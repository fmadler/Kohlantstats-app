import Component from '@glimmer/component';

export default class ParticipantParticipantScoreTableComponent extends Component {


    gameStats = this.args.stats;

    get score() {
        return this.gameStats;
    }

}
