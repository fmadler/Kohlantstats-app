import Controller from '@ember/controller';

import { tracked } from "@glimmer/tracking";

export default class ControllersTimelineIndexTeamParticipantTimeline extends Controller {
  scoreService = Ember.inject.service("score");
  queryParams= [
    'programWebPath',
    'teamWebPath',
    'participantWebPath',
  ];
  programWebPath = null;
  teamWebPath = null;
  participantWebPath = null;

}
