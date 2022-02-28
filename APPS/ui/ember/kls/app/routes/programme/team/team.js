import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';

export default class ProgrammeTeamTeamRoute extends Route {
    @service('Score') scoreService;

    model(params) {
        let searchParams = {
            programWebPath: params.programWebPath,
            teamWebPath: params.teamWebPath,
            entityType: "team",
            entityWebPath: params.teamWebPath,
        };
        let ret = this.get('scoreService').teamDetail2(
            searchParams
        );
        return ret;
    }
}
