import { helper } from '@ember/component/helper';
import _ from 'lodash'

export default helper(function affectedOption(params/*, hash*/) {
  let [element1WebPath, affectedChoices] = params;
  let ao = _.filter(affectedChoices, {element1WebPath : element1WebPath});
  if (ao.length == 1) {
    return ao[0].element2WebPath;
  }
  return "";

});
