import { module, test } from 'qunit';
import { setupRenderingTest } from 'ember-qunit';
import { render } from '@ember/test-helpers';
import { hbs } from 'ember-cli-htmlbars';

module('Integration | Component | card/programme-card', function(hooks) {
  setupRenderingTest(hooks);

  test('it renders', async function(assert) {
    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.set('myAction', function(val) { ... });

    await render(hbs`<Card::ProgrammeCard />`);

    //assert.equal(this.element.textContent.trim(), '');
    assert.dom('.card-body')
    .containsText('Edition', 'The user sees Edition.');

    this.set('data', {name:'KLS',editionNumber:21});

    await render(hbs`
      <Card::ProgrammeCard @data={{this.data}}/>
    `);
    assert.dom('.card-header')
    .hasText('KLS', 'The user sees KLS.');

  });
});
