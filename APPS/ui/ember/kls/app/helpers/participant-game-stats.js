import { helper } from '@ember/component/helper';
import _ from "lodash";

export default helper(function participantGameStats(params/*, hash*/) {
  let [stats, programWebPath] = params;
  return _.filter(stats, {programWebPath:programWebPath})[0];
});
