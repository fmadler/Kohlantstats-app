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
package com.game.score.dao.sdd.impl.quizz;



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
import com.game.score.sdd.out.quizz.QuizzParticipationFilterMatrixOutList;
import com.game.score.sdd.out.quizz.QuizzParticipationFilterMatrixOut;
import com.game.score.dao.sdd.face.quizz.QuizzParticipationFilterMatrixDaoFace;
import com.game.score.sdd.in.quizz.QuizzParticipationFilterMatrixIn;
/**
 *
 * <p>Title: QuizzParticipationFilterMatrixRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("quizzParticipationFilterMatrixDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class QuizzParticipationFilterMatrixRepository implements QuizzParticipationFilterMatrixDaoFace {

	public static final String QUERY_NATIVE = "select 									distinct 									pg.edition_number, 									pg.name program_name, 									pg.web_path program_web_path, 									g.time_position, 									g.name game_name, 									g.web_path game_web_path 								from 									gs_program pg, 									gs_game g, 									gs_participant_x_game pxg, 									gs_game_participation_type gpt 								where 									g.gs_program_id = pg.id and 									pxg.GS_GAME_ID = g.ID and 									pxg.gs_game_participation_type_id = gpt.id 									$whereProgramWebPath 									$whereGameTypeWebPath 									$whereParticipationTypeWebPath 								order by pg.edition_number desc, g.time_position asc";
	public static final String CHUNK_whereProgramWebPath = "pg.web_path = ?";
	public static final String CHUNK_whereGameTypeWebPath = "g.web_path = ?";
	public static final String CHUNK_whereParticipationTypeWebPath = "gpt.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="quizzParticipationFilterMatrixCache") 
    public QuizzParticipationFilterMatrixOutList execute (
		QuizzParticipationFilterMatrixIn quizzParticipationFilterMatrixIn
		) {
		QuizzParticipationFilterMatrixOutList quizzParticipationFilterMatrixOutList = new QuizzParticipationFilterMatrixOutList();
		QuizzParticipationFilterMatrixOutListWork work = new QuizzParticipationFilterMatrixOutListWork (
			quizzParticipationFilterMatrixIn
			);
        Session session = getSession();
        session.doWork(work);
		quizzParticipationFilterMatrixOutList.setQuizzParticipationFilterMatrixOuts (work.getResult());
        return quizzParticipationFilterMatrixOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(QuizzParticipationFilterMatrixIn quizzParticipationFilterMatrixIn) {
		if (quizzParticipationFilterMatrixIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameTypeWebPathActive(QuizzParticipationFilterMatrixIn quizzParticipationFilterMatrixIn) {
		if (quizzParticipationFilterMatrixIn.getGameWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereParticipationTypeWebPathActive(QuizzParticipationFilterMatrixIn quizzParticipationFilterMatrixIn) {
		if (quizzParticipationFilterMatrixIn.getParticipationTypeWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			QuizzParticipationFilterMatrixIn quizzParticipationFilterMatrixIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( quizzParticipationFilterMatrixIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(quizzParticipationFilterMatrixIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameTypeWebPathActive( quizzParticipationFilterMatrixIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameTypeWebPath", connectionWord + getChunkwhereGameTypeWebPath(quizzParticipationFilterMatrixIn, CHUNK_whereGameTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameTypeWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereParticipationTypeWebPathActive( quizzParticipationFilterMatrixIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereParticipationTypeWebPath", connectionWord + getChunkwhereParticipationTypeWebPath(quizzParticipationFilterMatrixIn, CHUNK_whereParticipationTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereParticipationTypeWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (QuizzParticipationFilterMatrixIn quizzParticipationFilterMatrixIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameTypeWebPath (QuizzParticipationFilterMatrixIn quizzParticipationFilterMatrixIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereParticipationTypeWebPath (QuizzParticipationFilterMatrixIn quizzParticipationFilterMatrixIn, String chunk) {
		return chunk;
	}
	
   private class QuizzParticipationFilterMatrixOutListWork implements Work {
		QuizzParticipationFilterMatrixIn quizzParticipationFilterMatrixIn;
        QuizzParticipationFilterMatrixOutListWork(
			QuizzParticipationFilterMatrixIn quizzParticipationFilterMatrixIn
			){
				this.quizzParticipationFilterMatrixIn = quizzParticipationFilterMatrixIn;
		}
		List<QuizzParticipationFilterMatrixOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, QuizzParticipationFilterMatrixIn quizzParticipationFilterMatrixIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( quizzParticipationFilterMatrixIn)) {
            if (quizzParticipationFilterMatrixIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzParticipationFilterMatrixIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameTypeWebPathActive( quizzParticipationFilterMatrixIn)) {
            if (quizzParticipationFilterMatrixIn.getGameWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzParticipationFilterMatrixIn.getGameWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereParticipationTypeWebPathActive( quizzParticipationFilterMatrixIn)) {
            if (quizzParticipationFilterMatrixIn.getParticipationTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzParticipationFilterMatrixIn.getParticipationTypeWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						quizzParticipationFilterMatrixIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, quizzParticipationFilterMatrixIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						QuizzParticipationFilterMatrixOut quizzParticipationFilterMatrixOut = new QuizzParticipationFilterMatrixOut();
						quizzParticipationFilterMatrixOut.setEditionNumber(rs.getInt("edition_number"));
						quizzParticipationFilterMatrixOut.setProgramName(rs.getString("program_name"));
						quizzParticipationFilterMatrixOut.setProgramWebPath(rs.getString("program_web_path"));
						quizzParticipationFilterMatrixOut.setTimePosition(rs.getString("time_position"));
						quizzParticipationFilterMatrixOut.setGameName(rs.getString("game_name"));
						quizzParticipationFilterMatrixOut.setGameWebPath(rs.getString("game_web_path"));
						list.add(quizzParticipationFilterMatrixOut);
	        		}	        	}			}
       }

       List<QuizzParticipationFilterMatrixOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}