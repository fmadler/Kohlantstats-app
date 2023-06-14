-- tania avantage strategique : indice collier immunite
call create_participant_realisation ('le-feu-sacre','tania-2023','blanc-2023',34,'decouverte-collier-immunite',@realisation_id);

-- tania decouvre collier 34 j
-- courrier + nourriture

--  36 j
call create_game('le-feu-sacre','La boue','boue-2023','boue','individuel','confort',27,36,'nuit-luxueuse','rapidite');

call create_game_participation('quentin-2023','blanc-2023','boue-2023','participant','individuel',1,'nuit-luxueuse');
call create_game_participation('julie-2023','blanc-2023','boue-2023','participant','individuel',2,'');
call create_game_participation('nicolas-2023','blanc-2023','boue-2023','participant','individuel',0,'');
call create_game_participation('frederic-2023','blanc-2023','boue-2023','participant','individuel',0,'nuit-luxueuse');
call create_game_participation('tania-2023','blanc-2023','boue-2023','participant','individuel',0,'');

call create_game('le-feu-sacre','Domino','domino-2023','domino','individuel','immunite',28,37,'totem,vote-contre-soi','rapidite,dexterity,clame');

call create_game_participation('frederic-2023','blanc-2023','domino-2023','participant','individuel',1,'totem');
call create_game_participation('quentin-2023','blanc-2023','domino-2023','participant','individuel',2,'');
call create_game_participation('nicolas-2023','blanc-2023','domino-2023','participant','individuel',3,'');
call create_game_participation('julie-2023','blanc-2023','domino-2023','participant','individuel',4,'');
call create_game_participation('tania-2023','blanc-2023','domino-2023','participant','individuel',5,'vote-contre-soi');

call first_vote_against ('le-feu-sacre','frederic-2023','tania-2023','blanc-2023', 38, 'annule-par-collier-immunite');
call first_vote_against ('le-feu-sacre','quentin-2023','tania-2023','blanc-2023', 38, 'annule-par-collier-immunite');
call second_vote_against ('le-feu-sacre','quentin-2023','tania-2023','blanc-2023', 38, 'annule-par-collier-immunite');
call first_vote_against ('le-feu-sacre','nicolas-2023','laura-2023','blanc-2023', 38, 'annule-par-collier-immunite');
call first_vote_against ('le-feu-sacre','tania-2023','tania-2023','blanc-2023', 38, 'annule-par-collier-immunite');
call second_vote_against ('le-feu-sacre','tania-2023','quentin-2023','blanc-2023', 38, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','quentin-2023','blanc-2023', 38, 'effectif');

call create_participant_departure('le-feu-sacre','quentin-2023','blanc-2023',38,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','quentin-2023',5,1,38);

call program_current_time ('le-feu-sacre',38);
