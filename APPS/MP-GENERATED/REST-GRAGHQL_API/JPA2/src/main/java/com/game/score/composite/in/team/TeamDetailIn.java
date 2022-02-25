/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9.11
	* - name      : SDDInputCompositeBean
	* - file name : JavaCompositeBean.vm
*/
package com.game.score.composite.in.team;

import lombok.Data;
import java.util.List;

import com.game.score.sdd.in.property.GetPropertiesIn;
import com.game.score.sdd.in.timeline.TeamParticipantTimelineIn;
import com.game.score.sdd.in.game.GamePerformanceIn;
import com.game.score.sdd.in.timeline.TeamGameTimelineIn;
import com.game.score.sdd.in.stat.GameStatsIn;
import com.game.score.sdd.in.info.TeamInfoIn;
import com.game.score.sdd.in.info.ProgramInfoIn;


/**
 *
 * <p>Title: TeamDetailIn</p>
 *
 * <p>Description: Java Bean Input composite</p>
 *
 */
@Data
public class TeamDetailIn {

	public TeamDetailIn (
		 String entityType
		, String entityWebPath
		, String property
		, String programWebPath
		, String teamWebPath
		, String playerWebPath
		, String gameWebPath
		, String gameTypeWebPath
		, String gameStakeTypeWebPath
		, String gameParticipationTypeWebPath
		, String gameActivityTypeWebPath
		, Integer untilDay
	) {
		this.getPropertiesIn = new GetPropertiesIn();
		this.getPropertiesIn.setEntityType(entityType);
		this.getPropertiesIn.setEntityWebPath(entityWebPath);
		this.getPropertiesIn.setProperty(property);
		this.teamParticipantTimelineIn = new TeamParticipantTimelineIn();
		this.teamParticipantTimelineIn.setProgramWebPath(programWebPath);
		this.teamParticipantTimelineIn.setTeamWebPath(teamWebPath);
		this.teamParticipantTimelineIn.setPlayerWebPath(playerWebPath);
		this.gamePerformanceIn = new GamePerformanceIn();
		this.gamePerformanceIn.setPlayerWebPath(playerWebPath);
		this.gamePerformanceIn.setProgramWebPath(programWebPath);
		this.teamGameTimelineIn = new TeamGameTimelineIn();
		this.teamGameTimelineIn.setProgramWebPath(programWebPath);
		this.teamGameTimelineIn.setTeamWebPath(teamWebPath);
		this.teamGameTimelineIn.setGameWebPath(gameWebPath);
		this.teamGameTimelineIn.setGameTypeWebPath(gameTypeWebPath);
		this.teamGameTimelineIn.setPlayerWebPath(playerWebPath);
		this.gameStatsIn = new GameStatsIn();
		this.gameStatsIn.setProgramWebPath(programWebPath);
		this.gameStatsIn.setPlayerWebPath(playerWebPath);
		this.gameStatsIn.setGameWebPath(gameWebPath);
		this.gameStatsIn.setTeamWebPath(teamWebPath);
		this.gameStatsIn.setGameTypeWebPath(gameTypeWebPath);
		this.gameStatsIn.setGameStakeTypeWebPath(gameStakeTypeWebPath);
		this.gameStatsIn.setGameParticipationTypeWebPath(gameParticipationTypeWebPath);
		this.gameStatsIn.setGameActivityTypeWebPath(gameActivityTypeWebPath);
		this.gameStatsIn.setUntilDay(untilDay);
		this.teamInfoIn = new TeamInfoIn();
		this.teamInfoIn.setProgramWebPath(programWebPath);
		this.teamInfoIn.setTeamWebPath(teamWebPath);
		this.programInfoIn = new ProgramInfoIn();
		this.programInfoIn.setProgramWebPath(programWebPath);
	}
    private String entityType;
    private String entityWebPath;
    private String property;
    private String programWebPath;
    private String teamWebPath;
    private String playerWebPath;
    private String gameWebPath;
    private String gameTypeWebPath;
    private String gameStakeTypeWebPath;
    private String gameParticipationTypeWebPath;
    private String gameActivityTypeWebPath;
    private Integer untilDay;
    private GetPropertiesIn getPropertiesIn;
    private TeamParticipantTimelineIn teamParticipantTimelineIn;
    private GamePerformanceIn gamePerformanceIn;
    private TeamGameTimelineIn teamGameTimelineIn;
    private GameStatsIn gameStatsIn;
    private TeamInfoIn teamInfoIn;
    private ProgramInfoIn programInfoIn;


}
