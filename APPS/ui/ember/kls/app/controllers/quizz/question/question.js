import Controller from '@ember/controller';

import { tracked } from '@glimmer/tracking';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';

export default class QuizzQuestionQuestionController extends Controller {
    queryParams = [
        'shuffle',
        'filter1WebPath',
        'filter2WebPath',
        'filter3WebPath'];

    shuffle = null;
    filter1WebPath = null;
    filter2WebPath = null;
    filter3WebPath = null;

}
