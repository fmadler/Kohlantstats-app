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


package com.game.score.rest.game;
    //templateModelCompress REST.Compress.Annotation

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
import com.game.score.sdd.out.game.CreateGameParticipationOutList;
import com.game.score.sdd.out.game.CreateGameParticipationOut;
import com.game.score.sdd.in.game.CreateGameParticipationIn;
import com.game.score.dao.sdd.face.game.CreateGameParticipationDaoFace;
import com.game.score.rest.Cacheable;
import com.game.score.rest.Compress;
/**
*
* <p>Title: CreateGameParticipationResource</p>
*
* <p>Description: class for CreateGameParticipationResource service </p>
*
*/
@Path("/sdd/CreateGameParticipationIn")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="/sdd/CreateGameParticipationIn", description = "operation about CreateGameParticipationIn")
public class CreateGameParticipationResource {
    @Autowired
    @Qualifier("createGameParticipationDaoFace")
	CreateGameParticipationDaoFace createGameParticipationDaoFace;
	


    @POST
	@Compress
    @ApiOperation(value = "create_game_participation", notes = "perform create_game_participation", response = CreateGameParticipationOutList.class)
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "ok")
    })
    public CreateGameParticipationOutList post (
        @ApiParam(value = "participantWebPath", required = true) @FormParam ("participantWebPath")  String participantWebPath
        ,        @ApiParam(value = "teamWebPath", required = true) @FormParam ("teamWebPath")  String teamWebPath
        ,        @ApiParam(value = "gameWebPath", required = true) @FormParam ("gameWebPath")  String gameWebPath
        ,        @ApiParam(value = "activityTypeWebPath", required = true) @FormParam ("activityTypeWebPath")  String activityTypeWebPath
        ,        @ApiParam(value = "participationTypeWebPath", required = true) @FormParam ("participationTypeWebPath")  String participationTypeWebPath
        ,        @ApiParam(value = "ranking", required = true) @FormParam ("ranking")  Integer ranking
        ,        @ApiParam(value = "rewardWebPaths", required = true) @FormParam ("rewardWebPaths")  String rewardWebPaths
    ) {
		return callImplementation(
         participantWebPath
        ,         teamWebPath
        ,         gameWebPath
        ,         activityTypeWebPath
        ,         participationTypeWebPath
        ,         ranking
        ,         rewardWebPaths
		);
    }
    
    @POST
    @Path("/withValidation")//TODO remove just for migration testing
    public CreateGameParticipationOutList postWithValidation (
        @ApiParam(value = "participantWebPath", required = true) @FormParam ("participantWebPath")  String participantWebPath
        ,        @ApiParam(value = "teamWebPath", required = true) @FormParam ("teamWebPath")  String teamWebPath
        ,        @ApiParam(value = "gameWebPath", required = true) @FormParam ("gameWebPath")  String gameWebPath
        ,        @ApiParam(value = "activityTypeWebPath", required = true) @FormParam ("activityTypeWebPath")  String activityTypeWebPath
        ,        @ApiParam(value = "participationTypeWebPath", required = true) @FormParam ("participationTypeWebPath")  String participationTypeWebPath
        ,        @ApiParam(value = "ranking", required = true) @FormParam ("ranking")  Integer ranking
        ,        @ApiParam(value = "rewardWebPaths", required = true) @FormParam ("rewardWebPaths")  String rewardWebPaths
    ) {
		return callImplementation(
         participantWebPath
        ,         teamWebPath
        ,         gameWebPath
        ,         activityTypeWebPath
        ,         participationTypeWebPath
        ,         ranking
        ,         rewardWebPaths
		);
    }
    

	public CreateGameParticipationOutList callImplementation (
         String participantWebPath
        ,         String teamWebPath
        ,         String gameWebPath
        ,         String activityTypeWebPath
        ,         String participationTypeWebPath
        ,         Integer ranking
        ,         String rewardWebPaths
	) {
        CreateGameParticipationIn createGameParticipationIn = new CreateGameParticipationIn ();
		createGameParticipationIn.setParticipantWebPath (participantWebPath);
		createGameParticipationIn.setTeamWebPath (teamWebPath);
		createGameParticipationIn.setGameWebPath (gameWebPath);
		createGameParticipationIn.setActivityTypeWebPath (activityTypeWebPath);
		createGameParticipationIn.setParticipationTypeWebPath (participationTypeWebPath);
		createGameParticipationIn.setRanking (ranking);
		createGameParticipationIn.setRewardWebPaths (rewardWebPaths);
        return createGameParticipationDaoFace.execute(
        	createGameParticipationIn
        );
	}
	





}
