INSERT INTO `GS_TEAM_DEPARTURE_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Réintegration dans l''aventure', 'reintegration-aventure');
INSERT INTO `GS_TEAM_ENTRANCE_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Réintegration à l''orientation', 'reintegration-orientation');

call create_game('la-legende-2021','Labyrinthe géant','labyrinthe-geant-2021-2','labyrinthe','individuel','arene',34,33,'exclusion-immediate,continuation-aventure','concentration,rapidite');

call create_program_game_participation('la-legende-2021','ugo-2012','ile-des-bannis-2-2021','labyrinthe-geant-2021-2','participant','individuel',1,'continuation-aventure');
call create_program_game_participation('la-legende-2021','alix-2020','ile-des-bannis-2-2021','labyrinthe-geant-2021-2','participant','individuel',0,'exclusion-immediate');
call create_program_game_participation('la-legende-2021','sam-2018','ile-des-bannis-2-2021','labyrinthe-geant-2021-2','participant','individuel',0,'exclusion-immediate');

call create_participant_departure('la-legende-2021','alix-2020','ile-des-bannis-2-2021',34,'elimination-du-dernier', @participant_team_id);
call create_participant_departure('la-legende-2021','sam-2018','ile-des-bannis-2-2021',34,'elimination-du-dernier', @participant_team_id);
call create_participant_departure ('la-legende-2021','ugo-2012','ile-des-bannis-2-2021',34,'reintegration-aventure', @participant_team_id);

call fill_participant_longevity ('la-legende-2021','alix-2020',6,1,34);
call fill_participant_longevity ('la-legende-2021','sam-2018',6,1,34);
call create_participant_entrance('la-legende-2021','ugo-2012','blanc-2021-2',34,'reintegration-orientation', @participant_team_id);

--
call create_game('la-legende-2021','Orientation','orientation-2021-2','orientation','individuel','immunite',35,35,'poteaux','patience,logique,endurance');

call create_game_participation('claude-2010','blanc-2021-2','orientation-2021-2','participant','individuel',2,'');
call create_game_participation('jade-2007','blanc-2021-2','orientation-2021-2','participant','individuel',4,'');
call create_game_participation('phil-2012','blanc-2021-2','orientation-2021-2','participant','individuel',4,'');
call create_game_participation('laurent-2011','blanc-2021-2','orientation-2021-2','participant','individuel',3,'');
call create_game_participation('ugo-2012','blanc-2021-2','orientation-2021-2','participant','individuel',1,'');

call create_participant_departure('la-legende-2021','phil-2012','blanc-2021-2',35,'defaite-orientation', @participant_team_id);
call create_participant_departure ('la-legende-2021','jade-2007','blanc-2021-2',35,'defaite-orientation', @participant_team_id);
call fill_participant_longevity ('la-legende-2021','phil-2012',6,1,35);
call fill_participant_longevity ('la-legende-2021','jade-2007',6,1,35);

call program_current_time ('la-legende-2021',35);
