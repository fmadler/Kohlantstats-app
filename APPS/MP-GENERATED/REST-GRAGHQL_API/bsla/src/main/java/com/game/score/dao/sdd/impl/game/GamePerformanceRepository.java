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
import com.game.score.sdd.out.game.GamePerformanceOutList;
import com.game.score.sdd.out.game.GamePerformanceOut;
import com.game.score.dao.sdd.face.game.GamePerformanceDaoFace;
import com.game.score.sdd.in.game.GamePerformanceIn;
/**
 *
 * <p>Title: GamePerformanceRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("gamePerformanceDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class GamePerformanceRepository implements GamePerformanceDaoFace {

	public static final String QUERY_NATIVE = "select 									participant_web_path, 									tag_name, 									tag_web_path, 									total_nb_of_games, 									performance_first, 									case when total_nb_of_games = 0 then 0 else round((performance_first / total_nb_of_games)*100,2) end as performance_first_percent, 									performance_first_two, 									case when total_nb_of_games = 0 then 0 else round((performance_first_two / total_nb_of_games)*100,2) end as performance_first_two_percent,  									total_nb_of_games_individual, 									individual_performance_first, 									case when total_nb_of_games_individual = 0 then 0 else round((individual_performance_first / total_nb_of_games_individual)*100,2) end as individual_performance_first_percent, 									individual_performance_first_two, 									case when total_nb_of_games_individual = 0 then 0 else round((individual_performance_first_two / total_nb_of_games_individual)*100,2) end as individual_performance_first_two_percent,  									total_nb_of_games_in_group, 									in_group_performance_first, 									case when total_nb_of_games_in_group = 0 then 0 else round((in_group_performance_first / total_nb_of_games_in_group)*100,2) end as in_group_performance_first_percent, 									in_group_performance_first_two, 									case when total_nb_of_games_in_group = 0 then 0 else round((in_group_performance_first_two / total_nb_of_games_in_group)*100,2) end as in_group_performance_first_two_percent 								from ( 									select count(tag_name) total_nb_of_games, 										sum(performance_first) performance_first, 										sum(performance_first_two) performance_first_two, 										sum(total_nb_of_games_individual) total_nb_of_games_individual, 										sum(individual_performance_first) individual_performance_first, 										sum(individual_performance_first_two) individual_performance_first_two, 										sum(total_nb_of_games_in_group) total_nb_of_games_in_group, 										sum(in_group_performance_first) in_group_performance_first, 										sum(in_group_performance_first_two) in_group_performance_first_two, 										tag_name, 										tag_web_path, 										participant_web_path 									from ( 									select 									t.name tag_name, 									t.web_path tag_web_path, 									g.web_path game_web_path, 									g.name game_name, 									pxg.ranking, 									case when pxg.ranking = 1 then 1 else 0 end as performance_first, 									case when pxg.ranking in (1,2) then 1 else 0 end as performance_first_two, 									case when gpt.web_path = 'individuel' then 1 else 0 end as total_nb_of_games_individual, 									case when gpt.web_path != 'individuel' then 1 else 0 end as total_nb_of_games_in_group, 									case when pxg.ranking = 1 and gpt.web_path = 'individuel' then 1 else 0 end as individual_performance_first, 									case when pxg.ranking in (1,2) and gpt.web_path = 'individuel' then 1 else 0 end as individual_performance_first_two, 									case when pxg.ranking = 1 and gpt.web_path != 'individuel' then 1 else 0 end as in_group_performance_first, 									case when pxg.ranking in (1,2) and gpt.web_path != 'individuel' then 1 else 0 end as in_group_performance_first_two, 									gpt.WEB_PATH participation_type_web_path, 									pl.web_path participant_web_path 									from gs_game_tag t, 									gs_game_x_tag gxt, 									gs_game g, 									gs_participant_x_game pxg, 									gs_player pl, 									gs_participant pa, 									gs_game_participation_type gpt, 									gs_game_activity_type gat, 									gs_program pg 									where 									gxt.GS_GAME_ID = g.id and 									gxt.GS_GAME_TAG_ID = t.ID and 									pxg.GS_GAME_ID = g.ID and 									pxg.GS_PARTICIPANT_ID = pa.ID and 									pa.GS_PLAYER_ID = pl.ID and 									pxg.GS_GAME_PARTICIPATION_TYPE_ID = gpt.ID and 									pa.GS_PROGRAM_ID = pg.ID 									$wherePlayerWebPath 									$whereProgramWebPath 									and gat.WEB_PATH = 'participant' 									) xxx 									group by participant_web_path, tag_web_path 								) yyy";
	public static final String CHUNK_wherePlayerWebPath = "pl.WEB_PATH = ?";
	public static final String CHUNK_whereProgramWebPath = "pg.WEB_PATH = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="gamePerformanceCache") 
    public GamePerformanceOutList execute (
		GamePerformanceIn gamePerformanceIn
		) {
		GamePerformanceOutList gamePerformanceOutList = new GamePerformanceOutList();
		GamePerformanceOutListWork work = new GamePerformanceOutListWork (
			gamePerformanceIn
			);
        Session session = getSession();
        session.doWork(work);
		gamePerformanceOutList.setGamePerformanceOuts (work.getResult());
        return gamePerformanceOutList;
    }


	public boolean isFilterwherePlayerWebPathActive(GamePerformanceIn gamePerformanceIn) {
		if (gamePerformanceIn.getPlayerWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereProgramWebPathActive(GamePerformanceIn gamePerformanceIn) {
		if (gamePerformanceIn.getProgramWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			GamePerformanceIn gamePerformanceIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwherePlayerWebPathActive( gamePerformanceIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"wherePlayerWebPath", connectionWord + getChunkwherePlayerWebPath(gamePerformanceIn, CHUNK_wherePlayerWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"wherePlayerWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereProgramWebPathActive( gamePerformanceIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(gamePerformanceIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwherePlayerWebPath (GamePerformanceIn gamePerformanceIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereProgramWebPath (GamePerformanceIn gamePerformanceIn, String chunk) {
		return chunk;
	}
	
   private class GamePerformanceOutListWork implements Work {
		GamePerformanceIn gamePerformanceIn;
        GamePerformanceOutListWork(
			GamePerformanceIn gamePerformanceIn
			){
				this.gamePerformanceIn = gamePerformanceIn;
		}
		List<GamePerformanceOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, GamePerformanceIn gamePerformanceIn			) throws SQLException {
			int index = 1;
			if (isFilterwherePlayerWebPathActive( gamePerformanceIn)) {
            if (gamePerformanceIn.getPlayerWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, gamePerformanceIn.getPlayerWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereProgramWebPathActive( gamePerformanceIn)) {
            if (gamePerformanceIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, gamePerformanceIn.getProgramWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						gamePerformanceIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, gamePerformanceIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						GamePerformanceOut gamePerformanceOut = new GamePerformanceOut();
						gamePerformanceOut.setParticipantWebPath(rs.getString("participant_web_path"));
						gamePerformanceOut.setTagName(rs.getString("tag_name"));
						gamePerformanceOut.setTagWebPath(rs.getString("tag_web_path"));
						gamePerformanceOut.setTotalNbOfGames(rs.getLong("total_nb_of_games"));
						gamePerformanceOut.setPerformanceFirst(rs.getLong("performance_first"));
						gamePerformanceOut.setPerformanceFirstPercent(rs.getBigDecimal("performance_first_percent"));
						gamePerformanceOut.setPerformanceFirstTwo(rs.getLong("performance_first_two"));
						gamePerformanceOut.setPerformanceFirstTwoPercent(rs.getBigDecimal("performance_first_two_percent"));
						gamePerformanceOut.setTotalNbOfGamesIndividual(rs.getLong("total_nb_of_games_individual"));
						gamePerformanceOut.setIndividualPerformanceFirst(rs.getLong("individual_performance_first"));
						gamePerformanceOut.setIndividualPerformanceFirstPercent(rs.getBigDecimal("individual_performance_first_percent"));
						gamePerformanceOut.setIndividualPerformanceFirstTwo(rs.getLong("individual_performance_first_two"));
						gamePerformanceOut.setIndividualPerformanceFirstTwoPercent(rs.getBigDecimal("individual_performance_first_two_percent"));
						gamePerformanceOut.setTotalNbOfGamesInGroup(rs.getLong("total_nb_of_games_in_group"));
						gamePerformanceOut.setInGroupPerformanceFirst(rs.getLong("in_group_performance_first"));
						gamePerformanceOut.setInGroupPerformanceFirstPercent(rs.getBigDecimal("in_group_performance_first_percent"));
						gamePerformanceOut.setInGroupPerformanceFirstTwo(rs.getLong("in_group_performance_first_two"));
						gamePerformanceOut.setInGroupPerformanceFirstTwoPercent(rs.getBigDecimal("in_group_performance_first_two_percent"));
						list.add(gamePerformanceOut);
	        		}//from while (rs.next())
	        	}//from try (autoclosable)
			}
       }

       List<GamePerformanceOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}