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
package com.game.score.dao.sdd.impl.timeline;



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
import com.game.score.sdd.out.timeline.ScoreTimelineOutList;
import com.game.score.sdd.out.timeline.ScoreTimelineOut;
import com.game.score.dao.sdd.face.timeline.ScoreTimelineDaoFace;
import com.game.score.sdd.in.timeline.ScoreTimelineIn;
/**
 *
 * <p>Title: ScoreTimelineRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("scoreTimelineDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class ScoreTimelineRepository implements ScoreTimelineDaoFace {

	public static final String QUERY_NATIVE = "select         dw.FULL_WEB_PATH,         dw.ENTITY_WEB_PATH,         ENTITY_TYPE_WEB_PATH,         dw.CONTEXT_WEB_PATH,         CONTEXT_TYPE_WEB_PATH,         DAY,         SCORE,         LONGEVITY,         GAME_SCORE_1,         GAME_SCORE_2     from dw_timeline_score dw, v_timeline_abstract v     where dw.ENTITY_WEB_PATH = v.ENTITY_WEB_PATH     	and dw.CONTEXT_WEB_PATH = v.CONTEXT_WEB_PATH        $whereProgramWebPath        $wherePlayerWebPathIn        $wherePlayerWebPath        $whereDay        $whereRankingLeq     order by dw.context_web_path, v.ranking, dw.entity_web_path, day asc";
	public static final String CHUNK_whereProgramWebPath = "dw.CONTEXT_WEB_PATH = ? and dw.CONTEXT_TYPE_WEB_PATH='programme'";
	public static final String CHUNK_wherePlayerWebPathIn = "dw.ENTITY_WEB_PATH in (?...) and dw.ENTITY_TYPE_WEB_PATH='player'";
	public static final String CHUNK_wherePlayerWebPath = "dw.ENTITY_WEB_PATH = ? and dw.ENTITY_TYPE_WEB_PATH='player'";
	public static final String CHUNK_whereDay = "dw.day = ?";
	public static final String CHUNK_whereRankingLeq = "v.ranking <= ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="scoreTimelineCache") 
    public ScoreTimelineOutList execute (
		ScoreTimelineIn scoreTimelineIn
		) {
		ScoreTimelineOutList scoreTimelineOutList = new ScoreTimelineOutList();
		ScoreTimelineOutListWork work = new ScoreTimelineOutListWork (
			scoreTimelineIn
			);
        Session session = getSession();
        session.doWork(work);
		scoreTimelineOutList.setScoreTimelineOuts (work.getResult());
        return scoreTimelineOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(ScoreTimelineIn scoreTimelineIn) {
		if (scoreTimelineIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwherePlayerWebPathInActive(ScoreTimelineIn scoreTimelineIn) {
		if (scoreTimelineIn.getPlayerWebPaths() == null) return false;
		if (scoreTimelineIn.getPlayerWebPaths().size()==0) return false;
		return true;	
	}
	public boolean isFilterwherePlayerWebPathActive(ScoreTimelineIn scoreTimelineIn) {
		if (scoreTimelineIn.getPlayerWebPath() == null) return false;
		if (scoreTimelineIn.getPlayerWebPath().size()==0) return false;
		return true;	
	}
	public boolean isFilterwhereDayActive(ScoreTimelineIn scoreTimelineIn) {
		if (scoreTimelineIn.getDay() == null) return false;
		return true;	
	}
	public boolean isFilterwhereRankingLeqActive(ScoreTimelineIn scoreTimelineIn) {
		if (scoreTimelineIn.getRankingLessThanEqualTo() == null) return false;
		return true;	
	}


	public String getStatement(
			ScoreTimelineIn scoreTimelineIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( scoreTimelineIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(scoreTimelineIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwherePlayerWebPathInActive( scoreTimelineIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"wherePlayerWebPathIn", connectionWord + getChunkwherePlayerWebPathIn(scoreTimelineIn, CHUNK_wherePlayerWebPathIn) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"wherePlayerWebPathIn","");//replaceOnce
		}
		if (
			 isFilterwherePlayerWebPathActive( scoreTimelineIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"wherePlayerWebPath", connectionWord + getChunkwherePlayerWebPath(scoreTimelineIn, CHUNK_wherePlayerWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"wherePlayerWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereDayActive( scoreTimelineIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereDay", connectionWord + getChunkwhereDay(scoreTimelineIn, CHUNK_whereDay) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereDay","");//replaceOnce
		}
		if (
			 isFilterwhereRankingLeqActive( scoreTimelineIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereRankingLeq", connectionWord + getChunkwhereRankingLeq(scoreTimelineIn, CHUNK_whereRankingLeq) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereRankingLeq","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (ScoreTimelineIn scoreTimelineIn, String chunk) {
		return chunk;
	}

	private String getChunkwherePlayerWebPathIn (ScoreTimelineIn scoreTimelineIn, String chunk) {
	   StringBuffer inSbplayerWebPaths = new StringBuffer();
	   for (int i = 0; i < scoreTimelineIn.getPlayerWebPaths().size(); i++) {
	   	  inSbplayerWebPaths.append("?");
	   	  if (i+1!=scoreTimelineIn.getPlayerWebPaths().size())
	   	  	inSbplayerWebPaths.append(",");
	   }
	   return StringUtils.replace (chunk, "?...", inSbplayerWebPaths.toString());//replaceOnce
	}

	private String getChunkwherePlayerWebPath (ScoreTimelineIn scoreTimelineIn, String chunk) {
	   StringBuffer inSbplayerWebPath = new StringBuffer();
	   for (int i = 0; i < scoreTimelineIn.getPlayerWebPath().size(); i++) {
	   	  inSbplayerWebPath.append("?");
	   	  if (i+1!=scoreTimelineIn.getPlayerWebPath().size())
	   	  	inSbplayerWebPath.append(",");
	   }
	   return StringUtils.replace (chunk, "?...", inSbplayerWebPath.toString());//replaceOnce
	}

	private String getChunkwhereDay (ScoreTimelineIn scoreTimelineIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereRankingLeq (ScoreTimelineIn scoreTimelineIn, String chunk) {
		return chunk;
	}
	
   private class ScoreTimelineOutListWork implements Work {
		ScoreTimelineIn scoreTimelineIn;
        ScoreTimelineOutListWork(
			ScoreTimelineIn scoreTimelineIn
			){
				this.scoreTimelineIn = scoreTimelineIn;
		}
		List<ScoreTimelineOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, ScoreTimelineIn scoreTimelineIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( scoreTimelineIn)) {
            if (scoreTimelineIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, scoreTimelineIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwherePlayerWebPathInActive( scoreTimelineIn)) {
            if (scoreTimelineIn.getPlayerWebPaths()==null) {
			   for (String element : scoreTimelineIn.getPlayerWebPaths()) {
			      pstmt.setNull(index, java.sql.Types.VARCHAR);
			      index ++;
			   }
			   //remove extra element
			   index --;
            } else {
			   for (String element : scoreTimelineIn.getPlayerWebPaths()) {
			      pstmt.setString(index, element);
			      index ++;
			   }
			   //remove extra element
			   index --;
            }
            index ++;
			}
			if (isFilterwherePlayerWebPathActive( scoreTimelineIn)) {
            if (scoreTimelineIn.getPlayerWebPath()==null) {
			   for (String element : scoreTimelineIn.getPlayerWebPath()) {
			      pstmt.setNull(index, java.sql.Types.VARCHAR);
			      index ++;
			   }
			   //remove extra element
			   index --;
            } else {
			   for (String element : scoreTimelineIn.getPlayerWebPath()) {
			      pstmt.setString(index, element);
			      index ++;
			   }
			   //remove extra element
			   index --;
            }
            index ++;
			}
			if (isFilterwhereDayActive( scoreTimelineIn)) {
            if (scoreTimelineIn.getDay()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, scoreTimelineIn.getDay()); 
            }
            index ++;
			}
			if (isFilterwhereRankingLeqActive( scoreTimelineIn)) {
            if (scoreTimelineIn.getRankingLessThanEqualTo()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, scoreTimelineIn.getRankingLessThanEqualTo()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						scoreTimelineIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, scoreTimelineIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						ScoreTimelineOut scoreTimelineOut = new ScoreTimelineOut();
						scoreTimelineOut.setFullWebPath(rs.getString("FULL_WEB_PATH"));
						scoreTimelineOut.setEntityWebPath(rs.getString("ENTITY_WEB_PATH"));
						scoreTimelineOut.setEntityTypeWebPath(rs.getString("ENTITY_TYPE_WEB_PATH"));
						scoreTimelineOut.setContextWebPath(rs.getString("CONTEXT_WEB_PATH"));
						scoreTimelineOut.setContextTypeWebPath(rs.getString("CONTEXT_TYPE_WEB_PATH"));
						scoreTimelineOut.setDay(rs.getInt("DAY"));
						scoreTimelineOut.setScore(rs.getBigDecimal("SCORE"));
						scoreTimelineOut.setLongevity(rs.getBigDecimal("LONGEVITY"));
						scoreTimelineOut.setGameScore1(rs.getBigDecimal("GAME_SCORE_1"));
						scoreTimelineOut.setGameScore2(rs.getBigDecimal("GAME_SCORE_2"));
						list.add(scoreTimelineOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<ScoreTimelineOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}