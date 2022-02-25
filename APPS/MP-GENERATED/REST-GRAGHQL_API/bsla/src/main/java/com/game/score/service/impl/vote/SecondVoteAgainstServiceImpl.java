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
package com.game.score.service.impl.vote;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.score.sdd.out.vote.SecondVoteAgainstOutList;
import com.game.score.sdd.out.vote.SecondVoteAgainstOut;
import com.game.score.sdd.in.vote.SecondVoteAgainstIn;
import com.game.score.dao.sdd.face.vote.SecondVoteAgainstDaoFace;
import com.game.score.service.face.vote.SecondVoteAgainstService;

/**
 *
 * <p>Title: SecondVoteAgainstServiceImpl</p>
 *
 * <p>Description: SDD Spring service implementation </p>
 *
 */
@Service ("secondVoteAgainstService")
@Transactional
public class SecondVoteAgainstServiceImpl implements SecondVoteAgainstService{
    @Autowired
    @Qualifier("secondVoteAgainstDaoFace")
    SecondVoteAgainstDaoFace secondVoteAgainstDaoFace;
    

    public SecondVoteAgainstOutList execute (
		SecondVoteAgainstIn secondVoteAgainstIn
    	) {
        return secondVoteAgainstDaoFace.execute (
			secondVoteAgainstIn
        );
    }




}