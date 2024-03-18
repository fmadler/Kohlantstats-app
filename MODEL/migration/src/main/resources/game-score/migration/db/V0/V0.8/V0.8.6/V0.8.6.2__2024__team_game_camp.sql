call create_game_type ('Bélier', 'belier', NULL);
call create_game('les-chasseurs-d-immunite','Bélier','belier-2024','belier','collectif','confort',1,1,'totem','rapidite,force,precision');

call create_game_participation('ricky-2024','rouge-2024','belier-2024','participant','collectif',2,'');
call create_game_participation('jean-2024','rouge-2024','belier-2024','participant','collectif',2,'');
call create_game_participation('megane-2024','rouge-2024','belier-2024','participant','collectif',2,'');
call create_game_participation('emilie-2024','rouge-2024','belier-2024','participant','collectif',2,'');
call create_game_participation('alicia-2024','rouge-2024','belier-2024','participant','collectif',2,'');
call create_game_participation('meissa-2024','rouge-2024','belier-2024','participant','collectif',2,'');
call create_game_participation('david-2024','rouge-2024','belier-2024','participant','collectif',2,'');
call create_game_participation('cecile-2024','rouge-2024','belier-2024','participant','collectif',2,'');
call create_game_participation('julie-2024','rouge-2024','belier-2024','participant','collectif',2,'');
call create_game_participation('maxime-2024','rouge-2024','belier-2024','participant','collectif',2,'');

call create_game_participation('alexis-2024','jaune-2024','belier-2024','participant','collectif',1,'kit-construction');
call create_game_participation('amri-2024','jaune-2024','belier-2024','participant','collectif',1,'kit-construction');
call create_game_participation('pauline-2024','jaune-2024','belier-2024','participant','collectif',1,'kit-construction');
call create_game_participation('aurelien-2024','jaune-2024','belier-2024','participant','collectif',1,'kit-construction');
call create_game_participation('nathalie-2024','jaune-2024','belier-2024','participant','collectif',1,'kit-construction');
call create_game_participation('sarah-2024','jaune-2024','belier-2024','participant','collectif',1,'kit-construction');
call create_game_participation('oceane-2024','jaune-2024','belier-2024','participant','collectif',1,'kit-construction');
call create_game_participation('sebastien-2024','jaune-2024','belier-2024','participant','collectif',1,'kit-construction');
call create_game_participation('steve-2024','jaune-2024','belier-2024','participant','collectif',1,'kit-construction');
call create_game_participation('lea-2024','jaune-2024','belier-2024','participant','collectif',1,'kit-construction');

call team_game_ranking ('jaune-2024','belier-2024',1);
call team_game_ranking ('rouge-2024','belier-2024',2);


call create_game('les-chasseurs-d-immunite','Equilibre sur poutre','equilibre-poutre-2024','equilibre','collectif','immunite',2,2,'kit-construction','rapidite,force,precision');

call create_game_participation('ricky-2024','rouge-2024','equilibre-poutre-2024','participant','collectif',1,'totem');
call create_game_participation('jean-2024','rouge-2024','equilibre-poutre-2024','participant','collectif',1,'totem');
call create_game_participation('megane-2024','rouge-2024','equilibre-poutre-2024','participant','collectif',1,'totem');
call create_game_participation('emilie-2024','rouge-2024','equilibre-poutre-2024','participant','collectif',1,'totem');
call create_game_participation('alicia-2024','rouge-2024','equilibre-poutre-2024','participant','collectif',1,'totem');
call create_game_participation('meissa-2024','rouge-2024','equilibre-poutre-2024','participant','collectif',1,'totem');
call create_game_participation('david-2024','rouge-2024','equilibre-poutre-2024','participant','collectif',1,'totem');
call create_game_participation('cecile-2024','rouge-2024','equilibre-poutre-2024','participant','collectif',1,'totem');
call create_game_participation('julie-2024','rouge-2024','equilibre-poutre-2024','participant','collectif',1,'totem');
call create_game_participation('maxime-2024','rouge-2024','equilibre-poutre-2024','participant','collectif',1,'totem');

call create_game_participation('alexis-2024','jaune-2024','equilibre-poutre-2024','participant','collectif',2,'conseil');
call create_game_participation('amri-2024','jaune-2024','equilibre-poutre-2024','participant','collectif',2,'conseil');
call create_game_participation('pauline-2024','jaune-2024','equilibre-poutre-2024','participant','collectif',2,'conseil');
call create_game_participation('aurelien-2024','jaune-2024','equilibre-poutre-2024','participant','collectif',2,'conseil');
call create_game_participation('nathalie-2024','jaune-2024','equilibre-poutre-2024','participant','collectif',2,'conseil');
call create_game_participation('sarah-2024','jaune-2024','equilibre-poutre-2024','participant','collectif',2,'conseil');
call create_game_participation('oceane-2024','jaune-2024','equilibre-poutre-2024','participant','collectif',2,'conseil');
call create_game_participation('sebastien-2024','jaune-2024','equilibre-poutre-2024','participant','collectif',2,'conseil');
call create_game_participation('steve-2024','jaune-2024','equilibre-poutre-2024','participant','collectif',2,'conseil');
call create_game_participation('lea-2024','jaune-2024','equilibre-poutre-2024','participant','collectif',2,'conseil');

call team_game_ranking ('jaune-2024','equilibre-poutre-2024',2);
call team_game_ranking ('rouge-2024','equilibre-poutre-2024',1);

-- steve collier

call first_vote_against ('les-chasseurs-d-immunite','steve-2024','nathalie-2024','jaune-2024', 3, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','aurelien-2024','steve-2024','jaune-2024', 3, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','alexis-2024','steve-2024','jaune-2024', 3, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','sebastien-2024','nathalie-2024','jaune-2024', 3, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','nathalie-2024','steve-2024','jaune-2024', 3, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','oceane-2024','steve-2024','jaune-2024', 3, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','amri-2024','steve-2024','jaune-2024', 3, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','sarah-2024','steve-2024','jaune-2024', 3, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','lea-2024','steve-2024','jaune-2024', 3, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','pauline-2024','steve-2024','jaune-2024', 3, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','steve-2024','jaune-2024',3,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','steve-2024',22,1,3);

call program_current_time ('les-chasseurs-d-immunite',3);
