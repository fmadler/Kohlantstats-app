import Component from '@glimmer/component';
import { tracked } from '@glimmer/tracking';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';

export default class GameGameComponent extends Component {
    @service("score") score;

    @tracked
    teams;

    @action
    getTeams(element) {
        //TODO centralize for all meta data (team, game attr)
        this.score.getProperties({entityType:"team"})
            .then(d => {
                this.teams = d.GetPropertiesOut;
            });
    }

}
