import { helper } from '@ember/component/helper';
import { getPlayerSearchTitle } from 'kohlantstats/utils/kls-data-util';

export default helper(function playerSearchPageTitle(params/*, hash*/) {
  let [model] = params;
  let selectedPlayerWebPath = model.params.playerWebPath;
  let selectedComparisonPlayerWebPath = model.params.comparisonPlayerWebPath;
  let programWebPath = model.params.programWebPath;

  if (programWebPath) {
    var programName = model.programInfo[0].name
  }
  if (selectedPlayerWebPath) {
    var playerName = model.participantSummary[0].name
  }
  if (selectedComparisonPlayerWebPath) {
    var player2Name = model.participantSummaryPlayer2[0].name
  }
  return getPlayerSearchTitle(programName, playerName, player2Name);
});
