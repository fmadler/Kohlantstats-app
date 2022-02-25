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
import com.game.score.sdd.out.distinct.DistinctTeamsOutList;
import com.game.score.sdd.out.distinct.DistinctTeamsOut;
import com.game.score.dao.sdd.face.distinct.DistinctTeamsDaoFace;
import com.game.score.sdd.in.distinct.DistinctTeamsIn;
/**
 *
 * <p>Title: DistinctTeamsRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("distinctTeamsDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class DistinctTeamsRepository implements DistinctTeamsDaoFace {

	public static final String QUERY_NATIVE = "SELECT distinct t.name, t.web_path      FROM gs_team t, gs_program p      where t.GS_PROGRAM_ID = p.ID      and p.web_path = ?      ORDER by t.name asc";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="distinctTeamsCache") 
    public DistinctTeamsOutList execute (
		DistinctTeamsIn distinctTeamsIn
		) {
		DistinctTeamsOutList distinctTeamsOutList = new DistinctTeamsOutList();
		DistinctTeamsOutListWork work = new DistinctTeamsOutListWork (
			distinctTeamsIn
			);
        Session session = getSession();
        session.doWork(work);
		distinctTeamsOutList.setDistinctTeamsOuts (work.getResult());
        return distinctTeamsOutList;
    }




	public String getStatement(
			DistinctTeamsIn distinctTeamsIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		return query;
	}
	
   private class DistinctTeamsOutListWork implements Work {
		DistinctTeamsIn distinctTeamsIn;
        DistinctTeamsOutListWork(
			DistinctTeamsIn distinctTeamsIn
			){
				this.distinctTeamsIn = distinctTeamsIn;
		}
		List<DistinctTeamsOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, DistinctTeamsIn distinctTeamsIn			) throws SQLException {
			int index = 1;
            if (distinctTeamsIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, distinctTeamsIn.getProgramWebPath()); 
            }
            index ++;
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						distinctTeamsIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, distinctTeamsIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						DistinctTeamsOut distinctTeamsOut = new DistinctTeamsOut();
						distinctTeamsOut.setName(rs.getString("name"));
						distinctTeamsOut.setWebPath(rs.getString("web_path"));
						list.add(distinctTeamsOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<DistinctTeamsOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}