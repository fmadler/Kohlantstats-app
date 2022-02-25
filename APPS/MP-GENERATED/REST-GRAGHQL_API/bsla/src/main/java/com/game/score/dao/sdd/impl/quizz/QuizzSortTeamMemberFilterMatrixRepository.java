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
import com.game.score.sdd.out.quizz.QuizzSortTeamMemberFilterMatrixOutList;
import com.game.score.sdd.out.quizz.QuizzSortTeamMemberFilterMatrixOut;
import com.game.score.dao.sdd.face.quizz.QuizzSortTeamMemberFilterMatrixDaoFace;
import com.game.score.sdd.in.quizz.QuizzSortTeamMemberFilterMatrixIn;
/**
 *
 * <p>Title: QuizzSortTeamMemberFilterMatrixRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("quizzSortTeamMemberFilterMatrixDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class QuizzSortTeamMemberFilterMatrixRepository implements QuizzSortTeamMemberFilterMatrixDaoFace {

	public static final String QUERY_NATIVE = "select distinct 	program_name, 	program_web_path, 	game_name,     game_web_path from ( select 	pg.name program_name,     pg.web_path program_web_path,     pg.EDITION_NUMBER, 	g.name game_name,     g.web_path game_web_path,     g.TIME_POSITION, 	t.name team_name,     t.web_path team_web_path,     pl.name participant_name,     pl.web_path participant_web_path,     gat.WEB_PATH game_activity_type_web_path  from 	gs_participant_x_game pxg, 	gs_game g, 	gs_team t, 	gs_program pg, 	gs_game_participation_type gpt, 	gs_game_activity_type gat, 	gs_participant pa, 	gs_player pl where 	pxg.gs_game_id = g.ID and 	pxg.gs_team_id = t.ID and 	pxg.GS_PARTICIPANT_ID = pa.ID and 	pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID and 	pa.GS_PLAYER_ID = pl.ID and 	g.gs_program_id = pg.ID and 	g.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID and 	gpt.WEB_PATH = 'collectif' $whereProgramWebPath $whereGameWebPath ) xx order by edition_number desc, time_position asc";
	public static final String CHUNK_whereProgramWebPath = "pg.web_path = ?";
	public static final String CHUNK_whereGameWebPath = "g.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="quizzSortTeamMemberFilterMatrixCache") 
    public QuizzSortTeamMemberFilterMatrixOutList execute (
		QuizzSortTeamMemberFilterMatrixIn quizzSortTeamMemberFilterMatrixIn
		) {
		QuizzSortTeamMemberFilterMatrixOutList quizzSortTeamMemberFilterMatrixOutList = new QuizzSortTeamMemberFilterMatrixOutList();
		QuizzSortTeamMemberFilterMatrixOutListWork work = new QuizzSortTeamMemberFilterMatrixOutListWork (
			quizzSortTeamMemberFilterMatrixIn
			);
        Session session = getSession();
        session.doWork(work);
		quizzSortTeamMemberFilterMatrixOutList.setQuizzSortTeamMemberFilterMatrixOuts (work.getResult());
        return quizzSortTeamMemberFilterMatrixOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(QuizzSortTeamMemberFilterMatrixIn quizzSortTeamMemberFilterMatrixIn) {
		if (quizzSortTeamMemberFilterMatrixIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameWebPathActive(QuizzSortTeamMemberFilterMatrixIn quizzSortTeamMemberFilterMatrixIn) {
		if (quizzSortTeamMemberFilterMatrixIn.getGameWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			QuizzSortTeamMemberFilterMatrixIn quizzSortTeamMemberFilterMatrixIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( quizzSortTeamMemberFilterMatrixIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(quizzSortTeamMemberFilterMatrixIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameWebPathActive( quizzSortTeamMemberFilterMatrixIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameWebPath", connectionWord + getChunkwhereGameWebPath(quizzSortTeamMemberFilterMatrixIn, CHUNK_whereGameWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (QuizzSortTeamMemberFilterMatrixIn quizzSortTeamMemberFilterMatrixIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameWebPath (QuizzSortTeamMemberFilterMatrixIn quizzSortTeamMemberFilterMatrixIn, String chunk) {
		return chunk;
	}
	
   private class QuizzSortTeamMemberFilterMatrixOutListWork implements Work {
		QuizzSortTeamMemberFilterMatrixIn quizzSortTeamMemberFilterMatrixIn;
        QuizzSortTeamMemberFilterMatrixOutListWork(
			QuizzSortTeamMemberFilterMatrixIn quizzSortTeamMemberFilterMatrixIn
			){
				this.quizzSortTeamMemberFilterMatrixIn = quizzSortTeamMemberFilterMatrixIn;
		}
		List<QuizzSortTeamMemberFilterMatrixOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, QuizzSortTeamMemberFilterMatrixIn quizzSortTeamMemberFilterMatrixIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( quizzSortTeamMemberFilterMatrixIn)) {
            if (quizzSortTeamMemberFilterMatrixIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzSortTeamMemberFilterMatrixIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameWebPathActive( quizzSortTeamMemberFilterMatrixIn)) {
            if (quizzSortTeamMemberFilterMatrixIn.getGameWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, quizzSortTeamMemberFilterMatrixIn.getGameWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						quizzSortTeamMemberFilterMatrixIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, quizzSortTeamMemberFilterMatrixIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						QuizzSortTeamMemberFilterMatrixOut quizzSortTeamMemberFilterMatrixOut = new QuizzSortTeamMemberFilterMatrixOut();
						quizzSortTeamMemberFilterMatrixOut.setProgramName(rs.getString("program_name"));
						quizzSortTeamMemberFilterMatrixOut.setProgramWebPath(rs.getString("program_web_path"));
						quizzSortTeamMemberFilterMatrixOut.setGameName(rs.getString("game_name"));
						quizzSortTeamMemberFilterMatrixOut.setGameWebPath(rs.getString("game_web_path"));
						list.add(quizzSortTeamMemberFilterMatrixOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<QuizzSortTeamMemberFilterMatrixOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}