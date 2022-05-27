
-- 12ème jour
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Désavantage sur la prochaine épreuve', 'desavantage-prochaine-epreuve', 4, 1);

call create_game('le-totem-maudit','Regate','regate-2022','regate','collectif','confort',10,13,'kit-de-peche,desavantage-prochaine-epreuve,poissons','navigation,force,rapidite');

/*
2 courses poursuites

victoire jaune

*/

call create_game_participation('louana-2022','rouge-2022','regate-2022','participant','collectif',2,'conseil');
call create_game_participation('maxime-2022','rouge-2022','regate-2022','participant','collectif',2,'conseil');
call create_game_participation('fouzi-2022','rouge-2022','regate-2022','exclusion-apres-tirage-au-sort','collectif',2,'conseil');
call create_game_participation('francois-2022','rouge-2022','regate-2022','participant','collectif',2,'conseil');
call create_game_participation('jean-philippe-2022','rouge-2022','regate-2022','participant','collectif',2,'conseil');
call create_game_participation('geraldine-2022','rouge-2022','regate-2022','participant','collectif',2,'conseil');
call create_game_participation('pauline-2022','rouge-2022','regate-2022','participant','collectif',2,'conseil');
call create_game_participation('jean-charles-2022','rouge-2022','regate-2022','participant','collectif',2,'conseil');
call create_game_participation('ambre-2022','rouge-2022','regate-2022','participant','collectif',2,'conseil');

call create_game_participation('anne-sophie-2022','jaune-2022','regate-2022','participant','collectif',1,'totem');
call create_game_participation('yannick-2022','jaune-2022','regate-2022','participant','collectif',1,'totem');
call create_game_participation('bastien-2022','jaune-2022','regate-2022','participant','collectif',1,'totem');
call create_game_participation('stephanie-2022','jaune-2022','regate-2022','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('alexandra-2022','jaune-2022','regate-2022','participant','collectif',1,'totem');
call create_game_participation('colin-2022','jaune-2022','regate-2022','participant','collectif',1,'totem');
call create_game_participation('nicolas-2022','jaune-2022','regate-2022','participant','collectif',1,'totem');
call create_game_participation('olga-2022','jaune-2022','regate-2022','participant','collectif',1,'totem');
call create_game_participation('setha-2022','jaune-2022','regate-2022','participant','collectif',1,'totem');


call team_game_ranking ('jaune-2022','regate-2022',2);
call team_game_ranking ('rouge-2022','regate-2022',1);

-- 15
-- constitution d'une fresque 
-- 3 nageurs
-- 3 tireurs
-- 3 poseur de tissu
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Fresque', 'fresque', NULL);

call create_game('le-totem-maudit','Fresque','fresque-2022','fresque','collectif','immunite',11,15,'conseil','rapidite,precision,voix,clarte');

call create_game_participation('louana-2022','rouge-2022','fresque-2022','participant','collectif',1,'conseil');
call create_game_participation('maxime-2022','rouge-2022','fresque-2022','participant','collectif',1,'conseil');
call create_game_participation('fouzi-2022','rouge-2022','fresque-2022','participant','collectif',1,'conseil');
call create_game_participation('francois-2022','rouge-2022','fresque-2022','participant','collectif',1,'conseil');
call create_game_participation('jean-philippe-2022','rouge-2022','fresque-2022','exempte-sur-raison-medicale','collectif',1,'conseil');
call create_game_participation('geraldine-2022','rouge-2022','fresque-2022','participant','collectif',1,'conseil');
call create_game_participation('pauline-2022','rouge-2022','fresque-2022','participant','collectif',1,'conseil');
call create_game_participation('jean-charles-2022','rouge-2022','fresque-2022','participant','collectif',1,'conseil');
call create_game_participation('ambre-2022','rouge-2022','fresque-2022','participant','collectif',1,'conseil');

call create_game_participation('anne-sophie-2022','jaune-2022','fresque-2022','participant','collectif',2,'totem');
call create_game_participation('yannick-2022','jaune-2022','fresque-2022','participant','collectif',2,'totem');
call create_game_participation('bastien-2022','jaune-2022','fresque-2022','participant','collectif',2,'totem');
call create_game_participation('stephanie-2022','jaune-2022','fresque-2022','exclusion-apres-tirage-au-sort','collectif',2,'totem');
call create_game_participation('alexandra-2022','jaune-2022','fresque-2022','participant','collectif',2,'totem');
call create_game_participation('colin-2022','jaune-2022','fresque-2022','participant','collectif',2,'totem');
call create_game_participation('nicolas-2022','jaune-2022','fresque-2022','participant','collectif',2,'totem');
call create_game_participation('olga-2022','jaune-2022','fresque-2022','participant','collectif',2,'totem');
call create_game_participation('setha-2022','jaune-2022','fresque-2022','participant','collectif',2,'totem');

call team_game_ranking ('jaune-2022','fresque-2022',2);
call team_game_ranking ('rouge-2022','fresque-2022',1);

call first_vote_against ('le-totem-maudit','bastien-2022','stephanie-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','yannick-2022','olga-2022','jaune-2022', 15, 'effectif');
call second_vote_against ('le-totem-maudit','yannick-2022','yannick-2022','jaune-2022', 15, 'effectif');
call vote ('le-totem-maudit','yannick-2022','yannick-2022','rouge-2022', 3, 15, 1, 'effectif', 'vote-contre');
call first_vote_against ('le-totem-maudit','alexandra-2022','setha-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','colin-2022','stephanie-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','olga-2022','stephanie-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','setha-2022','stephanie-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','stephanie-2022','alexandra-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','anne-sophie-2022','stephanie-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','nicolas-2022','stephanie-2022','jaune-2022', 15, 'effectif');

call create_participant_departure('le-totem-maudit','stephanie-2022','jaune-2022',11,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','stephanie-2022',17,1,15);

call program_current_time ('le-totem-maudit',15);
