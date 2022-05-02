import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';
import { task } from 'ember-concurrency';
import { fillCustomEntityValue } from 'kohlantstats/utils/entityvalue-utils';
import { fillIndividualWinnerStats } from 'kohlantstats/utils/kls-data-util';
import config from 'kohlantstats/config/environment';
const { host, namespace } = config.imageDS;
const entityValueStoreBaseUrl = host+"/"+namespace;

export default class PlayerPlayerRoute extends Route {
    titleToken = ['field.participant'];
    @service('Score') scoreService;
    @service('Entityvaluestore') entityvaluestoreService;

    searchParams=null;
    model(params) {
        let searchParams = {
            playerWebPath: params.playerWebPath,
            entityType: "player",
            entityWebPath: params.playerWebPath,
        };

        return {
            params: params,
            taskParticipantDetail: this.participantDetail.perform(
                searchParams
            ),
            taskEntityValue: this.entityValueTask.perform(params),
        };
    }

    @task
    * participantDetail(searchParams) {
        return this.scoreService.participantDetail2(
            searchParams
        ).then(d => {
            fillIndividualWinnerStats(d.gameStats);
            return d;
        });
    }

    @task
    * entityValueTask(params) {
        let searchParams = {
            entityFullWebPath: 'player/' + params.playerWebPath,
            tenantWebPath: 'kls',
        };
        return yield this.entityvaluestoreService.entityValue2(
            searchParams
        ).then(d => {
            return fillCustomEntityValue(d, { language: "FR", binaryType: "photo_up" }, entityValueStoreBaseUrl);
        });
    }
}
