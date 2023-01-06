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
import com.game.score.sdd.out.quizz.QuizzSortTeamMemberOptionOutList;
import com.game.score.sdd.out.quizz.QuizzSortTeamMemberOptionOut;
import com.game.score.dao.sdd.face.quizz.QuizzSortTeamMemberOptionDaoFace;
import com.game.score.sdd.in.quizz.QuizzSortTeamMemberOptionIn;
/**
 *
 * <p>Title: QuizzSortTeamMemberOptionRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("quizzSortTeamMemberOptionDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class QuizzSortTeamMemberOptionRepository implements QuizzSortTeamMemberOptionDaoFace {

	public static final String QUERY_NATIVE = "select 	pg.name program_name,     pg.web_path program_web_path,     pg.EDITION_NUMBER, 	g.name game_name,     g.web_path game_web_path,     g.TIME_POSITION, 	t.name team_name,     t.web_path team_web_path,     pl.name participant_name,     pl.web_path participant_web_path,     gat.WEB_PATH game_activity_type_web_path  from 	gs_participant_x_game pxg, 	gs_game g, 	gs_team t, 	gs_program pg, 	gs_game_participation_type gpt, 	gs_game_activity_type gat, 	gs_participant pa, 	gs_player pl where 	pxg.gs_game_id = g.ID and 	pxg.gs_team_id = t.ID and 	pxg.GS_PARTICIPANT_ID = pa.ID and 	pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID and 	pa.GS_PLAYER_ID = pl.ID and 	g.gs_program_id = pg.ID and 	g.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID and 	gpt.WEB_PATH = 'collectif' $whereProgramWebPath $whereGameWebPath $whereTeamWebPath $whereParticipantWebPath";
	public static final String CHUNK_whereProgramWebPath = "pg.web_path = ?";
	public static final String CHUNK_whereGameWebPath = "g.web_path = ?";
	public static final String CHUNK_whereTeamWebPath = "t.web_path = ?";
	public static final String CHUNK_whereParticipantWebPath = "pl.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="quizzSortTeamMemberOptionCache") 
    public QuizzSortTeamMemberOptionOutList execute (
		QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn
		) {
		QuizzSortTeamMemberOptionOutList quizzSortTeamMemberOptionOutList = new QuizzSortTeamMemberOptionOutList();
		QuizzSortTeamMemberOptionOutListWork work = new QuizzSortTeamMemberOptionOutListWork (
			quizzSortTeamMemberOptionIn
			);
        Session session = getSession();
        session.doWork(work);
		quizzSortTeamMemberOptionOutList.setQuizzSortTeamMemberOptionOuts (work.getResult());
        return quizzSortTeamMemberOptionOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn) {
		if (quizzSortTeamMemberOptionIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameWebPathActive(QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn) {
		if (quizzSortTeamMemberOptionIn.getGameWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereTeamWebPathActive(QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn) {
		if (quizzSortTeamMemberOptionIn.getTeamWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereParticipantWebPathActive(QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn) {
		if (quizzSortTeamMemberOptionIn.getParticipantWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( quizzSortTeamMemberOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(quizzSortTeamMemberOptionIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameWebPathActive( quizzSortTeamMemberOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameWebPath", connectionWord + getChunkwhereGameWebPath(quizzSortTeamMemberOptionIn, CHUNK_whereGameWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereTeamWebPathActive( quizzSortTeamMemberOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereTeamWebPath", connectionWord + getChunkwhereTeamWebPath(quizzSortTeamMemberOptionIn, CHUNK_whereTeamWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereTeamWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereParticipantWebPathActive( quizzSortTeamMemberOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereParticipantWebPath", connectionWord + getChunkwhereParticipantWebPath(quizzSortTeamMemberOptionIn, CHUNK_whereParticipantWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereParticipantWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameWebPath (QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereTeamWebPath (QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereParticipantWebPath (QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn, String chunk) {
		return chunk;
	}
	
   private class QuizzSortTeamMemberOptionOutListWork implements Work {
		QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn;
        QuizzSortTeamMemberOptionOutListWork(
			QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn
			){
				this.quizzSortTeamMemberOptionIn = quizzSortTeamMemberOptionIn;
		}
		List<QuizzSortTeamMemberOptionOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, QuizzSortTeamMemberOptionIn quizzSortTeamMemberOptionIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( quizzSortTeamMemberOptionIn)) {
            if (quizzSortTeamMemberOptionIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzSortTeamMemberOptionIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameWebPathActive( quizzSortTeamMemberOptionIn)) {
            if (quizzSortTeamMemberOptionIn.getGameWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzSortTeamMemberOptionIn.getGameWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereTeamWebPathActive( quizzSortTeamMemberOptionIn)) {
            if (quizzSortTeamMemberOptionIn.getTeamWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzSortTeamMemberOptionIn.getTeamWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereParticipantWebPathActive( quizzSortTeamMemberOptionIn)) {
            if (quizzSortTeamMemberOptionIn.getParticipantWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzSortTeamMemberOptionIn.getParticipantWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						quizzSortTeamMemberOptionIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, quizzSortTeamMemberOptionIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						QuizzSortTeamMemberOptionOut quizzSortTeamMemberOptionOut = new QuizzSortTeamMemberOptionOut();
						quizzSortTeamMemberOptionOut.setProgramName(rs.getString("program_name"));
						quizzSortTeamMemberOptionOut.setProgramWebPath(rs.getString("program_web_path"));
						quizzSortTeamMemberOptionOut.setEditionNumber(rs.getInt("EDITION_NUMBER"));
						quizzSortTeamMemberOptionOut.setGameName(rs.getString("game_name"));
						quizzSortTeamMemberOptionOut.setGameWebPath(rs.getString("game_web_path"));
						quizzSortTeamMemberOptionOut.setTimePosition(rs.getString("TIME_POSITION"));
						quizzSortTeamMemberOptionOut.setTeamName(rs.getString("team_name"));
						quizzSortTeamMemberOptionOut.setTeamWebPath(rs.getString("team_web_path"));
						quizzSortTeamMemberOptionOut.setParticipantName(rs.getString("participant_name"));
						quizzSortTeamMemberOptionOut.setParticipantWebPath(rs.getString("participant_web_path"));
						quizzSortTeamMemberOptionOut.setGameActivityTypeWebPath(rs.getString("game_activity_type_web_path"));
						list.add(quizzSortTeamMemberOptionOut);
	        		}	        	}			}
       }

       List<QuizzSortTeamMemberOptionOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}