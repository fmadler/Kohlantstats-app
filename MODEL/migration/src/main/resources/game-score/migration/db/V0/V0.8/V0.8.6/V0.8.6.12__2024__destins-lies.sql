call create_game('les-chasseurs-d-immunite','Boue','boue-2024','boue','binome','confort',20,27,'excursion-chez-l-habitant,avantage-strategique','rapidite,precision');

call create_game_participation('jean-2024','blanc-2024','boue-2024','participant','binome',1,'excursion-chez-l-habitant,avantage-strategique');
call create_game_participation('megane-2024','blanc-2024','boue-2024','participant','binome',1,'excursion-chez-l-habitant,avantage-strategique');
call create_game_participation('meissa-2024','blanc-2024','boue-2024','participant','binome',0,'');
call create_game_participation('david-2024','blanc-2024','boue-2024','participant','binome',0,'');
call create_game_participation('julie-2024','blanc-2024','boue-2024','participant','binome',0,'');
call create_game_participation('amri-2024','blanc-2024','boue-2024','participant','binome',0,'');
call create_game_participation('pauline-2024','blanc-2024','boue-2024','participant','binome',0,'');
call create_game_participation('aurelien-2024','blanc-2024','boue-2024','participant','binome',0,'');
call create_game_participation('sebastien-2024','blanc-2024','boue-2024','participant','binome',0,'');
call create_game_participation('lea-2024','blanc-2024','boue-2024','participant','binome',8,'');

call create_game('les-chasseurs-d-immunite','Equilibre avec perche','equilibre-avec-perche-2024','equilibre-avec-perche','binome','immunite',21,28,'totem','calme,equilibre,patience');

call create_game_participation('jean-2024','blanc-2024','equilibre-avec-perche-2024','participant','binome',1,'totem');
call create_game_participation('megane-2024','blanc-2024','equilibre-avec-perche-2024','participant','binome',1,'totem');
call create_game_participation('meissa-2024','blanc-2024','equilibre-avec-perche-2024','participant','binome',0,'');
call create_game_participation('david-2024','blanc-2024','equilibre-avec-perche-2024','participant','binome',0,'');
call create_game_participation('julie-2024','blanc-2024','equilibre-avec-perche-2024','participant','binome',0,'');
call create_game_participation('amri-2024','blanc-2024','equilibre-avec-perche-2024','participant','binome',0,'');
call create_game_participation('pauline-2024','blanc-2024','equilibre-avec-perche-2024','participant','binome',0,'');
call create_game_participation('aurelien-2024','blanc-2024','equilibre-avec-perche-2024','participant','binome',0,'');
call create_game_participation('sebastien-2024','blanc-2024','equilibre-avec-perche-2024','participant','binome',0,'');
call create_game_participation('lea-2024','blanc-2024','equilibre-avec-perche-2024','participant','binome',0,'');

call first_vote_against ('les-chasseurs-d-immunite','megane-2024','sebastien-2024','blanc-2024', 29, 'annule-par-collier-immunite');
call second_vote_against ('les-chasseurs-d-immunite','megane-2024','sebastien-2024','blanc-2024', 29, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','david-2024','sebastien-2024','blanc-2024', 29, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','julie-2024','sebastien-2024','blanc-2024', 29, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','jean-2024','sebastien-2024','blanc-2024', 29, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','meissa-2024','sebastien-2024','blanc-2024', 29, 'annule-par-collier-immunite');
call first_vote_against ('les-chasseurs-d-immunite','pauline-2024','cecile-2024','blanc-2024', 29, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','amri-2024','meissa-2024','blanc-2024', 29, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','sebastien-2024','meissa-2024','blanc-2024', 29, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','aurelien-2024','meissa-2024','blanc-2024', 29, 'effectif');
call first_vote_against ('les-chasseurs-d-immunite','lea-2024','lea-2024','blanc-2024', 29, 'effectif');

call create_participant_departure('les-chasseurs-d-immunite','sebastien-2024','blanc-2024',29,'exclusion-par-vote', @participant_team_id);
call create_participant_departure('les-chasseurs-d-immunite','aurelien-2024','blanc-2024',29,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('les-chasseurs-d-immunite','sebastien-2024',10,1,29);
call fill_participant_longevity ('les-chasseurs-d-immunite','aurelien-2024',9,1,29);

call program_current_time ('les-chasseurs-d-immunite',29);
