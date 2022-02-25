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
package com.game.score.dao.sdd.impl.sitemap;



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
import com.game.score.sdd.out.sitemap.DistinctEntityTypeOutList;
import com.game.score.sdd.out.sitemap.DistinctEntityTypeOut;
import com.game.score.dao.sdd.face.sitemap.DistinctEntityTypeDaoFace;
/**
 *
 * <p>Title: DistinctEntityTypeRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("distinctEntityTypeDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class DistinctEntityTypeRepository implements DistinctEntityTypeDaoFace {

	public static final String QUERY_NATIVE = "select distinct 									context_type_web_path, 									entity_type_web_path, 									entity_type_name 								from v_entity_type";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="distinctEntityTypeCache") 
    public DistinctEntityTypeOutList execute (
		) {
		DistinctEntityTypeOutList distinctEntityTypeOutList = new DistinctEntityTypeOutList();
		DistinctEntityTypeOutListWork work = new DistinctEntityTypeOutListWork (
			);
        Session session = getSession();
        session.doWork(work);
		distinctEntityTypeOutList.setDistinctEntityTypeOuts (work.getResult());
        return distinctEntityTypeOutList;
    }




	public String getStatement(
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		return query;
	}
	
   private class DistinctEntityTypeOutListWork implements Work {
        DistinctEntityTypeOutListWork(
			){
		}
		List<DistinctEntityTypeOut> list = new ArrayList<>();

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
						DistinctEntityTypeOut distinctEntityTypeOut = new DistinctEntityTypeOut();
						distinctEntityTypeOut.setContextTypeWebPath(rs.getString("context_type_web_path"));
						distinctEntityTypeOut.setEntityTypeWebPath(rs.getString("entity_type_web_path"));
						distinctEntityTypeOut.setEntityTypeName(rs.getString("entity_type_name"));
						list.add(distinctEntityTypeOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<DistinctEntityTypeOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}