-- duel aurelien, sebastien
-- puzzle
call create_game('les-chasseurs-d-immunite','puzzle-duel','puzzle-duel-2024','puzzle','individuel','eliminatoire',24,33,'continuation-aventure,elimination-du-dernier','logique,rapidite');
call create_game_participation('aurelien-2024','blanc-2024','puzzle-duel-2024','participant','individuel',2,'elimination-du-dernier');
call create_game_participation('sebastien-2024','blanc-2024','puzzle-duel-2024','participant','individuel',1,'continuation-aventure');

call create_participant_entrance ('les-chasseurs-d-immunite','sebastien-2024','blanc-2024',33,'remplacement', @participant_team_id);

-- victoire seb
call create_game('les-chasseurs-d-immunite','Koala','koala-2024','koala','individuel','confort',25,33,'nuit-hotel,avantage-strategique','patience,statique');

call create_game_participation('sebastien-2024','blanc-2024','koala-2024','participant','individuel',1,'nuit-hotel,avantage-strategique');
call create_game_participation('meissa-2024','blanc-2024','koala-2024','participant','individuel',0,'');
call create_game_participation('david-2024','blanc-2024','koala-2024','participant','individuel',0,'nuit-hotel');
call create_game_participation('julie-2024','blanc-2024','koala-2024','participant','individuel',2,'nuit-hotel');
call create_game_participation('amri-2024','blanc-2024','koala-2024','participant','individuel',0,'');
call create_game_participation('pauline-2024','blanc-2024','koala-2024','participant','individuel',0,'');
call create_game_participation('lea-2024','blanc-2024','koala-2024','participant','individuel',0,'');

-- seb gagne indice

call create_game('les-chasseurs-d-immunite','Equilibre sur l''eau','equilibre-sur-eau-2024','equilibre-sur-eau','individuel','immunite',26,34,'totem','rapidite,equilibre');

call create_game_participation('sebastien-2024','blanc-2024','equilibre-sur-eau-2024','participant','individuel',2,'');
call create_game_participation('meissa-2024','blanc-2024','equilibre-sur-eau-2024','participant','individuel',1,'totem');
call create_game_participation('david-2024','blanc-2024','equilibre-sur-eau-2024','participant','individuel',0,'');
call create_game_participation('julie-2024','blanc-2024','equilibre-sur-eau-2024','participant','individuel',0,'');
call create_game_participation('amri-2024','blanc-2024','equilibre-sur-eau-2024','participant','individuel',0,'');
call create_game_participation('pauline-2024','blanc-2024','equilibre-sur-eau-2024','participant','individuel',0,'');
call create_game_participation('lea-2024','blanc-2024','equilibre-sur-eau-2024','participant','individuel',0,'');

call first_vote_against ('les-chasseurs-d-immunite','david-2024','amri-2024','blanc-2024', 34, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','sebastien-2024','amri-2024','blanc-2024', 34, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','meissa-2024','david-2024','blanc-2024', 34, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','pauline-2024','david-2024','blanc-2024', 34, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','amri-2024','david-2024','blanc-2024', 34, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','julie-2024','amri-2024','blanc-2024', 34, 'effectif');
call second_vote_against ('les-chasseurs-d-immunite','julie-2024','amri-2024','blanc-2024', 34, 'effectif');

call second_round_first_vote_for ('les-chasseurs-d-immunite','david-2024','amri-2024','blanc-2024', 34, 'effectif');
call second_round_first_vote_for ('les-chasseurs-d-immunite','sebastien-2024','amri-2024','blanc-2024', 34, 'effectif');
call second_round_first_vote_for ('les-chasseurs-d-immunite','meissa-2024','david-2024','blanc-2024', 34, 'effectif');
call second_round_first_vote_for ('les-chasseurs-d-immunite','pauline-2024','david-2024','blanc-2024', 34, 'effectif');
call second_round_first_vote_for ('les-chasseurs-d-immunite','amri-2024','david-2024','blanc-2024', 34, 'effectif');
call second_round_first_vote_for ('les-chasseurs-d-immunite','julie-2024','amri-2024','blanc-2024', 34, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','david-2024','blanc-2024',34,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','david-2024',7,1,34);

call program_current_time ('les-chasseurs-d-immunite',34);
