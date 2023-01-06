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
import com.game.score.sdd.out.distinct.DistinctGameTagsOutList;
import com.game.score.sdd.out.distinct.DistinctGameTagsOut;
import com.game.score.dao.sdd.face.distinct.DistinctGameTagsDaoFace;
import com.game.score.sdd.in.distinct.DistinctGameTagsIn;
/**
 *
 * <p>Title: DistinctGameTagsRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("distinctGameTagsDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class DistinctGameTagsRepository implements DistinctGameTagsDaoFace {

	public static final String QUERY_NATIVE = "select distinct 	t.name name, 	t.web_path WEB_PATH, 	p.name program_name, 	p.web_path program_web_path from gs_game g 	left outer join ( 		select GS_GAME_ID, gta.NAME, gta.WEB_PATH from GS_GAME_X_TAG gxt, GS_GAME_TAG gta 		where gxt.GS_GAME_TAG_ID = gta.ID 	) t on t.GS_GAME_ID = g.ID , gs_program p where 	g.GS_PROGRAM_ID = p.ID 	$whereProgramWebPath ORDER by t.NAME";
	public static final String CHUNK_whereProgramWebPath = "p.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="distinctGameTagsCache") 
    public DistinctGameTagsOutList execute (
		DistinctGameTagsIn distinctGameTagsIn
		) {
		DistinctGameTagsOutList distinctGameTagsOutList = new DistinctGameTagsOutList();
		DistinctGameTagsOutListWork work = new DistinctGameTagsOutListWork (
			distinctGameTagsIn
			);
        Session session = getSession();
        session.doWork(work);
		distinctGameTagsOutList.setDistinctGameTagsOuts (work.getResult());
        return distinctGameTagsOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(DistinctGameTagsIn distinctGameTagsIn) {
		if (distinctGameTagsIn.getProgramWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			DistinctGameTagsIn distinctGameTagsIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( distinctGameTagsIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(distinctGameTagsIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (DistinctGameTagsIn distinctGameTagsIn, String chunk) {
		return chunk;
	}
	
   private class DistinctGameTagsOutListWork implements Work {
		DistinctGameTagsIn distinctGameTagsIn;
        DistinctGameTagsOutListWork(
			DistinctGameTagsIn distinctGameTagsIn
			){
				this.distinctGameTagsIn = distinctGameTagsIn;
		}
		List<DistinctGameTagsOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, DistinctGameTagsIn distinctGameTagsIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( distinctGameTagsIn)) {
            if (distinctGameTagsIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, distinctGameTagsIn.getProgramWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						distinctGameTagsIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, distinctGameTagsIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						DistinctGameTagsOut distinctGameTagsOut = new DistinctGameTagsOut();
						distinctGameTagsOut.setName(rs.getString("name"));
						distinctGameTagsOut.setWebPath(rs.getString("WEB_PATH"));
						distinctGameTagsOut.setProgramName(rs.getString("program_name"));
						distinctGameTagsOut.setProgramWebPath(rs.getString("program_web_path"));
						list.add(distinctGameTagsOut);
	        		}	        	}			}
       }

       List<DistinctGameTagsOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}