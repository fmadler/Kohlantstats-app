call create_programme('La revanche des quatre terres', 'la-revanche-des-quatre-terre', '2025', 26, 40, 'philippines', 'philippines', 1);

est: silongan : vert
  maxime
  gaelle : 34 ain, mère au foyer
  benoit: 24 ans, saut à la perche
  céline: 39, commerciale dans le soport, savoie
  maxime: resml sable communication fédération de peche: 33
  louise: écogarde 24 ans
  christian: 63, brocanteur: jura
  
 sud: blue timone
  pierre-marie, chef d'entreprise btp
  pauline: maitre nageuse: 39: corse du sud
  jérome: peintre en batiment, 43 pyrénées orietnales
  adiren: ingénieur: 23: bouche du rhone
  jessica: 34, restauratrice
  nais: éducatrice spécialisée: 25, marseille
  

ouest: orange: kaluran
  mael, patissier
  mehdi: chauffeur poids lourds, 27, lot et garonne
  néomei: 32, cheffe d'entreprise, ille et vilaine
  romane: 20 nantes coach sportif
  jeromee: 52, ex-militaire, lande
  cyinthiana: 39 agent immobilier

nord: ilaga violet
  allan, 25, docker dunkerque
  mohamed: 30: éducateur sportif
  frédéreic: 56: directeur service sport: 77 seine et marne
  andréa: étudiant, 24
  claire, 37, scénographe produit
  joana: 32, gérante salon de beauté, seine saint denis



  -- elastique: confort: feu (3 allumettes), le riz, le dernier: sur l'ile de l'exil

  sud 1
  nord 2
  est 3
  ouest 4 -> ile de l'exil

  -- destruction de cibles 8: totem
  sud 1
  nord 2
  est 3
  ouest 4
  
  sortie :  cynthiana
  
-- epreuve placement de boule blanche 1
-- todo verifier age / profession
call add_participant('la-revanche-des-quatre-terre', 'Ugo', 'xxx', 'ugo-2012', 'H', 42, null, 0, '', 'Responsable RH');
call add_participant('la-revanche-des-quatre-terre', 'Gustin', '', 'gustin-2024', 'M', 26, null, 0, 'Suisse', 'Maitre nageur');
call add_participant('la-revanche-des-quatre-terre', 'Alexandre', '', 'alexandre-2024', 'M', 33, null, 0, 'Paris', 'Ostéopathe');
call add_participant('la-revanche-des-quatre-terre', 'Maxim', '', 'maxim-2024', 'M', 28, null, 0, '', 'Livreur vélo');
call add_participant('la-revanche-des-quatre-terre', 'Ari', '', 'ari-2024', 'M', 51, null, 0, '', 'Chef d''entreprise');
call add_participant('la-revanche-des-quatre-terre', 'Cecile', '', 'cecile-2-2024', 'F', 41, null, 0, '', 'Professeur de pilates');
call add_participant('la-revanche-des-quatre-terre', 'Sarah', '', 'sarah-2-2024', 'F', 32, null, 0, 'Loire atlantique', 'Responsable merchandising');
call add_participant('la-revanche-des-quatre-terre', 'Cassandre', '', 'cassandre-2024', 'F', 23, null, 0, '', 'Autrice');
call add_participant('la-revanche-des-quatre-terre', 'Marie', '', 'marie-2024', 'F', 29, null, 0, '', 'Vendeuse d''action');
call add_participant('la-revanche-des-quatre-terre', 'Emmanuelle', '', 'emmanuelle-2024', 'F', 45, null, 0, '', 'Responsable qualité');
call add_participant('la-revanche-des-quatre-terre', 'Maude', '', 'maude-2024', 'F', 38, null, 0, '', 'Responsable commerciale');
call add_participant('la-revanche-des-quatre-terre', 'Nathanael', '', 'nathanael-2024', 'M', 27, null, 0, '', 'Cariste');
call add_participant('la-revanche-des-quatre-terre', 'Ilyesse', '', 'ilyesse-2024', 'M', 23, null, 0, '', 'Etudiant en ingénierie');

call add_participant('la-revanche-des-quatre-terre', 'Fréderic', 'xxx', 'frederic-2023', 'M', 39, null, 0, '', 'Restaurateur');
call add_participant('la-revanche-des-quatre-terre', 'Jacques', '', 'jacques-2024', 'H', 38, null, 0, '', 'Danseur');
call add_participant('la-revanche-des-quatre-terre', 'Thibault', '', 'thibault-2024', 'H', 34, null, 0, 'Corse', 'Agriculteur');
call add_participant('la-revanche-des-quatre-terre', 'Fabrice', '', 'fabrice-2024', 'H', 40, null, 0, '', 'Directeur de centre équestre');
call add_participant('la-revanche-des-quatre-terre', 'Michel', '', 'michel-2024', 'H', 36, null, 0, '', 'Responsable RH');
call add_participant('la-revanche-des-quatre-terre', 'Charlotte', '', 'charlotte-2024', 'F', 28, null, 0, 'Belgique', 'Médiatrice jeunesse');
call add_participant('la-revanche-des-quatre-terre', 'Lola', '', 'lola-2024', 'F', 25, null, 0, '', 'Kiné');
call add_participant('la-revanche-des-quatre-terre', 'Sophia', '', 'sophia-2024', 'F', 36, null, 0, '', 'Coach sportif');
call add_participant('la-revanche-des-quatre-terre', 'Cécile', '', 'cecile-3-2024', 'F', 34, null, 0, '', 'Hotesse de l''air');
call add_participant('la-revanche-des-quatre-terre', 'Vanessa', '', 'vanessa-2024', 'F', 39, null, 0, '', 'Danseuse et chorégraphe');
call add_participant('la-revanche-des-quatre-terre', 'Melissa', '', 'melissa-2024', 'F', 35, null, 0, '', 'GResponsable dans un supermarché');

call create_team('la-revanche-des-quatre-terre','Jaune','jaune-2-2024','Sabitang',1,22);
call create_team('la-revanche-des-quatre-terre','Rouge','rouge-2-2024','Pitogo',1,22);
call create_team('la-revanche-des-quatre-terre','Tribu maudite','tribu-maudite-2024','Tribu maudite',1,22);


call create_participant_entrance ('la-revanche-des-quatre-terre','ugo-2012','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','gustin-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','alexandre-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','maxim-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','ari-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','cecile-2-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','sarah-2-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','cassandre-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','marie-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','maude-2024','rouge-2-2024',1,'arrivee', @participant_team_id);

call create_participant_entrance ('la-revanche-des-quatre-terre','frederic-2023','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','jacques-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','thibault-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','fabrice-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','michel-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','charlotte-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','lola-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','sophia-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','cecile-3-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','emmanuelle-2024','jaune-2-2024',1,'arrivee', @participant_team_id);


call create_participant_entrance ('la-revanche-des-quatre-terre','melissa-2024','tribu-maudite-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','vanessa-2024','tribu-maudite-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','ilyesse-2024','tribu-maudite-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terre','nathanael-2024','tribu-maudite-2024',1,'arrivee', @participant_team_id);
