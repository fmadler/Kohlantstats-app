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
	* - name      : REST.JWTTokenNeededFilter
	* - file name : REST.JWTTokenNeededFilter.vm
*/
package com.game.score.rest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

// inspired by https://antoniogoncalves.org/2016/10/03/securing-jax-rs-endpoints-with-jwt/
@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
@Slf4j
public class JWTTokenNeededFilter implements ContainerRequestFilter {

    //@Inject
    //To fix not working
    //private KeyGenerator keyGenerator;

    @Override
    public void filter(ContainerRequestContext requestContext) {

        // Get the HTTP Authorization header from the request
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();

        try {

            // Validate the token
            JWTUtils.validateToken(token);

        } catch (Exception e) {
            //log.error(">> invalid token : " + token);
            log.error(">> invalid token exception : " + e);
            //log.error(">> invalid token exception stack : " + ExceptionUtils.getStackTrace(e));
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}