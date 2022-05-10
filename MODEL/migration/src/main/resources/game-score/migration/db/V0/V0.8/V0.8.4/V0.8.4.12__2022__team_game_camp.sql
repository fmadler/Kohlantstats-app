-- gouttiere
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Bien-être', 'bien-etre', 1, 1);
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Gouttière', 'gouttiere', NULL);

call create_game('le-totem-maudit','Gouttière','gouttiere-2022','gouttiere','individuel','confort',24,19,'toilette-massage,bien-etre,vote-contre-soi','statique,respiration,natation');
-- le dernier gagne

call create_game_participation('louana-2022','blanc-2022','gouttiere-2022','participant','individuel',4,'');
call create_game_participation('maxime-2022','blanc-2022','gouttiere-2022','participant','individuel',3,'');
call create_game_participation('fouzi-2022','blanc-2022','gouttiere-2022','participant','individuel',12,'vote-contre-soi');
call create_game_participation('francois-2022','blanc-2022','gouttiere-2022','participant','individuel',1,'toilette-massage,bien-etre');
call create_game_participation('geraldine-2022','blanc-2022','gouttiere-2022','participant','individuel',7,'');
call create_game_participation('pauline-2022','blanc-2022','gouttiere-2022','participant','individuel',6,'');
call create_game_participation('jean-charles-2022','blanc-2022','gouttiere-2022','participant','individuel',10,'');
call create_game_participation('ambre-2022','blanc-2022','gouttiere-2022','participant','individuel',5,'toilette-massage,bien-etre');

call create_game_participation('anne-sophie-2022','blanc-2022','gouttiere-2022','participant','individuel',11,'');
call create_game_participation('yannick-2022','blanc-2022','gouttiere-2022','participant','individuel',13,'vote-contre-soi');
call create_game_participation('bastien-2022','blanc-2022','gouttiere-2022','participant','individuel',2,'');
call create_game_participation('nicolas-2022','blanc-2022','gouttiere-2022','participant','individuel',9,'');
call create_game_participation('olga-2022','blanc-2022','gouttiere-2022','participant','individuel',8,'');



call create_game('le-totem-maudit','Grapin','grapin-2022','grapin','individuel','immunite',25,20,'totem,elimination-du-dernier','rapidite,precision');

call create_game_participation('louana-2022','blanc-2022','grapin-2022','participant','individuel',4,'');
call create_game_participation('maxime-2022','blanc-2022','grapin-2022','participant','individuel',10,'');
call create_game_participation('fouzi-2022','blanc-2022','grapin-2022','participant','individuel',2,'');
call create_game_participation('francois-2022','blanc-2022','grapin-2022','participant','individuel',1,'totem');
call create_game_participation('geraldine-2022','blanc-2022','grapin-2022','participant','individuel',8,'');
call create_game_participation('pauline-2022','blanc-2022','grapin-2022','participant','individuel',13,'elimination-du-dernier');
call create_game_participation('jean-charles-2022','blanc-2022','grapin-2022','participant','individuel',9,'');
call create_game_participation('ambre-2022','blanc-2022','grapin-2022','participant','individuel',5,'');
call create_game_participation('anne-sophie-2022','blanc-2022','grapin-2022','participant','individuel',12,'');
call create_game_participation('yannick-2022','blanc-2022','grapin-2022','participant','individuel',7,'');
call create_game_participation('bastien-2022','blanc-2022','grapin-2022','participant','individuel',3,'');
call create_game_participation('nicolas-2022','blanc-2022','grapin-2022','participant','individuel',11,'');
call create_game_participation('olga-2022','blanc-2022','grapin-2022','participant','individuel',6,'');

call create_participant_departure('le-totem-maudit','pauline-2022','blanc-2022',25,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','pauline-2022',13,1,25);


call first_vote_against ('le-totem-maudit','louana-2022','yannick-2022','blanc-2022', 25, 'effectif');
call first_vote_against ('le-totem-maudit','maxime-2022','yannick-2022','blanc-2022', 25, 'effectif');
call first_vote_against ('le-totem-maudit','fouzi-2022','yannick-2022','blanc-2022', 25, 'effectif');
call second_vote_against ('le-totem-maudit','fouzi-2022','fouzi-2022','blanc-2022', 25, 'effectif');
call first_vote_against ('le-totem-maudit','francois-2022','yannick-2022','blanc-2022', 25, 'effectif');
call first_vote_against ('le-totem-maudit','geraldine-2022','yannick-2022','blanc-2022', 25, 'effectif');
call first_vote_against ('le-totem-maudit','jean-charles-2022','yannick-2022','blanc-2022', 25, 'effectif');
call first_vote_against ('le-totem-maudit','ambre-2022','yannick-2022','blanc-2022', 25, 'effectif');
call first_vote_against ('le-totem-maudit','bastien-2022','louana-2022','blanc-2022', 25, 'effectif');

call first_vote_against ('le-totem-maudit','yannick-2022','louana-2022','blanc-2022', 25, 'effectif');
call second_vote_against ('le-totem-maudit','yannick-2022','yannick-2022','blanc-2022', 25, 'effectif');
call first_vote_against ('le-totem-maudit','olga-2022','louana-2022','blanc-2022', 25, 'effectif');
call second_vote_against ('le-totem-maudit','olga-2022','louana-2022','blanc-2022', 25, 'effectif');
call first_vote_against ('le-totem-maudit','anne-sophie-2022','louana-2022','blanc-2022', 25, 'effectif');
call first_vote_against ('le-totem-maudit','nicolas-2022','louana-2022','blanc-2022', 25, 'effectif');

call create_participant_departure('le-totem-maudit','yannick-2022','blanc-2022',25,'exclusion-par-duel-apres-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','yannick-2022',12,1,25);

call program_current_time ('le-totem-maudit',25);
