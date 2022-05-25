-- 32
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Peche à la languouste', 'peche-languouste', 5, 1);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Nuit dans un hamac', 'nuit-hamac', 1, 1);

call create_game('le-totem-maudit','A bout de souffle','a-bout-de-souffle-2022','apnee','individuel','confort',32,24,'visite-tortue,nuit-hotel,amulette-immunite,epreuve-eliminatoire,epreuve-eliminatoire-par-choix-du-vainqueur','statique,apnee');
-- degustation + boue

call create_game_participation('francois-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',3,'');
call create_game_participation('olga-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',8,'epreuve-eliminatoire');
call create_game_participation('ambre-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',2,'visite-tortue,nuit-hotel');
call create_game_participation('bastien-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',1,'visite-tortue,nuit-hotel,amulette-immunite');
call create_game_participation('fouzi-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',5,'epreuve-eliminatoire-par-choix-du-vainqueur');
call create_game_participation('geraldine-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',3,'');
call create_game_participation('jean-charles-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',6,'epreuve-eliminatoire-par-choix-du-vainqueur');
call create_game_participation('nicolas-2022','blanc-2022','a-bout-de-souffle-2022','participant','individuel',7,'');

-- 30 ème jour
--
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Equilibre avec perche', 'empilement-boules', NULL);

-- parcours du combattant + puzzle pour les 2 premiers
call create_game('le-totem-maudit','Equilibre en duo avec perche','empilement-boules-2022','empilement-boules','individuel','eliminatoire',33,26,'elimination-du-dernier','rapidite,adresse,minutie');

call create_game_participation('fouzi-2022','blanc-2022','empilement-boules-2022','participant','individuel',3,'');
call create_game_participation('olga-2022','blanc-2022','empilement-boules-2022','participant','individuel',1,'');
call create_game_participation('jean-charles-2022','blanc-2022','empilement-boules-2022','participant','individuel',2,'elimination-du-dernier');


call first_vote_against ('le-totem-maudit','louana-2022','fouzi-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','maxime-2022','nicolas-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','fouzi-2022','nicolas-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','francois-2022','maxime-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','geraldine-2022','nicolas-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','jean-charles-2022','fouzi-2022','blanc-2022', 31, 'effectif');
call second_vote_against ('le-totem-maudit','jean-charles-2022','jean-charles-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','ambre-2022','maxime-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','bastien-2022','maxime-2022','blanc-2022', 31, 'effectif');

call first_vote_against ('le-totem-maudit','olga-2022','maxime-2022','blanc-2022', 31, 'effectif');
call second_vote_against ('le-totem-maudit','olga-2022','maxime-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','nicolas-2022','fouzi-2022','blanc-2022', 31, 'effectif');
call second_vote_against ('le-totem-maudit','nicolas-2022','nicolas-2022','blanc-2022', 31, 'effectif');


call create_participant_departure('le-totem-maudit','maxime-2022','blanc-2022',31,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','maxime-2022',10,1,31);

call create_participant_departure('le-totem-maudit','louana-2022','blanc-2022',31,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','louana-2022',9,1,31);

call program_current_time ('le-totem-maudit',31);


