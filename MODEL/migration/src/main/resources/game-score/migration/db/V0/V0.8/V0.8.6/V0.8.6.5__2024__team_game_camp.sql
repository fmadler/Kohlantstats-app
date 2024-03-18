call create_game('les-chasseurs-d-immunite','Flambeaux','flambeaux-2024','flambeaux','collectif','confort',8,10,'pizzas,avantage-strategique','rapidite,force,reflexion');

call create_game_participation('ricky-2024','rouge-2024','flambeaux-2024','exclusion-apres-tirage-au-sort','collectif',1,'pizzas');
call create_game_participation('jean-2024','rouge-2024','flambeaux-2024','participant','collectif',1,'pizzas');
call create_game_participation('megane-2024','rouge-2024','flambeaux-2024','exclusion-apres-tirage-au-sort','collectif',1,'pizzas');
call create_game_participation('emilie-2024','rouge-2024','flambeaux-2024','participant','collectif',1,'pizzas');
call create_game_participation('meissa-2024','rouge-2024','flambeaux-2024','participant','collectif',1,'pizzas');
call create_game_participation('david-2024','rouge-2024','flambeaux-2024','participant','collectif',1,'pizzas');
call create_game_participation('cecile-2024','rouge-2024','flambeaux-2024','participant','collectif',1,'pizzas');
call create_game_participation('julie-2024','rouge-2024','flambeaux-2024','participant','collectif',1,'pizzas,avantage-strategique');
call create_game_participation('maxime-2024','rouge-2024','flambeaux-2024','participant','collectif',1,'pizzas');
call create_game_participation('lea-2-2024','rouge-2024','flambeaux-2024','participant','collectif',1,'pizzas');

call create_game_participation('alexis-2024','jaune-2024','flambeaux-2024','participant','collectif',2,'');
call create_game_participation('amri-2024','jaune-2024','flambeaux-2024','participant','collectif',2,'duel');
call create_game_participation('pauline-2024','jaune-2024','flambeaux-2024','participant','collectif',2,'');
call create_game_participation('nathalie-2024','jaune-2024','flambeaux-2024','participant','collectif',2,'duel');
call create_game_participation('sarah-2024','jaune-2024','flambeaux-2024','participant','collectif',2,'');
call create_game_participation('oceane-2024','jaune-2024','flambeaux-2024','participant','collectif',2,'');
call create_game_participation('sebastien-2024','jaune-2024','flambeaux-2024','participant','collectif',2,'');
call create_game_participation('lea-2024','jaune-2024','flambeaux-2024','participant','collectif',2,'');

call team_game_ranking ('jaune-2024','flambeaux-2024',2);
call team_game_ranking ('rouge-2024','flambeaux-2024',1);

call create_game('les-chasseurs-d-immunite','Régate','regate-2024','regate','collectif','immunite',9,9,'totem','construction,rapidite');
call create_game_participation('ricky-2024','rouge-2024','regate-2024','participant','collectif',1,'totem');
call create_game_participation('jean-2024','rouge-2024','regate-2024','participant','collectif',1,'totem');
call create_game_participation('megane-2024','rouge-2024','regate-2024','participant','collectif',1,'totem');
call create_game_participation('emilie-2024','rouge-2024','regate-2024','participant','collectif',1,'totem');
call create_game_participation('meissa-2024','rouge-2024','regate-2024','participant','collectif',1,'totem');
call create_game_participation('david-2024','rouge-2024','regate-2024','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('cecile-2024','rouge-2024','regate-2024','participant','collectif',1,'totem');
call create_game_participation('julie-2024','rouge-2024','regate-2024','participant','collectif',1,'totem');
call create_game_participation('maxime-2024','rouge-2024','regate-2024','participant','collectif',1,'totem');
call create_game_participation('lea-2-2024','rouge-2024','regate-2024','exclusion-apres-tirage-au-sort','collectif',1,'totem');

call create_game_participation('alexis-2024','jaune-2024','regate-2024','participant','collectif',2,'conseil');
call create_game_participation('amri-2024','jaune-2024','regate-2024','participant','collectif',2,'conseil');
call create_game_participation('pauline-2024','jaune-2024','regate-2024','participant','collectif',2,'conseil');
call create_game_participation('aurelien-2024','jaune-2024','regate-2024','participant','collectif',2,'conseil');
call create_game_participation('sarah-2024','jaune-2024','regate-2024','participant','collectif',2,'conseil');
call create_game_participation('oceane-2024','jaune-2024','regate-2024','participant','collectif',2,'conseil');
call create_game_participation('sebastien-2024','jaune-2024','regate-2024','participant','collectif',2,'conseil');
call create_game_participation('lea-2024','jaune-2024','regate-2024','participant','collectif',2,'conseil');

call team_game_ranking ('jaune-2024','regate-2024',2);
call team_game_ranking ('rouge-2024','regate-2024',1);

-- vote

call first_vote_against ('les-chasseurs-d-immunite','aurelien-2024','alexis-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','alexis-2024','lea-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','sebastien-2024','alexis-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','oceane-2024','alexis-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','amri-2024','alexis-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','sarah-2024','alexis-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','lea-2024','sarah-2024','jaune-2024', 9, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','pauline-2024','sarah-2024','jaune-2024', 9, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','alexis-2024','jaune-2024',11,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','alexis-2024',18,1,11);

call program_current_time ('les-chasseurs-d-immunite',11);
