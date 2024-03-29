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
	
package com.game.score.rest.quizz;


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
import com.game.score.sdd.out.quizz.QuizzParticipationOptionOutList;
import com.game.score.sdd.out.quizz.QuizzParticipationOptionOut;
import com.game.score.sdd.in.quizz.QuizzParticipationOptionIn;
import com.game.score.dao.sdd.face.quizz.QuizzParticipationOptionDaoFace;
import com.game.score.rest.Cacheable;
import com.game.score.rest.Compress;
/**
*
* <p>Title: QuizzParticipationOptionResource</p>
*
* <p>Description: class for QuizzParticipationOptionResource service </p>
* <p>Convention: $query.getNamingConvention() </p>
*
*/
@Path("/sdd/QuizzParticipationOptionIn")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="/sdd/QuizzParticipationOptionIn", description = "operation about QuizzParticipationOptionIn")
public class QuizzParticipationOptionResource {
    @Autowired
    @Qualifier("quizzParticipationOptionDaoFace")
	QuizzParticipationOptionDaoFace quizzParticipationOptionDaoFace;
	

    @GET
    @Cacheable(cc = "public, max-age=3600")
	@Compress
    @ApiOperation(value = "quizz_participation_option", notes = "perform quizz_participation_option", response = QuizzParticipationOptionOutList.class)
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "ok")
    })
    public QuizzParticipationOptionOutList execute (
        @ApiParam(value = "maxWinners", required = false) @QueryParam ("maxWinners")  Integer maxWinners
        ,        @ApiParam(value = "programWebPath", required = false) @QueryParam ("programWebPath")  String programWebPath
        ,        @ApiParam(value = "gameWebPath", required = false) @QueryParam ("gameWebPath")  String gameWebPath
        ,        @ApiParam(value = "participationTypeWebPath", required = false) @QueryParam ("participationTypeWebPath")  String participationTypeWebPath
        ,        @ApiParam(value = "participantWebPaths", required = false) @QueryParam ("participantWebPaths")   String participantWebPaths
        ,        @ApiParam(value = "ranking", required = false) @QueryParam ("ranking")  Integer ranking
        ,        @ApiParam(value = "limit", required = false) @QueryParam ("limit")  Integer limit
        ,        @ApiParam(value = "offset", required = false) @QueryParam ("offset")  Integer offset
    ) {
		return callImplementation(
         maxWinners
        ,         programWebPath
        ,         gameWebPath
        ,         participationTypeWebPath
        ,         participantWebPaths
        ,         ranking
        ,         limit
        ,         offset
		);
    }


	public QuizzParticipationOptionOutList callImplementation (
         Integer maxWinners
        ,         String programWebPath
        ,         String gameWebPath
        ,         String participationTypeWebPath
        ,          String participantWebPaths
        ,         Integer ranking
        ,         Integer limit
        ,         Integer offset
	) {
        QuizzParticipationOptionIn quizzParticipationOptionIn = new QuizzParticipationOptionIn ();
		quizzParticipationOptionIn.setMaxWinners (maxWinners);
		quizzParticipationOptionIn.setProgramWebPath (programWebPath);
		quizzParticipationOptionIn.setGameWebPath (gameWebPath);
		quizzParticipationOptionIn.setParticipationTypeWebPath (participationTypeWebPath);
		quizzParticipationOptionIn.setParticipantWebPaths (participantWebPaths);
		quizzParticipationOptionIn.setRanking (ranking);
		quizzParticipationOptionIn.setLimit (limit);
		quizzParticipationOptionIn.setOffset (offset);
        return quizzParticipationOptionDaoFace.execute(
        	quizzParticipationOptionIn
        );
	}
	



}
