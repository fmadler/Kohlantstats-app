INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Excursion', 'excursion', 3, 1);

call create_game('les-chasseurs-d-immunite','Poutre','poutre-2024','poutre','collectif','confort',12,15,'excursion,nourriture,telephone','statique,patience');

call create_game_participation('ricky-2024','rouge-2024','poutre-2024','participant','collectif',1,'excursion,nourriture,telephone');
call create_game_participation('jean-2024','rouge-2024','poutre-2024','exclusion-apres-tirage-au-sort','collectif',1,'excursion,nourriture,telephone');
call create_game_participation('megane-2024','rouge-2024','poutre-2024','participant','collectif',1,'excursion,nourriture,telephone');
call create_game_participation('meissa-2024','rouge-2024','poutre-2024','exclusion-apres-tirage-au-sort','collectif',1,'excursion,nourriture,telephone');
call create_game_participation('david-2024','rouge-2024','poutre-2024','participant','collectif',1,'excursion,nourriture,telephone');
call create_game_participation('cecile-2024','rouge-2024','poutre-2024','participant','collectif',1,'excursion,nourriture,telephone');
call create_game_participation('julie-2024','rouge-2024','poutre-2024','participant','collectif',1,'excursion,nourriture,telephone');
call create_game_participation('maxime-2024','rouge-2024','poutre-2024','participant','collectif',1,'excursion,nourriture,telephone');
call create_game_participation('lea-2-2024','rouge-2024','poutre-2024','participant','collectif',1,'excursion,nourriture,telephone');

call create_game_participation('amri-2024','jaune-2024','poutre-2024','participant','collectif',2,'');
call create_game_participation('pauline-2024','jaune-2024','poutre-2024','participant','collectif',2,'');
call create_game_participation('sarah-2024','jaune-2024','poutre-2024','participant','collectif',2,'');
call create_game_participation('oceane-2024','jaune-2024','poutre-2024','participant','collectif',2,'');
call create_game_participation('aurelien-2024','jaune-2024','poutre-2024','participant','collectif',2,'');
call create_game_participation('sebastien-2024','jaune-2024','poutre-2024','participant','collectif',2,'');
call create_game_participation('lea-2024','jaune-2024','poutre-2024','participant','collectif',2,'');

call team_game_ranking ('jaune-2024','poutre-2024',2);
call team_game_ranking ('rouge-2024','poutre-2024',1);

call create_game('les-chasseurs-d-immunite','Colonne','colonne-2024','colonne','individuel','confort',13, 15,'excursion,nourriture,telephone','rapidite,logique');

call create_game_participation('maxime-2024','rouge-2024','colonne-2024','participant','individuel',1,'excursion,nourriture,telephone');
call create_game_participation('sarah-2024','jaune-2024','colonne-2024','participant','individuel',2,'');

call create_game('les-chasseurs-d-immunite','Labyrinthe suspendu','labyrinthe-suspendu-2024','labyrinthe','collectif','immunite',14,17,'totem','construction,rapidite');
call create_game_participation('ricky-2024','rouge-2024','labyrinthe-suspendu-2024','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('jean-2024','rouge-2024','labyrinthe-suspendu-2024','participant','collectif',1,'totem');
call create_game_participation('megane-2024','rouge-2024','labyrinthe-suspendu-2024','participant','collectif',1,'totem');
call create_game_participation('meissa-2024','rouge-2024','labyrinthe-suspendu-2024','participant','collectif',1,'totem');
call create_game_participation('david-2024','rouge-2024','labyrinthe-suspendu-2024','participant','collectif',1,'totem');
call create_game_participation('cecile-2024','rouge-2024','labyrinthe-suspendu-2024','participant','collectif',1,'totem');
call create_game_participation('julie-2024','rouge-2024','labyrinthe-suspendu-2024','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('maxime-2024','rouge-2024','labyrinthe-suspendu-2024','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('lea-2-2024','rouge-2024','labyrinthe-suspendu-2024','participant','collectif',1,'totem');

call create_game_participation('amri-2024','jaune-2024','labyrinthe-suspendu-2024','participant','collectif',2,'conseil');
call create_game_participation('pauline-2024','jaune-2024','labyrinthe-suspendu-2024','participant','collectif',2,'conseil');
call create_game_participation('aurelien-2024','jaune-2024','labyrinthe-suspendu-2024','participant','collectif',2,'conseil');
call create_game_participation('sarah-2024','jaune-2024','labyrinthe-suspendu-2024','participant','collectif',2,'conseil');
call create_game_participation('oceane-2024','jaune-2024','labyrinthe-suspendu-2024','participant','collectif',2,'conseil');
call create_game_participation('sebastien-2024','jaune-2024','labyrinthe-suspendu-2024','participant','collectif',2,'conseil');
call create_game_participation('lea-2024','jaune-2024','labyrinthe-suspendu-2024','participant','collectif',2,'conseil');

call team_game_ranking ('jaune-2024','labyrinthe-suspendu-2024',2);
call team_game_ranking ('rouge-2024','labyrinthe-suspendu-2024',1);

-- vote

call first_vote_against ('les-chasseurs-d-immunite','amri-2024','sarah-2024','jaune-2024', 17, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','sebastien-2024','sarah-2024','jaune-2024', 17, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','aurelien-2024','sarah-2024','jaune-2024', 17, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','lea-2024','sarah-2024','jaune-2024', 17, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','sarah-2024','oceane-2024','jaune-2024', 17, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','oceane-2024','sarah-2024','jaune-2024', 17, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','pauline-2024','sarah-2024','jaune-2024', 17, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','sarah-2024','jaune-2024',17,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','sarah-2024',16,1,17);

call program_current_time ('les-chasseurs-d-immunite',17);
