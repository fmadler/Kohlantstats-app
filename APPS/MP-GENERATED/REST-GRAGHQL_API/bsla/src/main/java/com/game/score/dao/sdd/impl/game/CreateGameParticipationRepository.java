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
	* - name      : SDDSpringJPADao
	* - file name : SDDSpringJPADao.vm
*/
package com.game.score.dao.sdd.impl.game;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.game.score.sdd.out.game.CreateGameParticipationOutList;
import com.game.score.sdd.out.game.CreateGameParticipationOut;
import com.game.score.dao.sdd.face.game.CreateGameParticipationDaoFace;
import com.game.score.sdd.in.game.CreateGameParticipationIn;
/**
 *
 * <p>Title: CreateGameParticipationRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("createGameParticipationDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class CreateGameParticipationRepository implements CreateGameParticipationDaoFace {

	public static final String QUERY_NATIVE = "call create_game_participation (?, ?, ?, ?, ?, ?, ?)";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

    public CreateGameParticipationOutList execute (
		CreateGameParticipationIn createGameParticipationIn
		) {
		CreateGameParticipationOutList createGameParticipationOutList = new CreateGameParticipationOutList();
		CreateGameParticipationOutListWork work = new CreateGameParticipationOutListWork (
			createGameParticipationIn
			);
        Session session = getSession();
        session.doWork(work);
		createGameParticipationOutList.setCreateGameParticipationOuts (work.getResult());
        return createGameParticipationOutList;
    }




	public String getStatement(
			CreateGameParticipationIn createGameParticipationIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		return query;
	}
	
   private class CreateGameParticipationOutListWork implements Work {
		CreateGameParticipationIn createGameParticipationIn;
        CreateGameParticipationOutListWork(
			CreateGameParticipationIn createGameParticipationIn
			){
				this.createGameParticipationIn = createGameParticipationIn;
		}
		List<CreateGameParticipationOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			CallableStatement pstmt
			, CreateGameParticipationIn createGameParticipationIn			) throws SQLException {
			int index = 1;
            if (createGameParticipationIn.getParticipantWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, createGameParticipationIn.getParticipantWebPath()); 
            }
            index ++;
            if (createGameParticipationIn.getTeamWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, createGameParticipationIn.getTeamWebPath()); 
            }
            index ++;
            if (createGameParticipationIn.getGameWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, createGameParticipationIn.getGameWebPath()); 
            }
            index ++;
            if (createGameParticipationIn.getActivityTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, createGameParticipationIn.getActivityTypeWebPath()); 
            }
            index ++;
            if (createGameParticipationIn.getParticipationTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, createGameParticipationIn.getParticipationTypeWebPath()); 
            }
            index ++;
            if (createGameParticipationIn.getRanking()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, createGameParticipationIn.getRanking()); 
            }
            index ++;
            if (createGameParticipationIn.getRewardWebPaths()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, createGameParticipationIn.getRewardWebPaths()); 
            }
            index ++;
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				CallableStatement pstmt = conn.prepareCall(
					getStatement(
						createGameParticipationIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, createGameParticipationIn);
					pstmt.executeUpdate();
	        	}       }

       List<CreateGameParticipationOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}