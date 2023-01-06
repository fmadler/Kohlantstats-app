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
package com.game.score.dao.sdd.impl.vote;



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
import com.game.score.sdd.out.vote.VoteDetailOutList;
import com.game.score.sdd.out.vote.VoteDetailOut;
import com.game.score.dao.sdd.face.vote.VoteDetailDaoFace;
import com.game.score.sdd.in.vote.VoteDetailIn;
/**
 *
 * <p>Title: VoteDetailRepository</p>
 *
 * <p>Description: SDD DAO Spring JPA implementation </p>
 *
 */
@Repository ("voteDetailDaoFace")
@Transactional(propagation = Propagation.REQUIRED)
public class VoteDetailRepository implements VoteDetailDaoFace {

	public static final String QUERY_NATIVE = "select  	v.id, 	p.name program_name, 	p.web_path program_web_path, 	t.name team_name,	 	t.web_path team_web_path, 	vt.name vote_type_name, 	vt.web_path vote_type_web_path, 	vet.name vote_effectiveness_type_name, 	vet.web_path vote_effectiveness_type_web_path, 	pl1.name voter_name, 	pl1.web_path voter_web_path, 	pl2.name voter_target_name, 	pl2.web_path voter_target_web_path, 	v.sequence, 	v.time_unit, 	v.vote_number  from  	gs_vote v, 	gs_team t, 	gs_program p, 	gs_participant p1, 	gs_player pl1, 	gs_participant p2, 	gs_player pl2, 	gs_vote_effectiveness_type vet, 	gs_vote_type vt where 	v.gs_vote_effectiveness_type_id = vet.id and 	v.gs_vote_type_id = vt.id and 	v.gs_team_id = t.id and 	t.gs_program_id = p.id and 	v.gs_voter_participant_id = p1.id and 	p1.gs_player_id = pl1.id and 	v.gs_voter_target_participant_id = p2.id and 	p2.gs_player_id = pl2.id     $whereProgramWebPath     $whereTeamWebPath     $whereVoterWebPath	     $whereVoterTargetWebPath     $whereeffectivenesstypeWebPath     $whereetypeWebPath";
	public static final String CHUNK_whereProgramWebPath = "p.web_path = ?";
	public static final String CHUNK_whereTeamWebPath = "t.web_path = ?";
	public static final String CHUNK_whereVoterWebPath = "pl1.web_path = ?";
	public static final String CHUNK_whereVoterTargetWebPath = "pl2.web_path = ?";
	public static final String CHUNK_whereeffectivenesstypeWebPath = "vet.web_path = ?";
	public static final String CHUNK_whereetypeWebPath = "vt.web_path = ?";

	@PersistenceContext(unitName = "score")  
    EntityManager entityManager;  

	@Cacheable (cacheNames="voteDetailCache") 
    public VoteDetailOutList execute (
		VoteDetailIn voteDetailIn
		) {
		VoteDetailOutList voteDetailOutList = new VoteDetailOutList();
		VoteDetailOutListWork work = new VoteDetailOutListWork (
			voteDetailIn
			);
        Session session = getSession();
        session.doWork(work);
		voteDetailOutList.setVoteDetailOuts (work.getResult());
        return voteDetailOutList;
    }


	public boolean isFilterwhereProgramWebPathActive(VoteDetailIn voteDetailIn) {
		if (voteDetailIn.getProgramWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereTeamWebPathActive(VoteDetailIn voteDetailIn) {
		if (voteDetailIn.getTeamWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereVoterWebPathActive(VoteDetailIn voteDetailIn) {
		if (voteDetailIn.getVoterWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereVoterTargetWebPathActive(VoteDetailIn voteDetailIn) {
		if (voteDetailIn.getVoterTargetWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereeffectivenesstypeWebPathActive(VoteDetailIn voteDetailIn) {
		if (voteDetailIn.getVoteEffectivenessTypeWebPath() == null) return false;
		return true;	
	}
	public boolean isFilterwhereetypeWebPathActive(VoteDetailIn voteDetailIn) {
		if (voteDetailIn.getVoteTypeWebPath() == null) return false;
		return true;	
	}


	public String getStatement(
			VoteDetailIn voteDetailIn
		) {
		String query = QUERY_NATIVE;
		boolean isWhereDone = false;
		if (
			 isFilterwhereProgramWebPathActive( voteDetailIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereProgramWebPath", connectionWord + getChunkwhereProgramWebPath(voteDetailIn, CHUNK_whereProgramWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereProgramWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereTeamWebPathActive( voteDetailIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereTeamWebPath", connectionWord + getChunkwhereTeamWebPath(voteDetailIn, CHUNK_whereTeamWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereTeamWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereVoterWebPathActive( voteDetailIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereVoterWebPath", connectionWord + getChunkwhereVoterWebPath(voteDetailIn, CHUNK_whereVoterWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereVoterWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereVoterTargetWebPathActive( voteDetailIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereVoterTargetWebPath", connectionWord + getChunkwhereVoterTargetWebPath(voteDetailIn, CHUNK_whereVoterTargetWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereVoterTargetWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereeffectivenesstypeWebPathActive( voteDetailIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereeffectivenesstypeWebPath", connectionWord + getChunkwhereeffectivenesstypeWebPath(voteDetailIn, CHUNK_whereeffectivenesstypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereeffectivenesstypeWebPath","");//replaceOnce
		}
		if (
			 isFilterwhereetypeWebPathActive( voteDetailIn)			) {
			String connectionWord = " AND ";
			query = StringUtils.replace (query, "$"+"whereetypeWebPath", connectionWord + getChunkwhereetypeWebPath(voteDetailIn, CHUNK_whereetypeWebPath) ); //replaceOnce
			isWhereDone = true;
		} else {
			query = StringUtils.replace (query, "$"+"whereetypeWebPath","");//replaceOnce
		}
		return query;
	}

	private String getChunkwhereProgramWebPath (VoteDetailIn voteDetailIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereTeamWebPath (VoteDetailIn voteDetailIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereVoterWebPath (VoteDetailIn voteDetailIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereVoterTargetWebPath (VoteDetailIn voteDetailIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereeffectivenesstypeWebPath (VoteDetailIn voteDetailIn, String chunk) {
		return chunk;
	}

	private String getChunkwhereetypeWebPath (VoteDetailIn voteDetailIn, String chunk) {
		return chunk;
	}
	
   private class VoteDetailOutListWork implements Work {
		VoteDetailIn voteDetailIn;
        VoteDetailOutListWork(
			VoteDetailIn voteDetailIn
			){
				this.voteDetailIn = voteDetailIn;
		}
		List<VoteDetailOut> list = new ArrayList<>();
		private void injectPrepareStatementParams(
			PreparedStatement pstmt
			, VoteDetailIn voteDetailIn			) throws SQLException {
			int index = 1;
			if (isFilterwhereProgramWebPathActive( voteDetailIn)) {
            if (voteDetailIn.getProgramWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, voteDetailIn.getProgramWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereTeamWebPathActive( voteDetailIn)) {
            if (voteDetailIn.getTeamWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, voteDetailIn.getTeamWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereVoterWebPathActive( voteDetailIn)) {
            if (voteDetailIn.getVoterWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, voteDetailIn.getVoterWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereVoterTargetWebPathActive( voteDetailIn)) {
            if (voteDetailIn.getVoterTargetWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, voteDetailIn.getVoterTargetWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereeffectivenesstypeWebPathActive( voteDetailIn)) {
            if (voteDetailIn.getVoteEffectivenessTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, voteDetailIn.getVoteEffectivenessTypeWebPath()); 
            }
            index ++;
			}
			if (isFilterwhereetypeWebPathActive( voteDetailIn)) {
            if (voteDetailIn.getVoteTypeWebPath()==null) {
               pstmt.setNull(index, java.sql.Types.VARCHAR);
            } else {
               pstmt.setString(index, voteDetailIn.getVoteTypeWebPath()); 
            }
            index ++;
			}
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			try (
				PreparedStatement pstmt = conn.prepareStatement(
					getStatement(
						voteDetailIn
						)
					);
				) {
					injectPrepareStatementParams(pstmt, voteDetailIn);
					try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						VoteDetailOut voteDetailOut = new VoteDetailOut();
						voteDetailOut.setId(rs.getInt("id"));
						voteDetailOut.setProgramName(rs.getString("program_name"));
						voteDetailOut.setProgramWebPath(rs.getString("program_web_path"));
						voteDetailOut.setTeamName(rs.getString("team_name"));
						voteDetailOut.setTeamWebPath(rs.getString("team_web_path"));
						voteDetailOut.setVoteTypeName(rs.getString("vote_type_name"));
						voteDetailOut.setVoteTypeWebPath(rs.getString("vote_type_web_path"));
						voteDetailOut.setVoteEffectivenessTypeName(rs.getString("vote_effectiveness_type_name"));
						voteDetailOut.setVoteEffectivenessTypeWebPath(rs.getString("vote_effectiveness_type_web_path"));
						voteDetailOut.setVoterName(rs.getString("voter_name"));
						voteDetailOut.setVoterWebPath(rs.getString("voter_web_path"));
						voteDetailOut.setVoterTargetName(rs.getString("voter_target_name"));
						voteDetailOut.setVoterTargetWebPath(rs.getString("voter_target_web_path"));
						voteDetailOut.setSequence(rs.getInt("sequence"));
						voteDetailOut.setTimeUnit(rs.getInt("time_unit"));
						voteDetailOut.setVoteNumber(rs.getInt("vote_number"));
						list.add(voteDetailOut);
	        		}	        	}			}
       }

       List<VoteDetailOut> getResult() {
          return list;
       }
    }
  	
   	private Session getSession() {  
   		Session session = (Session) entityManager.getDelegate();  
   		return session;  
   	}


}