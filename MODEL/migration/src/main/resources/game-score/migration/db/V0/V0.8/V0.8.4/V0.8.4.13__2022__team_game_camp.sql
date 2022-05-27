-- tir-a-l-arc

call create_game('le-totem-maudit','Tir à l''arc','tir-a-l-arc-2022','tir-a-l-arc','collectif','confort',20,26,'bien-etre,telephone,exclusion-par-tirage-au-sort','statique,precision');
-- le dernier gagne

call create_game_participation('francois-2022','blanc-2022','tir-a-l-arc-2022','participant','equipe-composee',1,'bien-etre,telephone');
call create_game_participation('fouzi-2022','blanc-2022','tir-a-l-arc-2022','participant','equipe-composee',1,'bien-etre,telephone');
call create_game_participation('louana-2022','blanc-2022','tir-a-l-arc-2022','participant','equipe-composee',1,'bien-etre,telephone');
call create_game_participation('ambre-2022','blanc-2022','tir-a-l-arc-2022','participant','equipe-composee',1,'bien-etre,telephone');
call create_game_participation('bastien-2022','blanc-2022','tir-a-l-arc-2022','participant','equipe-composee',1,'bien-etre,telephone');

call create_game_participation('nicolas-2022','blanc-2022','tir-a-l-arc-2022','participant','equipe-composee',2,'');
call create_game_participation('maxime-2022','blanc-2022','tir-a-l-arc-2022','participant','equipe-composee',2,'');
call create_game_participation('geraldine-2022','blanc-2022','tir-a-l-arc-2022','participant','equipe-composee',2,'');
call create_game_participation('olga-2022','blanc-2022','tir-a-l-arc-2022','participant','equipe-composee',2,'');
call create_game_participation('anne-sophie-2022','blanc-2022','tir-a-l-arc-2022','participant','equipe-composee',2,'');


call create_game_participation('jean-charles-2022','blanc-2022','tir-a-l-arc-2022','exclusion-par-choix-d-equipe','equipe-composee',0,'');

-- tir à l'arc par duel avec 2 flèches en plus
--

-- parcours du combattant + puzzle pour les 2 premiers
call create_game('le-totem-maudit','Parcours du combattant','parcours-du-combattant-2022','parcours-du-combattant','individuel','immunite',21,27,'totem','rapidite,force,endurance');

call create_game_participation('louana-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',1,'totem');
call create_game_participation('maxime-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',0,'');
call create_game_participation('fouzi-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',0,'');
call create_game_participation('francois-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',0,'');
call create_game_participation('geraldine-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',0,'');
call create_game_participation('jean-charles-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',0,'');
call create_game_participation('ambre-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',0,'');
call create_game_participation('anne-sophie-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',0,'');
call create_game_participation('bastien-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',2,'');
call create_game_participation('nicolas-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',0,'');
call create_game_participation('olga-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',0,'');


call create_participant_realisation ('le-totem-maudit','olga-2022','blanc-2022',27,'decouverte-collier-immunite',@realisation_id);

call first_vote_against ('le-totem-maudit','louana-2022','anne-sophie-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','maxime-2022','anne-sophie-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','fouzi-2022','anne-sophie-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','francois-2022','anne-sophie-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','geraldine-2022','anne-sophie-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','jean-charles-2022','anne-sophie-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','ambre-2022','anne-sophie-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','bastien-2022','maxime-2022','blanc-2022', 27, 'effectif');

call first_vote_against ('le-totem-maudit','olga-2022','maxime-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','anne-sophie-2022','maxime-2022','blanc-2022', 27, 'effectif');
call second_vote_against ('le-totem-maudit','anne-sophie-2022','maxime-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','nicolas-2022','maxime-2022','blanc-2022', 27, 'effectif');


call create_participant_departure('le-totem-maudit','anne-sophie-2022','blanc-2022',27,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','anne-sophie-2022',11,1,27);

call program_current_time ('le-totem-maudit',27);
