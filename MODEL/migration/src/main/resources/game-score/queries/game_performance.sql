-- performance des candidats sur les épreuves
-- épreuve indi

-- tag_name, tag_wab
select count(tag_name) total_number, sum(effective_performance) effective_performance, tag_name, tag_web_path, participant_web_path
from (
select 
t.name tag_name,
t.web_path tag_web_path,
g.web_path game_web_path,
g.name game_name,
pxg.ranking,
case when pxg.ranking = 1 then 1 else 0 end as effective_performance,
gpt.WEB_PATH participation_type_web_path,
 pl.web_path participant_web_path
 from gs_game_tag t, 
	gs_game_x_tag gxt, 
    gs_game g, 
	gs_participant_x_game pxg, 
    gs_player pl, 
    gs_participant pa, 
    gs_game_participation_type gpt,
    gs_game_activity_type gat
 where 
 gxt.GS_GAME_ID = g.id and
 gxt.GS_GAME_TAG_ID = t.ID and
 pxg.GS_GAME_ID = g.ID and
 pxg.GS_PARTICIPANT_ID = pa.ID and
 pa.GS_PLAYER_ID = pl.ID and
 pxg.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID
 
 
 -- and pl.WEB_PATH = 'loic-2020'
 and gat.WEB_PATH = 'participant'
 -- and ranking = 1
 ) xxx
 
group by participant_web_path, tag_web_path
;



select 
t.name tag_name,
t.web_path tag_web_path,
g.web_path game_web_path,
g.name game_name,
pxg.ranking,
gpt.WEB_PATH participation_type_web_path,
 pl.web_path
 from gs_game_tag t, gs_game_x_tag gxt, gs_game g, gs_participant_x_game pxg, gs_player pl, gs_participant pa, gs_game_participation_type gpt
 where 
 gxt.GS_GAME_ID = g.id and
 gxt.GS_GAME_TAG_ID = t.ID and
 pxg.GS_GAME_ID = g.ID and
 pxg.GS_PARTICIPANT_ID = pa.ID and
 pa.GS_PLAYER_ID = pl.ID and
 pxg.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID
 
 and pl.WEB_PATH = 'loic-2020'
 -- and ranking = 1
 
-- group by pl.web_path, g.web_path
;