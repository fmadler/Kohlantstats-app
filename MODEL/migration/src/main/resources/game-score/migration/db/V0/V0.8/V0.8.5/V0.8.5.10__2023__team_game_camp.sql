call create_reward ('Repas sur lagon', 'repas-sur-lagon', 'nourriture', 1);
call create_game('le-feu-sacre','Elastique','elastique-2023','elastique','collectif','confort',13,19,'repas-sur-lagon','force,coordination');


call create_game_participation('helena-2023','rouge-2-2023','elastique-2023','participant','collectif',2,'');
call create_game_participation('anne-sophie-2023','rouge-2-2023','elastique-2023','participant','collectif',2,'');
call create_game_participation('esteban-2023','rouge-2-2023','elastique-2023','participant','collectif',2,'');
call create_game_participation('quentin-2023','rouge-2-2023','elastique-2023','participant','collectif',2,'');
call create_game_participation('frederic-2023','rouge-2-2023','elastique-2023','participant','collectif',2,'');
call create_game_participation('clemence-2023','rouge-2-2023','elastique-2023','participant','collectif',2,'');

call create_game_participation('nicolas-2023','jaune-2-2023','elastique-2023','participant','collectif',1,'nuit-hotel');
call create_game_participation('grace-2023','jaune-2-2023','elastique-2023','participant','collectif',1,'nuit-hotel');
call create_game_participation('laura-2023','jaune-2-2023','elastique-2023','participant','collectif',1,'nuit-hotel');
call create_game_participation('gilles-2023','jaune-2-2023','elastique-2023','participant','collectif',1,'nuit-hotel');
call create_game_participation('rudy-2023','jaune-2-2023','elastique-2023','participant','collectif',1,'nuit-hotel');
call create_game_participation('tania-2023','jaune-2-2023','elastique-2023','participant','collectif',1,'nuit-hotel');
call create_game_participation('julie-2023','jaune-2-2023','elastique-2023','exclusion-apres-tirage-au-sort','collectif',1,'nuit-hotel');

call team_game_ranking ('jaune-2-2023','elastique-2023',1);
call team_game_ranking ('rouge-2-2023','elastique-2023',2);

call create_game('le-feu-sacre','Puzzle d''une tortue','puzzle-tortue-2023','puzzle','collectif','immunite',14,20,'totem,conseil-immediat','rapidite,logique,coordination');

call create_game_participation('helena-2023','rouge-2-2023','puzzle-tortue-2023','participant','collectif',1,'totem');
call create_game_participation('anne-sophie-2023','rouge-2-2023','puzzle-tortue-2023','participant','collectif',1,'totem');
call create_game_participation('esteban-2023','rouge-2-2023','puzzle-tortue-2023','participant','collectif',1,'totem');
call create_game_participation('quentin-2023','rouge-2-2023','puzzle-tortue-2023','exclusion-par-choix-d-equipe','collectif',1,'totem');
call create_game_participation('frederic-2023','rouge-2-2023','puzzle-tortue-2023','participant','collectif',1,'totem');
call create_game_participation('clemence-2023','rouge-2-2023','puzzle-tortue-2023','participant','collectif',1,'totem');

call create_game_participation('nicolas-2023','jaune-2-2023','puzzle-tortue-2023','participant','collectif',2,'conseil-immediat');
call create_game_participation('grace-2023','jaune-2-2023','puzzle-tortue-2023','exclusion-apres-tirage-au-sort','collectif',2,'conseil-immediat');
call create_game_participation('laura-2023','jaune-2-2023','puzzle-tortue-2023','exclusion-apres-tirage-au-sort','collectif',2,'conseil-immediat');
call create_game_participation('gilles-2023','jaune-2-2023','puzzle-tortue-2023','participant','collectif',2,'conseil-immediat');
call create_game_participation('tania-2023','jaune-2-2023','puzzle-tortue-2023','participant','collectif',2,'conseil-immediat');
call create_game_participation('rudy-2023','jaune-2-2023','puzzle-tortue-2023','participant','collectif',2,'conseil-immediat');
call create_game_participation('julie-2023','jaune-2-2023','puzzle-tortue-2023','participant','collectif',2,'conseil-immediat');


call team_game_ranking ('jaune-2-2023','puzzle-tortue-2023',2);
call team_game_ranking ('rouge-2-2023','puzzle-tortue-2023',1);

-- gilles donne le talisman à tania

call create_vote_effectiveness_type ('Annulé par talisman','annule-par-talisman');
call first_vote_against ('le-feu-sacre','nicolas-2023','rudy-2023','jaune-2-2023', 20, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','tania-2023','jaune-2-2023', 20, 'annule-par-talisman');
call first_vote_against ('le-feu-sacre','rudy-2023','tania-2023','jaune-2-2023', 20, 'annule-par-talisman');
call second_vote_against ('le-feu-sacre','rudy-2023','tania-2023','jaune-2-2023', 20, 'annule-par-talisman');
call first_vote_against ('le-feu-sacre','gilles-2023','rudy-2023','jaune-2-2023', 20, 'effectif');
call first_vote_against ('le-feu-sacre','laura-2023','rudy-2023','jaune-2-2023', 20, 'effectif');
call first_vote_against ('le-feu-sacre','tania-2023','rudy-2023','jaune-2-2023', 20, 'effectif');


call create_participant_departure('le-feu-sacre','rudy-2023','jaune-2-2023',20,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','rudy-2023',12,1,20);

call program_current_time ('le-feu-sacre',20);
