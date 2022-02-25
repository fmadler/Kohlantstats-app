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
	* - name      : SDDOutputBean
	* - file name : JavaBean.vm
*/
package com.game.score.sdd.out.participant;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import lombok.Data;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import com.game.utils.JacksonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * <p>Title: ParticipantGameActivityOut</p>
 *
 * <p>Description: ParticipantGameActivity Java Bean </p>
 *
 */
@Data
public class ParticipantGameActivityOut {

    private String playerName;
    private String playerWebPath;
    private String gameName;
    private String gameWebPath;
    private String teamName;
    private String teamWebPath;
    private String timePosition;
    private Integer timeUnitIndex;
    private String participationType;
    private String participationTypeWebPath;
    private String activityType;
    private String activityTypeWebPath;
    private Integer ranking;
    private java.math.BigDecimal score;
    private Long displayOrderAsc;
    private String gameTypeName;
    private String gameTypeWebPath;
    private String gameStakeTypeName;
    private String gameStakeTypeWebPath;
	@Data
	public class Rewards {
		String name;
		String webPath;
		String isPositive;
	}
    private List<Rewards> rewards;
	@Data
	public class GameRewards {
		String name;
		String webPath;
		String isPositive;
	}
    private List<GameRewards> gameRewards;
	@Data
	public class GameTags {
		String name;
		String webPath;
	}
    private List<GameTags> gameTags;

}
