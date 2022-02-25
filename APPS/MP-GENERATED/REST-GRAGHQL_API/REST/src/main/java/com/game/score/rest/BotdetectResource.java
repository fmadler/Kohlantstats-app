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
	* - name      : REST.application.botdetect.captcha
	* - file name : REST.application.botdetect.captcha.vm
*/
package com.game.score.rest;

import com.captcha.botdetect.web.servlet.SimpleCaptcha;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Path("captcha/botdetect")
@Produces(MediaType.APPLICATION_JSON)
@Data
@Slf4j
public class BotdetectResource {

    @Context
    HttpServletRequest request;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String validate() throws ServletException, IOException {

        Gson gson = new Gson();

        JsonParser parser = new JsonParser();
        JsonObject formDataObj = (JsonObject) parser.parse(request.getReader());

        String userEnteredCaptchaCode = formDataObj.get("userEnteredCaptchaCode").getAsString();
        String captchaId = formDataObj.get("captchaId").getAsString();

        // create a captcha instance to be used for the captcha validation
        SimpleCaptcha captcha = SimpleCaptcha.load(request);
        // execute the captcha validation
        boolean isHuman = captcha.validate(userEnteredCaptchaCode, captchaId);

        // create an object that stores the validation result
        BasicValidationResult validationResult = new BasicValidationResult();

        if (isHuman == false) {
            // captcha validation failed
            validationResult.setSuccess(false);
            // TODO: consider logging the attempt
        } else {
            // captcha validation succeeded
            validationResult.setSuccess(true);
        }
        return gson.toJson(validationResult);
    }
}

class BasicValidationResult {
    private boolean success;

    public BasicValidationResult() {
    }

    public boolean getSuccess() {
    return success;
    }

    public void setSuccess(boolean success) {
    this.success = success;
    }
}