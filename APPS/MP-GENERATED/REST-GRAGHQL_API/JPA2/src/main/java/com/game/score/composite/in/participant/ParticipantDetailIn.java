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
package com.game.score.composite.in.participant;

import lombok.Data;
import java.util.List;

import com.game.score.sdd.in.distinct.DistinctParticipantsIn;
import com.game.score.sdd.in.participant.ParticipantSummaryIn;
import com.game.score.sdd.in.stat.GameStatsIn;
import com.game.score.sdd.in.property.GetPropertiesIn;
import com.game.score.sdd.in.participant.ParticipantGameActivityIn;
import com.game.score.sdd.in.participant.ParticipantCampActivityIn;
import com.game.score.sdd.in.game.GamePerformanceIn;
import com.game.score.sdd.in.timeline.TeamParticipantTimelineIn;


/**
 *
 * <p>Title: ParticipantDetailIn</p>
 *
 * <p>Description: Java Bean Input composite</p>
 *
 */
@Data
public class ParticipantDetailIn {

	public ParticipantDetailIn (
		 String programWebPath
		, String playerWebPath
		, String gameWebPath
		, String teamWebPath
		, String gameTypeWebPath
		, String gameStakeTypeWebPath
		, String gameParticipationTypeWebPath
		, String gameActivityTypeWebPath
		, Integer untilDay
		, String entityType
		, String entityWebPath
		, String property
		, String gameTagWebPath
		, String rewardWebPath
	) {
		this.distinctParticipantsIn = new DistinctParticipantsIn();
		this.distinctParticipantsIn.setProgramWebPath(programWebPath);
		this.participantSummaryIn = new ParticipantSummaryIn();
		this.participantSummaryIn.setProgramWebPath(programWebPath);
		this.participantSummaryIn.setPlayerWebPath(playerWebPath);
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
		this.getPropertiesIn = new GetPropertiesIn();
		this.getPropertiesIn.setEntityType(entityType);
		this.getPropertiesIn.setEntityWebPath(entityWebPath);
		this.getPropertiesIn.setProperty(property);
		this.participantGameActivityIn = new ParticipantGameActivityIn();
		this.participantGameActivityIn.setProgramWebPath(programWebPath);
		this.participantGameActivityIn.setPlayerWebPath(playerWebPath);
		this.participantGameActivityIn.setGameWebPath(gameWebPath);
		this.participantGameActivityIn.setGameTagWebPath(gameTagWebPath);
		this.participantGameActivityIn.setRewardWebPath(rewardWebPath);
		this.participantCampActivityIn = new ParticipantCampActivityIn();
		this.participantCampActivityIn.setProgramWebPath(programWebPath);
		this.participantCampActivityIn.setTeamWebPath(teamWebPath);
		this.participantCampActivityIn.setPlayerWebPath(playerWebPath);
		this.gamePerformanceIn = new GamePerformanceIn();
		this.gamePerformanceIn.setPlayerWebPath(playerWebPath);
		this.gamePerformanceIn.setProgramWebPath(programWebPath);
		this.teamParticipantTimelineIn = new TeamParticipantTimelineIn();
		this.teamParticipantTimelineIn.setProgramWebPath(programWebPath);
		this.teamParticipantTimelineIn.setTeamWebPath(teamWebPath);
		this.teamParticipantTimelineIn.setPlayerWebPath(playerWebPath);
	}
    private String programWebPath;
    private String playerWebPath;
    private String gameWebPath;
    private String teamWebPath;
    private String gameTypeWebPath;
    private String gameStakeTypeWebPath;
    private String gameParticipationTypeWebPath;
    private String gameActivityTypeWebPath;
    private Integer untilDay;
    private String entityType;
    private String entityWebPath;
    private String property;
    private String gameTagWebPath;
    private String rewardWebPath;
    private DistinctParticipantsIn distinctParticipantsIn;
    private ParticipantSummaryIn participantSummaryIn;
    private GameStatsIn gameStatsIn;
    private GetPropertiesIn getPropertiesIn;
    private ParticipantGameActivityIn participantGameActivityIn;
    private ParticipantCampActivityIn participantCampActivityIn;
    private GamePerformanceIn gamePerformanceIn;
    private TeamParticipantTimelineIn teamParticipantTimelineIn;


}
