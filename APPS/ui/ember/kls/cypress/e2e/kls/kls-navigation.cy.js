import {
  program_Les4terres_webPath,
  program_Lalegende_name,
  program_Les4terres_name,
  loic_Les4terres_webPath,
  alexandra_Les4terres_webPath,
  loic_Les4terres_score_longevity

}
  from './kls_mock_data';
import {
  root_url,
  goToEditions,
  goToPlayer,
  goToEdition,
  goToParticipant,
  goToGame,
  goToPlayers,
  goToPlayersEdition,
  goToQuizz,
  goToQuizzQuestion,
  goToHomePage,
  checkValue,
  checkText
}
  from './kls_commons';

//cy.get('.fa-sign-in')
context('Navigation links', () => {
    beforeEach(() => {
        cy.visit(root_url)
    })
    it('Check edition navigation', () => {
      goToEdition("les-quatre-terres")
      cy.get(`[data-cy=link-next-edition]`).should('exist')
      cy.get(`[data-cy=link-previous-edition]`).should('not.exist')

      cy.get(`[data-cy=link-next-edition]`).click();
      cy.get(`[data-cy=link-next-edition]`).should('exist')
      cy.get(`[data-cy=link-next-edition]`).contains( program_Lalegende_name)
      cy.get(`[data-cy=link-previous-edition]`).should('exist')
      cy.get(`[data-cy=link-previous-edition]`).contains(program_Les4terres_name)
    })


})
