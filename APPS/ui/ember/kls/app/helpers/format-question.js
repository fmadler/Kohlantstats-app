import { helper } from '@ember/component/helper';
import { htmlSafe } from '@ember/template';
import _ from 'lodash';

export default helper(function formatQuestion(params/*, hash*/) {
  let [questionDetails] = params;
  if (questionDetails && 
    questionDetails.options && 
    questionDetails.options.questionDetail &&
    questionDetails.filters &&
    questionDetails.filters.filters
    ) {
    let questionDetailFirst = questionDetails.options.questionDetail;
    let question = questionDetailFirst.questionName;

    let gamefilter = questionDetails.options.input.filter2WebPath;
    let filter = _.filter(questionDetails.filters.filters,
      { gameWebPath: gamefilter });
    let firstFilter = filter[0];
    if (firstFilter) {
      question = question.replace('$jeu', `<b>${firstFilter.gameName}</b>`)
      question = question.replace('$saison', `<b>${firstFilter.programName}</b>`)
      return htmlSafe(question);
    }
  }
  return "";
});
