
/*
- jour 13
  - epreuve : tribu maudite : cercle de pièce :
    -recompense: reintegraion tribu, depart avanture
    - tribu maudite :
    - victoire: melissa 1, emmanuelle 2

  - candidat
    - melissa 35 ans
    -  alex ostéo 33 ans
  - equipe
    - melissa : integre tribu rouge;
- emmanuelle : integre tribu jaune;
- alex : quitte l''avanture : abandon
*/
call create_participant_departure('la-tribu-maudite','melissa-2024','tribu-maudite-2024',13,'reintegration-aventure', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','melissa-2024','jaune-2-2024',13,'reintegration-aventure', @participant_team_id);

call create_participant_departure('la-tribu-maudite','emmanuelle-2024','tribu-maudite-2024',13,'reintegration-aventure', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','emmanuelle-2024','rouge-2-2024',13,'reintegration-aventure', @participant_team_id);

call create_participant_departure('la-tribu-maudite','nathanael-2024','tribu-maudite-2024',13,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','nathanael-2024',18,1,13);

call create_participant_departure('la-tribu-maudite','vanessa-2024','tribu-maudite-2024',13,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','vanessa-2024',17,1,13);

call create_participant_departure('la-tribu-maudite','alexandre-2024','rouge-2-2024',13,'abandon-volantaire', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','alexandre-2024',16,1,13);

call create_game('la-tribu-maudite','Poutre en equipe','poutre-2-2024','poutre','collectif','confort',15,14,'nourriture,massage,nuit-hotel','logique,rapidite');

call create_game_participation('ugo-2012','rouge-2-2024','poutre-2-2024','participant','collectif',1,'');
call create_game_participation('gustin-2024','rouge-2-2024','poutre-2-2024','participant','collectif',1,'');
call create_game_participation('maxim-2024','rouge-2-2024','poutre-2-2024','participant','collectif',1,'');
call create_game_participation('cecile-2-2024','rouge-2-2024','poutre-2-2024','participant','collectif',1,'');
call create_game_participation('sarah-2-2024','rouge-2-2024','poutre-2-2024','participant','collectif',1,'');
call create_game_participation('cassandre-2024','rouge-2-2024','poutre-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'');
call create_game_participation('marie-2024','rouge-2-2024','poutre-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'');
call create_game_participation('emmanuelle-2024','rouge-2-2024','poutre-2-2024','participant','collectif',1,'');
call create_game_participation('maude-2024','rouge-2-2024','poutre-2-2024','participant','collectif',1,'');

call create_game_participation('frederic-2023','jaune-2-2024','poutre-2-2024','participant','collectif',0,'nourriture');
call create_game_participation('jacques-2024','jaune-2-2024','poutre-2-2024','participant','collectif',0,'nourriture');
call create_game_participation('fabrice-2024','jaune-2-2024','poutre-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'nourriture');
call create_game_participation('thibault-2024','jaune-2-2024','poutre-2-2024','participant','collectif',0,'nourriture');
call create_game_participation('michel-2024','jaune-2-2024','poutre-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'nourriture');
call create_game_participation('charlotte-2024','jaune-2-2024','poutre-2-2024','participant','collectif',0,'nourriture');
call create_game_participation('sophia-2024','jaune-2-2024','poutre-2-2024','participant','collectif',0,'nourriture');
call create_game_participation('ilyesse-2024','jaune-2-2024','poutre-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'nourriture');
call create_game_participation('melissa-2024','jaune-2-2024','poutre-2-2024','participant','collectif',0,'nourriture');

/*
-jour: 14
  - epreuve: poutre lié
    - recompense: nourriture, massage, nuit
    - rouge
      - exempte: cassandre, emmanuelle
      - victoire
    - jaune
      - exempte: michel, ilyesse fabrice
*/
call create_game('la-tribu-maudite','Pierres apnée','pierre-apnee-2-2024','pierre-apnee','collectif','immunite',16,15,'totem','apnee,natation,rapidite');

call create_game_participation('ugo-2012','rouge-2-2024','pierre-apnee-2-2024','participant','collectif',1,'totem');
call create_game_participation('gustin-2024','rouge-2-2024','pierre-apnee-2-2024','participant','collectif',1,'totem');
call create_game_participation('maxim-2024','rouge-2-2024','pierre-apnee-2-2024','participant','collectif',1,'totem');
call create_game_participation('cecile-2-2024','rouge-2-2024','pierre-apnee-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('sarah-2-2024','rouge-2-2024','pierre-apnee-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('cassandre-2024','rouge-2-2024','pierre-apnee-2-2024','participant','collectif',1,'totem');
call create_game_participation('marie-2024','rouge-2-2024','pierre-apnee-2-2024','participant','collectif',1,'totem');
call create_game_participation('emmanuelle-2024','rouge-2-2024','pierre-apnee-2-2024','participant','collectif',1,'totem');
call create_game_participation('maude-2024','rouge-2-2024','pierre-apnee-2-2024','participant','collectif',1,'totem');

call create_game_participation('frederic-2023','jaune-2-2024','pierre-apnee-2-2024','participant','collectif',0,'conseil');
call create_game_participation('jacques-2024','jaune-2-2024','pierre-apnee-2-2024','participant','collectif',0,'conseil');
call create_game_participation('fabrice-2024','jaune-2-2024','pierre-apnee-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'conseil');
call create_game_participation('thibault-2024','jaune-2-2024','pierre-apnee-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'conseil');
call create_game_participation('michel-2024','jaune-2-2024','pierre-apnee-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'conseil');
call create_game_participation('charlotte-2024','jaune-2-2024','pierre-apnee-2-2024','participant','collectif',0,'conseil');
call create_game_participation('sophia-2024','jaune-2-2024','pierre-apnee-2-2024','participant','collectif',0,'conseil');
call create_game_participation('ilyesse-2024','jaune-2-2024','pierre-apnee-2-2024','participant','collectif',0,'conseil');
call create_game_participation('melissa-2024','jaune-2-2024','pierre-apnee-2-2024','participant','collectif',0,'conseil');

/*
-jour: 15
  - epreuve: pierre sous l''eau
    - recompense: totem
    - rouge
      - exempte: cecile, sarah
      - victoire
    - jaune
      - exempte: michel, thibaut fabrice
  - vote
    - fred -> melissa
    - fabrice -> melissa
    - jacques -> melissa
    - ilyesse -> melissa
    - michel -> melissa
    - thibault -> melissa
    - sophia -> michel
    - charlotte -> michel
    - melissa -> michel

depart michel
*/
call create_participant_departure('la-tribu-maudite','michel-2024','jaune-2-2024',16,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','michel-2024',15,1,16);

/*
- jour 16
  - epreuve: casse poterie sur plateforme
    - recompense: telephone, 1 kg de chocolat
    - rouge
      - exempte: cassandre, sarah
      - victoire
    - jaune
      - exempte: thibaut, frederic
*/
call create_reward ('Chocolat', 'chocolat', 'nourriture', 1);

call create_game('la-tribu-maudite','Poteries suspendues','poterie-suspendues-2-2024','poterie-suspendues','collectif','immunite',17,15,'telephone,chocolat','saut,natation,rapidite');

call create_game_participation('ugo-2012','rouge-2-2024','poterie-suspendues-2-2024','participant','collectif',1,'telephone,chocolat');
call create_game_participation('gustin-2024','rouge-2-2024','poterie-suspendues-2-2024','participant','collectif',1,'telephone,chocolat');
call create_game_participation('maxim-2024','rouge-2-2024','poterie-suspendues-2-2024','participant','collectif',1,'telephone,chocolat');
call create_game_participation('cecile-2-2024','rouge-2-2024','poterie-suspendues-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'telephone,chocolat');
call create_game_participation('sarah-2-2024','rouge-2-2024','poterie-suspendues-2-2024','participant','collectif',1,'telephone,chocolat');
call create_game_participation('cassandre-2024','rouge-2-2024','poterie-suspendues-2-2024','participant','collectif',1,'telephone,chocolat');
call create_game_participation('marie-2024','rouge-2-2024','poterie-suspendues-2-2024','participant','collectif',1,'telephone,chocolat');
call create_game_participation('emmanuelle-2024','rouge-2-2024','poterie-suspendues-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'telephone,chocolat');
call create_game_participation('maude-2024','rouge-2-2024','poterie-suspendues-2-2024','participant','collectif',1,'telephone,chocolat');

call create_game_participation('frederic-2023','jaune-2-2024','poterie-suspendues-2-2024','participant','collectif',0,'');
call create_game_participation('jacques-2024','jaune-2-2024','poterie-suspendues-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'');
call create_game_participation('fabrice-2024','jaune-2-2024','poterie-suspendues-2-2024','participant','collectif',0,'');
call create_game_participation('thibault-2024','jaune-2-2024','poterie-suspendues-2-2024','participant','collectif',0,'');
call create_game_participation('charlotte-2024','jaune-2-2024','poterie-suspendues-2-2024','participant','collectif',0,'');
call create_game_participation('sophia-2024','jaune-2-2024','poterie-suspendues-2-2024','participant','collectif',0,'');
call create_game_participation('ilyesse-2024','jaune-2-2024','poterie-suspendues-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'');
call create_game_participation('melissa-2024','jaune-2-2024','poterie-suspendues-2-2024','participant','collectif',0,'');

/*
- jour 17
  - epreuve: fugitif et meute
    - recompense: totem
    - rouge
      - exempte: emmanuelle, cecile
      - victoire
    - jaune
      - exempte: ilyesse jacques
  - vote
    - fred -> melissa
    - fabrice -> melissa
    - jacques -> melissa
    - ilyesse -> charlotte
    - michel -> melissa
    - thibault -> melissa
    - sophia -> melissa
    - charlotte -> melissa
    - melissa -> frederic
*/
call create_game('la-tribu-maudite','Le fugitif','fugitif-2-2024','fugitif','collectif','immunite',18,17,'totem','course,force,coordination,rapidite');

call create_game_participation('ugo-2012','rouge-2-2024','fugitif-2-2024','participant','collectif',1,'totem');
call create_game_participation('gustin-2024','rouge-2-2024','fugitif-2-2024','participant','collectif',1,'totem');
call create_game_participation('maxim-2024','rouge-2-2024','fugitif-2-2024','participant','collectif',1,'totem');
call create_game_participation('cecile-2-2024','rouge-2-2024','fugitif-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('sarah-2-2024','rouge-2-2024','fugitif-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('cassandre-2024','rouge-2-2024','fugitif-2-2024','participant','collectif',1,'totem');
call create_game_participation('marie-2024','rouge-2-2024','fugitif-2-2024','participant','collectif',1,'totem');
call create_game_participation('emmanuelle-2024','rouge-2-2024','fugitif-2-2024','participant','collectif',1,'totem');
call create_game_participation('maude-2024','rouge-2-2024','fugitif-2-2024','participant','collectif',1,'totem');

call create_game_participation('frederic-2023','jaune-2-2024','fugitif-2-2024','participant','collectif',0,'conseil');
call create_game_participation('jacques-2024','jaune-2-2024','fugitif-2-2024','participant','collectif',0,'conseil');
call create_game_participation('fabrice-2024','jaune-2-2024','fugitif-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'conseil');
call create_game_participation('thibault-2024','jaune-2-2024','fugitif-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'conseil');
call create_game_participation('charlotte-2024','jaune-2-2024','fugitif-2-2024','participant','collectif',0,'conseil');
call create_game_participation('sophia-2024','jaune-2-2024','fugitif-2-2024','participant','collectif',0,'conseil');
call create_game_participation('ilyesse-2024','jaune-2-2024','fugitif-2-2024','participant','collectif',0,'conseil');
call create_game_participation('melissa-2024','jaune-2-2024','fugitif-2-2024','participant','collectif',0,'conseil');

call create_participant_departure('la-tribu-maudite','melissa-2024','jaune-2-2024',16,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','melissa-2024',14,1,17);

call program_current_time ('la-tribu-maudite',17);
