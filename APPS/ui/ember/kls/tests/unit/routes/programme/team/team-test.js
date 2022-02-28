import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | programme/team/team', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:programme/team/team');
    assert.ok(route);
  });
});
