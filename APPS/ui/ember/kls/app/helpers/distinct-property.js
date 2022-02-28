import { helper } from '@ember/component/helper';
import _ from 'lodash'

export default helper(function distinctProperty(params/*, hash*/) {
  let [arr, webPath] = params;
  return _.uniqBy(arr, webPath);
  /*
  const uniqueLocations = _.uniqWith(
  locations,
  (locationA, locationB) =>
    locationA.latitude === locationB.latitude &&
    locationA.longitude === locationB.longitude
);
  */
});
