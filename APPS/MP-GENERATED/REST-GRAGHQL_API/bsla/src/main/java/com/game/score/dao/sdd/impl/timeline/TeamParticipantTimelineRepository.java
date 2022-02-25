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
import com.game.score.sdd.out.timeline.TeamParticipantTimelineOutList;
import com.game.score.sdd.out.timeline.TeamParticipantTimelineOut;
import com.game.score.dao.sdd.face.timeline.TeamParticipantTimelineDaoFace;
import com.game.score.sdd.in.timeline.TeamParticipantTimelineIn;
/**
 *
 * <p>Title: TeamParticipantTimelineRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("teamParticipantTimelineDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class TeamParticipantTimelineRepository implements TeamParticipantTimelineDaoFace {

	public static final String QUERY_NATIVE = "select  * from ( select   	pxt.id,     pr.WEB_PATH program_web_path, 	t.name team_name, 	t.web_path team_web_path, 	td.FROM_TIME_UNIT team_from_time,     td.TO_TIME_UNIT team_to_time,     pxt.FROM_TIME_UNIT time_unit,     pl.NAME participant_name,     pl.WEB_PATH participant_web_path, 	'entrance' event_type,     tet.NAME event_type_name,     tet.WEB_PATH event_type_web_path from  	gs_team t,     gs_program pr, 	gs_team_duration td,     gs_participant_team pxt,     gs_participant p,     gs_player pl,     gs_team_entrance_type tet where 	pxt.GS_PARTICIPANT_ID = p.ID and     t.GS_PROGRAM_ID = pr.id and     t.GS_TEAM_DURATION_ID= td.ID and     pxt.GS_TEAM_ID = t.ID and 	p.GS_PLAYER_ID = pl.ID and     pxt.GS_TEAM_ENTRANCE_TYPE_ID = tet.ID  union select   	pxt.id,     pr.WEB_PATH program_web_path, 	t.name team_name, 	t.web_path team_web_path,     td.FROM_TIME_UNIT team_from_time,     td.TO_TIME_UNIT team_to_time,     pxt.TO_TIME_UNIT time_unit,     pl.NAME participant_name,     pl.WEB_PATH participant_web_path, 	'departure' event_type,     tdt.NAME event_type_name,     tdt.WEB_PATH event_type_web_path from  	gs_team t,     gs_program pr,     gs_team_duration td,     gs_participant_team pxt,     gs_participant p,     gs_player pl,     gs_team_departure_type tdt where 	pxt.GS_PARTICIPANT_ID = p.ID and     t.GS_PROGRAM_ID = pr.id and     t.GS_TEAM_DURATION_ID= td.ID and     pxt.GS_TEAM_ID = t.ID and 	p.GS_PLAYER_ID = pl.ID and     pxt.GS_TEAM_DEPARTURE_TYPE_ID = tdt.ID           ) xx     $whereProgramWebPath     $whereTeamWebPath     $whereParticipantWebPath order by time_unit asc";
	public static final String CHUNK_whereProgramWebPath = "xx.program_web_path = ?";
	public static final String CHUNK_whereTeamWebPath = "xx.team_web_path = ?";
	public static final String CHUNK_whereParticipantWebPath = "xx.participant_web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="teamParticipantTimelineCache") 
    public TeamParticipantTimelineOutList execute (
		TeamParticipantTimelineIn teamParticipantTimelineIn
		) {
		TeamParticipantTimelineOutList teamParticipantTimelineOutList = new TeamParticipantTimelineOutList();
		TeamParticipantTimelineOutListWork work = new TeamParticipantTimelineOutListWork (
			teamParticipantTimelineIn
			);
        Session session = getSession();
        session.doWork(work);
		teamParticipantTimelineOutList.setTeamParticipantTimelineOuts (work.getResult());
        return teamParticipantTimelineOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(TeamParticipantTimelineIn teamParticipantTimelineIn) {
		if (teamParticipantTimelineIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereTeamWebPathActive(TeamParticipantTimelineIn teamParticipantTimelineIn) {
		if (teamParticipantTimelineIn.getTeamWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereParticipantWebPathActive(TeamParticipantTimelineIn teamParticipantTimelineIn) {
		if (teamParticipantTimelineIn.getPlayerWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			TeamParticipantTimelineIn teamParticipantTimelineIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( teamParticipantTimelineIn)			) {
			String connectionWord = " AND ";
			if (!isWhereDone) {
				connectionWord = " WHERE ";
			}
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(teamParticipantTimelineIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereTeamWebPathActive( teamParticipantTimelineIn)			) {
			String connectionWord = " AND ";
			if (!isWhereDone) {
				connectionWord = " WHERE ";
			}
			query = StringUtils.replace (query, "$"+"whereTeamWebPath", connectionWord + getChunkwhereTeamWebPath(teamParticipantTimelineIn, CHUNK_whereTeamWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereTeamWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereParticipantWebPathActive( teamParticipantTimelineIn)			) {
			String connectionWord = " AND ";
			if (!isWhereDone) {
				connectionWord = " WHERE ";
			}
			query = StringUtils.replace (query, "$"+"whereParticipantWebPath", connectionWord + getChunkwhereParticipantWebPath(teamParticipantTimelineIn, CHUNK_whereParticipantWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereParticipantWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (TeamParticipantTimelineIn teamParticipantTimelineIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereTeamWebPath (TeamParticipantTimelineIn teamParticipantTimelineIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereParticipantWebPath (TeamParticipantTimelineIn teamParticipantTimelineIn, String chunk) {
		return chunk;
	}
	
   private class TeamParticipantTimelineOutListWork implements Work {
		TeamParticipantTimelineIn teamParticipantTimelineIn;
        TeamParticipantTimelineOutListWork(
			TeamParticipantTimelineIn teamParticipantTimelineIn
			){
				this.teamParticipantTimelineIn = teamParticipantTimelineIn;
		}
		List<TeamParticipantTimelineOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, TeamParticipantTimelineIn teamParticipantTimelineIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( teamParticipantTimelineIn)) {
            if (teamParticipantTimelineIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, teamParticipantTimelineIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereTeamWebPathActive( teamParticipantTimelineIn)) {
            if (teamParticipantTimelineIn.getTeamWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, teamParticipantTimelineIn.getTeamWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereParticipantWebPathActive( teamParticipantTimelineIn)) {
            if (teamParticipantTimelineIn.getPlayerWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, teamParticipantTimelineIn.getPlayerWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						teamParticipantTimelineIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, teamParticipantTimelineIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						TeamParticipantTimelineOut teamParticipantTimelineOut = new TeamParticipantTimelineOut();
						teamParticipantTimelineOut.setId(rs.getInt("id"));
						teamParticipantTimelineOut.setProgramWebPath(rs.getString("program_web_path"));
						teamParticipantTimelineOut.setTeamName(rs.getString("team_name"));
						teamParticipantTimelineOut.setTeamWebPath(rs.getString("team_web_path"));
						teamParticipantTimelineOut.setTeamFromTime(rs.getInt("team_from_time"));
						teamParticipantTimelineOut.setTeamToTime(rs.getString("team_to_time"));
						teamParticipantTimelineOut.setTimeUnit(rs.getInt("time_unit"));
						teamParticipantTimelineOut.setParticipantName(rs.getString("participant_name"));
						teamParticipantTimelineOut.setParticipantWebPath(rs.getString("participant_web_path"));
						teamParticipantTimelineOut.setEventType(rs.getString("event_type"));
						teamParticipantTimelineOut.setEventTypeName(rs.getString("event_type_name"));
						teamParticipantTimelineOut.setEventTypeWebPath(rs.getString("event_type_web_path"));
						list.add(teamParticipantTimelineOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<TeamParticipantTimelineOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}