import {
    winner_parcours_du_combattant_2021,
    winnerWebPath_parcours_du_combattant_2021,
    optionPoursuite2020Option,

}
    from './kls_mock_data';
import _ from "lodash";

export const root_url = "http://localhost:4400";

export function getFirstLoserFromOptions(winnerWebPath) {
    //get all data-cy=option-* and exclude winner
    const wwp = winnerWebPath;
    const prefix = 'option-'
    cy.xpath(`//div[starts-with(@data-cy,"${prefix}")]`).then(($p1) => {
        let isFound = false;
        $p1.each(e => {
            if (isFound) return;
            const optDataCy = $p1[e].getAttribute("data-cy");
            const opt = optDataCy.replace(prefix, "");
            if (opt !== wwp) {
                isFound = true;
                cy.wrap(opt).as("firstLoser");
            }
        })
    })
}

export function getSortParticipants() {
    const prefix = 'option-body-participant-'
    cy.xpath(`//div[starts-with(@data-cy,"${prefix}")]`).then(($p1) => {
        let participants = [];
        $p1.each(e => {
            const optDataCy = $p1[e].getAttribute("data-cy");
            const opt = optDataCy.replace(prefix, "");
            participants.push(opt);
        })
        cy.wrap(participants).as("participants");
    })
}

export function getParticipantTeamForPoursuite2020(optionPoursuite2020Option, participantWebPath) {
    return _.filter(optionPoursuite2020Option, { participantWebPath: participantWebPath })[0].teamWebPath;
}

export function getFirstParticipantOtherTeamForPoursuite2020(optionPoursuite2020Option, participantWebPath) {
    let currentTeam = _.filter(optionPoursuite2020Option, { participantWebPath: participantWebPath })[0].teamWebPath;
    return _.find(optionPoursuite2020Option, e => {
        return e.teamWebPath !== currentTeam;
    }).teamWebPath;
}

export function checkAnswerCorrect() {
    cy.get(`[data-cy=incorrect-answer]`).should('not.exist')
    cy.get(`[data-cy=correct-answer]`).should('exist')
}

export function checkAnswerIncorrect() {
    cy.get(`[data-cy=incorrect-answer]`).should('exist')
    cy.get(`[data-cy=correct-answer]`).should('not.exist')
}

export function clickNextQuestion() {
    cy.get(`[data-cy=next-question-btn]`).click()
}

export function validate() {
    cy.get(`[data-cy=validate-btn]`).click()
}

export function goToEditions() {
    cy.get("[data-cy=nav-editions").click()
}

export function goToEdition(edition) {
    goToEditions()
    cy.get(`a[href="/programme/${edition}"]`).first().click()
}

export function goToHomePage() {
    cy.visit(`${root_url}`)
}

export function goToParticipant(programWp, participantWp) {
    cy.visit(`${root_url}/programme/${programWp}/participant/${participantWp}`)
}

export function goToGame(programWp, gameWp) {
    cy.visit(`${root_url}/programme/${programWp}/game/${gameWp}`)
}

export function goToPlayers() {
    cy.visit(`${root_url}/player`)
}

export function goToPlayersEdition(programWp) {
    cy.visit(`${root_url}/player?programWebPath=${programWp}`)
}


export function goToPlayer(playerWp) {
    cy.visit(`${root_url}/player/${playerWp}`)
}

export function goToQuizz() {
    cy.get("[data-cy=nav-quizz").click()
}

export function goToQuizzQuestion(category, program, game) {
    goToQuizz();
    cy.contains(category).click();
    cy.get(`[data-cy=all-questions-btn]`).click()
    cy.get(`[data-cy=link-to-question-${program}-${game}]`).click()
}

export function checkValidOrderFor(webPath) {
    cy.get(`[data-cy=option-body-${webPath}]`).should('have.class', 'kls-qz-correct-checked')
}

export function checkInvalidOrderFor(webPath) {
    cy.get(`[data-cy=option-body-${webPath}]`).should('have.class', 'kls-qz-incorrect-checked')
}

export function checkValue (dataCy, v) {
    cy.get(dataCy).then(($p1) => {
        cy.log("value to check "+$p1)
        const p1F = parseFloat($p1.text().trim())
        expect(p1F).to.eq(v)
    })
}