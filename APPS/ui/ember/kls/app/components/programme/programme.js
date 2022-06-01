import Component from '@glimmer/component';
import { tracked } from "@glimmer/tracking";
import { action } from "@ember/object";
import { inject as service } from '@ember/service';

export default class ProgrammeProgrammeComponent extends Component {
  @service("score") score;

  @tracked
  teams;
  @tracked
  scoreCaption=false;
  @tracked
  modal = false;

  popUpParticipant;
  topPerformersArray = [2,3,4,5,6];

  @action
  submit(form) {
    console.log("test")
  }

  @action
  getTeams(element) {
      //TODO centralize for all meta data (team, game attr)
      this.score.getProperties({entityType:"team"})
          .then(d => {
              this.teams = d.GetPropertiesOut;
          });
  }

  @action
  openPopup(participant) {
    console.log("participant "+participant);
    this.popUpParticipant = participant;
    this.modal = true;
  }
  @action
  closePopup(form) {
    console.log("close")
    this.modal = false;
  }
  @action
  toggleScoreCaption() {
    this.scoreCaption = !this.scoreCaption;
  }

}
