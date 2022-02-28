call create_game('la-legende-2021','Etoile','etoile-2021-2','etoile','collectif','confort',30,30,'nuit-luxueuse,decouverte-catamaran','statique,patience,equilibre');

-- liberation , encastre boule dans les encoches placement de 3 boules

call create_game_participation('claude-2010','blanc-2021-2','etoile-2021-2','participant','collectif',1,'nuit-luxueuse,decouverte-catamaran');
call create_game_participation('jade-2007','blanc-2021-2','etoile-2021-2','participant','collectif',1,'nuit-luxueuse,decouverte-catamaran');
call create_game_participation('phil-2012','blanc-2021-2','etoile-2021-2','participant','collectif',1,'nuit-luxueuse,decouverte-catamaran');
call create_game_participation('laurent-2011','blanc-2021-2','etoile-2021-2','participant','collectif',2,'');
call create_game_participation('sam-2018','blanc-2021-2','etoile-2021-2','participant','collectif',2,'');
call create_game_participation('ugo-2012','blanc-2021-2','etoile-2021-2','participant','collectif',2,'');

--
-- placement de boule dans un gecko, 3 boules, avec manipulation  via des cordelettes
call create_game('la-legende-2021','Placement de boules','placement-de-boules-2021-2','placement-de-boules','individuel','arene',31,31,'exclusion-immediate,continuation-aventure','concentration,precision,rapidite');

call create_program_game_participation('la-legende-2021','loic-2020','ile-des-bannis-2-2021','placement-de-boules-2021-2','participant','individuel',0,'continuation-aventure');
call create_program_game_participation('la-legende-2021','christelle-2008','ile-des-bannis-2-2021','placement-de-boules-2021-2','participant','individuel',0,'exclusion-immediate');
call create_program_game_participation('la-legende-2021','alix-2020','ile-des-bannis-2-2021','placement-de-boules-2021-2','participant','individuel',1,'exclusion-immediate');

call create_participant_departure('la-legende-2021','loic-2020','ile-des-bannis-2-2021',31,'elimination-du-dernier', @participant_team_id);
call create_participant_departure('la-legende-2021','christelle-2008','ile-des-bannis-2-2021',31,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-legende-2021','loic-2020',8,1,31);
call fill_participant_longevity ('la-legende-2021','christelle-2008',8,1,31);


--
call create_game('la-legende-2021','Assemblage vertical','assemblage-vertical-2021-2','Assemblage vertical','individuel','immunite',32,32,'totem,elimination-du-dernier','natation,rapidite,logique');

call create_game_participation('claude-2010','blanc-2021-2','assemblage-vertical-2021-2','participant','individuel',1,'totem');
call create_game_participation('jade-2007','blanc-2021-2','assemblage-vertical-2021-2','participant','individuel',2,'');
call create_game_participation('phil-2012','blanc-2021-2','assemblage-vertical-2021-2','participant','individuel',4,'');
call create_game_participation('laurent-2011','blanc-2021-2','assemblage-vertical-2021-2','participant','individuel',5,'');
call create_game_participation('sam-2018','blanc-2021-2','assemblage-vertical-2021-2','participant','individuel',6,'');
call create_game_participation('ugo-2012','blanc-2021-2','assemblage-vertical-2021-2','participant','individuel',3,'');

call create_participant_departure('la-legende-2021','sam-2018','blanc-2021-2',32,'elimination-du-dernier', @participant_team_id);
call create_participant_entrance ('la-legende-2021','sam-2018','ile-des-bannis-2-2021',32,'constitution-des-equipes', @participant_team_id);


call first_vote_against ('la-legende-2021','ugo-2012','jade-2007','blanc-2021-2', 32, 'effectif');
call first_vote_against ('la-legende-2021','claude-2010','jade-2007','blanc-2021-2', 32, 'effectif');
call first_vote_against ('la-legende-2021','phil-2012','ugo-2012','blanc-2021-2', 32, 'effectif');
call first_vote_against ('la-legende-2021','jade-2007','ugo-2012','blanc-2021-2', 32, 'effectif');
call second_vote_against ('la-legende-2021','jade-2007','ugo-2012','blanc-2021-2', 32, 'effectif');
call first_vote_against ('la-legende-2021','laurent-2011','ugo-2012','blanc-2021-2', 32, 'effectif');

call create_participant_departure('la-legende-2021','ugo-2012','blanc-2021-2',32,'exclusion-par-vote', @participant_team_id);
call create_participant_entrance ('la-legende-2021','ugo-2012','ile-des-bannis-2-2021',32,'constitution-des-equipes', @participant_team_id);

call program_current_time ('la-legende-2021',32);
