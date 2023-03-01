call create_game('le-feu-sacre','Placement boules','placement-de-boules-2023','placement-de-boules','collectif','immunite',2,2,'totem','rapidite,force,precision');

call create_game_participation('helena-2023','rouge-2023','placement-de-boules-2023','participant','individuel',1,'totem');
call create_game_participation('julie-2023','rouge-2023','placement-de-boules-2023','participant','individuel',1,'totem');
call create_game_participation('christine-2023','rouge-2023','placement-de-boules-2023','participant','individuel',1,'totem');
call create_game_participation('anne-sophie-2023','rouge-2023','placement-de-boules-2023','participant','individuel',1,'totem');
call create_game_participation('elodie-2023','rouge-2023','placement-de-boules-2023','participant','individuel',1,'totem');
call create_game_participation('martin-2023','rouge-2023','placement-de-boules-2023','participant','individuel',1,'totem');
call create_game_participation('esteban-2023','rouge-2023','placement-de-boules-2023','participant','individuel',1,'totem');
call create_game_participation('alexandre-2023','rouge-2023','placement-de-boules-2023','participant','individuel',1,'totem');
call create_game_participation('rudy-2023','rouge-2023','placement-de-boules-2023','participant','individuel',1,'totem');
call create_game_participation('emin-2023','rouge-2023','placement-de-boules-2023','participant','individuel',1,'totem');

call create_game_participation('nicolas-2023','jaune-2023','placement-de-boules-2023','participant','individuel',2,'conseil');
call create_game_participation('grace-2023','jaune-2023','placement-de-boules-2023','participant','individuel',2,'conseil');
call create_game_participation('frederic-2023','jaune-2023','placement-de-boules-2023','participant','individuel',2,'conseil');
call create_game_participation('quentin-2023','jaune-2023','placement-de-boules-2023','participant','individuel',2,'conseil');
call create_game_participation('laura-2023','jaune-2023','placement-de-boules-2023','participant','individuel',2,'conseil');
call create_game_participation('gilles-2023','jaune-2023','placement-de-boules-2023','participant','individuel',2,'conseil');
call create_game_participation('tania-2023','jaune-2023','placement-de-boules-2023','participant','individuel',2,'conseil');
call create_game_participation('clemence-2023','jaune-2023','placement-de-boules-2023','participant','individuel',2,'conseil');
call create_game_participation('benjamin-2023','jaune-2023','placement-de-boules-2023','participant','individuel',2,'conseil');
call create_game_participation('celia-2023','jaune-2023','placement-de-boules-2023','participant','individuel',2,'conseil');

call team_game_ranking ('jaune-2023','placement-de-boules-2023',2);
call team_game_ranking ('rouge-2023','placement-de-boules-2023',1);

call first_vote_against ('le-feu-sacre','nicolas-2023','celia-2023','jaune-2023', 3, 'effectif');
call first_vote_against ('le-feu-sacre','grace-2023','celia-2023','jaune-2023', 3, 'effectif');
call first_vote_against ('le-feu-sacre','frederic-2023','tania-2023','jaune-2023', 3, 'effectif');
call first_vote_against ('le-feu-sacre','quentin-2023','celia-2023','jaune-2023', 3, 'effectif');
call first_vote_against ('le-feu-sacre','laura-2023','celia-2023','jaune-2023', 3, 'effectif');
call first_vote_against ('le-feu-sacre','gilles-2023','celia-2023','jaune-2023', 3, 'effectif');
call first_vote_against ('le-feu-sacre','tania-2023','celia-2023','jaune-2023', 3, 'effectif');
call first_vote_against ('le-feu-sacre','clemence-2023','celia-2023','jaune-2023', 3, 'effectif');
call first_vote_against ('le-feu-sacre','benjamin-2023','celia-2023','jaune-2023', 3, 'effectif');
call first_vote_against ('le-feu-sacre','celia-2023','clemence-2023','jaune-2023', 3, 'effectif');

call create_participant_departure('le-totem-maudit','celia-2023','jaune-2023',3,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','celia-2023',20,1,3);
