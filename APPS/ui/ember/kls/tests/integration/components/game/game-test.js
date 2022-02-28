import { module, test } from 'qunit';
import { setupRenderingTest } from 'ember-qunit';
import { render } from '@ember/test-helpers';
import { hbs } from 'ember-cli-htmlbars';

module('Integration | Component | game/game', function(hooks) {
  setupRenderingTest(hooks);

  test('it renders', async function(assert) {
    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.set('myAction', function(val) { ... });

    await render(hbs`<Game::Game />`);
    assert.dom('.container')
    .containsText('Ensemble des épreuves', 'The user sees Ensemble des épreuves.');
    assert.dom('.container')
    .doesNotIncludeText('Jeu suivant', 'The user does not see Jeu suivant.');
    

    this.set('data', {custom:{nextGame:{name:"Bamboo", webPath:"bamboo-2020"}}});

    await render(hbs`
      <Game::Game @data={{this.data}}/>
    `);
    assert.dom('.container')
    .containsText('Jeu suivant', 'The user sees Jeu suivant.');


  });
});
