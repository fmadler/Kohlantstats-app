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
import com.game.score.sdd.out.timeline.ScoreTimelineOutList;
import com.game.score.sdd.out.timeline.ScoreTimelineOut;
import com.game.score.sdd.in.timeline.ScoreTimelineIn;
import com.game.score.dao.sdd.face.timeline.ScoreTimelineDaoFace;
import com.game.score.rest.Cacheable;
import com.game.score.rest.Compress;
/**
*
* <p>Title: ScoreTimelineResource</p>
*
* <p>Description: class for ScoreTimelineResource service </p>
*
*/
@Path("/sdd/ScoreTimelineIn")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="/sdd/ScoreTimelineIn", description = "operation about ScoreTimelineIn")
public class ScoreTimelineResource {
    @Autowired
    @Qualifier("scoreTimelineDaoFace")
	ScoreTimelineDaoFace scoreTimelineDaoFace;
	

    @GET
    @Cacheable(cc = "public, max-age=3600")
	@Compress
    @ApiOperation(value = "score_timeline", notes = "perform score_timeline", response = ScoreTimelineOutList.class)
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "ok")
    })
    public ScoreTimelineOutList execute (
        @ApiParam(value = "programWebPath", required = false) @QueryParam ("programWebPath")  String programWebPath
        ,        @ApiParam(value = "playerWebPaths", required = false) @QueryParam ("playerWebPaths")   String playerWebPaths
        ,        @ApiParam(value = "playerWebPath", required = false) @QueryParam ("playerWebPath")   String playerWebPath
        ,        @ApiParam(value = "day", required = false) @QueryParam ("day")  Integer day
        ,        @ApiParam(value = "rankingLessThanEqualTo", required = false) @QueryParam ("rankingLessThanEqualTo")  Integer rankingLessThanEqualTo
    ) {
		return callImplementation(
         programWebPath
        ,         playerWebPaths
        ,         playerWebPath
        ,         day
        ,         rankingLessThanEqualTo
		);
    }


	public ScoreTimelineOutList callImplementation (
         String programWebPath
        ,          String playerWebPaths
        ,          String playerWebPath
        ,         Integer day
        ,         Integer rankingLessThanEqualTo
	) {
        ScoreTimelineIn scoreTimelineIn = new ScoreTimelineIn ();
		scoreTimelineIn.setProgramWebPath (programWebPath);
		scoreTimelineIn.setPlayerWebPaths (playerWebPaths);
		scoreTimelineIn.setPlayerWebPath (playerWebPath);
		scoreTimelineIn.setDay (day);
		scoreTimelineIn.setRankingLessThanEqualTo (rankingLessThanEqualTo);
        return scoreTimelineDaoFace.execute(
        	scoreTimelineIn
        );
	}
	
    @GET
    @Path ("/getParticipants")
    @ApiOperation(value = "getParticipants", notes = "getParticipants", response = Participant.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "ok")
    })
    public List<Participant> getParticipants (
        @ApiParam(value = "programWebPath", required = false) @QueryParam ("programWebPath")  String programWebPath
        ,        @ApiParam(value = "playerWebPaths", required = false) @QueryParam ("playerWebPaths")   String playerWebPaths
        ,        @ApiParam(value = "playerWebPath", required = false) @QueryParam ("playerWebPath")   String playerWebPath
        ,        @ApiParam(value = "day", required = false) @QueryParam ("day")  Integer day
        ,        @ApiParam(value = "rankingLessThanEqualTo", required = false) @QueryParam ("rankingLessThanEqualTo")  Integer rankingLessThanEqualTo
    ) {
        ScoreTimelineOutList list = execute(
 programWebPath
, playerWebPaths
, playerWebPath
, day
, rankingLessThanEqualTo
			);
        return getParticipants(list);
    }
    @GET
    @Path ("/getResults")
    @ApiOperation(value = "getResults", notes = "getResults", response = Result.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "ok")
    })
    public List<Result> getResults (
        @ApiParam(value = "programWebPath", required = false) @QueryParam ("programWebPath")  String programWebPath
        ,        @ApiParam(value = "playerWebPaths", required = false) @QueryParam ("playerWebPaths")   String playerWebPaths
        ,        @ApiParam(value = "playerWebPath", required = false) @QueryParam ("playerWebPath")   String playerWebPath
        ,        @ApiParam(value = "day", required = false) @QueryParam ("day")  Integer day
        ,        @ApiParam(value = "rankingLessThanEqualTo", required = false) @QueryParam ("rankingLessThanEqualTo")  Integer rankingLessThanEqualTo
    ) {
        ScoreTimelineOutList list = execute(
 programWebPath
, playerWebPaths
, playerWebPath
, day
, rankingLessThanEqualTo
			);
        return getResults(list);
    }



	@lombok.Data
	private class Participant {
		String fullWebPath;
		String entityWebPath;
		String entityTypeWebPath;
		String contextWebPath;
		String contextTypeWebPath;

		@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)	
		List<Result> results = new ArrayList<>();
		public void addResult(Result e) {
			getResults().add(e);
		}
	}
	

	public List<Participant> getParticipants (ScoreTimelineOutList input) {
        List<Participant> ret = new ArrayList<>();
        Map<String, Participant> map = new HashMap<String, Participant>();
        for (ScoreTimelineOut pivot : input.getScoreTimelineOuts()) {
            Participant p = map.get(pivot.getFullWebPath());

            if (p==null) {
                p = new Participant();
                p.fullWebPath = pivot.getFullWebPath();
                p.entityWebPath = pivot.getEntityWebPath();
                p.entityTypeWebPath = pivot.getEntityTypeWebPath();
                p.contextWebPath = pivot.getContextWebPath();
                p.contextTypeWebPath = pivot.getContextTypeWebPath();
                map.put(pivot.getFullWebPath(), p);
            }
            Result result = new Result();
            result.day = pivot.getDay();
            result.score = pivot.getScore();
            result.longevity = pivot.getLongevity();
            result.gameScore1 = pivot.getGameScore1();
            result.gameScore2 = pivot.getGameScore2();
            p.addResult(result);
        }
        for (Participant e : map.values()) {
            ret.add(e);
        }
        return ret;
    }
	
	@lombok.Data
	private class Result {
		Integer day;
		java.math.BigDecimal score;
		java.math.BigDecimal longevity;
		java.math.BigDecimal gameScore1;
		java.math.BigDecimal gameScore2;

		@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)	
		List<Participant> participants = new ArrayList<>();
		public void addParticipant(Participant e) {
			getParticipants().add(e);
		}
	}
	

	public List<Result> getResults (ScoreTimelineOutList input) {
        List<Result> ret = new ArrayList<>();
        Map<Integer, Result> map = new HashMap<Integer, Result>();
        for (ScoreTimelineOut pivot : input.getScoreTimelineOuts()) {
            Result p = map.get(pivot.getDay());

            if (p==null) {
                p = new Result();
                p.day = pivot.getDay();
                p.score = pivot.getScore();
                p.longevity = pivot.getLongevity();
                p.gameScore1 = pivot.getGameScore1();
                p.gameScore2 = pivot.getGameScore2();
                map.put(pivot.getDay(), p);
            }
            Participant participant = new Participant();
            participant.fullWebPath = pivot.getFullWebPath();
            participant.entityWebPath = pivot.getEntityWebPath();
            participant.entityTypeWebPath = pivot.getEntityTypeWebPath();
            participant.contextWebPath = pivot.getContextWebPath();
            participant.contextTypeWebPath = pivot.getContextTypeWebPath();
            p.addParticipant(participant);
        }
        for (Result e : map.values()) {
            ret.add(e);
        }
        return ret;
    }
	


}
