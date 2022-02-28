-- jour 2
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Totem maudit', 'totem-maudit', 2, 0);
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Elastique', 'elastique', NULL);

call create_game('le-totem-maudit','Elastique','elastique-2022','elastique','collectif','immunite',2,2,'totem,totem-maudit','adresse,rapidite,equilibre');
-- 9 témoins
--


call create_game_participation('alexandra-2022','bleu-2022','elastique-2022','participant','collectif',1,'totem');
call create_game_participation('maxime-2022','bleu-2022','elastique-2022','participant','collectif',1,'totem');
call create_game_participation('benjamin-2022','bleu-2022','elastique-2022','participant','collectif',1,'totem');
call create_game_participation('fouzi-2022','bleu-2022','elastique-2022','participant','collectif',1,'totem');
call create_game_participation('colin-2022','bleu-2022','elastique-2022','participant','collectif',1,'totem');
call create_game_participation('olga-2022','bleu-2022','elastique-2022','participant','collectif',1,'totem');
call create_game_participation('geraldine-2022','bleu-2022','elastique-2022','participant','collectif',1,'totem');
call create_game_participation('samira-2022','bleu-2022','elastique-2022','participant','collectif',1,'totem');

call create_game_participation('celine-2022','violet-2022','elastique-2022','participant','collectif',2,'conseil');
call create_game_participation('yannick-2022','violet-2022','elastique-2022','participant','collectif',2,'conseil');
call create_game_participation('bastien-2022','violet-2022','elastique-2022','participant','collectif',2,'conseil');
call create_game_participation('jean-charles-2022','violet-2022','elastique-2022','participant','collectif',2,'conseil');
call create_game_participation('anne-sophie-2022','violet-2022','elastique-2022','participant','collectif',2,'conseil');
call create_game_participation('setha-2022','violet-2022','elastique-2022','participant','collectif',2,'conseil');
call create_game_participation('stephanie-2022','violet-2022','elastique-2022','participant','collectif',2,'conseil');
call create_game_participation('matteo-2022','violet-2022','elastique-2022','participant','collectif',2,'conseil');

call create_game_participation('jean-philippe-2022','vert-2022','elastique-2022','participant','collectif',3,'totem-maudit,conseil-immediat');
call create_game_participation('francois-2022','vert-2022','elastique-2022','participant','collectif',3,'totem-maudit,conseil-immediat');
call create_game_participation('pauline-2022','vert-2022','elastique-2022','participant','collectif',3,'totem-maudit,conseil-immediat');
call create_game_participation('ambre-2022','vert-2022','elastique-2022','participant','collectif',3,'totem-maudit,conseil-immediat');
call create_game_participation('nicolas-2022','vert-2022','elastique-2022','participant','collectif',3,'totem-maudit,conseil-immediat');
call create_game_participation('franck-2022','vert-2022','elastique-2022','participant','collectif',3,'totem-maudit,conseil-immediat');
call create_game_participation('louana-2022','vert-2022','elastique-2022','participant','collectif',3,'totem-maudit,conseil-immediat');
call create_game_participation('lili-2022','vert-2022','elastique-2022','participant','collectif',3,'totem-maudit,conseil-immediat');


call first_vote_against ('le-totem-maudit','jean-philippe-2022','lili-2022','vert-2022', 2, 'effectif');
call first_vote_against ('le-totem-maudit','francois-2022','lili-2022','vert-2022', 2, 'effectif');
call first_vote_against ('le-totem-maudit','pauline-2022','lili-2022','vert-2022', 2, 'effectif');
call first_vote_against ('le-totem-maudit','ambre-2022','lili-2022','vert-2022', 2, 'effectif');
call first_vote_against ('le-totem-maudit','nicolas-2022','lili-2022','vert-2022', 2, 'effectif');
call first_vote_against ('le-totem-maudit','franck-2022','lili-2022','vert-2022', 2, 'effectif');
call first_vote_against ('le-totem-maudit','louana-2022','lili-2022','vert-2022', 2, 'effectif');
call first_vote_against ('le-totem-maudit','lili-2022','pauline-2022','vert-2022', 2, 'effectif');
call second_vote_against ('le-totem-maudit','lili-2022','lili-2022','vert-2022', 2, 'effectif');

call create_participant_departure('le-totem-maudit','lili-2022','vert-2022',2,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','lili-2022',24,1,2);

call first_vote_against ('le-totem-maudit','celine-2022','stephanie-2022','violet-2022', 3, 'effectif');
call first_vote_against ('le-totem-maudit','yannick-2022','celine-2022','violet-2022', 3, 'effectif');
call second_vote_against ('le-totem-maudit','yannick-2022','yannick-2022','violet-2022', 3, 'effectif');
call first_vote_against ('le-totem-maudit','bastien-2022','celine-2022','violet-2022', 3, 'effectif');
call first_vote_against ('le-totem-maudit','jean-charles-2022','celine-2022','violet-2022', 3, 'effectif');
call first_vote_against ('le-totem-maudit','anne-sophie-2022','setha-2022','violet-2022', 3, 'effectif');
call first_vote_against ('le-totem-maudit','stephanie-2022','setha-2022','violet-2022', 3, 'effectif');
call first_vote_against ('le-totem-maudit','setha-2022','stephanie-2022','violet-2022', 3, 'effectif');
call first_vote_against ('le-totem-maudit','matteo-2022','celine-2022','violet-2022', 3, 'effectif');

call create_participant_departure('le-totem-maudit','celine-2022','violet-2022',3,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','celine-2022',24,1,3);

/* vote
jean phi  ->lili
francois->lili
pauline->lili
ambre->lili
nicolas->lili
franck->lili
louana->lili
lili->pauline
lili->lili

lili depart 2ème jour
transmission du bracelete maudit à pauline

celine -> stephanie
yannick->celine
yannick->yannick
bastien->celine
jean charles->celine
anne sophie->setha
setha->stephanie
stephanie->setha
matteo->celine

celine départ 3ème jour

*/
call program_current_time ('le-totem-maudit',3);
-- call first_vote_against ('le-totem-maudit','bastien-2022','stephanie-2022','vert-2022', 6, 'effectif');

-- call create_participant_departure('le-totem-maudit','cindy-2019','arrivee-femme-2021',6,'exclusion-par-vote', @participant_team_id);
-- call create_participant_entrance ('le-totem-maudit','cindy-2019','ile-des-bannis-2021',6,'constitution-des-equipes', @participant_team_id);

