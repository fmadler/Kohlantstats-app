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

import com.game.score.composite.in.game.PlayerSearchIn;
import com.game.score.composite.out.game.PlayerSearchOut;

import com.game.score.dao.sdd.face.distinct.DistinctProgramsDaoFace;
import com.game.score.dao.sdd.face.distinct.DistinctParticipantsDaoFace;
import com.game.score.dao.sdd.face.info.ProgramInfoDaoFace;
import com.game.score.dao.sdd.face.participant.ParticipantSummaryDaoFace;
import com.game.score.dao.sdd.face.participant.ParticipantGameActivityDaoFace;
import com.game.score.dao.sdd.face.stat.GameStatsDaoFace;
import com.game.score.dao.sdd.face.game.GamePerformanceDaoFace;
import com.game.score.dao.sdd.face.player.PlayerPerformanceComparisonDaoFace;
import com.game.score.sdd.out.distinct.DistinctProgramsOutList;
import com.game.score.sdd.out.distinct.DistinctParticipantsOutList;
import com.game.score.sdd.out.info.ProgramInfoOutList;
import com.game.score.sdd.out.participant.ParticipantSummaryOutList;
import com.game.score.sdd.out.participant.ParticipantGameActivityOutList;
import com.game.score.sdd.out.stat.GameStatsOutList;
import com.game.score.sdd.out.game.GamePerformanceOutList;
import com.game.score.sdd.out.player.PlayerPerformanceComparisonOutList;

import com.game.score.dao.composite.face.PlayerSearchDaoFace;
/**
 *
 * <p>Title: PlayerSearchRepository</p>
 *
 * <p>Description: Interface for PlayerSearchRepository service </p>
 *
 */
@Repository ("playerSearchDaoFace")
@Transactional(propagation = Propagation.REQUIRED) 
public class PlayerSearchRepository implements PlayerSearchDaoFace {

	@Autowired
	@Qualifier("distinctProgramsDaoFace")
	DistinctProgramsDaoFace distinctProgramsDaoFace;
	@Autowired
	@Qualifier("distinctParticipantsDaoFace")
	DistinctParticipantsDaoFace distinctParticipantsDaoFace;
	@Autowired
	@Qualifier("programInfoDaoFace")
	ProgramInfoDaoFace programInfoDaoFace;
	@Autowired
	@Qualifier("participantSummaryDaoFace")
	ParticipantSummaryDaoFace participantSummaryDaoFace;
	@Autowired
	@Qualifier("participantGameActivityDaoFace")
	ParticipantGameActivityDaoFace participantGameActivityDaoFace;
	@Autowired
	@Qualifier("gameStatsDaoFace")
	GameStatsDaoFace gameStatsDaoFace;
	@Autowired
	@Qualifier("gamePerformanceDaoFace")
	GamePerformanceDaoFace gamePerformanceDaoFace;
	@Autowired
	@Qualifier("playerPerformanceComparisonDaoFace")
	PlayerPerformanceComparisonDaoFace playerPerformanceComparisonDaoFace;


    public PlayerSearchOut execute (PlayerSearchIn playerSearchIn) {
		PlayerSearchOut playerSearchOut = new PlayerSearchOut();
		DistinctProgramsOutList distinctProgramsOutList = distinctProgramsDaoFace.execute ();
		playerSearchOut.setDistinctProgramsOutList (distinctProgramsOutList);
		DistinctParticipantsOutList distinctParticipantsOutList = distinctParticipantsDaoFace.execute (playerSearchIn.getDistinctParticipantsIn());
		playerSearchOut.setDistinctParticipantsOutList (distinctParticipantsOutList);
		ProgramInfoOutList programInfoOutList = programInfoDaoFace.execute (playerSearchIn.getProgramInfoIn());
		playerSearchOut.setProgramInfoOutList (programInfoOutList);
		ParticipantSummaryOutList participantSummaryOutList = participantSummaryDaoFace.execute (playerSearchIn.getParticipantSummaryIn());
		playerSearchOut.setParticipantSummaryOutList (participantSummaryOutList);
		ParticipantGameActivityOutList participantGameActivityOutList = participantGameActivityDaoFace.execute (playerSearchIn.getParticipantGameActivityIn());
		playerSearchOut.setParticipantGameActivityOutList (participantGameActivityOutList);
		GameStatsOutList gameStatsOutList = gameStatsDaoFace.execute (playerSearchIn.getGameStatsIn());
		playerSearchOut.setGameStatsOutList (gameStatsOutList);
		GamePerformanceOutList gamePerformanceOutList = gamePerformanceDaoFace.execute (playerSearchIn.getGamePerformanceIn());
		playerSearchOut.setGamePerformanceOutList (gamePerformanceOutList);
		PlayerPerformanceComparisonOutList playerPerformanceComparisonOutList = playerPerformanceComparisonDaoFace.execute (playerSearchIn.getPlayerPerformanceComparisonIn());
		playerSearchOut.setPlayerPerformanceComparisonOutList (playerPerformanceComparisonOutList);
		return playerSearchOut;
	}




}