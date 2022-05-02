import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';
import { task } from 'ember-concurrency';
import { fillCustomBinaryEntityValue } from 'kohlantstats/utils/entityvalue-utils';

import config from 'kohlantstats/config/environment';
const { host, namespace } = config.imageDS;
const entityValueStoreBaseUrl = host + "/" + namespace;

export default class PlayerIndexRoute extends Route {
    queryParams = {
        programWebPath: {
            refreshModel: true
        },
        playerWebPath: {
            refreshModel: true
        },
        comparisonPlayerWebPath: {
            refreshModel: true
        }
    };

    /*
    headTags= [
        {
        type: 'meta',
        tagId: 'meta-og-name',
        attrs: {
          property: 'og:name',
          content: 'Ice-T'
        }
      },
      {
        // html element type (meta, link, etc.)
        type: 'meta',
        // unique id for nesting (see below)
        tagId: 'meta-description-tag',
        // key value attributes for the element
        attrs: {
          name: 'description',
          content: 'Information du joueur', //TODO from evs
        },
        // optional element content
        content: 'Element content here'
      },
      {
        type: 'link',
        tagId: 'canonical-link',
        attrs: {
          rel: 'canonical',
          content: 'http://mydomain.org/'
        }
      }]
      */

    @service('Customscore') customscoreService;
    @service('Entityvaluestore') entityvaluestoreService;

    model(params) {
        params.comparisonPlayersWebPath = `${params.playerWebPath},${params.comparisonPlayerWebPath}`
        return {
            headTags : this.headTags,
            params : params,
            taskPlayerSearch : this.playerSearch2.perform(params),
            playerEntityValue: this.entityValueTask.perform(params.programWebPath, params.playerWebPath),
            player2EntityValue: this.entityValueTask.perform(params.programWebPath, params.comparisonPlayerWebPath),
        }
    }

    @task
    * playerSearch2(params) {
       return this.customscoreService.playerSearch2(params);
    }

    @task
    * entityValueTask(programWebPath, playerWebPath) {
        let searchParams = {
            entityFullWebPath: 'programme/' + programWebPath + '/participant/' + playerWebPath,
        };
        return yield this.entityvaluestoreService.binaryEntityValueRequest(
            searchParams
        ).then(d => {
            return fillCustomBinaryEntityValue(d, { binaryType: "face" }, entityValueStoreBaseUrl);
        });
    }

}
