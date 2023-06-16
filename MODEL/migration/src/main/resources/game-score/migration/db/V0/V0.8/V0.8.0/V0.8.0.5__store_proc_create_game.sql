-- store procedure
delimiter $$
drop procedure IF EXISTS add_game_rewards_stakes_for_id$$
create procedure add_game_rewards_stakes_for_id
(
    _game_id int,
    _reward_web_paths varchar(1000),
    _tag_web_paths varchar(1000)
)
begin
	DECLARE r INT Default 0 ;
    DECLARE t INT Default 0 ;
    DECLARE str     VARCHAR(255);
	IF(_reward_web_paths IS NOT NULL) THEN
        simple_loop: LOOP
		   set @gs_reward_id = null;
           SET r=r+1;
           SET str=SPLIT_STR(_reward_web_paths,",",r);
           IF str='' THEN
              LEAVE simple_loop;
           END IF;
           select id into @gs_reward_id from gs_reward where web_path = str;
           IF(@gs_reward_id is not null) THEN 
			   INSERT INTO GS_GAME_X_REWARD 
					(GS_GAME_ID, GS_REWARD_ID, DISPLAY_ORDER) 
				values 
					(_game_id, @gs_reward_id, r);
			END IF;
        END LOOP simple_loop;
    END IF;
    
	IF(_tag_web_paths IS NOT NULL) THEN
        simple_loop: LOOP
		   set @gs_tag_id = null;
           SET t=t+1;
           SET str=SPLIT_STR(_tag_web_paths,",",t);
           IF str='' THEN
              LEAVE simple_loop;
           END IF;
           select id into @gs_tag_id from gs_game_tag where web_path = str;
           IF(@gs_tag_id is not null) THEN 
			   INSERT INTO GS_GAME_X_TAG
					(GS_GAME_ID, GS_GAME_TAG_ID, DISPLAY_ORDER) 
				values 
					(_game_id, @gs_tag_id, t);
			END IF;
        END LOOP simple_loop;
    END IF;
      
end$$
drop procedure IF EXISTS add_game_rewards_stakes$$
create procedure add_game_rewards_stakes
(
    _game_web_path varchar(100),
    _reward_web_paths varchar(100),
    _tag_web_paths varchar(100)
)
begin
	set @game_id = null;
    set @reward_web_paths = null;
    set @tag_web_paths = null;
    
    select id into @game_id from gs_game where WEB_PATH = _game_web_path;
    IF(@game_id is null) THEN 
		SIGNAL SQLSTATE '50000'
			SET MESSAGE_TEXT = 'Game not found ';
	END IF;    
    -- insert rewards
    call add_game_rewards_stakes_for_id(@game_id, _reward_web_paths, _tag_web_paths);

end$$
drop procedure IF EXISTS create_game_type$$
create procedure create_game_type
    (
        _game_type_name varchar(100),
        _game_type_web_path varchar(100),
        _description varchar(100)
    )
begin
    set @id = null;
    select id into @id from GS_GAME_TYPE where WEB_PATH = _game_type_web_path or NAME=_game_type_name;
    IF(@id is null) THEN
        INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`)
        VALUES (_game_type_name, _game_type_web_path, _description);
    END IF;
end $$
drop procedure IF EXISTS create_game_stake_type$$
create procedure create_game_stake_type
    (
        _game_stake_type_name varchar(100),
        _game_stake_type_web_path varchar(100),
        _description varchar(100)
    )
begin
    set @id = null;
    select id into @id from GS_GAME_STAKE_TYPE where WEB_PATH = _game_stake_type_web_path or NAME=_game_stake_type_name;
    IF(@id is null) THEN
        INSERT INTO `GS_GAME_STAKE_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`)
        VALUES (_game_stake_type_name, _game_stake_type_web_path, _description);
    END IF;
end $$
drop procedure IF EXISTS create_vote_effectiveness_type$$
create procedure create_vote_effectiveness_type
    (
        _name varchar(100),
        _web_path varchar(100)
    )
begin
    set @id = null;
    select id into @id from gs_vote_effectiveness_type where WEB_PATH = _web_path or NAME=_name;
    IF(@id is null) THEN
        INSERT INTO `gs_vote_effectiveness_type` (`NAME`, `WEB_PATH`)
        VALUES (_name, _web_path);

    END IF;
end $$
drop procedure IF EXISTS create_departure_type$$
create procedure create_departure_type
    (
        _name varchar(100),
        _web_path varchar(100)
    )
begin
    set @id = null;
    select id into @id from GS_TEAM_DEPARTURE_TYPE where WEB_PATH = _web_path or NAME=_name;
    IF(@id is null) THEN
        INSERT INTO `GS_TEAM_DEPARTURE_TYPE` (`NAME`, `WEB_PATH`)
        VALUES (_name, _web_path);

    END IF;
end $$
drop procedure IF EXISTS create_reward_type$$
create procedure create_reward_type
(
    _name varchar(100),
    _web_path varchar(100)
)
begin
    set @id = null;
    select id into @id from GS_REWARD_TYPE where WEB_PATH = _web_path or NAME=_name;
    IF(@id is null) THEN
        INSERT INTO `GS_REWARD_TYPE` (`NAME`, `WEB_PATH`)
        VALUES (_name, _web_path);

    END IF;
end $$
drop procedure IF EXISTS create_reward$$
create procedure create_reward
(
    _reward_name varchar(100),
    _reward_web_path varchar(100),
    _reward_type_web_path varchar(100),
    _is_positive TINYINT(1)
)
begin
    set @id = null;
    set @reward_type_id = null;
    select id into @id from GS_REWARD where WEB_PATH = _reward_web_path or NAME=_reward_name;
    select id into @reward_type_id from GS_REWARD_TYPE where WEB_PATH = _reward_type_web_path;
    IF(@reward_type_id is null) THEN
        set @msg = concat('reward type does not exist ', _reward_type_web_path);
        SIGNAL SQLSTATE '50000'
            SET MESSAGE_TEXT = @msg;
    END IF;
    IF(@id is null) THEN
        INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`)
        VALUES (_reward_name, _reward_web_path, @reward_type_id, _is_positive);
    END IF;
end $$
drop procedure IF EXISTS create_game$$
create procedure create_game
(
    _program_web_path varchar(100),
	_game_name varchar(100),
    _game_web_path varchar(100),
    _game_type_web_path varchar(100),
    _game_participation_type_web_path varchar(100),
	_game_stake_web_path varchar(100),
    _program_index int,
    _time_unit_index int,
    _reward_web_paths varchar(1000),
    -- no need penalties are negative rewards_penalties_web_paths varchar(100)
    _tag_web_paths varchar(1000)
)
begin
    set @program_id = null;
	set @game_id = null;
    set @game_type_id = null;
    set @game_stake_id = null;
    set @reward_web_paths = null;
    set @tag_web_paths = null;
    
    select id into @program_id from gs_program where WEB_PATH = _program_web_path;
    IF(@program_id is null) THEN
        set @msg = concat('Program not found', _program_web_path);
        SIGNAL SQLSTATE '50000'
            SET MESSAGE_TEXT = @msg;
	END IF;
	select id into @game_participation_type_id from gs_game_participation_type where  WEB_PATH = _game_participation_type_web_path;
    IF(@game_participation_type_id is null) THEN
        set @msg = concat('Participation type not found', _game_participation_type_web_path);
		SIGNAL SQLSTATE '50000'
			SET MESSAGE_TEXT = @msg;
	END IF;
    select gt.id into @game_type_id from gs_game_type gt where  gt.WEB_PATH = _game_type_web_path;
    IF(@game_type_id is null) THEN 
        -- create game type
        INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`) VALUES (_game_type_web_path, _game_type_web_path);
        set @game_type_id = LAST_INSERT_ID();
	END IF;
	select gs.id into @game_stake_id from gs_game_stake_type gs where gs.WEB_PATH = _game_stake_web_path;
    IF(@game_stake_id is null) THEN
        set @msg = concat('Game stake not found', _game_stake_web_path);
		SIGNAL SQLSTATE '50000'
			SET MESSAGE_TEXT = @msg;
	END IF;
        
	INSERT INTO `GS_GAME` (`NAME`, `WEB_PATH`, `GS_GAME_PARTICIPATION_TYPE_ID`, `TIME_POSITION`, `TIME_UNIT_INDEX`, `PROGRAM_INDEX`, `GS_GAME_TYPE_ID`, `GS_GAME_STAKE_TYPE_ID`, `GS_PROGRAM_ID`)
    VALUES (_game_name, _game_web_path, @game_participation_type_id, _program_index, _time_unit_index, _program_index, @game_type_id, @game_stake_id, @program_id);

	set @game_id = LAST_INSERT_ID();

    call add_game_rewards_stakes_for_id(@game_id, _reward_web_paths, _tag_web_paths);

end$$
delimiter ;
