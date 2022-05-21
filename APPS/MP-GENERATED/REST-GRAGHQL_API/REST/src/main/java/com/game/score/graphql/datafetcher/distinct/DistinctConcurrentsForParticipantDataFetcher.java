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
package com.game.score.graphql.datafetcher.distinct;

import com.game.score.sdd.in.distinct.DistinctConcurrentsForParticipantIn;
import com.game.score.dao.sdd.face.distinct.DistinctConcurrentsForParticipantDaoFace;
import com.game.score.sdd.out.distinct.DistinctConcurrentsForParticipantOutList;
import com.game.score.sdd.out.distinct.DistinctConcurrentsForParticipantOut;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DistinctConcurrentsForParticipantDataFetcher implements DataFetcher<List<DistinctConcurrentsForParticipantOut>> {

    @Autowired
    @Qualifier("distinctConcurrentsForParticipantDaoFace")
    DistinctConcurrentsForParticipantDaoFace distinctConcurrentsForParticipantDaoFace;

    @Override
    public List<DistinctConcurrentsForParticipantOut> get(DataFetchingEnvironment dataFetchingEnvironment) {
        DistinctConcurrentsForParticipantIn distinctConcurrentsForParticipantIn = new DistinctConcurrentsForParticipantIn ();
        distinctConcurrentsForParticipantIn.setPlayerWebPath (dataFetchingEnvironment.getArgument("playerWebPath"));
        return distinctConcurrentsForParticipantDaoFace.execute (
        	distinctConcurrentsForParticipantIn
            ).getDistinctConcurrentsForParticipantOuts();
    }

}
