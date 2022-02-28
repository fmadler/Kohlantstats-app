import Component from '@glimmer/component';
import { tracked } from '@glimmer/tracking';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';

export default class PlayerPlayerSearchComponent extends Component {
    @service router;


    @tracked
    performanceCaptionToggle=false;
    @tracked
    participantCompareTargetToggle=false;
    
    @tracked
    selectedPlayerWebPath = this.args.model.params.playerWebPath;
    @tracked
    selectedComparisonPlayerWebPath = this.args.model.params.comparisonPlayerWebPath;
    @tracked
    programWebPath = this.args.model.params.programWebPath;

    @action
    togglePlayer(selectedPlayerWebPath) {
        if (this.selectedPlayerWebPath === selectedPlayerWebPath) {
            this.selectedPlayerWebPath = null;
        } else {
            this.selectedPlayerWebPath = selectedPlayerWebPath;
        }
        this.router.transitionTo('player.index', {
            queryParams: {
                programWebPath: this.programWebPath,
                playerWebPath: this.selectedPlayerWebPath
            }
        });
    }

    @action
    toggleComparisonPlayer(selectedComparisonPlayerWebPath) {
        if (this.selectedComparisonPlayerWebPath === selectedComparisonPlayerWebPath) {
            this.selectedComparisonPlayerWebPath = null;
        } else {
            this.selectedComparisonPlayerWebPath = selectedComparisonPlayerWebPath;
        }
        this.router.transitionTo('player.index', {
            queryParams: {
                programWebPath: this.programWebPath,
                playerWebPath: this.selectedPlayerWebPath,
                comparisonPlayerWebPath: this.selectedComparisonPlayerWebPath,
            }
        });
    }
    
    @action 
    toogleParticipantCompareTarget () {
        this.participantCompareTargetToggle = !this.participantCompareTargetToggle;
    }

    @action 
    togglePerformanceCaption () {
        this.performanceCaptionToggle = !this.performanceCaptionToggle;
    }

}
