import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';

export default class TeamTeamRoute extends Route {
  @service('Score') scoreService;

  model(params) {
    let searchParams =           {
      teamWebPath : params.teamWebPath,
      entityType : "team",
      entityWebPath : params.teamWebPath,
    };
    this.searchParams = searchParams;
    let ret =  this.get('scoreService').teamDetail2(
      searchParams
    );

    return ret;
  }
}
