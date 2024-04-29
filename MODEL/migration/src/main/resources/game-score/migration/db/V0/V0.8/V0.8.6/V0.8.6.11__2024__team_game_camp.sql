call create_reward ('Nage avec des requins baleine', 'nage-avec-requin-baleine', 'excursion', 1);

call create_game('les-chasseurs-d-immunite','Tir à l''arc','tir-a-l-arc-2024','tir-a-l-arc','individuel','immunite',18,24,'nage-avec-requin-baleine,nuit-hotel,avantage-strategique','precision,strategie');

call create_game_participation('jean-2024','blanc-2024','tir-a-l-arc-2024','participant','individuel',12,'');
call create_game_participation('megane-2024','blanc-2024','tir-a-l-arc-2024','participant','individuel',5,'');
call create_game_participation('meissa-2024','blanc-2024','tir-a-l-arc-2024','participant','individuel',6,'');
call create_game_participation('david-2024','blanc-2024','tir-a-l-arc-2024','participant','individuel',11,'');
call create_game_participation('cecile-2024','blanc-2024','tir-a-l-arc-2024','participant','individuel',9,'');
call create_game_participation('julie-2024','blanc-2024','tir-a-l-arc-2024','participant','individuel',10,'');
call create_game_participation('amri-2024','blanc-2024','tir-a-l-arc-2024','participant','individuel',1,'nage-avec-requin-baleine,nuit-hotel,avantage-strategique');
call create_game_participation('pauline-2024','blanc-2024','tir-a-l-arc-2024','participant','individuel',2,'nage-avec-requin-baleine,nuit-hotel');
call create_game_participation('aurelien-2024','blanc-2024','tir-a-l-arc-2024','participant','individuel',7,'');
call create_game_participation('oceane-2024','blanc-2024','tir-a-l-arc-2024','participant','individuel',4,'');
call create_game_participation('sebastien-2024','blanc-2024','tir-a-l-arc-2024','participant','individuel',3,'');
call create_game_participation('lea-2024','blanc-2024','tir-a-l-arc-2024','participant','individuel',8,'');

call create_game('les-chasseurs-d-immunite','Table bascule','table-bascule-2024','table-bascule','individuel','immunite',19,25,'totem,elimination-du-dernier','calme,dexterite,concentration');

call create_game_participation('jean-2024','blanc-2024','table-bascule-2024','participant','individuel',1,'totem');
call create_game_participation('megane-2024','blanc-2024','table-bascule-2024','participant','individuel',6,'');
call create_game_participation('meissa-2024','blanc-2024','table-bascule-2024','participant','individuel',9,'');
call create_game_participation('david-2024','blanc-2024','table-bascule-2024','participant','individuel',11,'');
call create_game_participation('cecile-2024','blanc-2024','table-bascule-2024','participant','individuel',10,'');
call create_game_participation('julie-2024','blanc-2024','table-bascule-2024','participant','individuel',11,'');
call create_game_participation('amri-2024','blanc-2024','table-bascule-2024','participant','individuel',8,'nage-avec-requin-baleine,nuit-hotel,avantage-strategique');
call create_game_participation('pauline-2024','blanc-2024','table-bascule-2024','participant','individuel',7,'nage-avec-requin-baleine,nuit-hotel');
call create_game_participation('aurelien-2024','blanc-2024','table-bascule-2024','participant','individuel',5,'');
call create_game_participation('oceane-2024','blanc-2024','table-bascule-2024','participant','individuel',12,'elimination-du-dernier');
call create_game_participation('sebastien-2024','blanc-2024','table-bascule-2024','participant','individuel',2,'');
call create_game_participation('lea-2024','blanc-2024','table-bascule-2024','participant','individuel',4,'');

call create_participant_departure('les-chasseurs-d-immunite','oceane-2024','blanc-2024',25,'elimination-du-dernier', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','oceane-2024',12,1,25);

-- vote

call first_vote_against ('les-chasseurs-d-immunite','megane-2024','amri-2024','blanc-2024', 26, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','david-2024','amri-2024','blanc-2024', 26, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','julie-2024','amri-2024','blanc-2024', 26, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','jean-2024','amri-2024','blanc-2024', 26, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','cecile-2024','amri-2024','blanc-2024', 26, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','meissa-2024','amri-2024','blanc-2024', 26, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','pauline-2024','cecile-2024','blanc-2024', 26, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','oceane-2024','cecile-2024','blanc-2024', 26, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','amri-2024','cecile-2024','blanc-2024', 26, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','sebastien-2024','cecile-2024','blanc-2024', 26, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','aurelien-2024','cecile-2024','blanc-2024', 26, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','cecile-2024','blanc-2024',26,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','cecile-2024',11,1,26);

call program_current_time ('les-chasseurs-d-immunite',25);
