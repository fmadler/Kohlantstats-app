-- 26

call create_game('le-feu-sacre','Etoile','etoile-2023','etoile','individuel','immunite',17,26,'collier-immunite,totem','endurance,patience,statique');


call create_game_participation('helena-2023','blanc-2023','etoile-2023','participant','individuel',2,'');
call create_game_participation('julie-2023','blanc-2023','etoile-2023','participant','individuel',5,'');
call create_game_participation('esteban-2023','blanc-2023','etoile-2023','participant','individuel',0,'');
call create_game_participation('nicolas-2023','blanc-2023','etoile-2023','participant','individuel',3,'');
call create_game_participation('frederic-2023','blanc-2023','etoile-2023','participant','individuel',0,'');
call create_game_participation('quentin-2023','blanc-2023','etoile-2023','participant','individuel',4,'');
call create_game_participation('gilles-2023','blanc-2023','etoile-2023','participant','individuel',0,'collier-immunite');
call create_game_participation('tania-2023','blanc-2023','etoile-2023','participant','individuel',0,'');
call create_game_participation('clemence-2023','blanc-2023','etoile-2023','participant','individuel',1,'totem');
call create_game_participation('laura-2023','blanc-2023','etoile-2023','participant','individuel',6,'');

/*

gilles - helena
tania -> helena
helena - tania
fred - tania
quentin - tania
clemence - tania
esteban - helena
laura - helena
julie - helena
julie - helena
nicolas - helena

depart helena

 */

call first_vote_against ('le-feu-sacre','gilles-2023','helena-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','tania-2023','helena-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','helena-2023','tania-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','frederic-2023','tania-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','quentin-2023','tania-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','clemence-2023','tania-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','esteban-2023','helena-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','nicolas-2023','helena-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','laura-2023','helena-2023','blanc-2023', 26, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','helena-2023','blanc-2023', 26, 'effectif');
call second_vote_against ('le-feu-sacre','julie-2023','helena-2023','blanc-2023', 26, 'effectif');

call create_participant_departure('le-feu-sacre','helena-2023','blanc-2023',26,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','helena-2023',10,1,26);

call program_current_time ('le-feu-sacre',26);
