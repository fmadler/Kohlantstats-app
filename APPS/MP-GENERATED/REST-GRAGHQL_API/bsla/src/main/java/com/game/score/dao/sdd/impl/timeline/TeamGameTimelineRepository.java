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
import com.game.score.sdd.out.timeline.TeamGameTimelineOutList;
import com.game.score.sdd.out.timeline.TeamGameTimelineOut;
import com.game.score.dao.sdd.face.timeline.TeamGameTimelineDaoFace;
import com.game.score.sdd.in.timeline.TeamGameTimelineIn;
/**
 *
 * <p>Title: TeamGameTimelineRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("teamGameTimelineDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class TeamGameTimelineRepository implements TeamGameTimelineDaoFace {

	public static final String QUERY_NATIVE = "select  	p.name program_name, 	p.web_path program_web_path,     t.name team_name,     t.WEB_PATH team_web_path,     g.name game_name, 	g.web_path game_web_path,     GROUP_CONCAT(distinct 				CONCAT_WS( 				'|', 				pl.WEB_PATH,                 pl.NAME,                 pxg.RANKING 				) 				order by pl.NAME 				) team_details, 	count(pl.WEB_PATH) nb_players,     xxx.nb_teams,     case when xxx.winner_team_id = t.id then 1 else 0 end is_winner,     xxx.winner_team_web_path,     xxx.winner_participant_web_paths, 	g.program_index program_index,     g.TIME_POSITION TIME_POSITION, 	gt.name game_type_name, 	gt.web_path game_type_web_path, 	gst.name game_stake_type_name, 	gst.web_path game_stake_type_web_path, 	gpt.name participation_type_name, 	gpt.web_path participation_type_web_path 	from gs_game g, gs_team t, gs_participant_x_game pxg, gs_game_type gt, gs_game_stake_type gst, gs_program p, gs_participant pa, gs_player pl, GS_GAME_PARTICIPATION_TYPE gpt, GS_GAME_ACTIVITY_TYPE gat 	, (      select   aaa.nb_teams nb_teams,  aaa.program_id,  aaa.game_id,  winner_team.team_id winner_team_id,  winner_team.team_web_path winner_team_web_path,  winner_participant.players winner_participant_web_paths  from   (    select count(distinct t.ID) nb_teams, p.ID program_id, g.PROGRAM_INDEX, g.id game_id  from  gs_team t, gs_game g, gs_participant_x_game pxg, gs_program p  where t.GS_PROGRAM_ID = p.ID and pxg.gs_team_id = t.id and pxg.GS_GAME_ID = g.ID  group by program_id, g.PROGRAM_INDEX  ) aaa,  (    select distinct t.ID team_id, t.WEB_PATH team_web_path, g.ID game_id, PROGRAM_INDEX  from  gs_team t, gs_game g, gs_participant_x_game pxg, gs_program p  where t.GS_PROGRAM_ID = p.ID and pxg.gs_team_id = t.id and pxg.GS_GAME_ID = g.ID  and pxg.ranking = 1  ) winner_team,   (    select         GROUP_CONCAT(distinct 				CONCAT_WS( 				'|', 				pl.WEB_PATH,                 pl.NAME 				) 				order by pl.NAME 				) players,    g.ID game_id, PROGRAM_INDEX  from  gs_participant pa, gs_player pl, gs_game g, gs_participant_x_game pxg  where pxg.GS_PARTICIPANT_ID = pa.id and pa.gs_player_id = pl.id and pxg.GS_GAME_ID = g.ID  and pxg.ranking = 1  group by g.id  ) winner_participant  where aaa.game_id = winner_team.game_id   and aaa.game_id = winner_participant.game_id     ) xxx     where 	pxg.GS_GAME_ID = g.ID and     pxg.GS_TEAM_ID = t.ID and 	pxg.GS_PARTICIPANT_ID = pa.ID and 	pa.GS_PROGRAM_ID = p.ID and 	g.GS_GAME_TYPE_ID = gt.id and  	g.GS_GAME_STAKE_TYPE_ID = gst.ID and 	pa.GS_PLAYER_ID = pl.ID and     pxg.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID and     pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID and      xxx.game_id = g.id     $whereProgramWebPath     $whereTeamWebPath      $whereParticipantWebPath     $whereGameWebPath     $whereGameTypeWebPath  group by team_web_path, program_index, game_web_path  order by p.name, program_index, t.name, g.name, pl.name";
	public static final String CHUNK_whereProgramWebPath = "p.web_path = ?";
	public static final String CHUNK_whereTeamWebPath = "t.web_path = ?";
	public static final String CHUNK_whereGameWebPath = "g.web_path = ?";
	public static final String CHUNK_whereGameTypeWebPath = "gt.web_path = ?";
	public static final String CHUNK_whereParticipantWebPath = "pl.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="teamGameTimelineCache") 
    public TeamGameTimelineOutList execute (
		TeamGameTimelineIn teamGameTimelineIn
		) {
		TeamGameTimelineOutList teamGameTimelineOutList = new TeamGameTimelineOutList();
		TeamGameTimelineOutListWork work = new TeamGameTimelineOutListWork (
			teamGameTimelineIn
			);
        Session session = getSession();
        session.doWork(work);
		teamGameTimelineOutList.setTeamGameTimelineOuts (work.getResult());
        return teamGameTimelineOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(TeamGameTimelineIn teamGameTimelineIn) {
		if (teamGameTimelineIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereTeamWebPathActive(TeamGameTimelineIn teamGameTimelineIn) {
		if (teamGameTimelineIn.getTeamWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameWebPathActive(TeamGameTimelineIn teamGameTimelineIn) {
		if (teamGameTimelineIn.getGameWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameTypeWebPathActive(TeamGameTimelineIn teamGameTimelineIn) {
		if (teamGameTimelineIn.getGameTypeWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereParticipantWebPathActive(TeamGameTimelineIn teamGameTimelineIn) {
		if (teamGameTimelineIn.getPlayerWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			TeamGameTimelineIn teamGameTimelineIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( teamGameTimelineIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(teamGameTimelineIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereTeamWebPathActive( teamGameTimelineIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereTeamWebPath", connectionWord + getChunkwhereTeamWebPath(teamGameTimelineIn, CHUNK_whereTeamWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereTeamWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameWebPathActive( teamGameTimelineIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameWebPath", connectionWord + getChunkwhereGameWebPath(teamGameTimelineIn, CHUNK_whereGameWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameTypeWebPathActive( teamGameTimelineIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameTypeWebPath", connectionWord + getChunkwhereGameTypeWebPath(teamGameTimelineIn, CHUNK_whereGameTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameTypeWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereParticipantWebPathActive( teamGameTimelineIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereParticipantWebPath", connectionWord + getChunkwhereParticipantWebPath(teamGameTimelineIn, CHUNK_whereParticipantWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereParticipantWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (TeamGameTimelineIn teamGameTimelineIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereTeamWebPath (TeamGameTimelineIn teamGameTimelineIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameWebPath (TeamGameTimelineIn teamGameTimelineIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameTypeWebPath (TeamGameTimelineIn teamGameTimelineIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereParticipantWebPath (TeamGameTimelineIn teamGameTimelineIn, String chunk) {
		return chunk;
	}
	
   private class TeamGameTimelineOutListWork implements Work {
		TeamGameTimelineIn teamGameTimelineIn;
        TeamGameTimelineOutListWork(
			TeamGameTimelineIn teamGameTimelineIn
			){
				this.teamGameTimelineIn = teamGameTimelineIn;
		}
		List<TeamGameTimelineOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, TeamGameTimelineIn teamGameTimelineIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( teamGameTimelineIn)) {
            if (teamGameTimelineIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, teamGameTimelineIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereTeamWebPathActive( teamGameTimelineIn)) {
            if (teamGameTimelineIn.getTeamWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, teamGameTimelineIn.getTeamWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameWebPathActive( teamGameTimelineIn)) {
            if (teamGameTimelineIn.getGameWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, teamGameTimelineIn.getGameWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameTypeWebPathActive( teamGameTimelineIn)) {
            if (teamGameTimelineIn.getGameTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, teamGameTimelineIn.getGameTypeWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereParticipantWebPathActive( teamGameTimelineIn)) {
            if (teamGameTimelineIn.getPlayerWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, teamGameTimelineIn.getPlayerWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						teamGameTimelineIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, teamGameTimelineIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						TeamGameTimelineOut teamGameTimelineOut = new TeamGameTimelineOut();
						teamGameTimelineOut.setProgramName(rs.getString("program_name"));
						teamGameTimelineOut.setProgramWebPath(rs.getString("program_web_path"));
						teamGameTimelineOut.setTeamName(rs.getString("team_name"));
						teamGameTimelineOut.setTeamWebPath(rs.getString("team_web_path"));
						teamGameTimelineOut.setGameName(rs.getString("game_name"));
						teamGameTimelineOut.setGameWebPath(rs.getString("game_web_path"));
						String teamDetails = rs.getString("team_details");
						if (teamDetails != null) {
							teamGameTimelineOut.setTeamDetails(
								Arrays.asList(teamDetails.split("\\,")).stream()
									.map(u -> {
										String[] uA = u.split("\\|");
										TeamGameTimelineOut.TeamDetails c = teamGameTimelineOut.new TeamDetails();
										if (uA.length==3) {
											c.setParticipantWebPath(uA[0]);
											c.setParticipantName(uA[1]);
											c.setRanking(uA[2]);
										}
										return c;
									})
									.collect(Collectors.toList())
							);
						}
						teamGameTimelineOut.setNbPlayers(rs.getLong("nb_players"));
						teamGameTimelineOut.setNbTeams(rs.getLong("nb_teams"));
						teamGameTimelineOut.setIsWinner(rs.getLong("is_winner"));
						teamGameTimelineOut.setWinnerTeamWebPath(rs.getString("winner_team_web_path"));
						String winnerParticipantWebPaths = rs.getString("winner_participant_web_paths");
						if (winnerParticipantWebPaths != null) {
							teamGameTimelineOut.setWinnerParticipantWebPaths(
								Arrays.asList(winnerParticipantWebPaths.split("\\,")).stream()
									.map(u -> {
										String[] uA = u.split("\\|");
										TeamGameTimelineOut.WinnerParticipantWebPaths c = teamGameTimelineOut.new WinnerParticipantWebPaths();
										if (uA.length==2) {
											c.setParticipantWebPath(uA[0]);
											c.setParticipantName(uA[1]);
										}
										return c;
									})
									.collect(Collectors.toList())
							);
						}
						teamGameTimelineOut.setProgramIndex(rs.getInt("program_index"));
						teamGameTimelineOut.setTimePosition(rs.getString("TIME_POSITION"));
						teamGameTimelineOut.setGameTypeName(rs.getString("game_type_name"));
						teamGameTimelineOut.setGameTypeWebPath(rs.getString("game_type_web_path"));
						teamGameTimelineOut.setGameStakeTypeName(rs.getString("game_stake_type_name"));
						teamGameTimelineOut.setGameStakeTypeWebPath(rs.getString("game_stake_type_web_path"));
						teamGameTimelineOut.setParticipationTypeName(rs.getString("participation_type_name"));
						teamGameTimelineOut.setParticipationTypeWebPath(rs.getString("participation_type_web_path"));
						list.add(teamGameTimelineOut);
	        		}	        	}			}
       }

       List<TeamGameTimelineOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}