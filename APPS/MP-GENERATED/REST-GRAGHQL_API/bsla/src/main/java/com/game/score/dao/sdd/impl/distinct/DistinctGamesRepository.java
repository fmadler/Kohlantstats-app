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
package com.game.score.dao.sdd.impl.distinct;



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
import com.game.score.sdd.out.distinct.DistinctGamesOutList;
import com.game.score.sdd.out.distinct.DistinctGamesOut;
import com.game.score.dao.sdd.face.distinct.DistinctGamesDaoFace;
import com.game.score.sdd.in.distinct.DistinctGamesIn;
/**
 *
 * <p>Title: DistinctGamesRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("distinctGamesDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class DistinctGamesRepository implements DistinctGamesDaoFace {

	public static final String QUERY_NATIVE = "select distinct	 	g.name name, 	g.web_path WEB_PATH, 	g.TIME_POSITION, 	g.TIME_UNIT_INDEX, 	g.PROGRAM_INDEX, 	gt.name game_type_name, 	gt.web_path game_type_web_path, 	gst.name game_stake_type_name, 	gst.web_path game_stake_type_web_path, 	p.name program_name, 	p.web_path program_web_path from gs_game g, gs_participant_x_game pxg, gs_game_type gt, gs_game_stake_type gst, gs_program p, gs_participant pa where 	pxg.GS_GAME_ID = g.ID and 	pxg.GS_PARTICIPANT_ID = pa.ID and 	pa.GS_PROGRAM_ID = p.ID and 	g.GS_GAME_TYPE_ID = gt.id and  	g.GS_GAME_STAKE_TYPE_ID = gst.ID 	$whereProgramWebPath 	$whereNotProgramWebPath 	$whereGameTypeWebPath ORDER by p.edition_number, g.PROGRAM_INDEX asc";
	public static final String CHUNK_whereProgramWebPath = "p.web_path = ?";
	public static final String CHUNK_whereNotProgramWebPath = "p.web_path != ?";
	public static final String CHUNK_whereGameTypeWebPath = "gt.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="distinctGamesCache") 
    public DistinctGamesOutList execute (
		DistinctGamesIn distinctGamesIn
		) {
		DistinctGamesOutList distinctGamesOutList = new DistinctGamesOutList();
		DistinctGamesOutListWork work = new DistinctGamesOutListWork (
			distinctGamesIn
			);
        Session session = getSession();
        session.doWork(work);
		distinctGamesOutList.setDistinctGamesOuts (work.getResult());
        return distinctGamesOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(DistinctGamesIn distinctGamesIn) {
		if (distinctGamesIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereNotProgramWebPathActive(DistinctGamesIn distinctGamesIn) {
		if (distinctGamesIn.getNotProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameTypeWebPathActive(DistinctGamesIn distinctGamesIn) {
		if (distinctGamesIn.getGameTypeWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			DistinctGamesIn distinctGamesIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( distinctGamesIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(distinctGamesIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereNotProgramWebPathActive( distinctGamesIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereNotProgramWebPath", connectionWord + getChunkwhereNotProgramWebPath(distinctGamesIn, CHUNK_whereNotProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereNotProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameTypeWebPathActive( distinctGamesIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameTypeWebPath", connectionWord + getChunkwhereGameTypeWebPath(distinctGamesIn, CHUNK_whereGameTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameTypeWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (DistinctGamesIn distinctGamesIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereNotProgramWebPath (DistinctGamesIn distinctGamesIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameTypeWebPath (DistinctGamesIn distinctGamesIn, String chunk) {
		return chunk;
	}
	
   private class DistinctGamesOutListWork implements Work {
		DistinctGamesIn distinctGamesIn;
        DistinctGamesOutListWork(
			DistinctGamesIn distinctGamesIn
			){
				this.distinctGamesIn = distinctGamesIn;
		}
		List<DistinctGamesOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, DistinctGamesIn distinctGamesIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( distinctGamesIn)) {
            if (distinctGamesIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, distinctGamesIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereNotProgramWebPathActive( distinctGamesIn)) {
            if (distinctGamesIn.getNotProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, distinctGamesIn.getNotProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameTypeWebPathActive( distinctGamesIn)) {
            if (distinctGamesIn.getGameTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, distinctGamesIn.getGameTypeWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						distinctGamesIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, distinctGamesIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						DistinctGamesOut distinctGamesOut = new DistinctGamesOut();
						distinctGamesOut.setName(rs.getString("name"));
						distinctGamesOut.setWebPath(rs.getString("WEB_PATH"));
						distinctGamesOut.setTimePosition(rs.getString("TIME_POSITION"));
						distinctGamesOut.setTimeUnitIndex(rs.getInt("TIME_UNIT_INDEX"));
						distinctGamesOut.setProgramIndex(rs.getInt("PROGRAM_INDEX"));
						distinctGamesOut.setGameTypeName(rs.getString("game_type_name"));
						distinctGamesOut.setGameTypeWebPath(rs.getString("game_type_web_path"));
						distinctGamesOut.setGameStakeTypeName(rs.getString("game_stake_type_name"));
						distinctGamesOut.setGameStakeTypeWebPath(rs.getString("game_stake_type_web_path"));
						distinctGamesOut.setProgramName(rs.getString("program_name"));
						distinctGamesOut.setProgramWebPath(rs.getString("program_web_path"));
						list.add(distinctGamesOut);
	        		}	        	}			}
       }

       List<DistinctGamesOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}