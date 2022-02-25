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
	* - name      : SDDOutputBeanCollection
	* - file name : JavaBeanCollection.vm
*/
package com.game.score.sdd.out.timeline;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import com.game.score.sdd.out.timeline.TeamParticipantTimelineOut;


/**
 *
 * <p>Title: TeamParticipantTimelineOutList</p>
 *
 * <p>Description: Java Bean TeamParticipantTimelineOutList </p>
 *
 */
@XmlRootElement (name="TeamParticipantTimelineOutList")
public class TeamParticipantTimelineOutList {

    @XmlElement (name="TeamParticipantTimelineOut") //(name="teamparticipanttimelineouts")
    private List<TeamParticipantTimelineOut> teamParticipantTimelineOuts;

    /**
    * Default constructor
    */
    public TeamParticipantTimelineOutList() {
    }
	
    public void setTeamParticipantTimelineOuts (List<TeamParticipantTimelineOut> teamParticipantTimelineOuts) {
        this.teamParticipantTimelineOuts = teamParticipantTimelineOuts;
    }

    @XmlTransient
    public List<TeamParticipantTimelineOut> getTeamParticipantTimelineOuts () {
        if (teamParticipantTimelineOuts==null)
            teamParticipantTimelineOuts = new ArrayList<>();
        return teamParticipantTimelineOuts;
    }

    public void addTeamParticipantTimelineOut (TeamParticipantTimelineOut teamParticipantTimelineOut) {
        getTeamParticipantTimelineOuts ().add(teamParticipantTimelineOut);
    }



}
