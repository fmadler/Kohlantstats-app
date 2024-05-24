call create_game('les-chasseurs-d-immunite','A bout de souffle','a-bout-de-souffle-2024','apnee','individuel','confort',22,31,'nuit-luxueuse,avantage-strategique','apnee,patience');

call create_game_participation('jean-2024','blanc-2024','a-bout-de-souffle-2024','participant','individuel',3,'');
call create_game_participation('megane-2024','blanc-2024','a-bout-de-souffle-2024','participant','individuel',2,'');
call create_game_participation('meissa-2024','blanc-2024','a-bout-de-souffle-2024','participant','individuel',7,'');
call create_game_participation('david-2024','blanc-2024','a-bout-de-souffle-2024','participant','individuel',8,'');
call create_game_participation('julie-2024','blanc-2024','a-bout-de-souffle-2024','participant','individuel',6,'');
call create_game_participation('amri-2024','blanc-2024','a-bout-de-souffle-2024','participant','individuel',1,'nuit-luxueuse,avantage-strategique');
call create_game_participation('pauline-2024','blanc-2024','a-bout-de-souffle-2024','participant','individuel',4,'');
call create_game_participation('lea-2024','blanc-2024','a-bout-de-souffle-2024','participant','individuel',5,'nuit-luxueuse');

-- amri trouve collier

call create_participant_departure ('les-chasseurs-d-immunite','jean-2024','blanc-2024',32,'abandon-medical', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','jean-2024',8,1,32);

call create_game('les-chasseurs-d-immunite','Construction d''un puzzle à l''aveugle','puzzle-aveugle-2024','puzzle-aveugle','individuel','immunite',23,32,'totem,vote-contre-soi','memoire,rapidite');

call create_game_participation('megane-2024','blanc-2024','puzzle-aveugle-2024','participant','individuel',3,'');
call create_game_participation('meissa-2024','blanc-2024','puzzle-aveugle-2024','participant','individuel',7,'vote-contre-soi');
call create_game_participation('david-2024','blanc-2024','puzzle-aveugle-2024','participant','individuel',6,'');
call create_game_participation('julie-2024','blanc-2024','puzzle-aveugle-2024','participant','individuel',4,'');
call create_game_participation('amri-2024','blanc-2024','puzzle-aveugle-2024','participant','individuel',5,'');
call create_game_participation('pauline-2024','blanc-2024','puzzle-aveugle-2024','participant','individuel',2,'');
call create_game_participation('lea-2024','blanc-2024','puzzle-aveugle-2024','participant','individuel',1,'totem');

call first_vote_against ('les-chasseurs-d-immunite','megane-2024','amri-2024','blanc-2024', 32, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','david-2024','meissa-2024','blanc-2024', 32, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','julie-2024','amri-2024','blanc-2024', 32, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','meissa-2024','julie-2024','blanc-2024', 32, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','pauline-2024','megane-2024','blanc-2024', 32, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','amri-2024','megane-2024','blanc-2024', 32, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','lea-2024','megane-2024','blanc-2024', 32, 'effectif');
call second_vote_against ('les-chasseurs-d-immunite','megane-2024','megane-2024','blanc-2024', 32, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','megane-2024','blanc-2024',32,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','megane-2024',7,1,32);

call program_current_time ('les-chasseurs-d-immunite',32);
