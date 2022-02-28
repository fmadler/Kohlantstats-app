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
const { host, namespace } = config.scoreDS;
const baseUrl = host+"/"+namespace;

// import scoreDSConfig from '../utils/environment-utils';
// const { host, namespace } = scoreDSConfig.scoreDS;
// const baseUrl = host+"/"+namespace;

//const baseUrl = "http://localhost/scoreKendoUiApp";//"https://winerylabs.com/scoreKendoUiApp";

export default class score extends JSONAPIAdapter {

    //package sitemap
    /* connector to Sitemap info */
    sitemap (params) {
        return fetchData(baseUrl+'/data/sdd/SitemapIn'+filterSitemap(params));
    }

    /* connector to SitemapParam info */
    sitemapParam (params) {
        return fetchData(baseUrl+'/data/sdd/SitemapParamIn'+filterSitemapParam(params));
    }

    /* connector to DistinctEntityType info */
    distinctEntityType (params) {
        return fetchData(baseUrl+'/data/sdd/DistinctEntityTypeIn'+filterDistinctEntityType(params));
    }

    /* connector to DistinctEntityDescriptionType info */
    distinctEntityDescriptionType (params) {
        return fetchData(baseUrl+'/data/sdd/DistinctEntityDescriptionTypeIn'+filterDistinctEntityDescriptionType(params));
    }

    /* connector to DistinctEntityBinaryType info */
    distinctEntityBinaryType (params) {
        return fetchData(baseUrl+'/data/sdd/DistinctEntityBinaryTypeIn'+filterDistinctEntityBinaryType(params));
    }

    //package team
    /* connector to CreateParticipantEntrance info */
    createParticipantEntrance (params) {
        return fetchData(baseUrl+'/data/sdd/CreateParticipantEntranceIn'+filterCreateParticipantEntrance(params));
    }

    /* connector to CreateParticipantDeparture info */
    createParticipantDeparture (params) {
        return fetchData(baseUrl+'/data/sdd/CreateParticipantDepartureIn'+filterCreateParticipantDeparture(params));
    }

    /* connector to CreateParticipantRealisation info */
    createParticipantRealisation (params) {
        return fetchData(baseUrl+'/data/sdd/CreateParticipantRealisationIn'+filterCreateParticipantRealisation(params));
    }

    //package info
    /* connector to TeamInfo info */
    teamInfo (params) {
        return fetchData(baseUrl+'/data/sdd/TeamInfoIn'+filterTeamInfo(params));
    }

    /* connector to ProgramInfo info */
    programInfo (params) {
        return fetchData(baseUrl+'/data/sdd/ProgramInfoIn'+filterProgramInfo(params));
    }

    //package distinct
    /* connector to DistinctGameTags info */
    distinctGameTags (params) {
        return fetchData(baseUrl+'/data/sdd/DistinctGameTagsIn'+filterDistinctGameTags(params));
    }

    /* connector to DistinctGames info */
    distinctGames (params) {
        return fetchData(baseUrl+'/data/sdd/DistinctGamesIn'+filterDistinctGames(params));
    }

    /* connector to DistinctPrograms info */
    distinctPrograms (params) {
        return fetchData(baseUrl+'/data/sdd/DistinctProgramsIn'+filterDistinctPrograms(params));
    }

    /* connector to DistinctTeams info */
    distinctTeams (params) {
        return fetchData(baseUrl+'/data/sdd/DistinctTeamsIn'+filterDistinctTeams(params));
    }

    /* connector to DistinctParticipants info */
    distinctParticipants (params) {
        return fetchData(baseUrl+'/data/sdd/DistinctParticipantsIn'+filterDistinctParticipants(params));
    }

    /* connector to DistinctConcurrentsForParticipant info */
    distinctConcurrentsForParticipant (params) {
        return fetchData(baseUrl+'/data/sdd/DistinctConcurrentsForParticipantIn'+filterDistinctConcurrentsForParticipant(params));
    }

    //package program
    //package stat
    /* connector to GameStats info */
    gameStats (params) {
        return fetchData(baseUrl+'/data/sdd/GameStatsIn'+filterGameStats(params));
    }

    //package vote
    /* connector to VoteDetail info */
    voteDetail (params) {
        return fetchData(baseUrl+'/data/sdd/VoteDetailIn'+filterVoteDetail(params));
    }

    /* connector to FirstVoteAgainst info */
    firstVoteAgainst (params) {
        return fetchData(baseUrl+'/data/sdd/FirstVoteAgainstIn'+filterFirstVoteAgainst(params));
    }

    /* connector to SecondVoteAgainst info */
    secondVoteAgainst (params) {
        return fetchData(baseUrl+'/data/sdd/SecondVoteAgainstIn'+filterSecondVoteAgainst(params));
    }

    //package quizz
    /* connector to QuizzParticipationFilterMatrix info */
    quizzParticipationFilterMatrix (params) {
        return fetchData(baseUrl+'/data/sdd/QuizzParticipationFilterMatrixIn'+filterQuizzParticipationFilterMatrix(params));
    }

    /* connector to QuizzWinnerTeamMatrix info */
    quizzWinnerTeamMatrix (params) {
        return fetchData(baseUrl+'/data/sdd/QuizzWinnerTeamMatrixIn'+filterQuizzWinnerTeamMatrix(params));
    }

    /* connector to QuizzWinnerTeamOption info */
    quizzWinnerTeamOption (params) {
        return fetchData(baseUrl+'/data/sdd/QuizzWinnerTeamOptionIn'+filterQuizzWinnerTeamOption(params));
    }

    /* connector to QuizzParticipationOption info */
    quizzParticipationOption (params) {
        return fetchData(baseUrl+'/data/sdd/QuizzParticipationOptionIn'+filterQuizzParticipationOption(params));
    }

    /* connector to QuizzWinnerParticipantOrderFilterMatrix info */
    quizzWinnerParticipantOrderFilterMatrix (params) {
        return fetchData(baseUrl+'/data/sdd/QuizzWinnerParticipantOrderFilterMatrixIn'+filterQuizzWinnerParticipantOrderFilterMatrix(params));
    }

    /* connector to QuizzWinnerTeamOrderFilterMatrix info */
    quizzWinnerTeamOrderFilterMatrix (params) {
        return fetchData(baseUrl+'/data/sdd/QuizzWinnerTeamOrderFilterMatrixIn'+filterQuizzWinnerTeamOrderFilterMatrix(params));
    }

    /* connector to QuizzSortTeamMemberFilterMatrix info */
    quizzSortTeamMemberFilterMatrix (params) {
        return fetchData(baseUrl+'/data/sdd/QuizzSortTeamMemberFilterMatrixIn'+filterQuizzSortTeamMemberFilterMatrix(params));
    }

    /* connector to QuizzSortTeamMemberOption info */
    quizzSortTeamMemberOption (params) {
        return fetchData(baseUrl+'/data/sdd/QuizzSortTeamMemberOptionIn'+filterQuizzSortTeamMemberOption(params));
    }

    /* connector to QuizzWinnerParticipantOrderOption info */
    quizzWinnerParticipantOrderOption (params) {
        return fetchData(baseUrl+'/data/sdd/QuizzWinnerParticipantOrderOptionIn'+filterQuizzWinnerParticipantOrderOption(params));
    }

    /* connector to QuizzWinnerTeamOrderOption info */
    quizzWinnerTeamOrderOption (params) {
        return fetchData(baseUrl+'/data/sdd/QuizzWinnerTeamOrderOptionIn'+filterQuizzWinnerTeamOrderOption(params));
    }

    //package participant
    /* connector to ParticipantSummary info */
    participantSummary (params) {
        return fetchData(baseUrl+'/data/sdd/ParticipantSummaryIn'+filterParticipantSummary(params));
    }

    /* connector to ParticipantGameActivity info */
    participantGameActivity (params) {
        return fetchData(baseUrl+'/data/sdd/ParticipantGameActivityIn'+filterParticipantGameActivity(params));
    }

    /* connector to ParticipantCampActivity info */
    participantCampActivity (params) {
        return fetchData(baseUrl+'/data/sdd/ParticipantCampActivityIn'+filterParticipantCampActivity(params));
    }

    //package property
    /* connector to GetProperties info */
    getProperties (params) {
        return fetchData(baseUrl+'/data/sdd/GetPropertiesIn'+filterGetProperties(params));
    }

    //package player
    /* connector to PlayerPerformanceComparison info */
    playerPerformanceComparison (params) {
        return fetchData(baseUrl+'/data/sdd/PlayerPerformanceComparisonIn'+filterPlayerPerformanceComparison(params));
    }
	/* pivot Game */
	playerPerformanceComparisonGetGames (params) {
		return fetchData(baseUrl+'/data/sdd/PlayerPerformanceComparisonIn/getGames'+filterPlayerPerformanceComparison(params));
	}
	/* pivot Participant */
	playerPerformanceComparisonGetParticipants (params) {
		return fetchData(baseUrl+'/data/sdd/PlayerPerformanceComparisonIn/getParticipants'+filterPlayerPerformanceComparison(params));
	}

    //package timeline
    /* connector to TeamGameTimeline info */
    teamGameTimeline (params) {
        return fetchData(baseUrl+'/data/sdd/TeamGameTimelineIn'+filterTeamGameTimeline(params));
    }

    /* connector to TeamParticipantTimeline info */
    teamParticipantTimeline (params) {
        return fetchData(baseUrl+'/data/sdd/TeamParticipantTimelineIn'+filterTeamParticipantTimeline(params));
    }

    //package game
    /* connector to GameInfo info */
    gameInfo (params) {
        return fetchData(baseUrl+'/data/sdd/GameInfoIn'+filterGameInfo(params));
    }

    /* connector to GamePerformance info */
    gamePerformance (params) {
        return fetchData(baseUrl+'/data/sdd/GamePerformanceIn'+filterGamePerformance(params));
    }

    /* connector to CreateGameParticipation info */
    createGameParticipation (params) {
        return fetchData(baseUrl+'/data/sdd/CreateGameParticipationIn'+filterCreateGameParticipation(params));
    }


	/* connector to composite team-detail info */
    teamDetail (params) {
        return fetchData(baseUrl+'/data/sdd/TeamDetailIn'+filterteamDetail(params));
    }

	/* connector to composite participant-camp-activity-info info */
    participantCampActivityInfo (params) {
        return fetchData(baseUrl+'/data/sdd/ParticipantCampActivityInfoIn'+filterparticipantCampActivityInfo(params));
    }

	/* connector to composite program-index info */
    programIndex (params) {
        return fetchData(baseUrl+'/data/sdd/ProgramIndexIn'+filterprogramIndex(params));
    }

	/* connector to composite program-detail info */
    programDetail (params) {
        return fetchData(baseUrl+'/data/sdd/ProgramDetailIn'+filterprogramDetail(params));
    }

	/* connector to composite participant-detail info */
    participantDetail (params) {
        return fetchData(baseUrl+'/data/sdd/ParticipantDetailIn'+filterparticipantDetail(params));
    }

	/* connector to composite game-detail info */
    gameDetail (params) {
        return fetchData(baseUrl+'/data/sdd/GameDetailIn'+filtergameDetail(params));
    }

	/* connector to composite game-search info */
    gameSearch (params) {
        return fetchData(baseUrl+'/data/sdd/GameSearchIn'+filtergameSearch(params));
    }

	/* connector to composite player-search info */
    playerSearch (params) {
        return fetchData(baseUrl+'/data/sdd/PlayerSearchIn'+filterplayerSearch(params));
    }


}


/* filter for composite team-detail entity */
function filterteamDetail (filter) {
	if (filter) {
		return appendQuery("",{
				"entityType":filter.entityType ,
				"entityWebPath":filter.entityWebPath ,
				"property":filter.property ,
				"programWebPath":filter.programWebPath ,
				"teamWebPath":filter.teamWebPath ,
				"playerWebPath":filter.playerWebPath ,
				"gameWebPath":filter.gameWebPath ,
				"gameTypeWebPath":filter.gameTypeWebPath ,
				"gameStakeTypeWebPath":filter.gameStakeTypeWebPath ,
				"gameParticipationTypeWebPath":filter.gameParticipationTypeWebPath ,
				"gameActivityTypeWebPath":filter.gameActivityTypeWebPath ,
				"untilDay":filter.untilDay ,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for composite participant-camp-activity-info entity */
function filterparticipantCampActivityInfo (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath ,
				"teamWebPath":filter.teamWebPath ,
				"playerWebPath":filter.playerWebPath ,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for composite program-index entity */
function filterprogramIndex (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath ,
				"playerWebPath":filter.playerWebPath ,
				"gameWebPath":filter.gameWebPath ,
				"teamWebPath":filter.teamWebPath ,
				"gameTypeWebPath":filter.gameTypeWebPath ,
				"gameStakeTypeWebPath":filter.gameStakeTypeWebPath ,
				"gameParticipationTypeWebPath":filter.gameParticipationTypeWebPath ,
				"gameActivityTypeWebPath":filter.gameActivityTypeWebPath ,
				"untilDay":filter.untilDay ,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for composite program-detail entity */
function filterprogramDetail (filter) {
	if (filter) {
		return appendQuery("",{
				"entityType":filter.entityType ,
				"entityWebPath":filter.entityWebPath ,
				"property":filter.property ,
				"programWebPath":filter.programWebPath ,
				"playerWebPath":filter.playerWebPath ,
				"gameWebPath":filter.gameWebPath ,
				"gameTagWebPath":filter.gameTagWebPath ,
				"rewardWebPath":filter.rewardWebPath ,
				"teamWebPath":filter.teamWebPath ,
				"gameTypeWebPath":filter.gameTypeWebPath ,
				"gameStakeTypeWebPath":filter.gameStakeTypeWebPath ,
				"gameParticipationTypeWebPath":filter.gameParticipationTypeWebPath ,
				"gameActivityTypeWebPath":filter.gameActivityTypeWebPath ,
				"untilDay":filter.untilDay ,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for composite participant-detail entity */
function filterparticipantDetail (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath ,
				"playerWebPath":filter.playerWebPath ,
				"gameWebPath":filter.gameWebPath ,
				"teamWebPath":filter.teamWebPath ,
				"gameTypeWebPath":filter.gameTypeWebPath ,
				"gameStakeTypeWebPath":filter.gameStakeTypeWebPath ,
				"gameParticipationTypeWebPath":filter.gameParticipationTypeWebPath ,
				"gameActivityTypeWebPath":filter.gameActivityTypeWebPath ,
				"untilDay":filter.untilDay ,
				"entityType":filter.entityType ,
				"entityWebPath":filter.entityWebPath ,
				"property":filter.property ,
				"gameTagWebPath":filter.gameTagWebPath ,
				"rewardWebPath":filter.rewardWebPath ,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for composite game-detail entity */
function filtergameDetail (filter) {
	if (filter) {
		return appendQuery("",{
				"entityType":filter.entityType ,
				"entityWebPath":filter.entityWebPath ,
				"property":filter.property ,
				"programWebPath":filter.programWebPath ,
				"playerWebPath":filter.playerWebPath ,
				"gameWebPath":filter.gameWebPath ,
				"gameTagWebPath":filter.gameTagWebPath ,
				"rewardWebPath":filter.rewardWebPath ,
				"notProgramWebPath":filter.notProgramWebPath ,
				"gameTypeWebPath":filter.gameTypeWebPath ,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for composite game-search entity */
function filtergameSearch (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath ,
				"gameWebPath":filter.gameWebPath ,
				"gameTagWebPath":filter.gameTagWebPath ,
				"rewardWebPath":filter.rewardWebPath ,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for composite player-search entity */
function filterplayerSearch (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath ,
				"playerWebPath":filter.playerWebPath ,
				"gameWebPath":filter.gameWebPath ,
				"gameTagWebPath":filter.gameTagWebPath ,
				"rewardWebPath":filter.rewardWebPath ,
				"teamWebPath":filter.teamWebPath ,
				"gameTypeWebPath":filter.gameTypeWebPath ,
				"gameStakeTypeWebPath":filter.gameStakeTypeWebPath ,
				"gameParticipationTypeWebPath":filter.gameParticipationTypeWebPath ,
				"gameActivityTypeWebPath":filter.gameActivityTypeWebPath ,
				"untilDay":filter.untilDay ,
				"comparisonPlayersWebPath":filter.comparisonPlayersWebPath ,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			


//sitemap

/* filter for Sitemap entity */
function filterSitemap (filter) {
	if (filter) {
		return appendQuery("",{
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for SitemapParam entity */
function filterSitemapParam (filter) {
	if (filter) {
		return appendQuery("",{
				"entityTypeWebPath":filter.entityTypeWebPath,
				"contextTypeWebPath":filter.contextTypeWebPath,
				"name":filter.name,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for DistinctEntityType entity */
function filterDistinctEntityType (filter) {
	if (filter) {
		return appendQuery("",{
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for DistinctEntityDescriptionType entity */
function filterDistinctEntityDescriptionType (filter) {
	if (filter) {
		return appendQuery("",{
				"entityTypeWebPath":filter.entityTypeWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for DistinctEntityBinaryType entity */
function filterDistinctEntityBinaryType (filter) {
	if (filter) {
		return appendQuery("",{
				"entityTypeWebPath":filter.entityTypeWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//team

/* filter for CreateParticipantEntrance entity */
function filterCreateParticipantEntrance (filter) {
	if (filter) {
		return appendQuery("",{
				"participantWebPath":filter.participantWebPath,
				"teamWebPath":filter.teamWebPath,
				"fromTime":filter.fromTime,
				"entranceTypeWebPath":filter.entranceTypeWebPath,
				"participantTeamId":filter.participantTeamId,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for CreateParticipantDeparture entity */
function filterCreateParticipantDeparture (filter) {
	if (filter) {
		return appendQuery("",{
				"participantWebPath":filter.participantWebPath,
				"teamWebPath":filter.teamWebPath,
				"toTime":filter.toTime,
				"departureTypeWebPath":filter.departureTypeWebPath,
				"participantTeamId":filter.participantTeamId,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for CreateParticipantRealisation entity */
function filterCreateParticipantRealisation (filter) {
	if (filter) {
		return appendQuery("",{
				"participantWebPath":filter.participantWebPath,
				"teamWebPath":filter.teamWebPath,
				"time":filter.time,
				"realisationWebPath":filter.realisationWebPath,
				"participantTeamRealisationId":filter.participantTeamRealisationId,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//info

/* filter for TeamInfo entity */
function filterTeamInfo (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"teamWebPath":filter.teamWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for ProgramInfo entity */
function filterProgramInfo (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//distinct

/* filter for DistinctGameTags entity */
function filterDistinctGameTags (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for DistinctGames entity */
function filterDistinctGames (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"notProgramWebPath":filter.notProgramWebPath,
				"gameTypeWebPath":filter.gameTypeWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for DistinctPrograms entity */
function filterDistinctPrograms (filter) {
	if (filter) {
		return appendQuery("",{
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for DistinctTeams entity */
function filterDistinctTeams (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for DistinctParticipants entity */
function filterDistinctParticipants (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for DistinctConcurrentsForParticipant entity */
function filterDistinctConcurrentsForParticipant (filter) {
	if (filter) {
		return appendQuery("",{
				"playerWebPath":filter.playerWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//program
//stat

/* filter for GameStats entity */
function filterGameStats (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"playerWebPath":filter.playerWebPath,
				"gameWebPath":filter.gameWebPath,
				"teamWebPath":filter.teamWebPath,
				"gameTypeWebPath":filter.gameTypeWebPath,
				"gameStakeTypeWebPath":filter.gameStakeTypeWebPath,
				"gameParticipationTypeWebPath":filter.gameParticipationTypeWebPath,
				"gameActivityTypeWebPath":filter.gameActivityTypeWebPath,
				"untilDay":filter.untilDay,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//vote

/* filter for VoteDetail entity */
function filterVoteDetail (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"teamWebPath":filter.teamWebPath,
				"voterWebPath":filter.voterWebPath,
				"voterTargetWebPath":filter.voterTargetWebPath,
				"voteEffectivenessTypeWebPath":filter.voteEffectivenessTypeWebPath,
				"voteTypeWebPath":filter.voteTypeWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for FirstVoteAgainst entity */
function filterFirstVoteAgainst (filter) {
	if (filter) {
		return appendQuery("",{
				"voterWebPath":filter.voterWebPath,
				"voterTargetWebPath":filter.voterTargetWebPath,
				"teamWebPath":filter.teamWebPath,
				"timeUnit":filter.timeUnit,
				"voteEffectivenessTypeWebPath":filter.voteEffectivenessTypeWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for SecondVoteAgainst entity */
function filterSecondVoteAgainst (filter) {
	if (filter) {
		return appendQuery("",{
				"voterWebPath":filter.voterWebPath,
				"voterTargetWebPath":filter.voterTargetWebPath,
				"teamWebPath":filter.teamWebPath,
				"timeUnit":filter.timeUnit,
				"voteEffectivenessTypeWebPath":filter.voteEffectivenessTypeWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//quizz

/* filter for QuizzParticipationFilterMatrix entity */
function filterQuizzParticipationFilterMatrix (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"gameWebPath":filter.gameWebPath,
				"participationTypeWebPath":filter.participationTypeWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for QuizzWinnerTeamMatrix entity */
function filterQuizzWinnerTeamMatrix (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"limit":filter.limit,
				"offset":filter.offset,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for QuizzWinnerTeamOption entity */
function filterQuizzWinnerTeamOption (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"ranking":filter.ranking,
				"gameWebPath":filter.gameWebPath,
				"limit":filter.limit,
				"offset":filter.offset,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for QuizzParticipationOption entity */
function filterQuizzParticipationOption (filter) {
	if (filter) {
		return appendQuery("",{
				"maxWinners":filter.maxWinners,
				"programWebPath":filter.programWebPath,
				"gameWebPath":filter.gameWebPath,
				"participationTypeWebPath":filter.participationTypeWebPath,
				"participantWebPaths":filter.participantWebPaths,
				"ranking":filter.ranking,
				"limit":filter.limit,
				"offset":filter.offset,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for QuizzWinnerParticipantOrderFilterMatrix entity */
function filterQuizzWinnerParticipantOrderFilterMatrix (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"gameWebPath":filter.gameWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for QuizzWinnerTeamOrderFilterMatrix entity */
function filterQuizzWinnerTeamOrderFilterMatrix (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"gameWebPath":filter.gameWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for QuizzSortTeamMemberFilterMatrix entity */
function filterQuizzSortTeamMemberFilterMatrix (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"gameWebPath":filter.gameWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for QuizzSortTeamMemberOption entity */
function filterQuizzSortTeamMemberOption (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"gameWebPath":filter.gameWebPath,
				"teamWebPath":filter.teamWebPath,
				"participantWebPath":filter.participantWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for QuizzWinnerParticipantOrderOption entity */
function filterQuizzWinnerParticipantOrderOption (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"gameWebPath":filter.gameWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for QuizzWinnerTeamOrderOption entity */
function filterQuizzWinnerTeamOrderOption (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"gameWebPath":filter.gameWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//participant

/* filter for ParticipantSummary entity */
function filterParticipantSummary (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"playerWebPath":filter.playerWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for ParticipantGameActivity entity */
function filterParticipantGameActivity (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"playerWebPath":filter.playerWebPath,
				"gameWebPath":filter.gameWebPath,
				"gameTagWebPath":filter.gameTagWebPath,
				"rewardWebPath":filter.rewardWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for ParticipantCampActivity entity */
function filterParticipantCampActivity (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"teamWebPath":filter.teamWebPath,
				"playerWebPath":filter.playerWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//property

/* filter for GetProperties entity */
function filterGetProperties (filter) {
	if (filter) {
		return appendQuery("",{
				"entityType":filter.entityType,
				"entityWebPath":filter.entityWebPath,
				"property":filter.property,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//player

/* filter for PlayerPerformanceComparison entity */
function filterPlayerPerformanceComparison (filter) {
	if (filter) {
		return appendQuery("",{
				"comparisonPlayersWebPath":filter.comparisonPlayersWebPath,
				"programWebPath":filter.programWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//timeline

/* filter for TeamGameTimeline entity */
function filterTeamGameTimeline (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"teamWebPath":filter.teamWebPath,
				"gameWebPath":filter.gameWebPath,
				"gameTypeWebPath":filter.gameTypeWebPath,
				"playerWebPath":filter.playerWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for TeamParticipantTimeline entity */
function filterTeamParticipantTimeline (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"teamWebPath":filter.teamWebPath,
				"playerWebPath":filter.playerWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//game

/* filter for GameInfo entity */
function filterGameInfo (filter) {
	if (filter) {
		return appendQuery("",{
				"programWebPath":filter.programWebPath,
				"gameWebPath":filter.gameWebPath,
				"gameTagWebPath":filter.gameTagWebPath,
				"rewardWebPath":filter.rewardWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for GamePerformance entity */
function filterGamePerformance (filter) {
	if (filter) {
		return appendQuery("",{
				"playerWebPath":filter.playerWebPath,
				"programWebPath":filter.programWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

/* filter for CreateGameParticipation entity */
function filterCreateGameParticipation (filter) {
	if (filter) {
		return appendQuery("",{
				"participantWebPath":filter.participantWebPath,
				"teamWebPath":filter.teamWebPath,
				"gameWebPath":filter.gameWebPath,
				"activityTypeWebPath":filter.activityTypeWebPath,
				"participationTypeWebPath":filter.participationTypeWebPath,
				"ranking":filter.ranking,
				"rewardWebPaths":filter.rewardWebPaths,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

