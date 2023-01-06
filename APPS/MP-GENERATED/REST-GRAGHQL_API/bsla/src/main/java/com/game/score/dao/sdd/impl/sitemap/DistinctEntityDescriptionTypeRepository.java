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
import com.game.score.sdd.out.sitemap.DistinctEntityDescriptionTypeOutList;
import com.game.score.sdd.out.sitemap.DistinctEntityDescriptionTypeOut;
import com.game.score.dao.sdd.face.sitemap.DistinctEntityDescriptionTypeDaoFace;
import com.game.score.sdd.in.sitemap.DistinctEntityDescriptionTypeIn;
/**
 *
 * <p>Title: DistinctEntityDescriptionTypeRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("distinctEntityDescriptionTypeDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class DistinctEntityDescriptionTypeRepository implements DistinctEntityDescriptionTypeDaoFace {

	public static final String QUERY_NATIVE = "select distinct 									description_type_name, 									description_type_web_path, 									entity_type_web_path 								from v_entity_description_type";
	public static final String CHUNK_whereEntityTypeWebPath = "entity_type_web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="distinctEntityDescriptionTypeCache") 
    public DistinctEntityDescriptionTypeOutList execute (
		DistinctEntityDescriptionTypeIn distinctEntityDescriptionTypeIn
		) {
		DistinctEntityDescriptionTypeOutList distinctEntityDescriptionTypeOutList = new DistinctEntityDescriptionTypeOutList();
		DistinctEntityDescriptionTypeOutListWork work = new DistinctEntityDescriptionTypeOutListWork (
			distinctEntityDescriptionTypeIn
			);
        Session session = getSession();
        session.doWork(work);
		distinctEntityDescriptionTypeOutList.setDistinctEntityDescriptionTypeOuts (work.getResult());
        return distinctEntityDescriptionTypeOutList;
    }


	public boolean isFilterwhereEntityTypeWebPathActive(DistinctEntityDescriptionTypeIn distinctEntityDescriptionTypeIn) {
		if (distinctEntityDescriptionTypeIn.getEntityTypeWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			DistinctEntityDescriptionTypeIn distinctEntityDescriptionTypeIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereEntityTypeWebPathActive( distinctEntityDescriptionTypeIn)			) {
			String connectionWord = " AND ";
			if (!isWhereDone) {
				connectionWord = " WHERE ";
			}
			query = StringUtils.replace (query, "$"+"whereEntityTypeWebPath", connectionWord + getChunkwhereEntityTypeWebPath(distinctEntityDescriptionTypeIn, CHUNK_whereEntityTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereEntityTypeWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereEntityTypeWebPath (DistinctEntityDescriptionTypeIn distinctEntityDescriptionTypeIn, String chunk) {
		return chunk;
	}
	
   private class DistinctEntityDescriptionTypeOutListWork implements Work {
		DistinctEntityDescriptionTypeIn distinctEntityDescriptionTypeIn;
        DistinctEntityDescriptionTypeOutListWork(
			DistinctEntityDescriptionTypeIn distinctEntityDescriptionTypeIn
			){
				this.distinctEntityDescriptionTypeIn = distinctEntityDescriptionTypeIn;
		}
		List<DistinctEntityDescriptionTypeOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, DistinctEntityDescriptionTypeIn distinctEntityDescriptionTypeIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereEntityTypeWebPathActive( distinctEntityDescriptionTypeIn)) {
            if (distinctEntityDescriptionTypeIn.getEntityTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, distinctEntityDescriptionTypeIn.getEntityTypeWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						distinctEntityDescriptionTypeIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, distinctEntityDescriptionTypeIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						DistinctEntityDescriptionTypeOut distinctEntityDescriptionTypeOut = new DistinctEntityDescriptionTypeOut();
						distinctEntityDescriptionTypeOut.setDescriptionTypeName(rs.getString("description_type_name"));
						distinctEntityDescriptionTypeOut.setDescriptionTypeWebPath(rs.getString("description_type_web_path"));
						distinctEntityDescriptionTypeOut.setEntityTypeWebPath(rs.getString("entity_type_web_path"));
						list.add(distinctEntityDescriptionTypeOut);
	        		}	        	}			}
       }

       List<DistinctEntityDescriptionTypeOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}