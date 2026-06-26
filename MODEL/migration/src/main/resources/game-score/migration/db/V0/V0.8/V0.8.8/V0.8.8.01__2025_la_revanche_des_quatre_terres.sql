call create_programme('La revanche des quatre terres', 'la-revanche-des-quatre-terres', '2025', 26, 40, 'philippines', 'philippines', 1);

call create_team('la-revanche-des-quatre-terres','Nord','nord-2025','Silongan',1,15);
call create_team('la-revanche-des-quatre-terres','Sud','sud-2025','Timone',1,15);
call create_team('la-revanche-des-quatre-terres','Est','est-2025','Ilaga',1,15);
call create_team('la-revanche-des-quatre-terres','Ouest','ouest-2025','Kaluran',1,15);

call add_participant('la-tribu-maudite', 'Maxime', '', 'maxime-2025', 'H', 33, null, 0, 'Vosges', 'Responsable communication fédération de peche');
call create_participant_entrance ('la-revanche-des-quatre-terres','maxime-2025','est-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Gaelle', '', 'gaelle-2025', 'F', 34, null, 0, '', 'Mère au foyer');
call create_participant_entrance ('la-revanche-des-quatre-terres','gaelle-2025','est-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Benoît', '', 'benoit-2025', 'H', 24, null, 0, '', 'Sportif - perchiste');
call create_participant_entrance ('la-revanche-des-quatre-terres','benoit-2025','est-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Céline', '', 'celine-2025', 'F', 39, null, 0, '', 'Commerciale dans le sport');
call create_participant_entrance ('la-revanche-des-quatre-terres','celine-2025','est-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Louise', '', 'louise-2025', 'F', 24, null, 0, '', 'Ecogarde');
call create_participant_entrance ('la-revanche-des-quatre-terres','louise-2025','est-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'christian', '', 'christian-2025', 'H', 63, null, 0, 'Jura', 'Brocanteur');
call create_participant_entrance ('la-revanche-des-quatre-terres','benoit-christian-2025','est-2025',1,'arrivee', @participant_team_id);

/*
est: silongan : vert
  maxime
  gaelle : 34 ain, mère au foyer
  benoit: 24 ans, saut à la perche
  céline: 39, commerciale dans le soport, savoie
  maxime: resml sable communication fédération de peche: 33
  louise: écogarde 24 ans
  christian: 63, brocanteur: jura
 */
call add_participant('la-tribu-maudite', 'Pierre-Marie', '', 'pierre-marie-2025', 'H', 45, null, 0, 'Jura', 'Chef d''entreprise BTP');
call create_participant_entrance ('la-revanche-des-quatre-terres','pierre-marie-2025','sud-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Pauline', '', 'pauline-2025', 'F', 39, null, 0, 'Corse du sud', 'maitre nageuse');
call create_participant_entrance ('la-revanche-des-quatre-terres','pauline-2025','sud-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Jérome', '', 'jerome-2025', 'H', 43, null, 0, 'Pyrénées orientales', 'Peintre en bâtiment');
call create_participant_entrance ('la-revanche-des-quatre-terres','jerome-2025','sud-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Adrien', '', 'adrien-2025', 'H', 23, null, 0, 'Bouches du Rhône', 'Ingénieur');
call create_participant_entrance ('la-revanche-des-quatre-terres','adrien-2025','sud-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Jessica', '', 'jessica-2025', 'F', 34, null, 0, '', 'Restauratrice');
call create_participant_entrance ('la-revanche-des-quatre-terres','jessica-2025','sud-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Naïs', '', 'nais-2025', 'F', 25, null, 0, 'Marseille', 'éducatrice spécialisée');
call create_participant_entrance ('la-revanche-des-quatre-terres','nais-2025','sud-2025',1,'arrivee', @participant_team_id);

/*
sud: blue timone
  pierre-marie, chef d'entreprise btp
  pauline: maitre nageuse: 39: corse du sud
  jérome: peintre en batiment, 43 pyrénées orietnales
  adiren: ingénieur: 23: bouche du rhone
  jessica: 34, restauratrice
  nais: éducatrice spécialisée: 25, marseille
  */

call add_participant('la-tribu-maudite', 'Mael', '', 'mael-2025', 'H', 27, null, 0, 'Bretagne', 'Patissier');
call create_participant_entrance ('la-revanche-des-quatre-terres','mael-2025','ouest-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Noémie', '', 'noemie-2025', 'F', 32, null, 0, 'ille et vilaine', 'cheffe d''entreprise');
call create_participant_entrance ('la-revanche-des-quatre-terres','noemie-2025','ouest-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Mehdi', '', 'mehdi-2025', 'H', 27, null, 0, 'lot et garonne', 'chauffeur poids lourds');
call create_participant_entrance ('la-revanche-des-quatre-terres','mehdi-2025','ouest-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Romane', '', 'romane-2025', 'F', 20, null, 0, 'Nantes', 'Coach sportif');
call create_participant_entrance ('la-revanche-des-quatre-terres','romane-2025','ouest-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Jérome', '', 'jerome-2-2025', 'H', 52, null, 0, 'Landes', 'ex-militaire');
call create_participant_entrance ('la-revanche-des-quatre-terres','jerome-2-2025','ouest-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Cyinthiana', '', 'cyinthiana-2025', 'F', 39, null, 0, '', 'agent immobilier');
call create_participant_entrance ('la-revanche-des-quatre-terres','cyinthiana-2025','ouest-2025',1,'arrivee', @participant_team_id);

/*
ouest: orange: kaluran
  mael, patissier
  mehdi: chauffeur poids lourds, 27, lot et garonne
  néomei: 32, cheffe d'entreprise, ille et vilaine
  romane: 20 nantes coach sportif
  jerome: 52, ex-militaire, lande
  cyinthiana: 39 agent immobilier
*/

call add_participant('la-tribu-maudite', 'Allan', '', 'allan-2025', 'H', 25, null, 0, 'Dunkerque', 'Docker');
call create_participant_entrance ('la-revanche-des-quatre-terres','allan-2025','nord-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Mohamed', '', 'mohamed-2025', 'H', 30, null, 0, '', 'éducateur sportif');
call create_participant_entrance ('la-revanche-des-quatre-terres','mohamed-2025','nord-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Frédéric', '', 'frederic-2025', 'H', 56, null, 0, '77', 'directeur service sport');
call create_participant_entrance ('la-revanche-des-quatre-terres','frederic-2025','nord-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'andréa', '', 'andrea-2025', 'F', 24, null, 0, '', 'étudiante');
call create_participant_entrance ('la-revanche-des-quatre-terres','andrea-2025','nord-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Claire', '', 'claire-2025', 'F', 37, null, 0, '', 'scénographe produit');
call create_participant_entrance ('la-revanche-des-quatre-terres','claire-2025','nord-2025',1,'arrivee', @participant_team_id);

call add_participant('la-tribu-maudite', 'Joana', '', 'joana-2025', 'F', 32, null, 0, 'seine saint denis', 'gérante salon de beauté');
call create_participant_entrance ('la-revanche-des-quatre-terres','joana-2025','nord-2025',1,'arrivee', @participant_team_id);

/*
nord: ilaga violet
  allan, 25, docker dunkerque
  mohamed: 30: éducateur sportif
  frédéric: 56: directeur service sport: 77 seine et marne
  andréa: étudiant, 24
  claire, 37, scénographe produit
  joana: 32, gérante salon de beauté, seine saint denis
*/


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
call add_participant('la-revanche-des-quatre-terres', 'Ugo', 'xxx', 'ugo-2012', 'H', 42, null, 0, '', 'Responsable RH');
call add_participant('la-revanche-des-quatre-terres', 'Gustin', '', 'gustin-2024', 'M', 26, null, 0, 'Suisse', 'Maitre nageur');
call add_participant('la-revanche-des-quatre-terres', 'Alexandre', '', 'alexandre-2024', 'M', 33, null, 0, 'Paris', 'Ostéopathe');
call add_participant('la-revanche-des-quatre-terres', 'Maxim', '', 'maxim-2024', 'M', 28, null, 0, '', 'Livreur vélo');
call add_participant('la-revanche-des-quatre-terres', 'Ari', '', 'ari-2024', 'M', 51, null, 0, '', 'Chef d''entreprise');
call add_participant('la-revanche-des-quatre-terres', 'Cecile', '', 'cecile-2-2024', 'F', 41, null, 0, '', 'Professeur de pilates');
call add_participant('la-revanche-des-quatre-terres', 'Sarah', '', 'sarah-2-2024', 'F', 32, null, 0, 'Loire atlantique', 'Responsable merchandising');
call add_participant('la-revanche-des-quatre-terres', 'Cassandre', '', 'cassandre-2024', 'F', 23, null, 0, '', 'Autrice');
call add_participant('la-revanche-des-quatre-terres', 'Marie', '', 'marie-2024', 'F', 29, null, 0, '', 'Vendeuse d''action');
call add_participant('la-revanche-des-quatre-terres', 'Emmanuelle', '', 'emmanuelle-2024', 'F', 45, null, 0, '', 'Responsable qualité');
call add_participant('la-revanche-des-quatre-terres', 'Maude', '', 'maude-2024', 'F', 38, null, 0, '', 'Responsable commerciale');
call add_participant('la-revanche-des-quatre-terres', 'Nathanael', '', 'nathanael-2024', 'M', 27, null, 0, '', 'Cariste');
call add_participant('la-revanche-des-quatre-terres', 'Ilyesse', '', 'ilyesse-2024', 'M', 23, null, 0, '', 'Etudiant en ingénierie');

call add_participant('la-revanche-des-quatre-terres', 'Fréderic', 'xxx', 'frederic-2023', 'M', 39, null, 0, '', 'Restaurateur');
call add_participant('la-revanche-des-quatre-terres', 'Jacques', '', 'jacques-2024', 'H', 38, null, 0, '', 'Danseur');
call add_participant('la-revanche-des-quatre-terres', 'Thibault', '', 'thibault-2024', 'H', 34, null, 0, 'Corse', 'Agriculteur');
call add_participant('la-revanche-des-quatre-terres', 'Fabrice', '', 'fabrice-2024', 'H', 40, null, 0, '', 'Directeur de centre équestre');
call add_participant('la-revanche-des-quatre-terres', 'Michel', '', 'michel-2024', 'H', 36, null, 0, '', 'Responsable RH');
call add_participant('la-revanche-des-quatre-terres', 'Charlotte', '', 'charlotte-2024', 'F', 28, null, 0, 'Belgique', 'Médiatrice jeunesse');
call add_participant('la-revanche-des-quatre-terres', 'Lola', '', 'lola-2024', 'F', 25, null, 0, '', 'Kiné');
call add_participant('la-revanche-des-quatre-terres', 'Sophia', '', 'sophia-2024', 'F', 36, null, 0, '', 'Coach sportif');
call add_participant('la-revanche-des-quatre-terres', 'Cécile', '', 'cecile-3-2024', 'F', 34, null, 0, '', 'Hotesse de l''air');
call add_participant('la-revanche-des-quatre-terres', 'Vanessa', '', 'vanessa-2024', 'F', 39, null, 0, '', 'Danseuse et chorégraphe');
call add_participant('la-revanche-des-quatre-terres', 'Melissa', '', 'melissa-2024', 'F', 35, null, 0, '', 'GResponsable dans un supermarché');

call create_team('la-revanche-des-quatre-terres','Jaune','jaune-2-2024','Sabitang',1,22);
call create_team('la-revanche-des-quatre-terres','Rouge','rouge-2-2024','Pitogo',1,22);
call create_team('la-revanche-des-quatre-terres','Tribu maudite','tribu-maudite-2024','Tribu maudite',1,22);


call create_participant_entrance ('la-revanche-des-quatre-terres','ugo-2012','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','gustin-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','alexandre-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','maxim-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','ari-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','cecile-2-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','sarah-2-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','cassandre-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','marie-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','maude-2024','rouge-2-2024',1,'arrivee', @participant_team_id);

call create_participant_entrance ('la-revanche-des-quatre-terres','frederic-2023','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','jacques-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','thibault-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','fabrice-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','michel-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','charlotte-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','lola-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','sophia-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','cecile-3-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','emmanuelle-2024','jaune-2-2024',1,'arrivee', @participant_team_id);


call create_participant_entrance ('la-revanche-des-quatre-terres','melissa-2024','tribu-maudite-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','vanessa-2024','tribu-maudite-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','ilyesse-2024','tribu-maudite-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-revanche-des-quatre-terres','nathanael-2024','tribu-maudite-2024',1,'arrivee', @participant_team_id);
