import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | mentions-legales', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:mentions-legales');
    assert.ok(route);
  });
});
