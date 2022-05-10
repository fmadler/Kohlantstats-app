import { getIconProperties } from 'kohlantstats/utils/icon-utils';
import { module, test } from 'qunit';

const inputIconClass = "fa fa-globe"
const expectedResult = {prefix:"fa",key:"globe"}
module('Unit | Utility | icon-utils', function () {

  test('test icon class to json', function (assert) {
    debugger
    let result = getIconProperties(inputIconClass);
    assert.deepEqual(result, expectedResult)
  });

});
