import Component from '@glimmer/component';
import { getScore } from 'kohlantstats/utils/kls-data-util';
import { inject as service } from '@ember/service'; // with polyfill
import { action } from '@ember/object';
import { tracked } from "@glimmer/tracking";

export default class ParticipantParticipantScoreTableComponent extends Component {


    gameStats = this.args.stats;

    get score() {
        return getScore(this.gameStats);
    }

}
