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
import com.game.score.sdd.out.quizz.QuizzWinnerTeamOrderOptionOutList;
import com.game.score.sdd.out.quizz.QuizzWinnerTeamOrderOptionOut;
import com.game.score.dao.sdd.face.quizz.QuizzWinnerTeamOrderOptionDaoFace;
import com.game.score.sdd.in.quizz.QuizzWinnerTeamOrderOptionIn;
/**
 *
 * <p>Title: QuizzWinnerTeamOrderOptionRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("quizzWinnerTeamOrderOptionDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class QuizzWinnerTeamOrderOptionRepository implements QuizzWinnerTeamOrderOptionDaoFace {

	public static final String QUERY_NATIVE = "select 	pg.name program_name,     pg.web_path program_web_path,     pg.EDITION_NUMBER, 	g.name game_name,     g.web_path game_web_path,     g.TIME_POSITION, 	t.name team_name,     t.web_path team_web_path,     txg.ranking ranking  from gs_team_x_game txg, gs_game g, gs_team t, gs_program pg, gs_game_participation_type gpt where txg.gs_game_id = g.ID and txg.GS_TEAM_ID = t.ID and g.gs_program_id = pg.ID and g.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID and gpt.WEB_PATH = 'collectif' and txg.RANKING between 1 and 3 and g.ID in (select g.ID from gs_team_x_game txg, gs_game g  	where txg.GS_GAME_ID = g.ID and txg.RANKING < 4 and txg.RANKING > 0     group by g.id     having count(*) between 2 and 3  ) $whereProgramWebPath $whereGameWebPath";
	public static final String CHUNK_whereProgramWebPath = "pg.web_path = ?";
	public static final String CHUNK_whereGameWebPath = "g.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="quizzWinnerTeamOrderOptionCache") 
    public QuizzWinnerTeamOrderOptionOutList execute (
		QuizzWinnerTeamOrderOptionIn quizzWinnerTeamOrderOptionIn
		) {
		QuizzWinnerTeamOrderOptionOutList quizzWinnerTeamOrderOptionOutList = new QuizzWinnerTeamOrderOptionOutList();
		QuizzWinnerTeamOrderOptionOutListWork work = new QuizzWinnerTeamOrderOptionOutListWork (
			quizzWinnerTeamOrderOptionIn
			);
        Session session = getSession();
        session.doWork(work);
		quizzWinnerTeamOrderOptionOutList.setQuizzWinnerTeamOrderOptionOuts (work.getResult());
        return quizzWinnerTeamOrderOptionOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(QuizzWinnerTeamOrderOptionIn quizzWinnerTeamOrderOptionIn) {
		if (quizzWinnerTeamOrderOptionIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameWebPathActive(QuizzWinnerTeamOrderOptionIn quizzWinnerTeamOrderOptionIn) {
		if (quizzWinnerTeamOrderOptionIn.getGameWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			QuizzWinnerTeamOrderOptionIn quizzWinnerTeamOrderOptionIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( quizzWinnerTeamOrderOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(quizzWinnerTeamOrderOptionIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameWebPathActive( quizzWinnerTeamOrderOptionIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameWebPath", connectionWord + getChunkwhereGameWebPath(quizzWinnerTeamOrderOptionIn, CHUNK_whereGameWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (QuizzWinnerTeamOrderOptionIn quizzWinnerTeamOrderOptionIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameWebPath (QuizzWinnerTeamOrderOptionIn quizzWinnerTeamOrderOptionIn, String chunk) {
		return chunk;
	}
	
   private class QuizzWinnerTeamOrderOptionOutListWork implements Work {
		QuizzWinnerTeamOrderOptionIn quizzWinnerTeamOrderOptionIn;
        QuizzWinnerTeamOrderOptionOutListWork(
			QuizzWinnerTeamOrderOptionIn quizzWinnerTeamOrderOptionIn
			){
				this.quizzWinnerTeamOrderOptionIn = quizzWinnerTeamOrderOptionIn;
		}
		List<QuizzWinnerTeamOrderOptionOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, QuizzWinnerTeamOrderOptionIn quizzWinnerTeamOrderOptionIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( quizzWinnerTeamOrderOptionIn)) {
            if (quizzWinnerTeamOrderOptionIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzWinnerTeamOrderOptionIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameWebPathActive( quizzWinnerTeamOrderOptionIn)) {
            if (quizzWinnerTeamOrderOptionIn.getGameWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzWinnerTeamOrderOptionIn.getGameWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						quizzWinnerTeamOrderOptionIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, quizzWinnerTeamOrderOptionIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						QuizzWinnerTeamOrderOptionOut quizzWinnerTeamOrderOptionOut = new QuizzWinnerTeamOrderOptionOut();
						quizzWinnerTeamOrderOptionOut.setProgramName(rs.getString("program_name"));
						quizzWinnerTeamOrderOptionOut.setProgramWebPath(rs.getString("program_web_path"));
						quizzWinnerTeamOrderOptionOut.setEditionNumber(rs.getInt("EDITION_NUMBER"));
						quizzWinnerTeamOrderOptionOut.setGameName(rs.getString("game_name"));
						quizzWinnerTeamOrderOptionOut.setGameWebPath(rs.getString("game_web_path"));
						quizzWinnerTeamOrderOptionOut.setTimePosition(rs.getString("TIME_POSITION"));
						quizzWinnerTeamOrderOptionOut.setTeamName(rs.getString("team_name"));
						quizzWinnerTeamOrderOptionOut.setTeamWebPath(rs.getString("team_web_path"));
						quizzWinnerTeamOrderOptionOut.setRanking(rs.getInt("ranking"));
						list.add(quizzWinnerTeamOrderOptionOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<QuizzWinnerTeamOrderOptionOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}