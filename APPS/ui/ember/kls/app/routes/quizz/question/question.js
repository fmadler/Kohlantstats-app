import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';
import { tracked } from '@glimmer/tracking';
import { fetchData } from '../../../utils/common-utils';
import { hash } from 'rsvp';
import { getEntries } from '../../../utils/quizz-utils'

export default class QuizzQuestionQuestionRoute extends Route {
    @service('quizz') quizz;
    @service('Score') scoreService;

    queryParams = {
        'shuffle': {
            refreshModel: true,
            replace: true
        },
        filter1WebPath: {
            refreshModel: true,
            replace: true
        },
        filter2WebPath: {
            refreshModel: true,
            replace: true
        },
        filter3WebPath: {
            refreshModel: true,
            replace: true
        },
    };

    async model(params) {
        const input = params
        const filter2 = params.filter2WebPath;
        let questionDetails = await this.quizz.questionDetail(
            params
        ).then(d => {
            return d.QuestionDetailOut;
        });

        //improve for perf
        let distinctPrograms = await this.scoreService
          .distinctPrograms()
          .then(d=>{
            return d.DistinctProgramsOut;
          })

        const questionDetailFirst = questionDetails[0];
        if (filter2) {
            if (filter2 !== "null") {
                let options = fetchData(
                    getOptionUrl(questionDetailFirst, input)
                )
                .then(d => {
                    let options = getEntries(questionDetailFirst.questionAnswerOptionsSubUrl, d)
                    options.distinctPrograms = distinctPrograms;
                    let result = {
                        input: input,
                        questionDetail: questionDetailFirst,
                        questionDetails: questionDetails,
                        options: options
                    };
                    return result;
                })
                let filters = fetchData(
                    getMatrixUrl(questionDetailFirst, input)
                )
                .then(d => {
                    let filters = getEntries(questionDetailFirst.questionFilterMatrixSubUrl, d)
                    let result = {
                        filters: filters
                    };
                    return result;
                })
                let promises = {
                    options: options,
                    filters: filters
                }
                //return promises;
                return hash(promises);
            } else {
                return {
                    options: {
                        input: input,
                        distinctPrograms : distinctPrograms,
                        questionDetail: questionDetailFirst,
                        questionDetails: questionDetails
                    }
                };
            }

        }
    }

}

//TODO refactor

function getOptionUrl(questionDetailFirst, input) {
    return getUrl(questionDetailFirst.tenantApiRootUrl,
        questionDetailFirst.questionAnswerOptionsSubUrl,
        input);
}

function getMatrixUrl(questionDetailFirst, input) {
    return getUrl(questionDetailFirst.tenantApiRootUrl,
        questionDetailFirst.questionFilterMatrixSubUrl,
        input);
}


function getUrl(rootUrl, subUrl, input) {
    const filter2WebPath = input.filter2WebPath;
    let res = rootUrl + subUrl;
    let connection = hasNestedParam(subUrl) ? '&' : '?';
    if (filter2WebPath && filter2WebPath != "null") {
        return res + connection + "gameWebPath=" + filter2WebPath;
    }
    return res;
}

function hasNestedParam(questionAnswerOptionsSubUrl) {
    return questionAnswerOptionsSubUrl.includes("?")
}
