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
import com.game.score.sdd.out.quizz.QuizzWinnerTeamOptionOutList;
import com.game.score.sdd.out.quizz.QuizzWinnerTeamOptionOut;
import com.game.score.dao.sdd.face.quizz.QuizzWinnerTeamOptionDaoFace;
import com.game.score.sdd.in.quizz.QuizzWinnerTeamOptionIn;
/**
 *
 * <p>Title: QuizzWinnerTeamOptionRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("quizzWinnerTeamOptionDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class QuizzWinnerTeamOptionRepository implements QuizzWinnerTeamOptionDaoFace {

	public static final String QUERY_NATIVE = "select 								p.name program_name, 								p.web_path program_web_path, 								g.name game_name, 								g.web_path game_web_path, 								t.name team_name, 								t.web_path team_web_path, 								ranking, 								case when ranking = 1 then 1 else RAND(6) end as score 							from 								gs_game g, gs_team t, gs_team_x_game txg, gs_program p 							where 								t.ID = txg.GS_TEAM_ID and g.ID = txg.GS_GAME_ID and g.GS_PROGRAM_ID = p.ID 								and exists ( 									select txg.GS_GAME_ID, count(*) from gs_team t, gs_team_x_game txg 									where t.ID = txg.GS_TEAM_ID and g.ID = txg.GS_GAME_ID 									group by txg.GS_GAME_ID 									having count(*) > 1 								) 								$whereProgramWebPath 								$whereGameWebPath 								$whereRanking 								order by program_name, game_name, score desc $___max_result___ $___offset___";
	public static final String CHUNK_whereProgramWebPath = "p.web_path = ?";
	public static final String CHUNK_whereRanking = "ranking = ?";
	public static final String CHUNK_whereGameWebPath = "g.web_path = ?";
	public static final String CHUNK____max_result___ = "limit ?";
	public static final String CHUNK____offset___ = "offset ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="quizzWinnerTeamOptionCache") 
    public QuizzWinnerTeamOptionOutList execute (
		QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn
		) {
		QuizzWinnerTeamOptionOutList quizzWinnerTeamOptionOutList = new QuizzWinnerTeamOptionOutList();
		QuizzWinnerTeamOptionOutListWork work = new QuizzWinnerTeamOptionOutListWork (
			quizzWinnerTeamOptionIn
			);
        Session session = getSession();
        session.doWork(work);
		quizzWinnerTeamOptionOutList.setQuizzWinnerTeamOptionOuts (work.getResult());
        return quizzWinnerTeamOptionOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn) {
		if (quizzWinnerTeamOptionIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereRankingActive(QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn) {
		if (quizzWinnerTeamOptionIn.getRanking() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameWebPathActive(QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn) {
		if (quizzWinnerTeamOptionIn.getGameWebPath() == null) return false;
		return true;	
	}
	public boolean isFilter___max_result___Active(QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn) {
		if (quizzWinnerTeamOptionIn.getLimit() == null) return false;
		return true;	
	}
	public boolean isFilter___offset___Active(QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn) {
		if (quizzWinnerTeamOptionIn.getOffset() == null) return false;
		return true;	
	}


	public String getStatement(
			QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( quizzWinnerTeamOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(quizzWinnerTeamOptionIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereRankingActive( quizzWinnerTeamOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereRanking", connectionWord + getChunkwhereRanking(quizzWinnerTeamOptionIn, CHUNK_whereRanking) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereRanking","");//replaceOnce
		}
		if (
			 isFilterwhereGameWebPathActive( quizzWinnerTeamOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameWebPath", connectionWord + getChunkwhereGameWebPath(quizzWinnerTeamOptionIn, CHUNK_whereGameWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameWebPath","");//replaceOnce
		}
		if (
			 isFilter___max_result___Active( quizzWinnerTeamOptionIn)			) {
			String connectionWord = " AND ";
			connectionWord = "";
			query = StringUtils.replace (query, "$"+"___max_result___", connectionWord + getChunk___max_result___(quizzWinnerTeamOptionIn, CHUNK____max_result___) ); //replaceOnce
		} else {
			query = StringUtils.replace (query, "$"+"___max_result___","");//replaceOnce
		}
		if (
			 isFilter___offset___Active( quizzWinnerTeamOptionIn)			) {
			String connectionWord = " AND ";
			connectionWord = "";
			query = StringUtils.replace (query, "$"+"___offset___", connectionWord + getChunk___offset___(quizzWinnerTeamOptionIn, CHUNK____offset___) ); //replaceOnce
		} else {
			query = StringUtils.replace (query, "$"+"___offset___","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereRanking (QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameWebPath (QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn, String chunk) {
		return chunk;
	}

	private String getChunk___max_result___ (QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn, String chunk) {
		return chunk;
	}

	private String getChunk___offset___ (QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn, String chunk) {
		return chunk;
	}
	
   private class QuizzWinnerTeamOptionOutListWork implements Work {
		QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn;
        QuizzWinnerTeamOptionOutListWork(
			QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn
			){
				this.quizzWinnerTeamOptionIn = quizzWinnerTeamOptionIn;
		}
		List<QuizzWinnerTeamOptionOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( quizzWinnerTeamOptionIn)) {
            if (quizzWinnerTeamOptionIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzWinnerTeamOptionIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereRankingActive( quizzWinnerTeamOptionIn)) {
            if (quizzWinnerTeamOptionIn.getRanking()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, quizzWinnerTeamOptionIn.getRanking()); 
            }
            index ++;
			}
			if (isFilterwhereGameWebPathActive( quizzWinnerTeamOptionIn)) {
            if (quizzWinnerTeamOptionIn.getGameWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzWinnerTeamOptionIn.getGameWebPath()); 
            }
            index ++;
			}
			if (isFilter___max_result___Active( quizzWinnerTeamOptionIn)) {
            if (quizzWinnerTeamOptionIn.getLimit()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, quizzWinnerTeamOptionIn.getLimit()); 
            }
            index ++;
			}
			if (isFilter___offset___Active( quizzWinnerTeamOptionIn)) {
            if (quizzWinnerTeamOptionIn.getOffset()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, quizzWinnerTeamOptionIn.getOffset()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						quizzWinnerTeamOptionIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, quizzWinnerTeamOptionIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						QuizzWinnerTeamOptionOut quizzWinnerTeamOptionOut = new QuizzWinnerTeamOptionOut();
						quizzWinnerTeamOptionOut.setProgramName(rs.getString("program_name"));
						quizzWinnerTeamOptionOut.setProgramWebPath(rs.getString("program_web_path"));
						quizzWinnerTeamOptionOut.setGameName(rs.getString("game_name"));
						quizzWinnerTeamOptionOut.setGameWebPath(rs.getString("game_web_path"));
						quizzWinnerTeamOptionOut.setTeamName(rs.getString("team_name"));
						quizzWinnerTeamOptionOut.setTeamWebPath(rs.getString("team_web_path"));
						quizzWinnerTeamOptionOut.setRanking(rs.getInt("ranking"));
						quizzWinnerTeamOptionOut.setScore(rs.getBigDecimal("score"));
						list.add(quizzWinnerTeamOptionOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<QuizzWinnerTeamOptionOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}