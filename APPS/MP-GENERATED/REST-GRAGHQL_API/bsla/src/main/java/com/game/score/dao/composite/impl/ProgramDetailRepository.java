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
	* - name      : SDDCompositeSpringJPADao
	* - file name : SDDCompositeSpringJPADao.vm
*/
package com.game.score.dao.composite.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.score.composite.in.program.ProgramDetailIn;
import com.game.score.composite.out.program.ProgramDetailOut;

import com.game.score.dao.sdd.face.property.GetPropertiesDaoFace;
import com.game.score.dao.sdd.face.distinct.DistinctProgramsDaoFace;
import com.game.score.dao.sdd.face.info.ProgramInfoDaoFace;
import com.game.score.dao.sdd.face.participant.ParticipantGameActivityDaoFace;
import com.game.score.dao.sdd.face.participant.ParticipantCampActivityDaoFace;
import com.game.score.dao.sdd.face.timeline.TeamParticipantTimelineDaoFace;
import com.game.score.dao.sdd.face.timeline.TeamGameTimelineDaoFace;
import com.game.score.dao.sdd.face.stat.GameStatsDaoFace;
import com.game.score.sdd.out.property.GetPropertiesOutList;
import com.game.score.sdd.out.distinct.DistinctProgramsOutList;
import com.game.score.sdd.out.info.ProgramInfoOutList;
import com.game.score.sdd.out.participant.ParticipantGameActivityOutList;
import com.game.score.sdd.out.participant.ParticipantCampActivityOutList;
import com.game.score.sdd.out.timeline.TeamParticipantTimelineOutList;
import com.game.score.sdd.out.timeline.TeamGameTimelineOutList;
import com.game.score.sdd.out.stat.GameStatsOutList;

import com.game.score.dao.composite.face.ProgramDetailDaoFace;
/**
 *
 * <p>Title: ProgramDetailRepository</p>
 *
 * <p>Description: Interface for ProgramDetailRepository service </p>
 *
 */
@Repository ("programDetailDaoFace")
@Transactional(propagation = Propagation.REQUIRED) 
public class ProgramDetailRepository implements ProgramDetailDaoFace {

	@Autowired
	@Qualifier("getPropertiesDaoFace")
	GetPropertiesDaoFace getPropertiesDaoFace;
	@Autowired
	@Qualifier("distinctProgramsDaoFace")
	DistinctProgramsDaoFace distinctProgramsDaoFace;
	@Autowired
	@Qualifier("programInfoDaoFace")
	ProgramInfoDaoFace programInfoDaoFace;
	@Autowired
	@Qualifier("participantGameActivityDaoFace")
	ParticipantGameActivityDaoFace participantGameActivityDaoFace;
	@Autowired
	@Qualifier("participantCampActivityDaoFace")
	ParticipantCampActivityDaoFace participantCampActivityDaoFace;
	@Autowired
	@Qualifier("teamParticipantTimelineDaoFace")
	TeamParticipantTimelineDaoFace teamParticipantTimelineDaoFace;
	@Autowired
	@Qualifier("teamGameTimelineDaoFace")
	TeamGameTimelineDaoFace teamGameTimelineDaoFace;
	@Autowired
	@Qualifier("gameStatsDaoFace")
	GameStatsDaoFace gameStatsDaoFace;


    public ProgramDetailOut execute (ProgramDetailIn programDetailIn) {
		ProgramDetailOut programDetailOut = new ProgramDetailOut();
		GetPropertiesOutList getPropertiesOutList = getPropertiesDaoFace.execute (programDetailIn.getGetPropertiesIn());
		programDetailOut.setGetPropertiesOutList (getPropertiesOutList);
		DistinctProgramsOutList distinctProgramsOutList = distinctProgramsDaoFace.execute ();
		programDetailOut.setDistinctProgramsOutList (distinctProgramsOutList);
		ProgramInfoOutList programInfoOutList = programInfoDaoFace.execute (programDetailIn.getProgramInfoIn());
		programDetailOut.setProgramInfoOutList (programInfoOutList);
		ParticipantGameActivityOutList participantGameActivityOutList = participantGameActivityDaoFace.execute (programDetailIn.getParticipantGameActivityIn());
		programDetailOut.setParticipantGameActivityOutList (participantGameActivityOutList);
		ParticipantCampActivityOutList participantCampActivityOutList = participantCampActivityDaoFace.execute (programDetailIn.getParticipantCampActivityIn());
		programDetailOut.setParticipantCampActivityOutList (participantCampActivityOutList);
		TeamParticipantTimelineOutList teamParticipantTimelineOutList = teamParticipantTimelineDaoFace.execute (programDetailIn.getTeamParticipantTimelineIn());
		programDetailOut.setTeamParticipantTimelineOutList (teamParticipantTimelineOutList);
		TeamGameTimelineOutList teamGameTimelineOutList = teamGameTimelineDaoFace.execute (programDetailIn.getTeamGameTimelineIn());
		programDetailOut.setTeamGameTimelineOutList (teamGameTimelineOutList);
		GameStatsOutList gameStatsOutList = gameStatsDaoFace.execute (programDetailIn.getGameStatsIn());
		programDetailOut.setGameStatsOutList (gameStatsOutList);
		return programDetailOut;
	}




}