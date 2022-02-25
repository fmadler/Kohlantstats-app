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
import com.game.score.sdd.out.quizz.QuizzWinnerParticipantOrderFilterMatrixOutList;
import com.game.score.sdd.out.quizz.QuizzWinnerParticipantOrderFilterMatrixOut;
import com.game.score.dao.sdd.face.quizz.QuizzWinnerParticipantOrderFilterMatrixDaoFace;
import com.game.score.sdd.in.quizz.QuizzWinnerParticipantOrderFilterMatrixIn;
/**
 *
 * <p>Title: QuizzWinnerParticipantOrderFilterMatrixRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("quizzWinnerParticipantOrderFilterMatrixDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class QuizzWinnerParticipantOrderFilterMatrixRepository implements QuizzWinnerParticipantOrderFilterMatrixDaoFace {

	public static final String QUERY_NATIVE = "select distinct game_name, game_web_path, program_name, program_web_path from 	( 	select 		g.name game_name, 		g.web_path game_web_path, 		pg.name program_name, 		pg.web_path program_web_path, 		pg.edition_number, 		g.time_position, 		pl.name participant_name, 		pl.web_path participant_web_path  	from 		gs_participant_x_game pxg, 		gs_game g, 		gs_program pg, 		gs_participant p, 		gs_player pl, 		gs_game_participation_type gpt 	where 		pxg.gs_game_id = g.ID and 		pxg.GS_PARTICIPANT_ID = p.ID and 		g.gs_program_id = pg.ID and 		p.GS_PLAYER_ID = pl.ID and 		g.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID and 		gpt.WEB_PATH = 'individuel' and 		pxg.RANKING between 1 and 3 		and g.ID in (select g.ID from gs_participant_x_game pxg, gs_game g 			where pxg.GS_GAME_ID = g.ID and pxg.RANKING < 4 and pxg.RANKING > 0 			group by g.id 			having count(*) between 2 and 3 		) 		$whereProgramWebPath 		$whereGameWebPath 	) xx order by edition_number desc, time_position asc";
	public static final String CHUNK_whereProgramWebPath = "pg.web_path = ?";
	public static final String CHUNK_whereGameWebPath = "g.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="quizzWinnerParticipantOrderFilterMatrixCache") 
    public QuizzWinnerParticipantOrderFilterMatrixOutList execute (
		QuizzWinnerParticipantOrderFilterMatrixIn quizzWinnerParticipantOrderFilterMatrixIn
		) {
		QuizzWinnerParticipantOrderFilterMatrixOutList quizzWinnerParticipantOrderFilterMatrixOutList = new QuizzWinnerParticipantOrderFilterMatrixOutList();
		QuizzWinnerParticipantOrderFilterMatrixOutListWork work = new QuizzWinnerParticipantOrderFilterMatrixOutListWork (
			quizzWinnerParticipantOrderFilterMatrixIn
			);
        Session session = getSession();
        session.doWork(work);
		quizzWinnerParticipantOrderFilterMatrixOutList.setQuizzWinnerParticipantOrderFilterMatrixOuts (work.getResult());
        return quizzWinnerParticipantOrderFilterMatrixOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(QuizzWinnerParticipantOrderFilterMatrixIn quizzWinnerParticipantOrderFilterMatrixIn) {
		if (quizzWinnerParticipantOrderFilterMatrixIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameWebPathActive(QuizzWinnerParticipantOrderFilterMatrixIn quizzWinnerParticipantOrderFilterMatrixIn) {
		if (quizzWinnerParticipantOrderFilterMatrixIn.getGameWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			QuizzWinnerParticipantOrderFilterMatrixIn quizzWinnerParticipantOrderFilterMatrixIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( quizzWinnerParticipantOrderFilterMatrixIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(quizzWinnerParticipantOrderFilterMatrixIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameWebPathActive( quizzWinnerParticipantOrderFilterMatrixIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameWebPath", connectionWord + getChunkwhereGameWebPath(quizzWinnerParticipantOrderFilterMatrixIn, CHUNK_whereGameWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (QuizzWinnerParticipantOrderFilterMatrixIn quizzWinnerParticipantOrderFilterMatrixIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameWebPath (QuizzWinnerParticipantOrderFilterMatrixIn quizzWinnerParticipantOrderFilterMatrixIn, String chunk) {
		return chunk;
	}
	
   private class QuizzWinnerParticipantOrderFilterMatrixOutListWork implements Work {
		QuizzWinnerParticipantOrderFilterMatrixIn quizzWinnerParticipantOrderFilterMatrixIn;
        QuizzWinnerParticipantOrderFilterMatrixOutListWork(
			QuizzWinnerParticipantOrderFilterMatrixIn quizzWinnerParticipantOrderFilterMatrixIn
			){
				this.quizzWinnerParticipantOrderFilterMatrixIn = quizzWinnerParticipantOrderFilterMatrixIn;
		}
		List<QuizzWinnerParticipantOrderFilterMatrixOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, QuizzWinnerParticipantOrderFilterMatrixIn quizzWinnerParticipantOrderFilterMatrixIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( quizzWinnerParticipantOrderFilterMatrixIn)) {
            if (quizzWinnerParticipantOrderFilterMatrixIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzWinnerParticipantOrderFilterMatrixIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameWebPathActive( quizzWinnerParticipantOrderFilterMatrixIn)) {
            if (quizzWinnerParticipantOrderFilterMatrixIn.getGameWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzWinnerParticipantOrderFilterMatrixIn.getGameWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						quizzWinnerParticipantOrderFilterMatrixIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, quizzWinnerParticipantOrderFilterMatrixIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						QuizzWinnerParticipantOrderFilterMatrixOut quizzWinnerParticipantOrderFilterMatrixOut = new QuizzWinnerParticipantOrderFilterMatrixOut();
						quizzWinnerParticipantOrderFilterMatrixOut.setGameName(rs.getString("game_name"));
						quizzWinnerParticipantOrderFilterMatrixOut.setGameWebPath(rs.getString("game_web_path"));
						quizzWinnerParticipantOrderFilterMatrixOut.setProgramName(rs.getString("program_name"));
						quizzWinnerParticipantOrderFilterMatrixOut.setProgramWebPath(rs.getString("program_web_path"));
						list.add(quizzWinnerParticipantOrderFilterMatrixOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<QuizzWinnerParticipantOrderFilterMatrixOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}