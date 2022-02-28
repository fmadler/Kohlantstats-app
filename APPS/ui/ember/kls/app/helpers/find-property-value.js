import { helper } from '@ember/component/helper';
import _ from 'lodash'

export default helper(function findPropertyValue(params/*, hash*/) {
  let [properties, property, entityWebPath] = params;
  if (properties == undefined) return;
  let prop =_.find(properties, {entityWebPath: entityWebPath, property: property});
  if (prop == undefined) return; 
  return prop.propertyValue;
});
