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
	* - name      : Spring.GraphQL.service
	* - file name : Spring.GraphQL.service.vm
*/
package com.game.score.graphql;

import com.game.score.graphql.datafetcher.sitemap.SitemapDataFetcher;
import com.game.score.graphql.datafetcher.sitemap.SitemapParamDataFetcher;
import com.game.score.graphql.datafetcher.sitemap.DistinctEntityTypeDataFetcher;
import com.game.score.graphql.datafetcher.sitemap.DistinctEntityDescriptionTypeDataFetcher;
import com.game.score.graphql.datafetcher.sitemap.DistinctEntityBinaryTypeDataFetcher;
import com.game.score.graphql.datafetcher.team.CreateParticipantEntranceDataFetcher;
import com.game.score.graphql.datafetcher.team.CreateParticipantDepartureDataFetcher;
import com.game.score.graphql.datafetcher.team.CreateParticipantRealisationDataFetcher;
import com.game.score.graphql.datafetcher.info.TeamInfoDataFetcher;
import com.game.score.graphql.datafetcher.info.ProgramInfoDataFetcher;
import com.game.score.graphql.datafetcher.distinct.DistinctGameTagsDataFetcher;
import com.game.score.graphql.datafetcher.distinct.DistinctGamesDataFetcher;
import com.game.score.graphql.datafetcher.distinct.DistinctProgramsDataFetcher;
import com.game.score.graphql.datafetcher.distinct.DistinctTeamsDataFetcher;
import com.game.score.graphql.datafetcher.distinct.DistinctParticipantsDataFetcher;
import com.game.score.graphql.datafetcher.distinct.DistinctConcurrentsForParticipantDataFetcher;
import com.game.score.graphql.datafetcher.stat.GameStatsDataFetcher;
import com.game.score.graphql.datafetcher.vote.VoteDetailDataFetcher;
import com.game.score.graphql.datafetcher.quizz.QuizzParticipationFilterMatrixDataFetcher;
import com.game.score.graphql.datafetcher.quizz.QuizzWinnerTeamMatrixDataFetcher;
import com.game.score.graphql.datafetcher.quizz.QuizzWinnerTeamOptionDataFetcher;
import com.game.score.graphql.datafetcher.quizz.QuizzParticipationOptionDataFetcher;
import com.game.score.graphql.datafetcher.quizz.QuizzWinnerParticipantOrderFilterMatrixDataFetcher;
import com.game.score.graphql.datafetcher.quizz.QuizzWinnerTeamOrderFilterMatrixDataFetcher;
import com.game.score.graphql.datafetcher.quizz.QuizzSortTeamMemberFilterMatrixDataFetcher;
import com.game.score.graphql.datafetcher.quizz.QuizzSortTeamMemberOptionDataFetcher;
import com.game.score.graphql.datafetcher.quizz.QuizzWinnerParticipantOrderOptionDataFetcher;
import com.game.score.graphql.datafetcher.quizz.QuizzWinnerTeamOrderOptionDataFetcher;
import com.game.score.graphql.datafetcher.generic.MasterDataDataFetcher;
import com.game.score.graphql.datafetcher.participant.ParticipantSummaryDataFetcher;
import com.game.score.graphql.datafetcher.participant.ParticipantGameActivityDataFetcher;
import com.game.score.graphql.datafetcher.participant.ParticipantCampActivityDataFetcher;
import com.game.score.graphql.datafetcher.property.GetPropertiesDataFetcher;
import com.game.score.graphql.datafetcher.player.PlayerPerformanceComparisonDataFetcher;
import com.game.score.graphql.datafetcher.timeline.TeamGameTimelineDataFetcher;
import com.game.score.graphql.datafetcher.timeline.TeamParticipantTimelineDataFetcher;
import com.game.score.graphql.datafetcher.timeline.ScoreTimelineDataFetcher;
import com.game.score.graphql.datafetcher.timeline.CreateTimelineDataFetcher;
import com.game.score.graphql.datafetcher.game.GameInfoDataFetcher;
import com.game.score.graphql.datafetcher.game.GamePerformanceDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import graphql.scalars.ExtendedScalars;
import com.game.score.graphql.scalar.TimestampScalar;

@Service
public class ScoreGraphQLService {

    @Value("classpath:/apiScore.graphql")
    Resource resource;
    @Value("classpath:/graphiqlScore.html")
    Resource graphiql;

    private GraphQL graphQL;

    @Autowired
    SitemapDataFetcher sitemapDataFetcher;
    @Autowired
    SitemapParamDataFetcher sitemapParamDataFetcher;
    @Autowired
    DistinctEntityTypeDataFetcher distinctEntityTypeDataFetcher;
    @Autowired
    DistinctEntityDescriptionTypeDataFetcher distinctEntityDescriptionTypeDataFetcher;
    @Autowired
    DistinctEntityBinaryTypeDataFetcher distinctEntityBinaryTypeDataFetcher;
    @Autowired
    CreateParticipantEntranceDataFetcher createParticipantEntranceDataFetcher;
    @Autowired
    CreateParticipantDepartureDataFetcher createParticipantDepartureDataFetcher;
    @Autowired
    CreateParticipantRealisationDataFetcher createParticipantRealisationDataFetcher;
    @Autowired
    TeamInfoDataFetcher teamInfoDataFetcher;
    @Autowired
    ProgramInfoDataFetcher programInfoDataFetcher;
    @Autowired
    DistinctGameTagsDataFetcher distinctGameTagsDataFetcher;
    @Autowired
    DistinctGamesDataFetcher distinctGamesDataFetcher;
    @Autowired
    DistinctProgramsDataFetcher distinctProgramsDataFetcher;
    @Autowired
    DistinctTeamsDataFetcher distinctTeamsDataFetcher;
    @Autowired
    DistinctParticipantsDataFetcher distinctParticipantsDataFetcher;
    @Autowired
    DistinctConcurrentsForParticipantDataFetcher distinctConcurrentsForParticipantDataFetcher;
    @Autowired
    GameStatsDataFetcher gameStatsDataFetcher;
    @Autowired
    VoteDetailDataFetcher voteDetailDataFetcher;
    @Autowired
    QuizzParticipationFilterMatrixDataFetcher quizzParticipationFilterMatrixDataFetcher;
    @Autowired
    QuizzWinnerTeamMatrixDataFetcher quizzWinnerTeamMatrixDataFetcher;
    @Autowired
    QuizzWinnerTeamOptionDataFetcher quizzWinnerTeamOptionDataFetcher;
    @Autowired
    QuizzParticipationOptionDataFetcher quizzParticipationOptionDataFetcher;
    @Autowired
    QuizzWinnerParticipantOrderFilterMatrixDataFetcher quizzWinnerParticipantOrderFilterMatrixDataFetcher;
    @Autowired
    QuizzWinnerTeamOrderFilterMatrixDataFetcher quizzWinnerTeamOrderFilterMatrixDataFetcher;
    @Autowired
    QuizzSortTeamMemberFilterMatrixDataFetcher quizzSortTeamMemberFilterMatrixDataFetcher;
    @Autowired
    QuizzSortTeamMemberOptionDataFetcher quizzSortTeamMemberOptionDataFetcher;
    @Autowired
    QuizzWinnerParticipantOrderOptionDataFetcher quizzWinnerParticipantOrderOptionDataFetcher;
    @Autowired
    QuizzWinnerTeamOrderOptionDataFetcher quizzWinnerTeamOrderOptionDataFetcher;
    @Autowired
    MasterDataDataFetcher masterDataDataFetcher;
    @Autowired
    ParticipantSummaryDataFetcher participantSummaryDataFetcher;
    @Autowired
    ParticipantGameActivityDataFetcher participantGameActivityDataFetcher;
    @Autowired
    ParticipantCampActivityDataFetcher participantCampActivityDataFetcher;
    @Autowired
    GetPropertiesDataFetcher getPropertiesDataFetcher;
    @Autowired
    PlayerPerformanceComparisonDataFetcher playerPerformanceComparisonDataFetcher;
    @Autowired
    TeamGameTimelineDataFetcher teamGameTimelineDataFetcher;
    @Autowired
    TeamParticipantTimelineDataFetcher teamParticipantTimelineDataFetcher;
    @Autowired
    ScoreTimelineDataFetcher scoreTimelineDataFetcher;
    @Autowired
    CreateTimelineDataFetcher createTimelineDataFetcher;
    @Autowired
    GameInfoDataFetcher gameInfoDataFetcher;
    @Autowired
    GamePerformanceDataFetcher gamePerformanceDataFetcher;

    // load schema at application start up
    @PostConstruct
    private void loadSchema() throws IOException {
        // get the schema
        File schemaFile = resource.getFile();
        // parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
            .scalar(ExtendedScalars.Date)
            .scalar(ExtendedScalars.DateTime)
            .scalar(TimestampScalar.INSTANCE)
            .type("Query", typeWiring -> typeWiring
                .dataFetcher("sitemap",sitemapDataFetcher)
                .dataFetcher("sitemapParam",sitemapParamDataFetcher)
                .dataFetcher("distinctEntityType",distinctEntityTypeDataFetcher)
                .dataFetcher("distinctEntityDescriptionType",distinctEntityDescriptionTypeDataFetcher)
                .dataFetcher("distinctEntityBinaryType",distinctEntityBinaryTypeDataFetcher)
                .dataFetcher("teamInfo",teamInfoDataFetcher)
                .dataFetcher("programInfo",programInfoDataFetcher)
                .dataFetcher("distinctGameTags",distinctGameTagsDataFetcher)
                .dataFetcher("distinctGames",distinctGamesDataFetcher)
                .dataFetcher("distinctPrograms",distinctProgramsDataFetcher)
                .dataFetcher("distinctTeams",distinctTeamsDataFetcher)
                .dataFetcher("distinctParticipants",distinctParticipantsDataFetcher)
                .dataFetcher("distinctConcurrentsForParticipant",distinctConcurrentsForParticipantDataFetcher)
                .dataFetcher("gameStats",gameStatsDataFetcher)
                .dataFetcher("voteDetail",voteDetailDataFetcher)
                .dataFetcher("quizzParticipationFilterMatrix",quizzParticipationFilterMatrixDataFetcher)
                .dataFetcher("quizzWinnerTeamMatrix",quizzWinnerTeamMatrixDataFetcher)
                .dataFetcher("quizzWinnerTeamOption",quizzWinnerTeamOptionDataFetcher)
                .dataFetcher("quizzParticipationOption",quizzParticipationOptionDataFetcher)
                .dataFetcher("quizzWinnerParticipantOrderFilterMatrix",quizzWinnerParticipantOrderFilterMatrixDataFetcher)
                .dataFetcher("quizzWinnerTeamOrderFilterMatrix",quizzWinnerTeamOrderFilterMatrixDataFetcher)
                .dataFetcher("quizzSortTeamMemberFilterMatrix",quizzSortTeamMemberFilterMatrixDataFetcher)
                .dataFetcher("quizzSortTeamMemberOption",quizzSortTeamMemberOptionDataFetcher)
                .dataFetcher("quizzWinnerParticipantOrderOption",quizzWinnerParticipantOrderOptionDataFetcher)
                .dataFetcher("quizzWinnerTeamOrderOption",quizzWinnerTeamOrderOptionDataFetcher)
                .dataFetcher("masterData",masterDataDataFetcher)
                .dataFetcher("participantSummary",participantSummaryDataFetcher)
                .dataFetcher("participantGameActivity",participantGameActivityDataFetcher)
                .dataFetcher("participantCampActivity",participantCampActivityDataFetcher)
                .dataFetcher("getProperties",getPropertiesDataFetcher)
                .dataFetcher("playerPerformanceComparison",playerPerformanceComparisonDataFetcher)
                //.dataFetcher("playerPerformanceComparisonGames",playerPerformanceComparisonDataFetcher)
                //.dataFetcher("playerPerformanceComparisonParticipants",playerPerformanceComparisonDataFetcher)
                .dataFetcher("teamGameTimeline",teamGameTimelineDataFetcher)
                .dataFetcher("teamParticipantTimeline",teamParticipantTimelineDataFetcher)
                .dataFetcher("scoreTimeline",scoreTimelineDataFetcher)
                //.dataFetcher("scoreTimelineParticipants",scoreTimelineDataFetcher)
                //.dataFetcher("scoreTimelineResults",scoreTimelineDataFetcher)
                .dataFetcher("gameInfo",gameInfoDataFetcher)
                .dataFetcher("gamePerformance",gamePerformanceDataFetcher)
            )
            .type("Mutation", typeWiring -> typeWiring
                .dataFetcher("createParticipantEntrance",createParticipantEntranceDataFetcher)
                .dataFetcher("createParticipantDeparture",createParticipantDepartureDataFetcher)
                .dataFetcher("createParticipantRealisation",createParticipantRealisationDataFetcher)
                .dataFetcher("createTimeline",createTimelineDataFetcher)
            )
            .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }

    public Resource getResource() {
        return resource;
    }

    public Resource getGraphiql() {
        return graphiql;
    }

}
