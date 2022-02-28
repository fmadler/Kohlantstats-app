import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';

export default class ProgramIndexRoute extends Route {
    @service('Score') scoreService;

    model(params) {
      return this.scoreService.distinctPrograms();
    }
}
