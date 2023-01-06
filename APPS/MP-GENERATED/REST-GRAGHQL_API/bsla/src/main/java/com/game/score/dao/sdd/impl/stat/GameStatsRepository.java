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
package com.game.score.dao.sdd.impl.stat;



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
import com.game.score.sdd.out.stat.GameStatsOutList;
import com.game.score.sdd.out.stat.GameStatsOut;
import com.game.score.dao.sdd.face.stat.GameStatsDaoFace;
import com.game.score.sdd.in.stat.GameStatsIn;
/**
 *
 * <p>Title: GameStatsRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("gameStatsDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class GameStatsRepository implements GameStatsDaoFace {

	public static final String QUERY_NATIVE = "select * from ( select participant_name, participant_web_path, program_name, program_web_path, longevity + sum(ranking_1_alone_nb_concurrents) + sum(ranking_2_alone_nb_concurrents) as score, sum(ranking_1_alone_nb_concurrents) + sum(ranking_2_alone_nb_concurrents) as ranking_1_and_2_alone_score, longevity, sum(totem) totems, sum(totem_individual) totems_individual, sum(confort) conforts, sum(confort_individual) conforts_individual, sum(ranking_1)  ranking_1, sum(ranking_2)  ranking_2, sum(ranking_3)  ranking_3, sum(ranking_other) ranking_other, sum(ranking_1_alone)  ranking_1_alone, sum(ranking_1_alone_nb_concurrents)  ranking_1_alone_score, sum(ranking_2_alone)  ranking_2_alone, sum(ranking_2_alone_nb_concurrents)  ranking_2_alone_score, sum(ranking_3_alone)  ranking_3_alone, sum(ranking_other_alone) ranking_other_alone, count(distinct game_name) nb_of_games, sum(individual_game_last) individual_game_lasts, sum(active_participation) active_participations, sum(individual_game) individual_participations, GROUP_CONCAT(distinct 				CONCAT_WS( 				'|', 				game_name,                 game_web_path,                 program_index, 				activity_type_name,                 participation_type_name,                 game_stake_type_name,                 ranking 				) 				order by program_index 				) participation_details from ( 	select * from v_game_stats where 1 = 1     $whereProgramWebPath     $whereParticipantWebPath     $whereGameWebPath     $whereTeamWebPath     $whereGameTypeWebPath     $whereGameStakeTypeWebPath     $whereGameParticipationTypeWebPath     $whereGameActivityTypeWebPath 	$whereCurrentDayUntil ) xxx  group by  participant_name, participant_web_path, program_name, program_web_path ) yyy order by score desc, ranking_1 desc, ranking_2 desc, ranking_3 desc";
	public static final String CHUNK_whereProgramWebPath = "program_web_path = ?";
	public static final String CHUNK_whereParticipantWebPath = "participant_web_path = ?";
	public static final String CHUNK_whereGameWebPath = "game_web_path = ?";
	public static final String CHUNK_whereTeamWebPath = "team_web_path = ?";
	public static final String CHUNK_whereGameTypeWebPath = "game_type_web_path = ?";
	public static final String CHUNK_whereGameStakeTypeWebPath = "game_stake_type_web_path = ?";
	public static final String CHUNK_whereGameParticipationTypeWebPath = "participation_type_web_path = ?";
	public static final String CHUNK_whereGameActivityTypeWebPath = "activity_type_web_path = ?";
	public static final String CHUNK_whereCurrentDayUntil = "time_position <= ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="gameStatsCache") 
    public GameStatsOutList execute (
		GameStatsIn gameStatsIn
		) {
		GameStatsOutList gameStatsOutList = new GameStatsOutList();
		GameStatsOutListWork work = new GameStatsOutListWork (
			gameStatsIn
			);
        Session session = getSession();
        session.doWork(work);
		gameStatsOutList.setGameStatsOuts (work.getResult());
        return gameStatsOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(GameStatsIn gameStatsIn) {
		if (gameStatsIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereParticipantWebPathActive(GameStatsIn gameStatsIn) {
		if (gameStatsIn.getPlayerWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameWebPathActive(GameStatsIn gameStatsIn) {
		if (gameStatsIn.getGameWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereTeamWebPathActive(GameStatsIn gameStatsIn) {
		if (gameStatsIn.getTeamWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameTypeWebPathActive(GameStatsIn gameStatsIn) {
		if (gameStatsIn.getGameTypeWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameStakeTypeWebPathActive(GameStatsIn gameStatsIn) {
		if (gameStatsIn.getGameStakeTypeWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameParticipationTypeWebPathActive(GameStatsIn gameStatsIn) {
		if (gameStatsIn.getGameParticipationTypeWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereGameActivityTypeWebPathActive(GameStatsIn gameStatsIn) {
		if (gameStatsIn.getGameActivityTypeWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereCurrentDayUntilActive(GameStatsIn gameStatsIn) {
		if (gameStatsIn.getUntilDay() == null) return false;
		return true;	
	}


	public String getStatement(
			GameStatsIn gameStatsIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( gameStatsIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(gameStatsIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereParticipantWebPathActive( gameStatsIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereParticipantWebPath", connectionWord + getChunkwhereParticipantWebPath(gameStatsIn, CHUNK_whereParticipantWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereParticipantWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameWebPathActive( gameStatsIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameWebPath", connectionWord + getChunkwhereGameWebPath(gameStatsIn, CHUNK_whereGameWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereTeamWebPathActive( gameStatsIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereTeamWebPath", connectionWord + getChunkwhereTeamWebPath(gameStatsIn, CHUNK_whereTeamWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereTeamWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameTypeWebPathActive( gameStatsIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameTypeWebPath", connectionWord + getChunkwhereGameTypeWebPath(gameStatsIn, CHUNK_whereGameTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameTypeWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameStakeTypeWebPathActive( gameStatsIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameStakeTypeWebPath", connectionWord + getChunkwhereGameStakeTypeWebPath(gameStatsIn, CHUNK_whereGameStakeTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameStakeTypeWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameParticipationTypeWebPathActive( gameStatsIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameParticipationTypeWebPath", connectionWord + getChunkwhereGameParticipationTypeWebPath(gameStatsIn, CHUNK_whereGameParticipationTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameParticipationTypeWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereGameActivityTypeWebPathActive( gameStatsIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereGameActivityTypeWebPath", connectionWord + getChunkwhereGameActivityTypeWebPath(gameStatsIn, CHUNK_whereGameActivityTypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereGameActivityTypeWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereCurrentDayUntilActive( gameStatsIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereCurrentDayUntil", connectionWord + getChunkwhereCurrentDayUntil(gameStatsIn, CHUNK_whereCurrentDayUntil) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereCurrentDayUntil","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (GameStatsIn gameStatsIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereParticipantWebPath (GameStatsIn gameStatsIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameWebPath (GameStatsIn gameStatsIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereTeamWebPath (GameStatsIn gameStatsIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameTypeWebPath (GameStatsIn gameStatsIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameStakeTypeWebPath (GameStatsIn gameStatsIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameParticipationTypeWebPath (GameStatsIn gameStatsIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereGameActivityTypeWebPath (GameStatsIn gameStatsIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereCurrentDayUntil (GameStatsIn gameStatsIn, String chunk) {
		return chunk;
	}
	
   private class GameStatsOutListWork implements Work {
		GameStatsIn gameStatsIn;
        GameStatsOutListWork(
			GameStatsIn gameStatsIn
			){
				this.gameStatsIn = gameStatsIn;
		}
		List<GameStatsOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, GameStatsIn gameStatsIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( gameStatsIn)) {
            if (gameStatsIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, gameStatsIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereParticipantWebPathActive( gameStatsIn)) {
            if (gameStatsIn.getPlayerWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, gameStatsIn.getPlayerWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameWebPathActive( gameStatsIn)) {
            if (gameStatsIn.getGameWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, gameStatsIn.getGameWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereTeamWebPathActive( gameStatsIn)) {
            if (gameStatsIn.getTeamWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, gameStatsIn.getTeamWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameTypeWebPathActive( gameStatsIn)) {
            if (gameStatsIn.getGameTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, gameStatsIn.getGameTypeWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameStakeTypeWebPathActive( gameStatsIn)) {
            if (gameStatsIn.getGameStakeTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, gameStatsIn.getGameStakeTypeWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameParticipationTypeWebPathActive( gameStatsIn)) {
            if (gameStatsIn.getGameParticipationTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, gameStatsIn.getGameParticipationTypeWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereGameActivityTypeWebPathActive( gameStatsIn)) {
            if (gameStatsIn.getGameActivityTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, gameStatsIn.getGameActivityTypeWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereCurrentDayUntilActive( gameStatsIn)) {
            if (gameStatsIn.getUntilDay()==null) {
               pstmt.setNull(index, java.sql.Types.INTEGER);
            } else {
               pstmt.setInt(index, gameStatsIn.getUntilDay()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						gameStatsIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, gameStatsIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						GameStatsOut gameStatsOut = new GameStatsOut();
						gameStatsOut.setParticipantName(rs.getString("participant_name"));
						gameStatsOut.setParticipantWebPath(rs.getString("participant_web_path"));
						gameStatsOut.setProgramName(rs.getString("program_name"));
						gameStatsOut.setProgramWebPath(rs.getString("program_web_path"));
						gameStatsOut.setScore(rs.getBigDecimal("score"));
						gameStatsOut.setRanking1And2AloneScore(rs.getBigDecimal("ranking_1_and_2_alone_score"));
						gameStatsOut.setLongevity(rs.getLong("longevity"));
						gameStatsOut.setTotems(rs.getLong("totems"));
						gameStatsOut.setTotemsIndividual(rs.getLong("totems_individual"));
						gameStatsOut.setConforts(rs.getLong("conforts"));
						gameStatsOut.setConfortsIndividual(rs.getLong("conforts_individual"));
						gameStatsOut.setRanking1(rs.getLong("ranking_1"));
						gameStatsOut.setRanking2(rs.getLong("ranking_2"));
						gameStatsOut.setRanking3(rs.getLong("ranking_3"));
						gameStatsOut.setRankingOther(rs.getLong("ranking_other"));
						gameStatsOut.setRanking1Alone(rs.getLong("ranking_1_alone"));
						gameStatsOut.setRanking1AloneScore(rs.getLong("ranking_1_alone_score"));
						gameStatsOut.setRanking2Alone(rs.getLong("ranking_2_alone"));
						gameStatsOut.setRanking2AloneScore(rs.getBigDecimal("ranking_2_alone_score"));
						gameStatsOut.setRanking3Alone(rs.getLong("ranking_3_alone"));
						gameStatsOut.setRankingOtherAlone(rs.getLong("ranking_other_alone"));
						gameStatsOut.setNbOfGames(rs.getLong("nb_of_games"));
						gameStatsOut.setIndividualGameLasts(rs.getLong("individual_game_lasts"));
						gameStatsOut.setActiveParticipations(rs.getLong("active_participations"));
						gameStatsOut.setIndividualParticipations(rs.getLong("individual_participations"));
						String participationDetails = rs.getString("participation_details");
						if (participationDetails != null) {
							gameStatsOut.setParticipationDetails(
								Arrays.asList(participationDetails.split("\\,")).stream()
									.map(u -> {
										String[] uA = u.split("\\|");
										GameStatsOut.ParticipationDetails c = gameStatsOut.new ParticipationDetails();
										if (uA.length==7) {
											c.setGameName(uA[0]);
											c.setGameWebPath(uA[1]);
											c.setProgramIndex(uA[2]);
											c.setActivityTypeName(uA[3]);
											c.setParticipationTypeName(uA[4]);
											c.setGameStakeTypeName(uA[5]);
											c.setRanking(uA[6]);
										}
										return c;
									})
									.collect(Collectors.toList())
							);
						}
						list.add(gameStatsOut);
	        		}	        	}			}
       }

       List<GameStatsOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}