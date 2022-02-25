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
	* - name      : SDDOutputBeanCollection
	* - file name : JavaBeanCollection.vm
*/
package com.game.score.sdd.out.quizz;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import com.game.score.sdd.out.quizz.QuizzWinnerTeamMatrixOut;


/**
 *
 * <p>Title: QuizzWinnerTeamMatrixOutList</p>
 *
 * <p>Description: Java Bean QuizzWinnerTeamMatrixOutList </p>
 *
 */
@XmlRootElement (name="QuizzWinnerTeamMatrixOutList")
public class QuizzWinnerTeamMatrixOutList {

    @XmlElement (name="QuizzWinnerTeamMatrixOut") //(name="quizzwinnerteammatrixouts")
    private List<QuizzWinnerTeamMatrixOut> quizzWinnerTeamMatrixOuts;

    /**
    * Default constructor
    */
    public QuizzWinnerTeamMatrixOutList() {
    }
	
    public void setQuizzWinnerTeamMatrixOuts (List<QuizzWinnerTeamMatrixOut> quizzWinnerTeamMatrixOuts) {
        this.quizzWinnerTeamMatrixOuts = quizzWinnerTeamMatrixOuts;
    }

    @XmlTransient
    public List<QuizzWinnerTeamMatrixOut> getQuizzWinnerTeamMatrixOuts () {
        if (quizzWinnerTeamMatrixOuts==null)
            quizzWinnerTeamMatrixOuts = new ArrayList<>();
        return quizzWinnerTeamMatrixOuts;
    }

    public void addQuizzWinnerTeamMatrixOut (QuizzWinnerTeamMatrixOut quizzWinnerTeamMatrixOut) {
        getQuizzWinnerTeamMatrixOuts ().add(quizzWinnerTeamMatrixOut);
    }



}
