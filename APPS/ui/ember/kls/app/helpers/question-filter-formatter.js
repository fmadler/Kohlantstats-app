import { helper } from '@ember/component/helper';
import { htmlSafe } from '@ember/template';

export default helper(function questionFilterFormatter(params/*, hash*/) {
  let [question, filter1, filter2, filter3] = params;
  question = question.replace('$saison', `<b>${filter1}</b>`)
  question = question.replace('$jeu', `<b>${filter2}</b>`)
  return htmlSafe(question);
});
