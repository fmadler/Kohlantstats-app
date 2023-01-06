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
import com.game.score.sdd.out.distinct.DistinctParticipantsOutList;
import com.game.score.sdd.out.distinct.DistinctParticipantsOut;
import com.game.score.dao.sdd.face.distinct.DistinctParticipantsDaoFace;
import com.game.score.sdd.in.distinct.DistinctParticipantsIn;
/**
 *
 * <p>Title: DistinctParticipantsRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("distinctParticipantsDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class DistinctParticipantsRepository implements DistinctParticipantsDaoFace {

	public static final String QUERY_NATIVE = "select pg.web_path program_web_path, pa.age, pl.name, pl.web_path, pl.family_name, pl.sex, pl.BIRTH_date, pa.final_position, xx.nb_victories, yy.max_time from  gs_program pg, gs_player pl, gs_participant pa left join ( select GS_PARTICIPANT_ID, count(*) nb_victories from gs_participant_x_game pxg where ranking = 1 group by GS_PARTICIPANT_ID ) xx on xx.GS_PARTICIPANT_ID = pa.id left join ( select GS_PARTICIPANT_ID, max(TO_TIME_UNIT) max_time from GS_PARTICIPANT_TEAM pt group by GS_PARTICIPANT_ID ) yy on yy.GS_PARTICIPANT_ID = pa.id where pa.GS_PLAYER_ID = pl.ID and pa.gs_program_id = pg.id and pg.web_path = ? ORDER by pa.final_position, pl.name asc";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="distinctParticipantsCache") 
    public DistinctParticipantsOutList execute (
		DistinctParticipantsIn distinctParticipantsIn
		) {
		DistinctParticipantsOutList distinctParticipantsOutList = new DistinctParticipantsOutList();
		DistinctParticipantsOutListWork work = new DistinctParticipantsOutListWork (
			distinctParticipantsIn
			);
        Session session = getSession();
        session.doWork(work);
		distinctParticipantsOutList.setDistinctParticipantsOuts (work.getResult());
        return distinctParticipantsOutList;
    }




	public String getStatement(
			DistinctParticipantsIn distinctParticipantsIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		return query;
	}
	
   private class DistinctParticipantsOutListWork implements Work {
		DistinctParticipantsIn distinctParticipantsIn;
        DistinctParticipantsOutListWork(
			DistinctParticipantsIn distinctParticipantsIn
			){
				this.distinctParticipantsIn = distinctParticipantsIn;
		}
		List<DistinctParticipantsOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, DistinctParticipantsIn distinctParticipantsIn			) throws SQLException {
			int index = 1;
            if (distinctParticipantsIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, distinctParticipantsIn.getProgramWebPath()); 
            }
            index ++;
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						distinctParticipantsIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, distinctParticipantsIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						DistinctParticipantsOut distinctParticipantsOut = new DistinctParticipantsOut();
						distinctParticipantsOut.setProgramWebPath(rs.getString("program_web_path"));
						distinctParticipantsOut.setAge(rs.getInt("age"));
						distinctParticipantsOut.setName(rs.getString("name"));
						distinctParticipantsOut.setWebPath(rs.getString("web_path"));
						distinctParticipantsOut.setFamilyName(rs.getString("family_name"));
						distinctParticipantsOut.setSex(rs.getString("sex"));
						distinctParticipantsOut.setBirthDate(rs.getDate("BIRTH_date"));
						distinctParticipantsOut.setFinalPosition(rs.getInt("final_position"));
						distinctParticipantsOut.setNbVictories(rs.getLong("nb_victories"));
						distinctParticipantsOut.setMaxTime(rs.getInt("max_time"));
						list.add(distinctParticipantsOut);
	        		}	        	}			}
       }

       List<DistinctParticipantsOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}