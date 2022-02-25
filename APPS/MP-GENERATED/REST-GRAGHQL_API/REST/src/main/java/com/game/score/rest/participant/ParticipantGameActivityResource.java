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


package com.game.score.rest.participant;
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
import com.game.score.sdd.out.participant.ParticipantGameActivityOutList;
import com.game.score.sdd.out.participant.ParticipantGameActivityOut;
import com.game.score.sdd.in.participant.ParticipantGameActivityIn;
import com.game.score.dao.sdd.face.participant.ParticipantGameActivityDaoFace;
import com.game.score.rest.Cacheable;
import com.game.score.rest.Compress;
/**
*
* <p>Title: ParticipantGameActivityResource</p>
*
* <p>Description: class for ParticipantGameActivityResource service </p>
*
*/
@Path("/sdd/ParticipantGameActivityIn")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="/sdd/ParticipantGameActivityIn", description = "operation about ParticipantGameActivityIn")
public class ParticipantGameActivityResource {
    @Autowired
    @Qualifier("participantGameActivityDaoFace")
	ParticipantGameActivityDaoFace participantGameActivityDaoFace;
	

    @GET
    @Cacheable(cc = "public, max-age=3600")
	@Compress
    @ApiOperation(value = "participant_game_activity", notes = "perform participant_game_activity", response = ParticipantGameActivityOutList.class)
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "ok")
    })
    public ParticipantGameActivityOutList execute (
        @ApiParam(value = "programWebPath", required = false) @QueryParam ("programWebPath")  String programWebPath
        ,        @ApiParam(value = "playerWebPath", required = false) @QueryParam ("playerWebPath")  String playerWebPath
        ,        @ApiParam(value = "gameWebPath", required = false) @QueryParam ("gameWebPath")  String gameWebPath
        ,        @ApiParam(value = "gameTagWebPath", required = false) @QueryParam ("gameTagWebPath")  String gameTagWebPath
        ,        @ApiParam(value = "rewardWebPath", required = false) @QueryParam ("rewardWebPath")  String rewardWebPath
    ) {
		return callImplementation(
         programWebPath
        ,         playerWebPath
        ,         gameWebPath
        ,         gameTagWebPath
        ,         rewardWebPath
		);
    }


	public ParticipantGameActivityOutList callImplementation (
         String programWebPath
        ,         String playerWebPath
        ,         String gameWebPath
        ,         String gameTagWebPath
        ,         String rewardWebPath
	) {
        ParticipantGameActivityIn participantGameActivityIn = new ParticipantGameActivityIn ();
		participantGameActivityIn.setProgramWebPath (programWebPath);
		participantGameActivityIn.setPlayerWebPath (playerWebPath);
		participantGameActivityIn.setGameWebPath (gameWebPath);
		participantGameActivityIn.setGameTagWebPath (gameTagWebPath);
		participantGameActivityIn.setRewardWebPath (rewardWebPath);
        return participantGameActivityDaoFace.execute(
        	participantGameActivityIn
        );
	}
	





}
