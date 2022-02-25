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
import com.game.score.sdd.out.sitemap.SitemapParamOutList;
import com.game.score.sdd.out.sitemap.SitemapParamOut;
import com.game.score.dao.sdd.face.sitemap.SitemapParamDaoFace;
import com.game.score.sdd.in.sitemap.SitemapParamIn;
/**
 *
 * <p>Title: SitemapParamRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("sitemapParamDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class SitemapParamRepository implements SitemapParamDaoFace {

	public static final String QUERY_NATIVE = "select 									name, 									entity_id, 									entity_full_web_path, 									context_type_web_path, 									context_web_path, 									entity_type_web_path, 									entity_web_path 								from v_sitemap_param_core 									$whereEntityTypeWebPath 									$whereContextTypeWebPath 									$whereName 								order by score";
	public static final String CHUNK_whereEntityTypeWebPath = "entity_type_web_path = ?";
	public static final String CHUNK_whereContextTypeWebPath = "context_type_web_path = ?";
	public static final String CHUNK_whereName = "name like ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="sitemapParamCache") 
    public SitemapParamOutList execute (
		SitemapParamIn sitemapParamIn
		) {
		SitemapParamOutList sitemapParamOutList = new SitemapParamOutList();
		SitemapParamOutListWork work = new SitemapParamOutListWork (
			sitemapParamIn
			);
        Session session = getSession();
        session.doWork(work);
		sitemapParamOutList.setSitemapParamOuts (work.getResult());
        return sitemapParamOutList;
    }


	public boolean isFilterwhereEntityTypeWebPathActive(SitemapParamIn sitemapParamIn) {
		if (sitemapParamIn.getEntityTypeWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereContextTypeWebPathActive(SitemapParamIn sitemapParamIn) {
		if (sitemapParamIn.getContextTypeWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereNameActive(SitemapParamIn sitemapParamIn) {
		if (sitemapParamIn.getName() == null) return false;
		return true;	
	}


	public String getStatement(
			SitemapParamIn sitemapParamIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereEntityTypeWebPathActive( sitemapParamIn)			) {
			String connectionWord = " AND ";
			if (!isWhereDone) {
				connectionWord = " WHERE ";
			}
			query = StringUtils.replace (query, "$"+"whereEntityTypeWebPath", connectionWord + getChunkwhereEntityTypeWebPath(sitemapParamIn, CHUNK_whereEntityTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereEntityTypeWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereContextTypeWebPathActive( sitemapParamIn)			) {
			String connectionWord = " AND ";
			if (!isWhereDone) {
				connectionWord = " WHERE ";
			}
			query = StringUtils.replace (query, "$"+"whereContextTypeWebPath", connectionWord + getChunkwhereContextTypeWebPath(sitemapParamIn, CHUNK_whereContextTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereContextTypeWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereNameActive( sitemapParamIn)			) {
			String connectionWord = " AND ";
			if (!isWhereDone) {
				connectionWord = " WHERE ";
			}
			query = StringUtils.replace (query, "$"+"whereName", connectionWord + getChunkwhereName(sitemapParamIn, CHUNK_whereName) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereName","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereEntityTypeWebPath (SitemapParamIn sitemapParamIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereContextTypeWebPath (SitemapParamIn sitemapParamIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereName (SitemapParamIn sitemapParamIn, String chunk) {
		return chunk;
	}
	
   private class SitemapParamOutListWork implements Work {
		SitemapParamIn sitemapParamIn;
        SitemapParamOutListWork(
			SitemapParamIn sitemapParamIn
			){
				this.sitemapParamIn = sitemapParamIn;
		}
		List<SitemapParamOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, SitemapParamIn sitemapParamIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereEntityTypeWebPathActive( sitemapParamIn)) {
            if (sitemapParamIn.getEntityTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, sitemapParamIn.getEntityTypeWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereContextTypeWebPathActive( sitemapParamIn)) {
            if (sitemapParamIn.getContextTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, sitemapParamIn.getContextTypeWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereNameActive( sitemapParamIn)) {
            if (sitemapParamIn.getName()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               String var = "%" + sitemapParamIn.getName() + "%";
               pstmt.setString(index, var); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						sitemapParamIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, sitemapParamIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						SitemapParamOut sitemapParamOut = new SitemapParamOut();
						sitemapParamOut.setName(rs.getString("name"));
						sitemapParamOut.setEntityId(rs.getLong("entity_id"));
						sitemapParamOut.setEntityFullWebPath(rs.getString("entity_full_web_path"));
						sitemapParamOut.setContextTypeWebPath(rs.getString("context_type_web_path"));
						sitemapParamOut.setContextWebPath(rs.getString("context_web_path"));
						sitemapParamOut.setEntityTypeWebPath(rs.getString("entity_type_web_path"));
						sitemapParamOut.setEntityWebPath(rs.getString("entity_web_path"));
						list.add(sitemapParamOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<SitemapParamOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}