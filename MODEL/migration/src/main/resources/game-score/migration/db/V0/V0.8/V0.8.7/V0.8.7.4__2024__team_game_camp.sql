-- jour 10
-- jour 10
call create_game_type ('Relier les cubes avec des amarres','cube-amarres','');
call create_game('la-tribu-maudite','Relier les cubes aux amarres','cube-amarres-2024','cube-amarres','collectif','confort',10,10,'nourriture','logique,rapidite');

call create_game_participation('ugo-2012','rouge-2-2024','cube-amarres-2024','participant','collectif',0,'');
call create_game_participation('gustin-2024','rouge-2-2024','cube-amarres-2024','participant','collectif',0,'');
call create_game_participation('alexandre-2024','rouge-2-2024','cube-amarres-2024','participant','collectif',0,'');
call create_game_participation('maxim-2024','rouge-2-2024','cube-amarres-2024','participant','collectif',0,'');
call create_game_participation('cecile-2-2024','rouge-2-2024','cube-amarres-2024','exclusion-apres-tirage-au-sort','collectif',0,'');
call create_game_participation('sarah-2-2024','rouge-2-2024','cube-amarres-2024','participant','collectif',0,'');
call create_game_participation('cassandre-2024','rouge-2-2024','cube-amarres-2024','exclusion-apres-tirage-au-sort','collectif',0,'');
call create_game_participation('marie-2024','rouge-2-2024','cube-amarres-2024','participant','collectif',0,'');
call create_game_participation('emmanuelle-2024','rouge-2-2024','cube-amarres-2024','participant','collectif',0,'');
call create_game_participation('maude-2024','rouge-2-2024','cube-amarres-2024','participant','collectif',1,'');

call create_game_participation('frederic-2023','jaune-2-2024','cube-amarres-2024','exclusion-apres-tirage-au-sort','collectif',1,'nourriture');
call create_game_participation('jacques-2024','jaune-2-2024','cube-amarres-2024','exclusion-apres-tirage-au-sort','collectif',1,'nourriture');
call create_game_participation('fabrice-2024','jaune-2-2024','cube-amarres-2024','participant','collectif',1,'nourriture');
call create_game_participation('thibault-2024','jaune-2-2024','cube-amarres-2024','participant','collectif',1,'nourriture');
call create_game_participation('michel-2024','jaune-2-2024','cube-amarres-2024','participant','collectif',1,'nourriture');
call create_game_participation('charlotte-2024','jaune-2-2024','cube-amarres-2024','participant','collectif',1,'nourriture');
call create_game_participation('lola-2024','jaune-2-2024','cube-amarres-2024','participant','collectif',1,'nourriture');
call create_game_participation('sophia-2024','jaune-2-2024','cube-amarres-2024','participant','collectif',1,'nourriture');
call create_game_participation('ilyesse-2024','jaune-2-2024','cube-amarres-2024','participant','collectif',1,'nourriture');



/*
  - epreuve : relier les cubes aux amarres; confort
    -recompense: marché nourriture
    - rouge :
      - excempte: cassandre
      - choix : cecile-2
    - jaune
      - exempte: jacques, frederic
      - victoire
  - epreuve : annito
    - tribu-maudite
      - trouvve: nathanael
  - epreuve duel: edifice 2 étages; duel
    - victoire: cecile-2+ collier-immunite
 */
call create_game('la-tribu-maudite','Placement de boules','placement-boules-2024','placement-de-pieces','collectif','confort',11,11,'nourriture','logique,rapidite');

call create_game_participation('ugo-2012','rouge-2-2024','placement-boules-2024','participant','collectif',0,'');
call create_game_participation('gustin-2024','rouge-2-2024','placement-boules-2024','participant','collectif',0,'');
call create_game_participation('alexandre-2024','rouge-2-2024','placement-boules-2024','participant','collectif',0,'');
call create_game_participation('maxim-2024','rouge-2-2024','placement-boules-2024','participant','collectif',0,'');
call create_game_participation('cecile-2-2024','rouge-2-2024','placement-boules-2024','exclusion-apres-tirage-au-sort','collectif',0,'');
call create_game_participation('sarah-2-2024','rouge-2-2024','placement-boules-2024','participant','collectif',0,'');
call create_game_participation('cassandre-2024','rouge-2-2024','placement-boules-2024','exclusion-apres-tirage-au-sort','collectif',0,'');
call create_game_participation('marie-2024','rouge-2-2024','placement-boules-2024','participant','collectif',0,'');
call create_game_participation('emmanuelle-2024','rouge-2-2024','placement-boules-2024','participant','collectif',0,'');
call create_game_participation('maude-2024','rouge-2-2024','placement-boules-2024','participant','collectif',1,'');

call create_game_participation('frederic-2023','jaune-2-2024','placement-boules-2024','participant','collectif',1,'nourriture');
call create_game_participation('jacques-2024','jaune-2-2024','placement-boules-2024','participant','collectif',1,'nourriture');
call create_game_participation('fabrice-2024','jaune-2-2024','placement-boules-2024','participant','collectif',1,'nourriture');
call create_game_participation('thibault-2024','jaune-2-2024','placement-boules-2024','exclusion-apres-tirage-au-sort','collectif',1,'nourriture');
call create_game_participation('michel-2024','jaune-2-2024','placement-boules-2024','exclusion-apres-tirage-au-sort','collectif',1,'nourriture');
call create_game_participation('charlotte-2024','jaune-2-2024','placement-boules-2024','participant','collectif',1,'nourriture');
call create_game_participation('lola-2024','jaune-2-2024','placement-boules-2024','participant','collectif',1,'nourriture');
call create_game_participation('sophia-2024','jaune-2-2024','placement-boules-2024','participant','collectif',1,'nourriture');
call create_game_participation('ilyesse-2024','jaune-2-2024','placement-boules-2024','participant','collectif',1,'nourriture');

/*
- jour: 11
 - epreuve: placement boule, immunite
   - recompense: totem
   - rouge
     - exempte: cassandre
     - victoire
   - jaune
     - exempte: thibaut, michel
- jour 12
 - vote
   - fred -> charlotte
   - fabrice -> lola
   - jacques -> charlotte
   - ilyesse -> lola
   - michel -> lola
   - lola -> michel
   - thibault -> charlotte
   - sophia -> michel
   - charlotte -> michel
- vote 2
   - fred -> lola
   - fabrice -> lola
   - jacques -> lola
   - ilyesse -> lola
   - michel -> lola
   - lola -> michel
   - thibault -> lola
   - sophia -> charlotte
   - charlotte -> lola

*/
call create_participant_departure('la-tribu-maudite','lola-2024','jaune-2-2024',12,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','lola-2024',19,1,12);
