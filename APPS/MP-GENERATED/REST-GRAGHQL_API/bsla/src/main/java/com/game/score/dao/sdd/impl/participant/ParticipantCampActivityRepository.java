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
import com.game.score.sdd.out.participant.ParticipantCampActivityOutList;
import com.game.score.sdd.out.participant.ParticipantCampActivityOut;
import com.game.score.dao.sdd.face.participant.ParticipantCampActivityDaoFace;
import com.game.score.sdd.in.participant.ParticipantCampActivityIn;
/**
 *
 * <p>Title: ParticipantCampActivityRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("participantCampActivityDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class ParticipantCampActivityRepository implements ParticipantCampActivityDaoFace {

	public static final String QUERY_NATIVE = "select  	prg.NAME program_name,     prg.WEB_PATH program_web_path,     t.NAME team_name,     t.WEB_PATH team_web_path,     td.FROM_TIME_UNIT team_from_time,     td.TO_TIME_UNIT team_to_time, 	pl.name player_name,      pl.web_path player_web_path,     p.ID participant_id,     tet.NAME team_player_entrance_type,     pt.FROM_TIME_UNIT team_player_from_time,     tdt.NAME team_player_departure_type,     pt.TO_TIME_UNIT team_player_to_time, 	GROUP_CONCAT(distinct 			CONCAT_WS( 			'|', 			rt.name,             rt.web_path 			) 			order by gtxr.DISPLAY_ORDER 			) realisations from  	GS_PROGRAM prg, 	GS_PLAYER pl,  	GS_PARTICIPANT p,  	GS_PARTICIPANT_TEAM pt 		left outer join GS_PARTICIPANT_TEAM_X_REALISATION gtxr on gtxr.GS_PARTICIPANT_TEAM_ID = pt.ID         left outer join GS_REALISATION_TYPE rt on gtxr.GS_REALISATION_TYPE_ID = rt.id,  	GS_TEAM t,  	GS_TEAM_DURATION td,  	GS_TEAM_ENTRANCE_TYPE tet,  	GS_TEAM_DEPARTURE_TYPE tdt where  	p.GS_PLAYER_ID = pl.ID and      pt.GS_PARTICIPANT_ID = p.ID and      p.GS_PROGRAM_ID = prg.ID and     pt.GS_TEAM_ID = t.ID and      t.GS_TEAM_DURATION_ID = td.ID and     pt.GS_TEAM_ENTRANCE_TYPE_ID = tet.ID and      pt.GS_TEAM_DEPARTURE_TYPE_ID = tdt.ID     $whereProgramWebPath     $whereTeamWebPath     $wherePlayerWebPath group by pt.ID order by pl.name, td.FROM_TIME_UNIT";
	public static final String CHUNK_whereProgramWebPath = "prg.web_path = ?";
	public static final String CHUNK_whereTeamWebPath = "t.web_path = ?";
	public static final String CHUNK_wherePlayerWebPath = "pl.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="participantCampActivityCache") 
    public ParticipantCampActivityOutList execute (
		ParticipantCampActivityIn participantCampActivityIn
		) {
		ParticipantCampActivityOutList participantCampActivityOutList = new ParticipantCampActivityOutList();
		ParticipantCampActivityOutListWork work = new ParticipantCampActivityOutListWork (
			participantCampActivityIn
			);
        Session session = getSession();
        session.doWork(work);
		participantCampActivityOutList.setParticipantCampActivityOuts (work.getResult());
        return participantCampActivityOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(ParticipantCampActivityIn participantCampActivityIn) {
		if (participantCampActivityIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereTeamWebPathActive(ParticipantCampActivityIn participantCampActivityIn) {
		if (participantCampActivityIn.getTeamWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwherePlayerWebPathActive(ParticipantCampActivityIn participantCampActivityIn) {
		if (participantCampActivityIn.getPlayerWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			ParticipantCampActivityIn participantCampActivityIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( participantCampActivityIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(participantCampActivityIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereTeamWebPathActive( participantCampActivityIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereTeamWebPath", connectionWord + getChunkwhereTeamWebPath(participantCampActivityIn, CHUNK_whereTeamWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereTeamWebPath","");//replaceOnce
		}
		if (
			 isFilterwherePlayerWebPathActive( participantCampActivityIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"wherePlayerWebPath", connectionWord + getChunkwherePlayerWebPath(participantCampActivityIn, CHUNK_wherePlayerWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"wherePlayerWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (ParticipantCampActivityIn participantCampActivityIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereTeamWebPath (ParticipantCampActivityIn participantCampActivityIn, String chunk) {
		return chunk;
	}

	private String getChunkwherePlayerWebPath (ParticipantCampActivityIn participantCampActivityIn, String chunk) {
		return chunk;
	}
	
   private class ParticipantCampActivityOutListWork implements Work {
		ParticipantCampActivityIn participantCampActivityIn;
        ParticipantCampActivityOutListWork(
			ParticipantCampActivityIn participantCampActivityIn
			){
				this.participantCampActivityIn = participantCampActivityIn;
		}
		List<ParticipantCampActivityOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, ParticipantCampActivityIn participantCampActivityIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( participantCampActivityIn)) {
            if (participantCampActivityIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, participantCampActivityIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereTeamWebPathActive( participantCampActivityIn)) {
            if (participantCampActivityIn.getTeamWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, participantCampActivityIn.getTeamWebPath()); 
            }
            index ++;
			}
			if (isFilterwherePlayerWebPathActive( participantCampActivityIn)) {
            if (participantCampActivityIn.getPlayerWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, participantCampActivityIn.getPlayerWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						participantCampActivityIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, participantCampActivityIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						ParticipantCampActivityOut participantCampActivityOut = new ParticipantCampActivityOut();
						participantCampActivityOut.setProgramName(rs.getString("program_name"));
						participantCampActivityOut.setProgramWebPath(rs.getString("program_web_path"));
						participantCampActivityOut.setTeamName(rs.getString("team_name"));
						participantCampActivityOut.setTeamWebPath(rs.getString("team_web_path"));
						participantCampActivityOut.setTeamFromTime(rs.getInt("team_from_time"));
						participantCampActivityOut.setTeamToTime(rs.getString("team_to_time"));
						participantCampActivityOut.setPlayerName(rs.getString("player_name"));
						participantCampActivityOut.setPlayerWebPath(rs.getString("player_web_path"));
						participantCampActivityOut.setParticipantId(rs.getInt("participant_id"));
						participantCampActivityOut.setTeamPlayerEntranceType(rs.getString("team_player_entrance_type"));
						participantCampActivityOut.setTeamPlayerFromTime(rs.getInt("team_player_from_time"));
						participantCampActivityOut.setTeamPlayerDepartureType(rs.getString("team_player_departure_type"));
						participantCampActivityOut.setTeamPlayerToTime(rs.getInt("team_player_to_time"));
						String realisations = rs.getString("realisations");
						if (realisations != null) {
							participantCampActivityOut.setRealisations(
								Arrays.asList(realisations.split("\\,")).stream()
									.map(u -> {
										String[] uA = u.split("\\|");
										ParticipantCampActivityOut.Realisations c = participantCampActivityOut.new Realisations();
										if (uA.length==2) {
											c.setName(uA[0]);
											c.setWebPath(uA[1]);
										}
										return c;
									})
									.collect(Collectors.toList())
							);
						}
						list.add(participantCampActivityOut);
	        		}	        	}			}
       }

       List<ParticipantCampActivityOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}