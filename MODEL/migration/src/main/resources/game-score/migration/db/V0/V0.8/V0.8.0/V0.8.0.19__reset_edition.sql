-- store procedure
delimiter $$

drop procedure IF EXISTS reset_edition$$
create procedure reset_edition
(
	_program_web_path varchar(100)
)
begin

    -- delete
    delete from gs_game_x_reward
    where id in
          (
              select id
              from (
                       select gxr.id
                       from gs_game_x_reward gxr,
                            gs_game g,
                            gs_program p
                       where gxr.GS_GAME_ID = g.ID
                         and g.GS_PROGRAM_ID = p.id
                         and p.WEB_PATH = _program_web_path
                   ) as x
          );
    delete from gs_game_x_tag
    where id in
          (
              select id
              from (
                       select gxt.id
                       from gs_game_x_tag gxt,
                            gs_game g,
                            gs_program p
                       where gxt.GS_GAME_ID = g.ID
                         and g.GS_PROGRAM_ID = p.id
                         and p.WEB_PATH = _program_web_path
                   ) as x
          );
    delete from gs_participant_game_x_reward
    where id in
          (
              select id
              from (
                       select pgxr.id
                       from gs_participant_game_x_reward pgxr,
                            gs_participant_x_game pxg,
                            gs_game g,
                            gs_program p
                       where pgxr.GS_PARTICIPANT_X_GAME_ID = pxg.ID
                         and pxg.GS_GAME_ID = g.id
                         and g.GS_PROGRAM_ID = p.id
                         and p.WEB_PATH = _program_web_path
                   ) as x
          );
    delete from gs_team_x_game
    where id in
          (
              select id
              from (
                       select txg.id
                       from gs_team_x_game txg,
                            gs_game g,
                            gs_program p
                       where txg.GS_GAME_ID = g.ID
                         and g.GS_PROGRAM_ID = p.id
                         and p.WEB_PATH = _program_web_path
                   ) as x
          );
    delete from gs_participant_x_game
    where id in
          (
              select id
              from (
                       select pxg.id
                       from gs_participant_x_game pxg,
                            gs_game g,
                            gs_program p
                       where pxg.GS_GAME_ID = g.ID
                         and g.GS_PROGRAM_ID = p.id
                         and p.WEB_PATH = _program_web_path
                   ) as x
          );
    delete from gs_vote
    where id in
          (
              select id
              from (
                       select v.id
                       from gs_vote v,
                            gs_team t,
                            gs_program p
                       where v.GS_TEAM_ID = t.ID
                         and t.GS_PROGRAM_ID = p.id
                         and p.WEB_PATH = _program_web_path
                   ) as x
          );
    delete from gs_game
    where id in
          (
              select id
              from (
                       select g.id
                       from
                           gs_game g,
                           gs_program p
                       where
                               g.GS_PROGRAM_ID = p.id
                         and p.WEB_PATH = _program_web_path
                   ) as x
          );

    delete from gs_participant_team_x_realisation
    where id in
          (
              select id
              from (
                       select ptxr.id
                       from gs_participant_team_x_realisation ptxr,
                            gs_participant_team pt,
                            gs_team t,
                            gs_program p
                       where ptxr.GS_PARTICIPANT_TEAM_ID = pt.ID
                         and pt.GS_TEAM_ID = t.ID
                         and t.GS_PROGRAM_ID = p.id
                         and p.WEB_PATH = _program_web_path
                   ) as x
          );

    delete from gs_participant_team
    where id in
          (
              select id
              from (
                       select pt.id
                       from gs_participant_team pt,
                            gs_team t,
                            gs_program p
                       where pt.GS_TEAM_ID = t.ID
                         and t.GS_PROGRAM_ID = p.id
                         and p.WEB_PATH = _program_web_path
                   ) as x
          );

    delete from gs_team
    where id in
          (
              select id
              from (
                       select t.id
                       from
                           gs_team t,
                           gs_program p
                       where t.GS_PROGRAM_ID = p.id
                         and p.WEB_PATH = _program_web_path
                   ) as x
          );

    delete from gs_participant where
            id in (
            select id
            from (
                     select p.id
                     from gs_participant p,
                          gs_program pg
                     where p.GS_PROGRAM_ID = pg.id
                       and pg.WEB_PATH = _program_web_path
                 ) as x
        )
    ;

    delete from gs_program where WEB_PATH = _program_web_path;

end$$
delimiter ;
