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
	
package com.game.score.rest.timeline;


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
import com.game.score.sdd.out.timeline.TeamParticipantTimelineOutList;
import com.game.score.sdd.out.timeline.TeamParticipantTimelineOut;
import com.game.score.sdd.in.timeline.TeamParticipantTimelineIn;
import com.game.score.dao.sdd.face.timeline.TeamParticipantTimelineDaoFace;
import com.game.score.rest.Cacheable;
import com.game.score.rest.Compress;
/**
*
* <p>Title: TeamParticipantTimelineResource</p>
*
* <p>Description: class for TeamParticipantTimelineResource service </p>
* <p>Convention: $query.getNamingConvention() </p>
*
*/
@Path("/sdd/TeamParticipantTimelineIn")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="/sdd/TeamParticipantTimelineIn", description = "operation about TeamParticipantTimelineIn")
public class TeamParticipantTimelineResource {
    @Autowired
    @Qualifier("teamParticipantTimelineDaoFace")
	TeamParticipantTimelineDaoFace teamParticipantTimelineDaoFace;
	

    @GET
    @Cacheable(cc = "public, max-age=3600")
	@Compress
    @ApiOperation(value = "team_participant_timeline", notes = "perform team_participant_timeline", response = TeamParticipantTimelineOutList.class)
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "ok")
    })
    public TeamParticipantTimelineOutList execute (
        @ApiParam(value = "programWebPath", required = false) @QueryParam ("programWebPath")  String programWebPath
        ,        @ApiParam(value = "teamWebPath", required = false) @QueryParam ("teamWebPath")  String teamWebPath
        ,        @ApiParam(value = "playerWebPath", required = false) @QueryParam ("playerWebPath")  String playerWebPath
    ) {
		return callImplementation(
         programWebPath
        ,         teamWebPath
        ,         playerWebPath
		);
    }


	public TeamParticipantTimelineOutList callImplementation (
         String programWebPath
        ,         String teamWebPath
        ,         String playerWebPath
	) {
        TeamParticipantTimelineIn teamParticipantTimelineIn = new TeamParticipantTimelineIn ();
		teamParticipantTimelineIn.setProgramWebPath (programWebPath);
		teamParticipantTimelineIn.setTeamWebPath (teamWebPath);
		teamParticipantTimelineIn.setPlayerWebPath (playerWebPath);
        return teamParticipantTimelineDaoFace.execute(
        	teamParticipantTimelineIn
        );
	}
	



}
