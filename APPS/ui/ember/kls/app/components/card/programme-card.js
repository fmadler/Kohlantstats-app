import Component from '@glimmer/component';
import { task } from 'ember-concurrency';
import { tracked } from "@glimmer/tracking";
import { action } from "@ember/object";
import { inject as service } from '@ember/service';
import {fillCustomEntityValue} from 'kohlantstats/utils/entityvalue-utils';

import config from 'kohlantstats/config/environment';
const { host, namespace } = config.imageDS;
const imageBaseUrl = host+"/"+namespace;

export default class CardProgrammeCardComponent extends Component {

    @service('Entityvaluestore') entityvaluestoreService;
    @service('score') score;//
    @tracked entityValue;
    @tracked gameStats;
    data = this.args.data;

    @action
    getEntityValue() {
        this.entityValue = this.entityValueTask.perform({programWebPath : this.data.webPath});
        this.gameStats = this.gameStatsTask.perform({programWebPath : this.data.webPath})
    }

    @task
    * gameStatsTask(params) {
      return yield this.score.gameStats(params);
    }

    @task
    * entityValueTask(params) {
      let searchParams = {
        entityFullWebPath : 'programme/'+params.programWebPath,
        tenantWebPath: 'kls'
      };
      return yield this.entityvaluestoreService.entityValue2(
        searchParams
      ).then(d => {
        return fillCustomEntityValue(d,{language:"FR",binaryType:"poster"}, imageBaseUrl);
      });
    }
}
