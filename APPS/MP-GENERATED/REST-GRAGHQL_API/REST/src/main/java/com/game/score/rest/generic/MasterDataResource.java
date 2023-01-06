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
	
package com.game.score.rest.generic;


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
import com.game.score.sdd.out.generic.MasterDataOutList;
import com.game.score.sdd.out.generic.MasterDataOut;
import com.game.score.dao.sdd.face.generic.MasterDataDaoFace;
import com.game.score.rest.Cacheable;
import com.game.score.rest.Compress;
/**
*
* <p>Title: MasterDataResource</p>
*
* <p>Description: class for MasterDataResource service </p>
* <p>Convention: $query.getNamingConvention() </p>
*
*/
@Path("/sdd/MasterDataIn")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="/sdd/MasterDataIn", description = "operation about MasterDataIn")
public class MasterDataResource {
    @Autowired
    @Qualifier("masterDataDaoFace")
	MasterDataDaoFace masterDataDaoFace;
	

    @GET
    @Cacheable(cc = "public, max-age=3600")
	@Compress
    @ApiOperation(value = "master_data", notes = "perform master_data", response = MasterDataOutList.class)
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "ok")
    })
    public MasterDataOutList execute (
        @ApiParam(value = "table", required=true, allowableValues = "gs_team_departure_type,gs_team_entrance_type,gs_team_reward_type,gs_game_type,gs_game_stake_type,gs_realisation_type,gs_vote_type" ) @QueryParam ("table")  String table
        ,        @ApiParam(value = "orderby", required=true, allowableValues = "id,name,web_path" ) @QueryParam ("orderby")  String orderby
        ,        @ApiParam(value = "sort", required=true, allowableValues = "ascending,descending" ) @QueryParam ("sort")  String sort
    ) {
		return callImplementation(
         table
        ,         orderby
        ,         sort
		);
    }


	public MasterDataOutList callImplementation (
         String table
        ,         String orderby
        ,         String sort
	) {
        return masterDataDaoFace.execute(
             table
            , orderby
            , sort
        );
	}
	



}
