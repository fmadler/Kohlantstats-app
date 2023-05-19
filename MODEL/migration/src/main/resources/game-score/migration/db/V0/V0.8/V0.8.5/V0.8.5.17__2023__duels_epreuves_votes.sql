call create_game('le-feu-sacre','Construction d''une tour','tour-puzzle-2023','puzzle','individuel','eliminatoire',23,31,'elimination-du-dernier,continuation-aventure','precision,logique,rapidite');

call create_game_participation('esteban-2023','blanc-2023','tour-puzzle-2023','participant','individuel',1,'continuation-aventure');
call create_game_participation('clemence-2023','blanc-2023','tour-puzzle-2023','participant','individuel',2,'elimination-du-dernier');

call create_participant_departure('le-feu-sacre','clemence-2023','blanc-2023',31,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','clemence-2023',8,1,31);

INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Immunité pour un autre aventurier', 'immunite-par-protection-d-un-aventurier', 1, 1);

call create_game('le-feu-sacre','Table bascule','table-bascule-2023','table-bascule','individuel','immunite',24,32,'talisman,immunite-par-protection-d-un-aventurier,vote-contre-soi','rapidite,dexterite,calme');

call create_game_participation('quentin-2023','blanc-2023','table-bascule-2023','participant','individuel',2,'');
call create_game_participation('laura-2023','blanc-2023','table-bascule-2023','participant','individuel',1,'talisman,immunite-par-protection-d-un-aventurier');
call create_game_participation('julie-2023','blanc-2023','table-bascule-2023','participant','individuel',5,'');
call create_game_participation('nicolas-2023','blanc-2023','table-bascule-2023','participant','individuel',4,'');
call create_game_participation('frederic-2023','blanc-2023','table-bascule-2023','participant','individuel',3,'');
call create_game_participation('tania-2023','blanc-2023','table-bascule-2023','participant','individuel',6,'vote-contre-soi');

call first_vote_against ('le-feu-sacre','frederic-2023','tania-2023','blanc-2023', 32, 'effectif');
call first_vote_against ('le-feu-sacre','quentin-2023','julie-2023','blanc-2023', 32, 'effectif');
call first_vote_against ('le-feu-sacre','nicolas-2023','tania-2023','blanc-2023', 32, 'effectif');
call first_vote_against ('le-feu-sacre','laura-2023','tania-2023','blanc-2023', 32, 'effectif');
call first_vote_against ('le-feu-sacre','tania-2023','quentin-2023','blanc-2023', 32, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','tania-2023','blanc-2023', 32, 'effectif');

-- laura protege quentin

call create_game('le-feu-sacre','Equilibre de poteries','poteries-suspendues-2023','poteries-suspendues','individuel','eliminatoire',25,33,'elimination-du-dernier,continuation-aventure','precision,logique,rapidite');

call create_game_participation('esteban-2023','blanc-2023','poteries-suspendues-2023','participant','individuel',2,'continuation-aventure');
call create_game_participation('tania-2023','blanc-2023','poteries-suspendues-2023','participant','individuel',1,'elimination-du-dernier');

call create_participant_departure('le-feu-sacre','esteban-2023','blanc-2023',33,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','esteban-2023',7,1,31);

call program_current_time ('le-feu-sacre',33);
