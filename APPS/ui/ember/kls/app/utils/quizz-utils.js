const INCORRECT_CHECKED = 'incorrect-checked';
const INCORRECT_UNCHECKED = 'incorrect-unchecked';
const CORRECT_CHECKED = 'correct-checked';
const CORRECT_UNCHECKED = 'correct-unchecked';

const CORRECT_AFFECTATION = 'correct-affectation';
const INCORRECT_AFFECTATION = 'incorrect-affectation';

export function getEntries(subUrl, json) {
    let entries = [];
    let mtxsuburlArr = subUrl.split("/");
    if (mtxsuburlArr.length > 0) {
        let lastElement = mtxsuburlArr[mtxsuburlArr.length - 1]
        let inputObjectName = lastElement.indexOf('?') == -1 ? lastElement : lastElement.substr(0, lastElement.indexOf('?'));
        let outputObjectName = inputObjectName.substr(0, inputObjectName.length - 2) + "Out";//for MP generation
        return json[outputObjectName]
    }
    return entries;
}

// generic fillChoice
export function affect(choices, element1WebPath, element2WebPath) {
    //affect
    let element = { element1WebPath: element1WebPath, element2WebPath: element2WebPath };
    let filter = { element1WebPath: element1WebPath };
    let isRowPresent = _.filter(
        choices, filter
    ).length > 0;
    let ret = [...choices];
    if (isRowPresent) {
        ret = removeRow1Element(ret, filter);
    }
    ret = [...ret, element];

    return ret;
}

export function unaffect(choices, element1WebPath, element2WebPath) {
    //affect
    let element = { element1WebPath: element1WebPath, element2WebPath: element2WebPath };
    let isRowPresent = _.filter(
        choices, element
    ).length > 0;
    let ret = [...choices];
    if (isRowPresent) {
        ret = removeRow(ret, element);
    }
    return ret;
}

export function areChoicesReadyToBeValidated(choices) {
    return choices.length == 3;//TODO more generic options.length;
}

function removeRow(arr, filter) {
    let index = arr.findIndex(function (item) {
        return item.element1WebPath === filter.element1WebPath
            && item.element2WebPath === filter.element2WebPath

    });
    if (index > -1) {
        arr.splice(index, 1);
    }
    return arr;
}


function removeRow1Element(arr, filter) {
    let index = arr.findIndex(function (item) {
        return item.element1WebPath === filter.element1WebPath
    });
    if (index > -1) {
        arr.splice(index, 1);
    }
    return arr;
}

//TODO merge into one
function removeRow2(arr, filter) {
    let index = arr.findIndex(function (item) {
        return item.element1WebPath === filter.element1WebPath
            && (filter.element2WebPath) ? item.element2WebPath === filter.element2WebPath : true

    });
    if (index > -1) {
        arr.splice(index, 1);
    }
    return arr;
}

export function getChoicesResultsForAffectation(options, choices) {
    let choicesResults = [];
    choices.forEach(choice => {
        let isElementAnswerCorrect = _.filter(options,
            {
                participantWebPath: choice.element1WebPath,
                teamWebPath: choice.element2WebPath
            }).length == 1;
        let choiceResult = choice;
        if (isElementAnswerCorrect) {
            choiceResult.validationResult = CORRECT_AFFECTATION
        } else {
            choiceResult.validationResult = INCORRECT_AFFECTATION
        }
        choicesResults.push(choiceResult);
    }
    )
    return choicesResults;
}

export function isResultSetCorrectForCheckedOptions(choicesResults) {
    if (typeof choicesResults !== "undefined") {
        return _.findIndex(choicesResults,
            e => {
                return e.validationResult === INCORRECT_CHECKED
                    || e.validationResult === INCORRECT_UNCHECKED
                    || e.validationResult === INCORRECT_AFFECTATION
                    ;
            }) == -1;
    }
}

export function fillEvaluations(choicesResults, evaluations, questionParams) {
    let s = fillEvaluation(evaluations, questionParams, isResultSetCorrectForCheckedOptions(choicesResults)?"correct":"incorrect");
    return [...s];
}

export function fillCorrectAnswer(correctAnswers, questionParams) {
    correctAnswers.push(
        {
            questionParams: questionParams,
            //TODO add results 
        }
    );
}

export function fillEvaluation(evaluations, questionParams, status) {
    let s = [...evaluations];
    s.push(
        {
            questionParams: questionParams,
            assessment: status,
            insertionTime: new Date(),
        }
    );
    return s;
}


//TODO unit tests
export function computeScore(evaluations) {
    //evaluation computed
    if (evaluations.length > 0) {
        let nbOfEvaluations = evaluations.length;
        let nbOfEvaluationCorrectAnswers = _.filter(evaluations, { assessment: "correct" }).length;
        let nbOfEvaluationIncorrectAnswers = _.filter(evaluations, { assessment: "incorrect" }).length;

        //question computed
        let x = _.groupBy(evaluations, function (e) {
            return e.questionParams.questionWebPath + '|' + e.questionParams.filter1WebPath + '|' + e.questionParams.filter2WebPath;
        })

        _.reduce(evaluations, function (result, num, key) {
            let x = num.assessement == "correct" ? true : false;
            result[key] = x;
            return result;
        }, {});

        //spec : get distinct questions,check if one incorrect exist

        let questions = 0;//_.uniq(_.map(evaluations, 'usernames'))
        let nbOfQuestions = 0;
        let nbOfQuestionCorrectAnswers = 0;
        let nbOfQuestionIncorrectAnswers = 0;
        return {
            evaluation: {
                total: nbOfEvaluations,
                correct: {
                    total: nbOfEvaluationCorrectAnswers,
                    percent: percent(nbOfEvaluationCorrectAnswers, nbOfEvaluations)
                },
                incorrect: {
                    total: nbOfEvaluationIncorrectAnswers,
                    percent: percent(nbOfEvaluationIncorrectAnswers, nbOfEvaluations)
                }
            },
            question: {
                total: nbOfQuestions,
                correct: {
                    total: nbOfQuestionCorrectAnswers,
                    percent: percent(nbOfQuestionCorrectAnswers, nbOfQuestions)
                },
                incorrect: {
                    total: nbOfQuestionIncorrectAnswers,
                    percent: percent(nbOfQuestionIncorrectAnswers, nbOfQuestions)
                }
            },

        }
    }
    else {
        return {};
    }
}

function percent(n, total) {
    return (total != undefined && total != 0) ? Math.round(n / total * 100) : 0;
}