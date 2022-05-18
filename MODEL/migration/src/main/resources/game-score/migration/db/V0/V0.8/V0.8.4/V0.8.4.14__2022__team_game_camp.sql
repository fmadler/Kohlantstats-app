-- tir-a-l-arc

call create_game('le-totem-maudit','Degustation','degustation-2022','degustation','binome','confort',28,22,'peche-languoste,nuit-hamac','degustation,rapidite');
-- degustation + boue

call create_game_participation('francois-2022','blanc-2022','tir-a-l-arc-2022','participant','binome',0,'toilette-massage,bien-etre');
call create_game_participation('olga-2022','blanc-2022','tir-a-l-arc-2022','participant','binome',0,'');
call create_game_participation('maxime-2022','blanc-2022','tir-a-l-arc-2022','participant','binome',0,'');
call create_game_participation('louana-2022','blanc-2022','tir-a-l-arc-2022','participant','binome',0,'');
call create_game_participation('ambre-2022','blanc-2022','tir-a-l-arc-2022','participant','binome',1,'peche-languoste,nuit-hamac');
call create_game_participation('bastien-2022','blanc-2022','tir-a-l-arc-2022','participant','binome',1,'peche-languoste,nuit-hamac');
call create_game_participation('fouzi-2022','blanc-2022','tir-a-l-arc-2022','participant','binome',0,'');
call create_game_participation('geraldine-2022','blanc-2022','tir-a-l-arc-2022','participant','binome',0,'');
call create_game_participation('jean-charles-2022','blanc-2022','tir-a-l-arc-2022','exclus-par-non-choix','binome',0,'');
call create_game_participation('nicolas-2022','blanc-2022','tir-a-l-arc-2022','participant','binome',0,'');

-- 30 ème jour
--

-- parcours du combattant + puzzle pour les 2 premiers
call create_game('le-totem-maudit','Parcours du combattant','parcours-du-combattant-2022','equilibre-perche','individuel','immunite',30,24,'totem,vote-contre-soi-du-dernier','rapidite,force,endurance');

call create_game_participation('louana-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',3,'');
call create_game_participation('maxime-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',3,'');
call create_game_participation('fouzi-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',7,'');
call create_game_participation('geraldine-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',7,'');
call create_game_participation('francois-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',1,'totem');
call create_game_participation('olga-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',1,'totem');
call create_game_participation('ambre-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',5,'');
call create_game_participation('bastien-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',5,'');
call create_game_participation('nicolas-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',9,'vote-contre-soi');
call create_game_participation('jean-charles-2022','blanc-2022','parcours-du-combattant-2022','participant','individuel',9,'vote-contre-soi');



call first_vote_against ('le-totem-maudit','louana-2022','fouzi-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','maxime-2022','nicolas-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','fouzi-2022','nicolas-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','francois-2022','maxime-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','geraldine-2022','nicolas-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','jean-charles-2022','fouzi-2022','blanc-2022', 27, 'effectif');
call second_vote_against ('le-totem-maudit','jean-charles-2022','jean-charles-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','ambre-2022','maxime-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','bastien-2022','maxime-2022','blanc-2022', 27, 'effectif');

call first_vote_against ('le-totem-maudit','olga-2022','maxime-2022','blanc-2022', 27, 'effectif');
call second_vote_against ('le-totem-maudit','olga-2022','maxime-2022','blanc-2022', 27, 'effectif');
call first_vote_against ('le-totem-maudit','nicolas-2022','fouzi-2022','blanc-2022', 27, 'effectif');
call second_vote_against ('le-totem-maudit','nicolas-2022','nicolas-2022','blanc-2022', 27, 'effectif');


call create_participant_departure('le-totem-maudit','anne-sophie-2022','blanc-2022',27,'exclusion-par-duel-apres-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','anne-sophie-2022',12,1,27);

call program_current_time ('le-totem-maudit',27);

sortie maxime + louana
