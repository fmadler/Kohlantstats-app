import {
    klsSiteUrl

}
    from './kls_mock_data';
import {
    getFirstLoserFromOptions,

}
    from './kls_commons';
const sizes = ['iphone-6', 'iphone-x'];//, 'ipad-2', [1024, 768]]

context('KLS Responsive', () => {
    beforeEach(() => {
        cy.visit('http://localhost:4400/')
    })

    sizes.forEach((size) => {
      // make assertions on the logo using


        // an array of different viewports
        it(`Should Quizz on ${size} screen`, () => {
          if (Cypress._.isArray(size)) {
            cy.viewport(size[0], size[1])
          } else {
            cy.viewport(size)
          }

          cy.visit(klsSiteUrl)
          cy.get(".navbar-toggler-icon").click()

          cy.get(`[data-cy=nav-editions]`).should('be.visible')
          cy.get(`[data-cy=nav-participants]`).should('be.visible')

          cy.get(`[data-cy=nav-editions]`).click()

          cy.get('.kls-img')
            .invoke('height')
            .should('be.greaterThan', 50)
            .and('be.lessThan',200)

        })
    })

})
