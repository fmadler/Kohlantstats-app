import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';

export default class DefinitionsRoute extends Route {
    @service headData;

    afterModel() {
        this.headData.description = 'Définitions utilisées dans Kohlantstats pour calculer les scores des participants';
    }
}
