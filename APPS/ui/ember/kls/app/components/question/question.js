import Component from '@glimmer/component';
import { tracked } from '@glimmer/tracking';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';
import { fetchData } from '../../utils/common-utils';
import appendQuery from 'append-query';
import { computed } from '@ember/object';
import _ from 'lodash'
import { task } from 'ember-concurrency';
import { getEntries, 
    affect, 
    areChoicesReadyToBeValidated, 
    getChoicesResultsForAffectation,
    isResultSetCorrectForCheckedOptions ,
    fillEvaluations,
    fillEvaluation,
    computeScore,
    fillCorrectAnswer
} 
from '../../utils/quizz-utils'

const INCORRECT_CHECKED = 'incorrect-checked';
const INCORRECT_UNCHECKED = 'incorrect-unchecked';
const CORRECT_CHECKED = 'correct-checked';
const CORRECT_UNCHECKED = 'correct-unchecked';

export default class QuestionQuestionComponent extends Component {

    @service('quizz') quizz;
    @service router;

    //@tracked options;
    @tracked matrix;

    @tracked filters = this.args.data.options.input;
    @tracked filtersHist;

    @tracked selectedFilter;
    @tracked isUnderValidation = false;
    @tracked showValidateButton = true;
    @tracked showValidateOrderButton = true;
    @tracked showValidateSortButton = true;
    @tracked areAllOrderedOptionChosen = false;
    @tracked areAllSortChoicesReadyToBeValidated = false;

    @tracked choices = [];
    @tracked choicesResults = [];
    @tracked showResult = false;
    @tracked correctAnswers = [];

    @tracked evaluations = [];
    @tracked computedScore = {};

    //sort questions
    @tracked element1WebPath;
    @tracked element2WebPath;

    @task *fetchNextQuestion() {
        // this.set('status', "Gimme one second...");
        // yield timeout(1000);
        // this.set('status', "Gimme one more second...");
        // yield timeout(1000);
        // this.set('status', "OK, I'm done.");
    }

    @action
    transition(questionWebPath, item) {
        resetChoices(this);
        this.router.transitionTo('quizz.question.question',
            questionWebPath,
            {
                queryParams: {
                    filter1WebPath: item.programWebPath,
                    filter2WebPath: item.gameWebPath
                }
            })
    }

    //@computed('choicesResults')
    get areChoicesCorrect() {
        return isResultSetCorrectForCheckedOptions(this.choicesResults);
    }

    //@computed('evaluations')
    get showComputedScore() {
        return this.evaluations.length > 0;
    }

    //@computed('choices')
    get isValidateDisable() {
        if (typeof this.choices !== "undefined") {
            return this.choices && this.choices.length == 0;
        }
        return true;
    }

    //@computed('areAllOrderedOptionChosen')
    get isValidateOrderDisable() {
        return !this.areAllOrderedOptionChosen;
    }

    get isValidateSortDisable() {
        return !this.areAllSortChoicesReadyToBeValidated;
    }

    @action
    selectElement1(item, questionWebPath) {
        this.element1WebPath = item.participantWebPath;
    }

    @action
    selectElement2(item, questionWebPath) {
        if (this.element1WebPath == undefined) return;//pick participant first
        this.element2WebPath = item.teamWebPath;
        this.choices = affect(this.choices, this.element1WebPath, this.element2WebPath)
        this.areAllSortChoicesReadyToBeValidated = areChoicesReadyToBeValidated(this.choices);

    }

    @task
    *allPossibilites(item) {
        let rootUrl = item.tenantApiRootUrl;
        let subUrl = item.questionFilterMatrixSubUrl;
        yield fetchData(rootUrl + subUrl)
            .then(d => {
                this.matrix = getEntries(item.questionFilterMatrixSubUrl, d);
            });
    }

    @action
    toggle(item, questionWebPath) {
        if (!this.showValidateButton) {
            return;
        }
        if (!this.isUnderValidation) {
            let wp = ''; //todo change to more generic
            if (questionWebPath === 'quelle-tribu-a-gagne-le-jeu-de-la-saison') {
                wp = item.teamWebPath;
            } else if (questionWebPath === 'qui-a-gagne-le-jeu-de-la-saison') {
                wp = item.participantWebPath;
            }
            if (this.choices.includes(wp)) {
                this.choices = removeItemOnce(this.choices, wp);
            } else {
                this.choices = [...this.choices, wp];
            }
        }
        this.showResult = false;
    }

    @action
    order(item, questionWebPath, position, options) {
        if (!this.showValidateOrderButton) {
            return;
        }
        if (!this.isUnderValidation) {
            let wp = ''; //todo change to more generic
            if (questionWebPath === 'classement-des-meilleurs-participants') {
                wp = item.participantWebPath;
            } else if (questionWebPath === 'classement-des-meilleurs-tribus') {
                wp = item.teamWebPath;
            }
            //get next available number
            let isRowPresent = _.filter(this.choices, { webPath: wp }).length > 0;

            if (isRowPresent) {
                let isCellPresent = _.filter(this.choices, { webPath: wp, position: position }).length > 0;
                this.choices = removeItemScoreOnce(this.choices, wp);
                if (!isCellPresent) {
                    this.choices = [...this.choices, { webPath: wp, position: position }];
                }
            } else {
                this.choices = [...this.choices, { webPath: wp, position: position }];
            }
            this.areAllOrderedOptionChosen = this.choices.length == options.length;
        }
        this.showResult = false;
    }

    @action
    validateSort(options, data) {
        let choicesResults = getChoicesResultsForAffectation(options, this.choices);
        this.choicesResults = [...choicesResults];
        this.showResult = true;
        this.evaluations = fillEvaluations(this.choicesResults, this.evaluations, data.options.input);
        this.computedScore = computeScore(this.evaluations);
        if (isResultSetCorrectForCheckedOptions(this.choicesResults)) {
            this.showValidateSortButton = false;
            fillCorrectAnswer(this.correctAnswers, data.options.input)
        }

    }

    @action
    validateOrder(options, data) {
        // refactor to use options only
        let questionWebPath = data.options.input.questionWebPath;
        this.isUnderValidation = true;
        let choices = this.choices;
        let choicesResults = [];
        options.forEach(element => {
            //done when choices array will be really tracked !...
            let tocheck = ''
            if (questionWebPath === 'classement-des-meilleurs-tribus') {
                tocheck = element.teamWebPath;
            } else if (questionWebPath === 'classement-des-meilleurs-participants') {
                tocheck = element.participantWebPath;
            }
            //extract method
            let isElementAnswerCorrect = _.filter(choices, { webPath: tocheck, position: element.ranking }).length == 1;
            if (isElementAnswerCorrect) {
                element.ticked = true;
                element.validationResult = CORRECT_CHECKED
            } else {
                element.validationResult = INCORRECT_CHECKED
            }
            let choiceResult = {}
            if (questionWebPath === 'classement-des-meilleurs-tribus') {
                choiceResult = {
                    participantName: element.teamName,
                    participantWebPath: element.teamWebPath,
                    validationResult: element.validationResult
                }
            } else if (questionWebPath === 'classement-des-meilleurs-participants') {
                choiceResult = {
                    participantName: element.participantName,
                    participantWebPath: element.participantWebPath,
                    validationResult: element.validationResult
                }
            }
            choicesResults.push(choiceResult);
        });

        this.choicesResults = [...choicesResults];

        this.isUnderValidation = false;
        this.showResult = true;

        // refactor to use options only -- END

        //Clean duplicate code
        //store the processed question
        if (isResultSetCorrectForCheckedOptions(this.choicesResults)) {
            this.showValidateOrderButton = false;
            this.correctAnswers.push(
                {
                    questionParams: data.options.input,
                    //TODO add results 
                }
            );
            let s = fillEvaluation(this.evaluations, data.options.input, "correct");
            this.evaluations = [...s];

        } else {
            let s = fillEvaluation(this.evaluations, data.options.input, "incorrect");
            this.evaluations = [...s];
        }
        this.computedScore = computeScore(this.evaluations);

        //TODO init ember concurrency task to fetch matrix if not present
        //For next question
        //if 
    }

    @action
    validate(options, data) {
        // refactor to use options only
        let questionWebPath = data.options.input.questionWebPath;
        this.isUnderValidation = true;
        let choices = this.choices;
        let choicesResults = [];

        //complement the matrix with the check values;
        options.forEach(element => {
            //done when choices array will be really tracked !...
            let tocheck = ''
            if (questionWebPath === 'quelle-tribu-a-gagne-le-jeu-de-la-saison') {
                tocheck = element.teamWebPath;
            } else if (questionWebPath === 'qui-a-gagne-le-jeu-de-la-saison') {
                tocheck = element.participantWebPath;
            }
            //extract method
            if (choices.includes(tocheck)) {
                element.ticked = true;
                if (element.score == 1) {
                    element.validationResult = CORRECT_CHECKED
                } else {
                    element.validationResult = INCORRECT_CHECKED
                }

            } else {
                if (element.score == 1) {
                    element.validationResult = INCORRECT_UNCHECKED
                } else {
                    element.validationResult = CORRECT_UNCHECKED
                }
            }
            let choiceResult = {}
            if (questionWebPath === 'quelle-tribu-a-gagne-le-jeu-de-la-saison') {
                choiceResult = {
                    participantName: element.teamName,
                    participantWebPath: element.teamWebPath,
                    validationResult: element.validationResult
                }
            } else if (questionWebPath === 'qui-a-gagne-le-jeu-de-la-saison') {
                choiceResult = {
                    participantName: element.participantName,
                    participantWebPath: element.participantWebPath,
                    validationResult: element.validationResult
                }
            }
            choicesResults.push(
                choiceResult);
        });

        this.choicesResults = [...choicesResults];

        this.isUnderValidation = false;
        this.showResult = true;

        // refactor to use options only -- END

        //Clean duplicate code
        //store the processed question
        if (isResultSetCorrectForCheckedOptions(this.choicesResults)) {
            this.showValidateButton = false;
            this.correctAnswers.push(
                {
                    questionParams: data.options.input,
                    //TODO add results 
                }
            );
            let s = fillEvaluation(this.evaluations, data.options.input, "correct");
            this.evaluations = [...s];

        } else {
            let s = fillEvaluation(this.evaluations, data.options.input, "incorrect");
            this.evaluations = [...s];
        }
        this.computedScore = computeScore(this.evaluations);

        //TODO init ember concurrency task to fetch matrix if not present
        //For next question
        //if 
    }

    @action
    nextQuestion(questionWebPath) {
        //lookup in the matrix for a question not part of the correctAnswersArray 
        //or to start the next question
        //=> search for same question w/ params take next or first if finished
        let lastCorrectAnswer = this.correctAnswers.slice(-1).pop();
        if (lastCorrectAnswer != undefined) {
            let index = _.findIndex(this.matrix, {
                programWebPath: lastCorrectAnswer.questionParams.filter1WebPath,
                gameWebPath: lastCorrectAnswer.questionParams.filter2WebPath
            })
            //get next in matrix
            let item = (index == this.matrix.length - 1) ? this.matrix[0] : this.matrix[index + 1];
            //
            resetChoices(this);
            this.router.transitionTo('quizz.question.question',
                questionWebPath,
                {
                    queryParams: {
                        filter1WebPath: item.programWebPath,
                        filter2WebPath: item.gameWebPath
                    }
                })
        }
    }

    @action
    addfilterGeneric(item) {
        let rootUrl = item.tenantApiRootUrl;
        let subUrl = item.questionParamDistinctOptionSubUrl;
        fetchData(rootUrl + subUrl)
            .then(d => {
                let o = { name: item.questionParamName, result: d }
                //todo remove filter
                this.filters = [...this.filters, o];
                this.selectedFilter = o;
            });
    }

    @action
    shuffleQuestion(item) {
        let rootUrl = item.QuestionDetailOut[0].tenantApiRootUrl;
        let subUrl = item.QuestionDetailOut[0].answerOptionsSubUrl;
        let params = {};
        params.programWebPath = 'les-quatre-terres';
        params.gameWebPath = 'poteaux-2020';
        fetchData(rootUrl + subUrl + filterQuizzParticipationOption(params))
            .then(d => {
                this.options = d.QuizzParticipationOptionOut;
            });
    }

}

function resetChoices(that) {
    that.choicesResults = [];
    that.choices = [];
    that.showResult = false;
    that.showValidateButton = true;
    that.showValidateOrderButton = true;
    that.showValidateSortButton = true;
    that.areAllOrderedOptionChosen = false;
}

function filterQuizzParticipationOption(filter) {
    if (filter) {
        return appendQuery("", {
            "programWebPath": filter.programWebPath,
            "gameWebPath": filter.gameWebPath,
            "participationTypeWebPath": filter.participationTypeWebPath,
            "participantWebPaths": filter.participantWebPaths,
            "ranking": filter.ranking,
        },
            { removeNull: true }
        );
    }
    return "";
}

function removeItemOnce(arr, value) {
    let index = arr.indexOf(value);
    if (index > -1) {
        arr.splice(index, 1);
    }
    return arr;
}

function removeItemScoreOnce(arr, value) {
    let index = arr.findIndex(function (item, i) {
        return item.webPath === value
    });
    if (index > -1) {
        arr.splice(index, 1);
    }
    return arr;
}




// function isResultSetCorrectForOrderddOptions(choicesResults) {

//     if (typeof choicesResults !== "undefined") {
//         return _.findIndex(choicesResults,
//             e => {
//                 return e.validationResult === INCORRECT_CHECKED
//                     || e.validationResult === INCORRECT_UNCHECKED;
//             }) == -1;
//     }
// }



//TODO unit test
function getNextAvailableNumber(choices) {
    choices.forEach((x, i) => {
        if (x.position != i + 1) {
            return i + 1
        }
    })
    return 1;
}