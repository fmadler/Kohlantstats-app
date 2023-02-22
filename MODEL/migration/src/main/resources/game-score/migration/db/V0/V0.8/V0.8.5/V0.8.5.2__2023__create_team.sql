call create_participant_entrance ('le-feu-sacre','julie-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','helena-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','anne-sophie-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','tania-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','clemence-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','laura-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','christine-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','elodie-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','grace-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','celia-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','nicolas-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','gilles-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','benjamin-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','quentin-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','martin-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','esteban-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','alexandre-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','rudy-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','frederic-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','emin-2023','arrivee-2023',1,'arrivee', @participant_team_id);

call create_game('le-feu-sacre','Parcours du combattant','parcours-du-combattant-2023','parcours-du-combattant','individuel','talisman,chef-equipe',1,1,'totem','rapidite,force,endurance');


/*
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Choix du chef adverse', 'determination-chef-adverse', 9, 1);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Bracelet maudit', 'bracelet-maudit', 2, 0);

call create_game('le-feu-sacre','Assemblage Puzzle Carre Homme','puzzle-carre-homme-2023','puzzle','individuel','capitaine',1,1,'determination-chef-adverse,bracelet-maudit','logique,rapidite,natation');
call create_game('le-feu-sacre','Assemblage Puzzle Carre Femme','puzzle-carre-femme-2023','puzzle','individuel','capitaine',1,1,'determination-chef-adverse,bracelet-maudit','logique,rapidite,natation');

call create_game_participation('alexandra-2023','arrivee-2023','puzzle-carre-femme-2023','participant','individuel',1,'determination-chef-adverse');
call create_game_participation('jean-philippe-2023','arrivee-2023','puzzle-carre-homme-2023','participant','individuel',1,'determination-chef-adverse');
call create_game_participation('ambre-2023','arrivee-2023','puzzle-carre-femme-2023','participant','individuel',2,'');
call create_game_participation('stephanie-2023','arrivee-2023','puzzle-carre-femme-2023','participant','individuel',3,'');
call create_game_participation('geraldine-2023','arrivee-2023','puzzle-carre-femme-2023','participant','individuel',4,'');
call create_game_participation('louana-2023','arrivee-2023','puzzle-carre-femme-2023','participant','individuel',5,'');
call create_game_participation('anne-sophie-2023','arrivee-2023','puzzle-carre-femme-2023','participant','individuel',6,'');
call create_game_participation('jean-charles-2023','arrivee-2023','puzzle-carre-homme-2023','participant','individuel',2,'');
call create_game_participation('pauline-2023','arrivee-2023','puzzle-carre-femme-2023','participant','individuel',7,'');
call create_game_participation('francois-2023','arrivee-2023','puzzle-carre-homme-2023','participant','individuel',3,'');
call create_game_participation('samira-2023','arrivee-2023','puzzle-carre-femme-2023','participant','individuel',8,'');
call create_game_participation('maxime-2023','arrivee-2023','puzzle-carre-homme-2023','participant','individuel',4,'');
call create_game_participation('benjamin-2023','arrivee-2023','puzzle-carre-homme-2023','participant','individuel',5,'');
call create_game_participation('matteo-2023','arrivee-2023','puzzle-carre-homme-2023','participant','individuel',6,'');
call create_game_participation('olga-2023','arrivee-2023','puzzle-carre-femme-2023','participant','individuel',9,'');
call create_game_participation('colin-2023','arrivee-2023','puzzle-carre-homme-2023','participant','individuel',7,'');
call create_game_participation('setha-2023','arrivee-2023','puzzle-carre-femme-2023','participant','individuel',10,'');
call create_game_participation('celine-2023','arrivee-2023','puzzle-carre-femme-2023','participant','individuel',11,'');
call create_game_participation('lili-2023','arrivee-2023','puzzle-carre-femme-2023','participant','individuel',12,'bracelet-maudit');
call create_game_participation('fouzi-2023','arrivee-2023','puzzle-carre-homme-2023','participant','individuel',8,'');
call create_game_participation('nicolas-2023','arrivee-2023','puzzle-carre-homme-2023','participant','individuel',9,'');
call create_game_participation('bastien-2023','arrivee-2023','puzzle-carre-homme-2023','participant','individuel',10,'');
call create_game_participation('franck-2023','arrivee-2023','puzzle-carre-homme-2023','participant','individuel',11,'');
call create_game_participation('yannick-2023','arrivee-2023','puzzle-carre-homme-2023','participant','individuel',12,'bracelet-maudit');

call create_team('le-feu-sacre','Vert','vert-2023','Equipe verte',1,7);
call create_team('le-feu-sacre','Violet','violet-2023','Equipe violette',1,7);
call create_team('le-feu-sacre','Bleu','bleu-2023','Equipe bleue',1,7);

-- bleu napan

call create_participant_entrance ('le-feu-sacre','alexandra-2023','bleu-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','maxime-2023','bleu-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','fouzi-2023','bleu-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','colin-2023','bleu-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','olga-2023','bleu-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','geraldine-2023','bleu-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','samira-2023','bleu-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','benjamin-2023','bleu-2023',1,'constitution-des-equipes', @participant_team_id);


-- Vert ino

call create_participant_entrance ('le-feu-sacre','jean-philippe-2023','vert-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','francois-2023','vert-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','pauline-2023','vert-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','ambre-2023','vert-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','nicolas-2023','vert-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','franck-2023','vert-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','louana-2023','vert-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','lili-2023','vert-2023',1,'constitution-des-equipes', @participant_team_id);


-- Violet turung

call create_participant_entrance ('le-feu-sacre','celine-2023','violet-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','yannick-2023','violet-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','bastien-2023','violet-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','jean-charles-2023','violet-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','anne-sophie-2023','violet-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','setha-2023','violet-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','stephanie-2023','violet-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','matteo-2023','violet-2023',1,'constitution-des-equipes', @participant_team_id);

 */
