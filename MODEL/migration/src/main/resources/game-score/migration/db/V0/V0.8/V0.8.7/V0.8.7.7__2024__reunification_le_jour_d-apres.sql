call create_game('la-tribu-maudite','Parcours du combattant et labyrinthe','parcours-du-combattant-2-2024','parcours-du-combattant','individuel','immunite',20,21,'totem','force,rapidite');

call create_game_participation('ugo-2012','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',0,'');
call create_game_participation('gustin-2024','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',1,'totem');
call create_game_participation('maxim-2024','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',0,'');
call create_game_participation('cecile-2-2024','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',0,'');
call create_game_participation('sarah-2-2024','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',0,'');
call create_game_participation('cassandre-2024','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',2,'');
call create_game_participation('maude-2024','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',0, '');

call create_game_participation('frederic-2023','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',0,'');
call create_game_participation('jacques-2024','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',1,'');
call create_game_participation('fabrice-2024','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',0,'');
call create_game_participation('thibault-2024','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',0,'');
call create_game_participation('charlotte-2024','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',0,'');
call create_game_participation('sophia-2024','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',0,'');
call create_game_participation('ilyesse-2024','blanc-2-2024','parcours-du-combattant-2-2024','participant','individuel',0,'');

call create_participant_departure('la-tribu-maudite','fabrice-2024','blanc-2-2024',21,'exclusion-par-duel-apres-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','fabrice-2024',14,1,21);

/*

- jour: 21
  - epreuve : parcours du combattant
    - cassandre, sophia, charlotte sarha
    - gustin, ilyesse, ugo, frederic
    - vainqueur: gustin
- jour: 22
  - 6 / 6 x 2
  -vote: fabrice boule noire
*/
call create_reward('Repas sur une île','repas-sur-ile', 'nourriture',1);
call create_game('la-tribu-maudite','Grapin et trois pallets','grapin-trois-pallets-2024','grapin','individuel','confort',21,22,'repas-sur-ile,elimination-du-dernier','dexterite,rapidite');

call create_game_participation('ugo-2012','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',2,'');
call create_game_participation('gustin-2024','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',8,'');
call create_game_participation('maxim-2024','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',3,'');
call create_game_participation('cecile-2-2024','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',7,'');
call create_game_participation('sarah-2-2024','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',5,'');
call create_game_participation('cassandre-2024','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',10,'');
call create_game_participation('maude-2024','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',13, '');

call create_game_participation('frederic-2023','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',1,'repas-sur-ile');
call create_game_participation('jacques-2024','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',11,'repas-sur-ile');
call create_game_participation('thibault-2024','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',6,'');
call create_game_participation('charlotte-2024','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',9,'');
call create_game_participation('sophia-2024','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',12,'');
call create_game_participation('ilyesse-2024','blanc-2-2024','grapin-trois-pallets-2024','participant','individuel',4,'');

call create_participant_departure('la-tribu-maudite','maude-2024','blanc-2-2024',22,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','maude-2024',13,1,22);

/*
- jour 22:
  - epreuve: confort, 3 pallets: elimination du dernier
  - vainqueur:
    - fred!!
    - ugo
    - maxim
    - ilyesse
    - sarah
    - thibault
    - cecile
    - gustin
    - charlotte
    - cassandre
    - jacques!!
    - sophia
    - maud: eliminée

*/
call create_game('la-tribu-maudite','Bambou','bambou-2-2024','bambou','individuel','confort',22,23,'totem','patience,équilibre');

call create_game_participation('ugo-2012','blanc-2-2024','bambou-2-2024','participant','individuel',1,'totem');
call create_game_participation('gustin-2024','blanc-2-2024','bambou-2-2024','participant','individuel',7,'');
call create_game_participation('maxim-2024','blanc-2-2024','bambou-2-2024','participant','individuel',6,'');
call create_game_participation('cecile-2-2024','blanc-2-2024','bambou-2-2024','participant','individuel',10,'');
call create_game_participation('sarah-2-2024','blanc-2-2024','bambou-2-2024','participant','individuel',4,'');
call create_game_participation('cassandre-2024','blanc-2-2024','bambou-2-2024','participant','individuel',11,'');
call create_game_participation('maude-2024','blanc-2-2024','bambou-2-2024','participant','individuel',13, '');

call create_game_participation('frederic-2023','blanc-2-2024','bambou-2-2024','participant','individuel',2,'');
call create_game_participation('jacques-2024','blanc-2-2024','bambou-2-2024','participant','individuel',5,'');
call create_game_participation('thibault-2024','blanc-2-2024','bambou-2-2024','participant','individuel',3,'');
call create_game_participation('charlotte-2024','blanc-2-2024','bambou-2-2024','exempte-sur-raison-medicale','individuel',0,'');
call create_game_participation('sophia-2024','blanc-2-2024','bambou-2-2024','participant','individuel',9,'');
call create_game_participation('ilyesse-2024','blanc-2-2024','bambou-2-2024','participant','individuel',8,'');

call create_participant_departure('la-tribu-maudite','sarah-2-2024','blanc-2-2024',23,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','sarah-2-2024',12,1,23);

/*
- jour: 23
  - epreuve: charlotte -> infirmerie
  - bambou:
    - cassandre
    - cecile
    - sophia
    - ilyesse
    - gustin
    - maxim
    - jacques
    - sarah
    - thibault
    - fred
    - ugo: victoire!!

- jour: 24
  - vote:
    gustin -> sarah
    thibault -> sarah x2
    sophia -> s
    fred -> s
    jacques -> s
    ilyesse -> s
    charlotte pas de vote
    cecile -> fred
    cassandre -> fred
    ugo -> fred
    maxim -> fred
    sarah -> fred


sarah
*/
