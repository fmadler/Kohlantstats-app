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
	* - name      : SDDSpringServiceImpl
	* - file name : SDDSpringServiceImpl.vm
*/
package com.game.score.service.impl.team;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.score.sdd.out.team.CreateParticipantDepartureOutList;
import com.game.score.sdd.out.team.CreateParticipantDepartureOut;
import com.game.score.sdd.in.team.CreateParticipantDepartureIn;
import com.game.score.dao.sdd.face.team.CreateParticipantDepartureDaoFace;
import com.game.score.service.face.team.CreateParticipantDepartureService;

/**
 *
 * <p>Title: CreateParticipantDepartureServiceImpl</p>
 *
 * <p>Description: SDD Spring service implementation </p>
 *
 */
@Service ("createParticipantDepartureService")
@Transactional
public class CreateParticipantDepartureServiceImpl implements CreateParticipantDepartureService{
    @Autowired
    @Qualifier("createParticipantDepartureDaoFace")
    CreateParticipantDepartureDaoFace createParticipantDepartureDaoFace;
    

    public CreateParticipantDepartureOutList execute (
		CreateParticipantDepartureIn createParticipantDepartureIn
    	) {
        return createParticipantDepartureDaoFace.execute (
			createParticipantDepartureIn
        );
    }




}