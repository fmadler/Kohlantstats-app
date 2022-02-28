create or replace view v_game_stats
as
select 	
	pl.name participant_name,
	pl.WEB_PATH participant_web_path,
	case when pa.start_day is not null and pa.end_day is not null then pa.end_day - pa.start_day + 1 else p.current_day end longevity,
	pxg.RANKING ranking,
    g.time_position time_position,
	case when pxg.RANKING = 1 then 1 else 0 end ranking_1,
	case when pxg.RANKING = 2 then 1 else 0 end ranking_2,
	case when pxg.RANKING = 3 then 1 else 0 end ranking_3,
	case when pxg.RANKING > 3 or pxg.RANKING = 0 then 1 else 0 end ranking_other,
	case when pxg.RANKING = 1 and gpt.WEB_PATH = 'individuel' then 1 else 0 end ranking_1_alone,
	case when pxg.RANKING = 1 and gpt.WEB_PATH = 'individuel' then nb_register_participants else 0 end ranking_1_alone_nb_concurrents,
	case when pxg.RANKING = 2 and gpt.WEB_PATH = 'individuel' then 1 else 0 end ranking_2_alone,
	case when pxg.RANKING = 2 and gpt.WEB_PATH = 'individuel' then (nb_register_participants-2)/2 else 0 end ranking_2_alone_nb_concurrents,
	case when pxg.RANKING = 3 and gpt.WEB_PATH = 'individuel' then 1 else 0 end ranking_3_alone,
    case when (pxg.RANKING > 3 or pxg.RANKING = 0) and gpt.WEB_PATH = 'individuel' then 1 else 0 end ranking_other_alone,
    case when gst.WEB_PATH = 'immunite' and pxg.ranking = 1 then 1 else 0 end totem,
    case when gst.web_path= 'immunite' and gpt.WEB_PATH = 'individuel' and pxg.ranking = 1 then 1 else 0 end totem_individual,
	case when gst.WEB_PATH = 'confort' and pxg.ranking = 1 then 1 else 0 end confort,
    case when gst.web_path = 'confort' and gpt.WEB_PATH = 'individuel' and pxg.ranking = 1 then 1 else 0 end confort_individual,
    case when gpt.WEB_PATH = 'individuel' then 1 else 0 end individual_game,
    case when gpt.WEB_PATH = 'individuel' and max_ranking=pxg.ranking and nb_register_participants=pxg.ranking then 1 else 0 end individual_game_last,
    case when gat.web_path = 'participant' then 1 else 0 end active_participation,
    t.name team_name, 
    t.web_path team_web_path,
    gat.name activity_type_name, 
    gat.web_path activity_type_web_path,
	g.program_index program_index,
	g.name game_name,
	g.web_path game_web_path,
	gt.name game_type_name,
	gt.web_path game_type_web_path,
	gst.name game_stake_type_name,
	gst.web_path game_stake_type_web_path,
	gpt.name participation_type_name,
	gpt.web_path participation_type_web_path,
	p.name program_name,
	p.web_path program_web_path
from gs_game g, gs_team t, gs_participant_x_game pxg, gs_game_type gt, gs_game_stake_type gst, gs_program p, gs_participant pa, gs_player pl, GS_GAME_PARTICIPATION_TYPE gpt, GS_GAME_ACTIVITY_TYPE gat
		, (    
		select max(pxg.ranking) max_ranking, count(*) nb_register_participants, g.id
			from gs_game g, gs_participant_x_game pxg, gs_game_activity_type gat
			where
		pxg.GS_GAME_ID = g.ID and pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID and gat.WEB_PATH = 'participant'
		group by g.id
		order by g.id
    ) aaa
where
	pxg.GS_GAME_ID = g.ID and
	pxg.gs_team_id = t.id and
	pxg.GS_PARTICIPANT_ID = pa.ID and
	pa.GS_PROGRAM_ID = p.ID and
	g.GS_GAME_TYPE_ID = gt.id and 
	g.GS_GAME_STAKE_TYPE_ID = gst.ID and
	pa.GS_PLAYER_ID = pl.ID and
    pxg.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID and
    pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID and
    aaa.id = g.id
;