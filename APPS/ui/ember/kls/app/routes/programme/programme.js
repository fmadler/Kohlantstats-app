import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';
import { task } from 'ember-concurrency';
import { action } from '@ember/object';
import {getCurrent, getNextWithOrder, getPreviousWithOrder} from 'kohlantstats/utils/kls-data-util';
import {fillCustomEntityValue} from 'kohlantstats/utils/entityvalue-utils';

import config from 'kohlantstats/config/environment';
const { host, namespace } = config.imageDS;
const imageBaseUrl = host+"/"+namespace;

export default class ProgrammeProgrammeRoute extends Route {

  @service('Score') scoreService;
  @service('Entityvaluestore') entityvaluestoreService;
  //@service inViewport

  model(params) {
    return {
      params: params,
      taskInstance: this.programInfoTask.perform(params),
      taskEntityValueInstance: this.entityValueTask.perform(params),
    };

  }

  @task
  * entityValueTask(params) {
    let searchParams = {
      entityFullWebPath : 'programme/'+params.programWebPath,
      tenantWebPath: 'kls',
    };
    return yield this.entityvaluestoreService.entityValue2(
      searchParams
    ).then(d => {
      return fillCustomEntityValue(d,{language:"FR",binaryType:"poster"}, imageBaseUrl);
    });
  }

  @task
  * programInfoTask(params) {
    let searchParams = {
      programWebPath : params.programWebPath,
      entityType : "program",
      entityWebPath : params.programWebPath,
      rankingLessThanEqualTo : 3
    };
    this.searchParams = searchParams;
    return yield  this.scoreService.programDetail2(
      searchParams
    ).then(d => {
      let programWebPath= d.params.programWebPath;
      let distinctPrograms = d.distinctPrograms;
      d.custom = {
        'currentProgram' : getCurrent(distinctPrograms, programWebPath),
        'nextProgram' : getNextWithOrder(distinctPrograms, "editionNumber", programWebPath),
        'previousProgram' : getPreviousWithOrder(distinctPrograms, "editionNumber", programWebPath)
      }
      return d;
    });
  }

  @action
  setupInViewport() {
    const loader = document.getElementById('loader');
    const viewportTolerance = { bottom: 200 };
    const { onEnter, _onExit } = this.inViewport.watchElement(loader, { viewportTolerance });
    // pass the bound method to `onEnter` or `onExit`
    onEnter(this.didEnterViewport.bind(this));
  }

  didEnterViewport() {
    // do some other stuff
    this.infinityLoad();
  }

  willDestroy() {
    // need to manage cache yourself if you don't use the mixin
    const loader = document.getElementById('loader');
    this.inViewport.stopWatching(loader);

    super.willDestroy(...arguments);
  }

}
