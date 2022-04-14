
-- 16ème jour

-- TODO jean philippe : sort par décision médicale
-- TODO stéphanie revient chez les rouges

INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Poulet adobo', 'poulet-adobo', 5, 1);

call create_game('le-totem-maudit','Poutre','poutre-2022','poutre','collectif','confort',16,12,'poulet-adobo,nuit-ilot-exil','equilibre,rapidite');

call create_game_participation('louana-2022','rouge-2022','poutre-2022','participant','collectif',2,'nuit-ilot-exil');
call create_game_participation('maxime-2022','rouge-2022','poutre-2022','participant','collectif',2,'nuit-ilot-exil');
call create_game_participation('fouzi-2022','rouge-2022','poutre-2022','exclusion-apres-tirage-au-sort','collectif',2,'nuit-ilot-exil');
call create_game_participation('francois-2022','rouge-2022','poutre-2022','participant','collectif',2,'nuit-ilot-exil');
call create_game_participation('stephanie-2022','rouge-2022','poutre-2022','participant','collectif',2,'nuit-ilot-exil');
call create_game_participation('geraldine-2022','rouge-2022','poutre-2022','participant','collectif',2,'nuit-ilot-exil');
call create_game_participation('pauline-2022','rouge-2022','poutre-2022','participant','collectif',2,'nuit-ilot-exil');
call create_game_participation('jean-charles-2022','rouge-2022','poutre-2022','participant','collectif',2,'nuit-ilot-exil');
call create_game_participation('ambre-2022','rouge-2022','poutre-2022','participant','collectif',2,'nuit-ilot-exil');


call create_game_participation('anne-sophie-2022','jaune-2022','poutre-2022','participant','collectif',1,'poulet-adobo');
call create_game_participation('yannick-2022','jaune-2022','poutre-2022','participant','collectif',1,'poulet-adobo');
call create_game_participation('bastien-2022','jaune-2022','poutre-2022','participant','collectif',1,'poulet-adobo');
call create_game_participation('alexandra-2022','jaune-2022','poutre-2022','participant','collectif',1,'poulet-adobo');
call create_game_participation('colin-2022','jaune-2022','poutre-2022','participant','collectif',1,'poulet-adobo');
call create_game_participation('nicolas-2022','jaune-2022','poutre-2022','participant','collectif',1,'poulet-adobo');
call create_game_participation('olga-2022','jaune-2022','poutre-2022','participant','collectif',1,'poulet-adobo');
call create_game_participation('setha-2022','jaune-2022','poutre-2022','participant','collectif',1,'poulet-adobo');


call team_game_ranking ('jaune-2022','poutre-2022',1);
call team_game_ranking ('rouge-2022','poutre-2022',2);

-- par serie de 4 

call create_game('le-totem-maudit','puzzle-contre-la-montre','puzzle-contre-la-montre-2022','puzzle-contre-la-montre','collectif','immunite',15,10,'conseil','rapidite,precision,voix,clarte');
-- exclues stephanie par tirage au sort
call create_game_participation('louana-2022','rouge-2022','puzzle-contre-la-montre-2022','participant','collectif',2,'conseil');
call create_game_participation('maxime-2022','rouge-2022','puzzle-contre-la-montre-2022','participant','collectif',2,'conseil');
call create_game_participation('fouzi-2022','rouge-2022','puzzle-contre-la-montre-2022','participant','collectif',2,'conseil');
call create_game_participation('francois-2022','rouge-2022','puzzle-contre-la-montre-2022','participant','collectif',2,'conseil');
call create_game_participation('stephanie-2022','rouge-2022','puzzle-contre-la-montre-2022','exclusion-apres-tirage-au-sort','collectif',2,'conseil');
call create_game_participation('geraldine-2022','rouge-2022','puzzle-contre-la-montre-2022','participant','collectif',2,'conseil');
call create_game_participation('pauline-2022','rouge-2022','puzzle-contre-la-montre-2022','participant','collectif',2,'conseil');
call create_game_participation('jean-charles-2022','rouge-2022','puzzle-contre-la-montre-2022','participant','collectif',2,'conseil');
call create_game_participation('ambre-2022','rouge-2022','puzzle-contre-la-montre-2022','participant','collectif',2,'conseil');

call create_game_participation('anne-sophie-2022','jaune-2022','puzzle-contre-la-montre-2022','participant','collectif',1,'totem');
call create_game_participation('yannick-2022','jaune-2022','puzzle-contre-la-montre-2022','participant','collectif',1,'totem');
call create_game_participation('bastien-2022','jaune-2022','puzzle-contre-la-montre-2022','participant','collectif',1,'totem');
call create_game_participation('alexandra-2022','jaune-2022','puzzle-contre-la-montre-2022','participant','collectif',1,'totem');
call create_game_participation('colin-2022','jaune-2022','puzzle-contre-la-montre-2022','participant','collectif',1,'totem');
call create_game_participation('nicolas-2022','jaune-2022','puzzle-contre-la-montre-2022','participant','collectif',1,'totem');
call create_game_participation('olga-2022','jaune-2022','puzzle-contre-la-montre-2022','participant','collectif',1,'totem');
call create_game_participation('setha-2022','jaune-2022','puzzle-contre-la-montre-2022','participant','collectif',1,'totem');

call team_game_ranking ('jaune-2022','puzzle-contre-la-montre-2022',1);
call team_game_ranking ('rouge-2022','puzzle-contre-la-montre-2022',2);

-- TODO check votes
call first_vote_against ('le-totem-maudit','maxime-2022','stephanie-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','pauline-2022','stephanie-2022','jaune-2022', 15, 'effectif');
call second_vote_against ('le-totem-maudit','pauline-2022','pauline-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','stephanie-2022','maxime-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','louana-2022','stephanie-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','francois-2022','stephanie-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','fouzi-2022','stephanie-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','jean-charles-2022','stephanie-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','ambre-2022','stephanie-2022','jaune-2022', 15, 'effectif');
call first_vote_against ('le-totem-maudit','geraldine-2022','stephanie-2022','jaune-2022', 15, 'effectif');

call create_participant_departure('le-totem-maudit','stephanie-2022','jaune-2022',11,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','stephanie-2022',17,1,15);

call program_current_time ('le-totem-maudit',15);
