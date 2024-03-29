-- INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Destruction de cibles', 'destruction-cibles', NULL);
call create_game_type ('Destruction de cibles', 'destruction-cibles', NULL);

call create_game('le-feu-sacre','Destruction de cibles','destruction-cibles-2023','destruction-cibles','collectif','confort',3,4,'kit-peche','rapidite,force,precision');

-- 3 kg riz
call create_game_participation('helena-2023','rouge-2023','destruction-cibles-2023','participant','collectif',1,'kit-peche');
call create_game_participation('julie-2023','rouge-2023','destruction-cibles-2023','participant','collectif',1,'kit-peche');
call create_game_participation('christine-2023','rouge-2023','destruction-cibles-2023','participant','collectif',1,'kit-peche');
call create_game_participation('anne-sophie-2023','rouge-2023','destruction-cibles-2023','participant','collectif',1,'kit-peche');
call create_game_participation('elodie-2023','rouge-2023','destruction-cibles-2023','exclusion-apres-tirage-au-sort','collectif',1,'kit-peche');
call create_game_participation('martin-2023','rouge-2023','destruction-cibles-2023','participant','collectif',1,'kit-peche');
call create_game_participation('esteban-2023','rouge-2023','destruction-cibles-2023','participant','collectif',1,'kit-peche');
call create_game_participation('alexandre-2023','rouge-2023','destruction-cibles-2023','participant','collectif',1,'kit-peche');
call create_game_participation('rudy-2023','rouge-2023','destruction-cibles-2023','participant','collectif',1,'kit-peche');
call create_game_participation('emin-2023','rouge-2023','destruction-cibles-2023','participant','collectif',1,'kit-peche');

call create_game_participation('nicolas-2023','jaune-2023','destruction-cibles-2023','participant','collectif',2,'');
call create_game_participation('grace-2023','jaune-2023','destruction-cibles-2023','participant','collectif',2,'');
call create_game_participation('frederic-2023','jaune-2023','destruction-cibles-2023','participant','collectif',2,'');
call create_game_participation('quentin-2023','jaune-2023','destruction-cibles-2023','participant','collectif',2,'');
call create_game_participation('gilles-2023','jaune-2023','destruction-cibles-2023','participant','collectif',2,'');
call create_game_participation('tania-2023','jaune-2023','destruction-cibles-2023','participant','collectif',2,'');
call create_game_participation('clemence-2023','jaune-2023','destruction-cibles-2023','participant','collectif',2,'');
call create_game_participation('benjamin-2023','jaune-2023','destruction-cibles-2023','participant','collectif',2,'');
call create_game_participation('celia-2023','jaune-2023','destruction-cibles-2023','participant','collectif',2,'');

call team_game_ranking ('jaune-2023','destruction-cibles-2023',2);
call team_game_ranking ('rouge-2023','destruction-cibles-2023',1);

-- nicolas perd le talisman
-- nicolas choisit rudy pour porter le talisman

call create_game('le-feu-sacre','Flambeaux','flambeaux-2023','flambeaux','collectif','immunite',4,5,'totem','rapidite,force,precision');

call create_game_participation('helena-2023','rouge-2023','flambeaux-2023','participant','collectif',2,'');
call create_game_participation('julie-2023','rouge-2023','flambeaux-2023','participant','collectif',2,'');
call create_game_participation('christine-2023','rouge-2023','flambeaux-2023','participant','collectif',2,'');
call create_game_participation('anne-sophie-2023','rouge-2023','flambeaux-2023','participant','collectif',2,'');
call create_game_participation('elodie-2023','rouge-2023','flambeaux-2023','exclusion-apres-tirage-au-sort','collectif',2,'');
call create_game_participation('martin-2023','rouge-2023','flambeaux-2023','participant','collectif',2,'');
call create_game_participation('esteban-2023','rouge-2023','flambeaux-2023','participant','collectif',2,'');
call create_game_participation('alexandre-2023','rouge-2023','flambeaux-2023','participant','collectif',2,'');
call create_game_participation('rudy-2023','rouge-2023','flambeaux-2023','participant','collectif',2,'');
call create_game_participation('emin-2023','rouge-2023','flambeaux-2023','participant','collectif',2,'');

call create_game_participation('nicolas-2023','jaune-2023','flambeaux-2023','participant','collectif',1,'');
call create_game_participation('grace-2023','jaune-2023','flambeaux-2023','participant','collectif',1,'');
call create_game_participation('frederic-2023','jaune-2023','flambeaux-2023','participant','collectif',1,'');
call create_game_participation('quentin-2023','jaune-2023','flambeaux-2023','participant','collectif',1,'');
call create_game_participation('laura-2023','jaune-2023','flambeaux-2023','participant','collectif',1,'');
call create_game_participation('gilles-2023','jaune-2023','flambeaux-2023','participant','collectif',1,'');
call create_game_participation('tania-2023','jaune-2023','flambeaux-2023','participant','collectif',1,'');
call create_game_participation('clemence-2023','jaune-2023','flambeaux-2023','participant','collectif',1,'');
call create_game_participation('benjamin-2023','jaune-2023','flambeaux-2023','participant','collectif',1,'');

call team_game_ranking ('jaune-2023','flambeaux-2023',1);
call team_game_ranking ('rouge-2023','flambeaux-2023',2);

-- decouverte double vote pour emin

call first_vote_against ('le-feu-sacre','helena-2023','emin-2023','rouge-2023', 5, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','emin-2023','rouge-2023', 5, 'effectif');
call first_vote_against ('le-feu-sacre','christine-2023','emin-2023','rouge-2023', 5, 'effectif');
call first_vote_against ('le-feu-sacre','anne-sophie-2023','emin-2023','rouge-2023', 5, 'effectif');
call first_vote_against ('le-feu-sacre','elodie-2023','emin-2023','rouge-2023', 5, 'effectif');
call first_vote_against ('le-feu-sacre','martin-2023','emin-2023','rouge-2023', 5, 'effectif');
call first_vote_against ('le-feu-sacre','esteban-2023','emin-2023','rouge-2023', 5, 'effectif');
call first_vote_against ('le-feu-sacre','rudy-2023','emin-2023','rouge-2023', 5, 'effectif');
call first_vote_against ('le-feu-sacre','emin-2023','christine-2023','rouge-2023', 5, 'effectif');
call second_vote_against ('le-feu-sacre','emin-2023','christine-2023','rouge-2023', 5, 'effectif');

call create_participant_departure('le-feu-sacre','emin-2023','rouge-2023',5,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','emin-2023',19,1,5);

call program_current_time ('le-feu-sacre',5);
