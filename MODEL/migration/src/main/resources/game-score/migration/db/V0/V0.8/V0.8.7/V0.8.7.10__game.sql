
call create_game('la-tribu-maudite','Boue','boue-2-2024','boue','individuel','confort',27,31,'excursion-chez-l-habitant','rapidite');
call create_game_participation('ilyesse-2024','blanc-2-2024','boue-2-2024','participant','individuel',1,'excursion-chez-l-habitant');
call create_game_participation('charlotte-2024','blanc-2-2024','boue-2-2024','participant','individuel',0,'excursion-chez-l-habitant');
call create_game_participation('gustin-2024','blanc-2-2024','boue-2-2024','participant','individuel',0,'');
call create_game_participation('thibault-2024','blanc-2-2024','boue-2-2024','participant','individuel',0,'');
call create_game_participation('cecile-2-2024','blanc-2-2024','boue-2-2024','participant','individuel',0,'');
call create_game_participation('ugo-2012','blanc-2-2024','boue-2-2024','participant','individuel',0,'');
call create_game_participation('sophia-2024','blanc-2-2024','boue-2-2024','participant','individuel',0,'');
call create_game_participation('cassandre-2024','blanc-2-2024','boue-2-2024','participant','individuel',0,'');
call create_game_participation('jacques-2024','blanc-2-2024','boue-2-2024','participant','individuel',0,'');

call create_game('la-tribu-maudite','Duel puzzle','duel-puzzle-2-2024','puzzle','individuel','duel',28,32,'duel-de-reintegration','precision,rapidite');

call create_game_participation('cassandre-2024','blanc-2-2024','duel-puzzle-2-2024','participant','individuel',1,'continuation-aventure');
call create_game_participation('maxim-2024','blanc-2-2024','duel-puzzle-2-2024','participant','individuel',2,'');
call create_participant_departure('la-tribu-maudite','maxim-2024','blanc-2-2024',29,'exclusion-par-duel', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','maxim-2024',10,1,33);
/*
  - duel puzzle (tribu maudite)
    - cassandre (victoire)
    - maxime
  */
call create_game('la-tribu-maudite','Parcours puzzle','parcours-puzzle-2-2024','puzzle','individuel','immunite',29,33,'totem','precision,rapidite');

call create_game_participation('charlotte-2024','blanc-2-2024','parcours-puzzle-2-2024','participant','individuel',1,'totem');
call create_game_participation('gustin-2024','blanc-2-2024','parcours-puzzle-2-2024','participant','individuel',2,'');
call create_game_participation('thibault-2024','blanc-2-2024','parcours-puzzle-2-2024','participant','individuel',3,'');
call create_game_participation('ilyesse-2024','blanc-2-2024','parcours-puzzle-2-2024','participant','individuel',4,'');
call create_game_participation('cecile-2-2024','blanc-2-2024','parcours-puzzle-2-2024','participant','individuel',5,'');
call create_game_participation('ugo-2012','blanc-2-2024','parcours-puzzle-2-2024','participant','individuel',6,'');
call create_game_participation('sophia-2024','blanc-2-2024','parcours-puzzle-2-2024','participant','individuel',7,'');
call create_game_participation('cassandre-2024','blanc-2-2024','parcours-puzzle-2-2024','participant','individuel',8,'');
call create_game_participation('jacques-2024','blanc-2-2024','parcours-puzzle-2-2024','participant','individuel',9,'');

/*
- jour: 33
  - epreuve: parcours puzzle, vote contre soi
    - charlotte 1
    - gustin 2
    - thibault
    - ilyesse
    - cecile
    - hugo
    - sophia
    - cassandre
    - jacques

- vote
  - hugo -> gustin x2
  - cassandre -> gustin
  - jacques -> cassandre
  - charlotte -> cassandre
  - sophia -> cassandre
  - gustin-> cecile
  - cecile -> gustin

cassandre collier d'ugo
*/

call create_participant_departure('la-tribu-maudite','gustin-2024','blanc-2-2024',33,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','gustin-2024',9,1,33);
