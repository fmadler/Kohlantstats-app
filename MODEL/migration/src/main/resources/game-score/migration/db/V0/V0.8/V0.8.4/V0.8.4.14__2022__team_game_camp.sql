INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Peche à la languouste', 'peche-languouste', 5, 1);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Nuit dans un hamac', 'nuit-hamac', 1, 1);

call create_game('le-totem-maudit','Degustation & Bain de boue','degustation-boue-2022','degustation','binome','confort',28,22,'peche-languoste,nuit-hamac','degustation,rapidite');
-- degustation + boue

call create_game_participation('francois-2022','blanc-2022','degustation-boue-2022','participant','binome',0,'');
call create_game_participation('olga-2022','blanc-2022','degustation-boue-2022','participant','binome',0,'');
call create_game_participation('maxime-2022','blanc-2022','degustation-boue-2022','participant','binome',0,'');
call create_game_participation('louana-2022','blanc-2022','degustation-boue-2022','participant','binome',0,'');
call create_game_participation('ambre-2022','blanc-2022','degustation-boue-2022','participant','binome',1,'peche-languouste,nuit-hamac');
call create_game_participation('bastien-2022','blanc-2022','degustation-boue-2022','participant','binome',1,'peche-languouste,nuit-hamac');
call create_game_participation('fouzi-2022','blanc-2022','degustation-boue-2022','participant','binome',0,'');
call create_game_participation('geraldine-2022','blanc-2022','degustation-boue-2022','participant','binome',0,'');
call create_game_participation('jean-charles-2022','blanc-2022','degustation-boue-2022','participant','binome',0,'');
call create_game_participation('nicolas-2022','blanc-2022','degustation-boue-2022','participant','binome',0,'');

-- 30 ème jour
--
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Equilibre avec perche', 'equilibre-perche', NULL);

-- parcours du combattant + puzzle pour les 2 premiers
call create_game('le-totem-maudit','Equilibre en duo avec perche','equilibre-perche-2022','equilibre-perche','binome','immunite',30,24,'totem,vote-contre-soi-du-dernier','rapidite,force,endurance');

call create_game_participation('louana-2022','blanc-2022','equilibre-perche-2022','participant','binome',3,'');
call create_game_participation('maxime-2022','blanc-2022','equilibre-perche-2022','participant','binome',3,'');
call create_game_participation('fouzi-2022','blanc-2022','equilibre-perche-2022','participant','binome',7,'');
call create_game_participation('geraldine-2022','blanc-2022','equilibre-perche-2022','participant','binome',7,'');
call create_game_participation('francois-2022','blanc-2022','equilibre-perche-2022','participant','binome',1,'totem');
call create_game_participation('olga-2022','blanc-2022','equilibre-perche-2022','participant','binome',1,'totem');
call create_game_participation('ambre-2022','blanc-2022','equilibre-perche-2022','participant','binome',5,'');
call create_game_participation('bastien-2022','blanc-2022','equilibre-perche-2022','participant','binome',5,'');
call create_game_participation('nicolas-2022','blanc-2022','equilibre-perche-2022','participant','binome',9,'vote-contre-soi');
call create_game_participation('jean-charles-2022','blanc-2022','equilibre-perche-2022','participant','binome',9,'vote-contre-soi');


call first_vote_against ('le-totem-maudit','louana-2022','fouzi-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','maxime-2022','nicolas-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','fouzi-2022','nicolas-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','francois-2022','maxime-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','geraldine-2022','nicolas-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','jean-charles-2022','fouzi-2022','blanc-2022', 31, 'effectif');
call second_vote_against ('le-totem-maudit','jean-charles-2022','jean-charles-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','ambre-2022','maxime-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','bastien-2022','maxime-2022','blanc-2022', 31, 'effectif');

call first_vote_against ('le-totem-maudit','olga-2022','maxime-2022','blanc-2022', 31, 'effectif');
call second_vote_against ('le-totem-maudit','olga-2022','maxime-2022','blanc-2022', 31, 'effectif');
call first_vote_against ('le-totem-maudit','nicolas-2022','fouzi-2022','blanc-2022', 31, 'effectif');
call second_vote_against ('le-totem-maudit','nicolas-2022','nicolas-2022','blanc-2022', 31, 'effectif');


call create_participant_departure('le-totem-maudit','maxime-2022','blanc-2022',31,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','maxime-2022',10,1,31);

call create_participant_departure('le-totem-maudit','louana-2022','blanc-2022',31,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','louana-2022',9,1,31);

call program_current_time ('le-totem-maudit',31);


