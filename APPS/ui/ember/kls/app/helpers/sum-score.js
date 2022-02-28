import { helper } from '@ember/component/helper';
import _ from 'lodash'

export default helper(function programScore(params/*, hash*/) {
  let [ stats, field ] = params;
  if (stats!==undefined) {
    if (field===undefined) field = "score";
    return _.sumBy(stats, e => e[field]);
  }

});
