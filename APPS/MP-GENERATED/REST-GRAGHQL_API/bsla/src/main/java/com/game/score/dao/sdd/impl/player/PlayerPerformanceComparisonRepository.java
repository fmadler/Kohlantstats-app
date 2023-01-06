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
package com.game.score.dao.sdd.impl.player;



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
import com.game.score.sdd.out.player.PlayerPerformanceComparisonOutList;
import com.game.score.sdd.out.player.PlayerPerformanceComparisonOut;
import com.game.score.dao.sdd.face.player.PlayerPerformanceComparisonDaoFace;
import com.game.score.sdd.in.player.PlayerPerformanceComparisonIn;
/**
 *
 * <p>Title: PlayerPerformanceComparisonRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("playerPerformanceComparisonDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class PlayerPerformanceComparisonRepository implements PlayerPerformanceComparisonDaoFace {

	public static final String QUERY_NATIVE = "select 	p.name program_name, 	p.web_path program_web_path, 	g.program_index program_index, 	g.name game_name, 	g.time_position time_position, 	g.web_path game_web_path,     nb_register_participants,     gt.name game_type_name, 	gt.web_path game_type_web_path, 	gst.name game_stake_type_name, 	gst.web_path game_stake_type_web_path, 	gpt.name participation_type_name, 	gpt.web_path participation_type_web_path, 	pl.name participant_name, 	pl.WEB_PATH participant_web_path, 	pxg.RANKING ranking, 	case when gpt.web_path = 'individuel' and ranking = 1 then nb_register_participants when gpt.web_path = 'individuel' and ranking = 2 then (nb_register_participants-2)/2 else 0 end as score,     gat.name activity_type_name,     gat.web_path activity_type_web_path 	from gs_game g, gs_participant_x_game pxg, gs_game_type gt, gs_game_stake_type gst, gs_program p, gs_participant pa, gs_player pl, GS_GAME_PARTICIPATION_TYPE gpt, GS_GAME_ACTIVITY_TYPE gat 	, ( 		select g.id game_id, count(*) nb_register_participants 		from gs_game g, gs_participant_x_game pxg, gs_game_activity_type gat 		where 		pxg.GS_GAME_ID = g.ID and pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID and gat.WEB_PATH = 'participant' 		group by g.id     ) aaa     where 	pxg.GS_GAME_ID = g.ID and 	pxg.GS_PARTICIPANT_ID = pa.ID and 	pa.GS_PROGRAM_ID = p.ID and 	g.GS_GAME_TYPE_ID = gt.id and 	g.GS_GAME_STAKE_TYPE_ID = gst.ID and 	pa.GS_PLAYER_ID = pl.ID and     pxg.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID and     pxg.GS_GAME_ACTIVITY_TYPE_ID = gat.ID and     aaa.game_id = g.id     $wherePlayersWebPath     $whereProgramWebPath order by program_index asc, g.time_position asc";
	public static final String CHUNK_wherePlayersWebPath = "pl.WEB_PATH in (?...)";
	public static final String CHUNK_whereProgramWebPath = "p.WEB_PATH = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="playerPerformanceComparisonCache") 
    public PlayerPerformanceComparisonOutList execute (
		PlayerPerformanceComparisonIn playerPerformanceComparisonIn
		) {
		PlayerPerformanceComparisonOutList playerPerformanceComparisonOutList = new PlayerPerformanceComparisonOutList();
		PlayerPerformanceComparisonOutListWork work = new PlayerPerformanceComparisonOutListWork (
			playerPerformanceComparisonIn
			);
        Session session = getSession();
        session.doWork(work);
		playerPerformanceComparisonOutList.setPlayerPerformanceComparisonOuts (work.getResult());
        return playerPerformanceComparisonOutList;
    }


	public boolean isFilterwherePlayersWebPathActive(PlayerPerformanceComparisonIn playerPerformanceComparisonIn) {
		if (playerPerformanceComparisonIn.getComparisonPlayersWebPath() == null) return false;
		if (playerPerformanceComparisonIn.getComparisonPlayersWebPath().size()==0) return false;
		return true;	
	}
	public boolean isFilterwhereProgramWebPathActive(PlayerPerformanceComparisonIn playerPerformanceComparisonIn) {
		if (playerPerformanceComparisonIn.getProgramWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			PlayerPerformanceComparisonIn playerPerformanceComparisonIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwherePlayersWebPathActive( playerPerformanceComparisonIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"wherePlayersWebPath", connectionWord + getChunkwherePlayersWebPath(playerPerformanceComparisonIn, CHUNK_wherePlayersWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"wherePlayersWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereProgramWebPathActive( playerPerformanceComparisonIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(playerPerformanceComparisonIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwherePlayersWebPath (PlayerPerformanceComparisonIn playerPerformanceComparisonIn, String chunk) {
	   StringBuffer inSbcomparisonPlayersWebPath = new StringBuffer();
	   for (int i = 0; i < playerPerformanceComparisonIn.getComparisonPlayersWebPath().size(); i++) {
	   	  inSbcomparisonPlayersWebPath.append("?");
	   	  if (i+1!=playerPerformanceComparisonIn.getComparisonPlayersWebPath().size())
	   	  	inSbcomparisonPlayersWebPath.append(",");
	   }
	   return StringUtils.replace (chunk, "?...", inSbcomparisonPlayersWebPath.toString());//replaceOnce
	}

	private String getChunkwhereProgramWebPath (PlayerPerformanceComparisonIn playerPerformanceComparisonIn, String chunk) {
		return chunk;
	}
	
   private class PlayerPerformanceComparisonOutListWork implements Work {
		PlayerPerformanceComparisonIn playerPerformanceComparisonIn;
        PlayerPerformanceComparisonOutListWork(
			PlayerPerformanceComparisonIn playerPerformanceComparisonIn
			){
				this.playerPerformanceComparisonIn = playerPerformanceComparisonIn;
		}
		List<PlayerPerformanceComparisonOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, PlayerPerformanceComparisonIn playerPerformanceComparisonIn			) throws SQLException {
			int index = 1;
			if (isFilterwherePlayersWebPathActive( playerPerformanceComparisonIn)) {
            if (playerPerformanceComparisonIn.getComparisonPlayersWebPath()==null) {
			   for (String element : playerPerformanceComparisonIn.getComparisonPlayersWebPath()) {
			      pstmt.setNull(index, java.sql.Types.VARCHAR);
			      index ++;
			   }
			   //remove extra element
			   index --;
            } else {
			   for (String element : playerPerformanceComparisonIn.getComparisonPlayersWebPath()) {
			      pstmt.setString(index, element);
			      index ++;
			   }
			   //remove extra element
			   index --;
            }
            index ++;
			}
			if (isFilterwhereProgramWebPathActive( playerPerformanceComparisonIn)) {
            if (playerPerformanceComparisonIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, playerPerformanceComparisonIn.getProgramWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						playerPerformanceComparisonIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, playerPerformanceComparisonIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						PlayerPerformanceComparisonOut playerPerformanceComparisonOut = new PlayerPerformanceComparisonOut();
						playerPerformanceComparisonOut.setProgramName(rs.getString("program_name"));
						playerPerformanceComparisonOut.setProgramWebPath(rs.getString("program_web_path"));
						playerPerformanceComparisonOut.setProgramIndex(rs.getInt("program_index"));
						playerPerformanceComparisonOut.setGameName(rs.getString("game_name"));
						playerPerformanceComparisonOut.setTimePosition(rs.getString("time_position"));
						playerPerformanceComparisonOut.setGameWebPath(rs.getString("game_web_path"));
						playerPerformanceComparisonOut.setNbRegisterParticipants(rs.getLong("nb_register_participants"));
						playerPerformanceComparisonOut.setGameTypeName(rs.getString("game_type_name"));
						playerPerformanceComparisonOut.setGameTypeWebPath(rs.getString("game_type_web_path"));
						playerPerformanceComparisonOut.setGameStakeTypeName(rs.getString("game_stake_type_name"));
						playerPerformanceComparisonOut.setGameStakeTypeWebPath(rs.getString("game_stake_type_web_path"));
						playerPerformanceComparisonOut.setParticipationTypeName(rs.getString("participation_type_name"));
						playerPerformanceComparisonOut.setParticipationTypeWebPath(rs.getString("participation_type_web_path"));
						playerPerformanceComparisonOut.setParticipantName(rs.getString("participant_name"));
						playerPerformanceComparisonOut.setParticipantWebPath(rs.getString("participant_web_path"));
						playerPerformanceComparisonOut.setRanking(rs.getInt("ranking"));
						playerPerformanceComparisonOut.setScore(rs.getBigDecimal("score"));
						playerPerformanceComparisonOut.setActivityTypeName(rs.getString("activity_type_name"));
						playerPerformanceComparisonOut.setActivityTypeWebPath(rs.getString("activity_type_web_path"));
						list.add(playerPerformanceComparisonOut);
	        		}	        	}			}
       }

       List<PlayerPerformanceComparisonOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}