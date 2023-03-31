INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Poulets rotis', 'poulets-rotis', 5, 1);
call create_game('le-feu-sacre','Régate','regate-2023','regate','collectif','confort',8,14,'poulets-rotis','rapidite,force,navigation,construction');


call create_game_participation('helena-2023','rouge-2-2023','regate-2023','participant','collectif',1,'poulets-rotis');
call create_game_participation('anne-sophie-2023','rouge-2-2023','regate-2023','participant','collectif',1,'poulets-rotis');
call create_game_participation('esteban-2023','rouge-2-2023','regate-2023','participant','collectif',1,'poulets-rotis');
call create_game_participation('quentin-2023','rouge-2-2023','regate-2023','participant','collectif',1,'poulets-rotis');
call create_game_participation('rudy-2023','rouge-2-2023','regate-2023','participant','collectif',1,'poulets-rotis');
call create_game_participation('frederic-2023','rouge-2-2023','regate-2023','participant','collectif',1,'poulets-rotis');
call create_game_participation('clemence-2023','rouge-2-2023','regate-2023','participant','collectif',1,'poulets-rotis');

call create_game_participation('nicolas-2023','jaune-2-2023','regate-2023','participant','collectif',2,'');
call create_game_participation('grace-2023','jaune-2-2023','regate-2023','participant','collectif',2,'');
call create_game_participation('laura-2023','jaune-2-2023','regate-2023','participant','collectif',2,'');
call create_game_participation('gilles-2023','jaune-2-2023','regate-2023','participant','collectif',2,'');
call create_game_participation('benjamin-2023','jaune-2-2023','regate-2023','participant','collectif',2,'');
call create_game_participation('martin-2023','jaune-2-2023','regate-2023','participant','collectif',2,'');
call create_game_participation('julie-2023','jaune-2-2023','regate-2023','participant','collectif',2,'');
call create_game_participation('christine-2023','jaune-2-2023','regate-2023','participant','collectif',2,'');


call team_game_ranking ('jaune-2-2023','regate-2023',2);
call team_game_ranking ('rouge-2-2023','regate-2023',1);

-- 14ème jour regate victoire rouge (confort)
-- 15 ème abandon benjamin
-- 16 ème tania revient jaune-2

call create_participant_departure ('le-feu-sacre','benjamin-2023','jaune-2-2023',15,'abandon-volantaire', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','benjamin-2023',15,1,15);

call create_participant_entrance ('le-feu-sacre','tania-2023','jaune-2-2023',16,'remplacement', @participant_team_id);

INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Placement de sacs sur une tour', 'placement-de-sacs-sur-tour', NULL);

call create_game('le-feu-sacre','placement-de-sacs-sur-tour','placement-de-sacs-sur-tour-2023','placement-de-sacs-sur-tour','collectif','immunite',9,16,'totem','rapidite,precision,coordination');

call create_game_participation('helena-2023','rouge-2-2023','placement-de-sacs-sur-tour-2023','participant','collectif',1,'');
call create_game_participation('anne-sophie-2023','rouge-2-2023','placement-de-sacs-sur-tour-2023','participant','collectif',1,'');
call create_game_participation('esteban-2023','rouge-2-2023','placement-de-sacs-sur-tour-2023','exclusion-apres-tirage-au-sort','collectif',1,'');
call create_game_participation('quentin-2023','rouge-2-2023','placement-de-sacs-sur-tour-2023','participant','collectif',1,'');
call create_game_participation('rudy-2023','rouge-2-2023','placement-de-sacs-sur-tour-2023','participant','collectif',1,'');
call create_game_participation('frederic-2023','rouge-2-2023','placement-de-sacs-sur-tour-2023','participant','collectif',1,'');
call create_game_participation('clemence-2023','rouge-2-2023','placement-de-sacs-sur-tour-2023','participant','collectif',1,'');

call create_game_participation('nicolas-2023','jaune-2-2023','placement-de-sacs-sur-tour-2023','participant','collectif',2,'totem');
call create_game_participation('grace-2023','jaune-2-2023','placement-de-sacs-sur-tour-2023','participant','collectif',2,'totem');
call create_game_participation('laura-2023','jaune-2-2023','placement-de-sacs-sur-tour-2023','exclusion-apres-tirage-au-sort','collectif',2,'totem');
call create_game_participation('gilles-2023','jaune-2-2023','placement-de-sacs-sur-tour-2023','participant','collectif',2,'totem');
call create_game_participation('tania-2023','jaune-2-2023','placement-de-sacs-sur-tour-2023','participant','collectif',2,'totem');
call create_game_participation('martin-2023','jaune-2-2023','placement-de-sacs-sur-tour-2023','participant','collectif',2,'totem');
call create_game_participation('julie-2023','jaune-2-2023','placement-de-sacs-sur-tour-2023','participant','collectif',2,'totem');
call create_game_participation('christine-2023','jaune-2-2023','placement-de-sacs-sur-tour-2023','exclusion-apres-tirage-au-sort','collectif',2,'totem');

-- 16 ème tour poids placement-de-sacs-sur-tour (immunite)


call team_game_ranking ('jaune-2-2023','placement-de-sacs-sur-tour-2023',1);
call team_game_ranking ('rouge-2-2023','placement-de-sacs-sur-tour-2023',2);
-- rouge esteban exclus-tirage-sort
-- jaune christine laura exclus

-- victoire jaune

call first_vote_against ('le-feu-sacre','helena-2023','rudy-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','quentin-2023','rudy-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','anne-sophie-2023','rudy-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','frederic-2023','rudy-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','clemence-2023','rudy-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','esteban-2023','frederic-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','rudy-2023','anne-sophie-2023','rouge-2-2023', 9, 'effectif');

-- fred donne le talisman à quentin



call create_participant_departure('le-feu-sacre','rudy-2023','rouge-2-2023',9,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','rudy-2023',14,1,16);

call program_current_time ('le-feu-sacre',16);
