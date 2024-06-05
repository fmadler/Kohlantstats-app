
call create_game('les-chasseurs-d-immunite','Orientation','orientation-2024','orientation','individuel','finale',29,37,'poteaux,elimination-du-dernier','rapidite,tenacite,perseverance');

call create_game_participation('amri-2024','blanc-2024','orientation-2024','participant','individuel',4,'elimination-du-dernier');
call create_game_participation('pauline-2024','blanc-2024','orientation-2024','participant','individuel',4,'elimination-du-dernier');
call create_game_participation('julie-2024','blanc-2024','orientation-2024','participant','individuel',3,'poteaux');
call create_game_participation('meissa-2024','blanc-2024','orientation-2024','participant','individuel',2,'poteaux');
call create_game_participation('lea-2024','blanc-2024','orientation-2024','participant','individuel',1,'poteaux');

call create_participant_departure('les-chasseurs-d-immunite','pauline-2024','blanc-2024',37,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','pauline-2024',4,1,37);
call create_participant_departure('les-chasseurs-d-immunite','amri-2024','blanc-2024',37,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','amri-2024',4,1,37);

call create_game('les-chasseurs-d-immunite','Poteaux','poteaux-2024','poteaux','individuel','finale',30,38,'groupe-final','patience,equilibre');


call create_game_participation('julie-2024','blanc-2024','poteaux-2024','participant','individuel',3,'');
call create_game_participation('meissa-2024','blanc-2024','poteaux-2024','participant','individuel',1,'groupe-final');
call create_game_participation('lea-2024','blanc-2024','poteaux-2024','participant','individuel',2,'groupe-final');

call create_participant_departure('les-chasseurs-d-immunite','julie-2024','blanc-2024',38,'epreuve-poteaux', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','julie-2024',3,1,38);

call first_vote_for ('les-chasseurs-d-immunite','julie-2024','meissa-2024','blanc-2024', 38, 'effectif');
call first_vote_for ('les-chasseurs-d-immunite','amri-2024','meissa-2024','blanc-2024', 38, 'effectif');
call first_vote_for ('les-chasseurs-d-immunite','megane-2024','meissa-2024','blanc-2024', 38, 'effectif');
call first_vote_for ('les-chasseurs-d-immunite','jean-2024','lea-2024','blanc-2024', 38, 'effectif');
call first_vote_for ('les-chasseurs-d-immunite','lea-2-2024','lea-2024','blanc-2024', 38, 'effectif');
call first_vote_for ('les-chasseurs-d-immunite','sebastien-2024','lea-2024','blanc-2024', 38, 'effectif');
call first_vote_for ('les-chasseurs-d-immunite','aurelien-2024','lea-2024','blanc-2024', 38, 'effectif');
call first_vote_for ('les-chasseurs-d-immunite','oceane-2024','lea-2024','blanc-2024', 38, 'effectif');
call first_vote_for ('les-chasseurs-d-immunite','cecile-2024','lea-2024','blanc-2024', 38, 'effectif');
call first_vote_for ('les-chasseurs-d-immunite','david-2024','lea-2024','blanc-2024', 38, 'effectif');
call first_vote_for ('les-chasseurs-d-immunite','pauline-2024','lea-2024','blanc-2024', 38, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','lea-2024','blanc-2024',38,'deliberation-jury-final', @participant_team_id);
call create_participant_departure('les-chasseurs-d-immunite','meissa-2024','blanc-2024',38,'deliberation-jury-final', @participant_team_id);

call team_game_ranking ('blanc-2024','orientation-2024',1);

call team_game_ranking ('blanc-2024','poteaux-2024',1);

call fill_participant_longevity ('les-chasseurs-d-immunite','meissa-2024',2,1,38);
call fill_participant_longevity ('les-chasseurs-d-immunite','lea-2024',1,1,38);

call program_current_time ('les-chasseurs-d-immunite',38);
