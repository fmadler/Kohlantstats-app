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
	* - name      : REST.Cache.ControlDecorator
	* - file name : REST.Cache.ControlDecorator.vm
*/
package com.game.score.rest;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ControlDecorator implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext,
		ContainerResponseContext responseContext) throws IOException {
		for (Annotation a : responseContext.getEntityAnnotations()) {
			if (a.annotationType() == Cacheable.class) {
				String cc = ((Cacheable) a).cc();
				responseContext.getHeaders().add("Cache-Control", cc);
			}
		}
	}
}