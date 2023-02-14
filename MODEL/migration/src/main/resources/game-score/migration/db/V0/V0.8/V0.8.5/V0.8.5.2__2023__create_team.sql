

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
