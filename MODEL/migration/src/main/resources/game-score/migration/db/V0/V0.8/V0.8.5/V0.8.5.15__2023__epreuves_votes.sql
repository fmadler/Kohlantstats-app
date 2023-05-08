

INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Voyage pour deux personnes', 'voyage-deux-personnes', 5, 1);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Nourriture', 'nourriture', 5, 1);
call create_game('le-feu-sacre','Tir à l''arc','tir-a-l-arc-2023','tir-a-l-arc','individuel','confort',19,28,'nuit-hamac,telephone,nourriture,voyage-deux-personnes','precision,dexterite,strategie');


call create_game_participation('julie-2023','blanc-2023','tir-a-l-arc-2023','participant','individuel',5,'');
call create_game_participation('esteban-2023','blanc-2023','tir-a-l-arc-2023','participant','individuel',4,'');
call create_game_participation('nicolas-2023','blanc-2023','tir-a-l-arc-2023','participant','individuel',3,'nuit-hamac,telephone,nourriture');
call create_game_participation('frederic-2023','blanc-2023','tir-a-l-arc-2023','participant','individuel',6,'');
call create_game_participation('quentin-2023','blanc-2023','tir-a-l-arc-2023','participant','individuel',2,'');
call create_game_participation('gilles-2023','blanc-2023','tir-a-l-arc-2023','participant','individuel',1,'nuit-hamac,telephone,nourriture,voyage-deux-personnes');
call create_game_participation('tania-2023','blanc-2023','tir-a-l-arc-2023','participant','individuel',7,'');
call create_game_participation('clemence-2023','blanc-2023','tir-a-l-arc-2023','participant','individuel',9,'');
call create_game_participation('laura-2023','blanc-2023','tir-a-l-arc-2023','participant','individuel',8,'');


call create_game('le-feu-sacre','Equilibre sur l''eau','equilibre-sur-l-eau-2023','equilibre-sur-l-eau','individuel','immunite',20,29,'totem,vote-contre-soi','rapidite,force,equilibre');


call create_game_participation('julie-2023','blanc-2023','equilibre-sur-l-eau-2023','participant','individuel',7,'');
call create_game_participation('esteban-2023','blanc-2023','equilibre-sur-l-eau-2023','participant','individuel',9,'vote-contre-soi');
call create_game_participation('nicolas-2023','blanc-2023','equilibre-sur-l-eau-2023','participant','individuel',1,'totem');
call create_game_participation('frederic-2023','blanc-2023','equilibre-sur-l-eau-2023','participant','individuel',3,'');
call create_game_participation('quentin-2023','blanc-2023','equilibre-sur-l-eau-2023','participant','individuel',2,'');
call create_game_participation('gilles-2023','blanc-2023','equilibre-sur-l-eau-2023','participant','individuel',5,'');
call create_game_participation('tania-2023','blanc-2023','equilibre-sur-l-eau-2023','participant','individuel',7,'');
call create_game_participation('clemence-2023','blanc-2023','equilibre-sur-l-eau-2023','participant','individuel',1,'');
call create_game_participation('laura-2023','blanc-2023','equilibre-sur-l-eau-2023','participant','individuel',9,'vote-contre-soi');


/*
laura - laura
esteban - esteban

tania -
laura - gilles
julie - gilles
esteban - gilles
quentin - tania
clemence - gilles
clemence - gilles
frederic - tania
gilles - esteban


depart de gilles

 */


call first_vote_against ('le-feu-sacre','gilles-2023','esteban-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','frederic-2023','tania-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','quentin-2023','tania-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','clemence-2023','gilles-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','esteban-2023','helena-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','nicolas-2023','esteban-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','laura-2023','gilles-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','tania-2023','gilles-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','gilles-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','clemence-2023','gilles-2023','blanc-2023', 26, 'effectif');
call second_vote_against ('le-feu-sacre','clemence-2023','gilles-2023','blanc-2023', 26, 'effectif');

call create_participant_departure('le-feu-sacre','gilles-2023','blanc-2023',29,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','gilles-2023',9,1,29);

call program_current_time ('le-feu-sacre',26);
