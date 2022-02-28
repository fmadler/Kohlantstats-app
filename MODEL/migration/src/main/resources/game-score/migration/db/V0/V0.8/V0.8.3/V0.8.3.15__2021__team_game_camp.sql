call create_game('la-legende-2021','Prisonnier','prisonnier-2021-2','prisonnier','individuel','confort',28,28,'excursion-chez-l-habitant,elimination-du-dernier','rapidite,precision,dexterite');

-- 
-- liberation , encastre boule dans les encoches placement de 3 boules
call create_game_participation('claude-2010','blanc-2021-2','prisonnier-2021-2','participant','individuel',1,'excursion-chez-l-habitant');
call create_game_participation('sam-2018','blanc-2021-2','prisonnier-2021-2','participant','individuel',4,'');
call create_game_participation('phil-2012','blanc-2021-2','prisonnier-2021-2','participant','individuel',3,'');
call create_program_game_participation('la-legende-2021','loic-2020','blanc-2021-2','prisonnier-2021-2','participant','individuel',8,'elimination-du-dernier');
call create_game_participation('laurent-2011','blanc-2021-2','prisonnier-2021-2','participant','individuel',7,'excursion-chez-l-habitant');
call create_game_participation('jade-2007','blanc-2021-2','prisonnier-2021-2','participant','individuel',6,'');
call create_game_participation('ugo-2012','blanc-2021-2','prisonnier-2021-2','participant','individuel',2,'');
call create_program_game_participation('la-legende-2021','alix-2020','blanc-2021-2','prisonnier-2021-2','participant','individuel',5,'');

call create_participant_departure ('la-legende-2021','loic-2020','blanc-2021-2',28,'elimination-du-dernier', @participant_team_id);
call create_participant_entrance ('la-legende-2021','loic-2020','ile-des-bannis-2-2021',26,'constitution-des-equipes', @participant_team_id);


-- parcours en cinq étapes
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Equilibre sur l''eau', 'equilibre-sur-l-eau', NULL);

call create_game('la-legende-2021','Equilibre sur l''eau','equilibre-sur-l-eau-2021-2','equilibre-sur-l-eau','individuel','immunite',29,29,'totem','rapidite,equilibre');

--
-- liberation , encastre boule dans les encoches placement de 3 boules
call create_game_participation('claude-2010','blanc-2021-2','equilibre-sur-l-eau-2021-2','participant','individuel',5,'');
call create_game_participation('sam-2018','blanc-2021-2','equilibre-sur-l-eau-2021-2','participant','individuel',3,'');
call create_game_participation('phil-2012','blanc-2021-2','equilibre-sur-l-eau-2021-2','participant','individuel',7,'');
call create_game_participation('laurent-2011','blanc-2021-2','equilibre-sur-l-eau-2021-2','participant','individuel',2,'');
call create_game_participation('jade-2007','blanc-2021-2','equilibre-sur-l-eau-2021-2','participant','individuel',4,'');
call create_game_participation('ugo-2012','blanc-2021-2','equilibre-sur-l-eau-2021-2','participant','individuel',1,'totem');
call create_program_game_participation('la-legende-2021','alix-2020','blanc-2021-2','equilibre-sur-l-eau-2021-2','participant','individuel',7,'');



call first_vote_against ('la-legende-2021','ugo-2012','jade-2007','blanc-2021-2', 29, 'effectif');
call first_vote_against ('la-legende-2021','claude-2010','alix-2020','blanc-2021-2', 29, 'effectif');
call second_vote_against ('la-legende-2021','claude-2010','alix-2020','blanc-2021-2', 29, 'effectif');
call first_vote_against ('la-legende-2021','phil-2012','alix-2020','blanc-2021-2', 29, 'effectif');
call first_vote_against ('la-legende-2021','sam-2018','alix-2020','blanc-2021-2', 29, 'effectif');
call first_vote_against ('la-legende-2021','jade-2007','alix-2020','blanc-2021-2', 29, 'effectif');
call first_vote_against ('la-legende-2021','alix-2020','sam-2018','blanc-2021-2', 29, 'effectif');
call first_vote_against ('la-legende-2021','laurent-2011','alix-2020','blanc-2021-2', 29, 'effectif');


call create_participant_departure('la-legende-2021','loic-2020','blanc-2021-2',27,'exclusion-par-vote', @participant_team_id);
call create_participant_entrance ('la-legende-2021','alix-2020','ile-des-bannis-2-2021',26,'constitution-des-equipes', @participant_team_id);

call program_current_time ('la-legende-2021',29);
