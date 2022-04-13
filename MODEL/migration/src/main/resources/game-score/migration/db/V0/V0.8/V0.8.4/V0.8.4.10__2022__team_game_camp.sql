
-- 19ème jour

-- jean philippe : sort par décision médicale
-- stéphanie revient chez les rouges





INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Poulet adobo', 'pas-d-entrainement-pour-la-prochaine-epreuve', 5, 0);

call create_game('le-totem-maudit','Potrie','potrie-2022','poterie','collectif','confort',18,14,'soiree-chez-l-habitant,pas-d-entrainement-pour-la-prochaine-epreuve','equilibre,rapidite');

-- exclues stephanie 
call create_game_participation('louana-2022','rouge-2022','potrie-2022','participant','collectif',2,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('maxime-2022','rouge-2022','potrie-2022','participant','collectif',2,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('fouzi-2022','rouge-2022','potrie-2022','exclusion-apres-tirage-au-sort','collectif',2,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('francois-2022','rouge-2022','potrie-2022','participant','collectif',2,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('geraldine-2022','rouge-2022','potrie-2022','participant','collectif',2,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('pauline-2022','rouge-2022','potrie-2022','participant','collectif',2,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('jean-charles-2022','rouge-2022','potrie-2022','participant','collectif',2,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('ambre-2022','rouge-2022','potrie-2022','participant','collectif',2,'pas-d-entrainement-pour-la-prochaine-epreuve');

call create_game_participation('anne-sophie-2022','jaune-2022','potrie-2022','participant','collectif',1,'soiree-chez-l-habitant');
call create_game_participation('yannick-2022','jaune-2022','potrie-2022','participant','collectif',1,'soiree-chez-l-habitant');
call create_game_participation('bastien-2022','jaune-2022','potrie-2022','participant','collectif',1,'soiree-chez-l-habitant');
call create_game_participation('alexandra-2022','jaune-2022','potrie-2022','participant','collectif',1,'soiree-chez-l-habitant');
call create_game_participation('colin-2022','jaune-2022','potrie-2022','participant','collectif',1,'soiree-chez-l-habitant');
call create_game_participation('nicolas-2022','jaune-2022','potrie-2022','participant','collectif',1,'soiree-chez-l-habitant');
call create_game_participation('olga-2022','jaune-2022','potrie-2022','participant','collectif',1,'soiree-chez-l-habitant');
call create_game_participation('setha-2022','jaune-2022','potrie-2022','participant','collectif',1,'soiree-chez-l-habitant');


call team_game_ranking ('jaune-2022','potrie-2022',1);
call team_game_ranking ('rouge-2022','potrie-2022',2);

-- par serie de 4 

call create_game('le-totem-maudit','Catapulte','catapulte-2022','catapulte','collectif','immunite',20,15,'conseil','rapidite,precision,voix,clarte');
-- exclues stephanie par tirage au sort
call create_game_participation('louana-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('maxime-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('fouzi-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('francois-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('stephanie-2022','rouge-2022','catapulte-2022','exclusion-apres-tirage-au-sort','totem',1,'conseil');
call create_game_participation('geraldine-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('pauline-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('jean-charles-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('ambre-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');

call create_game_participation('anne-sophie-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('yannick-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('bastien-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('alexandra-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('benjamin-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('colin-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('nicolas-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('olga-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('setha-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');

call team_game_ranking ('jaune-2022','catapulte-2022',2);
call team_game_ranking ('rouge-2022','catapulte-2022',1);

maxime  -
stephanie
louana
pauline
francois
fouzi
jean-charles
ambre
geraldine

call first_vote_against ('le-totem-maudit','bastien-2022','alexandra-2022','jaune-2022', 20, 'effectif');
call first_vote_against ('le-totem-maudit','yannick-2022','alexandra-2022','jaune-2022', 20, 'effectif');
call second_vote_against ('le-totem-maudit','yannick-2022','yannick-2022','jaune-2022', 20, 'effectif');
call vote ('le-totem-maudit','yannick-2022','yannick-2022','rouge-2022', 3, 20, 1, 'effectif', 'vote-contre');
call first_vote_against ('le-totem-maudit','alexandra-2022','setha-2022','jaune-2022', 20, 'effectif');
call first_vote_against ('le-totem-maudit','colin-2022','setha-2022','jaune-2022', 20, 'effectif');
call first_vote_against ('le-totem-maudit','olga-2022','setha-2022','jaune-2022', 20, 'effectif');
call first_vote_against ('le-totem-maudit','setha-2022','alexandra-2022','jaune-2022', 20, 'effectif');
call first_vote_against ('le-totem-maudit','anne-sophie-2022','alexandra-2022','jaune-2022', 20, 'effectif');
call first_vote_against ('le-totem-maudit','nicolas-2022','setha-2022','jaune-2022', 20, 'effectif');


idem pour les votes une deuxième fois

call create_participant_departure('le-totem-maudit','alexandra-2022','jaune-2022',11,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','alexandra-2022',16,1,20);

call program_current_time ('le-totem-maudit',20);


--
-- eqjipe jaune
-- setha alexandra tirage boule noire
-- alexandra boule noire

