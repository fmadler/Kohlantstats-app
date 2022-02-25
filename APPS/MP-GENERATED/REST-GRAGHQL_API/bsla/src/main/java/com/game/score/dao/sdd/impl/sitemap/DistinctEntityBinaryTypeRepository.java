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
import com.game.score.sdd.out.sitemap.DistinctEntityBinaryTypeOutList;
import com.game.score.sdd.out.sitemap.DistinctEntityBinaryTypeOut;
import com.game.score.dao.sdd.face.sitemap.DistinctEntityBinaryTypeDaoFace;
import com.game.score.sdd.in.sitemap.DistinctEntityBinaryTypeIn;
/**
 *
 * <p>Title: DistinctEntityBinaryTypeRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("distinctEntityBinaryTypeDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class DistinctEntityBinaryTypeRepository implements DistinctEntityBinaryTypeDaoFace {

	public static final String QUERY_NATIVE = "select distinct 									binary_type_name, 									binary_type_web_path, 									entity_type_web_path 								from v_entity_binary_type";
	public static final String CHUNK_whereEntityTypeWebPath = "entity_type_web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="distinctEntityBinaryTypeCache") 
    public DistinctEntityBinaryTypeOutList execute (
		DistinctEntityBinaryTypeIn distinctEntityBinaryTypeIn
		) {
		DistinctEntityBinaryTypeOutList distinctEntityBinaryTypeOutList = new DistinctEntityBinaryTypeOutList();
		DistinctEntityBinaryTypeOutListWork work = new DistinctEntityBinaryTypeOutListWork (
			distinctEntityBinaryTypeIn
			);
        Session session = getSession();
        session.doWork(work);
		distinctEntityBinaryTypeOutList.setDistinctEntityBinaryTypeOuts (work.getResult());
        return distinctEntityBinaryTypeOutList;
    }


	public boolean isFilterwhereEntityTypeWebPathActive(DistinctEntityBinaryTypeIn distinctEntityBinaryTypeIn) {
		if (distinctEntityBinaryTypeIn.getEntityTypeWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			DistinctEntityBinaryTypeIn distinctEntityBinaryTypeIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereEntityTypeWebPathActive( distinctEntityBinaryTypeIn)			) {
			String connectionWord = " AND ";
			if (!isWhereDone) {
				connectionWord = " WHERE ";
			}
			query = StringUtils.replace (query, "$"+"whereEntityTypeWebPath", connectionWord + getChunkwhereEntityTypeWebPath(distinctEntityBinaryTypeIn, CHUNK_whereEntityTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereEntityTypeWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereEntityTypeWebPath (DistinctEntityBinaryTypeIn distinctEntityBinaryTypeIn, String chunk) {
		return chunk;
	}
	
   private class DistinctEntityBinaryTypeOutListWork implements Work {
		DistinctEntityBinaryTypeIn distinctEntityBinaryTypeIn;
        DistinctEntityBinaryTypeOutListWork(
			DistinctEntityBinaryTypeIn distinctEntityBinaryTypeIn
			){
				this.distinctEntityBinaryTypeIn = distinctEntityBinaryTypeIn;
		}
		List<DistinctEntityBinaryTypeOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, DistinctEntityBinaryTypeIn distinctEntityBinaryTypeIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereEntityTypeWebPathActive( distinctEntityBinaryTypeIn)) {
            if (distinctEntityBinaryTypeIn.getEntityTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, distinctEntityBinaryTypeIn.getEntityTypeWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						distinctEntityBinaryTypeIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, distinctEntityBinaryTypeIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						DistinctEntityBinaryTypeOut distinctEntityBinaryTypeOut = new DistinctEntityBinaryTypeOut();
						distinctEntityBinaryTypeOut.setBinaryTypeName(rs.getString("binary_type_name"));
						distinctEntityBinaryTypeOut.setBinaryTypeWebPath(rs.getString("binary_type_web_path"));
						distinctEntityBinaryTypeOut.setEntityTypeWebPath(rs.getString("entity_type_web_path"));
						list.add(distinctEntityBinaryTypeOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<DistinctEntityBinaryTypeOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}