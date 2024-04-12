call create_game('les-chasseurs-d-immunite','Paresseux','paresseux-2024','paresseux','collectif','confort',13,18,'nourriture-fruits-legumes','statique,patience');

call create_game_participation('ricky-2024','rouge-2024','paresseux-2024','participant','collectif',2,'nourriture-fruits-legumes');
call create_game_participation('jean-2024','rouge-2024','paresseux-2024','participant','collectif',2,'nourriture-fruits-legumes');
call create_game_participation('megane-2024','rouge-2024','paresseux-2024','participant','collectif',2,'nourriture-fruits-legumes');
call create_game_participation('meissa-2024','rouge-2024','paresseux-2024','participant','collectif',2,'nourriture-fruits-legumes');
call create_game_participation('david-2024','rouge-2024','paresseux-2024','exclusion-apres-tirage-au-sort','collectif',2,'nourriture-fruits-legumes');
call create_game_participation('cecile-2024','rouge-2024','paresseux-2024','participant','collectif',2,'nourriture-fruits-legumes');
call create_game_participation('julie-2024','rouge-2024','paresseux-2024','exclusion-apres-tirage-au-sort','collectif',2,'nourriture-fruits-legumes');
call create_game_participation('maxime-2024','rouge-2024','paresseux-2024','exclusion-apres-tirage-au-sort','collectif',2,'nourriture-fruits-legumes');
call create_game_participation('lea-2-2024','rouge-2024','paresseux-2024','participant','collectif',2,'nourriture-fruits-legumes');

call create_game_participation('amri-2024','jaune-2024','paresseux-2024','participant','collectif',1,'');
call create_game_participation('pauline-2024','jaune-2024','paresseux-2024','participant','collectif',1,'');
call create_game_participation('aurelien-2024','jaune-2024','paresseux-2024','participant','collectif',1,'');
call create_game_participation('oceane-2024','jaune-2024','paresseux-2024','participant','collectif',1,'');
call create_game_participation('sebastien-2024','jaune-2024','paresseux-2024','participant','collectif',1,'');
call create_game_participation('lea-2024','jaune-2024','paresseux-2024','participant','collectif',1,'');

call team_game_ranking ('jaune-2024','paresseux-2024',1);
call team_game_ranking ('rouge-2024','paresseux-2024',2);

call create_game('les-chasseurs-d-immunite','Empillement de boules','empillement-de-boules-2024','empillement-de-boules','collectif','immunite',14,20,'totem','dexterite,rapidite,force');
call create_game_participation('ricky-2024','rouge-2024','empillement-de-boules-2024','exclusion-apres-tirage-au-sort','collectif',2,'conseil');
call create_game_participation('jean-2024','rouge-2024','empillement-de-boules-2024','participant','collectif',2,'conseil');
call create_game_participation('megane-2024','rouge-2024','empillement-de-boules-2024','exclusion-apres-tirage-au-sort','collectif',2,'conseil');
call create_game_participation('meissa-2024','rouge-2024','empillement-de-boules-2024','participant','collectif',2,'conseil');
call create_game_participation('david-2024','rouge-2024','empillement-de-boules-2024','participant','collectif',2,'conseil');
call create_game_participation('cecile-2024','rouge-2024','empillement-de-boules-2024','participant','collectif',2,'conseil');
call create_game_participation('julie-2024','rouge-2024','empillement-de-boules-2024','participant','collectif',2,'conseil');
call create_game_participation('maxime-2024','rouge-2024','empillement-de-boules-2024','exclusion-apres-tirage-au-sort','collectif',2,'conseil');
call create_game_participation('lea-2-2024','rouge-2024','empillement-de-boules-2024','participant','collectif',2,'conseil');

call create_game_participation('amri-2024','jaune-2024','empillement-de-boules-2024','participant','collectif',1,'totem');
call create_game_participation('pauline-2024','jaune-2024','empillement-de-boules-2024','participant','collectif',1,'totem');
call create_game_participation('aurelien-2024','jaune-2024','empillement-de-boules-2024','participant','collectif',1,'totem');
call create_game_participation('sarah-2024','jaune-2024','empillement-de-boules-2024','participant','collectif',1,'totem');
call create_game_participation('oceane-2024','jaune-2024','empillement-de-boules-2024','participant','collectif',1,'totem');
call create_game_participation('sebastien-2024','jaune-2024','empillement-de-boules-2024','participant','collectif',1,'totem');
call create_game_participation('lea-2024','jaune-2024','empillement-de-boules-2024','participant','collectif',1,'totem');

call team_game_ranking ('jaune-2024','empillement-de-boules-2024',2);
call team_game_ranking ('rouge-2024','empillement-de-boules-2024',1);

-- vote

call first_vote_against ('les-chasseurs-d-immunite','megane-2024','maxime-2024','jaune-2024', 20, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','ricky-2024','lea-2024','jaune-2024', 20, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','david-2024','lea-2024','jaune-2024', 20, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','julie-2024','maxime-2024','jaune-2024', 20, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','jean-2024','maxime-2024','jaune-2024', 20, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','cecile-2024','maxime-2024','jaune-2024', 20, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','meissa-2024','maxime-2024','jaune-2024', 20, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','lea-2024','maxime-2024','jaune-2024', 20, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','maxime-2024','david-2024','jaune-2024', 20, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','maxime-2024','rouge-2024',20,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','maxime-2024',15,1,20);

call program_current_time ('les-chasseurs-d-immunite',20);
