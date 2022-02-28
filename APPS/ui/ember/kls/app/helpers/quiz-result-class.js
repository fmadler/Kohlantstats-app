import { helper } from '@ember/component/helper';
import _ from 'lodash'

export default helper(function quizResultClass(params/*, hash*/) {
  let [active, webpath, choicesResults] = params;
  if (active) {
    if (webpath == undefined) return;
    if (choicesResults == undefined) return;
    let prop = _.find(choicesResults, { participantWebPath: webpath });
    if (prop == undefined) return;
    return "kls-qz-" + prop.validationResult;
  } else {
    return;
  }
});
