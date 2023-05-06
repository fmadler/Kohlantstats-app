25

call create_game('le-feu-sacre','Parcours en quatre étapes','parcours-quatre-etapes-2023','parcours-quatre-etapes','individuel','confort',16,25,'coraux-découverte,poisson','force,rapidite');


call create_game_participation('helena-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',4,'');
call create_game_participation('julie-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',3,'');
call create_game_participation('esteban-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',9,'');
call create_game_participation('nicolas-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',2,'');
call create_game_participation('frederic-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',5,'coraux-découverte,poisson');
call create_game_participation('quentin-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',1,'coraux-découverte,poisson');
call create_game_participation('gilles-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',7,'');
call create_game_participation('tania-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',9,'');
call create_game_participation('clemence-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',5,'');
call create_game_participation('laura-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',7,'');


-- fin des equipe blanc-2023 et blanc-2023




--
call create_game('le-feu-sacre','Relais aquatique','relais-aquatique-2023','pierre-apnee','individuel','immunite',8,11,'totem','rapidite,apnee,natation');

call create_game_participation('helena-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');
call create_game_participation('anne-sophie-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');
call create_game_participation('esteban-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');
call create_game_participation('quentin-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('rudy-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');
call create_game_participation('frederic-2023','blanc-2-2023','relais-aquatique-2023','exclusion-apres-tirage-au-sort','collectif',1,'');
call create_game_participation('tania-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('clemence-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',1,'');

call create_game_participation('nicolas-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('grace-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('laura-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('gilles-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('benjamin-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('martin-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');
call create_game_participation('julie-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');
call create_game_participation('christine-2023','blanc-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');

call team_game_ranking ('blanc-2-2023','relais-aquatique-2023',1);
call team_game_ranking ('blanc-2-2023','relais-aquatique-2023',2);


-- depart de tania
call first_vote_against ('le-feu-sacre','alexandre-2023','rudy-2023','blanc-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','helena-2023','alexandre-2023','blanc-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','elodie-2023','blanc-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','christine-2023','elodie-2023','blanc-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','anne-sophie-2023','alexandre-2023','blanc-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','elodie-2023','rudy-2023','blanc-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','martin-2023','elodie-2023','blanc-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','esteban-2023','alexandre-2023','blanc-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','rudy-2023','alexandre-2023','blanc-2-2023', 9, 'effectif');

call create_participant_departure('le-feu-sacre','alexandre-2023','blanc-2-2023',9,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','alexandre-2023',18,1,9);

call program_current_time ('le-feu-sacre',12);
