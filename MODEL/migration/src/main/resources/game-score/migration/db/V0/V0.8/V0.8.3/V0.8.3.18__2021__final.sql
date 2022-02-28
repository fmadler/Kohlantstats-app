
call create_game('la-legende-2021','Les poteaux','poteaux-2021-2','poteaux','individuel','finale',36,36,'blanc-2021-2','equilibre,statique,patience');

call create_program_game_participation('la-legende-2021','ugo-2012','blanc-2021-2','poteaux-2021-2','participant','individuel',2,'');
call create_program_game_participation('la-legende-2021','claude-2010','blanc-2021-2','poteaux-2021-2','participant','individuel',3,'');
call create_program_game_participation('la-legende-2021','laurent-2011','blanc-2021-2','poteaux-2021-2','participant','individuel',1,'');

-- TODO adapt model for multiple entrance and departure
-- call create_participant_departure ('la-legende-2021','ugo-2012','blanc-2021-2',36,'epreuve-poteaux', @participant_team_id);

call fill_participant_longevity ('la-legende-2021','ugo-2012',3,1,36);

/**/
call first_vote_for ('la-legende-2021','christelle-2008','claude-2010','blanc-2021-2', 36, 'effectif');
call first_vote_for ('la-legende-2021','ugo-2012','claude-2010','blanc-2021-2', 36, 'effectif');
call first_vote_for ('la-legende-2021','loic-2020','claude-2010','blanc-2021-2', 36, 'effectif');
call first_vote_for ('la-legende-2021','teheiura-2011','claude-2010','blanc-2021-2', 36, 'effectif');
call first_vote_for ('la-legende-2021','coumba-2010','claude-2010','blanc-2021-2', 36, 'effectif');
call first_vote_for ('la-legende-2021','jade-2007','claude-2010','blanc-2021-2', 36, 'effectif');
call first_vote_for ('la-legende-2021','phil-2012','claude-2010','blanc-2021-2', 36, 'effectif');
call first_vote_for ('la-legende-2021','alexandra-2020','claude-2010','blanc-2021-2', 36, 'effectif');
call first_vote_for ('la-legende-2021','alix-2020','claude-2010','blanc-2021-2', 36, 'effectif');
call first_vote_for ('la-legende-2021','namadia-2012','claude-2010','blanc-2021-2', 36, 'effectif');
call first_vote_for ('la-legende-2021','sam-2018','claude-2010','blanc-2021-2', 36, 'effectif');
call first_vote_for ('la-legende-2021','clementine-2017','claude-2010','blanc-2021-2', 36, 'effectif');


call create_participant_departure('la-legende-2021','claude-2010','blanc-2021-2',36,'deliberation-jury-final', @participant_team_id);
call create_participant_departure('la-legende-2021','laurent-2011','blanc-2021-2',36,'deliberation-jury-final', @participant_team_id);

-- première saison sans vainqueur...
call fill_participant_longevity ('la-legende-2021','claude-2010',2,1,36);
call fill_participant_longevity ('la-legende-2021','laurent-2011',2,1,36);
