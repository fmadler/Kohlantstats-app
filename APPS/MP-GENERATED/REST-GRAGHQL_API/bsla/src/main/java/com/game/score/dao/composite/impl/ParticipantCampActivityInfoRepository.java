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

import com.game.score.composite.in.info.ParticipantCampActivityInfoIn;
import com.game.score.composite.out.info.ParticipantCampActivityInfoOut;

import com.game.score.dao.sdd.face.participant.ParticipantCampActivityDaoFace;
import com.game.score.dao.sdd.face.distinct.DistinctProgramsDaoFace;
import com.game.score.dao.sdd.face.distinct.DistinctTeamsDaoFace;
import com.game.score.dao.sdd.face.distinct.DistinctParticipantsDaoFace;
import com.game.score.sdd.out.participant.ParticipantCampActivityOutList;
import com.game.score.sdd.out.distinct.DistinctProgramsOutList;
import com.game.score.sdd.out.distinct.DistinctTeamsOutList;
import com.game.score.sdd.out.distinct.DistinctParticipantsOutList;

import com.game.score.dao.composite.face.ParticipantCampActivityInfoDaoFace;
/**
 *
 * <p>Title: ParticipantCampActivityInfoRepository</p>
 *
 * <p>Description: Interface for ParticipantCampActivityInfoRepository service </p>
 *
 */
@Repository ("participantCampActivityInfoDaoFace")
@Transactional(propagation = Propagation.REQUIRED) 
public class ParticipantCampActivityInfoRepository implements ParticipantCampActivityInfoDaoFace {

	@Autowired
	@Qualifier("participantCampActivityDaoFace")
	ParticipantCampActivityDaoFace participantCampActivityDaoFace;
	@Autowired
	@Qualifier("distinctProgramsDaoFace")
	DistinctProgramsDaoFace distinctProgramsDaoFace;
	@Autowired
	@Qualifier("distinctTeamsDaoFace")
	DistinctTeamsDaoFace distinctTeamsDaoFace;
	@Autowired
	@Qualifier("distinctParticipantsDaoFace")
	DistinctParticipantsDaoFace distinctParticipantsDaoFace;


    public ParticipantCampActivityInfoOut execute (ParticipantCampActivityInfoIn participantCampActivityInfoIn) {
		ParticipantCampActivityInfoOut participantCampActivityInfoOut = new ParticipantCampActivityInfoOut();
		ParticipantCampActivityOutList participantCampActivityOutList = participantCampActivityDaoFace.execute (participantCampActivityInfoIn.getParticipantCampActivityIn());
		participantCampActivityInfoOut.setParticipantCampActivityOutList (participantCampActivityOutList);
		DistinctProgramsOutList distinctProgramsOutList = distinctProgramsDaoFace.execute ();
		participantCampActivityInfoOut.setDistinctProgramsOutList (distinctProgramsOutList);
		DistinctTeamsOutList distinctTeamsOutList = distinctTeamsDaoFace.execute (participantCampActivityInfoIn.getDistinctTeamsIn());
		participantCampActivityInfoOut.setDistinctTeamsOutList (distinctTeamsOutList);
		DistinctParticipantsOutList distinctParticipantsOutList = distinctParticipantsDaoFace.execute (participantCampActivityInfoIn.getDistinctParticipantsIn());
		participantCampActivityInfoOut.setDistinctParticipantsOutList (distinctParticipantsOutList);
		return participantCampActivityInfoOut;
	}




}