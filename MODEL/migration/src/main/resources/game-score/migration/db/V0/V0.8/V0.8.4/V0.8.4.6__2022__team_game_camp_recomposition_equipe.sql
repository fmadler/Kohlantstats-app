INSERT INTO `GS_EV_STORE` (`ID`, `ENTITY_TYPE`, `ENTITY_WEB_PATH`, `ENTITY_ID`, `PROPERTY_ID`, `VALUE`) VALUES (50, 'team', 'arrivee-2022', -1, 4, 'kls-team-white');
INSERT INTO `GS_EV_STORE` (`ID`, `ENTITY_TYPE`, `ENTITY_WEB_PATH`, `ENTITY_ID`, `PROPERTY_ID`, `VALUE`) VALUES (51, 'team', 'vert-2022', -1, 4, 'kls-team-rouge');
INSERT INTO `GS_EV_STORE` (`ID`, `ENTITY_TYPE`, `ENTITY_WEB_PATH`, `ENTITY_ID`, `PROPERTY_ID`, `VALUE`) VALUES (52, 'team', 'bleu-2022', -1, 4, 'kls-team-bleu');
INSERT INTO `GS_EV_STORE` (`ID`, `ENTITY_TYPE`, `ENTITY_WEB_PATH`, `ENTITY_ID`, `PROPERTY_ID`, `VALUE`) VALUES (53, 'team', 'violet-2022', -1, 4, 'kls-team-purple');
INSERT INTO `GS_EV_STORE` (`ID`, `ENTITY_TYPE`, `ENTITY_WEB_PATH`, `ENTITY_ID`, `PROPERTY_ID`, `VALUE`) VALUES (54, 'team', 'jaune-2022', -1, 4, 'kls-team-yellow');
INSERT INTO `GS_EV_STORE` (`ID`, `ENTITY_TYPE`, `ENTITY_WEB_PATH`, `ENTITY_ID`, `PROPERTY_ID`, `VALUE`) VALUES (55, 'team', 'rouge-2022', -1, 4, 'kls-team-rouge');
INSERT INTO `GS_EV_STORE` (`ID`, `ENTITY_TYPE`, `ENTITY_WEB_PATH`, `ENTITY_ID`, `PROPERTY_ID`, `VALUE`) VALUES (56, 'team', 'blanc-2022', -1, 4, 'kls-team-white');

/*

--



épreuve flambeaux collectif
8 §me jour


stéphanie exemption medical
géraldine exemption par choix d'équipe


victoire pour les jaunes


francois découvert collier d'umminité 9 ème j

vote 9ème hour'


pauline - pauline
pauline samira
ambre samira
francois samira
louana samira
fouzi pauline
samira pauline
maxime pauline
géraldine samira
jean-philippe samira
jean-charles samira

départ de samira

 */

 /*
  épreuve individuelle
-> bracelet-maudit puor le dernier
premier  et 2ème (aventage strategique)

defi inédi

Poutre equilbre baton
  */

INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Equilibre de batonnets', 'equilibre-batonnets', NULL);

call create_game('le-totem-maudit','Equilibre poutre et batonnets','equilibre-batonnets-2022','equilibre-batonnets','individuel','capitaine',6,7,'bracelet-maudit,chef-equipe,pierre-a-feu,nourriture-riz','adresse,patience,concentration,equilibre');

/*
 equilibre sur une poutre où chaque dessus de main supporte un batonnet sous forme de lance

 yannick dernier
benjamin
frencois
alexandre

maxime
samira 15
colin
fouzi
stepahine
ambre
pauline
setha 9

colin
nicolas
bsstine
olga
jean philippe
géraldine
anne sophie 2
louana 1
 */
call create_game_participation('yannick-2022','violet-2022','equilibre-batonnets-2022','participant','individuel',20,'bracelet-maudit');
call create_game_participation('benjamin-2022','bleu-2022','equilibre-batonnets-2022','participant','individuel',19,'');
call create_game_participation('francois-2022','vert-2022','equilibre-batonnets-2022','participant','individuel',18,'');
call create_game_participation('alexandra-2022','bleu-2022','equilibre-batonnets-2022','participant','individuel',17,'');
call create_game_participation('maxime-2022','bleu-2022','equilibre-batonnets-2022','participant','individuel',16,'');
call create_game_participation('samira-2022','bleu-2022','equilibre-batonnets-2022','participant','individuel',15,'');
call create_game_participation('jean-charles-2022','violet-2022','equilibre-batonnets-2022','participant','individuel',14,'');
call create_game_participation('fouzi-2022','bleu-2022','equilibre-batonnets-2022','participant','individuel',13,'');
call create_game_participation('stephanie-2022','violet-2022','equilibre-batonnets-2022','participant','individuel',12,'');
call create_game_participation('ambre-2022','violet-2022','equilibre-batonnets-2022','participant','individuel',11,'');
call create_game_participation('pauline-2022','vert-2022','equilibre-batonnets-2022','participant','individuel',10,'');
call create_game_participation('setha-2022','vert-2022','equilibre-batonnets-2022','participant','individuel',9,'');
call create_game_participation('colin-2022','bleu-2022','equilibre-batonnets-2022','participant','individuel',8,'');
call create_game_participation('nicolas-2022','vert-2022','equilibre-batonnets-2022','participant','individuel',7,'');
call create_game_participation('bastien-2022','violet-2022','equilibre-batonnets-2022','participant','individuel',6,'');
call create_game_participation('olga-2022','bleu-2022','equilibre-batonnets-2022','participant','individuel',5,'');
call create_game_participation('jean-philippe-2022','vert-2022','equilibre-batonnets-2022','participant','individuel',4,'');
call create_game_participation('geraldine-2022','bleu-2022','equilibre-batonnets-2022','participant','individuel',3,'');
call create_game_participation('anne-sophie-2022','violet-2022','equilibre-batonnets-2022','participant','individuel',2,'chef-equipe,nourriture-riz');
call create_game_participation('louana-2022','vert-2022','equilibre-batonnets-2022','participant','individuel',1,'chef-equipe,pierre-a-feu,nourriture-riz');

/*
 louana rouge kadlao (victoire riz 1.5kg) pierre à feu

maxime
samira
fouzi
géraldine
francois
jean philippe
pauline
jean-charles
ambre

anne sophie jaune (750 g de riz)

colin
olga
alexandra
benjamin
nicolas
setha
bastien
yannick
stephanie
 */
-- violet feu

call create_participant_departure ('le-totem-maudit','alexandra-2022','bleu-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','jean-philippe-2022','vert-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','ambre-2022','violet-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','stephanie-2022','violet-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','geraldine-2022','bleu-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','louana-2022','vert-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','anne-sophie-2022','violet-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','jean-charles-2022','violet-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','pauline-2022','vert-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','francois-2022','vert-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','samira-2022','bleu-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','maxime-2022','bleu-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','benjamin-2022','bleu-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','olga-2022','bleu-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','colin-2022','bleu-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','setha-2022','vert-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','fouzi-2022','bleu-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','nicolas-2022','vert-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','bastien-2022','violet-2022',7,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','yannick-2022','violet-2022',7,'recomposition-des-equipes', @participant_team_id);


/*
  louana rouge kadlao (victoire riz 1.5kg) pierre à feu

maxime
samira
fouzi
géraldine
francois
jean philippe
pauline
jean-charles
ambre
 */

call create_team('le-totem-maudit','Rouge','rouge-2022','Rouge',7,15);
call create_team('le-totem-maudit','Jaune','jaune-2022','Jaune',7,15);

call create_participant_entrance ('le-totem-maudit','louana-2022','rouge-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','maxime-2022','rouge-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','samira-2022','rouge-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','fouzi-2022','rouge-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','geraldine-2022','rouge-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','francois-2022','rouge-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','jean-philippe-2022','rouge-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','pauline-2022','rouge-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','jean-charles-2022','rouge-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','ambre-2022','rouge-2022',7,'constitution-des-equipes', @participant_team_id);

call create_participant_entrance ('le-totem-maudit','anne-sophie-2022','jaune-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','alexandra-2022','jaune-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','stephanie-2022','jaune-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','benjamin-2022','jaune-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','olga-2022','jaune-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','colin-2022','jaune-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','setha-2022','jaune-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','nicolas-2022','jaune-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','bastien-2022','jaune-2022',7,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','yannick-2022','jaune-2022',7,'constitution-des-equipes', @participant_team_id);


call create_game('le-totem-maudit','Flambeaux','flambeaux-2022','flambeaux','collectif','immunite',7,8,'totem','force,rapidite,precision');

call create_game_participation('louana-2022','rouge-2022','flambeaux-2022','participant','collectif',2,'conseil');
call create_game_participation('maxime-2022','rouge-2022','flambeaux-2022','participant','collectif',2,'conseil');
call create_game_participation('fouzi-2022','rouge-2022','flambeaux-2022','participant','collectif',2,'conseil');
call create_game_participation('francois-2022','rouge-2022','flambeaux-2022','participant','collectif',2,'conseil');
call create_game_participation('jean-philippe-2022','rouge-2022','flambeaux-2022','participant','collectif',2,'conseil');
call create_game_participation('samira-2022','rouge-2022','flambeaux-2022','participant','collectif',2,'conseil');
call create_game_participation('geraldine-2022','rouge-2022','flambeaux-2022','exempte-par-choix','collectif',2,'conseil');
call create_game_participation('pauline-2022','rouge-2022','flambeaux-2022','participant','collectif',2,'conseil');
call create_game_participation('jean-charles-2022','rouge-2022','flambeaux-2022','participant','collectif',2,'conseil');
call create_game_participation('ambre-2022','rouge-2022','flambeaux-2022','participant','collectif',2,'conseil');


call create_game_participation('anne-sophie-2022','jaune-2022','flambeaux-2022','participant','collectif',1,'totem');
call create_game_participation('yannick-2022','jaune-2022','flambeaux-2022','participant','collectif',1,'totem');
call create_game_participation('bastien-2022','jaune-2022','flambeaux-2022','participant','collectif',1,'totem');
call create_game_participation('stephanie-2022','jaune-2022','flambeaux-2022','exempte-sur-raison-medicale','collectif',1,'totem');
call create_game_participation('alexandra-2022','jaune-2022','flambeaux-2022','participant','collectif',1,'totem');
call create_game_participation('benjamin-2022','jaune-2022','flambeaux-2022','participant','collectif',1,'totem');
call create_game_participation('colin-2022','jaune-2022','flambeaux-2022','participant','collectif',1,'totem');
call create_game_participation('nicolas-2022','jaune-2022','flambeaux-2022','participant','collectif',1,'totem');
call create_game_participation('olga-2022','jaune-2022','flambeaux-2022','participant','collectif',1,'totem');
call create_game_participation('setha-2022','jaune-2022','flambeaux-2022','participant','collectif',1,'totem');


call first_vote_against ('le-totem-maudit','louana-2022','samira-2022','rouge-2022', 9, 'effectif');
call first_vote_against ('le-totem-maudit','pauline-2022','samira-2022','rouge-2022', 9, 'effectif');
call second_vote_against ('le-totem-maudit','pauline-2022','pauline-2022','rouge-2022', 9, 'effectif');
call first_vote_against ('le-totem-maudit','ambre-2022','samira-2022','rouge-2022', 9, 'effectif');
call first_vote_against ('le-totem-maudit','maxime-2022','pauline-2022','rouge-2022', 9, 'effectif');
call first_vote_against ('le-totem-maudit','jean-charles-2022','pauline-2022','rouge-2022', 9, 'effectif');
call first_vote_against ('le-totem-maudit','fouzi-2022','pauline-2022','rouge-2022', 9, 'effectif');
call first_vote_against ('le-totem-maudit','geraldine-2022','pauline-2022','rouge-2022', 9, 'effectif');
call first_vote_against ('le-totem-maudit','francois-2022','samira-2022','rouge-2022', 9, 'effectif');
call first_vote_against ('le-totem-maudit','jean-philippe-2022','samira-2022','rouge-2022', 9, 'effectif');
call first_vote_against ('le-totem-maudit','samira-2022','pauline-2022','rouge-2022', 9, 'effectif');

call create_participant_departure('le-totem-maudit','samira-2022','rouge-2022',9,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','samira-2022',20,1,9);

call program_current_time ('le-totem-maudit',9);
