-- 35
call create_game('le-totem-maudit','Parcours lesté','parcours-leste-2022','parcours-leste','individuel','confort',27,35,'villa-luxe','rapidite,strategie,force');
-- homme init 6kg, femme init 3kg

call create_game_participation('francois-2022','blanc-2022','parcours-leste-2022','participant','individuel',1,'villa-luxe');
call create_game_participation('olga-2022','blanc-2022','parcours-leste-2022','participant','individuel',3,'');
call create_game_participation('ambre-2022','blanc-2022','parcours-leste-2022','participant','individuel',2,'villa-luxe');
call create_game_participation('bastien-2022','blanc-2022','parcours-leste-2022','participant','individuel',4,'');
call create_game_participation('geraldine-2022','blanc-2022','parcours-leste-2022','participant','individuel',5,'');
call create_game_participation('jean-charles-2022','blanc-2022','parcours-leste-2022','participant','individuel',6,'');


INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Pallets sur rail', 'pallets-sur-rail', NULL);
call create_game('le-totem-maudit','Pallets sur rail','pallets-sur-rail-2022','pallets-sur-rail','individuel','immunite',28,36,'totem,vote-contre-soi','rapidite,strategie,force');


call create_game_participation('francois-2022','blanc-2022','pallets-sur-rail-2022','participant','individuel',2,'');
call create_game_participation('olga-2022','blanc-2022','pallets-sur-rail-2022','participant','individuel',4,'');
call create_game_participation('ambre-2022','blanc-2022','pallets-sur-rail-2022','participant','individuel',2,'');
call create_game_participation('bastien-2022','blanc-2022','pallets-sur-rail-2022','participant','individuel',1,'');
call create_game_participation('geraldine-2022','blanc-2022','pallets-sur-rail-2022','participant','individuel',3,'');
call create_game_participation('jean-charles-2022','blanc-2022','pallets-sur-rail-2022','participant','individuel',6,'vote-contre-soi');

call first_vote_against ('le-totem-maudit','maxime-2022','nicolas-2022','blanc-2022', 36, 'effectif');
call first_vote_against ('le-totem-maudit','francois-2022','olga-2022','blanc-2022', 36, 'effectif');
call second_vote_against ('le-totem-maudit','francois-2022','olga-2022','blanc-2022', 36, 'effectif');
call first_vote_against ('le-totem-maudit','geraldine-2022','jean-charles-2022','blanc-2022', 36, 'effectif');
call first_vote_against ('le-totem-maudit','jean-charles-2022','geraldine-2022','blanc-2022', 36, 'effectif');
call second_vote_against ('le-totem-maudit','jean-charles-2022','jean-charles-2022','blanc-2022', 36, 'effectif');
call first_vote_against ('le-totem-maudit','ambre-2022','olga-2022','blanc-2022', 36, 'effectif');
call first_vote_against ('le-totem-maudit','bastien-2022','geraldine-2022','blanc-2022', 36, 'effectif');
call first_vote_against ('le-totem-maudit','olga-2022','ambre-2022','blanc-2022', 36, 'effectif');


call create_participant_departure('le-totem-maudit','olga-2022','blanc-2022',36,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','olga-2022',6,1,36);

call program_current_time ('le-totem-maudit',36);


