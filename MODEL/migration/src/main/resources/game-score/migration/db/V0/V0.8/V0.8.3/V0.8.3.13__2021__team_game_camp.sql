call create_game('la-legende-2021','La glaise','la-boue-2021-2','boue','binome','confort',23,23,'excursion-chez-l-habitant','rapidite,precision');

-- creation de boulette avec boue+paille et tir pour faire pivoter un tourniquet, girouette doit tomber
call create_game_participation('claude-2010','blanc-2021-2','la-boue-2021-2','participant','binome',0,'');
call create_game_participation('sam-2018','blanc-2021-2','la-boue-2021-2','participant','binome',0,'');
call create_game_participation('phil-2012','blanc-2021-2','la-boue-2021-2','participant','binome',1,'excursion-chez-l-habitant');
call create_game_participation('christelle-2008','blanc-2021-2','la-boue-2021-2','participant','binome',0,'');
call create_program_game_participation('la-legende-2021','loic-2020','blanc-2021-2','la-boue-2021-2','participant','binome',0,'');
call create_game_participation('teheiura-2011','blanc-2021-2','la-boue-2021-2','participant','binome',0,'');
call create_game_participation('laurent-2011','blanc-2021-2','la-boue-2021-2','participant','binome',0,'');
call create_game_participation('jade-2007','blanc-2021-2','la-boue-2021-2','participant','binome',0,'');
call create_game_participation('ugo-2012','blanc-2021-2','la-boue-2021-2','participant','binome',0,'');
call create_program_game_participation('la-legende-2021','alix-2020','blanc-2021-2','la-boue-2021-2','participant','binome',1,'excursion-chez-l-habitant');

call create_game('la-legende-2021','Table bascule','table-bascule-2021-2','table-bascule','individuel','arene',23,24,'exclusion-immediate,continuation-aventure','concentration,precision,rapidite');

call create_program_game_participation('la-legende-2021','alexandra-2020','ile-des-bannis-2-2021','table-bascule-2021-2','participant','individuel',1,'continuation-aventure');
call create_program_game_participation('la-legende-2021','coumba-2010','ile-des-bannis-2-2021','table-bascule-2021-2','participant','individuel',0,'exclusion-immediate');
call create_program_game_participation('la-legende-2021','clemence-2005','ile-des-bannis-2-2021','table-bascule-2021-2','participant','individuel',0,'exclusion-immediate');

call create_participant_departure('la-legende-2021','clemence-2005','ile-des-bannis-2-2021',23,'elimination-du-dernier', @participant_team_id);
call create_participant_departure('la-legende-2021','coumba-2010','ile-des-bannis-2-2021',23,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-legende-2021','coumba-2010',13,1,23);
call fill_participant_longevity ('la-legende-2021','clemence-2005',13,1,23);

call create_game('la-legende-2021','Guide aveugle','guide-aveugle-2021-2','guide-aveugle','binome','immunite',24,25,'totem,vote-contre-soi','rapidite,orientation');

call create_game_participation('claude-2010','blanc-2021-2','guide-aveugle-2021-2','participant','binome',2,'');
call create_game_participation('sam-2018','blanc-2021-2','guide-aveugle-2021-2','participant','binome',5,'vote-contre-soi');
call create_game_participation('phil-2012','blanc-2021-2','guide-aveugle-2021-2','participant','binome',3,'');
call create_game_participation('christelle-2008','blanc-2021-2','guide-aveugle-2021-2','participant','binome',4,'');
call create_program_game_participation('la-legende-2021','loic-2020','blanc-2021-2','guide-aveugle-2021-2','participant','binome',1,'totem');
call create_game_participation('teheiura-2011','blanc-2021-2','guide-aveugle-2021-2','participant','binome',4,'');
call create_game_participation('laurent-2011','blanc-2021-2','guide-aveugle-2021-2','participant','binome',2,'');
call create_game_participation('jade-2007','blanc-2021-2','guide-aveugle-2021-2','participant','binome',5,'vote-contre-soi');
call create_game_participation('ugo-2012','blanc-2021-2','guide-aveugle-2021-2','participant','binome',1,'totem');
call create_program_game_participation('la-legende-2021','alix-2020','blanc-2021-2','guide-aveugle-2021-2','participant','binome',3,'');


call first_vote_against ('la-legende-2021','christelle-2008','phil-2012','blanc-2021-2', 25, 'effectif');
call first_vote_against ('la-legende-2021','ugo-2012','jade-2007','blanc-2021-2', 25, 'effectif');
call second_vote_against ('la-legende-2021','ugo-2012','sam-2018','blanc-2021-2', 25, 'effectif');
call first_vote_against ('la-legende-2021','claude-2010','phil-2012','blanc-2021-2', 25, 'effectif');

call first_vote_against ('la-legende-2021','phil-2012','christelle-2008','blanc-2021-2', 25, 'effectif');

call first_vote_against ('la-legende-2021','sam-2018','alix-2020','blanc-2021-2', 25, 'effectif');
call first_vote_against ('la-legende-2021','jade-2007','laurent-2011','blanc-2021-2', 25, 'effectif');
call second_vote_against ('la-legende-2021','sam-2018','sam-2018','blanc-2021-2', 25, 'effectif');
call second_vote_against ('la-legende-2021','jade-2007','jade-2007','blanc-2021-2', 25, 'effectif');

call first_vote_against ('la-legende-2021','alix-2020','christelle-2008','blanc-2021-2', 25, 'effectif');

call first_vote_against ('la-legende-2021','teheiura-2011','alix-2020','blanc-2021-2', 25, 'effectif');
call first_vote_against ('la-legende-2021','laurent-2011','christelle-2008','blanc-2021-2', 25, 'effectif');
call first_vote_against ('la-legende-2021','loic-2020','christelle-2008','blanc-2021-2', 25, 'effectif');

call create_participant_departure ('la-legende-2021','christelle-2008','blanc-2021-2',25,'exclusion-par-vote', @participant_team_id);
call create_participant_departure ('la-legende-2021','teheiura-2011','blanc-2021-2',25,'exclusion-par-vote', @participant_team_id);
call create_participant_entrance ('la-legende-2021','christelle-2008','ile-des-bannis-2-2021',26,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('la-legende-2021','teheiura-2011','ile-des-bannis-2-2021',26,'constitution-des-equipes', @participant_team_id);
