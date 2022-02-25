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

import com.game.score.composite.in.game.GameSearchIn;
import com.game.score.composite.out.game.GameSearchOut;

import com.game.score.dao.sdd.face.game.GameInfoDaoFace;
import com.game.score.dao.sdd.face.distinct.DistinctProgramsDaoFace;
import com.game.score.dao.sdd.face.distinct.DistinctGameTagsDaoFace;
import com.game.score.dao.sdd.face.info.ProgramInfoDaoFace;
import com.game.score.sdd.out.game.GameInfoOutList;
import com.game.score.sdd.out.distinct.DistinctProgramsOutList;
import com.game.score.sdd.out.distinct.DistinctGameTagsOutList;
import com.game.score.sdd.out.info.ProgramInfoOutList;

import com.game.score.dao.composite.face.GameSearchDaoFace;
/**
 *
 * <p>Title: GameSearchRepository</p>
 *
 * <p>Description: Interface for GameSearchRepository service </p>
 *
 */
@Repository ("gameSearchDaoFace")
@Transactional(propagation = Propagation.REQUIRED) 
public class GameSearchRepository implements GameSearchDaoFace {

	@Autowired
	@Qualifier("gameInfoDaoFace")
	GameInfoDaoFace gameInfoDaoFace;
	@Autowired
	@Qualifier("distinctProgramsDaoFace")
	DistinctProgramsDaoFace distinctProgramsDaoFace;
	@Autowired
	@Qualifier("distinctGameTagsDaoFace")
	DistinctGameTagsDaoFace distinctGameTagsDaoFace;
	@Autowired
	@Qualifier("programInfoDaoFace")
	ProgramInfoDaoFace programInfoDaoFace;


    public GameSearchOut execute (GameSearchIn gameSearchIn) {
		GameSearchOut gameSearchOut = new GameSearchOut();
		GameInfoOutList gameInfoOutList = gameInfoDaoFace.execute (gameSearchIn.getGameInfoIn());
		gameSearchOut.setGameInfoOutList (gameInfoOutList);
		DistinctProgramsOutList distinctProgramsOutList = distinctProgramsDaoFace.execute ();
		gameSearchOut.setDistinctProgramsOutList (distinctProgramsOutList);
		DistinctGameTagsOutList distinctGameTagsOutList = distinctGameTagsDaoFace.execute (gameSearchIn.getDistinctGameTagsIn());
		gameSearchOut.setDistinctGameTagsOutList (distinctGameTagsOutList);
		ProgramInfoOutList programInfoOutList = programInfoDaoFace.execute (gameSearchIn.getProgramInfoIn());
		gameSearchOut.setProgramInfoOutList (programInfoOutList);
		return gameSearchOut;
	}




}