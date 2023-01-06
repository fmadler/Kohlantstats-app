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
import com.game.score.sdd.out.distinct.DistinctConcurrentsForParticipantOutList;
import com.game.score.sdd.out.distinct.DistinctConcurrentsForParticipantOut;
import com.game.score.dao.sdd.face.distinct.DistinctConcurrentsForParticipantDaoFace;
import com.game.score.sdd.in.distinct.DistinctConcurrentsForParticipantIn;
/**
 *
 * <p>Title: DistinctConcurrentsForParticipantRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("distinctConcurrentsForParticipantDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class DistinctConcurrentsForParticipantRepository implements DistinctConcurrentsForParticipantDaoFace {

	public static final String QUERY_NATIVE = "SELECT distinct p.name program_name, p.web_path program_web_path, pl.name, pl.web_path FROM gs_participant pt, gs_player pl , gs_program p where pt.GS_PROGRAM_ID = p.ID  and pt.GS_PLAYER_ID = pl.ID and p.ID in ( 	select distinct p.id from gs_program p, gs_participant pt, gs_player pl     where pt.GS_PROGRAM_ID = p.ID  	and pt.GS_PLAYER_ID = pl.ID      and pl.WEB_PATH = ? ) and pl.WEB_PATH != ? ORDER by p.EDITION_NUMBER, pl.name asc";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="distinctConcurrentsForParticipantCache") 
    public DistinctConcurrentsForParticipantOutList execute (
		DistinctConcurrentsForParticipantIn distinctConcurrentsForParticipantIn
		) {
		DistinctConcurrentsForParticipantOutList distinctConcurrentsForParticipantOutList = new DistinctConcurrentsForParticipantOutList();
		DistinctConcurrentsForParticipantOutListWork work = new DistinctConcurrentsForParticipantOutListWork (
			distinctConcurrentsForParticipantIn
			);
        Session session = getSession();
        session.doWork(work);
		distinctConcurrentsForParticipantOutList.setDistinctConcurrentsForParticipantOuts (work.getResult());
        return distinctConcurrentsForParticipantOutList;
    }




	public String getStatement(
			DistinctConcurrentsForParticipantIn distinctConcurrentsForParticipantIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		return query;
	}
	
   private class DistinctConcurrentsForParticipantOutListWork implements Work {
		DistinctConcurrentsForParticipantIn distinctConcurrentsForParticipantIn;
        DistinctConcurrentsForParticipantOutListWork(
			DistinctConcurrentsForParticipantIn distinctConcurrentsForParticipantIn
			){
				this.distinctConcurrentsForParticipantIn = distinctConcurrentsForParticipantIn;
		}
		List<DistinctConcurrentsForParticipantOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, DistinctConcurrentsForParticipantIn distinctConcurrentsForParticipantIn			) throws SQLException {
			int index = 1;
            if (distinctConcurrentsForParticipantIn.getPlayerWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, distinctConcurrentsForParticipantIn.getPlayerWebPath()); 
            }
            index ++;
            if (distinctConcurrentsForParticipantIn.getPlayerWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, distinctConcurrentsForParticipantIn.getPlayerWebPath()); 
            }
            index ++;
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						distinctConcurrentsForParticipantIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, distinctConcurrentsForParticipantIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						DistinctConcurrentsForParticipantOut distinctConcurrentsForParticipantOut = new DistinctConcurrentsForParticipantOut();
						distinctConcurrentsForParticipantOut.setProgramName(rs.getString("program_name"));
						distinctConcurrentsForParticipantOut.setProgramWebPath(rs.getString("program_web_path"));
						distinctConcurrentsForParticipantOut.setName(rs.getString("name"));
						distinctConcurrentsForParticipantOut.setWebPath(rs.getString("web_path"));
						list.add(distinctConcurrentsForParticipantOut);
	        		}	        	}			}
       }

       List<DistinctConcurrentsForParticipantOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}