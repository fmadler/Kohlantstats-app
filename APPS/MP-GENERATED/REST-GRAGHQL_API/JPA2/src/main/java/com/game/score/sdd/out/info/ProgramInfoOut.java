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
	* - name      : SDDOutputBean
	* - file name : JavaBean.vm
*/
package com.game.score.sdd.out.info;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import lombok.Data;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import com.game.utils.JacksonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * <p>Title: ProgramInfoOut</p>
 *
 * <p>Description: ProgramInfo Java Bean </p>
 *
 */
@Data
public class ProgramInfoOut {

    private String name;
    private String webPath;
    private Integer year;
    private Integer editionNumber;
    private Integer totalTimeLength;
    private String country;
    private String countryFlag;
    private String countryWebPath;
    private String place;
    private String placeWebPath;
    private java.math.BigDecimal latitude;
    private java.math.BigDecimal longitude;
	@Data
	public class Winners {
		String name;
		String webPath;
	}
    private List<Winners> winners;
    private Long nbOfParticipants;
    private Long nbOfGames;

}
