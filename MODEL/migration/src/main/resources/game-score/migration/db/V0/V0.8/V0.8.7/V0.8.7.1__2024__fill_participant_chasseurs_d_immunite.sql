call create_programme('La tribu maudite', 'la-tribu-maudite', '2024', 22, 40, 'philippines', 'philippines', 1);

-- epreuve placement de boule blanche 1
-- todo verifier age / profession
call add_participant('la-tribu-maudite', 'Ugo', 'xxx', 'ugo-2012', 'H', 40, null, 0, '', 'Responsable RH');
call add_participant('la-tribu-maudite', 'Gustin', '', 'gustin-2024', 'M', 26, null, 0, 'Pyrénées-Orientales', 'Assistant d''éducation');
call add_participant('la-tribu-maudite', 'Alexandre', '', 'alexandre-2024', 'M', 33, null, 0, 'Paris', 'Ostéopathe');
call add_participant('la-tribu-maudite', 'Maxim', '', 'maxim-2024', 'M', 28, null, 0, '', 'Commerciale');
call add_participant('la-tribu-maudite', 'Ari', '', 'ari-2024', 'M', 51, null, 0, '', 'Vendeuse en téléphonie');
call add_participant('la-tribu-maudite', 'Cecile', '', 'cecile-2-2024', 'F', 23, null, 0, '', 'Cheffe d''entreprise');
call add_participant('la-tribu-maudite', 'Sarah', '', 'sarah-2-2024', 'F', 34, null, 0, 'Haute Seine', 'Chargé de recouvrement');
call add_participant('la-tribu-maudite', 'Cassandre', '', 'cassandre-2024', 'F', 41, null, 0, '', 'Directrice d''implementation de restaurants');
call add_participant('la-tribu-maudite', 'Marie', '', 'marie-2024', 'F', 35, null, 0, '', 'Gérante de société dans l''immobilier');
call add_participant('la-tribu-maudite', 'Emmanuelle', '', 'emmanuelle-2024', 'F', 43, null, 0, '', 'Ingénieur en éléctricité');
call add_participant('la-tribu-maudite', 'Maude', '', 'maude-2024', 'F', 43, null, 0, '', 'Ingénieur en éléctricité');
call add_participant('la-tribu-maudite', 'Nathanael', '', 'nathanael-2024', 'M', 43, null, 0, '', 'Ingénieur en éléctricité');
call add_participant('la-tribu-maudite', 'Ilyesse', '', 'ilyesse-2024', 'M', 43, null, 0, '', 'Ingénieur en éléctricité');

call add_participant('la-tribu-maudite', 'Fréderic', 'xxx', 'frederic-2023', 'M', 35, null, 0, '', 'Approvisionneur de distributeurs automatiques');
call add_participant('la-tribu-maudite', 'Jacques', '', 'jacques-2024', 'H', 42, null, 0, 'Seine-Saint-Denis', 'Gérant d''une salle de sport');
call add_participant('la-tribu-maudite', 'Thibault', '', 'thibault-2024', 'H', 29, null, 0, 'Haute Garonne', 'Gérante en Fromageries');
call add_participant('la-tribu-maudite', 'Fabrice', '', 'fabrice-2024', 'H', 34, null, 0, '', 'Agent Commercial immobilier');
call add_participant('la-tribu-maudite', 'Michel', '', 'michel-2024', 'H', 55, null, 0, '', 'Consultante en transition numérique');
call add_participant('la-tribu-maudite', 'Charlotte', '', 'charlotte-2024', 'F', 34, null, 0, 'Corse', 'Expert Comptable');
call add_participant('la-tribu-maudite', 'Lola', '', 'lola-2024', 'F', 30, null, 0, 'Pyrénées-Atlantiques', 'Charpentier');
call add_participant('la-tribu-maudite', 'Sophia', '', 'sophia-2024', 'F', 21, null, 0, 'Lot', 'Ex-militaire');
call add_participant('la-tribu-maudite', 'Cécile', '', 'cecile-3-2024', 'F', 37, null, 0, '', 'Gestion de taxis');
call add_participant('la-tribu-maudite', 'Vanessa', '', 'vanessa-2024', 'F', 37, null, 0, '', 'Gestion de taxis');
call add_participant('la-tribu-maudite', 'Melissa', '', 'melissa-2024', 'F', 37, null, 0, '', 'Gestion de taxis');

call create_team('la-tribu-maudite','Jaune','jaune-2-2024','Sabitang',1,22);
call create_team('la-tribu-maudite','Rouge','rouge-2-2024','Pitogo',1,22);
call create_team('la-tribu-maudite','Tribu maudite','tribu-maudite-2024','Tribu maudite',1,22);


call create_participant_entrance ('la-tribu-maudite','ugo-2012','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','gustin-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','alexandre-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','maxim-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','ari-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','cecile-2-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','sarah-2-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','cassandre-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','marie-2024','rouge-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','emmanuelle-2024','rouge-2-2024',1,'arrivee', @participant_team_id);

call create_participant_entrance ('la-tribu-maudite','frederic-2023','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','jacques-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','thibault-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','fabrice-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','michel-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','charlotte-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','lola-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','sophia-2024','jaune-2-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','cecile-3-2024','jaune-2-2024',1,'arrivee', @participant_team_id);


call create_participant_entrance ('la-tribu-maudite','melissa-2024','tribu-maudite-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','vanessa-2024','tribu-maudite-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','ilyesse-2024','tribu-maudite-2024',1,'arrivee', @participant_team_id);
call create_participant_entrance ('la-tribu-maudite','nathanael-2024','tribu-maudite-2024',1,'arrivee', @participant_team_id);

/*
thibault agriculteur corse

cassandre ecrivaine 23
lola kine 25

frederic 35 restaurateur
ugo guide nature 42 ans

michel responsalbe rh 36
melissa responsable en supermarché 35 var

ilyesse
jaccques danse 38
sarah 32 responsable merchandising
ccharlotte aide à la jeunesse 28 belgique
nathanael cariste 27
cécile 41 prof pilate
emamnuelle

41 hours

maud
alexandre osteopathe 33 paris
cécile2 hotesse de l'air' 34 haute savoie
marie 29 vendeuse
maxim livreur velo 28 paris
soohia coach sportif 36
vanessa danseuse et chorégrphe 39
fabrice directeur centre equestre 40

ilyesse etudiant 23
--
*/
insert into gs_game_stake_type (name, web_path) VALUES ('Exclusion de la sélection initiale', 'exclusion-selection-initiale');
call create_game('la-tribu-maudite','Placement de boule','boule-placement-2-2024','boule placement','collectif','confort',1,1,'selection-initiale,exclusion-selection-initiale','dexterite,rapidite');

call create_team('la-tribu-maudite','Arrivée','arrivee-2024','Arrivée',1,1);
insert into gs_reward (name, web_path, gs_reward_type_id, is_positive) values ('Sélection initial','selection-initiale',9,1);
insert into gs_reward (name, web_path, gs_reward_type_id, is_positive) values ('Exclusion sélection initial','exclusion-selection-initiale',9,0);

call create_game_participation('cecile-2-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',1,'selection-initiale');
call create_game_participation('charlotte-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',2,'selection-initiale');
call create_game_participation('maude-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',3,'selection-initiale');
call create_game_participation('lola-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',4,'selection-initiale');
call create_game_participation('emmanuelle-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',5,'selection-initiale');
call create_game_participation('sophia-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',6,'selection-initiale');
call create_game_participation('cassandre-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',7,'selection-initiale');
call create_game_participation('sarah-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',8,'selection-initiale');
call create_game_participation('melissa-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',0,'exclusion-selection-initiale');
call create_game_participation('vanessa-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',0,'exclusion-selection-initiale');

/*
epreuve boule placement

1 cecile
2 charlotte
3 maude
lola
emmanuelle
sophia
cassandre
sarah


-> exclue melissa, vanessa
*/

call create_game_participation('fabrice-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',1,'selection-initiale');
call create_game_participation('alexandre-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',2,'selection-initiale');
call create_game_participation('maxim-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',3,'selection-initiale');
call create_game_participation('gustin-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',4,'selection-initiale');
call create_game_participation('ari-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',5,'selection-initiale');
call create_game_participation('jacques-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',6,'selection-initiale');
call create_game_participation('michel-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',7,'selection-initiale');
call create_game_participation('thibault-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',8,'selection-initiale');
call create_game_participation('nathanael-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',0,'selection-initiale');
call create_game_participation('ilyesse-2024','arrivee-2024','boule-placement-2-2024','participant','individuel',0,'exclusion-selection-initiale');

/*
--
fabrice
alexandre
maxim
guistin

ari cchef d'entreprise 51'
jacques
michel


--- equipen

-- ugo rouge pitogo
gustin
alexandre
maxim
ari
cecile
sarah
cassandre
marie
emmanuelle
maud



--- fred jaune sabitang
jacques
thibault
fabrice
michel
charlotte
lola
sophia
cécile

--

 */

call create_game('la-tribu-maudite','Basket coco','basket-coco-2-2024','basket-coco','collectif','immunite',2,2,'totem','force,rapidite');

call create_game_participation('jacques-2024','jaune-2-2024','basket-coco-2-2024','participant','collectif',0,'conseil');
call create_game_participation('frederic-2023','jaune-2-2024','basket-coco-2-2024','participant','collectif',0,'conseil');
call create_game_participation('fabrice-2024','jaune-2-2024','basket-coco-2-2024','participant','collectif',0,'conseil');
call create_game_participation('thibault-2024','jaune-2-2024','basket-coco-2-2024','participant','collectif',0,'conseil');
call create_game_participation('michel-2024','jaune-2-2024','basket-coco-2-2024','participant','collectif',0,'conseil');
call create_game_participation('charlotte-2024','jaune-2-2024','basket-coco-2-2024','participant','collectif',0,'conseil');
call create_game_participation('lola-2024','jaune-2-2024','basket-coco-2-2024','participant','collectif',0,'conseil');
call create_game_participation('sophia-2024','jaune-2-2024','basket-coco-2-2024','participant','collectif',0,'conseil');
call create_game_participation('cecile-3-2024','jaune-2-2024','basket-coco-2-2024','participant','collectif',0,'conseil');
call create_game_participation('emmanuelle-2024','jaune-2-2024','basket-coco-2-2024','participant','collectif',1,'totem');

call create_game_participation('gustin-2024','rouge-2-2024','basket-coco-2-2024','participant','individuel',1,'totem');
call create_game_participation('ugo-2012','rouge-2-2024','basket-coco-2-2024','participant','individuel',1,'totem');
call create_game_participation('alexandre-2024','rouge-2-2024','basket-coco-2-2024','participant','individuel',1,'totem');
call create_game_participation('maxim-2024','rouge-2-2024','basket-coco-2-2024','participant','individuel',1,'totem');
call create_game_participation('cecile-2-2024','rouge-2-2024','basket-coco-2-2024','participant','individuel',1,'totem');
call create_game_participation('sarah-2-2024','rouge-2-2024','basket-coco-2-2024','participant','individuel',1,'totem');
call create_game_participation('ari-2024','rouge-2-2024','basket-coco-2-2024','participant','individuel',1,'totem');
call create_game_participation('cassandre-2024','rouge-2-2024','basket-coco-2-2024','participant','individuel',1,'totem');
call create_game_participation('marie-2024','rouge-2-2024','basket-coco-2-2024','participant','individuel',1,'totem');
call create_game_participation('maude-2024','rouge-2-2024','basket-coco-2-2024','participant','individuel',1,'totem');


call create_participant_departure('la-tribu-maudite','cecile-3-2024','jaune-2-2024',2,'exclusion-par-vote', @participant_team_id);
call fill_participant_longevity ('la-tribu-maudite','cecile-3-2024',22,1,2);

 /*
epreuve d'immunité'

coco panier alourdir la partie adverse

victoire rouge

--

vote

départ cécile


call add_participant('La-tribu-maudite', 'Lea', 'xxx', 'lea-2024', 'F', 33, null, 0, 'xx', 'x');
call add_participant('La-tribu-maudite', 'Steve', 'xxx', 'steve-2024', 'M', 27, null, 0, 'x', 'x');
call add_participant('La-tribu-maudite', 'Ricky', '', 'anne-sophie-2024', 'M', 23, null, 0, 'xx', 'xx');
call add_participant('La-tribu-maudite', 'Jean', '', 'jean-2024', 'M', 35, null, 0, 'yy', 'yy');
call add_participant('La-tribu-maudite', 'Mégane', '', 'megane-2024', 'F', 28, null, 0, 'xx', 'Vendeuse');
call add_participant('La-tribu-maudite', 'Émilie', '', 'emilie-2024', 'F', 45, null, 0, 'xxx', '');
call add_participant('La-tribu-maudite', 'Alicia', '', 'alicia-2024', 'F', 23, null, 0, '', '');
call add_participant('La-tribu-maudite', 'Meissa', '', 'meissa-2024', 'M', 99, null, 0, 'xx', '');
call add_participant('La-tribu-maudite', 'David', '', 'david-2024', 'M', 36, null, 0, 'Alsace', 'Boucher');
call add_participant('La-tribu-maudite', 'Cécile', '', 'cecile-2024', 'F', 41, null, 0, 'x', 'xx');
call add_participant('La-tribu-maudite', 'Océane', '', 'oceane-2024', 'H', 37, null, 0, 'rr', 'rr');
call add_participant('La-tribu-maudite', 'Maxime', '', 'maxime-2024', 'H', 43, null, 0, 'xx', 'xx');
call add_participant('La-tribu-maudite', 'Amri', '', 'amri-2024', 'H', 42, null, 0, 'xx', 'xx');
call add_participant('La-tribu-maudite', 'Pauline', '', 'pauline-2024', 'F', 99, null, 0, 'x', 'xx');
call add_participant('La-tribu-maudite', 'Aurélien', '', 'aurelien-2024', 'H', 99, null, 0, 'xx', 'xx');
call add_participant('La-tribu-maudite', 'Natalie', '', 'natalie-2024', 'F', 45, null, 0, 'x', 'xx');
call add_participant('La-tribu-maudite', 'Sarah', '', 'sarah-2024', 'F', 99, null, 0, 'xx', 'xx');
call add_participant('La-tribu-maudite', 'Sebastien', '', 'sebastien-2024', 'H', 99, null, 0, 'xx', 'Charpentier');


--
tribu maudite recherche anito blanc

inesse trouve l'anito' contre nathanael, vanessa, melissa

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

*/
