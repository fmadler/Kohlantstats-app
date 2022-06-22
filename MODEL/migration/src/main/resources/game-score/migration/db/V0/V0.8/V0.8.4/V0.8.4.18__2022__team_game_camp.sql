call create_game('le-totem-maudit','Orientation','orientation-2022','orientation','individuel','confort',29,38,'poteaux','rapidite,tenacite,perseverance');

call create_game_participation('francois-2022','blanc-2022','orientation-2022','participant','individuel',3,'finale');
call create_game_participation('ambre-2022','blanc-2022','orientation-2022','participant','individuel',5,'');
call create_game_participation('bastien-2022','blanc-2022','orientation-2022','participant','individuel',4,'');
call create_game_participation('geraldine-2022','blanc-2022','orientation-2022','participant','individuel',2,'finale');
call create_game_participation('jean-charles-2022','blanc-2022','orientation-2022','participant','individuel',1,'finale');

call create_participant_departure('le-totem-maudit','ambre-2022','blanc-2022',38,'defaite-orientation', @participant_team_id);
call fill_participant_longevity ('le-totem-maudit','ambre-2022',6,1,38);

call program_current_time ('le-totem-maudit',38);

2 jean-charles
4 francois
3 bastien
1 geraldine

fouzi -> francois
ambre-> francois
olga -> geraldine
nicolas -> francois
maxime -> geraldine
jean-charles -> bastien
louana -> geraldine
anne-sophie -> bastien
yannick -> bastien
pauline -> francois
colin -> bastien

2 vainqueurs bastien / francois
