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
	* - name      : REST.GraphQL.spring.endpoint
	* - file name : REST.GraphQL.spring.endpoint.vm
*/
package com.game.score.rest;

import com.game.score.graphql.ScoreGraphQLService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Path("/graphql")
public class GraphQLRestAPI {

    @Autowired
    ScoreGraphQLService scoreGraphQLService;

    @GET
    @Path("/graphiql")
    public Response graphiql() throws IOException {
        Resource resource = scoreGraphQLService.getGraphiql();
        File schemaFile = resource.getFile();
        return Response.ok(schemaFile, MediaType.TEXT_HTML).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response performQuery(String input) throws IOException {
        if (input==null) {
            return schema();
        }
        GraphQLInput gi = mapToGraphQLInput(input, new GraphQLRestAPI.GraphQLInput());
        ExecutionInput ei = ExecutionInput.newExecutionInput()
            .query(gi.getQuery())
            .variables(gi.getVariables())
            .build();
        ExecutionResult execute = scoreGraphQLService.getGraphQL().execute(ei);

        return Response
            .status(Response.Status.OK)
            .type(MediaType.APPLICATION_JSON)
            .entity(execute)
            .build();
    }

    public Response schema() throws IOException{
        Resource resource = scoreGraphQLService.getResource();
        File schemaFile = resource.getFile();
        return Response.ok(schemaFile, MediaType.TEXT_HTML).build();
    }

    public static GraphQLInput mapToGraphQLInput (String input, GraphQLInput graphqlInput) {
        Gson gson = new GsonBuilder().create();
        Map<String,Object> jsonMap = (input!=null)?gson.fromJson(input, Map.class):new HashMap();
        graphqlInput.setQuery((String)jsonMap.get("query"));
        graphqlInput.setVariables((Map<String,Object>)jsonMap.get("variables"));
        return graphqlInput;
    }

    @Data
    public class GraphQLInput {
        String query;
        Map<String, Object> variables;
        String mutation;
        String operationName;
    }

}
