import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | quizz/index', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:quizz/index');
    assert.ok(route);
  });
});
