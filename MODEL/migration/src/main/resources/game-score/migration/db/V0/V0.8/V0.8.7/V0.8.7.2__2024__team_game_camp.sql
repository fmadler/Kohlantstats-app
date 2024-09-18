
--
-- tribu maudite recherche anito blancinsert into gs_reward (name, web_path, gs_reward_type_id, is_positive) values ('Exclusion sélection initial','exclusion-selection-initiale',9,0);
insert into gs_reward (name, web_path, gs_reward_type_id, is_positive) values ('Participation à un duel de réintegration','duel-de-reintegration',9,1);
INSERT INTO `GS_GAME_STAKE_TYPE` (`NAME`, `WEB_PATH`, `DESCRIPTION`) VALUES ('Duel', 'duel', 'participation à un duel');

call create_game('la-tribu-maudite','Anito','anito-2024','anito','collectif','duel',3,3,'duel-de-reintegration','recherche,patience');
call create_game_participation('nathanael-2024','tribu-maudite-2024','anito-2024','participant','individuel',0,'');
call create_game_participation('melissa-2024','tribu-maudite-2024','anito-2024','participant','individuel',0,'');
call create_game_participation('vanessa-2024','tribu-maudite-2024','anito-2024','participant','individuel',0,'');
call create_game_participation('ilyesse-2024','tribu-maudite-2024','anito-2024','participant','individuel',1,'');

call create_game('la-tribu-maudite','Flambeaux','flambeaux-2-2024','flambeaux','collectif','confort',4,3,'kit-peche,duel-de-reintegration','force,logique,rapidite');

call create_game_participation('jacques-2024','jaune-2-2024','flambeaux-2-2024','participant','collectif',0,'');
call create_game_participation('frederic-2023','jaune-2-2024','flambeaux-2-2024','participant','collectif',0,'');
call create_game_participation('fabrice-2024','jaune-2-2024','flambeaux-2-2024','participant','collectif',0,'');
call create_game_participation('thibault-2024','jaune-2-2024','flambeaux-2-2024','participant','collectif',0,'');
call create_game_participation('michel-2024','jaune-2-2024','flambeaux-2-2024','participant','collectif',0,'');
call create_game_participation('charlotte-2024','jaune-2-2024','flambeaux-2-2024','participant','collectif',0,'');
call create_game_participation('lola-2024','jaune-2-2024','flambeaux-2-2024','participant','collectif',0,'');
call create_game_participation('sophia-2024','jaune-2-2024','flambeaux-2-2024','participant','collectif',0,'');
call create_game_participation('emmanuelle-2024','jaune-2-2024','flambeaux-2-2024','participant','collectif',1,'duel-de-reintegration');

call create_game_participation('gustin-2024','rouge-2-2024','flambeaux-2-2024','participant','collectif',1,'kit-peche');
call create_game_participation('ugo-2012','rouge-2-2024','flambeaux-2-2024','participant','collectif',1,'kit-peche');
call create_game_participation('alexandre-2024','rouge-2-2024','flambeaux-2-2024','participant','collectif',1,'kit-peche');
call create_game_participation('maxim-2024','rouge-2-2024','flambeaux-2-2024','participant','collectif',1,'kit-peche');
call create_game_participation('cecile-2-2024','rouge-2-2024','flambeaux-2-2024','participant','collectif',1,'kit-peche');
call create_game_participation('sarah-2-2024','rouge-2-2024','flambeaux-2-2024','participant','collectif',1,'kit-peche');
call create_game_participation('ari-2024','rouge-2-2024','flambeaux-2-2024','participant','collectif',1,'kit-peche');
call create_game_participation('cassandre-2024','rouge-2-2024','flambeaux-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'kit-peche');
call create_game_participation('marie-2024','rouge-2-2024','flambeaux-2-2024','participant','collectif',1,'kit-peche');
call create_game_participation('maude-2024','rouge-2-2024','flambeaux-2-2024','participant','collectif',1,'kit-peche');

-- call create_game('la-legende-2021','Table bascule','table-bascule-2021-2','table-bascule','individuel','arene',23,24,'exclusion-immediate,continuation-aventure','concentration,precision,rapidite');

-- call create_game('la-tribu-maudite','Equilibre-bascule','equilibre-bascule-2-2024','table-bascule','individuel','duel',5,3,'duel-de-reintegration','rapidite,precision');
call create_game('la-tribu-maudite','Equilibre-bascule','equilibre-bascule-2-2024','table-bascule','individuel','arene',5,3,'continuation-aventure','rapidite,precision');

call create_game_participation('ilyesse-2024','rouge-2-2024','equilibre-bascule-2-2024','participant','individuel',0,'');
call create_game_participation('emmanuelle-2024','rouge-2-2024','equilibre-bascule-2-2024','participant','individuel',1,'');

-- TODO departure emmanuel entry tribu-maudite
-- TODO departure ilyesse entry tribu-maudite


call create_game('la-tribu-maudite','Catapulte','catapulte-2-2024','catapulte','collectif','immunite',6,4,'totem','force,precision,rapidite');

call create_game_participation('jacques-2024','jaune-2-2024','catapulte-2-2024','participant','collectif',1,'totem');
call create_game_participation('frederic-2023','jaune-2-2024','catapulte-2-2024','participant','collectif',1,'totem');
call create_game_participation('fabrice-2024','jaune-2-2024','catapulte-2-2024','participant','collectif',1,'totem');
call create_game_participation('thibault-2024','jaune-2-2024','catapulte-2-2024','participant','collectif',1,'totem');
call create_game_participation('michel-2024','jaune-2-2024','catapulte-2-2024','participant','collectif',1,'totem');
call create_game_participation('charlotte-2024','jaune-2-2024','catapulte-2-2024','participant','collectif',1,'totem');
call create_game_participation('lola-2024','jaune-2-2024','catapulte-2-2024','participant','collectif',1,'totem');
call create_game_participation('sophia-2024','jaune-2-2024','catapulte-2-2024','participant','collectif',1,'totem');
call create_game_participation('ilyesse-2024','jaune-2-2024','catapulte-2-2024','participant','collectif',1,'totem');

call create_game_participation('gustin-2024','rouge-2-2024','catapulte-2-2024','participant','collectif',0,'conseil');
call create_game_participation('ugo-2012','rouge-2-2024','catapulte-2-2024','participant','collectif',0,'conseil');
call create_game_participation('alexandre-2024','rouge-2-2024','catapulte-2-2024','participant','collectif',0,'conseil');
call create_game_participation('maxim-2024','rouge-2-2024','catapulte-2-2024','participant','collectif',0,'conseil');
call create_game_participation('cecile-2-2024','rouge-2-2024','catapulte-2-2024','participant','collectif',0,'conseil');
call create_game_participation('sarah-2-2024','rouge-2-2024','catapulte-2-2024','participant','collectif',0,'conseil');
call create_game_participation('ari-2024','rouge-2-2024','catapulte-2-2024','participant','collectif',0,'conseil');
call create_game_participation('cassandre-2024','rouge-2-2024','catapulte-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'conseil');
call create_game_participation('marie-2024','rouge-2-2024','catapulte-2-2024','participant','collectif',0,'conseil');
call create_game_participation('maude-2024','rouge-2-2024','catapulte-2-2024','participant','collectif',0,'conseil');

call create_participant_departure('la-tribu-maudite','ari-2024','rouge-2-2024',6,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','ari-2024',21,1,6);

/*
--
Epreuve de confort

jour 3 les flambeaux recomponse kit de pêche,
exemptée cassandre

victoire rouge

--
duel: emmanuelle - iniesse

equilibre bascule piece
 iniesse gagne

iniesse tribu jaune + 1 collier d'immunité' jusqu'à la réunification'

jour 4:
immunité:
catapulte 9 cibles
iniesse exempté jaune
cassandre, sarah exemptées rouge

victoire jaune

--
vote

depart ari, alex vote contre ari, et pour marie
*/
