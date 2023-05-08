-- 25
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Repas de poisson', 'poisson', 5, 1);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Decouverte des coraux', 'decouverte-coraux', 5, 1);

call create_game('le-feu-sacre','Parcours en quatre étapes','parcours-quatre-etapes-2023','parcours-quatre-etapes','individuel','confort',16,25,'decouverte-coraux,poisson','force,rapidite');


call create_game_participation('helena-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',4,'');
call create_game_participation('julie-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',3,'');
call create_game_participation('esteban-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',9,'');
call create_game_participation('nicolas-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',2,'');
call create_game_participation('frederic-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',5,'decouverte-coraux,poisson');
call create_game_participation('quentin-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',1,'decouverte-coraux,poisson');
call create_game_participation('gilles-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',7,'');
call create_game_participation('tania-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',9,'');
call create_game_participation('clemence-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',5,'');
call create_game_participation('laura-2023','blanc-2023','parcours-quatre-etapes-2023','participant','individuel',7,'');

