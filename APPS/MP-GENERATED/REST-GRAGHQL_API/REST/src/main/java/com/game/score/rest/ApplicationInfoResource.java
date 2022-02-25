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
	* - name      : REST.environment.build.info
	* - file name : REST.environment.build.info.vm
*/
package com.game.score.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.Properties;

import com.game.score.rest.Cacheable;

@Path("score/applicationinfo")
@Produces(MediaType.APPLICATION_JSON)
@Data
@Slf4j
public class ApplicationInfoResource {

	@Context
	HttpServletRequest req;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Cacheable(cc = "public, max-age=36000")
    public ApplicationInfo getApplicationInfo() throws IOException{
        return getApplicationInfoDetails();
    }
    
    @Data
    class ApplicationInfo {
    	private String environment;
    	private String buildNumber;
    	private String buildTime;
    	private String buildId;
    	private String applicationVersion;
    	private String vcsRevision;
    }

    public ApplicationInfo getApplicationInfoDetails() {
        ApplicationInfo applicationInfo = new ApplicationInfo();
        try {
            Properties props = new Properties();
            props.load(getClass().getResourceAsStream("/application.properties"));
            
            applicationInfo.buildNumber = props.getProperty("build.number");
            applicationInfo.buildTime = props.getProperty("build.time");
            applicationInfo.buildId = props.getProperty("build.id");
            applicationInfo.applicationVersion = props.getProperty("application.version");
            applicationInfo.vcsRevision = props.getProperty("vcs.version");
            
            //TODO environment is found from the file referenced by system properties passed as a runtime parameter
            //via system prop -Denv="PROTO" or -Denvironment="PROTO" System.getProperty("environment")
            applicationInfo.environment = getEnvironment(props);
        } catch (IOException ioe) {
            log.error("cannot load application.properties");
        }
        return applicationInfo;
    }
    
    public static String getEnvironment(Properties props) {
		String environment = System.getProperty("environment");
		if (environment == null) {
			environment = System.getProperty("env");
		}
		if (environment == null) {
			environment = System.getProperty("spring.profiles.active");
		}
		if (environment == null) {
			environment = props.getProperty("environment");
			if (environment.equals("${environment}")) {					
				environment = null;
			}
		}
		if (environment == null) {
			environment = "TBD";
		}
		return environment;
	}

}