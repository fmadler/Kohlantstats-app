call create_game_type ('Marcher sur l eau', 'marcher-sur-l-eau', NULL);
-- INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Récolte de riz', 'recolte-riz', 5, 1);
call create_reward ('Récolte de riz', 'recolte-riz', 'nourriture', 1);
call create_game('le-feu-sacre','Marcher sur l''eau','marcher-sur-l-eau-2023','marcher-sur-l-eau','collectif','confort',5,7,'recolte-riz','rapidite,equilibre');

call create_game_participation('helena-2023','rouge-2023','marcher-sur-l-eau-2023','participant','collectif',2,'');
call create_game_participation('julie-2023','rouge-2023','marcher-sur-l-eau-2023','participant','collectif',2,'');
call create_game_participation('christine-2023','rouge-2023','marcher-sur-l-eau-2023','participant','collectif',2,'');
call create_game_participation('anne-sophie-2023','rouge-2023','marcher-sur-l-eau-2023','exclusion-apres-tirage-au-sort','collectif',2,'');
call create_game_participation('elodie-2023','rouge-2023','marcher-sur-l-eau-2023','participant','collectif',2,'');
call create_game_participation('martin-2023','rouge-2023','marcher-sur-l-eau-2023','participant','collectif',2,'');
call create_game_participation('esteban-2023','rouge-2023','marcher-sur-l-eau-2023','participant','collectif',2,'');
call create_game_participation('alexandre-2023','rouge-2023','marcher-sur-l-eau-2023','participant','collectif',2,'');
call create_game_participation('rudy-2023','rouge-2023','marcher-sur-l-eau-2023','participant','collectif',2,'');

call create_game_participation('nicolas-2023','jaune-2023','marcher-sur-l-eau-2023','participant','collectif',1,'recolte-riz');
call create_game_participation('grace-2023','jaune-2023','marcher-sur-l-eau-2023','participant','collectif',1,'recolte-riz');
call create_game_participation('frederic-2023','jaune-2023','marcher-sur-l-eau-2023','participant','collectif',1,'recolte-riz');
call create_game_participation('quentin-2023','jaune-2023','marcher-sur-l-eau-2023','participant','collectif',1,'recolte-riz');
call create_game_participation('gilles-2023','jaune-2023','marcher-sur-l-eau-2023','exclusion-apres-tirage-au-sort','collectif',1,'recolte-riz');
call create_game_participation('tania-2023','jaune-2023','marcher-sur-l-eau-2023','participant','collectif',1,'recolte-riz');
call create_game_participation('clemence-2023','jaune-2023','marcher-sur-l-eau-2023','participant','collectif',1,'recolte-riz');
call create_game_participation('benjamin-2023','jaune-2023','marcher-sur-l-eau-2023','participant','collectif',1,'recolte-riz');
call create_game_participation('celia-2023','jaune-2023','marcher-sur-l-eau-2023','participant','collectif',1,'recolte-riz');

call team_game_ranking ('jaune-2023','marcher-sur-l-eau-2023',1);
call team_game_ranking ('rouge-2023','marcher-sur-l-eau-2023',2);

-- rudy perd le talisman
-- rudy choisit tania pour porter le talisman

-- 9 ème matin
call create_game('le-feu-sacre','Reconstitution d''un puzzle avec des cordes','puzzle-corde-pieuvre-2023','puzzle-corde','collectif','immunite',6,9,'totem','rapidite,force,precision');

call create_game_participation('helena-2023','rouge-2023','puzzle-corde-pieuvre-2023','participant','collectif',2,'totem');
call create_game_participation('julie-2023','rouge-2023','puzzle-corde-pieuvre-2023','participant','collectif',2,'totem');
call create_game_participation('christine-2023','rouge-2023','puzzle-corde-pieuvre-2023','participant','collectif',2,'totem');
call create_game_participation('anne-sophie-2023','rouge-2023','puzzle-corde-pieuvre-2023','participant','collectif',2,'totem');
call create_game_participation('elodie-2023','rouge-2023','puzzle-corde-pieuvre-2023','exclusion-apres-tirage-au-sort','collectif',2,'totem');
call create_game_participation('martin-2023','rouge-2023','puzzle-corde-pieuvre-2023','participant','collectif',2,'totem');
call create_game_participation('esteban-2023','rouge-2023','puzzle-corde-pieuvre-2023','participant','collectif',2,'totem');
call create_game_participation('alexandre-2023','rouge-2023','puzzle-corde-pieuvre-2023','participant','collectif',2,'totem');
call create_game_participation('rudy-2023','rouge-2023','puzzle-corde-pieuvre-2023','participant','collectif',2,'totem');

call create_game_participation('nicolas-2023','jaune-2023','puzzle-corde-pieuvre-2023','participant','collectif',1,'');
call create_game_participation('grace-2023','jaune-2023','puzzle-corde-pieuvre-2023','participant','collectif',1,'');
call create_game_participation('frederic-2023','jaune-2023','puzzle-corde-pieuvre-2023','exclusion-apres-tirage-au-sort','collectif',1,'');
call create_game_participation('quentin-2023','jaune-2023','puzzle-corde-pieuvre-2023','participant','collectif',1,'');
call create_game_participation('laura-2023','jaune-2023','puzzle-corde-pieuvre-2023','participant','collectif',1,'');
call create_game_participation('gilles-2023','jaune-2023','puzzle-corde-pieuvre-2023','participant','collectif',1,'');
call create_game_participation('tania-2023','jaune-2023','puzzle-corde-pieuvre-2023','participant','collectif',1,'');
call create_game_participation('clemence-2023','jaune-2023','puzzle-corde-pieuvre-2023','participant','collectif',1,'');
call create_game_participation('benjamin-2023','jaune-2023','puzzle-corde-pieuvre-2023','participant','collectif',1,'');

call team_game_ranking ('jaune-2023','puzzle-corde-pieuvre-2023',1);
call team_game_ranking ('rouge-2023','puzzle-corde-pieuvre-2023',2);


-- talisman de tania pour christine
call first_vote_against ('le-feu-sacre','alexandre-2023','rudy-2023','rouge-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','helena-2023','alexandre-2023','rouge-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','elodie-2023','rouge-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','christine-2023','elodie-2023','rouge-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','anne-sophie-2023','alexandre-2023','rouge-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','elodie-2023','rudy-2023','rouge-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','martin-2023','elodie-2023','rouge-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','esteban-2023','alexandre-2023','rouge-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','rudy-2023','alexandre-2023','rouge-2023', 9, 'effectif');

call create_participant_departure('le-feu-sacre','alexandre-2023','rouge-2023',9,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','alexandre-2023',18,1,9);

call program_current_time ('le-feu-sacre',9);
