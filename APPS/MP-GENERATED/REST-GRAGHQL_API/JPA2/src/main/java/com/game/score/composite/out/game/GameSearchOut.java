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
	* - name      : SDDOutputCompositeBean
	* - file name : JavaCompositeBean.vm
*/
package com.game.score.composite.out.game;

import lombok.Data;
import java.util.List;

import com.game.score.sdd.out.game.GameInfoOutList;
import com.game.score.sdd.out.distinct.DistinctProgramsOutList;
import com.game.score.sdd.out.distinct.DistinctGameTagsOutList;
import com.game.score.sdd.out.info.ProgramInfoOutList;


/**
 *
 * <p>Title: GameSearchOut</p>
 *
 * <p>Description: Java Bean Output composite</p>
 *
 */
@Data
public class GameSearchOut {
	private GameInfoOutList gameInfoOutList;
    //private GameInfoOut gameInfoOut;
	private DistinctProgramsOutList distinctProgramsOutList;
    //private DistinctProgramsOut distinctProgramsOut;
	private DistinctGameTagsOutList distinctGameTagsOutList;
    //private DistinctGameTagsOut distinctGameTagsOut;
	private ProgramInfoOutList programInfoOutList;
    //private ProgramInfoOut programInfoOut;


}
