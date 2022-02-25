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
import com.game.score.sdd.out.quizz.QuizzParticipationOptionOutList;
import com.game.score.sdd.out.quizz.QuizzParticipationOptionOut;
import com.game.score.dao.sdd.face.quizz.QuizzParticipationOptionDaoFace;
import com.game.score.sdd.in.quizz.QuizzParticipationOptionIn;
/**
 *
 * <p>Title: QuizzParticipationOptionRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("quizzParticipationOptionDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class QuizzParticipationOptionRepository implements QuizzParticipationOptionDaoFace {

	public static final String QUERY_NATIVE = "select 									pl.name participant_name, 									pl.web_path participant_web_path, 									g.name game_name, 									g.web_path game_web_path, 									pg.name program_name, 									pg.web_path program_web_path, 									ranking, 									case when ranking = 1 then 1 else RAND(6) end as score 								from 									gs_player pl, 									gs_participant pa, 									gs_program pg, 									( 									 	select g.*, count(*) nb_of_winners from gs_game g, gs_participant_x_game pxg 										where pxg.GS_GAME_ID = g.ID and pxg.ranking = 1 										group by g.ID 									) g, 									gs_team t, 									gs_participant_x_game pxg, 									gs_game_participation_type gpt 								where 									pa.gs_player_id = pl.id and 									pa.gs_program_id = pg.id and 									pxg.gs_team_id = t.id and 									pxg.GS_GAME_ID = g.ID and 									pxg.GS_PARTICIPANT_ID = pa.ID and 									g.gs_program_id = pg.id and 									pxg.gs_game_participation_type_id = gpt.id  								$whereMaxWinners 								$whereProgramWebPath 								$whereGameWebPath 								$whereParticipationTypeWebPath 								$whereParticipantWebPathIn 								$whereRanking 								order by score desc $___max_result___ $___offset___";
	public static final String CHUNK_whereMaxWinners = "g.nb_of_winners <= ?";
	public static final String CHUNK_whereProgramWebPath = "pg.web_path = ?";
	public static final String CHUNK_whereGameWebPath = "g.web_path = ?";
	public static final String CHUNK_whereParticipationTypeWebPath = "gpt.web_path = ?";
	public static final String CHUNK_whereParticipantWebPathIn = "pl.web_path in (?...)";
	public static final String CHUNK_whereRanking = "ranking = ?";
	public static final String CHUNK____max_result___ = "limit ?";
	public static final String CHUNK____offset___ = "offset ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="quizzParticipationOptionCache") 
    public QuizzParticipationOptionOutList execute (
		QuizzParticipationOptionIn quizzParticipationOptionIn
		) {
		QuizzParticipationOptionOutList quizzParticipationOptionOutList = new QuizzParticipationOptionOutList();
		QuizzParticipationOptionOutListWork work = new QuizzParticipationOptionOutListWork (
			quizzParticipationOptionIn
			);
        Session session = getSession();
        session.doWork(work);
		quizzParticipationOptionOutList.setQuizzParticipationOptionOuts (work.getResult());
        return quizzParticipationOptionOutList;
    }


	public boolean isFilterwhereMaxWinnersActive(QuizzParticipationOptionIn quizzParticipationOptionIn) {
		if (quizzParticipationOptionIn.getMaxWinners() == null) return false;
		return true;	
	}
	public boolean isFilterwhereProgramWebPathActive(QuizzParticipationOptionIn quizzParticipationOptionIn) {
		if (quizzParticipationOptionIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameWebPathActive(QuizzParticipationOptionIn quizzParticipationOptionIn) {
		if (quizzParticipationOptionIn.getGameWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereParticipationTypeWebPathActive(QuizzParticipationOptionIn quizzParticipationOptionIn) {
		if (quizzParticipationOptionIn.getParticipationTypeWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereParticipantWebPathInActive(QuizzParticipationOptionIn quizzParticipationOptionIn) {
		if (quizzParticipationOptionIn.getParticipantWebPaths() == null) return false;
		if (quizzParticipationOptionIn.getParticipantWebPaths().size()==0) return false;
		return true;	
	}
	public boolean isFilterwhereRankingActive(QuizzParticipationOptionIn quizzParticipationOptionIn) {
		if (quizzParticipationOptionIn.getRanking() == null) return false;
		return true;	
	}
	public boolean isFilter___max_result___Active(QuizzParticipationOptionIn quizzParticipationOptionIn) {
		if (quizzParticipationOptionIn.getLimit() == null) return false;
		return true;	
	}
	public boolean isFilter___offset___Active(QuizzParticipationOptionIn quizzParticipationOptionIn) {
		if (quizzParticipationOptionIn.getOffset() == null) return false;
		return true;	
	}


	public String getStatement(
			QuizzParticipationOptionIn quizzParticipationOptionIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereMaxWinnersActive( quizzParticipationOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereMaxWinners", connectionWord + getChunkwhereMaxWinners(quizzParticipationOptionIn, CHUNK_whereMaxWinners) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereMaxWinners","");//replaceOnce
		}
		if (
			 isFilterwhereProgramWebPathActive( quizzParticipationOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(quizzParticipationOptionIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameWebPathActive( quizzParticipationOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameWebPath", connectionWord + getChunkwhereGameWebPath(quizzParticipationOptionIn, CHUNK_whereGameWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereParticipationTypeWebPathActive( quizzParticipationOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereParticipationTypeWebPath", connectionWord + getChunkwhereParticipationTypeWebPath(quizzParticipationOptionIn, CHUNK_whereParticipationTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereParticipationTypeWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereParticipantWebPathInActive( quizzParticipationOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereParticipantWebPathIn", connectionWord + getChunkwhereParticipantWebPathIn(quizzParticipationOptionIn, CHUNK_whereParticipantWebPathIn) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereParticipantWebPathIn","");//replaceOnce
		}
		if (
			 isFilterwhereRankingActive( quizzParticipationOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereRanking", connectionWord + getChunkwhereRanking(quizzParticipationOptionIn, CHUNK_whereRanking) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereRanking","");//replaceOnce
		}
		if (
			 isFilter___max_result___Active( quizzParticipationOptionIn)			) {
			String connectionWord = " AND ";
			connectionWord = "";
			query = StringUtils.replace (query, "$"+"___max_result___", connectionWord + getChunk___max_result___(quizzParticipationOptionIn, CHUNK____max_result___) ); //replaceOnce
		} else {
			query = StringUtils.replace (query, "$"+"___max_result___","");//replaceOnce
		}
		if (
			 isFilter___offset___Active( quizzParticipationOptionIn)			) {
			String connectionWord = " AND ";
			connectionWord = "";
			query = StringUtils.replace (query, "$"+"___offset___", connectionWord + getChunk___offset___(quizzParticipationOptionIn, CHUNK____offset___) ); //replaceOnce
		} else {
			query = StringUtils.replace (query, "$"+"___offset___","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereMaxWinners (QuizzParticipationOptionIn quizzParticipationOptionIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereProgramWebPath (QuizzParticipationOptionIn quizzParticipationOptionIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameWebPath (QuizzParticipationOptionIn quizzParticipationOptionIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereParticipationTypeWebPath (QuizzParticipationOptionIn quizzParticipationOptionIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereParticipantWebPathIn (QuizzParticipationOptionIn quizzParticipationOptionIn, String chunk) {
	   StringBuffer inSbparticipantWebPaths = new StringBuffer();
	   for (int i = 0; i < quizzParticipationOptionIn.getParticipantWebPaths().size(); i++) {
	   	  inSbparticipantWebPaths.append("?");
	   	  if (i+1!=quizzParticipationOptionIn.getParticipantWebPaths().size())
	   	  	inSbparticipantWebPaths.append(",");
	   }
	   return StringUtils.replace (chunk, "?...", inSbparticipantWebPaths.toString());//replaceOnce
	}

	private String getChunkwhereRanking (QuizzParticipationOptionIn quizzParticipationOptionIn, String chunk) {
		return chunk;
	}

	private String getChunk___max_result___ (QuizzParticipationOptionIn quizzParticipationOptionIn, String chunk) {
		return chunk;
	}

	private String getChunk___offset___ (QuizzParticipationOptionIn quizzParticipationOptionIn, String chunk) {
		return chunk;
	}
	
   private class QuizzParticipationOptionOutListWork implements Work {
		QuizzParticipationOptionIn quizzParticipationOptionIn;
        QuizzParticipationOptionOutListWork(
			QuizzParticipationOptionIn quizzParticipationOptionIn
			){
				this.quizzParticipationOptionIn = quizzParticipationOptionIn;
		}
		List<QuizzParticipationOptionOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, QuizzParticipationOptionIn quizzParticipationOptionIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereMaxWinnersActive( quizzParticipationOptionIn)) {
            if (quizzParticipationOptionIn.getMaxWinners()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, quizzParticipationOptionIn.getMaxWinners()); 
            }
            index ++;
			}
			if (isFilterwhereProgramWebPathActive( quizzParticipationOptionIn)) {
            if (quizzParticipationOptionIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzParticipationOptionIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameWebPathActive( quizzParticipationOptionIn)) {
            if (quizzParticipationOptionIn.getGameWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzParticipationOptionIn.getGameWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereParticipationTypeWebPathActive( quizzParticipationOptionIn)) {
            if (quizzParticipationOptionIn.getParticipationTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzParticipationOptionIn.getParticipationTypeWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereParticipantWebPathInActive( quizzParticipationOptionIn)) {
            if (quizzParticipationOptionIn.getParticipantWebPaths()==null) {
			   for (String element : quizzParticipationOptionIn.getParticipantWebPaths()) {
			      pstmt.setNull(index, java.sql.Types.VARCHAR);
			      index ++;
			   }
			   //remove extra element
			   index --;
            } else {
			   for (String element : quizzParticipationOptionIn.getParticipantWebPaths()) {
			      pstmt.setString(index, element);
			      index ++;
			   }
			   //remove extra element
			   index --;
            }
            index ++;
			}
			if (isFilterwhereRankingActive( quizzParticipationOptionIn)) {
            if (quizzParticipationOptionIn.getRanking()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, quizzParticipationOptionIn.getRanking()); 
            }
            index ++;
			}
			if (isFilter___max_result___Active( quizzParticipationOptionIn)) {
            if (quizzParticipationOptionIn.getLimit()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, quizzParticipationOptionIn.getLimit()); 
            }
            index ++;
			}
			if (isFilter___offset___Active( quizzParticipationOptionIn)) {
            if (quizzParticipationOptionIn.getOffset()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, quizzParticipationOptionIn.getOffset()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						quizzParticipationOptionIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, quizzParticipationOptionIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						QuizzParticipationOptionOut quizzParticipationOptionOut = new QuizzParticipationOptionOut();
						quizzParticipationOptionOut.setParticipantName(rs.getString("participant_name"));
						quizzParticipationOptionOut.setParticipantWebPath(rs.getString("participant_web_path"));
						quizzParticipationOptionOut.setGameName(rs.getString("game_name"));
						quizzParticipationOptionOut.setGameWebPath(rs.getString("game_web_path"));
						quizzParticipationOptionOut.setProgramName(rs.getString("program_name"));
						quizzParticipationOptionOut.setProgramWebPath(rs.getString("program_web_path"));
						quizzParticipationOptionOut.setRanking(rs.getInt("ranking"));
						quizzParticipationOptionOut.setScore(rs.getBigDecimal("score"));
						list.add(quizzParticipationOptionOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<QuizzParticipationOptionOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}