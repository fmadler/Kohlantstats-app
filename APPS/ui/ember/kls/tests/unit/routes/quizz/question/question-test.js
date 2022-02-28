import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | quizz/question/question', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:quizz/question/question');
    assert.ok(route);
  });
});
