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


package com.game.score.rest.property;
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
import com.game.score.sdd.out.property.GetPropertiesOutList;
import com.game.score.sdd.out.property.GetPropertiesOut;
import com.game.score.sdd.in.property.GetPropertiesIn;
import com.game.score.dao.sdd.face.property.GetPropertiesDaoFace;
import com.game.score.rest.Cacheable;
import com.game.score.rest.Compress;
/**
*
* <p>Title: GetPropertiesResource</p>
*
* <p>Description: class for GetPropertiesResource service </p>
*
*/
@Path("/sdd/GetPropertiesIn")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="/sdd/GetPropertiesIn", description = "operation about GetPropertiesIn")
public class GetPropertiesResource {
    @Autowired
    @Qualifier("getPropertiesDaoFace")
	GetPropertiesDaoFace getPropertiesDaoFace;
	

    @GET
    @Cacheable(cc = "public, max-age=3600")
	@Compress
    @ApiOperation(value = "get_properties", notes = "perform get_properties", response = GetPropertiesOutList.class)
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "ok")
    })
    public GetPropertiesOutList execute (
        @ApiParam(value = "entityType", required = false) @QueryParam ("entityType")  String entityType
        ,        @ApiParam(value = "entityWebPath", required = false) @QueryParam ("entityWebPath")  String entityWebPath
        ,        @ApiParam(value = "property", required = false) @QueryParam ("property")  String property
    ) {
		return callImplementation(
         entityType
        ,         entityWebPath
        ,         property
		);
    }


	public GetPropertiesOutList callImplementation (
         String entityType
        ,         String entityWebPath
        ,         String property
	) {
        GetPropertiesIn getPropertiesIn = new GetPropertiesIn ();
		getPropertiesIn.setEntityType (entityType);
		getPropertiesIn.setEntityWebPath (entityWebPath);
		getPropertiesIn.setProperty (property);
        return getPropertiesDaoFace.execute(
        	getPropertiesIn
        );
	}
	





}
