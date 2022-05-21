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
package com.game.score.dao.sdd.impl.timeline;



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
import com.game.score.sdd.out.timeline.CreateTimelineOutList;
import com.game.score.sdd.out.timeline.CreateTimelineOut;
import com.game.score.dao.sdd.face.timeline.CreateTimelineDaoFace;
import com.game.score.sdd.in.timeline.CreateTimelineIn;
/**
 *
 * <p>Title: CreateTimelineRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("createTimelineDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class CreateTimelineRepository implements CreateTimelineDaoFace {

	public static final String QUERY_NATIVE = "call create_timeline_for_program (?, ?)";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

    public CreateTimelineOutList execute (
		CreateTimelineIn createTimelineIn
		) {
		CreateTimelineOutList createTimelineOutList = new CreateTimelineOutList();
		CreateTimelineOutListWork work = new CreateTimelineOutListWork (
			createTimelineIn
			);
        Session session = getSession();
        session.doWork(work);
		createTimelineOutList.setCreateTimelineOuts (work.getResult());
        return createTimelineOutList;
    }




	public String getStatement(
			CreateTimelineIn createTimelineIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		return query;
	}
	
   private class CreateTimelineOutListWork implements Work {
		CreateTimelineIn createTimelineIn;
        CreateTimelineOutListWork(
			CreateTimelineIn createTimelineIn
			){
				this.createTimelineIn = createTimelineIn;
		}
		List<CreateTimelineOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			CallableStatement pstmt
			, CreateTimelineIn createTimelineIn			) throws SQLException {
			int index = 1;
            if (createTimelineIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, createTimelineIn.getProgramWebPath()); 
            }
            index ++;
			pstmt.registerOutParameter(index, java.sql.Types.VARCHAR);
			index++;
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				CallableStatement pstmt = conn.prepareCall(
					getStatement(
						createTimelineIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, createTimelineIn);
					pstmt.execute();
				CreateTimelineOut createTimelineOut = new CreateTimelineOut();
				createTimelineOut.setResult(pstmt.getString(2));
				list.add(createTimelineOut);
	        	}//from try (autoclosable)
       }

       List<CreateTimelineOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}