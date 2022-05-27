-- 32
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Visite nurserie pour tortues', 'nurserie-tortue', 1, 1);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Epreuve éliminatoire', 'epreuve-eliminatoire', 2, 0);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Epreuve éliminatoire sur choix du vainqueur', 'epreuve-eliminatoire-sur-choix-vainqueur', 2, 0);

call create_game('le-totem-maudit','A bout de souffle','a-bout-de-souffle-2022','apnee','individuel','confort',24,32,'nurserie,nuit-hotel,amulette-d-immunite,epreuve-eliminatoire,epreuve-eliminatoire-sur-choix-vainqueur','statique,apnee');
-- degustation + boue

call create_game_participation('francois-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',3,'');
call create_game_participation('olga-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',8,'epreuve-eliminatoire');
call create_game_participation('ambre-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',2,'nurserie-tortue,nuit-hotel');
call create_game_participation('bastien-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',1,'nurserie-tortue,nuit-hotel,amulette-d-immunite');
call create_game_participation('fouzi-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',5,'epreuve-eliminatoire-sur-choix-vainqueur');
call create_game_participation('geraldine-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',3,'');
call create_game_participation('jean-charles-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',6,'epreuve-eliminatoire-sur-choix-vainqueur');
call create_game_participation('nicolas-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',7,'');

INSERT INTO `GS_GAME_STAKE_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Eliminatoire', 'eliminatoire', 'Elimination d''un ou plusieurs participants');
call create_game('le-totem-maudit','Empillement de boules','empilement-boules-2022','empilement-boules','individuel','eliminatoire',25,33,'elimination-du-dernier','rapidite,adresse,minutie');

call create_game_participation('olga-2022','blanc-2022','empilement-boules-2022','participant','individuel',1,'');
call create_game_participation('jean-charles-2022','blanc-2022','empilement-boules-2022','participant','individuel',2,'');
call create_game_participation('fouzi-2022','blanc-2022','empilement-boules-2022','participant','individuel',3,'elimination-du-dernier');

call create_participant_departure('le-totem-maudit','fouzi-2022','blanc-2022',33,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','fouzi-2022',9,1,33);

call program_current_time ('le-totem-maudit',33);
