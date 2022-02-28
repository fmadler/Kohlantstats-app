import { helper } from '@ember/component/helper';
import { getScore } from 'kohlantstats/utils/kls-data-util';

export default helper(function scoreHelper(params/*, hash*/) {
  let [stats] = params;
  return getScore(stats);
});
