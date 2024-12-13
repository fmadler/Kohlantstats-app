
call create_game('la-tribu-maudite','Orientation','orientation-2-2024','orientation','individuel','finale',35,40,'poteaux,elimination-du-dernier','rapidite,tenacite,perseverance');

call create_game_participation('thibault-2024','blanc-2-2024','orientation-2-2024','participant','individuel',1,'poteaux');
call create_game_participation('ilyesse-2024','blanc-2-2024','orientation-2-2024','participant','individuel',2,'poteaux');
call create_game_participation('charlotte-2024','blanc-2-2024','orientation-2-2024','participant','individuel',3,'poteaux');
call create_game_participation('cecile-2-2024','blanc-2-2024','orientation-2-2024','participant','individuel',0,'elimination-du-dernier');
call create_game_participation('jacques-2024','blanc-2-2024','orientation-2-2024','participant','individuel',0,'elimination-du-dernier');


call create_participant_departure('la-tribu-maudite','cecile-2-2024','blanc-2-2024',40,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','cecile-2-2024',4,1,40);
call create_participant_departure('la-tribu-maudite','jacques-2024','blanc-2-2024',40,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','jacques-2024',4,1,40);

call create_game('la-tribu-maudite','Poteaux','poteaux-2-2024','poteaux','individuel','finale',36,41,'groupe-final','patience,equilibre');
/**/

call create_game_participation('thibault-2024','blanc-2-2024','poteaux-2-2024','participant','individuel',2,'groupe-final');
call create_game_participation('charlotte-2024','blanc-2-2024','poteaux-2-2024','participant','individuel',1,'groupe-final');
call create_game_participation('ilyesse-2024','blanc-2-2024','poteaux-2-2024','participant','individuel',3,'');

call create_participant_departure('la-tribu-maudite','ilyesse-2024','blanc-2-2024',41,'epreuve-poteaux', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','ilyesse-2024',3,1,41);

call first_vote_for ('la-tribu-maudite','ilyesse-2024','thibault-2024','blanc-2-2024', 41, 'effectif');
call first_vote_for ('la-tribu-maudite','gustin-2024','thibault-2024','blanc-2-2024', 41, 'effectif');
call first_vote_for ('la-tribu-maudite','ugo-2012','thibault-2024','blanc-2-2024', 41, 'effectif');
call first_vote_for ('la-tribu-maudite','maxim-2024','thibault-2024','blanc-2-2024', 41, 'effectif');
call first_vote_for ('la-tribu-maudite','cassandre-2024','charlotte-2024','blanc-2-2024', 41, 'effectif');
call first_vote_for ('la-tribu-maudite','jacques-2024','thibault-2024','blanc-2-2024', 41, 'effectif');
call first_vote_for ('la-tribu-maudite','sophia-2024','charlotte-2024','blanc-2-2024', 41, 'effectif');
call first_vote_for ('la-tribu-maudite','sarah-2-2024','charlotte-2024','blanc-2-2024', 41, 'effectif');
call first_vote_for ('la-tribu-maudite','maude-2024','charlotte-2024','blanc-2-2024', 41, 'effectif');
call first_vote_for ('la-tribu-maudite','frederic-2023','thibault-2024','blanc-2-2024', 41, 'effectif');
call first_vote_for ('la-tribu-maudite','cecile-2-2024','charlotte-2024','blanc-2-2024', 41, 'effectif');

call create_participant_departure('la-tribu-maudite','thibault-2024','blanc-2-2024',41,'deliberation-jury-final', @participant_team_id);
call create_participant_departure('la-tribu-maudite','charlotte-2024','blanc-2-2024',41,'deliberation-jury-final', @participant_team_id);

call team_game_ranking ('blanc-2-2024','orientation-2-2024',1);

call team_game_ranking ('blanc-2-2024','poteaux-2-2024',1);

call fill_participant_longevity ('la-tribu-maudite','charlotte-2024',2,1,41);
call fill_participant_longevity ('la-tribu-maudite','thibault-2024',1,1,41);

call program_current_time ('la-tribu-maudite',41);

