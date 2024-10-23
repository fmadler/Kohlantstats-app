call create_participant_realisation ('la-tribu-maudite','ugo-2012','blanc-2-2024',25,'decouverte-collier-immunite',@realisation_id);

call create_game('la-tribu-maudite','Tir à l''arc','tir-a-l-arc-2-2024','tir-a-l-arc','individuel','confort',23,25,'repas-sur-ile','precision,strategie');

call create_game_participation('ugo-2012','blanc-2-2024','tir-a-l-arc-2-2024','participant','individuel',8,'');
call create_game_participation('gustin-2024','blanc-2-2024','tir-a-l-arc-2-2024','participant','individuel',11,'totem');
call create_game_participation('maxim-2024','blanc-2-2024','tir-a-l-arc-2-2024','participant','individuel',10,'');
call create_game_participation('cecile-2-2024','blanc-2-2024','tir-a-l-arc-2-2024','participant','individuel',7,'');
call create_game_participation('cassandre-2024','blanc-2-2024','tir-a-l-arc-2-2024','participant','individuel',9,'');

call create_game_participation('frederic-2023','blanc-2-2024','tir-a-l-arc-2-2024','participant','individuel',1,'');
call create_game_participation('jacques-2024','blanc-2-2024','tir-a-l-arc-2-2024','participant','individuel',3,'');
call create_game_participation('thibault-2024','blanc-2-2024','tir-a-l-arc-2-2024','participant','individuel',2,'');
call create_game_participation('charlotte-2024','blanc-2-2024','tir-a-l-arc-2-2024','participant','individuel',4,'');
call create_game_participation('sophia-2024','blanc-2-2024','tir-a-l-arc-2-2024','participant','individuel',6,'');
call create_game_participation('ilyesse-2024','blanc-2-2024','tir-a-l-arc-2-2024','participant','individuel',5,'');

/*
- jour : 25
  - collier: ugo
- jour : 25
  - epreuve: tir à l'arc
    - recompense lasagnes, video message
    - gustin
    - maxim
    - cassandre
    - ugo
    - cecile
    - sophia
    - ilyesse
    - charlotte
    - jacques

    finale:
      - fred 1
      - thibault 2
*/
call create_participant_realisation ('la-tribu-maudite','maxim-2024','blanc-2-2024',26,'decouverte-collier-immunite',@realisation_id);

call create_game('la-tribu-maudite','Paresseux','paresseux-2-2024','paresseux','individuel','immunite',24,27,'confort','patience');

call create_game_participation('ugo-2012','blanc-2-2024','paresseux-2-2024','participant','individuel',3,'');
call create_game_participation('gustin-2024','blanc-2-2024','paresseux-2-2024','participant','individuel',10,'totem');
call create_game_participation('maxim-2024','blanc-2-2024','paresseux-2-2024','participant','individuel',6,'');
call create_game_participation('cecile-2-2024','blanc-2-2024','paresseux-2-2024','participant','individuel',7,'');
call create_game_participation('cassandre-2024','blanc-2-2024','paresseux-2-2024','participant','individuel',2,'');

call create_game_participation('frederic-2023','blanc-2-2024','paresseux-2-2024','participant','individuel',4,'');
call create_game_participation('jacques-2024','blanc-2-2024','paresseux-2-2024','participant','individuel',11,'');
call create_game_participation('thibault-2024','blanc-2-2024','paresseux-2-2024','participant','individuel',8,'');
call create_game_participation('charlotte-2024','blanc-2-2024','paresseux-2-2024','participant','individuel',1,'');
call create_game_participation('sophia-2024','blanc-2-2024','paresseux-2-2024','participant','individuel',5,'');
call create_game_participation('ilyesse-2024','blanc-2-2024','paresseux-2-2024','participant','individuel',6,'');

call create_participant_departure('la-tribu-maudite','frederic-2023','blanc-2-2024',27,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','frederic-2023',11,1,27);

call program_current_time ('les-chasseurs-d-immunite',27);

/*
- jour: 27
  - collier: maxim
  - epreuve : parresseux
    - jacques
    - gustin
    - thibault
    - cecile-2
    - ilyesse
    - maxime
    - sophia
    - fred
    - ugo
    - cassandre
    - charlotte
 - vote
    - jacques - ugo
    - gustin - ugo
    - thibault - ugo
    - cecile-2 - fred
    - ilyesse - ugo
    - maxime - fred
    - sophia - fred
    - fred - ugo
    - ugo - fred x2
    - cassandre- fred
    - charlotte - fred

*/
  
