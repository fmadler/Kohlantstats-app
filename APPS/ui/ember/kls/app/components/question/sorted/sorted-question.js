import QuestionOptionEvaluationPanelComponent from '../option-evaluation-panel';

import { tracked } from '@glimmer/tracking';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';
import appendQuery from 'append-query';
import { computed } from '@ember/object';
import _ from 'lodash'
import { task } from 'ember-concurrency';

const INCORRECT_CHECKED = 'incorrect-checked';
const INCORRECT_UNCHECKED = 'incorrect-unchecked';
const CORRECT_CHECKED = 'correct-checked';
const CORRECT_UNCHECKED = 'correct-unchecked';

export default class QuestionSortedSortedQuestionComponent extends QuestionOptionEvaluationPanelComponent {
    // @tracked participantWebPath;
    // @tracked teamWebPath;

    // @action
    // selectParticipant(item) {
    //     this.participantWebPath = item.participantWebPath;
    // }

    // @action
    // selectTeam(item) {
    //     if (this.participantWebPath == undefined) return;//pick participant first
    //     this.teamWebPath = item.teamWebPath;
    //     this.choices = affect(this.choices, this.participantWebPath, this.teamWebPath)
    //     this.areChoicesReadyToBeValidated = areChoicesReadyToBeValidated(this.choices);
    // }
    @tracked gameProperties = null;
    @tracked teamProperties = null;
    @service("score") score;

    @task getProperties = function* (set1, set2) {
        console.log('my task');
        
        yield this.score.getProperties({entityType:"game"})
        .then(d => {
            this.gameProperties = d.GetPropertiesOut;
        });
        yield this.score.getProperties({entityType:"team"})
        .then(d => {
            this.teamProperties = d.GetPropertiesOut;
        });
        //TODO task with array, task with initializer to put in session-storage
        //let childTasks = [];
        // childTasks.push(this.child.perform("game"));
        // childTasks.push(this.child.perform("team"));
        // let result = yield childTasks;
        // console.log("result = "+result)
    }

    @task({ enqueue: true, maxConcurrency: 3 })
    child = {
        percent: 0,
        id: null,

        *perform(entityTypeWebPath) {
            yield this.score.getProperties({entityTypeWebPath:entityTypeWebPath})
                .then(d => {
                    debugger
                });
        },
    };
}

// generic fillChoice
function affect(choices, element1WebPath, element2WebPath) {
    //affect
    let element = { element1WebPath: element1WebPath, element2WebPath: element2WebPath };
    let isRowPresent = _.filter(
        choices, element
    ).length > 0;
    let ret = [...choices];
    if (isRowPresent) {
        ret = removeRow(ret, element);
    } else {
        ret = [...ret, element];
    }
    return ret;
}

function areChoicesReadyToBeValidated(choices) {
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