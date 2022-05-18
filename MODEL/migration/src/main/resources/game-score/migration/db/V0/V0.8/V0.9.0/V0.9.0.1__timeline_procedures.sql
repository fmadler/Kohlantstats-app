-- store procedure
delimiter $$
drop procedure IF EXISTS create_timeline_for_session$$
create procedure create_timeline_for_session
(
    _program_web_path varchar(100)
)

begin
    DECLARE @participant_web_path varchar(100);
    DECLARE @participant_end_day int;
    DECLARE cursor_participant CURSOR FOR
        select pl.web_path, pa.END_DAY from gs_player pl, gs_participant pa, gs_program pg
        where pa.gs_program_id = pg.id and pa.gs_player_id = pl.id
          and pg.web_path = _program_web_path;

    set @program_id = null;
    select id into @program_id from gs_program where WEB_PATH = _program_web_path;
    IF(@program_id is null) THEN
        set @message = concat('Program not found for ',_program_web_path);
        SIGNAL SQLSTATE '50000'
            SET MESSAGE_TEXT = @message;
    END IF;
    -- for each participant
    OPEN cursor_participant;
    loopParticipant : LOOP
        -- for each participant day on camp
        set @nbOfDays = null;
        select pg.TOTAL_TIME_LENGTH from gs_program pg where web_path = _program_web_path into @nbOfDays;
        set @currentDay = 1;

        fetch cursor_participant into @participant_web_path, @participant_end_day;
        while (@currentDay<@nbOfDays AND @currentDay<@participant_end_day) do
            -- todo select snapshot for this day
            set @longevity = @currentDay;
            set @scoreFirstPlace = 1;
            set @scoreSecondPlace = 1;
            call add_score (_program_web_path,@participant_web_path, @currentDay, @longevity, @scoreFirstPlace, @scoreSecondPlace);
            SET @currentDay = @currentDay + 1;
        end while;


    end loop;
end$$
drop procedure IF EXISTS add_score$$
create procedure add_score
(
    _program_web_path varchar(100),
    _participant_web_path varchar(100),
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
                _longevity+_score_1+_score_2,
                concat('program/',_program_web_path),
                _participant_web_path,
                'player',
                _program_web_path,
                'program',
                _longevity,
                _score_1,
                _score_2
               );
end$$
delimiter ;
