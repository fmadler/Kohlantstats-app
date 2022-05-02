import Route from '@ember/routing/route';

import {getCurrentGame, getNextGame, getPreviousGame} from 'kohlantstats/utils/kls-data-util';

import { inject as service } from '@ember/service';
import { task } from 'ember-concurrency';
import { fillCustomEntityValue } from 'kohlantstats/utils/entityvalue-utils';
import { fillIndividualWinnerStats } from 'kohlantstats/utils/kls-data-util';
import config from 'kohlantstats/config/environment';
const { host, namespace } = config.imageDS;
const imageBaseUrl = host+"/"+namespace;


export default class ProgrammeGameGameRoute extends Route {

    @service('Score') scoreService;
    @service('Entityvaluestore') entityvaluestoreService;

    model(params) {
        let searchParams = {
            programWebPath: params.programWebPath,
            gameWebPath: params.gameWebPath,
            entityType: "game",
            entityWebPath: params.gameWebPath,
        };
        this.searchParams = searchParams;
        // let ret = this.get('scoreService').gameDetail2(
        //     searchParams
        // ).then(d => {
        //     let gameWebPath= d.params.gameWebPath;
        //     let distinctGames = d.distinctGames;
        //     d.custom = {
        //         'currentGame' : getCurrentGame(distinctGames, gameWebPath),
        //         'nextGame' : getNextGame(distinctGames, gameWebPath),
        //         'previousGame' : getPreviousGame(distinctGames, gameWebPath),
        //     }
		// 	return d;
		// });
        //return ret;
        return {
            params: params,
            taskGameDetail: this.gameDetail.perform(
                searchParams
            ),
            taskEntityValue: this.entityValueTask.perform(params),
        };
    }

    @task
    * gameDetail(searchParams) {
        return this.scoreService.gameDetail2(
            searchParams
        ).then(d => {
            let gameWebPath= d.params.gameWebPath;
            let distinctGames = d.distinctGames;
            d.custom = {
                'currentGame' : getCurrentGame(distinctGames, gameWebPath),
                'nextGame' : getNextGame(distinctGames, gameWebPath),
                'previousGame' : getPreviousGame(distinctGames, gameWebPath),
            }
			return d;
		});
    }

    @task
    * entityValueTask(params) {
        let searchParams = {
            entityFullWebPath: 'programme/' + params.programWebPath + '/game/' + params.gameWebPath,
            tenantWebPath: 'kls',
        };
        return yield this.entityvaluestoreService.entityValue2(
            searchParams
        ).then(d => {
            return fillCustomEntityValue(d, { language: "FR", binaryType: "photo_up" }, imageBaseUrl);
        });
    }
}
