import {
    program_Les4terres_webPath,
    loic_Les4terres_webPath,
    alexandra_Les4terres_webPath

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
}
    from './kls_commons';
    

context('SEO', () => {
    beforeEach(() => {
        cy.visit(root_url)
    })

    it('Homepage SEO', () => {
        goToHomePage();
        cy.title().should('eq', 'Kohlantstats')
    })

    it('Quizz SEO', () => {
        goToQuizz();
        cy.title().should('eq', 'Quizz | Kohlantstats')
    })

    it('Player comparison SEO', () => {
        goToPlayers()
        cy.title().should('eq', 'Découvrer les performances des participants | Kohlantstats')
        cy.get(`[data-cy=programme-${program_Les4terres_webPath}]`).click()
        cy.title().should('eq', `Découvrer les performances des participants dans l'édition Les quatre terres | Kohlantstats`)
        cy.get(`[data-cy=participant-${loic_Les4terres_webPath}]`).click()
        //cy.title().should('eq', `Découvrer les performances de Loïc dans l'édition Les quatre terres | Kohlantstats`)

        // cy.get('head meta[name="description"]').should(
        //     'have.attr',
        //     'content',
        //     'Information du joueur'
        //   )
        
    })

    it('Player SEO', () => {
        goToPlayer("loic-2020")
        cy.title().should('eq', 'Loïc | Kohlantstats')
    })

    it('Editions SEO', () => {
        goToEditions()
        cy.title().should('eq', 'Editions de Kohlanta | Kohlantstats')
        //TODO use click and check url
        goToEdition("les-quatre-terres")
        cy.title().should('eq', 'Edition - Les quatre terres | Kohlantstats')
    })

    it('Participant SEO', () => {
        goToParticipant("les-quatre-terres","loic-2020")
        cy.title().should('eq', 'Loïc - Les quatre terres | Kohlantstats')
    })

    it('Game SEO', () => {
        goToGame("les-quatre-terres","poteaux-2020")
        cy.title().should('eq', 'Poteaux - Les quatre terres | Kohlantstats')
    })


})
