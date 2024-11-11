# binome
call create_game('la-tribu-maudite','Monte charge','xxx-2-2024','degustation','binome','confort',25,28,'excursion-chez-l-habitant','degustation,rapidite');
-- degustation + boue

call create_game_participation('ugo-2012','blanc-2-2024','xxx-2-2024','participant','binome',1,'excursion-chez-l-habitant');
call create_game_participation('ilyesse-2024','blanc-2-2024','xxx-2-2024','participant','binome',1,'excursion-chez-l-habitant');

call create_game_participation('gustin-2024','blanc-2-2024','xxx-2-2024','participant','binome',0,'totem');
call create_game_participation('maxim-2024','blanc-2-2024','xxx-2-2024','participant','binome',0,'');
call create_game_participation('cecile-2-2024','blanc-2-2024','xxx-2-2024','participant','binome',0,'');
call create_game_participation('cassandre-2024','blanc-2-2024','xxx-2-2024','participant','binome',0,'');

call create_game_participation('frederic-2023','blanc-2-2024','xxx-2-2024','participant','binome',0,'');
call create_game_participation('jacques-2024','blanc-2-2024','xxx-2-2024','participant','binome',0,'');
call create_game_participation('thibault-2024','blanc-2-2024','xxx-2-2024','participant','binome',0,'');
call create_game_participation('charlotte-2024','blanc-2-2024','xxx-2-2024','participant','binome',0,'');
call create_game_participation('sophia-2024','blanc-2-2024','xxx-2-2024','participant','binome',0,'');

/*
 - jour: 28
  - binome
    - ilyesse-ugo
    - gustin-charlotte
    - maxim-cassandre
    - jacques-cecile-2
    - sophia-thibault
  - jeu: guide aveugle
  - victoire:
    - ilyesse - ugo
    - confort: repas sur l ile, soirée, chez l habitant


 */

call create_game('la-tribu-maudite','Guide aveugle','guide-aveugle-2-2024','guide-aveugle','binome','immunite',26,29,'totem','orientation,guide,rapidite');
-- degustation + boue

call create_game_participation('ugo-2012','blanc-2-2024','guide-aveugle-2-2024','participant','binome',1,'excursion-chez-l-habitant');
call create_game_participation('ilyesse-2024','blanc-2-2024','guide-aveugle-2-2024','participant','binome',1,'excursion-chez-l-habitant');

call create_game_participation('gustin-2024','blanc-2-2024','guide-aveugle-2-2024','participant','binome',0,'totem');
call create_game_participation('maxim-2024','blanc-2-2024','guide-aveugle-2-2024','participant','binome',0,'');
call create_game_participation('cecile-2-2024','blanc-2-2024','guide-aveugle-2-2024','participant','binome',0,'');
call create_game_participation('cassandre-2024','blanc-2-2024','guide-aveugle-2-2024','participant','binome',0,'');

call create_game_participation('frederic-2023','blanc-2-2024','guide-aveugle-2-2024','participant','binome',0,'');
call create_game_participation('jacques-2024','blanc-2-2024','guide-aveugle-2-2024','participant','binome',0,'');
call create_game_participation('thibault-2024','blanc-2-2024','guide-aveugle-2-2024','participant','binome',0,'');
call create_game_participation('charlotte-2024','blanc-2-2024','guide-aveugle-2-2024','participant','binome',0,'');
call create_game_participation('sophia-2024','blanc-2-2024','guide-aveugle-2-2024','participant','binome',0,'');

/*
- jour: 29
  - epreuve : immunite: guide aveugle
    -victoire: ilyesse-ugo

- jour: 30
  -vote
    - ilyesse -> maxim
    - ugo -> jacques
    - gustin -> jacques
    - charlotte -> maxim
    - maxim -> jacques
    - cassandre -> jacques 
    - jacques -> maxim x2
    - cecile-3 -> maxim 
    - sophia -> maxim 
    - thibault -> maxim 

- maxim-cassandre eliminé

 */

call create_participant_departure('la-tribu-maudite','frederic-2023','blanc-2-2024',29,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','frederic-2023',10,1,29);


call create_participant_departure('la-tribu-maudite','frederic-2023','blanc-2-2024',29,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','frederic-2023',9,1,29);
call program_current_time ('la-tribu-maudite',29);
