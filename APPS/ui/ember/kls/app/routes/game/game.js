import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';
import { task } from 'ember-concurrency';
import { fillCustomEntityValue } from 'kohlantstats/utils/entityvalue-utils';
import { fillIndividualWinnerStats } from 'kohlantstats/utils/kls-data-util';
import config from 'kohlantstats/config/environment';
const { host, namespace } = config.entityValueStoreDS;
const imageBaseUrl = host+"/"+namespace;


export default class GameGameRoute extends Route {
  @service('Score') scoreService;

  //TODO use task to load third party micro service
  model(params) {
    let searchParams =           {
      gameWebPath : params.gameWebPath,
      entityType : "game",
      entityWebPath : params.gameWebPath,
    };
    this.searchParams = searchParams;
    // let ret =  this.get('scoreService').gameDetail2(
    //   searchParams
    // );

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
      return yield this.scoreService.gameDetail2(
          searchParams
      ).then(d => {
          fillIndividualWinnerStats(d.gameStats);
          return d;
      });
  }

  @task
  * entityValueTask(params) {
      let searchParams = {
          entityFullWebPath: 'game/' + params.gameWebPath,
          tenantWebPath: 'kls',
      };
      return yield this.entityvaluestoreService.entityValue2(
          searchParams
      ).then(d => {
          return fillCustomEntityValue(d, { language: "FR", binaryType: "photo_up" }, imageBaseUrl);
      });
  }
}
