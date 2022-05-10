import { helper } from '@ember/component/helper';
import { getIconProperties } from 'kohlantstats/utils/icon-utils';
export default helper(function iconProperty(params/*, hash*/) {
  //input in format of "fa fa-icon"
  let [prop] = params;
  return getIconProperties(prop);
});
