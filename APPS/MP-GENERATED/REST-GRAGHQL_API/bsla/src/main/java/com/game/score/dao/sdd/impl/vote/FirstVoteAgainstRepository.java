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
package com.game.score.dao.sdd.impl.vote;



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
import com.game.score.sdd.out.vote.FirstVoteAgainstOutList;
import com.game.score.sdd.out.vote.FirstVoteAgainstOut;
import com.game.score.dao.sdd.face.vote.FirstVoteAgainstDaoFace;
import com.game.score.sdd.in.vote.FirstVoteAgainstIn;
/**
 *
 * <p>Title: FirstVoteAgainstRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("firstVoteAgainstDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class FirstVoteAgainstRepository implements FirstVoteAgainstDaoFace {

	public static final String QUERY_NATIVE = "call first_vote_against (?, ?, ?, ?, ?)";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

    public FirstVoteAgainstOutList execute (
		FirstVoteAgainstIn firstVoteAgainstIn
		) {
		FirstVoteAgainstOutList firstVoteAgainstOutList = new FirstVoteAgainstOutList();
		FirstVoteAgainstOutListWork work = new FirstVoteAgainstOutListWork (
			firstVoteAgainstIn
			);
        Session session = getSession();
        session.doWork(work);
		firstVoteAgainstOutList.setFirstVoteAgainstOuts (work.getResult());
        return firstVoteAgainstOutList;
    }




	public String getStatement(
			FirstVoteAgainstIn firstVoteAgainstIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		return query;
	}
	
   private class FirstVoteAgainstOutListWork implements Work {
		FirstVoteAgainstIn firstVoteAgainstIn;
        FirstVoteAgainstOutListWork(
			FirstVoteAgainstIn firstVoteAgainstIn
			){
				this.firstVoteAgainstIn = firstVoteAgainstIn;
		}
		List<FirstVoteAgainstOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			CallableStatement pstmt
			, FirstVoteAgainstIn firstVoteAgainstIn			) throws SQLException {
			int index = 1;
            if (firstVoteAgainstIn.getVoterWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, firstVoteAgainstIn.getVoterWebPath()); 
            }
            index ++;
            if (firstVoteAgainstIn.getVoterTargetWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, firstVoteAgainstIn.getVoterTargetWebPath()); 
            }
            index ++;
            if (firstVoteAgainstIn.getTeamWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, firstVoteAgainstIn.getTeamWebPath()); 
            }
            index ++;
            if (firstVoteAgainstIn.getTimeUnit()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, firstVoteAgainstIn.getTimeUnit()); 
            }
            index ++;
            if (firstVoteAgainstIn.getVoteEffectivenessTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, firstVoteAgainstIn.getVoteEffectivenessTypeWebPath()); 
            }
            index ++;
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				CallableStatement pstmt = conn.prepareCall(
					getStatement(
						firstVoteAgainstIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, firstVoteAgainstIn);
					pstmt.executeUpdate();
	        	}       }

       List<FirstVoteAgainstOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}