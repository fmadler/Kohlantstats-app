import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | programme/game/game', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:programme/game/game');
    assert.ok(route);
  });
});
