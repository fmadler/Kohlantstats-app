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
package com.game.score.sdd.out.game;

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
 * <p>Title: GamePerformanceOut</p>
 *
 * <p>Description: GamePerformance Java Bean </p>
 *
 */
@Data
public class GamePerformanceOut {

    private String participantWebPath;
    private String tagName;
    private String tagWebPath;
    private Long totalNbOfGames;
    private Long performanceFirst;
    private java.math.BigDecimal performanceFirstPercent;
    private Long performanceFirstTwo;
    private java.math.BigDecimal performanceFirstTwoPercent;
    private Long totalNbOfGamesIndividual;
    private Long individualPerformanceFirst;
    private java.math.BigDecimal individualPerformanceFirstPercent;
    private Long individualPerformanceFirstTwo;
    private java.math.BigDecimal individualPerformanceFirstTwoPercent;
    private Long totalNbOfGamesInGroup;
    private Long inGroupPerformanceFirst;
    private java.math.BigDecimal inGroupPerformanceFirstPercent;
    private Long inGroupPerformanceFirstTwo;
    private java.math.BigDecimal inGroupPerformanceFirstTwoPercent;

}
