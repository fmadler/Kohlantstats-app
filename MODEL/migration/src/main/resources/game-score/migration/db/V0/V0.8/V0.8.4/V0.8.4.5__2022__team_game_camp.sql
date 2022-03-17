INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Renfort équipe par choix d''un coequipier adverse', 'renfort-equipe-par-coequipier-adverse', 2, 0);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Deforcement équipe par changement d''un coequipier', 'deforcement-equipe-par-changement-coequipier', 2, 0);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Découverte de la nature auprès d''un autoctone', 'initiation-nature', 5, 0);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Pierre à feu', 'pierre-a-feu', 1, 0);
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Toît et contre-poids', 'toit-et-contre-poids', NULL);

call create_game('le-totem-maudit','Toît et contre-poids','toit-et-contre-poids-2022','toit-et-contre-poids','collectif','confort',4,3,'renfort-equipe,deforcement-equipe,pierre-a-feu,initiation-nature','adresse,rapidite,equilibre');

call create_game_participation('alexandra-2022','bleu-2022','toit-et-contre-poids-2022','participant','collectif',2,'');
call create_game_participation('maxime-2022','bleu-2022','toit-et-contre-poids-2022','participant','collectif',2,'');
call create_game_participation('benjamin-2022','bleu-2022','toit-et-contre-poids-2022','participant','collectif',2,'');
call create_game_participation('fouzi-2022','bleu-2022','toit-et-contre-poids-2022','participant','collectif',2,'');
call create_game_participation('colin-2022','bleu-2022','toit-et-contre-poids-2022','participant','collectif',2,'');
call create_game_participation('olga-2022','bleu-2022','toit-et-contre-poids-2022','participant','collectif',2,'');
call create_game_participation('samira-2022','bleu-2022','toit-et-contre-poids-2022','exclusion-apres-tirage-au-sort','collectif',2,'');
call create_game_participation('geraldine-2022','bleu-2022','toit-et-contre-poids-2022','participant','collectif',2,'');

-- violet gagne confort + feu
call create_game_participation('yannick-2022','violet-2022','toit-et-contre-poids-2022','participant','collectif',1,'renfort-equipe-par-coequipier-adverse,pierre-a-feu,initiation-nature');
call create_game_participation('bastien-2022','violet-2022','toit-et-contre-poids-2022','participant','collectif',1,'renfort-equipe-par-coequipier-adverse,pierre-a-feu,initiation-nature');
call create_game_participation('jean-charles-2022','violet-2022','toit-et-contre-poids-2022','participant','collectif',1,'renfort-equipe-par-coequipier-adverse,pierre-a-feu,initiation-nature');
call create_game_participation('anne-sophie-2022','violet-2022','toit-et-contre-poids-2022','participant','collectif',1,'renfort-equipe-par-coequipier-adverse,pierre-a-feu,initiation-nature');
call create_game_participation('setha-2022','violet-2022','toit-et-contre-poids-2022','participant','collectif',1,'renfort-equipe-par-coequipier-adverse,pierre-a-feu,initiation-nature');
call create_game_participation('stephanie-2022','violet-2022','toit-et-contre-poids-2022','participant','collectif',1,'renfort-equipe-par-coequipier-adverse,pierre-a-feu,initiation-nature');
call create_game_participation('matteo-2022','violet-2022','toit-et-contre-poids-2022','participant','collectif',1,'renfort-equipe-par-coequipier-adverse,pierre-a-feu,initiation-nature');

call create_game_participation('jean-philippe-2022','vert-2022','toit-et-contre-poids-2022','participant','collectif',3,'deforcement-equipe-par-changement-coequipier');
call create_game_participation('francois-2022','vert-2022','toit-et-contre-poids-2022','participant','collectif',3,'deforcement-equipe-par-changement-coequipier');
call create_game_participation('pauline-2022','vert-2022','toit-et-contre-poids-2022','participant','collectif',3,'deforcement-equipe-par-changement-coequipier');
call create_game_participation('ambre-2022','vert-2022','toit-et-contre-poids-2022','participant','collectif',3,'deforcement-equipe-par-changement-coequipier');
call create_game_participation('nicolas-2022','vert-2022','toit-et-contre-poids-2022','participant','collectif',3,'deforcement-equipe-par-changement-coequipier');
call create_game_participation('franck-2022','vert-2022','toit-et-contre-poids-2022','participant','collectif',3,'deforcement-equipe-par-changement-coequipier');
call create_game_participation('louana-2022','vert-2022','toit-et-contre-poids-2022','participant','collectif',3,'deforcement-equipe-par-changement-coequipier');

call team_game_ranking ('violet-2022','toit-et-contre-poids-2022',1);
call team_game_ranking ('bleu-2022','toit-et-contre-poids-2022',2);
call team_game_ranking ('vert-2022','toit-et-contre-poids-2022',3);

-- depart de franck (abandon)
call create_participant_departure('le-totem-maudit','franck-2022','vert-2022',4,'abandon-volantaire', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','franck-2022',22,1,4);

-- violet feu
INSERT INTO `GS_TEAM_DEPARTURE_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Remplacement par choix de l''ésquipe adverse', 'remplacement-par-choix-equipe-adverse');
INSERT INTO `GS_TEAM_DEPARTURE_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Remplacement par choix d''ésquipe', 'remplacement-par-choix-equipe');
INSERT INTO `GS_TEAM_ENTRANCE_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Remplacement par choix de l''ésquipe adverse', 'remplacement-par-choix-equipe-adverse');
INSERT INTO `GS_TEAM_ENTRANCE_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Remplacement par choix d''ésquipe', 'remplacement-par-choix-equipe');

call create_participant_departure('le-totem-maudit','ambre-2022','vert-2022',4,'remplacement-par-choix-equipe-adverse', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','ambre-2022','violet-2022',4,'remplacement-par-choix-equipe-adverse', @participant_team_id);

-- setha vert
call create_participant_departure('le-totem-maudit','setha-2022','violet-2022',4,'remplacement-par-choix-equipe', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','setha-2022','vert-2022',4,'remplacement-par-choix-equipe', @participant_team_id);

INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Tourniquet', 'tourniquet', NULL);

call create_game('le-totem-maudit','Tourniquet','tourniquet-2022','tourniquet','collectif','confort',5,4,'totem,totem-maudit','construction,equilbre,rapidite,natation,relais');

call create_game_participation('alexandra-2022','bleu-2022','tourniquet-2022','participant','collectif',1,'totem');
call create_game_participation('maxime-2022','bleu-2022','tourniquet-2022','participant','collectif',1,'totem');
call create_game_participation('benjamin-2022','bleu-2022','tourniquet-2022','participant','collectif',1,'totem');
call create_game_participation('fouzi-2022','bleu-2022','tourniquet-2022','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('colin-2022','bleu-2022','tourniquet-2022','participant','collectif',1,'totem');
call create_game_participation('olga-2022','bleu-2022','tourniquet-2022','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('samira-2022','bleu-2022','tourniquet-2022','participant','collectif',1,'totem');
call create_game_participation('geraldine-2022','bleu-2022','tourniquet-2022','participant','collectif',1,'totem');

call create_game_participation('celine-2022','violet-2022','tourniquet-2022','participant','collectif',3,'conseil');
call create_game_participation('yannick-2022','violet-2022','tourniquet-2022','participant','collectif',3,'conseil');
call create_game_participation('bastien-2022','violet-2022','tourniquet-2022','exclusion-apres-tirage-au-sort','collectif',3,'conseil');
call create_game_participation('jean-charles-2022','violet-2022','tourniquet-2022','participant','collectif',3,'conseil');
call create_game_participation('anne-sophie-2022','violet-2022','tourniquet-2022','participant','collectif',3,'conseil');
call create_game_participation('matteo-2022','violet-2022','tourniquet-2022','participant','collectif',3,'conseil');
call create_game_participation('ambre-2022','violet-2022','tourniquet-2022','participant','collectif',2,'');

call create_game_participation('jean-philippe-2022','vert-2022','tourniquet-2022','participant','collectif',2,'');
call create_game_participation('francois-2022','vert-2022','tourniquet-2022','participant','collectif',2,'');
call create_game_participation('pauline-2022','vert-2022','tourniquet-2022','participant','collectif',2,'');
call create_game_participation('nicolas-2022','vert-2022','tourniquet-2022','participant','collectif',2,'');
call create_game_participation('louana-2022','vert-2022','tourniquet-2022','participant','collectif',2,'');
call create_game_participation('setha-2022','vert-2022','tourniquet-2022','participant','collectif',3,'conseil');

call first_vote_against ('le-totem-maudit','stephanie-2022','matteo-2022','violet-2022', 6, 'effectif');
call first_vote_against ('le-totem-maudit','yannick-2022','matteo-2022','violet-2022', 6, 'effectif');
call second_vote_against ('le-totem-maudit','yannick-2022','yannick-2022','violet-2022', 6, 'effectif');
call first_vote_against ('le-totem-maudit','bastien-2022','stephanie-2022','violet-2022', 6, 'effectif');
call first_vote_against ('le-totem-maudit','jean-charles-2022','stephanie-2022','violet-2022', 6, 'effectif');
call first_vote_against ('le-totem-maudit','anne-sophie-2022','matteo-2022','violet-2022', 6, 'effectif');
call first_vote_against ('le-totem-maudit','ambre-2022','matteo-2022','violet-2022', 6, 'effectif');
call first_vote_against ('le-totem-maudit','matteo-2022','stephanie-2022','violet-2022', 6, 'effectif');

call create_participant_departure('le-totem-maudit','matteo-2022','violet-2022',6,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','matteo-2022',21,1,6);

call program_current_time ('le-totem-maudit',6);
