call create_game('la-tribu-maudite','Parcours chargé en cinq étapes','parcours-charge-2-2024','parcours-charge','individuel','confort',33,37,'nuit-hotel-avec-un-proche','force,rapidite,strategie');

call create_game_participation('charlotte-2024','blanc-2-2024','parcours-charge-2-2024','participant','individuel',3,'');
call create_game_participation('ilyesse-2024','blanc-2-2024','parcours-charge-2-2024','participant','individuel',3,'');
call create_game_participation('cecile-2-2024','blanc-2-2024','parcours-charge-2-2024','participant','individuel',7,'');
call create_game_participation('jacques-2024','blanc-2-2024','parcours-charge-2-2024','participant','individuel',5,'');
call create_game_participation('ugo-2012','blanc-2-2024','parcours-charge-2-2024','participant','individuel',4,'');
call create_game_participation('thibault-2024','blanc-2-2024','parcours-charge-2-2024','participant','individuel',1,'');
call create_game_participation('sophia-2024','blanc-2-2024','parcours-charge-2-2024','participant','individuel',6,'');

/*
jour: 37
  - epreuve parcours 5 étapes chargé - soirée avec un proche
    - cecile
    - ilyesse
    - sophia
    - jacques
    - hugo
    - ilyesse
    - charlotte
    - thibault: victoire


 */
call create_game('la-tribu-maudite','Puzzle à l''aveugle','puzzle-aveugle-2-2024','puzzle','individuel','immunite',34,39,'totem,elimination-du-dernier','force,rapidite,strategie');

call create_game_participation('charlotte-2024','blanc-2-2024','puzzle-aveugle-2-2024','participant','individuel',5,'');
call create_game_participation('ilyesse-2024','blanc-2-2024','puzzle-aveugle-2-2024','participant','individuel',1,'');
call create_game_participation('cecile-2-2024','blanc-2-2024','puzzle-aveugle-2-2024','participant','individuel',6,'');
call create_game_participation('jacques-2024','blanc-2-2024','puzzle-aveugle-2-2024','participant','individuel',3,'');
call create_game_participation('ugo-2012','blanc-2-2024','puzzle-aveugle-2-2024','participant','individuel',4,'');
call create_game_participation('thibault-2024','blanc-2-2024','puzzle-aveugle-2-2024','participant','individuel',2,'');
call create_game_participation('sophia-2024','blanc-2-2024','puzzle-aveugle-2-2024','participant','individuel',7,'elimination-du-dernier');
call create_participant_departure('la-tribu-maudite','sophia-2024','blanc-2-2024',39,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','sophia-2024',7,1,39);

/*
jour: 38 (repo)
jour: 39:  
  - epreuve: puzzle à l'aveugle
    - ilyesse
    - thibault
    - jacques
    - ugo
    - charlotte
    - cecile
    - sophia (éliminée)

  - vote
    - ugo -> charlotte *2
    - cecile -> ugo
    - jacques -> ugo
    - ilyesse
    - thibault
    - 

  - depart ugo


 */

call create_participant_departure('la-tribu-maudite','ugo-2012','blanc-2-2024',39,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','ugo-2012',6,1,39);
