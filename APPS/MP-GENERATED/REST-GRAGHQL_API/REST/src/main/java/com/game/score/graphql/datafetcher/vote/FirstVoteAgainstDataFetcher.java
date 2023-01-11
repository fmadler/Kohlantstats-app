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
package com.game.score.graphql.datafetcher.vote;

import com.game.score.sdd.in.vote.FirstVoteAgainstIn;
import com.game.score.dao.sdd.face.vote.FirstVoteAgainstDaoFace;
import com.game.score.sdd.out.vote.FirstVoteAgainstOutList;
import com.game.score.sdd.out.vote.FirstVoteAgainstOut;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FirstVoteAgainstDataFetcher implements DataFetcher<List<FirstVoteAgainstOut>> {

    @Autowired
    @Qualifier("firstVoteAgainstDaoFace")
    FirstVoteAgainstDaoFace firstVoteAgainstDaoFace;

    @Override
    public List<FirstVoteAgainstOut> get(DataFetchingEnvironment dataFetchingEnvironment) {
        FirstVoteAgainstIn firstVoteAgainstIn = new FirstVoteAgainstIn ();
        firstVoteAgainstIn.setVoterWebPath (dataFetchingEnvironment.getArgument("voterWebPath"));
        firstVoteAgainstIn.setVoterTargetWebPath (dataFetchingEnvironment.getArgument("voterTargetWebPath"));
        firstVoteAgainstIn.setTeamWebPath (dataFetchingEnvironment.getArgument("teamWebPath"));
        firstVoteAgainstIn.setTimeUnit (dataFetchingEnvironment.getArgument("timeUnit"));
        firstVoteAgainstIn.setVoteEffectivenessTypeWebPath (dataFetchingEnvironment.getArgument("voteEffectivenessTypeWebPath"));
        return firstVoteAgainstDaoFace.execute (
        	firstVoteAgainstIn
            ).getFirstVoteAgainstOuts();
    }

}
