import { helper } from '@ember/component/helper';
import { getBinaryUrl } from 'kohlantstats/utils/entityvalue-utils';

import config from 'kohlantstats/config/environment';
const { host, namespace } = config.imageDS;
const baseUrl = host+"/"+namespace;

export default helper(function binaryUrl(params/*, hash*/) {
  let [ entityFullWebPath, binaryType ] = params;
  let binaryInfo = {binaryType:binaryType, entityFullWebPath:entityFullWebPath};
  return getBinaryUrl(binaryInfo, baseUrl);
});
