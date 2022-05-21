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

import com.game.score.sdd.in.vote.SecondVoteAgainstIn;
import com.game.score.dao.sdd.face.vote.SecondVoteAgainstDaoFace;
import com.game.score.sdd.out.vote.SecondVoteAgainstOutList;
import com.game.score.sdd.out.vote.SecondVoteAgainstOut;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecondVoteAgainstDataFetcher implements DataFetcher<List<SecondVoteAgainstOut>> {

    @Autowired
    @Qualifier("secondVoteAgainstDaoFace")
    SecondVoteAgainstDaoFace secondVoteAgainstDaoFace;

    @Override
    public List<SecondVoteAgainstOut> get(DataFetchingEnvironment dataFetchingEnvironment) {
        SecondVoteAgainstIn secondVoteAgainstIn = new SecondVoteAgainstIn ();
        secondVoteAgainstIn.setVoterWebPath (dataFetchingEnvironment.getArgument("voterWebPath"));
        secondVoteAgainstIn.setVoterTargetWebPath (dataFetchingEnvironment.getArgument("voterTargetWebPath"));
        secondVoteAgainstIn.setTeamWebPath (dataFetchingEnvironment.getArgument("teamWebPath"));
        secondVoteAgainstIn.setTimeUnit (dataFetchingEnvironment.getArgument("timeUnit"));
        secondVoteAgainstIn.setVoteEffectivenessTypeWebPath (dataFetchingEnvironment.getArgument("voteEffectivenessTypeWebPath"));
        return secondVoteAgainstDaoFace.execute (
        	secondVoteAgainstIn
            ).getSecondVoteAgainstOuts();
    }

}
