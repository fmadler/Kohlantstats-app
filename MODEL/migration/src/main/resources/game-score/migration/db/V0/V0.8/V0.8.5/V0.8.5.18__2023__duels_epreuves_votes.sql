-- tania avantage strategique : indice collier immunite
call create_participant_realisation ('le-feu-sacre','tania-2023','blanc-2023',34,'decouverte-collier-immunite',@realisation_id);

-- tania decouvre collier 34 j
-- courrier + nourriture

--  35 j
call create_game('le-feu-sacre','Labyrinthe','labyrinthe-2023','labyrinthe','individuel','immunite',26,35,'totem,vote-contre-soi','rapidite,dexterite,calme');

call create_game_participation('quentin-2023','blanc-2023','labyrinthe-2023','participant','individuel',6,'vote-contre-soi');
call create_game_participation('laura-2023','blanc-2023','labyrinthe-2023','participant','individuel',2,'');
call create_game_participation('julie-2023','blanc-2023','labyrinthe-2023','participant','individuel',5,'');
call create_game_participation('nicolas-2023','blanc-2023','labyrinthe-2023','participant','individuel',1,'totem');
call create_game_participation('frederic-2023','blanc-2023','labyrinthe-2023','participant','individuel',3,'');
call create_game_participation('tania-2023','blanc-2023','labyrinthe-2023','participant','individuel',4,'');

call first_vote_against ('le-feu-sacre','frederic-2023','laura-2023','blanc-2023', 35, 'effectif');
call first_vote_against ('le-feu-sacre','quentin-2023','quentin-2023','blanc-2023', 35, 'effectif');
call second_vote_against ('le-feu-sacre','quentin-2023','tania-2023','blanc-2023', 35, 'effectif');
call third_vote_against ('le-feu-sacre','quentin-2023','tania-2023','blanc-2023', 35, 'effectif');
call first_vote_against ('le-feu-sacre','nicolas-2023','laura-2023','blanc-2023', 35, 'effectif');
call first_vote_against ('le-feu-sacre','laura-2023','tania-2023','blanc-2023', 35, 'effectif');
call first_vote_against ('le-feu-sacre','tania-2023','laura-2023','blanc-2023', 35, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','laura-2023','blanc-2023', 35, 'effectif');

call create_participant_departure('le-feu-sacre','laura-2023','blanc-2023',35,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','laura-2023',6,1,35);

call program_current_time ('le-feu-sacre',35);
