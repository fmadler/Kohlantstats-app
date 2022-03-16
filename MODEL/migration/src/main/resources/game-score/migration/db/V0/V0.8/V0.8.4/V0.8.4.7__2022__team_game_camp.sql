
-- 10ème jour
INSERT INTO `GS_GAME_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Tireurs', 'tireurs', NULL);

call create_game('le-totem-maudit','Tireurs en équipe','tireurs-en-equipe-2022','tireur','collectif','confort',8,10,'smoothy,amelioration-camp-maudit,exil-d-aventuriers','force,rapidite');

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

-- victoire pour les jaunes

/*
rouge cadlao

jaune --> matingi
*/

call create_participant_realisation ('la-totem-maudit','maxime-2022','rouge-2022',10,'decouverte-talisman',@realisation_id);
call create_participant_realisation ('la-totem-maudit','jean-philippe-2022','rouge-2022',10,'decouverte-talisman',@realisation_id);


-- 2 talismans trouvés par maxime et jean-philippe


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


-- olga exemption par tirage au sort



-- victoire pour les rouges

/*
vote 11ème hour'

benjamin->alexandra
bastien->stephanie
yannick->benjamin
yannick-->yannick
yannick-->yannick
alexandra->benjamin
colin->stephanie
olga->stephanie
setha->stephanie
stéphanie->benjamin
anne-sophie->benjamin
nicolas->stephanie


vote contre setha
4/4 steph/ben





benjamin->stephanie
bastien->stephanie
yannick->benjamin
alexandra->benjamin
colin->stephanie
olga->stephanie
setha->stephanie
stéphanie->benjamin
anne-sophie->benjamin
nicolas->stephanie

5/5

tirage au sort

départ de benjamin (par tirage au sort)


 */