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
import com.game.score.sdd.out.participant.ParticipantGameActivityOutList;
import com.game.score.sdd.out.participant.ParticipantGameActivityOut;
import com.game.score.dao.sdd.face.participant.ParticipantGameActivityDaoFace;
import com.game.score.sdd.in.participant.ParticipantGameActivityIn;
/**
 *
 * <p>Title: ParticipantGameActivityRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("participantGameActivityDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class ParticipantGameActivityRepository implements ParticipantGameActivityDaoFace {

	public static final String QUERY_NATIVE = "select * from ( select 	pl.name player_name,      pl.web_path player_web_path,     g.name game_name,     g.web_path game_web_path,     t.name team_name,     t.WEB_PATH team_web_path, 	g.time_position,     g.TIME_UNIT_INDEX,     gpt.name participation_type,     gpt.web_path participation_type_web_path,     gat.name activity_type,     gat.web_path activity_type_web_path,     pxg.ranking ranking, 	case when gpt.web_path = 'individuel' and ranking = 1 then nb_register_participants when gpt.web_path = 'individuel' and ranking = 2 then (nb_register_participants-2)/2 else 0 end as score,     case when pxg.ranking = 0 then 99 else pxg.ranking end as display_order_asc,     gt.name game_type_name,     gt.WEB_PATH game_type_web_path,     gst.name game_stake_type_name,     gst.WEB_PATH game_stake_type_web_path, 	GROUP_CONCAT(distinct 			CONCAT_WS( 			'|', 			r.name,             r.web_path,             r.is_positive 			) 			order by ggxr.DISPLAY_ORDER 			) rewards, 	GROUP_CONCAT(distinct 			CONCAT_WS( 			'|', 			r2.name,             r2.web_path,             r2.is_positive 			) 			order by gxr.DISPLAY_ORDER 			) game_rewards 	,GROUP_CONCAT(distinct 			CONCAT_WS( 			'|', 			x.name,             x.web_path 			) 			order by x.DISPLAY_ORDER 			) game_tags              from GS_PARTICIPANT_X_GAME pxg  		left outer join GS_PARTICIPANT_GAME_X_REWARD ggxr on ggxr.GS_PARTICIPANT_X_GAME_ID = pxg.ID         left outer join GS_REWARD r on ggxr.GS_REWARD_ID = r.ID, 	gs_program pr,      gs_player pl,      gs_participant pa,      gs_team t,      gs_game g  		left outer join GS_GAME_X_REWARD gxr on gxr.GS_GAME_ID = g.ID         left outer join GS_REWARD r2 on gxr.GS_REWARD_ID = r2.ID         left outer join ( 			select GS_GAME_ID, DISPLAY_ORDER, gta.NAME, gta.WEB_PATH 			from GS_GAME_X_TAG gxt,  GS_GAME_TAG gta where gxt.GS_GAME_TAG_ID = gta.ID             ) x on x.GS_GAME_ID = g.ID, 	( 		select g.id game_id, count(*) nb_register_participants 		from gs_game g, gs_participant_x_game pxg, gs_game_activity_type gat 		where 		pxg.GS_GAME_ID = g.ID and pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID and gat.WEB_PATH = 'participant' 		group by g.id 	) aaa,     GS_GAME_PARTICIPATION_TYPE gpt,      GS_GAME_ACTIVITY_TYPE gat,     GS_GAME_STAKE_TYPE gst,     GS_GAME_TYPE gt where 	pxg.GS_Participant_id = pa.ID and     pxg.GS_GAME_ID = g.ID and     pxg.GS_TEAM_ID = t.ID and     pxg.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID and     pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID and 	pa.GS_PROGRAM_ID = pr.ID and  	pa.GS_PLAYER_ID = pl.ID and     g.GS_GAME_STAKE_TYPE_ID = gst.ID and     g.GS_GAME_TYPE_ID = gt.ID and 	aaa.game_id = g.ID     $whereProgramWebPath     $wherePlayerWebPath     $whereGameWebPath group by pxg.ID ) xx where 1 = 1 $whereGameTagWebPath $whereRewardWebPath order by TIME_UNIT_INDEX, display_order_asc asc";
	public static final String CHUNK_whereProgramWebPath = "pr.web_path = ?";
	public static final String CHUNK_wherePlayerWebPath = "pl.web_path = ?";
	public static final String CHUNK_whereGameWebPath = "g.web_path = ?";
	public static final String CHUNK_whereGameTagWebPath = "xx.game_tags like ?";
	public static final String CHUNK_whereRewardWebPath = "xx.game_rewards like ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="participantGameActivityCache") 
    public ParticipantGameActivityOutList execute (
		ParticipantGameActivityIn participantGameActivityIn
		) {
		ParticipantGameActivityOutList participantGameActivityOutList = new ParticipantGameActivityOutList();
		ParticipantGameActivityOutListWork work = new ParticipantGameActivityOutListWork (
			participantGameActivityIn
			);
        Session session = getSession();
        session.doWork(work);
		participantGameActivityOutList.setParticipantGameActivityOuts (work.getResult());
        return participantGameActivityOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(ParticipantGameActivityIn participantGameActivityIn) {
		if (participantGameActivityIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwherePlayerWebPathActive(ParticipantGameActivityIn participantGameActivityIn) {
		if (participantGameActivityIn.getPlayerWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameWebPathActive(ParticipantGameActivityIn participantGameActivityIn) {
		if (participantGameActivityIn.getGameWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameTagWebPathActive(ParticipantGameActivityIn participantGameActivityIn) {
		if (participantGameActivityIn.getGameTagWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereRewardWebPathActive(ParticipantGameActivityIn participantGameActivityIn) {
		if (participantGameActivityIn.getRewardWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			ParticipantGameActivityIn participantGameActivityIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( participantGameActivityIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(participantGameActivityIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwherePlayerWebPathActive( participantGameActivityIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"wherePlayerWebPath", connectionWord + getChunkwherePlayerWebPath(participantGameActivityIn, CHUNK_wherePlayerWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"wherePlayerWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameWebPathActive( participantGameActivityIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameWebPath", connectionWord + getChunkwhereGameWebPath(participantGameActivityIn, CHUNK_whereGameWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameTagWebPathActive( participantGameActivityIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameTagWebPath", connectionWord + getChunkwhereGameTagWebPath(participantGameActivityIn, CHUNK_whereGameTagWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameTagWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereRewardWebPathActive( participantGameActivityIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereRewardWebPath", connectionWord + getChunkwhereRewardWebPath(participantGameActivityIn, CHUNK_whereRewardWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereRewardWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (ParticipantGameActivityIn participantGameActivityIn, String chunk) {
		return chunk;
	}

	private String getChunkwherePlayerWebPath (ParticipantGameActivityIn participantGameActivityIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameWebPath (ParticipantGameActivityIn participantGameActivityIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameTagWebPath (ParticipantGameActivityIn participantGameActivityIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereRewardWebPath (ParticipantGameActivityIn participantGameActivityIn, String chunk) {
		return chunk;
	}
	
   private class ParticipantGameActivityOutListWork implements Work {
		ParticipantGameActivityIn participantGameActivityIn;
        ParticipantGameActivityOutListWork(
			ParticipantGameActivityIn participantGameActivityIn
			){
				this.participantGameActivityIn = participantGameActivityIn;
		}
		List<ParticipantGameActivityOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, ParticipantGameActivityIn participantGameActivityIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( participantGameActivityIn)) {
            if (participantGameActivityIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, participantGameActivityIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwherePlayerWebPathActive( participantGameActivityIn)) {
            if (participantGameActivityIn.getPlayerWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, participantGameActivityIn.getPlayerWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameWebPathActive( participantGameActivityIn)) {
            if (participantGameActivityIn.getGameWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, participantGameActivityIn.getGameWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameTagWebPathActive( participantGameActivityIn)) {
            if (participantGameActivityIn.getGameTagWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               String var = "%" + participantGameActivityIn.getGameTagWebPath() + "%";
               pstmt.setString(index, var); 
            }
            index ++;
			}
			if (isFilterwhereRewardWebPathActive( participantGameActivityIn)) {
            if (participantGameActivityIn.getRewardWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               String var = "%" + participantGameActivityIn.getRewardWebPath() + "%";
               pstmt.setString(index, var); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						participantGameActivityIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, participantGameActivityIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						ParticipantGameActivityOut participantGameActivityOut = new ParticipantGameActivityOut();
						participantGameActivityOut.setPlayerName(rs.getString("player_name"));
						participantGameActivityOut.setPlayerWebPath(rs.getString("player_web_path"));
						participantGameActivityOut.setGameName(rs.getString("game_name"));
						participantGameActivityOut.setGameWebPath(rs.getString("game_web_path"));
						participantGameActivityOut.setTeamName(rs.getString("team_name"));
						participantGameActivityOut.setTeamWebPath(rs.getString("team_web_path"));
						participantGameActivityOut.setTimePosition(rs.getString("time_position"));
						participantGameActivityOut.setTimeUnitIndex(rs.getInt("TIME_UNIT_INDEX"));
						participantGameActivityOut.setParticipationType(rs.getString("participation_type"));
						participantGameActivityOut.setParticipationTypeWebPath(rs.getString("participation_type_web_path"));
						participantGameActivityOut.setActivityType(rs.getString("activity_type"));
						participantGameActivityOut.setActivityTypeWebPath(rs.getString("activity_type_web_path"));
						participantGameActivityOut.setRanking(rs.getInt("ranking"));
						participantGameActivityOut.setScore(rs.getBigDecimal("score"));
						participantGameActivityOut.setDisplayOrderAsc(rs.getLong("display_order_asc"));
						participantGameActivityOut.setGameTypeName(rs.getString("game_type_name"));
						participantGameActivityOut.setGameTypeWebPath(rs.getString("game_type_web_path"));
						participantGameActivityOut.setGameStakeTypeName(rs.getString("game_stake_type_name"));
						participantGameActivityOut.setGameStakeTypeWebPath(rs.getString("game_stake_type_web_path"));
						String rewards = rs.getString("rewards");
						if (rewards != null) {
							participantGameActivityOut.setRewards(
								Arrays.asList(rewards.split("\\,")).stream()
									.map(u -> {
										String[] uA = u.split("\\|");
										ParticipantGameActivityOut.Rewards c = participantGameActivityOut.new Rewards();
										if (uA.length==3) {
											c.setName(uA[0]);
											c.setWebPath(uA[1]);
											c.setIsPositive(uA[2]);
										}
										return c;
									})
									.collect(Collectors.toList())
							);
						}
						String gameRewards = rs.getString("game_rewards");
						if (gameRewards != null) {
							participantGameActivityOut.setGameRewards(
								Arrays.asList(gameRewards.split("\\,")).stream()
									.map(u -> {
										String[] uA = u.split("\\|");
										ParticipantGameActivityOut.GameRewards c = participantGameActivityOut.new GameRewards();
										if (uA.length==3) {
											c.setName(uA[0]);
											c.setWebPath(uA[1]);
											c.setIsPositive(uA[2]);
										}
										return c;
									})
									.collect(Collectors.toList())
							);
						}
						String gameTags = rs.getString("game_tags");
						if (gameTags != null) {
							participantGameActivityOut.setGameTags(
								Arrays.asList(gameTags.split("\\,")).stream()
									.map(u -> {
										String[] uA = u.split("\\|");
										ParticipantGameActivityOut.GameTags c = participantGameActivityOut.new GameTags();
										if (uA.length==2) {
											c.setName(uA[0]);
											c.setWebPath(uA[1]);
										}
										return c;
									})
									.collect(Collectors.toList())
							);
						}
						list.add(participantGameActivityOut);
	        		}	        	}			}
       }

       List<ParticipantGameActivityOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}