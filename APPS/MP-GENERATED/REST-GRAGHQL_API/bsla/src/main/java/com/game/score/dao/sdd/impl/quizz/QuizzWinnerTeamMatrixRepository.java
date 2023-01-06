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
import com.game.score.sdd.out.quizz.QuizzWinnerTeamMatrixOutList;
import com.game.score.sdd.out.quizz.QuizzWinnerTeamMatrixOut;
import com.game.score.dao.sdd.face.quizz.QuizzWinnerTeamMatrixDaoFace;
import com.game.score.sdd.in.quizz.QuizzWinnerTeamMatrixIn;
/**
 *
 * <p>Title: QuizzWinnerTeamMatrixRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("quizzWinnerTeamMatrixDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class QuizzWinnerTeamMatrixRepository implements QuizzWinnerTeamMatrixDaoFace {

	public static final String QUERY_NATIVE = "select 								p.name program_name, 								p.web_path program_web_path, 								g.name game_name, 								g.web_path game_web_path 							from 								gs_game g, gs_program p 							where 								g.GS_PROGRAM_ID = p.ID 								and exists ( 									select txg.GS_GAME_ID, count(*) from gs_team t, gs_team_x_game txg 									where t.ID = txg.GS_TEAM_ID and g.ID = txg.GS_GAME_ID 									group by txg.GS_GAME_ID 									having count(*) > 1 								) 							$whereProgramWebPath 							order by program_name, game_name $___max_result___ $___offset___";
	public static final String CHUNK_whereProgramWebPath = "p.web_path = ?";
	public static final String CHUNK____max_result___ = "limit ?";
	public static final String CHUNK____offset___ = "offset ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="quizzWinnerTeamMatrixCache") 
    public QuizzWinnerTeamMatrixOutList execute (
		QuizzWinnerTeamMatrixIn quizzWinnerTeamMatrixIn
		) {
		QuizzWinnerTeamMatrixOutList quizzWinnerTeamMatrixOutList = new QuizzWinnerTeamMatrixOutList();
		QuizzWinnerTeamMatrixOutListWork work = new QuizzWinnerTeamMatrixOutListWork (
			quizzWinnerTeamMatrixIn
			);
        Session session = getSession();
        session.doWork(work);
		quizzWinnerTeamMatrixOutList.setQuizzWinnerTeamMatrixOuts (work.getResult());
        return quizzWinnerTeamMatrixOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(QuizzWinnerTeamMatrixIn quizzWinnerTeamMatrixIn) {
		if (quizzWinnerTeamMatrixIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilter___max_result___Active(QuizzWinnerTeamMatrixIn quizzWinnerTeamMatrixIn) {
		if (quizzWinnerTeamMatrixIn.getLimit() == null) return false;
		return true;	
	}
	public boolean isFilter___offset___Active(QuizzWinnerTeamMatrixIn quizzWinnerTeamMatrixIn) {
		if (quizzWinnerTeamMatrixIn.getOffset() == null) return false;
		return true;	
	}


	public String getStatement(
			QuizzWinnerTeamMatrixIn quizzWinnerTeamMatrixIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( quizzWinnerTeamMatrixIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(quizzWinnerTeamMatrixIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilter___max_result___Active( quizzWinnerTeamMatrixIn)			) {
			String connectionWord = " AND ";
			connectionWord = "";
			query = StringUtils.replace (query, "$"+"___max_result___", connectionWord + getChunk___max_result___(quizzWinnerTeamMatrixIn, CHUNK____max_result___) ); //replaceOnce
		} else {
			query = StringUtils.replace (query, "$"+"___max_result___","");//replaceOnce
		}
		if (
			 isFilter___offset___Active( quizzWinnerTeamMatrixIn)			) {
			String connectionWord = " AND ";
			connectionWord = "";
			query = StringUtils.replace (query, "$"+"___offset___", connectionWord + getChunk___offset___(quizzWinnerTeamMatrixIn, CHUNK____offset___) ); //replaceOnce
		} else {
			query = StringUtils.replace (query, "$"+"___offset___","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (QuizzWinnerTeamMatrixIn quizzWinnerTeamMatrixIn, String chunk) {
		return chunk;
	}

	private String getChunk___max_result___ (QuizzWinnerTeamMatrixIn quizzWinnerTeamMatrixIn, String chunk) {
		return chunk;
	}

	private String getChunk___offset___ (QuizzWinnerTeamMatrixIn quizzWinnerTeamMatrixIn, String chunk) {
		return chunk;
	}
	
   private class QuizzWinnerTeamMatrixOutListWork implements Work {
		QuizzWinnerTeamMatrixIn quizzWinnerTeamMatrixIn;
        QuizzWinnerTeamMatrixOutListWork(
			QuizzWinnerTeamMatrixIn quizzWinnerTeamMatrixIn
			){
				this.quizzWinnerTeamMatrixIn = quizzWinnerTeamMatrixIn;
		}
		List<QuizzWinnerTeamMatrixOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, QuizzWinnerTeamMatrixIn quizzWinnerTeamMatrixIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( quizzWinnerTeamMatrixIn)) {
            if (quizzWinnerTeamMatrixIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzWinnerTeamMatrixIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilter___max_result___Active( quizzWinnerTeamMatrixIn)) {
            if (quizzWinnerTeamMatrixIn.getLimit()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, quizzWinnerTeamMatrixIn.getLimit()); 
            }
            index ++;
			}
			if (isFilter___offset___Active( quizzWinnerTeamMatrixIn)) {
            if (quizzWinnerTeamMatrixIn.getOffset()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, quizzWinnerTeamMatrixIn.getOffset()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						quizzWinnerTeamMatrixIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, quizzWinnerTeamMatrixIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						QuizzWinnerTeamMatrixOut quizzWinnerTeamMatrixOut = new QuizzWinnerTeamMatrixOut();
						quizzWinnerTeamMatrixOut.setProgramName(rs.getString("program_name"));
						quizzWinnerTeamMatrixOut.setProgramWebPath(rs.getString("program_web_path"));
						quizzWinnerTeamMatrixOut.setGameName(rs.getString("game_name"));
						quizzWinnerTeamMatrixOut.setGameWebPath(rs.getString("game_web_path"));
						list.add(quizzWinnerTeamMatrixOut);
	        		}	        	}			}
       }

       List<QuizzWinnerTeamMatrixOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}