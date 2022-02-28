import Component from '@glimmer/component';
import { tracked } from '@glimmer/tracking';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';

export default class ParticipantParticipantComponent extends Component {
//TODO initialized team metadata
    @service("score") score;

    @tracked
    teams;

    @tracked
    performanceCaptionToggle=false;

    @tracked
    scoreCaption = false;

    @action
    getTeams(element) {
        this.score.getProperties({entityType:"team"})
            .then(d => {
                this.teams = d.GetPropertiesOut;
            });
        //TODO caching
    }

    @action 
    togglePerformanceCaption () {
        this.performanceCaptionToggle = !this.performanceCaptionToggle;
    }

    @action 
    toggleScoreCaption () {
        this.scoreCaption = !this.scoreCaption;
    }
    

}
