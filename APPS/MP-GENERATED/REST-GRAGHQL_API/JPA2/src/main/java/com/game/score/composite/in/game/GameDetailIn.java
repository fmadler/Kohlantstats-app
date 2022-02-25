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
package com.game.score.composite.in.game;

import lombok.Data;
import java.util.List;

import com.game.score.sdd.in.property.GetPropertiesIn;
import com.game.score.sdd.in.participant.ParticipantGameActivityIn;
import com.game.score.sdd.in.distinct.DistinctGamesIn;
import com.game.score.sdd.in.info.ProgramInfoIn;


/**
 *
 * <p>Title: GameDetailIn</p>
 *
 * <p>Description: Java Bean Input composite</p>
 *
 */
@Data
public class GameDetailIn {

	public GameDetailIn (
		 String entityType
		, String entityWebPath
		, String property
		, String programWebPath
		, String playerWebPath
		, String gameWebPath
		, String gameTagWebPath
		, String rewardWebPath
		, String notProgramWebPath
		, String gameTypeWebPath
	) {
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
		this.distinctGamesIn = new DistinctGamesIn();
		this.distinctGamesIn.setProgramWebPath(programWebPath);
		this.distinctGamesIn.setNotProgramWebPath(notProgramWebPath);
		this.distinctGamesIn.setGameTypeWebPath(gameTypeWebPath);
		this.programInfoIn = new ProgramInfoIn();
		this.programInfoIn.setProgramWebPath(programWebPath);
	}
    private String entityType;
    private String entityWebPath;
    private String property;
    private String programWebPath;
    private String playerWebPath;
    private String gameWebPath;
    private String gameTagWebPath;
    private String rewardWebPath;
    private String notProgramWebPath;
    private String gameTypeWebPath;
    private GetPropertiesIn getPropertiesIn;
    private ParticipantGameActivityIn participantGameActivityIn;
    private DistinctGamesIn distinctGamesIn;
    private ProgramInfoIn programInfoIn;


}
