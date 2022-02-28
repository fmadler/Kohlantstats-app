//import klsDataUtil from 'kohlantstats/utils/quizz-utils';
import {
    affect,
    unaffect,
    getChoicesResultsForAffectation,
    isResultSetCorrectForCheckedOptions

}
    from 'kohlantstats/utils/quizz-utils';

import { module, test } from 'qunit';

const optionPoursuite2020Option = [
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Est", "teamWebPath": "est-2020", "participantName": "Bertrand-Kamal", "participantWebPath": "bertrand-kamal-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Est", "teamWebPath": "est-2020", "participantName": "Loïc", "participantWebPath": "loic-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Est", "teamWebPath": "est-2020", "participantName": "Alexandra", "participantWebPath": "alexandra-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Est", "teamWebPath": "est-2020", "participantName": "Hadja", "participantWebPath": "hadja-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Est", "teamWebPath": "est-2020", "participantName": "Laurent", "participantWebPath": "laurent-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Est", "teamWebPath": "est-2020", "participantName": "Joaquina", "participantWebPath": "joaquina-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Ouest", "teamWebPath": "ouest-2020", "participantName": "Brice", "participantWebPath": "brice-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Ouest", "teamWebPath": "ouest-2020", "participantName": "Diane", "participantWebPath": "diane-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Ouest", "teamWebPath": "ouest-2020", "participantName": "François", "participantWebPath": "francois-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Ouest", "teamWebPath": "ouest-2020", "participantName": "Dorian", "participantWebPath": "dorian-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Ouest", "teamWebPath": "ouest-2020", "participantName": "Estelle", "participantWebPath": "estelle-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Ouest", "teamWebPath": "ouest-2020", "participantName": "Jody", "participantWebPath": "jody-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Nord", "teamWebPath": "nord-2020", "participantName": "Lola", "participantWebPath": "lola-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Nord", "teamWebPath": "nord-2020", "participantName": "Fabrice", "participantWebPath": "fabrice-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Nord", "teamWebPath": "nord-2020", "participantName": "Angélique", "participantWebPath": "angelique-2020", "gameActivityTypeWebPath": "participant" },
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Nord", "teamWebPath": "nord-2020", "participantName": "Adrien", "participantWebPath": "adrien-2020", "gameActivityTypeWebPath": "participant" }, 
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Nord", "teamWebPath": "nord-2020", "participantName": "Marie-France", "participantWebPath": "marie-france-2020", "gameActivityTypeWebPath": "participant" }, 
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Nord", "teamWebPath": "nord-2020", "participantName": "Samuel", "participantWebPath": "samuel-2020", "gameActivityTypeWebPath": "participant" }, 
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Sud", "teamWebPath": "sud-2020", "participantName": "Alix", "participantWebPath": "alix-2020", "gameActivityTypeWebPath": "participant" }, 
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Sud", "teamWebPath": "sud-2020", "participantName": "Sébastien", "participantWebPath": "sebastien-2020", "gameActivityTypeWebPath": "participant" }, 
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Sud", "teamWebPath": "sud-2020", "participantName": "Carole", "participantWebPath": "carole-2020", "gameActivityTypeWebPath": "participant" }, 
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Sud", "teamWebPath": "sud-2020", "participantName": "Mathieu", "participantWebPath": "mathieu-2020", "gameActivityTypeWebPath": "participant" }, 
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Sud", "teamWebPath": "sud-2020", "participantName": "Aubin", "participantWebPath": "aubin-2020", "gameActivityTypeWebPath": "participant" }, 
    { "programName": "Les quatre terres", "programWebPath": "les-quatre-terres", "editionNumber": 20, "gameName": "Poursuite par équipe", "gameWebPath": "poursuite-par-equipe-2020", "timePosition": "1", "teamName": "Sud", "teamWebPath": "sud-2020", "participantName": "Ava", "participantWebPath": "ava-2020", "gameActivityTypeWebPath": "participant" }];

const sortChoices = [
    { "element1WebPath": "fabrice-2020", "element2WebPath": "ouest-2020" },
    { "element1WebPath": "aubin-2020", "element2WebPath": "est-2020" },
    { "element1WebPath": "marie-france-2020", "element2WebPath": "sud-2020" }
];
const sortChoicesToValidateNotOk = [
    { "element1WebPath": "fabrice-2020", "element2WebPath": "ouest-2020" },
    { "element1WebPath": "aubin-2020", "element2WebPath": "est-2020" },
    { "element1WebPath": "marie-france-2020", "element2WebPath": "sud-2020" }
];
const sortChoicesNotValid = [
    { "element1WebPath": "fabrice-2020", "element2WebPath": "ouest-2020", "validationResult": "incorrect-affectation" },
    { "element1WebPath": "aubin-2020", "element2WebPath": "est-2020", "validationResult": "incorrect-affectation" },
    { "element1WebPath": "marie-france-2020", "element2WebPath": "sud-2020", "validationResult": "incorrect-affectation" }
];
const sortChoicesToValidateOk = [
    { "element1WebPath": "fabrice-2020", "element2WebPath": "nord-2020" },
    { "element1WebPath": "aubin-2020", "element2WebPath": "sud-2020" },
    { "element1WebPath": "marie-france-2020", "element2WebPath": "nord-2020" }
];
const sortChoicesValid = [
    { "element1WebPath": "fabrice-2020", "element2WebPath": "nord-2020", "validationResult": "correct-affectation" },
    { "element1WebPath": "aubin-2020", "element2WebPath": "sud-2020", "validationResult": "correct-affectation" },
    { "element1WebPath": "marie-france-2020", "element2WebPath": "nord-2020", "validationResult": "correct-affectation" }
];
const sortChoices2 = [
    { "element1WebPath": "fabrice-2020", "element2WebPath": "ouest-2020" },
    { "element1WebPath": "aubin-2020", "element2WebPath": "est-2020" },
    { "element1WebPath": "marie-france-2020", "element2WebPath": "est-2020" }
];
const sortChoices3 = [
    { "element1WebPath": "fabrice-2020", "element2WebPath": "ouest-2020" },
    { "element1WebPath": "aubin-2020", "element2WebPath": "est-2020" }
];


const bambooWebPath = "bamboo-2020";
const prisonnierWebPath = "prisonnier-2020";
const radeauWebPath = "radeaux-2020";

module('Unit | Utility | quizz-util', function () {

    test('affect user to team twice', function (assert) {
        let element1WebPath = "marie-france-2020";
        let element2WebPath = "sud-2020";

        let result = affect(sortChoices, element1WebPath, element2WebPath);
        assert.ok(result);
        assert.deepEqual(result, sortChoices, "The 2 sets should be identical");
    });

    test('affect user to another team', function (assert) {
        let element1WebPath = "marie-france-2020";
        let element2WebPath = "est-2020";

        let result = affect(sortChoices, element1WebPath, element2WebPath);
        assert.ok(result);
        assert.deepEqual(result, sortChoices2, "new affectation");
    });

    test('unaffect user to team', function (assert) {
        let element1WebPath = "marie-france-2020";
        let element2WebPath = "sud-2020";

        let result = unaffect(sortChoices, element1WebPath, element2WebPath);
        assert.ok(result);
        assert.deepEqual(result, sortChoices3, "remove  affectation");
    });

    test('validate result ok', function (assert) {
        let result = getChoicesResultsForAffectation(optionPoursuite2020Option, sortChoicesToValidateOk);
        assert.ok(result);
        assert.deepEqual(result, sortChoicesValid, "correct affectation");
        assert.true(isResultSetCorrectForCheckedOptions(result));
    });

    test('validate result not ok', function (assert) {
        let result = getChoicesResultsForAffectation(optionPoursuite2020Option, sortChoicesToValidateNotOk);
        assert.ok(result);
        assert.deepEqual(result, sortChoicesNotValid, "correct affectation");
        assert.false(isResultSetCorrectForCheckedOptions(result));
    });


});
