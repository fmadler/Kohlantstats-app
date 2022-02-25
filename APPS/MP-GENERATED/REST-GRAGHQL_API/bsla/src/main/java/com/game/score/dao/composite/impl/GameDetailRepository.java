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

import com.game.score.composite.in.game.GameDetailIn;
import com.game.score.composite.out.game.GameDetailOut;

import com.game.score.dao.sdd.face.property.GetPropertiesDaoFace;
import com.game.score.dao.sdd.face.participant.ParticipantGameActivityDaoFace;
import com.game.score.dao.sdd.face.distinct.DistinctGamesDaoFace;
import com.game.score.dao.sdd.face.info.ProgramInfoDaoFace;
import com.game.score.sdd.out.property.GetPropertiesOutList;
import com.game.score.sdd.out.participant.ParticipantGameActivityOutList;
import com.game.score.sdd.out.distinct.DistinctGamesOutList;
import com.game.score.sdd.out.info.ProgramInfoOutList;

import com.game.score.dao.composite.face.GameDetailDaoFace;
/**
 *
 * <p>Title: GameDetailRepository</p>
 *
 * <p>Description: Interface for GameDetailRepository service </p>
 *
 */
@Repository ("gameDetailDaoFace")
@Transactional(propagation = Propagation.REQUIRED) 
public class GameDetailRepository implements GameDetailDaoFace {

	@Autowired
	@Qualifier("getPropertiesDaoFace")
	GetPropertiesDaoFace getPropertiesDaoFace;
	@Autowired
	@Qualifier("participantGameActivityDaoFace")
	ParticipantGameActivityDaoFace participantGameActivityDaoFace;
	@Autowired
	@Qualifier("distinctGamesDaoFace")
	DistinctGamesDaoFace distinctGamesDaoFace;
	@Autowired
	@Qualifier("programInfoDaoFace")
	ProgramInfoDaoFace programInfoDaoFace;


    public GameDetailOut execute (GameDetailIn gameDetailIn) {
		GameDetailOut gameDetailOut = new GameDetailOut();
		GetPropertiesOutList getPropertiesOutList = getPropertiesDaoFace.execute (gameDetailIn.getGetPropertiesIn());
		gameDetailOut.setGetPropertiesOutList (getPropertiesOutList);
		ParticipantGameActivityOutList participantGameActivityOutList = participantGameActivityDaoFace.execute (gameDetailIn.getParticipantGameActivityIn());
		gameDetailOut.setParticipantGameActivityOutList (participantGameActivityOutList);
		DistinctGamesOutList distinctGamesOutList = distinctGamesDaoFace.execute (gameDetailIn.getDistinctGamesIn());
		gameDetailOut.setDistinctGamesOutList (distinctGamesOutList);
		ProgramInfoOutList programInfoOutList = programInfoDaoFace.execute (gameDetailIn.getProgramInfoIn());
		gameDetailOut.setProgramInfoOutList (programInfoOutList);
		return gameDetailOut;
	}




}