import {
    winner_parcours_du_combattant_2021,
    winnerWebPath_parcours_du_combattant_2021,
    optionPoursuite2020Option

}
    from './kls_mock_data';
import {
    getFirstLoserFromOptions,
    goToQuizz,
    goToQuizzQuestion,
    validate,
    clickNextQuestion,
    checkValidOrderFor,
    checkInvalidOrderFor,
    getSortParticipants,
    getParticipantTeamForPoursuite2020,
    getFirstParticipantOtherTeamForPoursuite2020,
    checkAnswerCorrect,
    checkAnswerIncorrect
}
    from './kls_commons';

context('KLS TODOs', () => {
    beforeEach(() => {
        cy.visit('http://localhost:4400/')
    })

    it('TODO check responsive design', () => {
    })
    it('TODO check sitemap with quizz', () => {
    })
    it('TODO check stored quizz evaluations', () => {
    })
    it('TODO check pictures', () => {
    })
})
