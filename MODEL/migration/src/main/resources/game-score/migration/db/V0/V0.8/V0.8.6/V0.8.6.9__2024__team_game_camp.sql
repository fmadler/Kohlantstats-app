
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Côte à l''os et frites', 'cote-a-l-os-frites', 5, 1);

call create_game('les-chasseurs-d-immunite','Puzzle contre la montre','puzzle-contre-la-montre-2024','puzzle-contre-la-montre','collectif','confort',15,21,'cote-a-l-os-frites','statique,patience');

call create_game_participation('ricky-2024','rouge-2024','puzzle-contre-la-montre-2024','participant','collectif',2,'cote-a-l-os-frites');
call create_game_participation('jean-2024','rouge-2024','puzzle-contre-la-montre-2024','participant','collectif',2,'cote-a-l-os-frites');
call create_game_participation('megane-2024','rouge-2024','puzzle-contre-la-montre-2024','participant','collectif',2,'cote-a-l-os-frites');
call create_game_participation('meissa-2024','rouge-2024','puzzle-contre-la-montre-2024','participant','collectif',2,'cote-a-l-os-frites');
call create_game_participation('david-2024','rouge-2024','puzzle-contre-la-montre-2024','exclusion-apres-tirage-au-sort','collectif',2,'cote-a-l-os-frites');
call create_game_participation('cecile-2024','rouge-2024','puzzle-contre-la-montre-2024','participant','collectif',2,'cote-a-l-os-frites');
call create_game_participation('julie-2024','rouge-2024','puzzle-contre-la-montre-2024','exclusion-apres-tirage-au-sort','collectif',2,'cote-a-l-os-frites');
call create_game_participation('lea-2-2024','rouge-2024','puzzle-contre-la-montre-2024','participant','collectif',2,'cote-a-l-os-frites');

call create_game_participation('amri-2024','jaune-2024','puzzle-contre-la-montre-2024','participant','collectif',1,'');
call create_game_participation('pauline-2024','jaune-2024','puzzle-contre-la-montre-2024','participant','collectif',1,'');
call create_game_participation('aurelien-2024','jaune-2024','puzzle-contre-la-montre-2024','participant','collectif',1,'');
call create_game_participation('oceane-2024','jaune-2024','puzzle-contre-la-montre-2024','participant','collectif',1,'');
call create_game_participation('sebastien-2024','jaune-2024','puzzle-contre-la-montre-2024','participant','collectif',1,'');
call create_game_participation('lea-2024','jaune-2024','puzzle-contre-la-montre-2024','participant','collectif',1,'');

call team_game_ranking ('jaune-2024','puzzle-contre-la-montre-2024',1);
call team_game_ranking ('rouge-2024','puzzle-contre-la-montre-2024',2);

call create_participant_departure('les-chasseurs-d-immunite','ricky-2024','rouge-2024',22,'choix-des-ambassadeurs', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','ricky-2024',14,1,22);

call program_current_time ('les-chasseurs-d-immunite',22);
