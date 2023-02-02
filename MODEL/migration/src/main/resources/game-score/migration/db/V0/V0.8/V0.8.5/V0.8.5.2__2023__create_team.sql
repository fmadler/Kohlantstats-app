
call add_participant('le-feu-sacre', 'Julie', 'Debever', 'julie-2023', 'F', 33, null, 0, 'Essonne', 'Footballeuse');
-- Helena, 27 ans, kinésithérapeute en Belgique
call add_participant('le-feu-sacre', 'Helena', '', 'helena-2023', 'F', 27, null, 0, 'Belgique', 'Kinésithérapeute');
-- Anne-Sophie, 35 ans, professeur de Zumba en Meurthe-et-Moselle
call add_participant('le-feu-sacre', 'Anne-Sophie', '', 'anne-sophie-2023', 'F', 35, null, 0, 'Meurthe-et-Moselle', 'Professeur de Zumba');


-- Tania, 22 ans, diététicienne en Seine-Saint-Denis. Elle est la benjamin de la saison.
call add_participant('le-feu-sacre', 'Tania', '', 'tania-2023', 'F', 35, null, 0, 'Seine-Saint-Denis', 'Diététicienne');


call add_participant('le-feu-sacre', 'Clémence', '', 'clemence-2023', 'F', 27, null, 0, 'Charente-Maritime', 'Raccordeuse de fibre optique');
-- Clémence, 27 ans, raccordeuse de fibre optique en Charente-Maritime

call add_participant('le-feu-sacre', 'Laura', '', 'laura-2023', 'F', 32, null, 0, 'Charente-Maritime', 'Photographe aquatique');
-- Laura, 32 ans, photographe aquatique en Charente-Maritime

call add_participant('le-feu-sacre', 'Christine', '', 'christine-2023', 'F', 49, null, 0, 'Gironde', 'Éducatrice canine');
-- Christine, 49 ans, éducatrice canine en Gironde

call add_participant('le-feu-sacre', 'Élodie', '', 'elodie-2023', 'F', 35, null, 0, 'Belgique', 'Responsable marketing en jeux de société');
-- Élodie, 35 ans, responsable marketing en jeux de société en Belgique

call add_participant('le-feu-sacre', 'Grâce', '', 'grace-2023', 'F', 39, null, 0, 'Ain', 'Technicienne en plasturgie');
-- Grâce, 39 ans, technicienne en plasturgie dans l’Ain

call add_participant('le-feu-sacre', 'Célia', '', 'celia-2023', 'F', 49, null, 0, 'Calvados', 'Assistante familiale');
-- Célia, 49 ans, assistante familiale dans le Calvados.

call add_participant('le-feu-sacre', 'Nicolas', '', 'nicolas-2023', 'H', 43, null, 0, 'Corse', 'Entrepreneur');
-- Nicolas, 43 ans, un entrepreneur de Corse

call add_participant('le-feu-sacre', 'Gilles', '', 'gilles-2023', 'H', 31, null, 0, 'Nord', 'Maraîcher et éleveur bovin du Nord');
-- Gilles, 31 ans, un maraîcher et éleveur bovin du Nord

call add_participant('le-feu-sacre', 'Benjamin', '', 'benjamin-2023', 'H', 23, null, 0, 'Marseille', 'Marin à Marseille');
-- Benjamin, 23 ans, marin à Marseille

call add_participant('le-feu-sacre', 'Quentin', '', 'quentin-2023', 'H', 26, null, 0, 'Marseille', 'Marin à Marseille');
-- Quentin, 26 ans, un charpentier en Moselle

call add_participant('le-feu-sacre', 'Martin', '', 'martin-2023', 'H', 30, null, 0, 'Suisse', 'Fromager venu de Suisse qui a totalement changé de voie puisqu''il s''agit d''un ancien trader');
-- Martin, 30 ans, un fromage venu de Suisse qui a totalement changé de voie puisqu'il s'agit d'un ancien trader.

call add_participant('le-feu-sacre', 'Esteban', '', 'esteban-2023', 'H', 40, null, 0, 'Eure-et-Loir', 'Vendeur et démonstrateur');
-- Esteban, 40 ans, vendeur et démonstrateur dans l’Eure-et-Loir

call add_participant('le-feu-sacre', 'Alexandre', '', 'alexandre-2023', 'H', 40, null, 0, 'Seine-Maritime', 'Responsable logistique');
-- Alexandre, 34 ans, responsable logistique en Seine-Maritime

call add_participant('le-feu-sacre', 'Rudy', '', 'rudy-2023', 'H', 40, null, 0, 'Val-de-Marne', 'Conducteur de métro');
-- Rudy, 41 ans, conducteur de métro dans le Val-de-Marne

call add_participant('le-feu-sacre', 'Frédéric', '', 'frederic-2023', 'H', 33, null, 0, 'Hauts-de-Seine', 'Directeur commercial dans une société de conseil');
-- Frédéric, 33 ans, directeur commercial dans une société de conseil dans les Hauts-de-Seine.

call add_participant('le-feu-sacre', 'Emin', '', 'emin-2023', 'H', 56, null, 0, 'Belgique', 'directeur général d''une entreprise d''événementiel');
-- Emin, 56 ans, directeur général d'une entreprise d'événementiel en Belgique. Cela fait… 20 ans que le doyen de la saison s’inscrit à Koh-Lanta chaque année. Cette fois-ci, c'est la bonne !

call create_team('le-totem-maudit','Arrivée','arrivee-2022','Arrivée',1,1);


INSERT INTO `GS_TEAM_ENTRANCE_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Arrivée', 'arrivee');




call create_participant_entrance ('le-totem-maudit','alexandra-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','jean-philippe-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','ambre-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','stephanie-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','geraldine-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','louana-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','anne-sophie-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','jean-charles-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','pauline-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','francois-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','samira-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','maxime-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','benjamin-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','matteo-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','olga-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','colin-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','setha-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','celine-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','lili-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','fouzi-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','nicolas-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','bastien-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','franck-2022','arrivee-2022',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','yannick-2022','arrivee-2022',1,'arrivee', @participant_team_id);

INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Choix du chef adverse', 'determination-chef-adverse', 9, 1);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Bracelet maudit', 'bracelet-maudit', 2, 0);

call create_game('le-totem-maudit','Assemblage Puzzle Carre Homme','puzzle-carre-homme-2022','puzzle','individuel','capitaine',1,1,'determination-chef-adverse,bracelet-maudit','logique,rapidite,natation');
call create_game('le-totem-maudit','Assemblage Puzzle Carre Femme','puzzle-carre-femme-2022','puzzle','individuel','capitaine',1,1,'determination-chef-adverse,bracelet-maudit','logique,rapidite,natation');

call create_game_participation('alexandra-2022','arrivee-2022','puzzle-carre-femme-2022','participant','individuel',1,'determination-chef-adverse');
call create_game_participation('jean-philippe-2022','arrivee-2022','puzzle-carre-homme-2022','participant','individuel',1,'determination-chef-adverse');
call create_game_participation('ambre-2022','arrivee-2022','puzzle-carre-femme-2022','participant','individuel',2,'');
call create_game_participation('stephanie-2022','arrivee-2022','puzzle-carre-femme-2022','participant','individuel',3,'');
call create_game_participation('geraldine-2022','arrivee-2022','puzzle-carre-femme-2022','participant','individuel',4,'');
call create_game_participation('louana-2022','arrivee-2022','puzzle-carre-femme-2022','participant','individuel',5,'');
call create_game_participation('anne-sophie-2022','arrivee-2022','puzzle-carre-femme-2022','participant','individuel',6,'');
call create_game_participation('jean-charles-2022','arrivee-2022','puzzle-carre-homme-2022','participant','individuel',2,'');
call create_game_participation('pauline-2022','arrivee-2022','puzzle-carre-femme-2022','participant','individuel',7,'');
call create_game_participation('francois-2022','arrivee-2022','puzzle-carre-homme-2022','participant','individuel',3,'');
call create_game_participation('samira-2022','arrivee-2022','puzzle-carre-femme-2022','participant','individuel',8,'');
call create_game_participation('maxime-2022','arrivee-2022','puzzle-carre-homme-2022','participant','individuel',4,'');
call create_game_participation('benjamin-2022','arrivee-2022','puzzle-carre-homme-2022','participant','individuel',5,'');
call create_game_participation('matteo-2022','arrivee-2022','puzzle-carre-homme-2022','participant','individuel',6,'');
call create_game_participation('olga-2022','arrivee-2022','puzzle-carre-femme-2022','participant','individuel',9,'');
call create_game_participation('colin-2022','arrivee-2022','puzzle-carre-homme-2022','participant','individuel',7,'');
call create_game_participation('setha-2022','arrivee-2022','puzzle-carre-femme-2022','participant','individuel',10,'');
call create_game_participation('celine-2022','arrivee-2022','puzzle-carre-femme-2022','participant','individuel',11,'');
call create_game_participation('lili-2022','arrivee-2022','puzzle-carre-femme-2022','participant','individuel',12,'bracelet-maudit');
call create_game_participation('fouzi-2022','arrivee-2022','puzzle-carre-homme-2022','participant','individuel',8,'');
call create_game_participation('nicolas-2022','arrivee-2022','puzzle-carre-homme-2022','participant','individuel',9,'');
call create_game_participation('bastien-2022','arrivee-2022','puzzle-carre-homme-2022','participant','individuel',10,'');
call create_game_participation('franck-2022','arrivee-2022','puzzle-carre-homme-2022','participant','individuel',11,'');
call create_game_participation('yannick-2022','arrivee-2022','puzzle-carre-homme-2022','participant','individuel',12,'bracelet-maudit');

call create_team('le-totem-maudit','Vert','vert-2022','Equipe verte',1,7);
call create_team('le-totem-maudit','Violet','violet-2022','Equipe violette',1,7);
call create_team('le-totem-maudit','Bleu','bleu-2022','Equipe bleue',1,7);

-- bleu napan

call create_participant_entrance ('le-totem-maudit','alexandra-2022','bleu-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','maxime-2022','bleu-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','fouzi-2022','bleu-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','colin-2022','bleu-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','olga-2022','bleu-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','geraldine-2022','bleu-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','samira-2022','bleu-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','benjamin-2022','bleu-2022',1,'constitution-des-equipes', @participant_team_id);


-- Vert ino

call create_participant_entrance ('le-totem-maudit','jean-philippe-2022','vert-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','francois-2022','vert-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','pauline-2022','vert-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','ambre-2022','vert-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','nicolas-2022','vert-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','franck-2022','vert-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','louana-2022','vert-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','lili-2022','vert-2022',1,'constitution-des-equipes', @participant_team_id);


-- Violet turung

call create_participant_entrance ('le-totem-maudit','celine-2022','violet-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','yannick-2022','violet-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','bastien-2022','violet-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','jean-charles-2022','violet-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','anne-sophie-2022','violet-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','setha-2022','violet-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','stephanie-2022','violet-2022',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','matteo-2022','violet-2022',1,'constitution-des-equipes', @participant_team_id);
