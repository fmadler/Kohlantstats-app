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
package com.game.score.service.impl.quizz;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.score.sdd.out.quizz.QuizzWinnerParticipantOrderOptionOutList;
import com.game.score.sdd.out.quizz.QuizzWinnerParticipantOrderOptionOut;
import com.game.score.sdd.in.quizz.QuizzWinnerParticipantOrderOptionIn;
import com.game.score.dao.sdd.face.quizz.QuizzWinnerParticipantOrderOptionDaoFace;
import com.game.score.service.face.quizz.QuizzWinnerParticipantOrderOptionService;

/**
 *
 * <p>Title: QuizzWinnerParticipantOrderOptionServiceImpl</p>
 *
 * <p>Description: SDD Spring service implementation </p>
 *
 */
@Service ("quizzWinnerParticipantOrderOptionService")
@Transactional
public class QuizzWinnerParticipantOrderOptionServiceImpl implements QuizzWinnerParticipantOrderOptionService{
    @Autowired
    @Qualifier("quizzWinnerParticipantOrderOptionDaoFace")
    QuizzWinnerParticipantOrderOptionDaoFace quizzWinnerParticipantOrderOptionDaoFace;
    

    public QuizzWinnerParticipantOrderOptionOutList execute (
		QuizzWinnerParticipantOrderOptionIn quizzWinnerParticipantOrderOptionIn
    	) {
        return quizzWinnerParticipantOrderOptionDaoFace.execute (
			quizzWinnerParticipantOrderOptionIn
        );
    }




}