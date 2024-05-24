INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Nuit tout confort avec un proche', 'nuit-hotel-avec-un-proche', 7, 1);

call create_game('les-chasseurs-d-immunite','Parcours en cinq étapes','parcours-en-cinq-etapes-2024','parcours-en-cinq-etapes','individuel','confort',27,35,'nuit-hotel-avec-un-proche,avantage-strategique','force,equilibre,rapidite');

call create_game_participation('sebastien-2024','blanc-2024','parcours-en-cinq-etapes-2024','participant','individuel',2,'nuit-hotel,avantage-strategique');
call create_game_participation('meissa-2024','blanc-2024','parcours-en-cinq-etapes-2024','participant','individuel',1,'nuit-hotel-avec-un-proche');
call create_game_participation('julie-2024','blanc-2024','parcours-en-cinq-etapes-2024','participant','individuel',6,'nuit-hotel');
call create_game_participation('amri-2024','blanc-2024','parcours-en-cinq-etapes-2024','participant','individuel',3,'');
call create_game_participation('pauline-2024','blanc-2024','parcours-en-cinq-etapes-2024','participant','individuel',4,'');
call create_game_participation('lea-2024','blanc-2024','parcours-en-cinq-etapes-2024','participant','individuel',5,'');

-- seb gagne indice
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Plan incliné et placement de boules', 'plan-incline-boules', NULL);
call create_game('les-chasseurs-d-immunite','Plan incliné et placement de boules','plan-incline-boules-2024','plan-incline-boules','individuel','immunite',28,36,'totem,vote-contre-soi','rapidite,logique,construction');

call create_game_participation('sebastien-2024','blanc-2024','plan-incline-boules-2024','participant','individuel',2,'');
call create_game_participation('meissa-2024','blanc-2024','plan-incline-boules-2024','participant','individuel',1,'totem');
call create_game_participation('julie-2024','blanc-2024','plan-incline-boules-2024','participant','individuel',5,'');
call create_game_participation('amri-2024','blanc-2024','plan-incline-boules-2024','participant','individuel',6,'vote-contre-soi');
call create_game_participation('pauline-2024','blanc-2024','plan-incline-boules-2024','participant','individuel',4,'');
call create_game_participation('lea-2024','blanc-2024','plan-incline-boules-2024','participant','individuel',3,'');


call first_vote_against ('les-chasseurs-d-immunite','sebastien-2024','julie-2024','blanc-2024', 36, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','meissa-2024','sebastien-2024','blanc-2024', 36, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','lea-2024','julie-2024','blanc-2024', 36, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','pauline-2024','sebastien-2024','blanc-2024', 36, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','amri-2024','sebastien-2024','blanc-2024', 36, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','julie-2024','sebastien-2024','blanc-2024', 36, 'effectif');
call second_vote_against ('les-chasseurs-d-immunite','sebastien-2024','julie-2024','blanc-2024', 36, 'effectif');
call second_vote_against ('les-chasseurs-d-immunite','amri-2024','amri-2024','blanc-2024', 36, 'effectif');
call third_vote_against ('les-chasseurs-d-immunite','sebastien-2024','sebastien-2024','blanc-2024', 36, 'effectif');

-- call create_participant_departure('les-chasseurs-d-immunite','sebastien-2024','blanc-2024',36,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','sebastien-2024',6,1,36);

call program_current_time ('les-chasseurs-d-immunite',36);
