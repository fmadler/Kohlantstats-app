import { helper } from '@ember/component/helper';
import _ from 'lodash'

export default helper(function selectedOrderOption(params/*, hash*/) {
  let [webPath, position, orderedChoice] = params;
  return _.filter(orderedChoice, {webPath : webPath, position:position}).length == 1;
});
