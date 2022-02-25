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
package com.game.score.dao.sdd.impl.participant;



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
import com.game.score.sdd.out.participant.ParticipantSummaryOutList;
import com.game.score.sdd.out.participant.ParticipantSummaryOut;
import com.game.score.dao.sdd.face.participant.ParticipantSummaryDaoFace;
import com.game.score.sdd.in.participant.ParticipantSummaryIn;
/**
 *
 * <p>Title: ParticipantSummaryRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("participantSummaryDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class ParticipantSummaryRepository implements ParticipantSummaryDaoFace {

	public static final String QUERY_NATIVE = "select pg.web_path program_web_path, pg.name program_name, pg.EDITION_NUMBER program_EDITION_NUMBER, pa.age, pl.name, pl.web_path, pl.family_name, pl.sex, pl.BIRTH_date, pa.final_position, xx.nb_victories, yy.max_time from  gs_program pg, gs_player pl, gs_participant pa left join ( select GS_PARTICIPANT_ID, count(*) nb_victories from gs_participant_x_game pxg where ranking = 1 group by GS_PARTICIPANT_ID ) xx on xx.GS_PARTICIPANT_ID = pa.id left join ( select GS_PARTICIPANT_ID, max(TO_TIME_UNIT) max_time from GS_PARTICIPANT_TEAM pt group by GS_PARTICIPANT_ID ) yy on yy.GS_PARTICIPANT_ID = pa.id where pa.GS_PLAYER_ID = pl.ID and pa.gs_program_id = pg.id $whereProgramWebPath $wherePlayerWebPath";
	public static final String CHUNK_whereProgramWebPath = "pg.web_path = ?";
	public static final String CHUNK_wherePlayerWebPath = "pl.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="participantSummaryCache") 
    public ParticipantSummaryOutList execute (
		ParticipantSummaryIn participantSummaryIn
		) {
		ParticipantSummaryOutList participantSummaryOutList = new ParticipantSummaryOutList();
		ParticipantSummaryOutListWork work = new ParticipantSummaryOutListWork (
			participantSummaryIn
			);
        Session session = getSession();
        session.doWork(work);
		participantSummaryOutList.setParticipantSummaryOuts (work.getResult());
        return participantSummaryOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(ParticipantSummaryIn participantSummaryIn) {
		if (participantSummaryIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwherePlayerWebPathActive(ParticipantSummaryIn participantSummaryIn) {
		if (participantSummaryIn.getPlayerWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			ParticipantSummaryIn participantSummaryIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( participantSummaryIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(participantSummaryIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwherePlayerWebPathActive( participantSummaryIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"wherePlayerWebPath", connectionWord + getChunkwherePlayerWebPath(participantSummaryIn, CHUNK_wherePlayerWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"wherePlayerWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (ParticipantSummaryIn participantSummaryIn, String chunk) {
		return chunk;
	}

	private String getChunkwherePlayerWebPath (ParticipantSummaryIn participantSummaryIn, String chunk) {
		return chunk;
	}
	
   private class ParticipantSummaryOutListWork implements Work {
		ParticipantSummaryIn participantSummaryIn;
        ParticipantSummaryOutListWork(
			ParticipantSummaryIn participantSummaryIn
			){
				this.participantSummaryIn = participantSummaryIn;
		}
		List<ParticipantSummaryOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, ParticipantSummaryIn participantSummaryIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( participantSummaryIn)) {
            if (participantSummaryIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, participantSummaryIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwherePlayerWebPathActive( participantSummaryIn)) {
            if (participantSummaryIn.getPlayerWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, participantSummaryIn.getPlayerWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						participantSummaryIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, participantSummaryIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						ParticipantSummaryOut participantSummaryOut = new ParticipantSummaryOut();
						participantSummaryOut.setProgramWebPath(rs.getString("program_web_path"));
						participantSummaryOut.setProgramName(rs.getString("program_name"));
						participantSummaryOut.setProgramEditionNumber(rs.getInt("program_EDITION_NUMBER"));
						participantSummaryOut.setAge(rs.getInt("age"));
						participantSummaryOut.setName(rs.getString("name"));
						participantSummaryOut.setWebPath(rs.getString("web_path"));
						participantSummaryOut.setFamilyName(rs.getString("family_name"));
						participantSummaryOut.setSex(rs.getString("sex"));
						participantSummaryOut.setBirthDate(rs.getDate("BIRTH_date"));
						participantSummaryOut.setFinalPosition(rs.getInt("final_position"));
						participantSummaryOut.setNbVictories(rs.getLong("nb_victories"));
						participantSummaryOut.setMaxTime(rs.getInt("max_time"));
						list.add(participantSummaryOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<ParticipantSummaryOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}