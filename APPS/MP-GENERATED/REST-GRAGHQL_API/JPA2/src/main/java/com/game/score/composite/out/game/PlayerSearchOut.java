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

import com.game.score.sdd.out.distinct.DistinctProgramsOutList;
import com.game.score.sdd.out.distinct.DistinctParticipantsOutList;
import com.game.score.sdd.out.info.ProgramInfoOutList;
import com.game.score.sdd.out.participant.ParticipantSummaryOutList;
import com.game.score.sdd.out.participant.ParticipantGameActivityOutList;
import com.game.score.sdd.out.stat.GameStatsOutList;
import com.game.score.sdd.out.game.GamePerformanceOutList;
import com.game.score.sdd.out.player.PlayerPerformanceComparisonOutList;


/**
 *
 * <p>Title: PlayerSearchOut</p>
 *
 * <p>Description: Java Bean Output composite</p>
 *
 */
@Data
public class PlayerSearchOut {
	private DistinctProgramsOutList distinctProgramsOutList;
    //private DistinctProgramsOut distinctProgramsOut;
	private DistinctParticipantsOutList distinctParticipantsOutList;
    //private DistinctParticipantsOut distinctParticipantsOut;
	private ProgramInfoOutList programInfoOutList;
    //private ProgramInfoOut programInfoOut;
	private ParticipantSummaryOutList participantSummaryOutList;
    //private ParticipantSummaryOut participantSummaryOut;
	private ParticipantGameActivityOutList participantGameActivityOutList;
    //private ParticipantGameActivityOut participantGameActivityOut;
	private GameStatsOutList gameStatsOutList;
    //private GameStatsOut gameStatsOut;
	private GamePerformanceOutList gamePerformanceOutList;
    //private GamePerformanceOut gamePerformanceOut;
	private PlayerPerformanceComparisonOutList playerPerformanceComparisonOutList;
    //private PlayerPerformanceComparisonOut playerPerformanceComparisonOut;


}
