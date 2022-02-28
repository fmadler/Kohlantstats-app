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
    
//cy.get('.fa-sign-in')
context('Images & Icons', () => {
    beforeEach(() => {
        cy.visit(root_url)
    })
    it('Hadja icon', () => {
        goToParticipant("les-quatre-terres","hadja-2020")
        cy.get('.fa-user')
        cy.get('.kls-img').children()
            .should('have.class', 'fa-user')
    })

    
    it('Loïc image', () => {
        goToParticipant("les-quatre-terres","loic-2020")
        cy.get('.kls-img')
            .should('not.have.class', 'fa-user')
    })

  
})