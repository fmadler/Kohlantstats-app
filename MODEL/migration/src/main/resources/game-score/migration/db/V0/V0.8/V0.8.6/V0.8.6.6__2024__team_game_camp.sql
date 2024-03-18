call create_game('les-chasseurs-d-immunite','Coursier','coursier-2024','coursier','collectif','confort',10,13,'nourriture,kit-peche','rapidite,force,reflexion');

call create_game_participation('ricky-2024','rouge-2024','coursier-2024','participant','collectif',2,'');
call create_game_participation('jean-2024','rouge-2024','coursier-2024','exclusion-apres-tirage-au-sort','collectif',2,'');
call create_game_participation('megane-2024','rouge-2024','coursier-2024','exclusion-apres-tirage-au-sort','collectif',2,'');
call create_game_participation('emilie-2024','rouge-2024','coursier-2024','participant','collectif',2,'');
call create_game_participation('meissa-2024','rouge-2024','coursier-2024','participant','collectif',2,'');
call create_game_participation('david-2024','rouge-2024','coursier-2024','exclusion-apres-tirage-au-sort','collectif',2,'');
call create_game_participation('cecile-2024','rouge-2024','coursier-2024','participant','collectif',2,'');
call create_game_participation('julie-2024','rouge-2024','coursier-2024','participant','collectif',2,'');
call create_game_participation('maxime-2024','rouge-2024','coursier-2024','participant','collectif',2,'');
call create_game_participation('lea-2-2024','rouge-2024','coursier-2024','participant','collectif',2,'');

call create_game_participation('amri-2024','jaune-2024','coursier-2024','participant','collectif',1,'nourriture,kit-peche');
call create_game_participation('pauline-2024','jaune-2024','coursier-2024','participant','collectif',1,'nourriture,kit-peche');
call create_game_participation('sarah-2024','jaune-2024','coursier-2024','participant','collectif',1,'nourriture,kit-peche');
call create_game_participation('oceane-2024','jaune-2024','coursier-2024','participant','collectif',1,'nourriture,kit-peche');
call create_game_participation('sebastien-2024','jaune-2024','coursier-2024','participant','collectif',1,'nourriture,kit-peche');
call create_game_participation('lea-2024','jaune-2024','coursier-2024','participant','collectif',1,'nourriture,kit-peche');

call team_game_ranking ('jaune-2024','coursier-2024',1);
call team_game_ranking ('rouge-2024','coursier-2024',2);

call create_game('les-chasseurs-d-immunite','Catapulte','catapulte-2024','catapulte','collectif','immunite',11,14,'totem','construction,rapidite');
call create_game_participation('ricky-2024','rouge-2024','catapulte-2024','exclusion-apres-tirage-au-sort','collectif',2,'totem');
call create_game_participation('jean-2024','rouge-2024','catapulte-2024','participant','collectif',2,'conseil');
call create_game_participation('megane-2024','rouge-2024','catapulte-2024','participant','collectif',2,'conseil');
call create_game_participation('emilie-2024','rouge-2024','catapulte-2024','participant','collectif',2,'conseil');
call create_game_participation('meissa-2024','rouge-2024','catapulte-2024','participant','collectif',2,'conseil');
call create_game_participation('david-2024','rouge-2024','catapulte-2024','participant','collectif',2,'conseil');
call create_game_participation('cecile-2024','rouge-2024','catapulte-2024','participant','collectif',2,'conseil');
call create_game_participation('julie-2024','rouge-2024','catapulte-2024','exclusion-apres-tirage-au-sort','collectif',2,'conseil');
call create_game_participation('maxime-2024','rouge-2024','catapulte-2024','exclusion-apres-tirage-au-sort','collectif',2,'conseil');
call create_game_participation('lea-2-2024','rouge-2024','catapulte-2024','participant','collectif',2,'conseil');

call create_game_participation('amri-2024','jaune-2024','catapulte-2024','participant','collectif',1,'totem');
call create_game_participation('pauline-2024','jaune-2024','catapulte-2024','participant','collectif',1,'totem');
call create_game_participation('aurelien-2024','jaune-2024','catapulte-2024','participant','collectif',1,'totem');
call create_game_participation('sarah-2024','jaune-2024','catapulte-2024','participant','collectif',1,'totem');
call create_game_participation('oceane-2024','jaune-2024','catapulte-2024','participant','collectif',1,'totem');
call create_game_participation('sebastien-2024','jaune-2024','catapulte-2024','participant','collectif',1,'totem');
call create_game_participation('lea-2024','jaune-2024','catapulte-2024','participant','collectif',1,'totem');

call team_game_ranking ('jaune-2024','catapulte-2024',1);
call team_game_ranking ('rouge-2024','catapulte-2024',2);

-- vote

call first_vote_against ('les-chasseurs-d-immunite','julie-2024','emilie-2024','rouge-2024', 14, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','emilie-2024','lea-2-2024','rouge-2024', 14, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','maxime-2024','emilie-2024','rouge-2024', 14, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','jean-2024','emilie-2024','rouge-2024', 14, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','ricky-2024','emilie-2024','rouge-2024', 14, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','megane-2024','emilie-2024','rouge-2024', 14, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','lea-2-2024','emilie-2024','rouge-2024', 14, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','cecile-2024','lea-2-2024','rouge-2024', 14, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','meissa-2024','emilie-2024','rouge-2024', 14, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','david-2024','emilie-2024','rouge-2024', 14, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','emilie-2024','rouge-2024',14,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','emilie-2024',17,1,14);

call program_current_time ('les-chasseurs-d-immunite',14);
