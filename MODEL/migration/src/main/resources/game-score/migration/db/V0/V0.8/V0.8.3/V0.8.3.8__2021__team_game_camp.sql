INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Catapulte', 'catapulte', NULL);
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Rangement', 'rangement', NULL);


call create_game('la-legende-2021','Construction Edifice','construction-edifice-2021','construction-edifice','individuel','arene',12,12,'exclusion-immediate,continuation-aventure','logique,rapidite');
call create_program_game_participation('la-legende-2021','ugo-2012','ile-des-bannis-2021','construction-edifice-2021','participant','individuel',1,'continuation-aventure');
call create_program_game_participation('la-legende-2021','clementine-2017','ile-des-bannis-2021','construction-edifice-2021','participant','individuel',2,'continuation-aventure');
call create_program_game_participation('la-legende-2021','maxime-2019','ile-des-bannis-2021','construction-edifice-2021','participant','individuel',3,'exclusion-immediate');

call create_participant_departure('la-legende-2021','maxime-2019','ile-des-bannis-2021',12,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-legende-2021','maxime-2019',17,1,12);

INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Panier de nourriture fruits et légumes', 'nourriture-fruits-legumes', 5, 1);

call create_game('la-legende-2021','Placement de pieces','placement-de-pieces-2021','rangement','individuel','confort',12,13,'nourriture-fruits-legumes','rapidite,cohesion,logique');
-- en deux parties collectifs et individuel

call create_game_participation('claude-2010','jaune-2021-2','placement-de-pieces-2021','participant','individuel',2,'nourriture-fruits-legumes');
call create_game_participation('coumba-2010','jaune-2021-2','placement-de-pieces-2021','participant','individuel',0,'');
call create_game_participation('sam-2018','jaune-2021-2','placement-de-pieces-2021','participant','individuel',0,'');
call create_game_participation('phil-2012','jaune-2021-2','placement-de-pieces-2021','participant','individuel',3,'nourriture-fruits-legumes');
call create_game_participation('christelle-2008','jaune-2021-2','placement-de-pieces-2021','participant','individuel',0,'');
call create_game_participation('clemence-2005','jaune-2021-2','placement-de-pieces-2021','participant','individuel',0,'');
call create_game_participation('candice-2016','jaune-2021-2','placement-de-pieces-2021','participant','individuel',0,'');
call create_program_game_participation('la-legende-2021','loic-2020','rouge-2021-2','placement-de-pieces-2021','participant','individuel',0,'');
call create_game_participation('teheiura-2011','rouge-2021-2','placement-de-pieces-2021','participant','individuel',1,'nourriture-fruits-legumes');
call create_game_participation('laurent-2011','rouge-2021-2','placement-de-pieces-2021','participant','individuel',0,'');
call create_game_participation('namadia-2012','rouge-2021-2','placement-de-pieces-2021','participant','individuel',0,'');
call create_game_participation('jade-2007','rouge-2021-2','placement-de-pieces-2021','participant','individuel',0,'');
call create_program_game_participation('la-legende-2021','alexandra-2020','rouge-2021-2','placement-de-pieces-2021','participant','individuel',0,'');
call create_program_game_participation('la-legende-2021','alix-2020','rouge-2021-2','placement-de-pieces-2021','participant','individuel',0,'');


call create_game('la-legende-2021','Catapulte','catapulte-2021','catapulte','equipe','immunite',13,14,'totem,conseil-immediat','strategie,precision');


call create_game_participation('claude-2010','jaune-2021-2','catapulte-2021','participant','collectif',2,'conseil-immediat');
call create_game_participation('coumba-2010','jaune-2021-2','catapulte-2021','exclusion-apres-tirage-au-sort','collectif',2,'conseil-immediat');
call create_game_participation('sam-2018','jaune-2021-2','catapulte-2021','participant','collectif',2,'conseil-immediat');
call create_game_participation('phil-2012','jaune-2021-2','catapulte-2021','participant','collectif',2,'conseil-immediat');
call create_game_participation('christelle-2008','jaune-2021-2','catapulte-2021','participant','collectif',2,'conseil-immediat');
call create_game_participation('clemence-2005','jaune-2021-2','catapulte-2021','participant','collectif',2,'conseil-immediat');
call create_game_participation('candice-2016','jaune-2021-2','catapulte-2021','participant','collectif',2,'conseil-immediat');

call create_program_game_participation('la-legende-2021','loic-2020','rouge-2021-2','catapulte-2021','participant','collectif',1,'totem');
call create_game_participation('teheiura-2011','rouge-2021-2','catapulte-2021','participant','collectif',1,'totem');
call create_game_participation('laurent-2011','rouge-2021-2','catapulte-2021','participant','collectif',1,'totem');
call create_game_participation('namadia-2012','rouge-2021-2','catapulte-2021','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('jade-2007','rouge-2021-2','catapulte-2021','participant','collectif',1,'totem');
call create_program_game_participation('la-legende-2021','alexandra-2020','rouge-2021-2','catapulte-2021','participant','collectif',1,'totem');
call create_program_game_participation('la-legende-2021','alix-2020','rouge-2021-2','catapulte-2021','participant','collectif',1,'totem');

call team_game_ranking ('rouge-2021-2','catapulte-2021',1);
call team_game_ranking ('jaune-2021-2','catapulte-2021',2);

call first_vote_against ('la-legende-2021','christelle-2008','clemence-2005','jaune-2021-2', 13, 'annule-par-collier-immunite');
call first_vote_against ('la-legende-2021','coumba-2010','candice-2016','jaune-2021-2', 13, 'effectif');
call first_vote_against ('la-legende-2021','clemence-2005','sam-2018','jaune-2021-2', 13, 'effectif');
call first_vote_against ('la-legende-2021','candice-2016','clemence-2005','jaune-2021-2', 13, 'annule-par-collier-immunite');
call first_vote_against ('la-legende-2021','claude-2010','clemence-2005','jaune-2021-2', 13, 'annule-par-collier-immunite');
call first_vote_against ('la-legende-2021','phil-2012','clemence-2005','jaune-2021-2', 13, 'annule-par-collier-immunite');
call first_vote_against ('la-legende-2021','sam-2018','clemence-2005','jaune-2021-2', 13, 'annule-par-collier-immunite');

call second_round_first_vote_for ('la-legende-2021','christelle-2008','candice-2016','jaune-2021-2', 13, 'effectif');
call second_round_first_vote_for ('la-legende-2021','coumba-2010','candice-2016','jaune-2021-2', 13, 'effectif');
call second_round_first_vote_for ('la-legende-2021','clemence-2005','sam-2018','jaune-2021-2', 13, 'effectif');
call second_round_first_vote_for ('la-legende-2021','candice-2016','sam-2018','jaune-2021-2', 13, 'effectif');
call second_round_first_vote_for ('la-legende-2021','claude-2010','candice-2016','jaune-2021-2', 13, 'effectif');
call second_round_first_vote_for ('la-legende-2021','phil-2012','candice-2016','jaune-2021-2', 13, 'effectif');
call second_round_first_vote_for ('la-legende-2021','sam-2018','candice-2016','jaune-2021-2', 13, 'effectif');

call create_participant_departure('la-legende-2021','candice-2016','jaune-2021-2',13,'exclusion-par-vote', @participant_team_id);
call create_participant_entrance ('la-legende-2021','candice-2016','ile-des-bannis-2021',14,'constitution-des-equipes', @participant_team_id);
