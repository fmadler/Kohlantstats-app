call create_game('le-feu-sacre','Perche','perche-2023','perche','collectif','confort',10,16,'nuit-hotel','rapidite,dexterite,collaboration');


call create_game_participation('helena-2023','rouge-2-2023','perche-2023','participant','collectif',2,'');
call create_game_participation('anne-sophie-2023','rouge-2-2023','perche-2023','participant','collectif',2,'');
call create_game_participation('esteban-2023','rouge-2-2023','perche-2023','participant','collectif',2,'');
call create_game_participation('quentin-2023','rouge-2-2023','perche-2023','participant','collectif',2,'');
call create_game_participation('rudy-2023','rouge-2-2023','perche-2023','participant','collectif',2,'');
call create_game_participation('frederic-2023','rouge-2-2023','perche-2023','participant','collectif',2,'');
call create_game_participation('clemence-2023','rouge-2-2023','perche-2023','participant','collectif',2,'');

call create_game_participation('nicolas-2023','jaune-2-2023','perche-2023','participant','collectif',1,'nuit-hotel');
call create_game_participation('grace-2023','jaune-2-2023','perche-2023','participant','collectif',1,'nuit-hotel');
call create_game_participation('laura-2023','jaune-2-2023','perche-2023','exclusion-apres-tirage-au-sort','collectif',1,'nuit-hotel');
call create_game_participation('gilles-2023','jaune-2-2023','perche-2023','participant','collectif',1,'nuit-hotel');
call create_game_participation('martin-2023','jaune-2-2023','perche-2023','participant','collectif',1,'nuit-hotel');
call create_game_participation('tania-2023','jaune-2-2023','perche-2023','participant','collectif',1,'nuit-hotel');
call create_game_participation('julie-2023','jaune-2-2023','perche-2023','participant','collectif',1,'nuit-hotel');
call create_game_participation('christine-2023','jaune-2-2023','perche-2023','exclusion-apres-tirage-au-sort','collectif',1,'nuit-hotel');


call team_game_ranking ('jaune-2-2023','perche-2023',1);
call team_game_ranking ('rouge-2-2023','perche-2023',2);


-- 17 ème jour defi placement boule
INSERT INTO `GS_GAME_STAKE_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Talisman', 'talisman', 'Talisman');

call create_game('le-feu-sacre','Empilement boules','empilement-boules-2023','empilement-boules','individuel','talisman',11,17,'nuit-hotel','rapidite,dexterite,collaboration');
call create_game_participation('nicolas-2023','jaune-2-2023','empilement-boules-2023','participant','individuel',0,'');
call create_game_participation('grace-2023','jaune-2-2023','empilement-boules-2023','participant','individuel',0,'');
call create_game_participation('laura-2023','jaune-2-2023','empilement-boules-2023','participant','individuel',0,'');
call create_game_participation('gilles-2023','jaune-2-2023','empilement-boules-2023','participant','individuel',1,'talisman');
call create_game_participation('martin-2023','jaune-2-2023','empilement-boules-2023','participant','individuel',0,'');
call create_game_participation('tania-2023','jaune-2-2023','empilement-boules-2023','participant','individuel',0,'');
call create_game_participation('julie-2023','jaune-2-2023','empilement-boules-2023','participant','individuel',0,'');
call create_game_participation('christine-2023','jaune-2-2023','empilement-boules-2023','participant','individuel',0,'');


call create_participant_departure ('le-feu-sacre','martin-2023','jaune-2-2023',18,'abandon-medical', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','martin-2023',14,1,18);

call create_participant_entrance ('le-feu-sacre','rudy-2023','jaune-2-2023',19,'remplacement', @participant_team_id);


call create_game('le-feu-sacre','Catapulte','catapulte-2023','catapulte','collectif','immunite',12,18,'totem,conseil-immediat','rapidite,precision,coordination');

call create_game_participation('helena-2023','rouge-2-2023','catapulte-2023','participant','collectif',1,'totem');
call create_game_participation('anne-sophie-2023','rouge-2-2023','catapulte-2023','participant','collectif',1,'totem');
call create_game_participation('esteban-2023','rouge-2-2023','catapulte-2023','participant','collectif',1,'totem');
call create_game_participation('quentin-2023','rouge-2-2023','catapulte-2023','exclusion-par-choix-d-equipe','collectif',1,'totem');
call create_game_participation('rudy-2023','rouge-2-2023','catapulte-2023','participant','collectif',1,'totem');
call create_game_participation('frederic-2023','rouge-2-2023','catapulte-2023','participant','collectif',1,'totem');
call create_game_participation('clemence-2023','rouge-2-2023','catapulte-2023','participant','collectif',1,'totem');

call create_game_participation('nicolas-2023','jaune-2-2023','catapulte-2023','participant','collectif',2,'conseil-immediat');
call create_game_participation('grace-2023','jaune-2-2023','catapulte-2023','exclusion-apres-tirage-au-sort','collectif',2,'conseil-immediat');
call create_game_participation('laura-2023','jaune-2-2023','catapulte-2023','participant','collectif',2,'conseil-immediat');
call create_game_participation('gilles-2023','jaune-2-2023','catapulte-2023','participant','collectif',2,'conseil-immediat');
call create_game_participation('tania-2023','jaune-2-2023','catapulte-2023','participant','collectif',2,'conseil-immediat');
call create_game_participation('martin-2023','jaune-2-2023','catapulte-2023','participant','collectif',2,'conseil-immediat');
call create_game_participation('julie-2023','jaune-2-2023','catapulte-2023','exclusion-apres-tirage-au-sort','collectif',2,'conseil-immediat');
call create_game_participation('christine-2023','jaune-2-2023','catapulte-2023','participant','collectif',2,'conseil-immediat');


call team_game_ranking ('jaune-2-2023','catapulte-2023',2);
call team_game_ranking ('rouge-2-2023','catapulte-2023',1);

call first_vote_against ('le-feu-sacre','nicolas-2023','christine-2023','jaune-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','tania-2023','jaune-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','christine-2023','tania-2023','jaune-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','gilles-2023','christine-2023','jaune-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','laura-2023','christine-2023','jaune-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','tania-2023','christine-2023','jaune-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','grace-2023','christine-2023','jaune-2-2023', 9, 'effectif');


call create_participant_departure('le-feu-sacre','christine-2023','jaune-2-2023',9,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','christine-2023',13,1,18);

call program_current_time ('le-feu-sacre',18);
