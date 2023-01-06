INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Place sur les poteaux', 'poteaux', 9, 1);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Poteau maudit', 'poteau-maudit', 2, 0);

call create_game('le-totem-maudit','Orientation','orientation-2022','orientation','individuel','finale',29,38,'poteaux,elimination-du-dernier,poteau-maudit','rapidite,tenacite,perseverance');

call create_game_participation('francois-2022','blanc-2022','orientation-2022','participant','individuel',3,'poteaux');
call create_game_participation('ambre-2022','blanc-2022','orientation-2022','participant','individuel',5,'elimination-du-dernier');
call create_game_participation('bastien-2022','blanc-2022','orientation-2022','participant','individuel',4,'poteaux,poteau-maudit');
call create_game_participation('geraldine-2022','blanc-2022','orientation-2022','participant','individuel',2,'poteaux');
call create_game_participation('jean-charles-2022','blanc-2022','orientation-2022','participant','individuel',1,'poteaux');

call create_participant_departure('le-totem-maudit','ambre-2022','blanc-2022',38,'defaite-orientation', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','ambre-2022',6,1,38);


call create_game('le-totem-maudit','Les poteaux','poteaux-2022','poteaux','individuel','finale',30,39,'groupe-final','equilibre,statique,patience');

call create_game_participation('francois-2022','blanc-2022','poteaux-2022','participant','individuel',4,'');
call create_game_participation('bastien-2022','blanc-2022','poteaux-2022','participant','individuel',3,'');
call create_game_participation('geraldine-2022','blanc-2022','poteaux-2022','participant','individuel',1,'');
call create_game_participation('jean-charles-2022','blanc-2022','poteaux-2022','participant','individuel',2,'');

call fill_participant_longevity ('le-totem-maudit','jean-charles-2022',4,1,39);

/**/
call first_vote_for ('le-totem-maudit','fouzi-2022','francois-2022','blanc-2022', 39, 'effectif');
call first_vote_for ('le-totem-maudit','ambre-2022','francois-2022','blanc-2022', 39, 'effectif');
call first_vote_for ('le-totem-maudit','olga-2022','geraldine-2022','blanc-2022', 39, 'effectif');
call first_vote_for ('le-totem-maudit','nicolas-2022','francois-2022','blanc-2022', 39, 'effectif');
call first_vote_for ('le-totem-maudit','maxime-2022','geraldine-2022','blanc-2022', 39, 'effectif');
call first_vote_for ('le-totem-maudit','jean-charles-2022','bastien-2022','blanc-2022', 39, 'effectif');
call first_vote_for ('le-totem-maudit','louana-2022','geraldine-2022','blanc-2022', 39, 'effectif');
call first_vote_for ('le-totem-maudit','anne-sophie-2022','bastien-2022','blanc-2022', 39, 'effectif');
call first_vote_for ('le-totem-maudit','yannick-2022','bastien-2022','blanc-2022', 39, 'effectif');
call first_vote_for ('le-totem-maudit','pauline-2022','francois-2022','blanc-2022', 39, 'effectif');
call first_vote_for ('le-totem-maudit','colin-2022','bastien-2022','blanc-2022', 39, 'effectif');


-- 2 vainqueurs bastien / francois
call create_participant_departure('le-totem-maudit','geraldine-2022','blanc-2022',39,'deliberation-jury-final', @participant_team_id);
call create_participant_departure('le-totem-maudit','bastien-2022','blanc-2022',39,'deliberation-jury-final', @participant_team_id);
call create_participant_departure('le-totem-maudit','francois-2022','blanc-2022',39,'deliberation-jury-final', @participant_team_id);

call program_current_time ('le-totem-maudit',39);

call team_game_ranking ('blanc-2022','orientation-2022',1);

call team_game_ranking ('blanc-2022','poteaux-2022',1);

call fill_participant_longevity ('le-totem-maudit','geraldine-2022',3,1,39);
call fill_participant_longevity ('le-totem-maudit','bastien-2022',1,1,39);
call fill_participant_longevity ('le-totem-maudit','francois-2022',1,1,39);
