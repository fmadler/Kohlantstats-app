delimiter $$
drop procedure IF EXISTS create_timeline_abstract$$
create procedure create_timeline_abstract
(
    out result varchar(100)
)
begin
    DECLARE full_web_path varchar(255);
    DECLARE context_web_path varchar(255);
    DECLARE entity_web_path varchar(255);
    DECLARE max_score DECIMAL(10,4);
    DECLARE ranking int;
    DECLARE nb_participants_behind_score INT;
    DECLARE nb_participants INT;
    DECLARE done INT DEFAULT 0;

    DECLARE cursor_timeline_abstract CURSOR FOR
        select full_web_path,
               context_web_path,
               entity_web_path,
               max_score,
               ranking,
               nb_participants_behind_score,
               nb_participants
        from
            v_timeline_abstract
    ;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    -- clean data
    delete from DW_TIMELINE_SCORE_ABSTRACT where 1 = 1;
    -- for each participant
    OPEN cursor_timeline_abstract;
    loopParticipant : LOOP
        fetch cursor_timeline_abstract into
            full_web_path,
            context_web_path,
            entity_web_path,
            max_score,
            ranking,
            nb_participants_behind_score,
            nb_participants;
        set result = concat("result",'xxx');
        IF done = 1 THEN
            set result = concat(result,'- leave -');
            LEAVE loopParticipant;
        END IF;
        set result = concat(result,'- insert -');
        insert into DW_TIMELINE_SCORE_ABSTRACT
        (
            FULL_WEB_PATH,
            ENTITY_WEB_PATH,
            CONTEXT_WEB_PATH,
            MAX_SCORE,
            RANKING,
            NB_PARTICIPANTS_BEHIND_SCORE,
            NB_PARTICIPANTS
        ) values
        (
            full_web_path,
            entity_web_path,
            context_web_path,
            max_score,
            ranking,
            nb_participants_behind_score,
            nb_participants
        );
    end loop;
    set result = concat(result,'PROCESSED');
end$$

delimiter ;
