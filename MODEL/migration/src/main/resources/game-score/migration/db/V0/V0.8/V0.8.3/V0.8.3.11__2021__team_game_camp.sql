INSERT INTO `GS_REALISATION_TYPE` (`WEB_PATH`, `NAME`) VALUES ('ambassadeur-par-victoire', 'ambassadeur-par-victoire');
INSERT INTO `GS_TEAM_DEPARTURE_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Choix des ambassadeurs', 'choix-des-ambassadeurs');

call create_team('la-legende-2021','Ile des bannis','ile-des-bannis-2-2021','Ile des bannis',18,35);

call create_participant_realisation ('la-legende-2021','phil-2012','jaune-2021-2',18,'ambassadeur-par-choix-adverse',@realisation_id);
call create_participant_realisation ('la-legende-2021','laurent-2011','rouge-2021-2',18,'ambassadeur-par-choix-adverse',@realisation_id);
call create_participant_realisation ('la-legende-2021','ugo-2012','ile-des-bannis-2021',18,'ambassadeur-par-victoire',@realisation_id);
call create_participant_realisation ('la-legende-2021','clemence-2005','ile-des-bannis-2021',18,'ambassadeur-par-victoire',@realisation_id);

call create_participant_departure ('la-legende-2021','coumba-2010','jaune-2021-2',18,'choix-des-ambassadeurs', @participant_team_id);
call create_participant_entrance ('la-legende-2021','coumba-2010','ile-des-bannis-2-2021',18,'constitution-des-equipes', @participant_team_id);

--
-- changement d'équipe
-- 
call create_participant_departure ('la-legende-2021','claude-2010','jaune-2021-2',18,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('la-legende-2021','sam-2018','jaune-2021-2',18,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('la-legende-2021','phil-2012','jaune-2021-2',18,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('la-legende-2021','christelle-2008','jaune-2021-2',18,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('la-legende-2021','loic-2020','rouge-2021-2',18,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('la-legende-2021','teheiura-2011','rouge-2021-2',18,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('la-legende-2021','laurent-2011','rouge-2021-2',18,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('la-legende-2021','namadia-2012','rouge-2021-2',18,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('la-legende-2021','jade-2007','rouge-2021-2',18,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('la-legende-2021','ugo-2012','ile-des-bannis-2021',18,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('la-legende-2021','clemence-2005','ile-des-bannis-2021',18,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('la-legende-2021','alexandra-2020','rouge-2021-2',18,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('la-legende-2021','alix-2020','rouge-2021-2',18,'recomposition-des-equipes', @participant_team_id);

call create_team('la-legende-2021','Blanc','blanc-2021-2','Rouge',18,40);

call create_participant_entrance ('la-legende-2021','claude-2010','blanc-2021-2',18,'reunification', @participant_team_id);
call create_participant_entrance ('la-legende-2021','sam-2018','blanc-2021-2',18,'reunification', @participant_team_id);
call create_participant_entrance ('la-legende-2021','phil-2012','blanc-2021-2',18,'reunification', @participant_team_id);
call create_participant_entrance ('la-legende-2021','christelle-2008','blanc-2021-2',18,'reunification', @participant_team_id);
call create_participant_entrance ('la-legende-2021','loic-2020','blanc-2021-2',18,'reunification', @participant_team_id);
call create_participant_entrance ('la-legende-2021','teheiura-2011','blanc-2021-2',18,'reunification', @participant_team_id);
call create_participant_entrance ('la-legende-2021','laurent-2011','blanc-2021-2',18,'reunification', @participant_team_id);
call create_participant_entrance ('la-legende-2021','namadia-2012','blanc-2021-2',18,'reunification', @participant_team_id);
call create_participant_entrance ('la-legende-2021','jade-2007','blanc-2021-2',18,'reunification', @participant_team_id);
call create_participant_entrance ('la-legende-2021','ugo-2012','blanc-2021-2',18,'reunification', @participant_team_id);
call create_participant_entrance ('la-legende-2021','clemence-2005','blanc-2021-2',18,'reunification', @participant_team_id);
call create_participant_entrance ('la-legende-2021','alexandra-2020','blanc-2021-2',18,'reunification', @participant_team_id);
call create_participant_entrance ('la-legende-2021','alix-2020','blanc-2021-2',18,'reunification', @participant_team_id);


call create_game('la-legende-2021','A bout de souffle','apnee-2021','apnee','individuel','immunite',19,19,'totem,vote-contre-soi','statique,apnee,patience');

call create_game_participation('claude-2010','blanc-2021-2','apnee-2021','participant','individuel',2,'');
call create_game_participation('sam-2018','blanc-2021-2','apnee-2021','participant','individuel',4,'');
call create_game_participation('phil-2012','blanc-2021-2','apnee-2021','participant','individuel',11,'');
call create_game_participation('christelle-2008','blanc-2021-2','apnee-2021','participant','individuel',8,'');
call create_program_game_participation('la-legende-2021','loic-2020','blanc-2021-2','apnee-2021','participant','individuel',6,'');
call create_game_participation('teheiura-2011','blanc-2021-2','apnee-2021','participant','individuel',12,'');
call create_game_participation('laurent-2011','blanc-2021-2','apnee-2021','participant','individuel',3,'');
call create_game_participation('namadia-2012','blanc-2021-2','apnee-2021','participant','individuel',13,'vote-contre-soi');
call create_game_participation('jade-2007','blanc-2021-2','apnee-2021','participant','individuel',7,'');
call create_game_participation('ugo-2012','blanc-2021-2','apnee-2021','participant','individuel',9,'');
call create_game_participation('clemence-2005','blanc-2021-2','apnee-2021','participant','individuel',1,'');
call create_program_game_participation('la-legende-2021','alexandra-2020','blanc-2021-2','apnee-2021','participant','individuel',10,'');
call create_program_game_participation('la-legende-2021','alix-2020','blanc-2021-2','apnee-2021','participant','individuel',5,'');

INSERT INTO `GS_VOTE_EFFECTIVENESS_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Annulé par amulette d''immunité', 'annule-par-amulette-immunite');

call first_vote_against ('la-legende-2021','christelle-2008','alexandra-2020','blanc-2021-2', 19, 'effectif');
call first_vote_against ('la-legende-2021','ugo-2012','alix-2020','blanc-2021-2', 19, 'annule-par-amulette-immunite');

call first_vote_against ('la-legende-2021','clemence-2005','namadia-2012','blanc-2021-2', 19, 'effectif');
call first_vote_against ('la-legende-2021','claude-2010','alix-2020','blanc-2021-2', 19, 'annule-par-amulette-immunite');
call first_vote_against ('la-legende-2021','phil-2012','alix-2020','blanc-2021-2', 19, 'annule-par-amulette-immunite');
call first_vote_against ('la-legende-2021','sam-2018','alix-2020','blanc-2021-2', 19, 'annule-par-amulette-immunite');
call first_vote_against ('la-legende-2021','alexandra-2020','namadia-2012','blanc-2021-2', 19, 'effectif');
call first_vote_against ('la-legende-2021','jade-2007','alix-2020','blanc-2021-2', 19, 'annule-par-amulette-immunite');
call first_vote_against ('la-legende-2021','alix-2020','namadia-2012','blanc-2021-2', 19, 'effectif');
call first_vote_against ('la-legende-2021','teheiura-2011','alix-2020','blanc-2021-2', 19, 'annule-par-amulette-immunite');
call first_vote_against ('la-legende-2021','laurent-2011','christelle-2008','blanc-2021-2', 19, 'effectif');
call first_vote_against ('la-legende-2021','namadia-2012','christelle-2008','blanc-2021-2', 19, 'effectif');
call second_vote_against ('la-legende-2021','namadia-2012','namadia-2012','blanc-2021-2', 19, 'effectif');
call first_vote_against ('la-legende-2021','loic-2020','christelle-2008','blanc-2021-2', 19, 'effectif');

call create_participant_departure ('la-legende-2021','namadia-2012','blanc-2021-2',19,'exclusion-par-vote', @participant_team_id);

call create_participant_entrance ('la-legende-2021','namadia-2012','ile-des-bannis-2-2021',20,'constitution-des-equipes', @participant_team_id);
