import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | programme/participant/participant', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:programme/participant/participant');
    assert.ok(route);
  });
});
