call create_team('le-feu-sacre','Arrivée','arrivee-2023','Arrivée',1,2);

call create_participant_entrance ('le-feu-sacre','julie-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','helena-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','anne-sophie-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','tania-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','clemence-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','laura-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','christine-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','elodie-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','grace-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','celia-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','nicolas-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','gilles-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','benjamin-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','quentin-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','martin-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','esteban-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','alexandre-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','rudy-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','frederic-2023','arrivee-2023',1,'arrivee', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','emin-2023','arrivee-2023',1,'arrivee', @participant_team_id);


call create_game('le-feu-sacre','Parcours du combattant','parcours-du-combattant-2023','parcours-du-combattant','individuel','capitaine',1,1,'talisman,chef-equipe','rapidite,force,endurance');

call create_game_participation('julie-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('helena-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',2,'chef-equipe');
call create_game_participation('anne-sophie-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('tania-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('clemence-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('laura-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('christine-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('elodie-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('grace-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('nicolas-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',1,'talisman,chef-equipe');
call create_game_participation('gilles-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('benjamin-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('martin-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('esteban-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('alexandre-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('rudy-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('frederic-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('emin-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');
call create_game_participation('quentin-2023','arrivee-2023','parcours-du-combattant-2023','participant','individuel',0,'');

-- paniman
call create_team('le-feu-sacre','Jaune','jaune-2023','Equipe jaune',2,7);
-- dinago
call create_team('le-feu-sacre','Rouge','rouge-2023','Equipe rouge',2,7);

call create_participant_entrance ('le-feu-sacre','nicolas-2023','jaune-2023',1,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','grace-2023','jaune-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','frederic-2023','jaune-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','quentin-2023','jaune-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','gilles-2023','jaune-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','clemence-2023','jaune-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','benjamin-2023','jaune-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','tania-2023','jaune-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','celia-2023','jaune-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','laura-2023','jaune-2023',2,'constitution-des-equipes', @participant_team_id);


call create_participant_entrance ('le-feu-sacre','helena-2023','rouge-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','christine-2023','rouge-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','esteban-2023','rouge-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','rudy-2023','rouge-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','elodie-2023','rouge-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','julie-2023','rouge-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','emin-2023','rouge-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','martin-2023','rouge-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','alexandre-2023','rouge-2023',2,'constitution-des-equipes', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','anne-sophie-2023','rouge-2023',2,'constitution-des-equipes', @participant_team_id);



