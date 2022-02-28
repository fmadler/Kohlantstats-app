import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';

export default class ProgrammeGameIndexRoute extends Route {
    queryParams = {
        gameTagWebPath: {
            refreshModel: true
        },
        rewardWebPath: {
            refreshModel: true
        }
    };

    @service('Score') scoreService;

    model(params) {
      return this.scoreService.gameSearch2(params);
    }
}
