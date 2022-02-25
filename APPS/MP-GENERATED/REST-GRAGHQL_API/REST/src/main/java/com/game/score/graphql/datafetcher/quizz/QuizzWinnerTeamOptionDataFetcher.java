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
package com.game.score.graphql.datafetcher.quizz;

import com.game.score.sdd.in.quizz.QuizzWinnerTeamOptionIn;
import com.game.score.dao.sdd.face.quizz.QuizzWinnerTeamOptionDaoFace;
import com.game.score.sdd.out.quizz.QuizzWinnerTeamOptionOutList;
import com.game.score.sdd.out.quizz.QuizzWinnerTeamOptionOut;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuizzWinnerTeamOptionDataFetcher implements DataFetcher<List<QuizzWinnerTeamOptionOut>>{

    @Autowired
    @Qualifier("quizzWinnerTeamOptionDaoFace")
    QuizzWinnerTeamOptionDaoFace quizzWinnerTeamOptionDaoFace;

    @Override
    public List<QuizzWinnerTeamOptionOut> get(DataFetchingEnvironment dataFetchingEnvironment) {
        QuizzWinnerTeamOptionIn quizzWinnerTeamOptionIn = new QuizzWinnerTeamOptionIn ();
        quizzWinnerTeamOptionIn.setProgramWebPath (dataFetchingEnvironment.getArgument("programWebPath"));
        quizzWinnerTeamOptionIn.setRanking (dataFetchingEnvironment.getArgument("ranking"));
        quizzWinnerTeamOptionIn.setGameWebPath (dataFetchingEnvironment.getArgument("gameWebPath"));
        quizzWinnerTeamOptionIn.setLimit (dataFetchingEnvironment.getArgument("limit"));
        quizzWinnerTeamOptionIn.setOffset (dataFetchingEnvironment.getArgument("offset"));
        return quizzWinnerTeamOptionDaoFace.execute (
        	quizzWinnerTeamOptionIn
            ).getQuizzWinnerTeamOptionOuts();
    }

}
