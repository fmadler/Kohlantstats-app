import Route from '@ember/routing/route';
import ConfigAwareRoute from 'kohlantstats/routes/config-aware-route'
import { inject as service } from '@ember/service';
import { task } from 'ember-concurrency';
import { tracked } from "@glimmer/tracking"
import { fillCustomEntityValue } from 'kohlantstats/utils/entityvalue-utils';

//TODO add in ConfigAwareRoute
import config from 'kohlantstats/config/environment';
const { host, namespace } = config.imageDS;
const imageBaseUrl = host + "/" + namespace;

export default class ProgrammeParticipantParticipantRoute extends ConfigAwareRoute {
    @service('Score') scoreService;
    @service('Entityvaluestore') entityvaluestoreService;

    @tracked headTags ; /*= [
        {
        type: 'meta',
        tagId: 'meta-og-name',
        attrs: {
            property: 'og:name',
            content: 'Ice-T'
        }
    },
    {
        type: 'link',
        tagId: 'canonical-link',
        attrs: {
            rel: 'canonical',
            content: 'http://mydomain.org/'
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
            //content: this.entityValueTask(this.params).value.custom.description
        },
        // optional element content
        content: 'Element content here'
    }
    ];
    */

    afterModel(model, transition) {
        /*
        this.headTags = [{
            type: 'meta',
            tagId: 'meta-og-name',
            attrs: {
                property: 'og:name',
                content: 'Ice-T'
            }
        },
        {
            type: 'link',
            tagId: 'canonical-link',
            attrs: {
                rel: 'canonical',
                content: 'http://mydomain.org/'
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
                content: 'todo',//model.taskEntityValue.value.custom.description
            },
            // optional element content
            content: 'Element content here'
        }
        ];
        // if (model.get('length') === 1) {
        //     this.transitionTo('post', model.get('firstObject'));
        // }
        */
    }

    model(params) {
        let searchParams = {
            programWebPath: params.programWebPath,
            playerWebPath: params.playerWebPath,
            entityType: "player",
            entityWebPath: params.playerWebPath,
        };
        let entityValueTaskPerform = this.entityValueTask.perform(params);
        let taskParticipantDetail = this.participantDetail.perform(searchParams);
        let playerEntityValueTaskPerform = this.taskPlayerEntityValueTask.perform(searchParams);
        return {
          params: params,
              taskParticipantDetail: taskParticipantDetail,
              taskEntityValue: entityValueTaskPerform,
              taskPlayerEntityValue: playerEntityValueTaskPerform
          };
    }

    @task
    * participantDetail(searchParams) {
        return yield this.scoreService.participantDetail2(
            searchParams
        );
    }

    @task
    * taskPlayerEntityValueTask(params) {
        let searchParams = {
            entityFullWebPath: 'player/' + params.playerWebPath,
            tenantWebPath: 'kls',
        };
        return yield this.entityvaluestoreService.entityValue2(
            searchParams
        ).then(d => {
            let data = fillCustomEntityValue(d, { language: "FR", binaryType: "photo_up" }, imageBaseUrl);
            return data;
        });
    }

    @task
    * entityValueTask(params) {
        let searchParams = {
            entityFullWebPath: 'programme/' + params.programWebPath + '/participant/' + params.playerWebPath,
            tenantWebPath: 'kls',
        };
        return yield this.entityvaluestoreService.entityValue2(
            searchParams
        ).then(d => {
            let data = fillCustomEntityValue(d, { language: "FR", binaryType: "photo_up" }, imageBaseUrl);
            this.headTags = [
                {
                    // html element type (meta, link, etc.)
                    type: 'meta',
                    // unique id for nesting (see below)
                    tagId: 'meta-description-tag',
                    // key value attributes for the element
                    attrs: {
                        name: 'description',
                        content: data.custom.description,//model.taskEntityValue.value.custom.description
                    },
                    // optional element content
                    //content: data.custom.description
                }
                ];
            return data;
        });
    }
}
