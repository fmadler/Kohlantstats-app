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
package com.game.score.dao.sdd.impl.generic;



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
import com.game.score.sdd.out.generic.MasterDataOutList;
import com.game.score.sdd.out.generic.MasterDataOut;
import com.game.score.dao.sdd.face.generic.MasterDataDaoFace;
/**
 *
 * <p>Title: MasterDataRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("masterDataDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class MasterDataRepository implements MasterDataDaoFace {

	public static final String QUERY_NATIVE = "select id, name, web_path from $table order by $orderby $sort";
	public static final String CHUNK_table = "table";
	public static final String CHUNK_table_gs_team_departure_type = "gs_team_departure_type";
	public static final String CHUNK_table_gs_team_entrance_type = "gs_team_entrance_type";
	public static final String CHUNK_table_gs_team_reward_type = "gs_team_reward_type";
	public static final String CHUNK_table_gs_game_type = "gs_game_type";
	public static final String CHUNK_table_gs_game_stake_type = "gs_game_stake_type";
	public static final String CHUNK_table_gs_realisation_type = "gs_realisation_type";
	public static final String CHUNK_table_gs_vote_type = "gs_vote_type";
	public static final String CHUNK_orderby = "orderby";
	public static final String CHUNK_orderby_id = "id";
	public static final String CHUNK_orderby_name = "name";
	public static final String CHUNK_orderby_web_path = "web_path";
	public static final String CHUNK_sort = "sort";
	public static final String CHUNK_sort_ascending = "asc";
	public static final String CHUNK_sort_descending = "desc";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="masterDataCache") 
    public MasterDataOutList execute (
        String table 
        ,String orderby 
        ,String sort 
		) {
		MasterDataOutList masterDataOutList = new MasterDataOutList();
		MasterDataOutListWork work = new MasterDataOutListWork (
        	table 
        	, orderby 
        	, sort 
			);
        Session session = getSession();
        session.doWork(work);
		masterDataOutList.setMasterDataOuts (work.getResult());
        return masterDataOutList;
    }



	String gettable(String table) {
		if ("gs_team_departure_type".equals(table) || "gsTeamDepartureType".equals(table))
			return CHUNK_table_gs_team_departure_type;
		if ("gs_team_entrance_type".equals(table) || "gsTeamEntranceType".equals(table))
			return CHUNK_table_gs_team_entrance_type;
		if ("gs_team_reward_type".equals(table) || "gsTeamRewardType".equals(table))
			return CHUNK_table_gs_team_reward_type;
		if ("gs_game_type".equals(table) || "gsGameType".equals(table))
			return CHUNK_table_gs_game_type;
		if ("gs_game_stake_type".equals(table) || "gsGameStakeType".equals(table))
			return CHUNK_table_gs_game_stake_type;
		if ("gs_realisation_type".equals(table) || "gsRealisationType".equals(table))
			return CHUNK_table_gs_realisation_type;
		if ("gs_vote_type".equals(table) || "gsVoteType".equals(table))
			return CHUNK_table_gs_vote_type;
		return table;
	}  
	String getorderby(String orderby) {
		if ("id".equals(orderby) || "id".equals(orderby))
			return CHUNK_orderby_id;
		if ("name".equals(orderby) || "name".equals(orderby))
			return CHUNK_orderby_name;
		if ("web_path".equals(orderby) || "webPath".equals(orderby))
			return CHUNK_orderby_web_path;
		return orderby;
	}  
	String getsort(String sort) {
		if ("ascending".equals(sort) || "ascending".equals(sort))
			return CHUNK_sort_ascending;
		if ("descending".equals(sort) || "descending".equals(sort))
			return CHUNK_sort_descending;
		return sort;
	}  

	public String getStatement(
        	String table 
        	,String orderby 
        	,String sort 
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		query = StringUtils.replace (query, "$"+"table", gettable(table));  
		query = StringUtils.replace (query, "$"+"orderby", getorderby(orderby));  
		query = StringUtils.replace (query, "$"+"sort", getsort(sort));  
		return query;
	}
	
   private class MasterDataOutListWork implements Work {
        String table;
        String orderby; 
        String sort; 
        MasterDataOutListWork(
        	String table 
        	,String orderby 
        	,String sort 
			){
        		this.table = table; 
        		this.orderby = orderby;
        		this.sort = sort;
		}
		List<MasterDataOut> list = new ArrayList<>();

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						table 
						, orderby 
						, sort 
						)
					);
				) {
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						MasterDataOut masterDataOut = new MasterDataOut();
						masterDataOut.setId(rs.getInt("id"));
						masterDataOut.setName(rs.getString("name"));
						masterDataOut.setWebPath(rs.getString("web_path"));
						list.add(masterDataOut);
	        		}	        	}			}
       }

       List<MasterDataOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}