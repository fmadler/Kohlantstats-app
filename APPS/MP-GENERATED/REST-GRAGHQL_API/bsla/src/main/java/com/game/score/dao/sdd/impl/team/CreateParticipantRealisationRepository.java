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
package com.game.score.dao.sdd.impl.team;



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
import com.game.score.sdd.out.team.CreateParticipantRealisationOutList;
import com.game.score.sdd.out.team.CreateParticipantRealisationOut;
import com.game.score.dao.sdd.face.team.CreateParticipantRealisationDaoFace;
import com.game.score.sdd.in.team.CreateParticipantRealisationIn;
/**
 *
 * <p>Title: CreateParticipantRealisationRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("createParticipantRealisationDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class CreateParticipantRealisationRepository implements CreateParticipantRealisationDaoFace {

	public static final String QUERY_NATIVE = "call create_participant_realisation (?, ?, ?, ?, ?, ?)";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

    public CreateParticipantRealisationOutList execute (
		CreateParticipantRealisationIn createParticipantRealisationIn
		) {
		CreateParticipantRealisationOutList createParticipantRealisationOutList = new CreateParticipantRealisationOutList();
		CreateParticipantRealisationOutListWork work = new CreateParticipantRealisationOutListWork (
			createParticipantRealisationIn
			);
        Session session = getSession();
        session.doWork(work);
		createParticipantRealisationOutList.setCreateParticipantRealisationOuts (work.getResult());
        return createParticipantRealisationOutList;
    }




	public String getStatement(
			CreateParticipantRealisationIn createParticipantRealisationIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		return query;
	}
	
   private class CreateParticipantRealisationOutListWork implements Work {
		CreateParticipantRealisationIn createParticipantRealisationIn;
        CreateParticipantRealisationOutListWork(
			CreateParticipantRealisationIn createParticipantRealisationIn
			){
				this.createParticipantRealisationIn = createParticipantRealisationIn;
		}
		List<CreateParticipantRealisationOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			CallableStatement pstmt
			, CreateParticipantRealisationIn createParticipantRealisationIn			) throws SQLException {
			int index = 1;
            if (createParticipantRealisationIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, createParticipantRealisationIn.getProgramWebPath()); 
            }
            index ++;
            if (createParticipantRealisationIn.getParticipantWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, createParticipantRealisationIn.getParticipantWebPath()); 
            }
            index ++;
            if (createParticipantRealisationIn.getTeamWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, createParticipantRealisationIn.getTeamWebPath()); 
            }
            index ++;
            if (createParticipantRealisationIn.getTime()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, createParticipantRealisationIn.getTime()); 
            }
            index ++;
            if (createParticipantRealisationIn.getRealisationWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, createParticipantRealisationIn.getRealisationWebPath()); 
            }
            index ++;
			pstmt.registerOutParameter(index, java.sql.Types.INTEGER);
			index++;
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				CallableStatement pstmt = conn.prepareCall(
					getStatement(
						createParticipantRealisationIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, createParticipantRealisationIn);
					pstmt.execute();
				CreateParticipantRealisationOut createParticipantRealisationOut = new CreateParticipantRealisationOut();
				createParticipantRealisationOut.setParticipantTeamRealisationId(pstmt.getInt(6));
				list.add(createParticipantRealisationOut);
	        	}       }

       List<CreateParticipantRealisationOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}