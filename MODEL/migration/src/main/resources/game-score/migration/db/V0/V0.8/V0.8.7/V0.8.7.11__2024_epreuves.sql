call create_game('la-tribu-maudite','Placement sac','placement-de-sacs-sur-tour-2-2024','placement-de-sacs-sur-tour','individuel','confort',30,35,'excursion-chez-l-habitant','precision,rapidite');

call create_game_participation('charlotte-2024','blanc-2-2024','placement-de-sacs-sur-tour-2-2024','participant','collectif',1,'excursion-chez-l-habitant');
call create_game_participation('ilyesse-2024','blanc-2-2024','placement-de-sacs-sur-tour-2-2024','participant','collectif',1,'excursion-chez-l-habitant');
call create_game_participation('cecile-2-2024','blanc-2-2024','placement-de-sacs-sur-tour-2-2024','participant','collectif',1,'excursion-chez-l-habitant');
call create_game_participation('jacques-2024','blanc-2-2024','placement-de-sacs-sur-tour-2-2024','participant','collectif',1,'excursion-chez-l-habitant');
call create_game_participation('ugo-2012','blanc-2-2024','placement-de-sacs-sur-tour-2-2024','participant','collectif',0,'');
call create_game_participation('thibault-2024','blanc-2-2024','placement-de-sacs-sur-tour-2-2024','participant','collectif',0,'');
call create_game_participation('sophia-2024','blanc-2-2024','placement-de-sacs-sur-tour-2-2024','participant','collectif',0,'');
call create_game_participation('cassandre-2024','blanc-2-2024','placement-de-sacs-sur-tour-2-2024','participant','collectif',0,'');

/*
- jour: 35
  - confort: 2 equipes de 4: placement de sac: decouverte village
  - cecile, hugo, thibault, cassandre
  - charlotte, ilyesse, jacques, sophia: victoire


 */
call create_game('la-tribu-maudite','Etoile','etoile-2-2024','etoile','individuel','immunite',31,36,'totem','patience,stabilité');

call create_game_participation('charlotte-2024','blanc-2-2024','etoile-2-2024','participant','individuel',6,'');
call create_game_participation('ilyesse-2024','blanc-2-2024','etoile-2-2024','participant','individuel',8,'');
call create_game_participation('cecile-2-2024','blanc-2-2024','etoile-2-2024','participant','individuel',4,'');
call create_game_participation('jacques-2024','blanc-2-2024','etoile-2-2024','participant','individuel',1,'');
call create_game_participation('ugo-2012','blanc-2-2024','etoile-2-2024','participant','individuel',7,'');
call create_game_participation('thibault-2024','blanc-2-2024','etoile-2-2024','participant','individuel',5,'');
call create_game_participation('sophia-2024','blanc-2-2024','etoile-2-2024','participant','individuel',3,'');
call create_game_participation('cassandre-2024','blanc-2-2024','etoile-2-2024','participant','individuel',2,'');

/*
- jour: 36
  -epreuve: etoile, immunite
  - ilyesse (dernier)
  - hugo
  - charlotte
  - thibault
  - cecile
  - sophia
  - cassandre
  - jacques
  - 

- jour: 36
  - vote: (collier hugo)
  - ilyesse -> hugo *2
  - hugo -> ilyesse
  - charlotte -> cassandre
  - thibault -> cassandre
  - cecile -> ilyesse
  - sophia -> cassandre
  - cassandre -> ilyesse
  - jacques -> cassandre

- 2ème vote
  - vote: (collier hugo)
  - ilyesse -> cassandre
  - hugo -> ilyesse
  - charlotte -> cassandre
  - thibault -> cassandre
  - cecile -> ilyesse
  - sophia -> cassandre
  - cassandre -> ilyesse
  - jacques -> cassandre

- depart cassandre
 */
call create_participant_departure('la-tribu-maudite','cassandre-2024','blanc-2-2024',36,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','cassandre-2024',8,1,36);
