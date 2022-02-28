import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | definitions', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:definitions');
    assert.ok(route);
  });
});
