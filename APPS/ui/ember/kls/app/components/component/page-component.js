import Component from '@glimmer/component';
import { getPageTitle } from 'kohlantstats/utils/kls-data-util';

export default class ComponentPageComponentComponent extends Component {

    entityTitle = this.args.entityTitle;
    entity = this.args.entity;
    pageTitle = this.args.pageTitle;

    get componentTitle() {
        return getPageTitle(this.pageTitle, this.entity, this.entityTitle)
    }

}
