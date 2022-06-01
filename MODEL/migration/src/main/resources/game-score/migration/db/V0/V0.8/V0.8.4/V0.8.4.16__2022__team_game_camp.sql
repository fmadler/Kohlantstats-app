-- 32


-- 2 avantages strategiques
-- un collier
-- un double vote
-- lettre
call create_participant_realisation ('le-totem-maudit','jean-charles-2022','blanc-2022',34,'decouverte-collier-immunite',@realisation_id);

INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Equilibre sur l''eau', 'equilibre-sur-eau', NULL);
call create_game('le-totem-maudit','Equilibre sur l''eau','equilibre-sur-eau-2022','equilibre-sur-eau','individuel','immunite',26,34,'totem','rapidite,equilibree');
-- degustation + boue

call create_game_participation('francois-2022','blanc-2022','equilibre-sur-eau-2022','participant','individuel',3,'');
call create_game_participation('olga-2022','blanc-2022','equilibre-sur-eau-2022','participant','individuel',1,'');
call create_game_participation('ambre-2022','blanc-2022','equilibre-sur-eau-2022','participant','individuel',6,'');
call create_game_participation('bastien-2022','blanc-2022','equilibre-sur-eau-2022','participant','individuel',2,'');
call create_game_participation('geraldine-2022','blanc-2022','equilibre-sur-eau-2022','participant','individuel',5,'');
call create_game_participation('jean-charles-2022','blanc-2022','equilibre-sur-eau-2022','participant','individuel',6,'');
call create_game_participation('nicolas-2022','blanc-2022','equilibre-sur-eau-2022','participant','individuel',4,'');

call first_vote_against ('le-totem-maudit','maxime-2022','nicolas-2022','blanc-2022', 34, 'effectif');
call first_vote_against ('le-totem-maudit','francois-2022','jean-charles-2022','blanc-2022', 34, 'effectif');
call first_vote_against ('le-totem-maudit','geraldine-2022','nicolas-2022','blanc-2022', 34, 'effectif');
call first_vote_against ('le-totem-maudit','jean-charles-2022','nicolas-2022','blanc-2022', 34, 'effectif');
call first_vote_against ('le-totem-maudit','ambre-2022','jean-charles-2022','blanc-2022', 34, 'effectif');
call first_vote_against ('le-totem-maudit','bastien-2022','geraldine-2022','blanc-2022', 34, 'effectif');

call first_vote_against ('le-totem-maudit','olga-2022','nicolas-2022','blanc-2022', 34, 'effectif');
call second_vote_against ('le-totem-maudit','olga-2022','nicolas-2022','blanc-2022', 34, 'effectif');
call first_vote_against ('le-totem-maudit','nicolas-2022','geraldine-2022','blanc-2022', 34, 'effectif');
call second_vote_against ('le-totem-maudit','nicolas-2022','geraldine-2022','blanc-2022', 34, 'effectif');


call create_participant_departure('le-totem-maudit','nicolas-2022','blanc-2022',34,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','nicolas-2022',8,1,34);

call program_current_time ('le-totem-maudit',34);


