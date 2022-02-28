import { helper } from '@ember/component/helper';
import _ from "lodash";
import { getIndivualWinnerStatsPerPrograms } from 'kohlantstats/utils/kls-data-util';

export default helper(function hasIndividualVictory(params/*, hash*/) {
  let [stats, programWebPath] = params;
  let prgStats = _.filter(stats, {programWebPath:programWebPath})[0];
  if (prgStats) {
    return getIndivualWinnerStatsPerPrograms(prgStats, "1", "Individuel").length>0;
  }
  return false;
});
