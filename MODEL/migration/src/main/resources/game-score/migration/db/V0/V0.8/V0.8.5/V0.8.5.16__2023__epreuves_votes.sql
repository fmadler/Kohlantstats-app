call create_game('le-feu-sacre','Dégustation','degustation-2023','degustation','binome','confort',21,30,'nuit-hotel','degustation');

call create_game_participation('quentin-2023','blanc-2023','degustation-2023','participant','binome',1,'nuit-hotel');
call create_game_participation('laura-2023','blanc-2023','degustation-2023','participant','binome',1,'nuit-hotel');
call create_game_participation('julie-2023','blanc-2023','degustation-2023','participant','binome',2,'');
call create_game_participation('nicolas-2023','blanc-2023','degustation-2023','participant','binome',2,'');
call create_game_participation('esteban-2023','blanc-2023','degustation-2023','participant','binome',0,'');
call create_game_participation('clemence-2023','blanc-2023','degustation-2023','participant','binome',0,'');
call create_game_participation('frederic-2023','blanc-2023','degustation-2023','participant','binome',0,'');
call create_game_participation('tania-2023','blanc-2023','degustation-2023','participant','binome',0,'');


call create_game('le-feu-sacre','Guide aveugle','guide-aveugle-2023','guide-aveugle','binome','immunite',22,31,'totem','voix,patience,commandement,cohesion');


call create_game_participation('esteban-2023','blanc-2023','guide-aveugle-2023','participant','binome',0,'vote-contre-soi');
call create_game_participation('clemence-2023','blanc-2023','guide-aveugle-2023','participant','binome',0,'');
call create_game_participation('julie-2023','blanc-2023','guide-aveugle-2023','participant','binome',0,'');
call create_game_participation('nicolas-2023','blanc-2023','guide-aveugle-2023','participant','binome',0,'');
call create_game_participation('frederic-2023','blanc-2023','guide-aveugle-2023','participant','binome',1,'totem');
call create_game_participation('tania-2023','blanc-2023','guide-aveugle-2023','participant','binome',1,'totem');
call create_game_participation('quentin-2023','blanc-2023','guide-aveugle-2023','participant','binome',0,'');
call create_game_participation('laura-2023','blanc-2023','guide-aveugle-2023','participant','binome',0,'');

-- decouverte double vote par julie
call first_vote_against ('le-feu-sacre','frederic-2023','clemence-2023','blanc-2023', 31, 'effectif');
call first_vote_against ('le-feu-sacre','quentin-2023','nicolas-2023','blanc-2023', 31, 'effectif');
call first_vote_against ('le-feu-sacre','esteban-2023','nicolas-2023','blanc-2023', 31, 'effectif');
call first_vote_against ('le-feu-sacre','nicolas-2023','clemence-2023','blanc-2023', 31, 'effectif');
call second_vote_against ('le-feu-sacre','nicolas-2023','clemence-2023','blanc-2023', 31, 'effectif');
call first_vote_against ('le-feu-sacre','laura-2023','nicolas-2023','blanc-2023', 31, 'effectif');
call first_vote_against ('le-feu-sacre','tania-2023','clemence-2023','blanc-2023', 31, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','clemence-2023','blanc-2023', 31, 'effectif');
call second_vote_against ('le-feu-sacre','julie-2023','clemence-2023','blanc-2023', 31, 'effectif');
call first_vote_against ('le-feu-sacre','clemence-2023','nicolas-2023','blanc-2023', 31, 'effectif');


call program_current_time ('le-feu-sacre',31);
