import { helper } from '@ember/component/helper';

export default helper(function participantFullEntityWebpath(params/*, hash*/) {
  let [ programWebPath, participantWebPath ] = params;
  return `programme/${programWebPath}/participant/${participantWebPath}`;
});
