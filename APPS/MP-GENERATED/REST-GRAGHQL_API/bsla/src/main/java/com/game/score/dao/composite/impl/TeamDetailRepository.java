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

import com.game.score.composite.in.team.TeamDetailIn;
import com.game.score.composite.out.team.TeamDetailOut;

import com.game.score.dao.sdd.face.property.GetPropertiesDaoFace;
import com.game.score.dao.sdd.face.timeline.TeamParticipantTimelineDaoFace;
import com.game.score.dao.sdd.face.game.GamePerformanceDaoFace;
import com.game.score.dao.sdd.face.timeline.TeamGameTimelineDaoFace;
import com.game.score.dao.sdd.face.stat.GameStatsDaoFace;
import com.game.score.dao.sdd.face.info.TeamInfoDaoFace;
import com.game.score.dao.sdd.face.info.ProgramInfoDaoFace;
import com.game.score.sdd.out.property.GetPropertiesOutList;
import com.game.score.sdd.out.timeline.TeamParticipantTimelineOutList;
import com.game.score.sdd.out.game.GamePerformanceOutList;
import com.game.score.sdd.out.timeline.TeamGameTimelineOutList;
import com.game.score.sdd.out.stat.GameStatsOutList;
import com.game.score.sdd.out.info.TeamInfoOutList;
import com.game.score.sdd.out.info.ProgramInfoOutList;

import com.game.score.dao.composite.face.TeamDetailDaoFace;
/**
 *
 * <p>Title: TeamDetailRepository</p>
 *
 * <p>Description: Interface for TeamDetailRepository service </p>
 *
 */
@Repository ("teamDetailDaoFace")
@Transactional(propagation = Propagation.REQUIRED) 
public class TeamDetailRepository implements TeamDetailDaoFace {

	@Autowired
	@Qualifier("getPropertiesDaoFace")
	GetPropertiesDaoFace getPropertiesDaoFace;
	@Autowired
	@Qualifier("teamParticipantTimelineDaoFace")
	TeamParticipantTimelineDaoFace teamParticipantTimelineDaoFace;
	@Autowired
	@Qualifier("gamePerformanceDaoFace")
	GamePerformanceDaoFace gamePerformanceDaoFace;
	@Autowired
	@Qualifier("teamGameTimelineDaoFace")
	TeamGameTimelineDaoFace teamGameTimelineDaoFace;
	@Autowired
	@Qualifier("gameStatsDaoFace")
	GameStatsDaoFace gameStatsDaoFace;
	@Autowired
	@Qualifier("teamInfoDaoFace")
	TeamInfoDaoFace teamInfoDaoFace;
	@Autowired
	@Qualifier("programInfoDaoFace")
	ProgramInfoDaoFace programInfoDaoFace;


    public TeamDetailOut execute (TeamDetailIn teamDetailIn) {
		TeamDetailOut teamDetailOut = new TeamDetailOut();
		GetPropertiesOutList getPropertiesOutList = getPropertiesDaoFace.execute (teamDetailIn.getGetPropertiesIn());
		teamDetailOut.setGetPropertiesOutList (getPropertiesOutList);
		TeamParticipantTimelineOutList teamParticipantTimelineOutList = teamParticipantTimelineDaoFace.execute (teamDetailIn.getTeamParticipantTimelineIn());
		teamDetailOut.setTeamParticipantTimelineOutList (teamParticipantTimelineOutList);
		GamePerformanceOutList gamePerformanceOutList = gamePerformanceDaoFace.execute (teamDetailIn.getGamePerformanceIn());
		teamDetailOut.setGamePerformanceOutList (gamePerformanceOutList);
		TeamGameTimelineOutList teamGameTimelineOutList = teamGameTimelineDaoFace.execute (teamDetailIn.getTeamGameTimelineIn());
		teamDetailOut.setTeamGameTimelineOutList (teamGameTimelineOutList);
		GameStatsOutList gameStatsOutList = gameStatsDaoFace.execute (teamDetailIn.getGameStatsIn());
		teamDetailOut.setGameStatsOutList (gameStatsOutList);
		TeamInfoOutList teamInfoOutList = teamInfoDaoFace.execute (teamDetailIn.getTeamInfoIn());
		teamDetailOut.setTeamInfoOutList (teamInfoOutList);
		ProgramInfoOutList programInfoOutList = programInfoDaoFace.execute (teamDetailIn.getProgramInfoIn());
		teamDetailOut.setProgramInfoOutList (programInfoOutList);
		return teamDetailOut;
	}




}