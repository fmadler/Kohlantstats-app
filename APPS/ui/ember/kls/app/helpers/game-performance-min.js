import { helper } from '@ember/component/helper';
import _ from "lodash";
export default helper(function gamePerformanceMin(params/*, hash*/) {
  let [performances, min] = params;
  return _.filter(performances, e => { e.individualPerformanceFirstTwoPercent > 0 }).length > min;
});
