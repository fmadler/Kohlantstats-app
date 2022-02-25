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
import com.game.score.sdd.out.distinct.DistinctProgramsOutList;
import com.game.score.sdd.out.distinct.DistinctProgramsOut;
import com.game.score.dao.sdd.face.distinct.DistinctProgramsDaoFace;
/**
 *
 * <p>Title: DistinctProgramsRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("distinctProgramsDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class DistinctProgramsRepository implements DistinctProgramsDaoFace {

	public static final String QUERY_NATIVE = "SELECT p.edition_number, p.year, p.name, p.web_path, p.TOTAL_TIME_LENGTH, l.COUNTRY, l.COUNTRY_FLAG, l.COUNTRY_WEB_PATH, l.PLACE, l.PLACE_WEB_PATH, count(p.ID) nb_of_participants, winner.name winner_name, winner.web_path winner_web_path FROM gs_program p left outer join  ( 	select 		pl.name name, 		pl.web_path web_path, 		pg.id program_id 	from gs_participant pa, gs_player pl, gs_program pg 	where pa.gs_program_id = pg.id 		and pa.gs_player_id = pl.id 		and pa.final_position = 1 	group by pg.id ) winner on winner.program_id = p.id , gs_location l, gs_participant pa where p.GS_LOCATION_ID = l.ID and pa.GS_PROGRAM_ID = p.ID group by p.edition_number ORDER by edition_number desc";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="distinctProgramsCache") 
    public DistinctProgramsOutList execute (
		) {
		DistinctProgramsOutList distinctProgramsOutList = new DistinctProgramsOutList();
		DistinctProgramsOutListWork work = new DistinctProgramsOutListWork (
			);
        Session session = getSession();
        session.doWork(work);
		distinctProgramsOutList.setDistinctProgramsOuts (work.getResult());
        return distinctProgramsOutList;
    }




	public String getStatement(
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		return query;
	}
	
   private class DistinctProgramsOutListWork implements Work {
        DistinctProgramsOutListWork(
			){
		}
		List<DistinctProgramsOut> list = new ArrayList<>();

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						)
					);
				) {
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						DistinctProgramsOut distinctProgramsOut = new DistinctProgramsOut();
						distinctProgramsOut.setEditionNumber(rs.getInt("edition_number"));
						distinctProgramsOut.setYear(rs.getInt("year"));
						distinctProgramsOut.setName(rs.getString("name"));
						distinctProgramsOut.setWebPath(rs.getString("web_path"));
						distinctProgramsOut.setTotalTimeLength(rs.getInt("TOTAL_TIME_LENGTH"));
						distinctProgramsOut.setCountry(rs.getString("COUNTRY"));
						distinctProgramsOut.setCountryFlag(rs.getString("COUNTRY_FLAG"));
						distinctProgramsOut.setCountryWebPath(rs.getString("COUNTRY_WEB_PATH"));
						distinctProgramsOut.setPlace(rs.getString("PLACE"));
						distinctProgramsOut.setPlaceWebPath(rs.getString("PLACE_WEB_PATH"));
						distinctProgramsOut.setNbOfParticipants(rs.getLong("nb_of_participants"));
						distinctProgramsOut.setWinnerName(rs.getString("winner_name"));
						distinctProgramsOut.setWinnerWebPath(rs.getString("winner_web_path"));
						list.add(distinctProgramsOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<DistinctProgramsOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}