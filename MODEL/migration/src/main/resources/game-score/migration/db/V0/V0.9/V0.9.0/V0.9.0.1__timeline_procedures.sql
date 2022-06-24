-- store procedure
delimiter $$
drop procedure IF EXISTS create_timeline_for_program$$
create procedure create_timeline_for_program
(
    _program_web_path varchar(100),
    out result varchar(100)
)

begin
    DECLARE participant_web_path varchar(100);
    DECLARE participant_start_day int;
    DECLARE participant_end_day int;
    DECLARE program_currentDay int;
    DECLARE until_day int;
    DECLARE done INT DEFAULT 0;
    DECLARE cursor_participant CURSOR FOR
        select pl.web_path,
               coalesce(pa.START_DAY,1),
               pa.END_DAY,
               pg.current_day,
               least(COALESCE(pa.END_DAY,pg.current_day), pg.TOTAL_TIME_LENGTH) until_day
        from gs_player pl, gs_participant pa, gs_program pg
        where pa.gs_program_id = pg.id and pa.gs_player_id = pl.id
          and pg.web_path = _program_web_path;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    set @program_id = null;
    select id into @program_id from gs_program where WEB_PATH = _program_web_path;
    IF(@program_id is null) THEN
        set @message = concat('Program not found for ',_program_web_path);
        SIGNAL SQLSTATE '50000'
            SET MESSAGE_TEXT = @message;
    END IF;
    -- clean data
    delete from DW_TIMELINE_SCORE
    where CONTEXT_WEB_PATH = _program_web_path
      and CONTEXT_TYPE_WEB_PATH = 'programme';
    -- for each participant
    OPEN cursor_participant;
    loopParticipant : LOOP
        -- for each participant day on camp
        set @nbOfDays = null;
        select pg.TOTAL_TIME_LENGTH from gs_program pg where web_path = _program_web_path into @nbOfDays;

        fetch cursor_participant into participant_web_path, participant_start_day, participant_end_day, program_currentDay, until_day;
        set @currentDay = participant_start_day-1;
        IF done = 1 THEN
            LEAVE loopParticipant;
        END IF;
        -- while (@currentDay<@nbOfDays) do -- AND @currentDay<participant_end_day) do no pas de fin pour les concurrents encore en lice
        while (@currentDay<@nbOfDays AND @currentDay<until_day) do -- no pas de fin pour les concurrents encore en lice
            SET @currentDay = @currentDay + 1;
            call snapshot_score(_program_web_path, participant_web_path, @currentDay);
        end while;
    end loop;
    set result = 'PROCESSED';
end$$
drop procedure IF EXISTS snapshot_score$$
create procedure snapshot_score
    (_program_web_path varchar(100),
    _participant_web_path varchar(100),
    _currentDay int)
begin
    set @longevity = _currentDay;
    set @scoreFirstPlace = null;
    set @scoreSecondPlace = null;
    set @scoreFirstSecondPlace = null;
    set @score = null;
    set @participation_details = null;
    set @participant_name = null;

    select
        participant_name,
        COALESCE(sum(ranking_1_alone_score),0) as ranking_1_alone_score,
        COALESCE(sum(ranking_2_alone_score),0) as ranking_2_alone_score,
        COALESCE(sum(ranking_1_alone_score),0) + COALESCE(sum(ranking_2_alone_score),0) as ranking_1_and_2_alone_score,
        COALESCE(longevity + COALESCE(sum(ranking_1_alone_score),0) + COALESCE(sum(ranking_2_alone_score),0),0) as score,
        longevity,
        GROUP_CONCAT(distinct
                     CONCAT_WS(
                             '|',
                             game_name,
                             game_web_path,
                             program_index,
                             activity_type_name,
                             participation_type_name,
                             game_stake_type_name,
                             ranking
                         )
                     order by program_index
            ) participation_details
    from (
             select pl.name                                                                     participant_name,
                    pl.WEB_PATH                                                                 participant_web_path,
                    case
                        when pa.start_day is not null and pa.end_day is not null
                            then LEAST(pa.end_day - pa.start_day + 1, bbb.day)
                        else bbb.day end                                                  longevity,
                    pxg.RANKING                                                                 ranking,
                    case
                        when pxg.RANKING = 1 and gpt.WEB_PATH = 'individuel' then nb_register_participants
                        else 0 end                                                              ranking_1_alone_score,
                    case
                        when pxg.RANKING = 2 and gpt.WEB_PATH = 'individuel' then (nb_register_participants - 2) / 2
                        else 0 end                                                              ranking_2_alone_score,
                    gat.name                                                                    activity_type_name,
                    g.program_index                                                             program_index,
                    g.name                                                                      game_name,
                    g.web_path                                                                  game_web_path,
                    gst.name                                                                    game_stake_type_name,
                    gpt.name                                                                    participation_type_name,
                    p.name                                                                      program_name,
                    p.web_path                                                                  program_web_path
             from gs_game g,
                  gs_team t,
                  gs_participant_x_game pxg,
                  gs_game_type gt,
                  gs_game_stake_type gst,
                  gs_program p,
                  gs_participant pa,
                  gs_player pl,
                  GS_GAME_PARTICIPATION_TYPE gpt,
                  GS_GAME_ACTIVITY_TYPE gat
                     ,
                  (
                      select max(pxg.ranking) max_ranking, count(*) nb_register_participants, g.id
                      from gs_game g,
                           gs_participant_x_game pxg,
                           gs_game_activity_type gat
                      where pxg.GS_GAME_ID = g.ID
                        and pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID
                        and gat.WEB_PATH = 'participant'
                      group by g.id
                      order by g.id
                  ) aaa,
                  (
                      select _currentDay day
                      from dual
                  ) bbb
             where pxg.GS_GAME_ID = g.ID
               and pxg.gs_team_id = t.id
               and pxg.GS_PARTICIPANT_ID = pa.ID
               and pa.GS_PROGRAM_ID = p.ID
               and g.GS_GAME_TYPE_ID = gt.id
               and g.GS_GAME_STAKE_TYPE_ID = gst.ID
               and pa.GS_PLAYER_ID = pl.ID
               and pxg.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID
               and pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID
               and aaa.id = g.id
               and p.WEB_PATH = _program_web_path
               and pl.web_path = _participant_web_path
               and g.TIME_UNIT_INDEX <= bbb.day
         )xxx

    group by
        participant_name,
        participant_web_path,
        program_name,
        program_web_path
    into @participant_name, @scoreFirstPlace, @scoreSecondPlace, @scoreFirstSecondPlace, @score, @longevity, @participation_details
    ;

    call add_score (_program_web_path,_participant_web_path, @participant_name, @currentDay, @longevity, @scoreFirstPlace, @scoreSecondPlace);
 end$$
drop procedure IF EXISTS add_score$$
create procedure add_score
(
    _program_web_path varchar(100),
    _participant_web_path varchar(100),
    _participant_name varchar(100),
    _day int,
    _longevity DECIMAL(10,4),
    _score_1 DECIMAL(10,4),
    _score_2 DECIMAL(10,4)
)
begin
    insert into DW_TIMELINE_SCORE
        (
         `DAY`,
         SCORE,
         DISPLAY_NAME,
         FULL_WEB_PATH,
         ENTITY_WEB_PATH,
         ENTITY_TYPE_WEB_PATH,
         CONTEXT_WEB_PATH,
         CONTEXT_TYPE_WEB_PATH,
         LONGEVITY,
         GAME_SCORE_1,
         GAME_SCORE_2
        )
        values (
                _day,
                COALESCE(COALESCE(_longevity,0)+COALESCE(_score_1,0)+COALESCE(_score_2,0),0),
                _participant_name,
                concat('programme/',_program_web_path,'/player/',_participant_web_path),
                _participant_web_path,
                'player',
                _program_web_path,
                'programme',
                COALESCE(_longevity,0),
                COALESCE(_score_1,0),
                COALESCE(_score_2,0)
               );
end$$
delimiter ;
