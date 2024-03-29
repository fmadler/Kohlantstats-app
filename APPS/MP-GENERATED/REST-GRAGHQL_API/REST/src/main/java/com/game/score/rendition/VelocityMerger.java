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
	* - name      : VelocityMerger
	* - file name : VelocityMerger.java.vm
*/
package com.game.score.rendition;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * VelocityMerger class to be used to transform a Map containing a set of Object into HTML, XML or Other format.
 *
 * <p>
 * This class could be used also for generating XSL-FO files to generate PDF File using Apache Fop.
 * @author devuser
 *
 */
public class VelocityMerger implements InitializingBean {

	private static final Logger logger = LoggerFactory.getLogger(VelocityMerger.class);

	private VelocityEngine engine;
	private Resource toolBoxConfigLocation;
	private String toolBoxConfigurationPath;

	public void setToolBoxConfigLocation(Resource toolBoxConfigLocation) {
		this.toolBoxConfigLocation = toolBoxConfigLocation;
	}

	public void setEngine(VelocityEngine engine) {
		this.engine = engine;
	}

	public void afterPropertiesSet() {
		//TODO if start with classpath => loads from cp
		//https://github.com/testinfected/petstore/blob/master/petstore-app/src/main/webapp/WEB-INF/petstore.xml
		//http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/view/velocity/VelocityViewResolver.html
		try {
			toolBoxConfigurationPath = toolBoxConfigLocation.getFile().getAbsolutePath();

			if (logger.isInfoEnabled()) {
				logger.info("Resource loader path '{}' resolved to file '{}'", toolBoxConfigLocation.getURI(), toolBoxConfigurationPath);
			}
		} catch (IOException ioe) {
			toolBoxConfigurationPath = null;
		}
	}

	public String merge(String templateName, Map<String, Object> model) {
		return VelocityUtils.mergeTemplateIntoString(engine, templateName, model, toolBoxConfigurationPath);
	}

	public String merge(String templateName, String templateEncoding, Map<String, Object> model) {
		return VelocityUtils.mergeTemplateIntoString(engine, templateName, templateEncoding, model,toolBoxConfigurationPath);
	}

	public void mergeToWriter(String templateName, Map<String, Object> model, Writer writer) {
		VelocityUtils.mergeTemplate(engine, templateName, model, writer, toolBoxConfigurationPath);
	}

	public void mergeToWriter(String templateName, String templateEncoding, Map<String, Object> model, Writer writer) {
		VelocityUtils.mergeTemplate(engine, templateName, templateEncoding, model, writer,
				toolBoxConfigurationPath);
	}
}
