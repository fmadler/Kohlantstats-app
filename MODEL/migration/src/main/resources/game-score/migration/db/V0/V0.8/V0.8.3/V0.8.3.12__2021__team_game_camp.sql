
call create_game('la-legende-2021','Puzzle sous forme de vague','puzzle-vague-2021-2','puzzle','individuel','arene',19,19,'exclusion-immediate,continuation-aventure','concentration,precision,rapidite');

call create_program_game_participation('la-legende-2021','namadia-2012','ile-des-bannis-2-2021','puzzle-vague-2021-2','participant','individuel',2,'continuation-aventure');
call create_program_game_participation('la-legende-2021','coumba-2010','ile-des-bannis-2-2021','puzzle-vague-2021-2','participant','individuel',1,'exclusion-immediate');

call create_participant_departure('la-legende-2021','namadia-2012','ile-des-bannis-2-2021',19,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-legende-2021','namadia-2012',14,1,19);

INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Soirée rétro', 'soiree-retro', 5, 1);

call create_game('la-legende-2021','Tir à l''arc','tir-a-l-arc-2021-2','tir-a-l-arc','individuel','confort',19,20,'soiree-retro','precision,strategie');

call create_game_participation('claude-2010','blanc-2021-2','tir-a-l-arc-2021-2','participant','individuel',3,'');
call create_game_participation('sam-2018','blanc-2021-2','tir-a-l-arc-2021-2','participant','individuel',2,'soiree-retro');
call create_game_participation('phil-2012','blanc-2021-2','tir-a-l-arc-2021-2','participant','individuel',10,'');
call create_game_participation('christelle-2008','blanc-2021-2','tir-a-l-arc-2021-2','participant','individuel',9,'');
call create_program_game_participation('la-legende-2021','loic-2020','blanc-2021-2','tir-a-l-arc-2021-2','participant','individuel',5,'');
call create_game_participation('teheiura-2011','blanc-2021-2','tir-a-l-arc-2021-2','participant','individuel',1,'soiree-retro');
call create_game_participation('laurent-2011','blanc-2021-2','tir-a-l-arc-2021-2','participant','individuel',4,'');
call create_game_participation('jade-2007','blanc-2021-2','tir-a-l-arc-2021-2','participant','individuel',7,'');
call create_game_participation('ugo-2012','blanc-2021-2','tir-a-l-arc-2021-2','participant','individuel',6,'');
call create_game_participation('clemence-2005','blanc-2021-2','tir-a-l-arc-2021-2','participant','individuel',12,'');
call create_program_game_participation('la-legende-2021','alexandra-2020','blanc-2021-2','tir-a-l-arc-2021-2','participant','individuel',8,'');
call create_program_game_participation('la-legende-2021','alix-2020','blanc-2021-2','tir-a-l-arc-2021-2','participant','individuel',11,'');

call create_game('la-legende-2021','La perche','perche-2021-2','perche','individuel','immunite',21,21,'totem,elimination-du-dernier','dexterite,precision');

call create_game_participation('claude-2010','blanc-2021-2','perche-2021-2','participant','individuel',5,'');
call create_game_participation('sam-2018','blanc-2021-2','perche-2021-2','participant','individuel',9,'');
call create_game_participation('phil-2012','blanc-2021-2','perche-2021-2','participant','individuel',6,'');
call create_game_participation('christelle-2008','blanc-2021-2','perche-2021-2','participant','individuel',11,'');
call create_program_game_participation('la-legende-2021','loic-2020','blanc-2021-2','perche-2021-2','participant','individuel',2,'');
call create_game_participation('teheiura-2011','blanc-2021-2','perche-2021-2','participant','individuel',4,'');
call create_game_participation('laurent-2011','blanc-2021-2','perche-2021-2','participant','individuel',7,'');
call create_game_participation('jade-2007','blanc-2021-2','perche-2021-2','participant','individuel',8,'');
call create_game_participation('ugo-2012','blanc-2021-2','perche-2021-2','participant','individuel',1,'totem');
call create_game_participation('clemence-2005','blanc-2021-2','perche-2021-2','participant','individuel',10,'');
call create_program_game_participation('la-legende-2021','alexandra-2020','blanc-2021-2','perche-2021-2','participant','individuel',12,'elimination-du-dernier');
call create_program_game_participation('la-legende-2021','alix-2020','blanc-2021-2','perche-2021-2','participant','individuel',3,'');

call create_participant_departure ('la-legende-2021','alexandra-2020','blanc-2021-2',21,'elimination-du-dernier', @participant_team_id);
call create_participant_entrance ('la-legende-2021','alexandra-2020','ile-des-bannis-2-2021',21,'constitution-des-equipes', @participant_team_id);


call first_vote_against ('la-legende-2021','christelle-2008','alix-2020','blanc-2021-2', 22, 'effectif');
call first_vote_against ('la-legende-2021','ugo-2012','alix-2020','blanc-2021-2', 22, 'effectif');

call first_vote_against ('la-legende-2021','clemence-2005','alix-2020','blanc-2021-2', 22, 'effectif');
call first_vote_against ('la-legende-2021','claude-2010','alix-2020','blanc-2021-2', 22, 'effectif');
call first_vote_against ('la-legende-2021','phil-2012','clemence-2005','blanc-2021-2', 22, 'effectif');
call first_vote_against ('la-legende-2021','sam-2018','clemence-2005','blanc-2021-2', 22, 'effectif');
call first_vote_against ('la-legende-2021','jade-2007','alix-2020','blanc-2021-2', 22, 'effectif');
call first_vote_against ('la-legende-2021','alix-2020','clemence-2005','blanc-2021-2', 22, 'effectif');
call first_vote_against ('la-legende-2021','teheiura-2011','clemence-2005','blanc-2021-2', 22, 'effectif');
call first_vote_against ('la-legende-2021','laurent-2011','clemence-2005','blanc-2021-2', 22, 'effectif');
call second_vote_against ('la-legende-2021','laurent-2011','clemence-2005','blanc-2021-2', 22, 'effectif');
call first_vote_against ('la-legende-2021','loic-2020','clemence-2005','blanc-2021-2', 22, 'effectif');

call create_participant_departure ('la-legende-2021','clemence-2005','blanc-2021-2',22,'exclusion-par-vote', @participant_team_id);
call create_participant_entrance ('la-legende-2021','clemence-2005','ile-des-bannis-2-2021',22,'constitution-des-equipes', @participant_team_id);
