import Component from '@glimmer/component';
import { tracked } from '@glimmer/tracking';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';
import { fetchData } from '../../utils/common-utils';
import appendQuery from 'append-query';
import { computed } from '@ember/object';
import _ from 'lodash'
import { task } from 'ember-concurrency';
import { getEntries } from '../../utils/quizz-utils'

const INCORRECT_CHECKED = 'incorrect-checked';
const INCORRECT_UNCHECKED = 'incorrect-unchecked';
const CORRECT_CHECKED = 'correct-checked';
const CORRECT_UNCHECKED = 'correct-unchecked';
export default class QuestionOptionEvaluationPanelComponent extends Component {

    @tracked choices = [];
    @tracked areChoicesReadyToBeValidated = false;
    
    @action
    validate(options, data) {
        //inside subclass implementation
    }

    //@computed('areChoicesReadyToBeValidated')
    get isValidateDisable() {
        return !this.areChoicesReadyToBeValidated;
    }

}
