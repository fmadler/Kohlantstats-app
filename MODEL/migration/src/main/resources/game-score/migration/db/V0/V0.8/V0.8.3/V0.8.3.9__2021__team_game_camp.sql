call create_game('la-legende-2021','Empilement de boules','empilement-boules-2021-2','empilement-boules','individuel','arene',16,16,'exclusion-immediate,continuation-aventure','concentration,precision');

call create_program_game_participation('la-legende-2021','ugo-2012','ile-des-bannis-2021','empilement-boules-2021-2','participant','individuel',1,'continuation-aventure');
call create_program_game_participation('la-legende-2021','clementine-2017','ile-des-bannis-2021','empilement-boules-2021-2','participant','individuel',2,'continuation-aventure');
call create_program_game_participation('la-legende-2021','candice-2016','ile-des-bannis-2021','empilement-boules-2021-2','participant','individuel',3,'exclusion-immediate');

call create_participant_departure('la-legende-2021','candice-2016','ile-des-bannis-2021',14,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('la-legende-2021','candice-2016',16,1,14);

call create_game('la-legende-2021','Radeaux','radeaux-2021-2','radeaux','collectif','confort',15,15,'nourriture-poisson','force,construction,technique');


call create_game_participation('claude-2010','jaune-2021-2','radeaux-2021-2','participant','collectif',1,'nourriture-poisson');
call create_game_participation('coumba-2010','jaune-2021-2','radeaux-2021-2','participant','collectif',1,'nourriture-poisson');
call create_game_participation('sam-2018','jaune-2021-2','radeaux-2021-2','participant','collectif',1,'nourriture-poisson');
call create_game_participation('phil-2012','jaune-2021-2','radeaux-2021-2','participant','collectif',1,'nourriture-poisson');
call create_game_participation('christelle-2008','jaune-2021-2','radeaux-2021-2','participant','collectif',1,'nourriture-poisson');
call create_game_participation('clemence-2005','jaune-2021-2','radeaux-2021-2','participant','collectif',1,'nourriture-poisson');
call create_program_game_participation('la-legende-2021','loic-2020','rouge-2021-2','radeaux-2021-2','participant','collectif',2,'');
call create_game_participation('teheiura-2011','rouge-2021-2','radeaux-2021-2','participant','collectif',2,'');
call create_game_participation('laurent-2011','rouge-2021-2','radeaux-2021-2','exclusion-apres-tirage-au-sort','collectif',2,'');
call create_game_participation('namadia-2012','rouge-2021-2','radeaux-2021-2','participant','collectif',2,'');
call create_game_participation('jade-2007','rouge-2021-2','radeaux-2021-2','participant','collectif',2,'');
call create_program_game_participation('la-legende-2021','alexandra-2020','rouge-2021-2','radeaux-2021-2','participant','collectif',2,'');
call create_program_game_participation('la-legende-2021','alix-2020','rouge-2021-2','radeaux-2021-2','participant','collectif',2,'');

call team_game_ranking ('rouge-2021-2','radeaux-2021-2',1);
call team_game_ranking ('jaune-2021-2','radeaux-2021-2',2);


--
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Porteur-remplisseur', 'porteur-remplisseur', NULL);

call create_game('la-legende-2021','Porteur-remplisseur','porteur-remplisseur-2021','porteur-remplisseur','equipe','immunite',16,16,'totem','strategie,force,rapidite');


call create_game_participation('claude-2010','jaune-2021-2','porteur-remplisseur-2021','participant','collectif',2,'');
call create_game_participation('coumba-2010','jaune-2021-2','porteur-remplisseur-2021','participant','collectif',2,'');
call create_game_participation('sam-2018','jaune-2021-2','porteur-remplisseur-2021','participant','collectif',2,'');
call create_game_participation('phil-2012','jaune-2021-2','porteur-remplisseur-2021','participant','collectif',2,'');
call create_game_participation('christelle-2008','jaune-2021-2','porteur-remplisseur-2021','participant','collectif',2,'');
call create_game_participation('clemence-2005','jaune-2021-2','porteur-remplisseur-2021','participant','collectif',2,'');
call create_game_participation('candice-2016','jaune-2021-2','porteur-remplisseur-2021','participant','collectif',2,'');

call create_program_game_participation('la-legende-2021','loic-2020','rouge-2021-2','porteur-remplisseur-2021','participant','collectif',1,'totem');
call create_game_participation('teheiura-2011','rouge-2021-2','porteur-remplisseur-2021','exclusion-apres-tirage-au-sort','collectif',1,'totem');
call create_game_participation('laurent-2011','rouge-2021-2','porteur-remplisseur-2021','participant','collectif',1,'totem');
call create_game_participation('namadia-2012','rouge-2021-2','porteur-remplisseur-2021','participant','collectif',1,'totem');
call create_game_participation('jade-2007','rouge-2021-2','porteur-remplisseur-2021','participant','collectif',1,'totem');
call create_program_game_participation('la-legende-2021','alexandra-2020','rouge-2021-2','porteur-remplisseur-2021','participant','collectif',1,'totem');
call create_program_game_participation('la-legende-2021','alix-2020','rouge-2021-2','porteur-remplisseur-2021','participant','collectif',1,'totem');

call team_game_ranking ('rouge-2021-2','porteur-remplisseur-2021',1);
call team_game_ranking ('jaune-2021-2','porteur-remplisseur-2021',2);

call first_vote_against ('la-legende-2021','christelle-2008','clemence-2005','jaune-2021-2', 16, 'effectif');
call first_vote_against ('la-legende-2021','coumba-2010','clemence-2005','jaune-2021-2', 16, 'effectif');
call first_vote_against ('la-legende-2021','clemence-2005','sam-2018','jaune-2021-2', 16, 'effectif');
call first_vote_against ('la-legende-2021','claude-2010','clemence-2005','jaune-2021-2', 16, 'effectif');
call first_vote_against ('la-legende-2021','phil-2012','clemence-2005','jaune-2021-2', 16, 'effectif');
call first_vote_against ('la-legende-2021','sam-2018','clemence-2005','jaune-2021-2', 16, 'effectif');

call create_participant_departure('la-legende-2021','clemence-2005','jaune-2021-2',16,'exclusion-par-vote', @participant_team_id);
call create_participant_entrance ('la-legende-2021','clemence-2005','ile-des-bannis-2021',17,'constitution-des-equipes', @participant_team_id);
