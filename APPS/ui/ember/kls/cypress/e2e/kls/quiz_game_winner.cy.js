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

context('Quiz', () => {
    beforeEach(() => {
        cy.visit('http://localhost:4400/quizz')
    })

    it('Participant-team affectation not ok', () => {
        goToQuizzQuestion('Répartition des participants par épreuve', 'les-quatre-terres', 'poursuite-par-equipe-2020');
        //check team color
        getSortParticipants()

        cy.get("@participants").then((fl) => {
            fl.forEach(p => {
                cy.get(`[data-cy=option-body-participant-${p}]`).click()
                //let team = getParticipantTeamForPoursuite2020(optionPoursuite2020Option, p);
                let otherTeam = getFirstParticipantOtherTeamForPoursuite2020(optionPoursuite2020Option, p);
                
                cy.get(`[data-cy=option-body-team-${otherTeam}]`).click()
            })
        })
        validate();
        checkAnswerIncorrect();
        cy.get(`[data-cy=validate-btn]`).should('exist')
        //TODO pickup displayed participant
        //pick correct affectation from optionPoursuite2020Option
        //validate and check
    })

    it('Participant-team affectation ok', () => {
        goToQuizzQuestion('Répartition des participants par épreuve', 'les-quatre-terres', 'poursuite-par-equipe-2020');
        //check team color
        getSortParticipants()

        cy.get("@participants").then((fl) => {
            fl.forEach(p => {
                cy.get(`[data-cy=option-body-participant-${p}]`).click()
                let team = getParticipantTeamForPoursuite2020(optionPoursuite2020Option, p);         
                cy.get(`[data-cy=option-body-team-${team}]`).click()
            })
        })
        validate();
        checkAnswerCorrect();
        cy.get(`[data-cy=validate-btn]`).should('not.exist')
        //TODO pickup displayed participant
        //pick correct affectation from optionPoursuite2020Option
        //validate and check
    })

    it('Quiz validation error', () => {
        goToQuizzQuestion('Classement des meilleurs tribus', 'les-quatre-terres', 'poursuite-par-equipe-2020');
        cy.get(`[data-cy=option-ouest-2020-0]`).click()
        cy.get(`[data-cy=option-ticked-ouest-2020-0]`).should('exist')
        cy.get(`[data-cy=option-nord-2020-1]`).click()
        cy.get(`[data-cy=option-ticked-nord-2020-1]`).should('exist')
        cy.get(`[data-cy=option-sud-2020-2]`).click()
        cy.get(`[data-cy=option-ticked-sud-2020-2]`).should('exist')
        validate();
        checkValidOrderFor('ouest-2020')
        checkInvalidOrderFor('nord-2020')
        checkInvalidOrderFor('sud-2020')
        cy.get(`[data-cy=option-sud-2020-1]`).click()
        cy.get(`[data-cy=option-nord-2020-2]`).click()
        validate();
        checkValidOrderFor('ouest-2020')
        checkValidOrderFor('nord-2020')
        checkValidOrderFor('sud-2020')
    })

    it('Quiz with ordered answer button behavior', () => {
        goToQuizzQuestion('Classement des meilleurs participants', 'les-armes-secretes', 'parcours-en-cinq-etapes-2021');
        cy.get(`[data-cy=option-arnaud-2021-1]`).click()
        cy.get(`[data-cy=option-ticked-arnaud-2021-1]`).should('exist')
        cy.get(`[data-cy=validate-btn]`).should('be.disabled')
        cy.get(`[data-cy=option-flavio-2021-1]`).click()
        cy.get(`[data-cy=option-ticked-flavio-2021-1]`).should('exist')
        cy.get(`[data-cy=validate-btn]`).should('be.disabled')
        cy.get(`[data-cy=option-flavio-2021-2]`).click()
        cy.get(`[data-cy=option-ticked-flavio-2021-1]`).should('not.exist')
        cy.get(`[data-cy=option-ticked-flavio-2021-2]`).should('exist')
        cy.get(`[data-cy=option-maxine-2021-0]`).click()
        cy.get(`[data-cy=option-ticked-maxine-2021-0]`).should('exist')
        cy.get(`[data-cy=validate-btn]`).should('not.be.disabled')
        validate();
        checkValidOrderFor('maxine-2021')
        checkValidOrderFor('flavio-2021')
        checkValidOrderFor('arnaud-2021')
    })

    it('Once valid cannot check options', () => {
        //given
        goToQuizz();
        cy.contains('Qui est le vainqueur du jeu').click();
        cy.get(`[data-cy=all-questions-btn]`).click()
        cy.get(`[data-cy=link-to-question-les-armes-secretes-parcours-du-combattant-2021]`).click()
        //check validate not enabled
        cy.get(`[data-cy=option-laure-2021]`).click()
        validate();

        //when try to click having
        //click the same => still ticked
        cy.get(`[data-cy=option-laure-2021]`).click()
        cy.get(`[data-cy=option-ticked-laure-2021]`).should('exist')

        //click on invalid => should not be ticked

    })

    it('Quizz on winner team', () => {
        goToQuizz();
        cy.contains('Quelle tribu est vainqueur').click();
        cy.get(`[data-cy=all-questions-btn]`).click()
        cy.get(`[data-cy=link-to-question-les-quatre-terres-poursuite-par-equipe-2020]`).click()
        cy.get(`[data-cy=validate-btn]`).should('be.disabled')
        cy.get(`[data-cy=option-ticked-ouest-2020]`).should('not.exist')
        cy.get(`[data-cy=option-ouest-2020]`).click()
        validate();
    })

    // https://on.cypress.io/interacting-with-elements

    it('Check first option', () => {
        cy.contains('Qui est le vainqueur du jeu').click();
        cy.get(`[data-cy=validate-btn]`).should('not.exist')
        cy.get(`[data-cy=all-questions-btn]`).click()
        cy.get(`[data-cy=link-to-question-les-armes-secretes-parcours-du-combattant-2021]`).click()
        //check validate not enabled
        cy.get(`[data-cy=validate-btn]`).should('be.disabled')
        cy.get(`[data-cy=option-ticked-laure-2021]`).should('not.exist')
        cy.get(`[data-cy=option-laure-2021]`).click()
        cy.get(`[data-cy=option-ticked-laure-2021]`).should('exist')
        cy.get(`[data-cy=validate-btn]`).should('not.be.disabled')
        validate();
        //check result is correct

        cy.get(`[data-cy=validate-btn]`).should('not.exist')
        cy.get(`[data-cy=option-ticked-laure-2021]`).should('exist')
        cy.get(`[data-cy=correct-answer]`).should('exist')
        cy.get(`[data-cy=incorrect-answer]`).should('not.exist')

    })

    it('Check wrong option', () => {
        cy.contains('Qui est le vainqueur du jeu').click();
        cy.get(`[data-cy=all-questions-btn]`).click()
        cy.get(`[data-cy=link-to-question-les-armes-secretes-parcours-du-combattant-2021]`).click()

        getFirstLoserFromOptions(winnerWebPath_parcours_du_combattant_2021)

        cy.get("@firstLoser").then((fl) => {
            cy.get(`[data-cy=option-${fl}]`).click()
        })
        validate();
        checkAnswerIncorrect();
    })


    it('Check reset when back to quizz', () => {
        goToQuizz();
        cy.contains('Qui est le vainqueur du jeu').click();
        /// ??? should have being reseted for test isolation ???cy.get(`[data-cy=validate-btn]`).should('not.exist')
        cy.get(`[data-cy=all-questions-btn]`).click()
        cy.get(`[data-cy=link-to-question-les-armes-secretes-parcours-du-combattant-2021]`).click()
        //check validate not enabled

        cy.get(`[data-cy=validate-btn]`).should('be.disabled')
        cy.get(`[data-cy=option-ticked-laure-2021]`).should('not.exist')
        cy.get(`[data-cy=option-laure-2021]`).click()
        cy.get(`[data-cy=option-ticked-laure-2021]`).should('exist')
        cy.get(`[data-cy=validate-btn]`).should('not.be.disabled')
        validate();
        //check result is correct

        cy.get(`[data-cy=option-ticked-laure-2021]`).should('exist')

        //pick a wrong option
        goToQuizz()
        cy.contains('Qui est le vainqueur du jeu').click();
        cy.get(`[data-cy=all-questions-btn]`).click()
        cy.get(`[data-cy=link-to-question-les-armes-secretes-parcours-du-combattant-2021]`).click()

        cy.get(`[data-cy=validate-btn]`).should('be.disabled')
    })

    it('Check next question', () => {
        goToQuizz();
        cy.contains('Qui est le vainqueur du jeu').click();
        cy.get(`[data-cy=all-questions-btn]`).click()
        cy.get(`[data-cy=link-to-question-les-armes-secretes-parcours-du-combattant-2021]`).click()
        //check validate not enabled
        cy.get(`[data-cy=option-laure-2021]`).click()
        validate();
        clickNextQuestion()
        //check score
        // find a way to figure out what the next question is
        // cy.get(`[data-cy=option-myriam-2021]`).click()
        // validate();
        // clickNextQuestion()
    })



    it('No questions displayed from generic question lookup', () => {
        goToQuizz();
        //TODO
    })

})
