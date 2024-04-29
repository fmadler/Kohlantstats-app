call create_game('les-chasseurs-d-immunite','Parcours du combattant','parcours-du-combattant-2024','parcours-du-combattant','individuel','immunite',17,23,'totem','force,rapidite');

call create_game_participation('jean-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',1,'totem');
call create_game_participation('megane-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',0,'');
call create_game_participation('meissa-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',0,'');
call create_game_participation('david-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',0,'');
call create_game_participation('cecile-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',0,'');
call create_game_participation('julie-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',0,'');
call create_game_participation('lea-2-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',2,'');
call create_game_participation('amri-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',0,'');
call create_game_participation('pauline-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',0,'');
call create_game_participation('aurelien-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',0,'');
call create_game_participation('oceane-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',0,'');
call create_game_participation('sebastien-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',0,'');
call create_game_participation('lea-2024','blanc-2024','parcours-du-combattant-2024','participant','individuel',0,'');

-- vote

call first_vote_against ('les-chasseurs-d-immunite','megane-2024','oceane-2024','blanc-2024', 23, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','david-2024','oceane-2024','blanc-2024', 23, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','julie-2024','oceane-2024','blanc-2024', 23, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','jean-2024','oceane-2024','blanc-2024', 23, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','cecile-2024','oceane-2024','blanc-2024', 23, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','meissa-2024','oceane-2024','blanc-2024', 23, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','lea-2-2024','oceane-2024','blanc-2024', 23, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','pauline-2024','lea-2024','blanc-2024', 23, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','oceane-2024','lea-2024','blanc-2024', 23, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','amri-2024','lea-2024','blanc-2024', 23, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','sebastien-2024','lea-2024','blanc-2024', 23, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','aurelien-2024','lea-2024','blanc-2024', 23, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','lea-2-2024','blanc-2024',23,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','lea-2-2024',14,1,23);

call program_current_time ('les-chasseurs-d-immunite',23);
