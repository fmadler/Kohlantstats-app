import { helper } from '@ember/component/helper';

export default helper(function plus(params/*, hash*/) {
  let [input, valueToAdd] = params;
  return input+valueToAdd;
});
