
-- 10ème jour
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Tireurs', 'tireurs', NULL);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Exil d\'aventuriers', 'exil-d-aventuriers', 2, 0);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Amélioration camp', 'amelioration-camp', 4, 1);
INSERT INTO `GS_REWARD` (`NAME`, `WEB_PATH`, `GS_REWARD_TYPE_ID`, `IS_POSITIVE`) VALUES ('Smoothy', 'smoothy', 5, 1);
call create_game('le-totem-maudit','Tireurs en équipe','tireurs-en-equipe-2022','tireur','collectif','confort',8,10,'smoothy,amelioration-camp,exil-d-aventuriers','force,rapidite');

/*
comfort camp mobilier campement, smoothy,amelioration-camp-maudit, 2-aventuriers-bannis,epreuve
epreuve potence (tireurs)
jean charles exempte medical (rouge)
benjamin exempte par choix (jaune)
stephanie exempte par tirage au sort (jaune)
*/

call create_game_participation('louana-2022','rouge-2022','tireurs-en-equipe-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('maxime-2022','rouge-2022','tireurs-en-equipe-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('fouzi-2022','rouge-2022','tireurs-en-equipe-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('francois-2022','rouge-2022','tireurs-en-equipe-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('jean-philippe-2022','rouge-2022','tireurs-en-equipe-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('geraldine-2022','rouge-2022','tireurs-en-equipe-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('pauline-2022','rouge-2022','tireurs-en-equipe-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('jean-charles-2022','rouge-2022','tireurs-en-equipe-2022','exempte-sur-raison-medicale','collectif',1,'exil-d-aventuriers');
call create_game_participation('ambre-2022','rouge-2022','tireurs-en-equipe-2022','participant','collectif',1,'exil-d-aventuriers');

call create_game_participation('anne-sophie-2022','jaune-2022','tireurs-en-equipe-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('yannick-2022','jaune-2022','tireurs-en-equipe-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('bastien-2022','jaune-2022','tireurs-en-equipe-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('stephanie-2022','jaune-2022','tireurs-en-equipe-2022','exclusion-apres-tirage-au-sort','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('alexandra-2022','jaune-2022','tireurs-en-equipe-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('benjamin-2022','jaune-2022','tireurs-en-equipe-2022','exempte-par-choix','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('colin-2022','jaune-2022','tireurs-en-equipe-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('nicolas-2022','jaune-2022','tireurs-en-equipe-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('olga-2022','jaune-2022','tireurs-en-equipe-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('setha-2022','jaune-2022','tireurs-en-equipe-2022','participant','collectif',2,'smoothy,amelioration-camp');


call team_game_ranking ('jaune-2022','tireurs-en-equipe-2022',1);
call team_game_ranking ('rouge-2022','tireurs-en-equipe-2022',2);

-- setha, anne-sophie vs louana + pauline
-- 2 groupe de tireur
-- changement de porteur

/*
rouge cadlao

jaune --> matingi
*/

INSERT INTO `GS_REALISATION_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Découverte d\'un talisman', 'decouverte-talisman');
call create_participant_realisation ('le-totem-maudit','maxime-2022','rouge-2022',10,'decouverte-talisman',@realisation_id);
call create_participant_realisation ('le-totem-maudit','jean-philippe-2022','rouge-2022',10,'decouverte-talisman',@realisation_id);


call create_game('le-totem-maudit','Guide aveugle','guide-aveugle-2022','guide-aveugle','collectif','immunite',11,9,'conseil','rapidite,precision,voix,clarte');

call create_game_participation('louana-2022','rouge-2022','guide-aveugle-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('maxime-2022','rouge-2022','guide-aveugle-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('fouzi-2022','rouge-2022','guide-aveugle-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('francois-2022','rouge-2022','guide-aveugle-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('jean-philippe-2022','rouge-2022','guide-aveugle-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('geraldine-2022','rouge-2022','guide-aveugle-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('pauline-2022','rouge-2022','guide-aveugle-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('jean-charles-2022','rouge-2022','guide-aveugle-2022','participant','collectif',1,'exil-d-aventuriers');
call create_game_participation('ambre-2022','rouge-2022','guide-aveugle-2022','participant','collectif',1,'exil-d-aventuriers');

call create_game_participation('anne-sophie-2022','jaune-2022','guide-aveugle-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('yannick-2022','jaune-2022','guide-aveugle-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('bastien-2022','jaune-2022','guide-aveugle-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('stephanie-2022','jaune-2022','guide-aveugle-2022','exclusion-apres-tirage-au-sort','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('alexandra-2022','jaune-2022','guide-aveugle-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('benjamin-2022','jaune-2022','guide-aveugle-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('colin-2022','jaune-2022','guide-aveugle-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('nicolas-2022','jaune-2022','guide-aveugle-2022','participant','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('olga-2022','jaune-2022','guide-aveugle-2022','exclusion-apres-tirage-au-sort','collectif',2,'smoothy,amelioration-camp');
call create_game_participation('setha-2022','jaune-2022','guide-aveugle-2022','participant','collectif',2,'smoothy,amelioration-camp');


call team_game_ranking ('jaune-2022','guide-aveugle-2022',2);
call team_game_ranking ('rouge-2022','guide-aveugle-2022',1);

-- épreuve guide aveugle collectif
-- 8 aveugles 1 guide relais + construction

call first_vote_against ('le-totem-maudit','benjamin-2022','alexandra-2022','jaune-2022', 11, 'effectif');
call first_vote_against ('le-totem-maudit','bastien-2022','stephanie-2022','jaune-2022', 11, 'effectif');
call first_vote_against ('le-totem-maudit','yannick-2022','benjamin-2022','jaune-2022', 11, 'effectif');
call second_vote_against ('le-totem-maudit','yannick-2022','yannick-2022','jaune-2022', 11, 'effectif');
call vote ('le-totem-maudit','yannick-2022','yannick-2022','rouge-2022', 3, 11, 1, 'effectif', 'vote-contre');
call first_vote_against ('le-totem-maudit','alexandra-2022','benjamin-2022','jaune-2022', 11, 'effectif');
call first_vote_against ('le-totem-maudit','colin-2022','stephanie-2022','jaune-2022', 11, 'effectif');
call first_vote_against ('le-totem-maudit','olga-2022','stephanie-2022','jaune-2022', 11, 'effectif');
call first_vote_against ('le-totem-maudit','setha-2022','stephanie-2022','jaune-2022', 11, 'effectif');
call first_vote_against ('le-totem-maudit','stephanie-2022','benjamin-2022','jaune-2022', 11, 'effectif');
call first_vote_against ('le-totem-maudit','anne-sophie-2022','benjamin-2022','jaune-2022', 11, 'effectif');
call first_vote_against ('le-totem-maudit','nicolas-2022','stephanie-2022','jaune-2022', 11, 'effectif');

call second_round_first_vote_for ('le-totem-maudit','benjamin-2022','stephanie-2022','jaune-2022', 11, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','bastien-2022','stephanie-2022','jaune-2022', 11, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','yannick-2022','benjamin-2022','jaune-2022', 11, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','alexandra-2022','benjamin-2022','jaune-2022', 11, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','colin-2022','stephanie-2022','jaune-2022', 11, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','olga-2022','benjamin-2022','jaune-2022', 11, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','setha-2022','stephanie-2022','jaune-2022', 11, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','stephanie-2022','benjamin-2022','jaune-2022', 11, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','anne-sophie-2022','benjamin-2022','jaune-2022', 11, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','nicolas-2022','stephanie-2022','jaune-2022', 11, 'effectif');

INSERT INTO `GS_TEAM_DEPARTURE_TYPE` (`NAME`, `WEB_PATH`) VALUES ('Exclusion par duel après vote', 'exclusion-par-duel-apres-vote');

call create_participant_departure('le-totem-maudit','benjamin-2022','jaune-2022',11,'exclusion-par-duel-apres-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','benjamin-2022',19,1,11);


call program_current_time ('le-totem-maudit',11);
