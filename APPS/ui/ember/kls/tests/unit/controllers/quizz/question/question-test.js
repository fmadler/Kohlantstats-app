import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Controller | quizz/question/question', function(hooks) {
  setupTest(hooks);

  // TODO: Replace this with your real tests.
  test('it exists', function(assert) {
    let controller = this.owner.lookup('controller:quizz/question/question');
    assert.ok(controller);
  });
});
