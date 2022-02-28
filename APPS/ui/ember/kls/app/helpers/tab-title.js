import { helper } from '@ember/component/helper';
import { htmlSafe } from '@ember/template';

export default helper(function tabTitle(params/*, hash*/) {
  let [title, quantity, cssclass] = params;
  if (cssclass==undefined) cssclass='kls-tab-title-quantity';
  if (quantity===undefined){
    return htmlSafe(`${title}`)
  }

  return htmlSafe(`${title} <span class="badge ${cssclass}">${quantity}</span>`)

});
