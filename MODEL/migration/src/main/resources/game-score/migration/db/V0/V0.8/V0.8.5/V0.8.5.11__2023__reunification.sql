auenitn
grace
ambassadeur`

aller à la boule =>
quentin eliminé à la boule (boule noire)`

tribu blanche


-- grace abondonne
quentin reintegre

ambassadeur 23

24

call create_game('le-feu-sacre','Grappin','grappin-2023','grappin','individuel','totem',15,23,'totem,vote-contre-soi','adresse,dexterite');

clemence totem
gilles
frederic
nicolas
esteban
quentin
laura
helena
anne-sophie
tania
julie vote contre



--, vote
clemence julie
gilles anneso
frederic
nicolas anneso
esteban anneso
quentin tania
laura anneso
helena
anne-sophie tania
tania anne sophie
julie anne)so
julie -> julie

depart anne-sophie


call create_game_participation('helena-2023','rouge-2023','marcher-sur-l-eau-2023','participant','individuel',11,'');
call create_game_participation('julie-2023','rouge-2023','marcher-sur-l-eau-2023','participant','individuel',13,'');
call create_game_participation('christine-2023','rouge-2023','marcher-sur-l-eau-2023','participant','individuel',16,'');
call create_game_participation('anne-sophie-2023','rouge-2023','marcher-sur-l-eau-2023','participant','individuel',9,'');
call create_game_participation('elodie-2023','rouge-2023','marcher-sur-l-eau-2023','participant','individuel',17,'elimination-directe');
call create_game_participation('martin-2023','rouge-2023','marcher-sur-l-eau-2023','participant','individuel',10,'');
call create_game_participation('esteban-2023','rouge-2023','marcher-sur-l-eau-2023','participant','individuel',14,'');
call create_game_participation('rudy-2023','rouge-2023','marcher-sur-l-eau-2023','participant','individuel',15,'');

call create_game_participation('nicolas-2023','jaune-2023','marcher-sur-l-eau-2023','participant','individuel',5,'');
call create_game_participation('grace-2023','jaune-2023','marcher-sur-l-eau-2023','participant','individuel',4,'');
call create_game_participation('frederic-2023','jaune-2023','marcher-sur-l-eau-2023','participant','individuel',7,'');
call create_game_participation('quentin-2023','jaune-2023','marcher-sur-l-eau-2023','participant','individuel',12,'');
call create_game_participation('gilles-2023','jaune-2023','marcher-sur-l-eau-2023','exclusion-apres-tirage-au-sort','individuel',1,'capitaine');
call create_game_participation('tania-2023','jaune-2023','marcher-sur-l-eau-2023','participant','individuel',3,'');
call create_game_participation('clemence-2023','jaune-2023','marcher-sur-l-eau-2023','participant','individuel',2,'');
call create_game_participation('benjamin-2023','jaune-2023','marcher-sur-l-eau-2023','participant','individuel',7,'');
call create_game_participation('celia-2023','jaune-2023','marcher-sur-l-eau-2023','participant','individuel',1,'');
call create_game_participation('laura-2023','jaune-2023','marcher-sur-l-eau-2023','participant','individuel',6,'');

call create_participant_departure('le-feu-sacre','elodie-2023','rouge-2023',10,'elimination-directe', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','elodie-2023',17,1,9);

-- fin des equipe rouge-2023 et jaune-2023




--
call create_game('le-feu-sacre','Relais aquatique','relais-aquatique-2023','pierre-apnee','individuel','immunite',8,11,'totem','rapidite,apnee,natation');

call create_game_participation('helena-2023','rouge-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');
call create_game_participation('anne-sophie-2023','rouge-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');
call create_game_participation('esteban-2023','rouge-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');
call create_game_participation('quentin-2023','jaune-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('rudy-2023','jaune-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');
call create_game_participation('frederic-2023','jaune-2-2023','relais-aquatique-2023','exclusion-apres-tirage-au-sort','collectif',1,'');
call create_game_participation('tania-2023','jaune-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('clemence-2023','jaune-2-2023','relais-aquatique-2023','participant','collectif',1,'');

call create_game_participation('nicolas-2023','jaune-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('grace-2023','jaune-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('laura-2023','jaune-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('gilles-2023','jaune-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('benjamin-2023','jaune-2-2023','relais-aquatique-2023','participant','collectif',1,'');
call create_game_participation('martin-2023','jaune-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');
call create_game_participation('julie-2023','jaune-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');
call create_game_participation('christine-2023','jaune-2-2023','relais-aquatique-2023','participant','collectif',2,'totem');

call team_game_ranking ('jaune-2-2023','relais-aquatique-2023',1);
call team_game_ranking ('rouge-2-2023','relais-aquatique-2023',2);


-- depart de tania
call first_vote_against ('le-feu-sacre','alexandre-2023','rudy-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','helena-2023','alexandre-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','elodie-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','christine-2023','elodie-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','anne-sophie-2023','alexandre-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','elodie-2023','rudy-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','martin-2023','elodie-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','esteban-2023','alexandre-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','rudy-2023','alexandre-2023','rouge-2-2023', 9, 'effectif');

call create_participant_departure('le-feu-sacre','alexandre-2023','rouge-2-2023',9,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','alexandre-2023',18,1,9);

call program_current_time ('le-feu-sacre',12);