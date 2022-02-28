/*
	 Copyright (c) minuteproject, minuteproject@gmail.com
	 All rights reserved.
	 
	 Licensed under the Apache License, Version 2.0 (the "License")
	 you may not use this file except in compliance with the License.
	 You may obtain a copy of the License at
	 
	 http://www.apache.org/licenses/LICENSE-2.0
	 
	 Unless required by applicable law or agreed to in writing, software
	 distributed under the License is distributed on an "AS IS" BASIS,
	 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 See the License for the specific language governing permissions and
	 limitations under the License.
	 
	 More information on minuteproject:
	 twitter @minuteproject
	 wiki http://minuteproject.wikispaces.com 
	 blog http://minuteproject.blogspot.net
	 
*/
/*
	 template reference : 
	 - Minuteproject version : 0.9.11
	 - name      : EmberAdapterJs
	 - file name : EmberAdapterJs.vm
*/
import JSONAPIAdapter from '@ember-data/adapter/json-api';
import {fetchData} from '../utils/common-utils';
import appendQuery from 'append-query';

/**/
import config from 'kohlantstats/config/environment';
const { host, namespace } = config.quizzDS;
const baseUrl = host+"/"+namespace;

export default class quizz extends JSONAPIAdapter {

    //package question
    /* connector to DistinctQuestions info */
    distinctQuestions (params) {
        return fetchData(baseUrl+'/data/sdd/DistinctQuestionsIn'+filterDistinctQuestions(params));
    }
    /* connector to QuestionDetail info */
    questionDetail (params) {
        return fetchData(baseUrl+'/data/sdd/QuestionDetailIn'+filterQuestionDetail(params));
    }


}



//question

/* filter for DistinctQuestions entity */
function filterDistinctQuestions (filter) {
	if (filter) {
		return appendQuery("",{
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for QuestionDetail entity */
function filterQuestionDetail (filter) {
	if (filter) {
		return appendQuery("",{
				"tenantWebPath":filter.tenantWebPath,
				"questionWebPath":filter.questionWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

