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
	* - name      : Spring.GraphQL.datafetcher
	* - file name : Spring.GraphQL.datafetcher.vm
*/
package com.game.score.graphql.datafetcher.team;

import com.game.score.sdd.in.team.CreateParticipantEntranceIn;
import com.game.score.dao.sdd.face.team.CreateParticipantEntranceDaoFace;
import com.game.score.sdd.out.team.CreateParticipantEntranceOutList;
import com.game.score.sdd.out.team.CreateParticipantEntranceOut;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateParticipantEntranceDataFetcher implements DataFetcher<List<CreateParticipantEntranceOut>> {

    @Autowired
    @Qualifier("createParticipantEntranceDaoFace")
    CreateParticipantEntranceDaoFace createParticipantEntranceDaoFace;

    @Override
    public List<CreateParticipantEntranceOut> get(DataFetchingEnvironment dataFetchingEnvironment) {
        CreateParticipantEntranceIn createParticipantEntranceIn = new CreateParticipantEntranceIn ();
        createParticipantEntranceIn.setProgramWebPath (dataFetchingEnvironment.getArgument("programWebPath"));
        createParticipantEntranceIn.setParticipantWebPath (dataFetchingEnvironment.getArgument("participantWebPath"));
        createParticipantEntranceIn.setTeamWebPath (dataFetchingEnvironment.getArgument("teamWebPath"));
        createParticipantEntranceIn.setFromTime (dataFetchingEnvironment.getArgument("fromTime"));
        createParticipantEntranceIn.setEntranceTypeWebPath (dataFetchingEnvironment.getArgument("entranceTypeWebPath"));
        createParticipantEntranceIn.setParticipantTeamId (dataFetchingEnvironment.getArgument("participantTeamId"));
        return createParticipantEntranceDaoFace.execute (
        	createParticipantEntranceIn
            ).getCreateParticipantEntranceOuts();
    }

}
