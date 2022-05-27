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

  //sitemap

  sitemap (params) {
    var adapter = Adapter.create();
    return adapter.sitemap(params);
  },


  sitemapParam (params) {
    var adapter = Adapter.create();
    return adapter.sitemapParam(params);
  },


  distinctEntityType (params) {
    var adapter = Adapter.create();
    return adapter.distinctEntityType(params);
  },


  distinctEntityDescriptionType (params) {
    var adapter = Adapter.create();
    return adapter.distinctEntityDescriptionType(params);
  },


  distinctEntityBinaryType (params) {
    var adapter = Adapter.create();
    return adapter.distinctEntityBinaryType(params);
  },

  //team

  createParticipantEntrance (params) {
    var adapter = Adapter.create();
    return adapter.createParticipantEntrance(params);
  },


  createParticipantDeparture (params) {
    var adapter = Adapter.create();
    return adapter.createParticipantDeparture(params);
  },


  createParticipantRealisation (params) {
    var adapter = Adapter.create();
    return adapter.createParticipantRealisation(params);
  },

  //info

  teamInfo (params) {
    var adapter = Adapter.create();
    return adapter.teamInfo(params);
  },


  programInfo (params) {
    var adapter = Adapter.create();
    return adapter.programInfo(params);
  },

  //distinct

  distinctGameTags (params) {
    var adapter = Adapter.create();
    return adapter.distinctGameTags(params);
  },


  distinctGames (params) {
    var adapter = Adapter.create();
    return adapter.distinctGames(params);
  },


  distinctPrograms (params) {
    var adapter = Adapter.create();
    return adapter.distinctPrograms(params);
  },


  distinctTeams (params) {
    var adapter = Adapter.create();
    return adapter.distinctTeams(params);
  },


  distinctParticipants (params) {
    var adapter = Adapter.create();
    return adapter.distinctParticipants(params);
  },


  distinctConcurrentsForParticipant (params) {
    var adapter = Adapter.create();
    return adapter.distinctConcurrentsForParticipant(params);
  },

  //program
  //stat

  gameStats (params) {
    var adapter = Adapter.create();
    return adapter.gameStats(params);
  },

  //vote

  voteDetail (params) {
    var adapter = Adapter.create();
    return adapter.voteDetail(params);
  },


  firstVoteAgainst (params) {
    var adapter = Adapter.create();
    return adapter.firstVoteAgainst(params);
  },


  secondVoteAgainst (params) {
    var adapter = Adapter.create();
    return adapter.secondVoteAgainst(params);
  },

  //quizz

  quizzParticipationFilterMatrix (params) {
    var adapter = Adapter.create();
    return adapter.quizzParticipationFilterMatrix(params);
  },


  quizzWinnerTeamMatrix (params) {
    var adapter = Adapter.create();
    return adapter.quizzWinnerTeamMatrix(params);
  },


  quizzWinnerTeamOption (params) {
    var adapter = Adapter.create();
    return adapter.quizzWinnerTeamOption(params);
  },


  quizzParticipationOption (params) {
    var adapter = Adapter.create();
    return adapter.quizzParticipationOption(params);
  },


  quizzWinnerParticipantOrderFilterMatrix (params) {
    var adapter = Adapter.create();
    return adapter.quizzWinnerParticipantOrderFilterMatrix(params);
  },


  quizzWinnerTeamOrderFilterMatrix (params) {
    var adapter = Adapter.create();
    return adapter.quizzWinnerTeamOrderFilterMatrix(params);
  },


  quizzSortTeamMemberFilterMatrix (params) {
    var adapter = Adapter.create();
    return adapter.quizzSortTeamMemberFilterMatrix(params);
  },


  quizzSortTeamMemberOption (params) {
    var adapter = Adapter.create();
    return adapter.quizzSortTeamMemberOption(params);
  },


  quizzWinnerParticipantOrderOption (params) {
    var adapter = Adapter.create();
    return adapter.quizzWinnerParticipantOrderOption(params);
  },


  quizzWinnerTeamOrderOption (params) {
    var adapter = Adapter.create();
    return adapter.quizzWinnerTeamOrderOption(params);
  },

  //generic

  masterData (params) {
    var adapter = Adapter.create();
    return adapter.masterData(params);
  },

  //participant

  participantSummary (params) {
    var adapter = Adapter.create();
    return adapter.participantSummary(params);
  },


  participantGameActivity (params) {
    var adapter = Adapter.create();
    return adapter.participantGameActivity(params);
  },


  participantCampActivity (params) {
    var adapter = Adapter.create();
    return adapter.participantCampActivity(params);
  },

  //property

  getProperties (params) {
    var adapter = Adapter.create();
    return adapter.getProperties(params);
  },

  //player

  playerPerformanceComparison (params) {
    var adapter = Adapter.create();
    return adapter.playerPerformanceComparison(params);
  },

  //timeline

  teamGameTimeline (params) {
    var adapter = Adapter.create();
    return adapter.teamGameTimeline(params);
  },


  teamParticipantTimeline (params) {
    var adapter = Adapter.create();
    return adapter.teamParticipantTimeline(params);
  },


  scoreTimeline (params) {
    var adapter = Adapter.create();
    return adapter.scoreTimeline(params);
  },


  createTimeline (params) {
    var adapter = Adapter.create();
    return adapter.createTimeline(params);
  },

  //game

  gameInfo (params) {
    var adapter = Adapter.create();
    return adapter.gameInfo(params);
  },


  gamePerformance (params) {
    var adapter = Adapter.create();
    return adapter.gamePerformance(params);
  },


  createGameParticipation (params) {
    var adapter = Adapter.create();
    return adapter.createGameParticipation(params);
  },

  /**
   * Service to composite team-detail info
   * @param  {params} made of
   *  - entityType
   *  - entityWebPath
   *  - property
   *  - programWebPath
   *  - teamWebPath
   *  - playerWebPath
   *  - gameWebPath
   *  - gameTypeWebPath
   *  - gameStakeTypeWebPath
   *  - gameParticipationTypeWebPath
   *  - gameActivityTypeWebPath
   *  - untilDay
   * @returns {*} Promise
   */
  teamDetail (params) {
    var adapter = Adapter.create();
    return adapter.TeamDetail(params);
  },

  /** service to composite team-detail info in js
   * @param  {params} made of
   *  - entityType
   *  - entityWebPath
   *  - property
   *  - programWebPath
   *  - teamWebPath
   *  - playerWebPath
   *  - gameWebPath
   *  - gameTypeWebPath
   *  - gameStakeTypeWebPath
   *  - gameParticipationTypeWebPath
   *  - gameActivityTypeWebPath
   *  - untilDay
   * @returns {*} Promise
   */
  teamDetail2 (params) {
    var adapter = Adapter.create();
    var getPropertiesPromise = adapter.getProperties(params)
      .then(d => {
        return d.GetPropertiesOut;
      });
    var teamParticipantTimelinePromise = adapter.teamParticipantTimeline(params)
      .then(d => {
        return d.TeamParticipantTimelineOut;
      });
    var gamePerformancePromise = adapter.gamePerformance(params)
      .then(d => {
        return d.GamePerformanceOut;
      });
    var teamGameTimelinePromise = adapter.teamGameTimeline(params)
      .then(d => {
        return d.TeamGameTimelineOut;
      });
    var gameStatsPromise = adapter.gameStats(params)
      .then(d => {
        return d.GameStatsOut;
      });
    var teamInfoPromise = adapter.teamInfo(params)
      .then(d => {
        return d.TeamInfoOut;
      });
    var programInfoPromise = adapter.programInfo(params)
      .then(d => {
        return d.ProgramInfoOut;
      });
    var promises = {
      getProperties : getPropertiesPromise,
      teamParticipantTimeline : teamParticipantTimelinePromise,
      gamePerformance : gamePerformancePromise,
      teamGameTimeline : teamGameTimelinePromise,
      gameStats : gameStatsPromise,
      teamInfo : teamInfoPromise,
      programInfo : programInfoPromise,
      params : params,
    };
    return hash(promises);

  },

  /**
   * Service to composite participant-camp-activity-info info
   * @param  {params} made of
   *  - programWebPath
   *  - teamWebPath
   *  - playerWebPath
   * @returns {*} Promise
   */
  participantCampActivityInfo (params) {
    var adapter = Adapter.create();
    return adapter.ParticipantCampActivityInfo(params);
  },

  /** service to composite participant-camp-activity-info info in js
   * @param  {params} made of
   *  - programWebPath
   *  - teamWebPath
   *  - playerWebPath
   * @returns {*} Promise
   */
  participantCampActivityInfo2 (params) {
    var adapter = Adapter.create();
    var participantCampActivityPromise = adapter.participantCampActivity(params)
      .then(d => {
        return d.ParticipantCampActivityOut;
      });
    var distinctProgramsPromise = adapter.distinctPrograms(params)
      .then(d => {
        return d.DistinctProgramsOut;
      });
    if (validatedistinctTeams(params)) {
      var distinctTeamsPromise = adapter.distinctTeams(params)
        .then(d => {
          return d.DistinctTeamsOut;
        });
    }
    if (validatedistinctParticipants(params)) {
      var distinctParticipantsPromise = adapter.distinctParticipants(params)
        .then(d => {
          return d.DistinctParticipantsOut;
        });
    }
    var promises = {
      participantCampActivity : participantCampActivityPromise,
      distinctPrograms : distinctProgramsPromise,
      distinctTeams : validatedistinctTeams(params) ? distinctTeamsPromise : [],
      distinctParticipants : validatedistinctParticipants(params) ? distinctParticipantsPromise : [],
      params : params,
    };
    return hash(promises);

  },

  /**
   * Service to composite program-detail info
   * @param  {params} made of
   *  - entityType
   *  - entityWebPath
   *  - property
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
   *  - untilDay
   * @returns {*} Promise
   */
  programDetail (params) {
    var adapter = Adapter.create();
    return adapter.ProgramDetail(params);
  },

  /** service to composite program-detail info in js
   * @param  {params} made of
   *  - entityType
   *  - entityWebPath
   *  - property
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
   *  - untilDay
   * @returns {*} Promise
   */
  programDetail2 (params) {
    var adapter = Adapter.create();
    var getPropertiesPromise = adapter.getProperties(params)
      .then(d => {
        return d.GetPropertiesOut;
      });
    var distinctProgramsPromise = adapter.distinctPrograms(params)
      .then(d => {
        return d.DistinctProgramsOut;
      });
    var programInfoPromise = adapter.programInfo(params)
      .then(d => {
        return d.ProgramInfoOut;
      });
    var participantGameActivityPromise = adapter.participantGameActivity(params)
      .then(d => {
        return d.ParticipantGameActivityOut;
      });
    var participantCampActivityPromise = adapter.participantCampActivity(params)
      .then(d => {
        return d.ParticipantCampActivityOut;
      });
    var teamParticipantTimelinePromise = adapter.teamParticipantTimeline(params)
      .then(d => {
        return d.TeamParticipantTimelineOut;
      });
    var teamGameTimelinePromise = adapter.teamGameTimeline(params)
      .then(d => {
        return d.TeamGameTimelineOut;
      });
    var gameStatsPromise = adapter.gameStats(params)
      .then(d => {
        return d.GameStatsOut;
      });
    var promises = {
      getProperties : getPropertiesPromise,
      distinctPrograms : distinctProgramsPromise,
      programInfo : programInfoPromise,
      participantGameActivity : participantGameActivityPromise,
      participantCampActivity : participantCampActivityPromise,
      teamParticipantTimeline : teamParticipantTimelinePromise,
      teamGameTimeline : teamGameTimelinePromise,
      gameStats : gameStatsPromise,
      params : params,
    };
    return hash(promises);

  },

  /**
   * Service to composite participant-detail info
   * @param  {params} made of
   *  - programWebPath
   *  - playerWebPath
   *  - gameWebPath
   *  - teamWebPath
   *  - gameTypeWebPath
   *  - gameStakeTypeWebPath
   *  - gameParticipationTypeWebPath
   *  - gameActivityTypeWebPath
   *  - untilDay
   *  - entityType
   *  - entityWebPath
   *  - property
   *  - gameTagWebPath
   *  - rewardWebPath
   *  - playerWebPaths
   *  - day
   * @returns {*} Promise
   */
  participantDetail (params) {
    var adapter = Adapter.create();
    return adapter.ParticipantDetail(params);
  },

  /** service to composite participant-detail info in js
   * @param  {params} made of
   *  - programWebPath
   *  - playerWebPath
   *  - gameWebPath
   *  - teamWebPath
   *  - gameTypeWebPath
   *  - gameStakeTypeWebPath
   *  - gameParticipationTypeWebPath
   *  - gameActivityTypeWebPath
   *  - untilDay
   *  - entityType
   *  - entityWebPath
   *  - property
   *  - gameTagWebPath
   *  - rewardWebPath
   *  - playerWebPaths
   *  - day
   * @returns {*} Promise
   */
  participantDetail2 (params) {
    var adapter = Adapter.create();
    if (validatedistinctParticipants(params)) {
      var distinctParticipantsPromise = adapter.distinctParticipants(params)
        .then(d => {
          return d.DistinctParticipantsOut;
        });
    }
    var participantSummaryPromise = adapter.participantSummary(params)
      .then(d => {
        return d.ParticipantSummaryOut;
      });
    var gameStatsPromise = adapter.gameStats(params)
      .then(d => {
        return d.GameStatsOut;
      });
    var getPropertiesPromise = adapter.getProperties(params)
      .then(d => {
        return d.GetPropertiesOut;
      });
    var participantGameActivityPromise = adapter.participantGameActivity(params)
      .then(d => {
        return d.ParticipantGameActivityOut;
      });
    var participantCampActivityPromise = adapter.participantCampActivity(params)
      .then(d => {
        return d.ParticipantCampActivityOut;
      });
    var gamePerformancePromise = adapter.gamePerformance(params)
      .then(d => {
        return d.GamePerformanceOut;
      });
    var teamParticipantTimelinePromise = adapter.teamParticipantTimeline(params)
      .then(d => {
        return d.TeamParticipantTimelineOut;
      });
    var scoreTimelinePromise = adapter.scoreTimeline(params)
      .then(d => {
        return d.ScoreTimelineOut;
      });
    var promises = {
      distinctParticipants : validatedistinctParticipants(params) ? distinctParticipantsPromise : [],
      participantSummary : participantSummaryPromise,
      gameStats : gameStatsPromise,
      getProperties : getPropertiesPromise,
      participantGameActivity : participantGameActivityPromise,
      participantCampActivity : participantCampActivityPromise,
      gamePerformance : gamePerformancePromise,
      teamParticipantTimeline : teamParticipantTimelinePromise,
      scoreTimeline : scoreTimelinePromise,
      params : params,
    };
    return hash(promises);

  },

  /**
   * Service to composite game-detail info
   * @param  {params} made of
   *  - entityType
   *  - entityWebPath
   *  - property
   *  - programWebPath
   *  - playerWebPath
   *  - gameWebPath
   *  - gameTagWebPath
   *  - rewardWebPath
   *  - notProgramWebPath
   *  - gameTypeWebPath
   * @returns {*} Promise
   */
  gameDetail (params) {
    var adapter = Adapter.create();
    return adapter.GameDetail(params);
  },

  /** service to composite game-detail info in js
   * @param  {params} made of
   *  - entityType
   *  - entityWebPath
   *  - property
   *  - programWebPath
   *  - playerWebPath
   *  - gameWebPath
   *  - gameTagWebPath
   *  - rewardWebPath
   *  - notProgramWebPath
   *  - gameTypeWebPath
   * @returns {*} Promise
   */
  gameDetail2 (params) {
    var adapter = Adapter.create();
    var getPropertiesPromise = adapter.getProperties(params)
      .then(d => {
        return d.GetPropertiesOut;
      });
    var participantGameActivityPromise = adapter.participantGameActivity(params)
      .then(d => {
        return d.ParticipantGameActivityOut;
      });
    var distinctGamesPromise = adapter.distinctGames(params)
      .then(d => {
        return d.DistinctGamesOut;
      });
    var programInfoPromise = adapter.programInfo(params)
      .then(d => {
        return d.ProgramInfoOut;
      });
    var promises = {
      getProperties : getPropertiesPromise,
      participantGameActivity : participantGameActivityPromise,
      distinctGames : distinctGamesPromise,
      programInfo : programInfoPromise,
      params : params,
    };
    return hash(promises);

  },

  /**
   * Service to composite game-search info
   * @param  {params} made of
   *  - programWebPath
   *  - gameWebPath
   *  - gameTagWebPath
   *  - rewardWebPath
   * @returns {*} Promise
   */
  gameSearch (params) {
    var adapter = Adapter.create();
    return adapter.GameSearch(params);
  },

  /** service to composite game-search info in js
   * @param  {params} made of
   *  - programWebPath
   *  - gameWebPath
   *  - gameTagWebPath
   *  - rewardWebPath
   * @returns {*} Promise
   */
  gameSearch2 (params) {
    var adapter = Adapter.create();
    var gameInfoPromise = adapter.gameInfo(params)
      .then(d => {
        return d.GameInfoOut;
      });
    var distinctProgramsPromise = adapter.distinctPrograms(params)
      .then(d => {
        return d.DistinctProgramsOut;
      });
    var distinctGameTagsPromise = adapter.distinctGameTags(params)
      .then(d => {
        return d.DistinctGameTagsOut;
      });
    var programInfoPromise = adapter.programInfo(params)
      .then(d => {
        return d.ProgramInfoOut;
      });
    var promises = {
      gameInfo : gameInfoPromise,
      distinctPrograms : distinctProgramsPromise,
      distinctGameTags : distinctGameTagsPromise,
      programInfo : programInfoPromise,
      params : params,
    };
    return hash(promises);

  },

  /**
   * Service to composite player-search info
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
   *  - untilDay
   *  - comparisonPlayersWebPath
   * @returns {*} Promise
   */
  playerSearch (params) {
    var adapter = Adapter.create();
    return adapter.PlayerSearch(params);
  },

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
   *  - untilDay
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
    var gameStatsPromise = adapter.gameStats(params)
      .then(d => {
        return d.GameStatsOut;
      });
    var gamePerformancePromise = adapter.gamePerformance(params)
      .then(d => {
        return d.GamePerformanceOut;
      });
    if (validateplayerPerformanceComparison(params)) {
      var playerPerformanceComparisonPromise = adapter.playerPerformanceComparison(params)
        .then(d => {
          return d.PlayerPerformanceComparisonOut;
        });
    }
    var promises = {
      distinctPrograms : distinctProgramsPromise,
      distinctParticipants : validatedistinctParticipants(params) ? distinctParticipantsPromise : [],
      programInfo : programInfoPromise,
      participantSummary : participantSummaryPromise,
      participantGameActivity : participantGameActivityPromise,
      gameStats : gameStatsPromise,
      gamePerformance : gamePerformancePromise,
      playerPerformanceComparison : validateplayerPerformanceComparison(params) ? playerPerformanceComparisonPromise : [],
      params : params,
    };
    return hash(promises);

  },


});

// input validation check for createParticipantEntrance
export function validatecreateParticipantEntrance(params) {
  if (!params.programWebPath) return false;
  if (!params.participantWebPath) return false;
  if (!params.teamWebPath) return false;
  if (!params.fromTime) return false;
  if (!params.entranceTypeWebPath) return false;
  return true;
}
// input validation check for createParticipantDeparture
export function validatecreateParticipantDeparture(params) {
  if (!params.programWebPath) return false;
  if (!params.participantWebPath) return false;
  if (!params.teamWebPath) return false;
  if (!params.toTime) return false;
  if (!params.departureTypeWebPath) return false;
  return true;
}
// input validation check for createParticipantRealisation
export function validatecreateParticipantRealisation(params) {
  if (!params.programWebPath) return false;
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
// input validation check for createTimeline
export function validatecreateTimeline(params) {
  if (!params.programWebPath) return false;
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
