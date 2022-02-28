import { helper } from '@ember/component/helper';

export default helper(function class4ParticipantActivity(params/*, hash*/) {
  let [activityTypeWebPath] = params;
  if (activityTypeWebPath !== 'participant') {
    return "kls-game-activity-none";
  }
  return "";
});
