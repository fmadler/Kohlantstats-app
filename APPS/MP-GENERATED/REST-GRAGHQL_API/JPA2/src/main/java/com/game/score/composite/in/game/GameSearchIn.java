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

import com.game.score.sdd.in.game.GameInfoIn;
import com.game.score.sdd.in.distinct.DistinctProgramsIn;
import com.game.score.sdd.in.distinct.DistinctGameTagsIn;
import com.game.score.sdd.in.info.ProgramInfoIn;


/**
 *
 * <p>Title: GameSearchIn</p>
 *
 * <p>Description: Java Bean Input composite</p>
 *
 */
@Data
public class GameSearchIn {

	public GameSearchIn (
		 String programWebPath
		, String gameWebPath
		, String gameTagWebPath
		, String rewardWebPath
	) {
		this.gameInfoIn = new GameInfoIn();
		this.gameInfoIn.setProgramWebPath(programWebPath);
		this.gameInfoIn.setGameWebPath(gameWebPath);
		this.gameInfoIn.setGameTagWebPath(gameTagWebPath);
		this.gameInfoIn.setRewardWebPath(rewardWebPath);
		this.distinctProgramsIn = new DistinctProgramsIn();
		this.distinctGameTagsIn = new DistinctGameTagsIn();
		this.distinctGameTagsIn.setProgramWebPath(programWebPath);
		this.programInfoIn = new ProgramInfoIn();
		this.programInfoIn.setProgramWebPath(programWebPath);
	}
    private String programWebPath;
    private String gameWebPath;
    private String gameTagWebPath;
    private String rewardWebPath;
    private GameInfoIn gameInfoIn;
    private DistinctProgramsIn distinctProgramsIn;
    private DistinctGameTagsIn distinctGameTagsIn;
    private ProgramInfoIn programInfoIn;


}
