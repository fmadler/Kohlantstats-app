
call create_game('le-feu-sacre','Orientation','orientation-2023','orientation','individuel','finale',29,39,'poteaux,elimination-du-dernier','rapidite,tenacite,perseverance');

call create_game_participation('julie-2023','blanc-2023','orientation-2023','participant','individuel',4,'elimination-du-dernier');
call create_game_participation('nicolas-2023','blanc-2023','orientation-2023','participant','individuel',1,'poteaux');
call create_game_participation('frederic-2023','blanc-2023','orientation-2023','participant','individuel',3,'poteaux');
call create_game_participation('tania-2023','blanc-2023','orientation-2023','participant','individuel',2,'poteaux');

call create_participant_departure('le-feu-sacre','julie-2023','blanc-2023',40,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','julie-2023',4,1,39);

call create_game('le-feu-sacre','Poteaux','poteaux-2023','poteaux','individuel','finale',29,40,'groupe-final','patience,equilibre');

call create_game_participation('nicolas-2023','blanc-2023','poteaux-2023','participant','individuel',3,'');
call create_game_participation('frederic-2023','blanc-2023','poteaux-2023','participant','individuel',1,'groupe-final');
call create_game_participation('tania-2023','blanc-2023','poteaux-2023','participant','individuel',2,'groupe-final');

call create_participant_departure('le-feu-sacre','nicolas-2023','blanc-2023',40,'epreuve-poteaux', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','nicolas-2023',3,1,40);

call first_vote_for ('le-feu-sacre','nicolas-2023','frederic-2023','blanc-2023', 40, 'effectif');
call first_vote_for ('le-feu-sacre','anne-sophie-2023','frederic-2023','blanc-2023', 40, 'effectif');
call first_vote_for ('le-feu-sacre','clemence-2023','frederic-2023','blanc-2023', 40, 'effectif');
call first_vote_for ('le-feu-sacre','helena-2023','frederic-2023','blanc-2023', 40, 'effectif');
call first_vote_for ('le-feu-sacre','laura-2023','frederic-2023','blanc-2023', 40, 'effectif');
call first_vote_for ('le-feu-sacre','quentin-2023','frederic-2023','blanc-2023', 40, 'effectif');
call first_vote_for ('le-feu-sacre','gilles-2023','frederic-2023','blanc-2023', 40, 'effectif');
call first_vote_for ('le-feu-sacre','esteban-2023','tania-2023','blanc-2023', 40, 'effectif');
call first_vote_for ('le-feu-sacre','julie-2023','tania-2023','blanc-2023', 40, 'effectif');

call create_participant_departure('le-feu-sacre','frederic-2023','blanc-2023',40,'deliberation-jury-final', @participant_team_id);
call create_participant_departure('le-feu-sacre','tania-2023','blanc-2023',40,'deliberation-jury-final', @participant_team_id);

call team_game_ranking ('blanc-2023','orientation-2023',1);

call team_game_ranking ('blanc-2023','poteaux-2023',1);

call fill_participant_longevity ('le-feu-sacre','tania-2023',2,1,40);
call fill_participant_longevity ('le-feu-sacre','frederic-2023',1,1,40);

call program_current_time ('le-feu-sacre',40);
