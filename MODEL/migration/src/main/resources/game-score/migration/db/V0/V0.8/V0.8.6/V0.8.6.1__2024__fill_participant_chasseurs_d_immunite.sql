call create_programme('Les chasseurs d''immunite', 'les-chasseurs-d-immunite', '2024', 25, 38, 'philippines', 'philippines', 1);

call add_participant('les-chasseurs-d-immunite', 'Lea', 'xxx', 'lea-2024', 'F', 40, null, 0, '', 'Responsable RH');
call add_participant('les-chasseurs-d-immunite', 'Steve', 'xxx', 'steve-2024', 'M', 34, null, 0, '', 'Approvisionneur de distributeurs automatiques');
call add_participant('les-chasseurs-d-immunite', 'Ricky', '', 'ricky-2024', 'M', 23, null, 0, 'Pyrénées-Orientales', 'Assistant d''éducation');
call add_participant('les-chasseurs-d-immunite', 'Jean', '', 'jean-2024', 'M', 25, null, 0, 'Calvados', 'Charpentier');
call add_participant('les-chasseurs-d-immunite', 'Mégane', '', 'megane-2024', 'F', 28, null, 0, '', 'Commerciale');
call add_participant('les-chasseurs-d-immunite', 'Émilie', '', 'emilie-2024', 'F', 45, null, 0, '', 'Vendeuse en téléphonie');
call add_participant('les-chasseurs-d-immunite', 'Alicia', '', 'alicia-2024', 'F', 23, null, 0, '', 'Cheffe d''entreprise');
call add_participant('les-chasseurs-d-immunite', 'Meissa', '', 'meissa-2024', 'M', 34, null, 0, 'Haute Seine', 'Chargé de recouvrement');
call add_participant('les-chasseurs-d-immunite', 'David', '', 'david-2024', 'M', 36, null, 0, 'Alsace', 'Boucher');
call add_participant('les-chasseurs-d-immunite', 'Cécile', '', 'cecile-2024', 'F', 41, null, 0, '', 'Directrice d''implementation de restaurants');
call add_participant('les-chasseurs-d-immunite', 'Océane', '', 'oceane-2024', 'F', 35, null, 0, '', 'Gérante de société dans l''immobilier');
call add_participant('les-chasseurs-d-immunite', 'Maxime', '', 'maxime-2024', 'H', 43, null, 0, '', 'Ingénieur en éléctricité');
call add_participant('les-chasseurs-d-immunite', 'Amri', '', 'amri-2024', 'H', 42, null, 0, 'Seine-Saint-Denis', 'Gérant d''une salle de sport');
call add_participant('les-chasseurs-d-immunite', 'Pauline', '', 'pauline-2024', 'F', 29, null, 0, 'Haute Garonne', 'Gérante en Fromageries');
call add_participant('les-chasseurs-d-immunite', 'Aurélien', '', 'aurelien-2024', 'H', 34, null, 0, '', 'Agent Commercial immobilier');
call add_participant('les-chasseurs-d-immunite', 'Nathalie', '', 'nathalie-2024', 'F', 55, null, 0, '', 'Consultante en transition numérique');
call add_participant('les-chasseurs-d-immunite', 'Sarah', '', 'sarah-2024', 'F', 34, null, 0, 'Corse', 'Expert Comptable');
call add_participant('les-chasseurs-d-immunite', 'Sebastien', '', 'sebastien-2024', 'H', 30, null, 0, 'Pyrénées-Atlantiques', 'Charpentier');
call add_participant('les-chasseurs-d-immunite', 'Alexis', '', 'alexis-2024', 'H', 21, null, 0, 'Lot', 'Ex-militaire');
call add_participant('les-chasseurs-d-immunite', 'Julie', '', 'julie-2024', 'F', 37, null, 0, '', 'Gestion de taxis');

call create_team('les-chasseurs-d-immunite','Jaune','jaune-2024','Kadasi',1,22);
call create_team('les-chasseurs-d-immunite','Rouge','rouge-2024','Matukad',1,22);

call create_participant_entrance ('les-chasseurs-d-immunite','alexis-2024','jaune-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','amri-2024','jaune-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','pauline-2024','jaune-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','aurelien-2024','jaune-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','nathalie-2024','jaune-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','sarah-2024','jaune-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','oceane-2024','jaune-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','sebastien-2024','jaune-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','steve-2024','jaune-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','lea-2024','jaune-2024',1,'arrivee', @participant_team_id);

call create_participant_entrance ('les-chasseurs-d-immunite','ricky-2024','rouge-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','jean-2024','rouge-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','megane-2024','rouge-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','emilie-2024','rouge-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','alicia-2024','rouge-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','meissa-2024','rouge-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','david-2024','rouge-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','cecile-2024','rouge-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','julie-2024','rouge-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('les-chasseurs-d-immunite','maxime-2024','rouge-2024',1,'arrivee', @participant_team_id);

INSERT INTO `GS_EV_STORE` (`ENTITY_TYPE`, `ENTITY_WEB_PATH`, `ENTITY_ID`, `PROPERTY_ID`, `VALUE`) VALUES ('team', 'jaune-2024', -1, 4, 'kls-team-yellow');
INSERT INTO `GS_EV_STORE` (`ENTITY_TYPE`, `ENTITY_WEB_PATH`, `ENTITY_ID`, `PROPERTY_ID`, `VALUE`) VALUES ('team', 'rouge-2024', -1, 4, 'kls-team-rouge');
