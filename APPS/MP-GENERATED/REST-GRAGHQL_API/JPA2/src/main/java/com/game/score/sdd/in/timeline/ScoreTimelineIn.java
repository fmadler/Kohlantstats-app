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
	* - name      : SDDInputBean
	* - file name : JavaBean.vm
*/
package com.game.score.sdd.in.timeline;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import com.game.utils.JacksonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * <p>Title: ScoreTimelineIn</p>
 *
 * <p>Description: ScoreTimeline Java Bean </p>
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScoreTimelineIn {

    private String programWebPath;
    private String playerWebPathsInput;
    private List<String> playerWebPaths;

    public List<String> getPlayerWebPaths () {
        if (playerWebPaths==null)
            playerWebPaths = new ArrayList<String>();
        return playerWebPaths;
    }
    
    public void setPlayerWebPaths (String playerWebPaths) {
        this.playerWebPathsInput = playerWebPaths;
    	if (playerWebPaths!=null) {
    		for (String element : StringUtils.split(playerWebPaths, ",")) {
        		getPlayerWebPaths().add (element);
        	}
        }
    }
    private String playerWebPathInput;
    private List<String> playerWebPath;

    public List<String> getPlayerWebPath () {
        if (playerWebPath==null)
            playerWebPath = new ArrayList<String>();
        return playerWebPath;
    }
    
    public void setPlayerWebPath (String playerWebPath) {
        this.playerWebPathInput = playerWebPath;
    	if (playerWebPath!=null) {
    		for (String element : StringUtils.split(playerWebPath, ",")) {
        		getPlayerWebPath().add (element);
        	}
        }
    }
    private Integer day;
    private Integer rankingLessThanEqualTo;

}
