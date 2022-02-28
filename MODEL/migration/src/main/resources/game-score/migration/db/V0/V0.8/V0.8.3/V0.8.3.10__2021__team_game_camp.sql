
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Malle tractée', 'malle-tractee', NULL);

-- détacher une malle de 120kg, la faire passer par la sortie de l'enclos, la tracter sur la plage et l'élever au sommet d'une rampe
call create_game('la-legende-2021','Malle tractée','malle-tractee-2021','malle-tractee','collectif','confort',17,17,'pizzas','force,natation,apnee,parcours');

call create_game_participation('claude-2010','jaune-2021-2','malle-tractee-2021','participant','collectif',2,'');
call create_game_participation('coumba-2010','jaune-2021-2','malle-tractee-2021','participant','collectif',2,'');
call create_game_participation('sam-2018','jaune-2021-2','malle-tractee-2021','participant','collectif',2,'');
call create_game_participation('phil-2012','jaune-2021-2','malle-tractee-2021','participant','collectif',2,'');
call create_game_participation('christelle-2008','jaune-2021-2','malle-tractee-2021','participant','collectif',2,'');
call create_program_game_participation('la-legende-2021','loic-2020','rouge-2021-2','malle-tractee-2021','participant','collectif',1,'pizzas');
call create_game_participation('teheiura-2011','rouge-2021-2','malle-tractee-2021','exclusion-apres-tirage-au-sort','collectif',1,'pizzas');
call create_game_participation('laurent-2011','rouge-2021-2','malle-tractee-2021','participant','collectif',1,'pizzas');
call create_game_participation('namadia-2012','rouge-2021-2','malle-tractee-2021','participant','collectif',1,'pizzas');
call create_game_participation('jade-2007','rouge-2021-2','malle-tractee-2021','exclusion-apres-tirage-au-sort','collectif',1,'pizzas');
call create_program_game_participation('la-legende-2021','alexandra-2020','rouge-2021-2','malle-tractee-2021','participant','collectif',1,'pizzas');
call create_program_game_participation('la-legende-2021','alix-2020','rouge-2021-2','malle-tractee-2021','participant','collectif',1,'pizzas');

call team_game_ranking ('rouge-2021-2','malle-tractee-2021',2);
call team_game_ranking ('jaune-2021-2','malle-tractee-2021',1);

call create_game('la-legende-2021','Dominos','dominos-2021-2','domino','individuel','arene',18,18,'exclusion-immediate,continuation-aventure,amulette-immunite','concentration,precision,rapidite');

-- 31 dominos, quadrillage
call create_program_game_participation('la-legende-2021','ugo-2012','ile-des-bannis-2021','dominos-2021-2','participant','individuel',1,'continuation-aventure,amulette-d-immunite');
call create_program_game_participation('la-legende-2021','clementine-2017','ile-des-bannis-2021','dominos-2021-2','participant','individuel',3,'exclusion-immediate');
call create_program_game_participation('la-legende-2021','clemence-2005','ile-des-bannis-2021','dominos-2021-2','participant','individuel',2,'continuation-aventure,amulette-d-immunite');

call create_participant_departure('la-legende-2021','clementine-2017','ile-des-bannis-2021',18,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-legende-2021','clementine-2017',15,1,18);
-- 18 ème jour ambassadeurs
--
