import Component from '@glimmer/component';
import fillIndividualWinnerStats from 'kohlantstats/utils/kls-data-util';

export default class PlayerPlayerComponent extends Component {

    get stats() {
        return this.args.data.gameStats;
    }

    get individualWinnerStats() {
        let stats = this.args.data.gameStats;
        fillIndividualWinnerStats(stats);
    }

}
