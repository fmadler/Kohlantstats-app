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
package com.game.score.dao.sdd.impl.info;



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
import com.game.score.sdd.out.info.TeamInfoOutList;
import com.game.score.sdd.out.info.TeamInfoOut;
import com.game.score.dao.sdd.face.info.TeamInfoDaoFace;
import com.game.score.sdd.in.info.TeamInfoIn;
/**
 *
 * <p>Title: TeamInfoRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("teamInfoDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class TeamInfoRepository implements TeamInfoDaoFace {

	public static final String QUERY_NATIVE = "select p.name program_name, p.web_path program_web_path, 	t.name, t.web_path, t.alias, td.from_time_unit, td.to_time_unit, 	beginners.nb nb_of_beginners, 	enders.nb nb_of_enders  from  	gs_program p,  	gs_team_duration td,  	gs_team t left outer join (  		select count(*) nb, pt.gs_team_id team_id  		from gs_participant_team pt, gs_team t, gs_team_duration td  		where pt.gs_team_id = t.id  			and t.gs_team_duration_id = td.id  			and pt.from_time_unit = td.from_time_unit  		group by pt.gs_team_id  	) beginners on beginners.team_id = t.id  	left outer join (  		select count(*) nb, pt.gs_team_id team_id  		from gs_participant_team pt, gs_team t, gs_team_duration td  		where pt.gs_team_id = t.id  			and t.gs_team_duration_id = td.id  			and pt.to_time_unit = td.to_time_unit  		group by pt.gs_team_id  	) enders on enders.team_id = t.id where 	t.GS_PROGRAM_ID = p.ID and t.gs_team_duration_id = td.id $whereProgramWebPath $whereTeamWebPath ORDER by edition_number asc";
	public static final String CHUNK_whereProgramWebPath = "p.web_path = ?";
	public static final String CHUNK_whereTeamWebPath = "t.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="teamInfoCache") 
    public TeamInfoOutList execute (
		TeamInfoIn teamInfoIn
		) {
		TeamInfoOutList teamInfoOutList = new TeamInfoOutList();
		TeamInfoOutListWork work = new TeamInfoOutListWork (
			teamInfoIn
			);
        Session session = getSession();
        session.doWork(work);
		teamInfoOutList.setTeamInfoOuts (work.getResult());
        return teamInfoOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(TeamInfoIn teamInfoIn) {
		if (teamInfoIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereTeamWebPathActive(TeamInfoIn teamInfoIn) {
		if (teamInfoIn.getTeamWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			TeamInfoIn teamInfoIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( teamInfoIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(teamInfoIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereTeamWebPathActive( teamInfoIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereTeamWebPath", connectionWord + getChunkwhereTeamWebPath(teamInfoIn, CHUNK_whereTeamWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereTeamWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (TeamInfoIn teamInfoIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereTeamWebPath (TeamInfoIn teamInfoIn, String chunk) {
		return chunk;
	}
	
   private class TeamInfoOutListWork implements Work {
		TeamInfoIn teamInfoIn;
        TeamInfoOutListWork(
			TeamInfoIn teamInfoIn
			){
				this.teamInfoIn = teamInfoIn;
		}
		List<TeamInfoOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, TeamInfoIn teamInfoIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( teamInfoIn)) {
            if (teamInfoIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, teamInfoIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereTeamWebPathActive( teamInfoIn)) {
            if (teamInfoIn.getTeamWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, teamInfoIn.getTeamWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						teamInfoIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, teamInfoIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						TeamInfoOut teamInfoOut = new TeamInfoOut();
						teamInfoOut.setProgramName(rs.getString("program_name"));
						teamInfoOut.setProgramWebPath(rs.getString("program_web_path"));
						teamInfoOut.setName(rs.getString("name"));
						teamInfoOut.setWebPath(rs.getString("web_path"));
						teamInfoOut.setAlias(rs.getString("alias"));
						teamInfoOut.setFromTimeUnit(rs.getInt("from_time_unit"));
						teamInfoOut.setToTimeUnit(rs.getString("to_time_unit"));
						teamInfoOut.setNbOfBeginners(rs.getLong("nb_of_beginners"));
						teamInfoOut.setNbOfEnders(rs.getLong("nb_of_enders"));
						list.add(teamInfoOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<TeamInfoOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}