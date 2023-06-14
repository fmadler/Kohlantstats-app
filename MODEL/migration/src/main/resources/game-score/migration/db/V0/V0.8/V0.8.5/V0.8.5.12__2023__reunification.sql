
INSERT INTO `GS_TEAM_DEPARTURE_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Tirage boule noire aux ambassadeur', 'tirage-boule-noire-ambassadeur');
INSERT INTO `GS_TEAM_DEPARTURE_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Tirage boule noirer', 'tirage-boule-noire');

call create_participant_realisation ('le-feu-sacre','grace-2023','jaune-2-2023',23,'ambassadeur-par-choix-d-equipe',@realisation_id);
call create_participant_realisation ('le-feu-sacre','quentin-2023','rouge-2-2023',23,'ambassadeur-par-choix-d-equipe',@realisation_id);
call create_participant_departure ('le-feu-sacre','quentin-2023','rouge-2-2023',23,'tirage-boule-noire-ambassadeur', @participant_team_id);
call create_participant_departure ('le-feu-sacre','grace-2023','jaune-2-2023',23,'abandon-volantaire', @participant_team_id);

call fill_participant_longevity ('le-feu-sacre','grace-2023',12,1,23);

call create_participant_departure ('le-feu-sacre','clemence-2023','rouge-2-2023',23,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-feu-sacre','gilles-2023','jaune-2-2023',23,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-feu-sacre','frederic-2023','rouge-2-2023',23,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-feu-sacre','nicolas-2023','jaune-2-2023',23,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-feu-sacre','esteban-2023','rouge-2-2023',23,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-feu-sacre','laura-2023','jaune-2-2023',23,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-feu-sacre','helena-2023','rouge-2-2023',23,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-feu-sacre','anne-sophie-2023','rouge-2-2023',23,'recomposition-des-equipes', @participant_team_id);

-- model issue Result consisted of more than one row
-- call create_participant_departure ('le-feu-sacre','tania-2023','jaune-2-2023',23,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-feu-sacre','julie-2023','jaune-2-2023',23,'recomposition-des-equipes', @participant_team_id);

call create_team('le-feu-sacre','Blanc','blanc-2023','Tribu blanche',23,40);

call create_participant_entrance ('le-feu-sacre','clemence-2023','blanc-2023',23,'reunification', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','gilles-2023','blanc-2023',23,'reunification', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','frederic-2023','blanc-2023',23,'reunification', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','nicolas-2023','blanc-2023',23,'reunification', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','esteban-2023','blanc-2023',23,'reunification', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','laura-2023','blanc-2023',23,'reunification', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','helena-2023','blanc-2023',23,'reunification', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','anne-sophie-2023','blanc-2023',23,'reunification', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','tania-2023','blanc-2023',23,'reunification', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','julie-2023','blanc-2023',23,'reunification', @participant_team_id);
call create_participant_entrance ('le-feu-sacre','quentin-2023','blanc-2023',23,'reunification', @participant_team_id);

call create_game('le-feu-sacre','Grappin','grappin-2023','grappin','individuel','immunite',16,24,'totem,vote-contre-soi','adresse,dexterite');

call create_game_participation('clemence-2023','blanc-2023','grappin-2023','participant','individuel',1,'totem');
call create_game_participation('gilles-2023','blanc-2023','grappin-2023','participant','individuel',2,'');
call create_game_participation('frederic-2023','blanc-2023','grappin-2023','participant','individuel',3,'');
call create_game_participation('nicolas-2023','blanc-2023','grappin-2023','participant','individuel',4,'');
call create_game_participation('esteban-2023','blanc-2023','grappin-2023','participant','individuel',5,'');
call create_game_participation('quentin-2023','blanc-2023','grappin-2023','participant','individuel',6,'');
call create_game_participation('laura-2023','blanc-2023','grappin-2023','participant','individuel',7,'');
call create_game_participation('helena-2023','blanc-2023','grappin-2023','participant','individuel',8,'');
call create_game_participation('anne-sophie-2023','blanc-2023','grappin-2023','participant','individuel',9,'');
call create_game_participation('tania-2023','blanc-2023','grappin-2023','participant','individuel',10,'');
call create_game_participation('julie-2023','blanc-2023','grappin-2023','participant','individuel',11,'vote-contre-soi');

call first_vote_against ('le-feu-sacre','clemence-2023','julie-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','gilles-2023','anne-sophie-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','frederic-2023','anne-sophie-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','nicolas-2023','anne-sophie-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','esteban-2023','anne-sophie-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','quentin-2023','tania-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','laura-2023','anne-sophie-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','helena-2023','tania-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','anne-sophie-2023','tania-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','tania-2023','anne-sophie-2023','rouge-2-2023', 9, 'effectif');
call first_vote_against ('le-feu-sacre','julie-2023','anne-sophie-2023','rouge-2-2023', 9, 'effectif');
call second_vote_against ('le-feu-sacre','julie-2023','julie-2023','rouge-2-2023', 9, 'effectif');

call create_participant_departure('le-feu-sacre','anne-sophie-2023','blanc-2023',24,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-feu-sacre','anne-sophie-2023',11,1,24);

call program_current_time ('le-feu-sacre',24);
