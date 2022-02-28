call create_game('la-legende-2021','Bambou','bambou-2021-2','bambou','individuel','confort',26,26,'avantage-strategique','statique,patience,equilibre');

-- creation de boulette avec boue+paille et tir pour faire pivoter un tourniquet, girouette doit tomber
call create_game_participation('claude-2010','blanc-2021-2','bambou-2021-2','participant','individuel',1,'avantage-strategique');
call create_game_participation('sam-2018','blanc-2021-2','bambou-2021-2','participant','individuel',4,'');
call create_game_participation('phil-2012','blanc-2021-2','bambou-2021-2','participant','individuel',7,'');
call create_program_game_participation('la-legende-2021','loic-2020','blanc-2021-2','bambou-2021-2','participant','individuel',3,'');
call create_game_participation('laurent-2011','blanc-2021-2','bambou-2021-2','participant','individuel',1,'avantage-strategique');
call create_game_participation('jade-2007','blanc-2021-2','bambou-2021-2','participant','individuel',8,'');
call create_game_participation('ugo-2012','blanc-2021-2','bambou-2021-2','participant','individuel',6,'');
call create_program_game_participation('la-legende-2021','alix-2020','blanc-2021-2','bambou-2021-2','participant','individuel',5,'excursion-chez-l-habitant');

-- jade 39
-- 27 j : 2 collier d'immunité, claude et laurent
call create_participant_realisation ('la-legende-2021','laurent-2011','blanc-2021-2',27,'decouverte-collier-immunite',@realisation_id);
call create_participant_realisation ('la-legende-2021','claude-2010','blanc-2021-2',27,'decouverte-collier-immunite',@realisation_id);

-- 27 teheiura tricherie exclusion
call create_participant_departure ('la-legende-2021','teheiura-2011','ile-des-bannis-2-2021',27,'exclusion-par-tricherie', @participant_team_id);
call fill_participant_longevity ('la-legende-2021','teheiura-2011',11,1,27);

-- recherche courrier
call create_game('la-legende-2021','Assemblage cubes','cubes-2021-2','assemblage-cube','individuel','arene',27,27,'exclusion-immediate,continuation-aventure','concentration,precision,rapidite');

call create_program_game_participation('la-legende-2021','alexandra-2020','ile-des-bannis-2-2021','cubes-2021-2','participant','individuel',0,'continuation-aventure');
call create_program_game_participation('la-legende-2021','christelle-2008','ile-des-bannis-2-2021','cubes-2021-2','participant','individuel',1,'exclusion-immediate');


call create_participant_departure('la-legende-2021','alexandra-2020','ile-des-bannis-2-2021',27,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-legende-2021','alexandra-2020',10,1,27);

call program_current_time ('la-legende-2021',27);
