call create_game('le-feu-sacre','Paresseux','paresseux-2023','paresseux','collectif','confort',15,21,'frites,talisman','patience,coordination');


call create_game_participation('helena-2023','rouge-2-2023','paresseux-2023','participant','collectif',1,'talisman');
call create_game_participation('anne-sophie-2023','rouge-2-2023','paresseux-2023','participant','collectif',1,'');
call create_game_participation('esteban-2023','rouge-2-2023','paresseux-2023','participant','collectif',1,'');
call create_game_participation('quentin-2023','rouge-2-2023','paresseux-2023','participant','collectif',1,'');
call create_game_participation('frederic-2023','rouge-2-2023','paresseux-2023','participant','collectif',1,'');
call create_game_participation('clemence-2023','rouge-2-2023','paresseux-2023','participant','collectif',1,'');

call create_game_participation('nicolas-2023','jaune-2-2023','paresseux-2023','participant','collectif',2,'');
call create_game_participation('grace-2023','jaune-2-2023','paresseux-2023','participant','collectif',2,'');
call create_game_participation('laura-2023','jaune-2-2023','paresseux-2023','participant','collectif',2,'');
call create_game_participation('gilles-2023','jaune-2-2023','paresseux-2023','participant','collectif',2,'');
call create_game_participation('tania-2023','jaune-2-2023','paresseux-2023','participant','collectif',2,'');
call create_game_participation('julie-2023','jaune-2-2023','paresseux-2023','participant','collectif',1,'');

call team_game_ranking ('jaune-2-2023','paresseux-2023',2);
call team_game_ranking ('rouge-2-2023','paresseux-2023',1);

call program_current_time ('le-feu-sacre',21);
