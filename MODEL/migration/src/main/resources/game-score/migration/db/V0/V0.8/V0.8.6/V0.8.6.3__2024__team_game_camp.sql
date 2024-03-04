call create_game('les-chasseurs-d-immunite','Malle tractée','malle-tractee-2024','malle-tractee','collectif','confort',3,4,'renfort,poisson','rapidite,force,precision');

-- todo add exclusion-par-tirage-au-sort
call create_game_participation('ricky-2024','rouge-2024','malle-tractee-2024','participant','collectif',2,'renfort');
call create_game_participation('jean-2024','rouge-2024','malle-tractee-2024','participant','collectif',2,'renfort');
call create_game_participation('megane-2024','rouge-2024','malle-tractee-2024','participant','collectif',2,'renfort');
call create_game_participation('emilie-2024','rouge-2024','malle-tractee-2024','participant','collectif',2,'renfort');
call create_game_participation('alicia-2024','rouge-2024','malle-tractee-2024','participant','collectif',2,'renfort');
call create_game_participation('meissa-2024','rouge-2024','malle-tractee-2024','participant','collectif',2,'renfort');
call create_game_participation('david-2024','rouge-2024','malle-tractee-2024','participant','collectif',2,'renfort');
call create_game_participation('cecile-2024','rouge-2024','malle-tractee-2024','participant','collectif',2,'renfort');
call create_game_participation('julie-2024','rouge-2024','malle-tractee-2024','participant','collectif',2,'renfort');
call create_game_participation('maxime-2024','rouge-2024','malle-tractee-2024','exclusion-apres-tirage-au-sort','collectif',2,'renfort');

call create_game_participation('alexis-2024','jaune-2024','malle-tractee-2024','participant','collectif',1,'poisson,renfort');
call create_game_participation('amri-2024','jaune-2024','malle-tractee-2024','participant','collectif',1,'poisson,renfort');
call create_game_participation('pauline-2024','jaune-2024','malle-tractee-2024','participant','collectif',1,'poisson,renfort');
call create_game_participation('aurelien-2024','jaune-2024','malle-tractee-2024','participant','collectif',1,'poisson,renfort');
call create_game_participation('nathalie-2024','jaune-2024','malle-tractee-2024','participant','collectif',1,'poisson,renfort');
call create_game_participation('sarah-2024','jaune-2024','malle-tractee-2024','participant','collectif',1,'poisson,renfort');
call create_game_participation('oceane-2024','jaune-2024','malle-tractee-2024','participant','collectif',1,'poisson,renfort');
call create_game_participation('sebastien-2024','jaune-2024','malle-tractee-2024','participant','collectif',1,'poisson,renfort');
call create_game_participation('lea-2024','jaune-2024','malle-tractee-2024','participant','collectif',1,'poisson,renfort');

call team_game_ranking ('jaune-2024','malle-tractee-2024',1);
call team_game_ranking ('rouge-2024','malle-tractee-2024',2);

call add_participant('les-chasseurs-d-immunite', 'William', 'xxx', 'william-2024', 'M', 55, null, 0, 'xx', 'x');
call add_participant('les-chasseurs-d-immunite', 'Léa 2', 'xxx', 'lea-2-2024', 'F', 27, null, 0, 'x', 'x');
call create_participant_entrance ('les-chasseurs-d-immunite','william-2024','jaune-2024',4,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','lea-2-2024','rouge-2024',4,'arrivee', @participant_team_id);

call create_game('les-chasseurs-d-immunite','Las bolas','las-bolas-2024','rapidite','collectif','immunite',4,5,'totem','rapidite,memorisation,orientation,precision');
call create_game_participation('ricky-2024','rouge-2024','las-bolas-2024','participant','collectif',2,'conseil');
call create_game_participation('jean-2024','rouge-2024','las-bolas-2024','participant','collectif',2,'conseil');
call create_game_participation('megane-2024','rouge-2024','las-bolas-2024','participant','collectif',2,'conseil');
call create_game_participation('emilie-2024','rouge-2024','las-bolas-2024','participant','collectif',2,'conseil');
call create_game_participation('alicia-2024','rouge-2024','las-bolas-2024','participant','collectif',2,'conseil');
call create_game_participation('meissa-2024','rouge-2024','las-bolas-2024','participant','collectif',2,'conseil');
call create_game_participation('david-2024','rouge-2024','las-bolas-2024','participant','collectif',2,'conseil');
call create_game_participation('cecile-2024','rouge-2024','las-bolas-2024','participant','collectif',2,'conseil');
call create_game_participation('julie-2024','rouge-2024','las-bolas-2024','participant','collectif',2,'conseil');
call create_game_participation('maxime-2024','rouge-2024','las-bolas-2024','participant','collectif',2,'conseil');
call create_game_participation('lea-2-2024','rouge-2024','las-bolas-2024','exclusion-apres-tirage-au-sort','collectif',2,'conseil');

call create_game_participation('alexis-2024','jaune-2024','las-bolas-2024','participant','collectif',1,'totem');
call create_game_participation('amri-2024','jaune-2024','las-bolas-2024','participant','collectif',1,'totem');
call create_game_participation('pauline-2024','jaune-2024','las-bolas-2024','participant','collectif',1,'totem');
call create_game_participation('aurelien-2024','jaune-2024','las-bolas-2024','participant','collectif',1,'totem');
call create_game_participation('nathalie-2024','jaune-2024','las-bolas-2024','participant','collectif',1,'totem');
call create_game_participation('sarah-2024','jaune-2024','las-bolas-2024','participant','collectif',1,'totem');
call create_game_participation('oceane-2024','jaune-2024','las-bolas-2024','participant','collectif',1,'totem');
call create_game_participation('sebastien-2024','jaune-2024','las-bolas-2024','participant','collectif',1,'totem');
call create_game_participation('lea-2024','jaune-2024','las-bolas-2024','participant','collectif',1,'totem');
call create_game_participation('william-2024','jaune-2024','las-bolas-2024','participant','collectif',1,'totem');

call team_game_ranking ('jaune-2024','las-bolas-2024',2);
call team_game_ranking ('rouge-2024','las-bolas-2024',1);

-- steve collier

call first_vote_against ('les-chasseurs-d-immunite','ricky-2024','alicia-2024','rouge-2024', 6, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','jean-2024','julie-2024','rouge-2024', 6, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','megane-2024','alicia-2024','rouge-2024', 6, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','emilie-2024','alicia-2024','rouge-2024', 6, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','alicia-2024','julie-2024','rouge-2024', 6, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','meissa-2024','julie-2024','rouge-2024', 6, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','david-2024','alicia-2024','rouge-2024', 6, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','cecile-2024','alicia-2024','rouge-2024', 6, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','lea-2-2024','alicia-2024','rouge-2024', 6, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','julie-2024','alicia-2024','rouge-2024', 6, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','maxime-2024','alicia-2024','rouge-2024', 6, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','alicia-2024','rouge-2024',6,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','alicia-2024',21,1,6);

call program_current_time ('les-chasseurs-d-immunite',6);
