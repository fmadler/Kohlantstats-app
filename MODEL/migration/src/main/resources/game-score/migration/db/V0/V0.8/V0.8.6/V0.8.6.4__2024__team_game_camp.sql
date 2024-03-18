call create_game('les-chasseurs-d-immunite','Bamboo','bambou-2024','bambou','individuel','confort',5,7,'nourriture-riz,duel,avantage-strategique','statique,patience');

call create_game_participation('ricky-2024','rouge-2024','bambou-2024','participant','individuel',1,'nourriture-riz,avantage-strategique');
call create_game_participation('jean-2024','rouge-2024','bambou-2024','participant','individuel',4,'nourriture-riz');
call create_game_participation('megane-2024','rouge-2024','bambou-2024','participant','individuel',17,'nourriture-riz');
call create_game_participation('emilie-2024','rouge-2024','bambou-2024','participant','individuel',15,'nourriture-riz');
call create_game_participation('meissa-2024','rouge-2024','bambou-2024','participant','individuel',9,'nourriture-riz');
call create_game_participation('david-2024','rouge-2024','bambou-2024','participant','individuel',12,'nourriture-riz');
call create_game_participation('cecile-2024','rouge-2024','bambou-2024','participant','individuel',19,'nourriture-riz');
call create_game_participation('julie-2024','rouge-2024','bambou-2024','participant','individuel',7,'nourriture-riz');
call create_game_participation('maxime-2024','rouge-2024','bambou-2024','participant','individuel',2,'nourriture-riz');
call create_game_participation('lea-2-2024','rouge-2024','bambou-2024','participant','individuel',16,'nourriture-riz');

call create_game_participation('alexis-2024','jaune-2024','bambou-2024','participant','individuel',14,'');
call create_game_participation('amri-2024','jaune-2024','bambou-2024','participant','individuel',18,'duel');
call create_game_participation('pauline-2024','jaune-2024','bambou-2024','participant','individuel',10,'');
call create_game_participation('aurelien-2024','jaune-2024','bambou-2024','participant','individuel',5,'');
call create_game_participation('nathalie-2024','jaune-2024','bambou-2024','participant','individuel',20,'duel');
call create_game_participation('sarah-2024','jaune-2024','bambou-2024','participant','individuel',13,'');
call create_game_participation('oceane-2024','jaune-2024','bambou-2024','participant','individuel',11,'');
call create_game_participation('sebastien-2024','jaune-2024','bambou-2024','participant','individuel',6,'');
call create_game_participation('lea-2024','jaune-2024','bambou-2024','participant','individuel',8,'');
call create_game_participation('william-2024','jaune-2024','bambou-2024','participant','individuel',3,'');

call team_game_ranking ('jaune-2024','bambou-2024',2);
call team_game_ranking ('rouge-2024','bambou-2024',1);

/**/
call create_game('les-chasseurs-d-immunite','Labyrinthe','labyrinthe-2024','labyrinthe','individuel','eliminatoire',7, 7,'elimination-du-dernier','rapidite,logique');

call create_game_participation('amri-2024','jaune-2024','labyrinthe-2024','participant','individuel',1,'');
call create_game_participation('nathalie-2024','jaune-2024','labyrinthe-2024','participant','individuel',2,'elimination-du-dernier');

call create_participant_departure('les-chasseurs-d-immunite','nathalie-2024','jaune-2024',7,'exclusion-par-duel', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','nathalie-2024',20,1,7);

-- duel amri - nathalie

-- depart de nathalie

call create_game('les-chasseurs-d-immunite','Le grand bleu','le-grand-bleu-2024','rapidite','collectif','immunite',7,8,'totem','rapidite,natation,apnee');
call create_game_participation('ricky-2024','rouge-2024','le-grand-bleu-2024','participant','collectif',1,'totem');
call create_game_participation('jean-2024','rouge-2024','le-grand-bleu-2024','participant','collectif',1,'totem');
call create_game_participation('megane-2024','rouge-2024','le-grand-bleu-2024','participant','collectif',1,'totem');
call create_game_participation('emilie-2024','rouge-2024','le-grand-bleu-2024','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('meissa-2024','rouge-2024','le-grand-bleu-2024','participant','collectif',1,'totem');
call create_game_participation('david-2024','rouge-2024','le-grand-bleu-2024','participant','collectif',1,'totem');
call create_game_participation('cecile-2024','rouge-2024','le-grand-bleu-2024','participant','collectif',1,'totem');
call create_game_participation('julie-2024','rouge-2024','le-grand-bleu-2024','participant','collectif',1,'totem');
call create_game_participation('maxime-2024','rouge-2024','le-grand-bleu-2024','participant','collectif',1,'totem');
call create_game_participation('lea-2-2024','rouge-2024','le-grand-bleu-2024','participant','collectif',1,'totem');

call create_game_participation('alexis-2024','jaune-2024','le-grand-bleu-2024','participant','collectif',2,'conseil');
call create_game_participation('amri-2024','jaune-2024','le-grand-bleu-2024','participant','collectif',2,'conseil');
call create_game_participation('pauline-2024','jaune-2024','le-grand-bleu-2024','participant','collectif',2,'conseil');
call create_game_participation('aurelien-2024','jaune-2024','le-grand-bleu-2024','participant','collectif',2,'conseil');
call create_game_participation('sarah-2024','jaune-2024','le-grand-bleu-2024','participant','collectif',2,'conseil');
call create_game_participation('oceane-2024','jaune-2024','le-grand-bleu-2024','participant','collectif',2,'conseil');
call create_game_participation('sebastien-2024','jaune-2024','le-grand-bleu-2024','participant','collectif',2,'conseil');
call create_game_participation('lea-2024','jaune-2024','le-grand-bleu-2024','participant','collectif',2,'conseil');
call create_game_participation('william-2024','jaune-2024','le-grand-bleu-2024','participant','collectif',2,'conseil');

call team_game_ranking ('jaune-2024','le-grand-bleu-2024',2);
call team_game_ranking ('rouge-2024','le-grand-bleu-2024',1);

-- vote

call first_vote_against ('les-chasseurs-d-immunite','william-2024','lea-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','aurelien-2024','william-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','alexis-2024','william-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','sebastien-2024','william-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','oceane-2024','william-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','amri-2024','william-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','sarah-2024','william-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','lea-2024','william-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','pauline-2024','william-2024','jaune-2024', 9, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','william-2024','jaune-2024',9,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','william-2024',19,4,9);

call program_current_time ('les-chasseurs-d-immunite',9);
