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
	* - name      : RESTDbAPISDDResource
	* - file name : RESTDbAPISDDResource.vm
*/
	
package com.game.score.rest.player;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import java.sql.*;
import java.io.IOException;
import javax.servlet.http.*;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.HttpHeaders;
import javax.xml.bind.JAXBElement;

import com.game.score.rest.JWTUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.security.RolesAllowed;
import com.game.score.sdd.out.player.PlayerPerformanceComparisonOutList;
import com.game.score.sdd.out.player.PlayerPerformanceComparisonOut;
import com.game.score.sdd.in.player.PlayerPerformanceComparisonIn;
import com.game.score.dao.sdd.face.player.PlayerPerformanceComparisonDaoFace;
import com.game.score.rest.Cacheable;
import com.game.score.rest.Compress;
/**
*
* <p>Title: PlayerPerformanceComparisonResource</p>
*
* <p>Description: class for PlayerPerformanceComparisonResource service </p>
* <p>Convention: $query.getNamingConvention() </p>
*
*/
@Path("/sdd/PlayerPerformanceComparisonIn")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="/sdd/PlayerPerformanceComparisonIn", description = "operation about PlayerPerformanceComparisonIn")
public class PlayerPerformanceComparisonResource {
    @Autowired
    @Qualifier("playerPerformanceComparisonDaoFace")
	PlayerPerformanceComparisonDaoFace playerPerformanceComparisonDaoFace;
	

    @GET
    @Cacheable(cc = "public, max-age=3600")
	@Compress
    @ApiOperation(value = "player_performance_comparison", notes = "perform player_performance_comparison", response = PlayerPerformanceComparisonOutList.class)
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "ok")
    })
    public PlayerPerformanceComparisonOutList execute (
        @ApiParam(value = "comparisonPlayersWebPath", required = true) @QueryParam ("comparisonPlayersWebPath")   String comparisonPlayersWebPath
        ,        @ApiParam(value = "programWebPath", required = false) @QueryParam ("programWebPath")  String programWebPath
    ) {
		return callImplementation(
         comparisonPlayersWebPath
        ,         programWebPath
		);
    }


	public PlayerPerformanceComparisonOutList callImplementation (
          String comparisonPlayersWebPath
        ,         String programWebPath
	) {
        PlayerPerformanceComparisonIn playerPerformanceComparisonIn = new PlayerPerformanceComparisonIn ();
		playerPerformanceComparisonIn.setComparisonPlayersWebPath (comparisonPlayersWebPath);
		playerPerformanceComparisonIn.setProgramWebPath (programWebPath);
        return playerPerformanceComparisonDaoFace.execute(
        	playerPerformanceComparisonIn
        );
	}
	
    @GET
    @Path ("/getGames")
    @ApiOperation(value = "getGames", notes = "getGames", response = Game.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "ok")
    })
    public List<Game> getGames (
        @ApiParam(value = "comparisonPlayersWebPath", required = true) @QueryParam ("comparisonPlayersWebPath")   String comparisonPlayersWebPath
        ,        @ApiParam(value = "programWebPath", required = false) @QueryParam ("programWebPath")  String programWebPath
    ) {
        PlayerPerformanceComparisonOutList list = execute(
 comparisonPlayersWebPath
, programWebPath
			);
        return getGames(list);
    }
    @GET
    @Path ("/getParticipants")
    @ApiOperation(value = "getParticipants", notes = "getParticipants", response = Participant.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "ok")
    })
    public List<Participant> getParticipants (
        @ApiParam(value = "comparisonPlayersWebPath", required = true) @QueryParam ("comparisonPlayersWebPath")   String comparisonPlayersWebPath
        ,        @ApiParam(value = "programWebPath", required = false) @QueryParam ("programWebPath")  String programWebPath
    ) {
        PlayerPerformanceComparisonOutList list = execute(
 comparisonPlayersWebPath
, programWebPath
			);
        return getParticipants(list);
    }

	@lombok.Data
	private class Game {
		String programName;
		String programWebPath;
		Integer programIndex;
		String gameName;
		String gameWebPath;
		Long nbRegisterParticipants;
		String gameTypeName;
		String gameTypeWebPath;
		String gameStakeTypeName;
		String gameStakeTypeWebPath;
		String participationTypeName;
		String participationTypeWebPath;
		String timePosition;

		@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)	
		List<Participant> participants = new ArrayList<>();
		public void addParticipant(Participant e) {
			getParticipants().add(e);
		}
	}

	public List<Game> getGames (PlayerPerformanceComparisonOutList input) {
        List<Game> ret = new ArrayList<>();
        Map<String, Game> map = new HashMap<String, Game>();
        for (PlayerPerformanceComparisonOut pivot : input.getPlayerPerformanceComparisonOuts()) {
            Game p = map.get(pivot.getGameWebPath());

            if (p==null) {
                p = new Game();
                p.programName = pivot.getProgramName();
                p.programWebPath = pivot.getProgramWebPath();
                p.programIndex = pivot.getProgramIndex();
                p.gameName = pivot.getGameName();
                p.gameWebPath = pivot.getGameWebPath();
                p.nbRegisterParticipants = pivot.getNbRegisterParticipants();
                p.gameTypeName = pivot.getGameTypeName();
                p.gameTypeWebPath = pivot.getGameTypeWebPath();
                p.gameStakeTypeName = pivot.getGameStakeTypeName();
                p.gameStakeTypeWebPath = pivot.getGameStakeTypeWebPath();
                p.participationTypeName = pivot.getParticipationTypeName();
                p.participationTypeWebPath = pivot.getParticipationTypeWebPath();
                p.timePosition = pivot.getTimePosition();
                map.put(pivot.getGameWebPath(), p);
            }
            Participant participant = new Participant();
            participant.participantName = pivot.getParticipantName();
            participant.participantWebPath = pivot.getParticipantWebPath();
            participant.ranking = pivot.getRanking();
            participant.activityTypeName = pivot.getActivityTypeName();
            participant.activityTypeWebPath = pivot.getActivityTypeWebPath();
            participant.score = pivot.getScore();
            p.addParticipant(participant);
        }
        for (Game e : map.values()) {
            ret.add(e);
        }
        return ret;
    }
	
	@lombok.Data
	private class Participant {
		String participantName;
		String participantWebPath;
		Integer ranking;
		String activityTypeName;
		String activityTypeWebPath;
		java.math.BigDecimal score;

		@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)	
		List<Game> games = new ArrayList<>();
		public void addGame(Game e) {
			getGames().add(e);
		}
	}

	public List<Participant> getParticipants (PlayerPerformanceComparisonOutList input) {
        List<Participant> ret = new ArrayList<>();
        Map<String, Participant> map = new HashMap<String, Participant>();
        for (PlayerPerformanceComparisonOut pivot : input.getPlayerPerformanceComparisonOuts()) {
            Participant p = map.get(pivot.getParticipantWebPath());

            if (p==null) {
                p = new Participant();
                p.participantName = pivot.getParticipantName();
                p.participantWebPath = pivot.getParticipantWebPath();
                p.ranking = pivot.getRanking();
                p.activityTypeName = pivot.getActivityTypeName();
                p.activityTypeWebPath = pivot.getActivityTypeWebPath();
                p.score = pivot.getScore();
                map.put(pivot.getParticipantWebPath(), p);
            }
            Game game = new Game();
            game.programName = pivot.getProgramName();
            game.programWebPath = pivot.getProgramWebPath();
            game.programIndex = pivot.getProgramIndex();
            game.gameName = pivot.getGameName();
            game.gameWebPath = pivot.getGameWebPath();
            game.nbRegisterParticipants = pivot.getNbRegisterParticipants();
            game.gameTypeName = pivot.getGameTypeName();
            game.gameTypeWebPath = pivot.getGameTypeWebPath();
            game.gameStakeTypeName = pivot.getGameStakeTypeName();
            game.gameStakeTypeWebPath = pivot.getGameStakeTypeWebPath();
            game.participationTypeName = pivot.getParticipationTypeName();
            game.participationTypeWebPath = pivot.getParticipationTypeWebPath();
            game.timePosition = pivot.getTimePosition();
            p.addGame(game);
        }
        for (Participant e : map.values()) {
            ret.add(e);
        }
        return ret;
    }
	


}
