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
package com.game.score.dao.sdd.impl.property;



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
import com.game.score.sdd.out.property.GetPropertiesOutList;
import com.game.score.sdd.out.property.GetPropertiesOut;
import com.game.score.dao.sdd.face.property.GetPropertiesDaoFace;
import com.game.score.sdd.in.property.GetPropertiesIn;
/**
 *
 * <p>Title: GetPropertiesRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("getPropertiesDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class GetPropertiesRepository implements GetPropertiesDaoFace {

	public static final String QUERY_NATIVE = "select      sp.PROPERTY property,     sp.UNIT unit,     s.VALUE property_value, 	s.ENTITY_TYPE entity_type, 	s.ENTITY_WEB_PATH entity_web_path from  	gs_ev_store s,     gs_ev_store_property sp where 	s.PROPERTY_ID = sp.ID and     s.PROPERTY_ID = sp.ID      $whereEntityType     $whereEntityWebPath     $whereProperty";
	public static final String CHUNK_whereEntityType = "s.ENTITY_TYPE = ?";
	public static final String CHUNK_whereEntityWebPath = "s.ENTITY_WEB_PATH = ?";
	public static final String CHUNK_whereProperty = "sp.PROPERTY = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="getPropertiesCache") 
    public GetPropertiesOutList execute (
		GetPropertiesIn getPropertiesIn
		) {
		GetPropertiesOutList getPropertiesOutList = new GetPropertiesOutList();
		GetPropertiesOutListWork work = new GetPropertiesOutListWork (
			getPropertiesIn
			);
        Session session = getSession();
        session.doWork(work);
		getPropertiesOutList.setGetPropertiesOuts (work.getResult());
        return getPropertiesOutList;
    }


	public boolean isFilterwhereEntityTypeActive(GetPropertiesIn getPropertiesIn) {
		if (getPropertiesIn.getEntityType() == null) return false;
		return true;	
	}
	public boolean isFilterwhereEntityWebPathActive(GetPropertiesIn getPropertiesIn) {
		if (getPropertiesIn.getEntityWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwherePropertyActive(GetPropertiesIn getPropertiesIn) {
		if (getPropertiesIn.getProperty() == null) return false;
		return true;	
	}


	public String getStatement(
			GetPropertiesIn getPropertiesIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereEntityTypeActive( getPropertiesIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereEntityType", connectionWord + getChunkwhereEntityType(getPropertiesIn, CHUNK_whereEntityType) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereEntityType","");//replaceOnce
		}
		if (
			 isFilterwhereEntityWebPathActive( getPropertiesIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereEntityWebPath", connectionWord + getChunkwhereEntityWebPath(getPropertiesIn, CHUNK_whereEntityWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereEntityWebPath","");//replaceOnce
		}
		if (
			 isFilterwherePropertyActive( getPropertiesIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProperty", connectionWord + getChunkwhereProperty(getPropertiesIn, CHUNK_whereProperty) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProperty","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereEntityType (GetPropertiesIn getPropertiesIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereEntityWebPath (GetPropertiesIn getPropertiesIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereProperty (GetPropertiesIn getPropertiesIn, String chunk) {
		return chunk;
	}
	
   private class GetPropertiesOutListWork implements Work {
		GetPropertiesIn getPropertiesIn;
        GetPropertiesOutListWork(
			GetPropertiesIn getPropertiesIn
			){
				this.getPropertiesIn = getPropertiesIn;
		}
		List<GetPropertiesOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, GetPropertiesIn getPropertiesIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereEntityTypeActive( getPropertiesIn)) {
            if (getPropertiesIn.getEntityType()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, getPropertiesIn.getEntityType()); 
            }
            index ++;
			}
			if (isFilterwhereEntityWebPathActive( getPropertiesIn)) {
            if (getPropertiesIn.getEntityWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, getPropertiesIn.getEntityWebPath()); 
            }
            index ++;
			}
			if (isFilterwherePropertyActive( getPropertiesIn)) {
            if (getPropertiesIn.getProperty()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, getPropertiesIn.getProperty()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						getPropertiesIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, getPropertiesIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						GetPropertiesOut getPropertiesOut = new GetPropertiesOut();
						getPropertiesOut.setProperty(rs.getString("property"));
						getPropertiesOut.setUnit(rs.getString("unit"));
						getPropertiesOut.setPropertyValue(rs.getString("property_value"));
						getPropertiesOut.setEntityType(rs.getString("entity_type"));
						getPropertiesOut.setEntityWebPath(rs.getString("entity_web_path"));
						list.add(getPropertiesOut);
	        		}	        	}			}
       }

       List<GetPropertiesOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}