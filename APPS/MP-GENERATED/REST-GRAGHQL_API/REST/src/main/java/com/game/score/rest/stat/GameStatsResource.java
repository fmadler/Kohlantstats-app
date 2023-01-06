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
	
package com.game.score.rest.stat;


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
import com.game.score.sdd.out.stat.GameStatsOutList;
import com.game.score.sdd.out.stat.GameStatsOut;
import com.game.score.sdd.in.stat.GameStatsIn;
import com.game.score.dao.sdd.face.stat.GameStatsDaoFace;
import com.game.score.rest.Cacheable;
import com.game.score.rest.Compress;
/**
*
* <p>Title: GameStatsResource</p>
*
* <p>Description: class for GameStatsResource service </p>
* <p>Convention: $query.getNamingConvention() </p>
*
*/
@Path("/sdd/GameStatsIn")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="/sdd/GameStatsIn", description = "operation about GameStatsIn")
public class GameStatsResource {
    @Autowired
    @Qualifier("gameStatsDaoFace")
	GameStatsDaoFace gameStatsDaoFace;
	

    @GET
    @Cacheable(cc = "public, max-age=3600")
	@Compress
    @ApiOperation(value = "game_stats", notes = "perform game_stats", response = GameStatsOutList.class)
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "ok")
    })
    public GameStatsOutList execute (
        @ApiParam(value = "programWebPath", required = false) @QueryParam ("programWebPath")  String programWebPath
        ,        @ApiParam(value = "playerWebPath", required = false) @QueryParam ("playerWebPath")  String playerWebPath
        ,        @ApiParam(value = "gameWebPath", required = false) @QueryParam ("gameWebPath")  String gameWebPath
        ,        @ApiParam(value = "teamWebPath", required = false) @QueryParam ("teamWebPath")  String teamWebPath
        ,        @ApiParam(value = "gameTypeWebPath", required = false) @QueryParam ("gameTypeWebPath")  String gameTypeWebPath
        ,        @ApiParam(value = "gameStakeTypeWebPath", required = false) @QueryParam ("gameStakeTypeWebPath")  String gameStakeTypeWebPath
        ,        @ApiParam(value = "gameParticipationTypeWebPath", required = false) @QueryParam ("gameParticipationTypeWebPath")  String gameParticipationTypeWebPath
        ,        @ApiParam(value = "gameActivityTypeWebPath", required = false) @QueryParam ("gameActivityTypeWebPath")  String gameActivityTypeWebPath
        ,        @ApiParam(value = "untilDay", required = false) @QueryParam ("untilDay")  Integer untilDay
    ) {
		return callImplementation(
         programWebPath
        ,         playerWebPath
        ,         gameWebPath
        ,         teamWebPath
        ,         gameTypeWebPath
        ,         gameStakeTypeWebPath
        ,         gameParticipationTypeWebPath
        ,         gameActivityTypeWebPath
        ,         untilDay
		);
    }


	public GameStatsOutList callImplementation (
         String programWebPath
        ,         String playerWebPath
        ,         String gameWebPath
        ,         String teamWebPath
        ,         String gameTypeWebPath
        ,         String gameStakeTypeWebPath
        ,         String gameParticipationTypeWebPath
        ,         String gameActivityTypeWebPath
        ,         Integer untilDay
	) {
        GameStatsIn gameStatsIn = new GameStatsIn ();
		gameStatsIn.setProgramWebPath (programWebPath);
		gameStatsIn.setPlayerWebPath (playerWebPath);
		gameStatsIn.setGameWebPath (gameWebPath);
		gameStatsIn.setTeamWebPath (teamWebPath);
		gameStatsIn.setGameTypeWebPath (gameTypeWebPath);
		gameStatsIn.setGameStakeTypeWebPath (gameStakeTypeWebPath);
		gameStatsIn.setGameParticipationTypeWebPath (gameParticipationTypeWebPath);
		gameStatsIn.setGameActivityTypeWebPath (gameActivityTypeWebPath);
		gameStatsIn.setUntilDay (untilDay);
        return gameStatsDaoFace.execute(
        	gameStatsIn
        );
	}
	



}
