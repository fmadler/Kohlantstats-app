import { helper } from '@ember/component/helper';
import _ from 'lodash';

export default helper(function participationFilter(params/*, hash*/) {
  let [data, ranking, participationTypeName] = params;
  let details = data.participationDetails;
  return _.filter(details, {ranking:ranking, participationTypeName:participationTypeName});
});
