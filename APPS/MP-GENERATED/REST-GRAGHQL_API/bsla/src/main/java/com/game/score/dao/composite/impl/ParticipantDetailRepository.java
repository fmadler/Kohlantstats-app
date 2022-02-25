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

import com.game.score.composite.in.participant.ParticipantDetailIn;
import com.game.score.composite.out.participant.ParticipantDetailOut;

import com.game.score.dao.sdd.face.distinct.DistinctParticipantsDaoFace;
import com.game.score.dao.sdd.face.participant.ParticipantSummaryDaoFace;
import com.game.score.dao.sdd.face.stat.GameStatsDaoFace;
import com.game.score.dao.sdd.face.property.GetPropertiesDaoFace;
import com.game.score.dao.sdd.face.participant.ParticipantGameActivityDaoFace;
import com.game.score.dao.sdd.face.participant.ParticipantCampActivityDaoFace;
import com.game.score.dao.sdd.face.game.GamePerformanceDaoFace;
import com.game.score.dao.sdd.face.timeline.TeamParticipantTimelineDaoFace;
import com.game.score.sdd.out.distinct.DistinctParticipantsOutList;
import com.game.score.sdd.out.participant.ParticipantSummaryOutList;
import com.game.score.sdd.out.stat.GameStatsOutList;
import com.game.score.sdd.out.property.GetPropertiesOutList;
import com.game.score.sdd.out.participant.ParticipantGameActivityOutList;
import com.game.score.sdd.out.participant.ParticipantCampActivityOutList;
import com.game.score.sdd.out.game.GamePerformanceOutList;
import com.game.score.sdd.out.timeline.TeamParticipantTimelineOutList;

import com.game.score.dao.composite.face.ParticipantDetailDaoFace;
/**
 *
 * <p>Title: ParticipantDetailRepository</p>
 *
 * <p>Description: Interface for ParticipantDetailRepository service </p>
 *
 */
@Repository ("participantDetailDaoFace")
@Transactional(propagation = Propagation.REQUIRED) 
public class ParticipantDetailRepository implements ParticipantDetailDaoFace {

	@Autowired
	@Qualifier("distinctParticipantsDaoFace")
	DistinctParticipantsDaoFace distinctParticipantsDaoFace;
	@Autowired
	@Qualifier("participantSummaryDaoFace")
	ParticipantSummaryDaoFace participantSummaryDaoFace;
	@Autowired
	@Qualifier("gameStatsDaoFace")
	GameStatsDaoFace gameStatsDaoFace;
	@Autowired
	@Qualifier("getPropertiesDaoFace")
	GetPropertiesDaoFace getPropertiesDaoFace;
	@Autowired
	@Qualifier("participantGameActivityDaoFace")
	ParticipantGameActivityDaoFace participantGameActivityDaoFace;
	@Autowired
	@Qualifier("participantCampActivityDaoFace")
	ParticipantCampActivityDaoFace participantCampActivityDaoFace;
	@Autowired
	@Qualifier("gamePerformanceDaoFace")
	GamePerformanceDaoFace gamePerformanceDaoFace;
	@Autowired
	@Qualifier("teamParticipantTimelineDaoFace")
	TeamParticipantTimelineDaoFace teamParticipantTimelineDaoFace;


    public ParticipantDetailOut execute (ParticipantDetailIn participantDetailIn) {
		ParticipantDetailOut participantDetailOut = new ParticipantDetailOut();
		DistinctParticipantsOutList distinctParticipantsOutList = distinctParticipantsDaoFace.execute (participantDetailIn.getDistinctParticipantsIn());
		participantDetailOut.setDistinctParticipantsOutList (distinctParticipantsOutList);
		ParticipantSummaryOutList participantSummaryOutList = participantSummaryDaoFace.execute (participantDetailIn.getParticipantSummaryIn());
		participantDetailOut.setParticipantSummaryOutList (participantSummaryOutList);
		GameStatsOutList gameStatsOutList = gameStatsDaoFace.execute (participantDetailIn.getGameStatsIn());
		participantDetailOut.setGameStatsOutList (gameStatsOutList);
		GetPropertiesOutList getPropertiesOutList = getPropertiesDaoFace.execute (participantDetailIn.getGetPropertiesIn());
		participantDetailOut.setGetPropertiesOutList (getPropertiesOutList);
		ParticipantGameActivityOutList participantGameActivityOutList = participantGameActivityDaoFace.execute (participantDetailIn.getParticipantGameActivityIn());
		participantDetailOut.setParticipantGameActivityOutList (participantGameActivityOutList);
		ParticipantCampActivityOutList participantCampActivityOutList = participantCampActivityDaoFace.execute (participantDetailIn.getParticipantCampActivityIn());
		participantDetailOut.setParticipantCampActivityOutList (participantCampActivityOutList);
		GamePerformanceOutList gamePerformanceOutList = gamePerformanceDaoFace.execute (participantDetailIn.getGamePerformanceIn());
		participantDetailOut.setGamePerformanceOutList (gamePerformanceOutList);
		TeamParticipantTimelineOutList teamParticipantTimelineOutList = teamParticipantTimelineDaoFace.execute (participantDetailIn.getTeamParticipantTimelineIn());
		participantDetailOut.setTeamParticipantTimelineOutList (teamParticipantTimelineOutList);
		return participantDetailOut;
	}




}