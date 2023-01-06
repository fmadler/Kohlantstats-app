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
package com.game.score.dao.sdd.impl.info;



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
import com.game.score.sdd.out.info.ProgramInfoOutList;
import com.game.score.sdd.out.info.ProgramInfoOut;
import com.game.score.dao.sdd.face.info.ProgramInfoDaoFace;
import com.game.score.sdd.in.info.ProgramInfoIn;
/**
 *
 * <p>Title: ProgramInfoRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("programInfoDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class ProgramInfoRepository implements ProgramInfoDaoFace {

	public static final String QUERY_NATIVE = "select p.name, p.web_path, p.year, 	p.EDITION_NUMBER EDITION_NUMBER,     p.TOTAL_TIME_LENGTH,     l.COUNTRY,     l.COUNTRY_FLAG,     l.COUNTRY_WEB_PATH,     l.PLACE,     l.PLACE_WEB_PATH,     l.LATITUDE,     l.LONGITUDE,     winner.name winner_name,     winner.WEB_PATH winner_web_path,     participants.nb nb_of_participants,     games.nb nb_of_games  from gs_location l, gs_program p left outer join  ( 	select 		pl.name name, 		pl.web_path web_path, 		pg.id program_id 	from gs_participant pa, gs_player pl, gs_program pg 	where pa.gs_program_id = pg.id 		and pa.gs_player_id = pl.id 		and pa.final_position = 1 	group by pg.id ) winner on winner.program_id = p.id, ( 	select count(*) nb, pg.WEB_PATH program_web_path from gs_participant pa, gs_program pg 	where pa.GS_PROGRAM_ID = pg.ID 	group by pg.web_path ) participants, ( 	select count(*) nb, pg.WEB_PATH program_web_path from gs_game g, gs_program pg 	where g.GS_PROGRAM_ID = pg.ID 	group by pg.web_path ) games where 	p.GS_LOCATION_ID = l.ID and     p.web_path = participants.program_web_path and     p.web_path = games.program_web_path $whereProgramWebPath ORDER by edition_number asc";
	public static final String CHUNK_whereProgramWebPath = "p.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="programInfoCache") 
    public ProgramInfoOutList execute (
		ProgramInfoIn programInfoIn
		) {
		ProgramInfoOutList programInfoOutList = new ProgramInfoOutList();
		ProgramInfoOutListWork work = new ProgramInfoOutListWork (
			programInfoIn
			);
        Session session = getSession();
        session.doWork(work);
		programInfoOutList.setProgramInfoOuts (work.getResult());
        return programInfoOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(ProgramInfoIn programInfoIn) {
		if (programInfoIn.getProgramWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			ProgramInfoIn programInfoIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( programInfoIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(programInfoIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (ProgramInfoIn programInfoIn, String chunk) {
		return chunk;
	}
	
   private class ProgramInfoOutListWork implements Work {
		ProgramInfoIn programInfoIn;
        ProgramInfoOutListWork(
			ProgramInfoIn programInfoIn
			){
				this.programInfoIn = programInfoIn;
		}
		List<ProgramInfoOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, ProgramInfoIn programInfoIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( programInfoIn)) {
            if (programInfoIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, programInfoIn.getProgramWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						programInfoIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, programInfoIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						ProgramInfoOut programInfoOut = new ProgramInfoOut();
						programInfoOut.setName(rs.getString("name"));
						programInfoOut.setWebPath(rs.getString("web_path"));
						programInfoOut.setYear(rs.getInt("year"));
						programInfoOut.setEditionNumber(rs.getInt("EDITION_NUMBER"));
						programInfoOut.setTotalTimeLength(rs.getInt("TOTAL_TIME_LENGTH"));
						programInfoOut.setCountry(rs.getString("COUNTRY"));
						programInfoOut.setCountryFlag(rs.getString("COUNTRY_FLAG"));
						programInfoOut.setCountryWebPath(rs.getString("COUNTRY_WEB_PATH"));
						programInfoOut.setPlace(rs.getString("PLACE"));
						programInfoOut.setPlaceWebPath(rs.getString("PLACE_WEB_PATH"));
						programInfoOut.setLatitude(rs.getBigDecimal("LATITUDE"));
						programInfoOut.setLongitude(rs.getBigDecimal("LONGITUDE"));
						programInfoOut.setWinnerName(rs.getString("winner_name"));
						programInfoOut.setWinnerWebPath(rs.getString("winner_web_path"));
						programInfoOut.setNbOfParticipants(rs.getLong("nb_of_participants"));
						programInfoOut.setNbOfGames(rs.getLong("nb_of_games"));
						list.add(programInfoOut);
	        		}	        	}			}
       }

       List<ProgramInfoOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}