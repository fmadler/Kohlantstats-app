
-- ??ème jour

-- perche liberation anneaux
call create_game('le-totem-maudit','Perches','perches-2022','perches','collectif','confort',21,16,'brochette-pommes-sautees','rapidite,relais,dexterite');

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



-- reunification

-- choix ambassadeur
-- louana rouge ambassadeur


call create_game('le-totem-maudit','Catapulte','catapulte-2022','catapulte','collectif','immunite',20,15,'conseil','rapidite,precision');

call create_game_participation('louana-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('maxime-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('fouzi-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('francois-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('geraldine-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('pauline-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('jean-charles-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');
call create_game_participation('ambre-2022','rouge-2022','catapulte-2022','participant','collectif',1,'totem');

call create_game_participation('anne-sophie-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('yannick-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('bastien-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('alexandra-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('colin-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('nicolas-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('olga-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');
call create_game_participation('setha-2022','jaune-2022','catapulte-2022','participant','collectif',2,'conseil');

call team_game_ranking ('jaune-2022','catapulte-2022',2);
call team_game_ranking ('rouge-2022','catapulte-2022',1);

call first_vote_against ('le-totem-maudit','bastien-2022','alexandra-2022','jaune-2022', 20, 'effectif');
call first_vote_against ('le-totem-maudit','yannick-2022','alexandra-2022','jaune-2022', 20, 'effectif');
call second_vote_against ('le-totem-maudit','yannick-2022','yannick-2022','jaune-2022', 20, 'effectif');
call vote ('le-totem-maudit','yannick-2022','yannick-2022','rouge-2022', 3, 20, 1, 'effectif', 'vote-contre');
call first_vote_against ('le-totem-maudit','alexandra-2022','setha-2022','jaune-2022', 20, 'effectif');
call first_vote_against ('le-totem-maudit','colin-2022','setha-2022','jaune-2022', 20, 'effectif');
call first_vote_against ('le-totem-maudit','olga-2022','setha-2022','jaune-2022', 20, 'effectif');
call first_vote_against ('le-totem-maudit','setha-2022','alexandra-2022','jaune-2022', 20, 'effectif');
call first_vote_against ('le-totem-maudit','anne-sophie-2022','alexandra-2022','jaune-2022', 20, 'effectif');
call first_vote_against ('le-totem-maudit','nicolas-2022','setha-2022','jaune-2022', 20, 'effectif');

call second_round_first_vote_for ('le-totem-maudit','bastien-2022','alexandra-2022','jaune-2022', 20, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','yannick-2022','alexandra-2022','jaune-2022', 20, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','alexandra-2022','setha-2022','jaune-2022', 20, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','colin-2022','setha-2022','jaune-2022', 20, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','olga-2022','setha-2022','jaune-2022', 20, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','setha-2022','alexandra-2022','jaune-2022', 20, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','anne-sophie-2022','alexandra-2022','jaune-2022', 20, 'effectif');
call second_round_first_vote_for ('le-totem-maudit','nicolas-2022','setha-2022','jaune-2022', 20, 'effectif');

call create_participant_departure('le-totem-maudit','alexandra-2022','jaune-2022',11,'exclusion-par-duel-apres-vote', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','alexandra-2022',15,1,20);

call program_current_time ('le-totem-maudit',20);
