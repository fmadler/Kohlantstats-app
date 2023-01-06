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
import com.game.score.sdd.out.vote.SecondVoteAgainstOutList;
import com.game.score.sdd.out.vote.SecondVoteAgainstOut;
import com.game.score.dao.sdd.face.vote.SecondVoteAgainstDaoFace;
import com.game.score.sdd.in.vote.SecondVoteAgainstIn;
/**
 *
 * <p>Title: SecondVoteAgainstRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("secondVoteAgainstDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class SecondVoteAgainstRepository implements SecondVoteAgainstDaoFace {

	public static final String QUERY_NATIVE = "call second_vote_against (?, ?, ?, ?, ?)";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

    public SecondVoteAgainstOutList execute (
		SecondVoteAgainstIn secondVoteAgainstIn
		) {
		SecondVoteAgainstOutList secondVoteAgainstOutList = new SecondVoteAgainstOutList();
		SecondVoteAgainstOutListWork work = new SecondVoteAgainstOutListWork (
			secondVoteAgainstIn
			);
        Session session = getSession();
        session.doWork(work);
		secondVoteAgainstOutList.setSecondVoteAgainstOuts (work.getResult());
        return secondVoteAgainstOutList;
    }




	public String getStatement(
			SecondVoteAgainstIn secondVoteAgainstIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		return query;
	}
	
   private class SecondVoteAgainstOutListWork implements Work {
		SecondVoteAgainstIn secondVoteAgainstIn;
        SecondVoteAgainstOutListWork(
			SecondVoteAgainstIn secondVoteAgainstIn
			){
				this.secondVoteAgainstIn = secondVoteAgainstIn;
		}
		List<SecondVoteAgainstOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			CallableStatement pstmt
			, SecondVoteAgainstIn secondVoteAgainstIn			) throws SQLException {
			int index = 1;
            if (secondVoteAgainstIn.getVoterWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, secondVoteAgainstIn.getVoterWebPath()); 
            }
            index ++;
            if (secondVoteAgainstIn.getVoterTargetWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, secondVoteAgainstIn.getVoterTargetWebPath()); 
            }
            index ++;
            if (secondVoteAgainstIn.getTeamWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, secondVoteAgainstIn.getTeamWebPath()); 
            }
            index ++;
            if (secondVoteAgainstIn.getTimeUnit()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, secondVoteAgainstIn.getTimeUnit()); 
            }
            index ++;
            if (secondVoteAgainstIn.getVoteEffectivenessTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, secondVoteAgainstIn.getVoteEffectivenessTypeWebPath()); 
            }
            index ++;
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				CallableStatement pstmt = conn.prepareCall(
					getStatement(
						secondVoteAgainstIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, secondVoteAgainstIn);
					pstmt.executeUpdate();
	        	}       }

       List<SecondVoteAgainstOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}