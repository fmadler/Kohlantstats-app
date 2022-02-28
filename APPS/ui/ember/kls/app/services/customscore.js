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
	 - name      : EmberServiceJs
	 - file name : EmberServiceJs.vm
*/
import Adapter from '../adapters/score';
import Service from '@ember/service';
import { hash } from 'rsvp';

export default Service.extend({

	/** service to composite player-search info in js
	 * @param  {params} made of
	 *  - programWebPath
	 *  - playerWebPath
	 *  - gameWebPath
	 *  - gameTagWebPath
	 *  - rewardWebPath
	 *  - teamWebPath
	 *  - gameTypeWebPath
	 *  - gameStakeTypeWebPath
	 *  - gameParticipationTypeWebPath
	 *  - gameActivityTypeWebPath
	 *  - comparisonPlayersWebPath
	 * @returns {*} Promise
	*/
    playerSearch2 (params) {
    	var adapter = Adapter.create();
		var distinctProgramsPromise = adapter.distinctPrograms(params)
		.then(d => {
			return d.DistinctProgramsOut;
		});
		if (validatedistinctParticipants(params)) {
			var distinctParticipantsPromise = adapter.distinctParticipants(params)
			.then(d => {
				return d.DistinctParticipantsOut;
			});
		}
		var programInfoPromise = adapter.programInfo(params)
		.then(d => {
			return d.ProgramInfoOut;
		});
		var participantSummaryPromise = adapter.participantSummary(params)
		.then(d => {
			return d.ParticipantSummaryOut;
		});
		var participantGameActivityPromise = adapter.participantGameActivity(params)
		.then(d => {
			return d.ParticipantGameActivityOut;
		});

		//
		var gameStatsPromise = adapter.gameStats(params)
		.then(d => {
			return d.GameStatsOut;
		});

		var gamePerformancePromise = adapter.gamePerformance(params)
		.then(d => {
			return d.GamePerformanceOut;
		});

		// duplicate for player2WebPath TODO in MP generation for composite
		if (validateComparisonPlayer2(params)) {
			let alias = {playerWebPath: params.comparisonPlayerWebPath};
			var gameStatsPromisePlayer2 = adapter.gameStats(alias)
			.then(d => {
				return d.GameStatsOut;
			});
	
			var gamePerformancePromisePlayer2 = adapter.gamePerformance(alias)
			.then(d => {
				return d.GamePerformanceOut;
			});

			var participantSummaryPromisePlayer2 = adapter.participantSummary(alias)
			.then(d => {
				return d.ParticipantSummaryOut;
			});
		}

		if (validateplayerPerformanceComparison(params)) {
			var playerPerformanceComparisonPromise = adapter.playerPerformanceComparisonGetGames(params)
			// .then(d => {
			// 	return d.PlayerPerformanceComparisonOut;
			// })
			;
		}
		var promises = {
			distinctPrograms : distinctProgramsPromise,
			distinctParticipants : validatedistinctParticipants(params) ? distinctParticipantsPromise : [],
			programInfo : programInfoPromise,
			participantSummary : participantSummaryPromise,
			participantGameActivity : participantGameActivityPromise,
			gameStats : gameStatsPromise,
			gamePerformance : gamePerformancePromise,
			
			gameStatsPlayer2 : validateComparisonPlayer2(params) ? gameStatsPromisePlayer2 : [],
			gamePerformancePlayer2 : validateComparisonPlayer2(params) ? gamePerformancePromisePlayer2 : [],
			participantSummaryPlayer2 : validateComparisonPlayer2(params) ? participantSummaryPromisePlayer2 : [],

			playerPerformanceComparison : validateplayerPerformanceComparison(params) ? playerPerformanceComparisonPromise : [],
			params : params,
		};
    	return hash(promises);

    },    


});

function validateComparisonPlayer2(params) {
	if (!params.comparisonPlayerWebPath) return false;
	return true;
}
	// input validation check for createParticipantEntrance
export function validatecreateParticipantEntrance(params) {
	if (!params.participantWebPath) return false;
	if (!params.teamWebPath) return false;
	if (!params.fromTime) return false;
	if (!params.entranceTypeWebPath) return false;
	return true;
}
	// input validation check for createParticipantDeparture
export function validatecreateParticipantDeparture(params) {
	if (!params.participantWebPath) return false;
	if (!params.teamWebPath) return false;
	if (!params.toTime) return false;
	if (!params.departureTypeWebPath) return false;
	return true;
}
	// input validation check for createParticipantRealisation
export function validatecreateParticipantRealisation(params) {
	if (!params.participantWebPath) return false;
	if (!params.teamWebPath) return false;
	if (!params.time) return false;
	if (!params.realisationWebPath) return false;
	return true;
}
	// input validation check for distinctTeams
export function validatedistinctTeams(params) {
	if (!params.programWebPath) return false;
	return true;
}
	// input validation check for distinctParticipants
export function validatedistinctParticipants(params) {
	if (!params.programWebPath) return false;
	return true;
}
	// input validation check for distinctConcurrentsForParticipant
export function validatedistinctConcurrentsForParticipant(params) {
	if (!params.playerWebPath) return false;
	if (!params.playerWebPath) return false;
	return true;
}
	// input validation check for firstVoteAgainst
export function validatefirstVoteAgainst(params) {
	if (!params.voterWebPath) return false;
	if (!params.voterTargetWebPath) return false;
	if (!params.teamWebPath) return false;
	if (!params.timeUnit) return false;
	if (!params.voteEffectivenessTypeWebPath) return false;
	return true;
}
	// input validation check for secondVoteAgainst
export function validatesecondVoteAgainst(params) {
	if (!params.voterWebPath) return false;
	if (!params.voterTargetWebPath) return false;
	if (!params.teamWebPath) return false;
	if (!params.timeUnit) return false;
	if (!params.voteEffectivenessTypeWebPath) return false;
	return true;
}
	// input validation check for playerPerformanceComparison
export function validateplayerPerformanceComparison(params) {
	if (!params.comparisonPlayersWebPath) return false;
	return true;
}
	// input validation check for createGameParticipation
export function validatecreateGameParticipation(params) {
	if (!params.participantWebPath) return false;
	if (!params.teamWebPath) return false;
	if (!params.gameWebPath) return false;
	if (!params.activityTypeWebPath) return false;
	if (!params.participationTypeWebPath) return false;
	if (!params.ranking) return false;
	if (!params.rewardWebPaths) return false;
	return true;
}
