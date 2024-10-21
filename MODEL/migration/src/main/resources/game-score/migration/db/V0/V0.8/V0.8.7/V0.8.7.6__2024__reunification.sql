/*
-jour: 18
- jeu:
  - morpion; recompense poulet roti
     -rouge :exempte
      cecile, emmanuelle
    - jaune :
      - jacques fabrice exempte
    - victoire : jaune
*/
call create_reward ('Poulet rôti', 'poulet-roti', 'nourriture', 1);

call create_game_type('Morpion','morpion','Jeu du morpion à la sauce Kohlanta');
call create_game('la-tribu-maudite','Morpion','morpion-2-2024','morpion','collectif','immunite',19,18,'poulet-roti','logique,rapidite');

call create_game_participation('ugo-2012','rouge-2-2024','morpion-2-2024','participant','collectif',0,'');
call create_game_participation('gustin-2024','rouge-2-2024','morpion-2-2024','participant','collectif',0,'');
call create_game_participation('maxim-2024','rouge-2-2024','morpion-2-2024','participant','collectif',0,'');
call create_game_participation('cecile-2-2024','rouge-2-2024','morpion-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'');
call create_game_participation('sarah-2-2024','rouge-2-2024','morpion-2-2024','participant','collectif',0,'');
call create_game_participation('cassandre-2024','rouge-2-2024','morpion-2-2024','participant','collectif',0,'');
call create_game_participation('emmanuelle-2024','rouge-2-2024','morpion-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'');
call create_game_participation('maude-2024','rouge-2-2024','morpion-2-2024','participant','collectif',0, '');

call create_game_participation('frederic-2023','jaune-2-2024','morpion-2-2024','participant','collectif',1,'poulet-roti');
call create_game_participation('jacques-2024','jaune-2-2024','morpion-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'poulet-roti');
call create_game_participation('fabrice-2024','jaune-2-2024','morpion-2-2024','participant','collectif',1,'poulet-roti');
call create_game_participation('thibault-2024','jaune-2-2024','morpion-2-2024','participant','collectif',1,'poulet-roti');
call create_game_participation('charlotte-2024','jaune-2-2024','morpion-2-2024','participant','collectif',1,'poulet-roti');
call create_game_participation('sophia-2024','jaune-2-2024','morpion-2-2024','participant','collectif',1,'poulet-roti');
call create_game_participation('ilyesse-2024','jaune-2-2024','morpion-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'poulet-roti');

call create_participant_departure('la-tribu-maudite','ugo-2012','rouge-2-2024',19,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure('la-tribu-maudite','gustin-2024','rouge-2-2024',19,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure('la-tribu-maudite','maxim-2024','rouge-2-2024',19,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure('la-tribu-maudite','cecile-2-2024','rouge-2-2024',19,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure('la-tribu-maudite','sarah-2-2024','rouge-2-2024',19,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure('la-tribu-maudite','cassandre-2024','rouge-2-2024',19,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure('la-tribu-maudite','maude-2024','rouge-2-2024',19,'recomposition-des-equipes', @participant_team_id);

call create_participant_departure('la-tribu-maudite','frederic-2023','jaune-2-2024',19,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure('la-tribu-maudite','jacques-2024','jaune-2-2024',19,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure('la-tribu-maudite','fabrice-2024','jaune-2-2024',19,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure('la-tribu-maudite','thibault-2024','jaune-2-2024',19,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure('la-tribu-maudite','charlotte-2024','jaune-2-2024',19,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure('la-tribu-maudite','sophia-2024','jaune-2-2024',19,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure('la-tribu-maudite','ilyesse-2024','jaune-2-2024',19,'recomposition-des-equipes', @participant_team_id);

call create_team('la-tribu-maudite','Blanc','blanc-2-2024','Blanc',19,40);

call create_participant_entrance('la-tribu-maudite','ugo-2012','blanc-2-2024',19,'reunification', @participant_team_id);
call create_participant_entrance('la-tribu-maudite','gustin-2024','blanc-2-2024',19,'reunification', @participant_team_id);
call create_participant_entrance('la-tribu-maudite','maxim-2024','blanc-2-2024',19,'reunification', @participant_team_id);
call create_participant_entrance('la-tribu-maudite','cecile-2-2024','blanc-2-2024',19,'reunification', @participant_team_id);
call create_participant_entrance('la-tribu-maudite','sarah-2-2024','blanc-2-2024',19,'reunification', @participant_team_id);
call create_participant_entrance('la-tribu-maudite','cassandre-2024','blanc-2-2024',19,'reunification', @participant_team_id);
call create_participant_entrance('la-tribu-maudite','maude-2024','blanc-2-2024',19,'reunification', @participant_team_id);

call create_participant_entrance('la-tribu-maudite','frederic-2023','blanc-2-2024',19,'reunification', @participant_team_id);
call create_participant_entrance('la-tribu-maudite','jacques-2024','blanc-2-2024',19,'reunification', @participant_team_id);
call create_participant_entrance('la-tribu-maudite','fabrice-2024','blanc-2-2024',19,'reunification', @participant_team_id);
call create_participant_entrance('la-tribu-maudite','thibault-2024','blanc-2-2024',19,'reunification', @participant_team_id);
call create_participant_entrance('la-tribu-maudite','charlotte-2024','blanc-2-2024',19,'reunification', @participant_team_id);
call create_participant_entrance('la-tribu-maudite','sophia-2024','blanc-2-2024',19,'reunification', @participant_team_id);
call create_participant_entrance('la-tribu-maudite','ilyesse-2024','blanc-2-2024',19,'reunification', @participant_team_id);

/*

- ambassadeur : 
  - jaune : sophia
  - rouge : gustin
  - depart: emmanuelle
- jour : 19
  - réunificiation
 */
call create_participant_departure('la-tribu-maudite','emmanuelle-2024','rouge-2-2024',19,'choix-des-ambassadeurs', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','emmanuelle-2024',15,1,19);

