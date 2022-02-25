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
	* - name      : REST.Exception-handling
	* - file name : REST.Exception-handling.vm
*/
package com.game.score.rest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.sql.SQLException;

@Provider
@Slf4j
public class GenericExceptionMapper implements ExceptionMapper<Throwable> { 

    @Override
    public Response toResponse(Throwable ex) {

        ErrorMessage errorMessage = new ErrorMessage();
        setHttpStatus(ex, errorMessage);
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setCause(ExceptionUtils.getStackTrace(ex));
        log.error(errorMessage.toString());

        return Response.status(errorMessage.getStatus())
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private void setHttpStatus(Throwable ex, ErrorMessage errorMessage) {
        if(ex instanceof WebApplicationException) {
            errorMessage.setStatus(Response.Status.fromStatusCode(((WebApplicationException)ex).getResponse().getStatus()));
            errorMessage.setCause("");
        } else {
            errorMessage.setStatus(Response.Status.INTERNAL_SERVER_ERROR); //defaults to internal server error 500
            if (ex instanceof SQLException) {
                errorMessage.setCause(((SQLException)ex).getErrorCode()+" - sql ex");
            } else if (ex instanceof HibernateException) {
                HibernateException he = (HibernateException)ex;
                errorMessage.setCause(he.getMessage()+" - hibernate ex; "+he.getCause().getMessage());
            } else {
                errorMessage.setMessage(ExceptionUtils.getMessage(ex));
            }
        }
    }

	@Data
    private class ErrorMessage {
        String code, message, cause;
        Response.StatusType status;
    }
}