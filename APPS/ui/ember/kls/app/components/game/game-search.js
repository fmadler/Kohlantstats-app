import Component from '@glimmer/component';
import { tracked } from '@glimmer/tracking';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';

export default class GameGameSearchComponent extends Component {

    @service router;

    @tracked
    selectedGameTagWebPath = this.args.gameTagWebPath;
    @tracked
    programWebPath = this.args.programWebPath;

    @action
    toggleTag(gameTagWebPath) {
        if (this.selectedGameTagWebPath === gameTagWebPath) {
            this.selectedGameTagWebPath = null;
        } else {
            this.selectedGameTagWebPath = gameTagWebPath;
        }
        this.router.transitionTo('programme.game.index', {
            queryParams: {
                programWebPath: this.programWebPath,
                gameTagWebPath: this.selectedGameTagWebPath
            }
        });
    }
}
