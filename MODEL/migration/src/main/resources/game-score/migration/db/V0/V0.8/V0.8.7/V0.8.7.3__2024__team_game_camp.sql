-- jour 7

-- jour 8

call create_game('la-tribu-maudite','Régate','regate-2-2024','regate','collectif','confort',8,9,'nourriture','construction,rapidite');

call create_game_participation('ugo-2012','rouge-2-2024','regate-2-2024','participant','collectif',1,'');
call create_game_participation('gustin-2024','rouge-2-2024','regate-2-2024','participant','collectif',1,'');
call create_game_participation('alexandre-2024','rouge-2-2024','regate-2-2024','participant','collectif',1,'');
call create_game_participation('maxim-2024','rouge-2-2024','regate-2-2024','participant','collectif',1,'');
call create_game_participation('cecile-2-2024','rouge-2-2024','regate-2-2024','participant','collectif',1,'');
call create_game_participation('sarah-2-2024','rouge-2-2024','regate-2-2024','participant','collectif',1,'');
call create_game_participation('cassandre-2024','rouge-2-2024','regate-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'');
call create_game_participation('marie-2024','rouge-2-2024','regate-2-2024','participant','collectif',1,'');
call create_game_participation('emmanuelle-2024','rouge-2-2024','regate-2-2024','participant','collectif',1,'');
call create_game_participation('maude-2024','rouge-2-2024','regate-2-2024','exclusion-apres-tirage-au-sort','collectif',1,'');
  
call create_game_participation('frederic-2023','jaune-2-2024','regate-2-2024','participant','collectif',0,'');
call create_game_participation('jacques-2024','jaune-2-2024','regate-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'');
call create_game_participation('fabrice-2024','jaune-2-2024','regate-2-2024','participant','collectif',0,'');
call create_game_participation('thibault-2024','jaune-2-2024','regate-2-2024','participant','collectif',0,'');
call create_game_participation('michel-2024','jaune-2-2024','regate-2-2024','exclusion-apres-tirage-au-sort','collectif',0,'');
call create_game_participation('charlotte-2024','jaune-2-2024','regate-2-2024','participant','collectif',0,'');
call create_game_participation('lola-2024','jaune-2-2024','regate-2-2024','participant','collectif',0,'');
call create_game_participation('sophia-2024','jaune-2-2024','regate-2-2024','participant','collectif',0,'');
call create_game_participation('ilyesse-2024','jaune-2-2024','regate-2-2024','participant','collectif',0,'');

-- 8§me jour anito blanc rivviere
call create_game('la-tribu-maudite','Anito-2','anito-2-2024','anito','collectif','duel',8,8,'duel-de-reintegration','recherche');
call create_game_participation('nathanael-2024','rouge-2-2024','anito-2-2024','participant','individuel',0,'');
call create_game_participation('melissa-2024','rouge-2-2024','anito-2-2024','participant','individuel',1,'');
call create_game_participation('vanessa-2024','rouge-2-2024','anito-2-2024','participant','individuel',0,'');
call create_game_participation('emmanuelle-2024','rouge-2-2024','anito-2-2024','participant','individuel',0,'');


-- duel melissa contre ilyesse

--
/*
call create_game('la-tribu-maudite','°allet','pallet-2-2024','pallet','collectif','duel',8,9,'duel-de-reintegration','rapidite,precision');
call create_game_participation('ilyesse-2024','rouge-2-2024','pallet-2-2024','participant','individuel',1,''); -- reintegration
call create_game_participation('melissa-2024','rouge-2-2024','pallet-2-2024','participant','individuel',0,''); -- retour tribu maudite
*/
--  9ème jour
call create_game('la-tribu-maudite','Puzzle de 27 pièces','puzzle-27-pieces-2024','Puzzle','collectif','immunite',9,10,'conseil,totem','logique,rapidite');

call create_game_participation('ugo-2012','rouge-2-2024','puzzle-27-pieces-2024','participant','collectif',1,'');
call create_game_participation('gustin-2024','rouge-2-2024','puzzle-27-pieces-2024','participant','collectif',1,'');
call create_game_participation('alexandre-2024','rouge-2-2024','puzzle-27-pieces-2024','participant','collectif',1,'');
call create_game_participation('maxim-2024','rouge-2-2024','puzzle-27-pieces-2024','participant','collectif',1,'');
call create_game_participation('cecile-2-2024','rouge-2-2024','puzzle-27-pieces-2024','participant','collectif',1,'');
call create_game_participation('sarah-2-2024','rouge-2-2024','puzzle-27-pieces-2024','participant','collectif',1,'');
call create_game_participation('cassandre-2024','rouge-2-2024','puzzle-27-pieces-2024','exclusion-apres-tirage-au-sort','collectif',1,'');
call create_game_participation('marie-2024','rouge-2-2024','puzzle-27-pieces-2024','participant','collectif',1,'');
call create_game_participation('emmanuelle-2024','rouge-2-2024','puzzle-27-pieces-2024','participant','collectif',1,'');
call create_game_participation('maude-2024','rouge-2-2024','puzzle-27-pieces-2024','exclusion-apres-tirage-au-sort','collectif',1,'');

call create_game_participation('frederic-2023','jaune-2-2024','puzzle-27-pieces-2024','participant','collectif',0,'');
call create_game_participation('jacques-2024','jaune-2-2024','puzzle-27-pieces-2024','participant','collectif',0,'');
call create_game_participation('fabrice-2024','jaune-2-2024','puzzle-27-pieces-2024','exclusion-apres-tirage-au-sort','collectif',0,'');
call create_game_participation('thibault-2024','jaune-2-2024','puzzle-27-pieces-2024','participant','collectif',0,'');
call create_game_participation('michel-2024','jaune-2-2024','puzzle-27-pieces-2024','exclusion-apres-tirage-au-sort','collectif',0,'');
call create_game_participation('charlotte-2024','jaune-2-2024','puzzle-27-pieces-2024','participant','collectif',0,'');
call create_game_participation('lola-2024','jaune-2-2024','puzzle-27-pieces-2024','participant','collectif',0,'');
call create_game_participation('sophia-2024','jaune-2-2024','puzzle-27-pieces-2024','participant','collectif',0,'');
call create_game_participation('ilyesse-2024','jaune-2-2024','puzzle-27-pieces-2024','participant','collectif',0,'');

/*
-- victoire jaune
maud -> marie
gustin -> alex
alexandre -> hugo
sarah -> marie
marie -> alexandre
cecile-2 -> alex
cassandre -> alex
maxime -> alex
hugo -> marie

-- 
maud -> marie
gustin -> marie
alexandre -> marie
sarah -> marie
marie -> alexandre
cecile-2 -> alex
cassandre -> alex
maxime -> marie
hugo -> alex

 */
call create_participant_departure('la-tribu-maudite','marie-2024','rouge-2-2024',8,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','ari-2024',20,1,8);
