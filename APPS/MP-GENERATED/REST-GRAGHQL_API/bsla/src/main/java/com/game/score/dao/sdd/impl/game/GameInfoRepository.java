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
package com.game.score.dao.sdd.impl.game;



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
import com.game.score.sdd.out.game.GameInfoOutList;
import com.game.score.sdd.out.game.GameInfoOut;
import com.game.score.dao.sdd.face.game.GameInfoDaoFace;
import com.game.score.sdd.in.game.GameInfoIn;
/**
 *
 * <p>Title: GameInfoRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("gameInfoDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class GameInfoRepository implements GameInfoDaoFace {

	public static final String QUERY_NATIVE = "select * from ( 	select 	pr.name program, 	pr.web_path program_web_path, 	pr.edition_number, 	g.name game_name, 	g.web_path game_web_path, 	g.time_position, 	g.TIME_UNIT_INDEX, 	gt.name game_type_name, 	gt.WEB_PATH game_type_web_path, 	gst.name game_stake_type_name, 	gst.WEB_PATH game_stake_type_web_path, 	gpt.NAME game_participation_type_name, 	gpt.WEB_PATH game_participation_type_web_path, 	GROUP_CONCAT(distinct 		CONCAT_WS( 		'|', 		r2.name, 		r2.web_path, 		r2.is_positive 		) 		order by gxr.DISPLAY_ORDER 		) game_rewards, 	GROUP_CONCAT(distinct 		CONCAT_WS( 		'|', 		w.name, 		w.web_path, 		w.game_activity_type_web_path, 		w.game_activity_type_name 		) 		order by w.name 		) winners 	,GROUP_CONCAT(distinct 		CONCAT_WS( 		'|', 		x.name, 		x.web_path 		) 		order by x.DISPLAY_ORDER 		) game_tags 	from 		gs_program pr, 		gs_game g 			left outer join ( 				select GS_GAME_ID, pl.NAME, pl.WEB_PATH, gat.WEB_PATH game_activity_type_web_path, gat.NAME game_activity_type_name 					from GS_PARTICIPANT_X_GAME pxg, 					GS_GAME_ACTIVITY_TYPE gat, 					GS_PARTICIPANT pa, 					GS_PLAYER pl 				where 					pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID and 					pxg.GS_PARTICIPANT_ID = pa.ID and 					pa.GS_PLAYER_ID = pl.ID and 					pxg.ranking = 1 				) w on w.GS_GAME_ID = g.ID 			left outer join GS_GAME_X_REWARD gxr on gxr.GS_GAME_ID = g.ID 			left outer join GS_REWARD r2 on gxr.GS_REWARD_ID = r2.ID 			left outer join ( 			select GS_GAME_ID, DISPLAY_ORDER, gta.NAME, gta.WEB_PATH from GS_GAME_X_TAG gxt,  GS_GAME_TAG gta where gxt.GS_GAME_TAG_ID = gta.ID 			) x on x.GS_GAME_ID = g.ID, 		( 			select g.id game_id, count(*) nb_register_participants 			from gs_game g, gs_participant_x_game pxg, gs_game_activity_type gat 			where 			pxg.GS_GAME_ID = g.ID and pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID and gat.WEB_PATH = 'participant' 			group by g.id 		) aaa, 		GS_GAME_STAKE_TYPE gst, 		GS_GAME_TYPE gt, 		GS_GAME_PARTICIPATION_TYPE gpt 	where 		g.gs_program_id = pr.id and 		g.GS_GAME_STAKE_TYPE_ID = gst.ID and 		g.GS_GAME_TYPE_ID = gt.ID and 		g.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID and 		g.ID = aaa.game_id 		$whereProgramWebPath 		$whereGameWebPath 		group by g.web_path 		) xx 	where 1 = 1 	$whereGameTagWebPath 	$whereRewardWebPath 	order by edition_number, TIME_UNIT_INDEX";
	public static final String CHUNK_whereProgramWebPath = "pr.web_path = ?";
	public static final String CHUNK_whereGameWebPath = "g.web_path = ?";
	public static final String CHUNK_whereGameTagWebPath = "xx.game_tags like ?";
	public static final String CHUNK_whereRewardWebPath = "xx.game_rewards like ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="gameInfoCache") 
    public GameInfoOutList execute (
		GameInfoIn gameInfoIn
		) {
		GameInfoOutList gameInfoOutList = new GameInfoOutList();
		GameInfoOutListWork work = new GameInfoOutListWork (
			gameInfoIn
			);
        Session session = getSession();
        session.doWork(work);
		gameInfoOutList.setGameInfoOuts (work.getResult());
        return gameInfoOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(GameInfoIn gameInfoIn) {
		if (gameInfoIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameWebPathActive(GameInfoIn gameInfoIn) {
		if (gameInfoIn.getGameWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameTagWebPathActive(GameInfoIn gameInfoIn) {
		if (gameInfoIn.getGameTagWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereRewardWebPathActive(GameInfoIn gameInfoIn) {
		if (gameInfoIn.getRewardWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			GameInfoIn gameInfoIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( gameInfoIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(gameInfoIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameWebPathActive( gameInfoIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameWebPath", connectionWord + getChunkwhereGameWebPath(gameInfoIn, CHUNK_whereGameWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameTagWebPathActive( gameInfoIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameTagWebPath", connectionWord + getChunkwhereGameTagWebPath(gameInfoIn, CHUNK_whereGameTagWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameTagWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereRewardWebPathActive( gameInfoIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereRewardWebPath", connectionWord + getChunkwhereRewardWebPath(gameInfoIn, CHUNK_whereRewardWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereRewardWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (GameInfoIn gameInfoIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameWebPath (GameInfoIn gameInfoIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameTagWebPath (GameInfoIn gameInfoIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereRewardWebPath (GameInfoIn gameInfoIn, String chunk) {
		return chunk;
	}
	
   private class GameInfoOutListWork implements Work {
		GameInfoIn gameInfoIn;
        GameInfoOutListWork(
			GameInfoIn gameInfoIn
			){
				this.gameInfoIn = gameInfoIn;
		}
		List<GameInfoOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, GameInfoIn gameInfoIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( gameInfoIn)) {
            if (gameInfoIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, gameInfoIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameWebPathActive( gameInfoIn)) {
            if (gameInfoIn.getGameWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, gameInfoIn.getGameWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameTagWebPathActive( gameInfoIn)) {
            if (gameInfoIn.getGameTagWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               String var = "%" + gameInfoIn.getGameTagWebPath() + "%";
               pstmt.setString(index, var); 
            }
            index ++;
			}
			if (isFilterwhereRewardWebPathActive( gameInfoIn)) {
            if (gameInfoIn.getRewardWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               String var = "%" + gameInfoIn.getRewardWebPath() + "%";
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
						gameInfoIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, gameInfoIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						GameInfoOut gameInfoOut = new GameInfoOut();
						gameInfoOut.setProgram(rs.getString("program"));
						gameInfoOut.setProgramWebPath(rs.getString("program_web_path"));
						gameInfoOut.setEditionNumber(rs.getInt("edition_number"));
						gameInfoOut.setGameName(rs.getString("game_name"));
						gameInfoOut.setGameWebPath(rs.getString("game_web_path"));
						gameInfoOut.setTimePosition(rs.getString("time_position"));
						gameInfoOut.setTimeUnitIndex(rs.getInt("TIME_UNIT_INDEX"));
						gameInfoOut.setGameTypeName(rs.getString("game_type_name"));
						gameInfoOut.setGameTypeWebPath(rs.getString("game_type_web_path"));
						gameInfoOut.setGameStakeTypeName(rs.getString("game_stake_type_name"));
						gameInfoOut.setGameStakeTypeWebPath(rs.getString("game_stake_type_web_path"));
						gameInfoOut.setGameParticipationTypeName(rs.getString("game_participation_type_name"));
						gameInfoOut.setGameParticipationTypeWebPath(rs.getString("game_participation_type_web_path"));
						gameInfoOut.setGameRewards(
							Arrays.asList(rs.getString("game_rewards").split("\\,")).stream()
								.map(u -> {
									String[] uA = u.split("\\|");
									GameInfoOut.GameRewards c = gameInfoOut.new GameRewards();
									if (uA.length==3) {
										c.setName(uA[0]);
										c.setWebPath(uA[1]);
										c.setIsPositive(uA[2]);
									}
									return c;
								})
								.collect(Collectors.toList())
						);
						gameInfoOut.setWinners(
							Arrays.asList(rs.getString("winners").split("\\,")).stream()
								.map(u -> {
									String[] uA = u.split("\\|");
									GameInfoOut.Winners c = gameInfoOut.new Winners();
									if (uA.length==4) {
										c.setName(uA[0]);
										c.setWebPath(uA[1]);
										c.setGameActivityTypeWebPath(uA[2]);
										c.setGameActivityTypeName(uA[3]);
									}
									return c;
								})
								.collect(Collectors.toList())
						);
						gameInfoOut.setGameTags(
							Arrays.asList(rs.getString("game_tags").split("\\,")).stream()
								.map(u -> {
									String[] uA = u.split("\\|");
									GameInfoOut.GameTags c = gameInfoOut.new GameTags();
									if (uA.length==2) {
										c.setName(uA[0]);
										c.setWebPath(uA[1]);
									}
									return c;
								})
								.collect(Collectors.toList())
						);
						list.add(gameInfoOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<GameInfoOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}