
-- ??ème jour

-- perche liberation anneaux
call create_game('le-totem-maudit','Perches','perches-2022','perches','collectif','confort',21,17,'brochette-pommes-sautees','rapidite,relais,dexterite');

call create_game_participation('louana-2022','rouge-2022','perches-2022','participant','collectif',1,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('maxime-2022','rouge-2022','perches-2022','participant','collectif',1,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('fouzi-2022','rouge-2022','perches-2022','exclusion-apres-tirage-au-sort','collectif',1,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('francois-2022','rouge-2022','perches-2022','participant','collectif',1,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('geraldine-2022','rouge-2022','perches-2022','participant','collectif',1,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('pauline-2022','rouge-2022','perches-2022','participant','collectif',1,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('jean-charles-2022','rouge-2022','perches-2022','participant','collectif',1,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('ambre-2022','rouge-2022','perches-2022','participant','collectif',1,'pas-d-entrainement-pour-la-prochaine-epreuve');

call create_game_participation('anne-sophie-2022','jaune-2022','perches-2022','participant','collectif',2,'soiree-bateau');
call create_game_participation('yannick-2022','jaune-2022','perches-2022','participant','collectif',2,'soiree-bateau');
call create_game_participation('bastien-2022','jaune-2022','perches-2022','participant','collectif',2,'soiree-bateau');
call create_game_participation('colin-2022','jaune-2022','perches-2022','participant','collectif',2,'soiree-bateau');
call create_game_participation('nicolas-2022','jaune-2022','perches-2022','participant','collectif',2,'soiree-bateau');
call create_game_participation('olga-2022','jaune-2022','perches-2022','participant','collectif',2,'soiree-bateau');
call create_game_participation('setha-2022','jaune-2022','perches-2022','participant','collectif',2,'soiree-bateau');

call team_game_ranking ('jaune-2022','perches-2022',2);
call team_game_ranking ('rouge-2022','perches-2022',1);


call create_participant_realisation ('le-totem-maudit','louana-2022','rouge-2022',21,'ambassadeur-par-choix-adverse',@realisation_id);
call create_participant_realisation ('le-totem-maudit','colin-2022','jaune-2022',21,'ambassadeur-par-choix-adverse',@realisation_id);
call create_participant_departure ('le-totem-maudit','setha-2022','jaune-2021-2',21,'choix-des-ambassadeurs', @participant_team_id);

-- reunification

call create_participant_departure ('le-totem-maudit','louana-2022','rouge-2022',21,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','maxime-2022','rouge-2022',21,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','fouzi-2022','rouge-2022',21,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','francois-2022','rouge-2022',21,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','geraldine-2022','rouge-2022',21,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','pauline-2022','rouge-2022',21,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','jean-charles-2022','rouge-2022',21,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','ambre-2022','rouge-2022',21,'recomposition-des-equipes', @participant_team_id);

call create_participant_departure ('le-totem-maudit','anne-sophie-2022','jaune-2022',21,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','yannick-2022','jaune-2022',21,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','bastien-2022','jaune-2022',21,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','colin-2022','jaune-2022',21,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','nicolas-2022','jaune-2022',21,'recomposition-des-equipes', @participant_team_id);
call create_participant_departure ('le-totem-maudit','olga-2022','jaune-2022',21,'recomposition-des-equipes', @participant_team_id);

call create_team('le-totem-maudit','Blanc','blanc-2022','Blanc',21,40);

call create_participant_entrance ('le-totem-maudit','louana-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','maxime-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','fouzi-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','francois-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','geraldine-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','pauline-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','jean-charles-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','ambre-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','anne-sophie-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','yannick-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','bastien-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','colin-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','nicolas-2022','blanc-2022',21,'reunification', @participant_team_id);
call create_participant_entrance ('le-totem-maudit','olga-2022','blanc-2022',21,'reunification', @participant_team_id);


-- choix ambassadeur
-- louana rouge ambassadeur
-- colin jaune ambassadeur

-- 2 boules noires pour colin

call create_game('le-totem-maudit','Koala','koala-2022','koala','collectif','confort',23,18,'brochette-pommes-sautees','rapidite,relais,dexterite');
-- le dernier gagne

call create_game_participation('louana-2022','blanc-2022','perches-2022','participant','collectif',1,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('maxime-2022','blanc-2022','perches-2022','participant','collectif',9,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('fouzi-2022','blanc-2022','perches-2022','participant','collectif',13,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('francois-2022','blanc-2022','perches-2022','participant','collectif',14,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('geraldine-2022','blanc-2022','perches-2022','participant','collectif',7,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('pauline-2022','blanc-2022','perches-2022','participant','collectif',10,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('jean-charles-2022','blanc-2022','perches-2022','participant','collectif',12,'pas-d-entrainement-pour-la-prochaine-epreuve');
call create_game_participation('ambre-2022','blanc-2022','perches-2022','participant','collectif',5,'pas-d-entrainement-pour-la-prochaine-epreuve');

call create_game_participation('anne-sophie-2022','blanc-2022','perches-2022','participant','collectif',6,'soiree-bateau');
call create_game_participation('yannick-2022','blanc-2022','perches-2022','participant','collectif',11,'soiree-bateau');
call create_game_participation('bastien-2022','blanc-2022','perches-2022','participant','collectif',2,'soiree-bateau');
call create_game_participation('colin-2022','blanc-2022','perches-2022','participant','collectif',3,'soiree-bateau');
call create_game_participation('nicolas-2022','blanc-2022','perches-2022','participant','collectif',8,'soiree-bateau');
call create_game_participation('olga-2022','blanc-2022','perches-2022','participant','collectif',4,'soiree-bateau');


call first_vote_against ('le-totem-maudit','louana-2022','yannick-2022','jaune-2022', 23, 'effectif');
call first_vote_against ('le-totem-maudit','maxime-2022','colin-2022','jaune-2022', 23, 'effectif');
call first_vote_against ('le-totem-maudit','fouzi-2022','colin-2022','jaune-2022', 23, 'effectif');
call first_vote_against ('le-totem-maudit','francois-2022','colin-2022','jaune-2022', 23, 'effectif');
call first_vote_against ('le-totem-maudit','geraldine-2022','colin-2022','jaune-2022', 23, 'effectif');
call first_vote_against ('le-totem-maudit','pauline-2022','colin-2022','jaune-2022', 23, 'effectif');
call second_vote_against ('le-totem-maudit','pauline-2022','pauline-2022','jaune-2022', 23, 'effectif');
call first_vote_against ('le-totem-maudit','jean-charles-2022','colin-2022','jaune-2022', 23, 'effectif');
call first_vote_against ('le-totem-maudit','ambre-2022','colin-2022','jaune-2022', 23, 'effectif');

call first_vote_against ('le-totem-maudit','bastien-2022','alexandra-2022','jaune-2022', 23, 'effectif');
call first_vote_against ('le-totem-maudit','yannick-2022','maxime-2022','jaune-2022', 23, 'effectif');
call second_vote_against ('le-totem-maudit','yannick-2022','yannick-2022','jaune-2022', 23, 'effectif');
call vote ('le-totem-maudit','yannick-2022','yannick-2022','rouge-2022', 3, 23, 1, 'effectif', 'vote-contre');
call first_vote_against ('le-totem-maudit','alexandra-2022','setha-2022','jaune-2022', 23, 'effectif');
call first_vote_against ('le-totem-maudit','colin-2022','maxime-2022','jaune-2022', 23, 'effectif');
call first_vote_against ('le-totem-maudit','olga-2022','maxime-2022','jaune-2022', 23, 'effectif');
call first_vote_against ('le-totem-maudit','anne-sophie-2022','maxime-2022','jaune-2022', 23, 'effectif');
call first_vote_against ('le-totem-maudit','nicolas-2022','colin-2022','jaune-2022', 23, 'effectif');

-- colin depart