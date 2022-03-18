import _ from "lodash"

export const DEFAULT_TITLE_PARTICIPANT_PERFORMANCES = "Découvrer les performances des participants";


//export const TITLE_PARTICIPANT_NAME_PERFORMANCES_EDITION = `Découvrer les performances de ${playerName} dans l'édition ${programName}`;

//export const TITLE_COMPARISON_PARTICIPANT_NAME_WITH_PARTICIPANT2_NAME_PERFORMANCES_EDITION = `Découvrer les performances de ${playerName} comparées à celles de ${player2Name} dans l'édition ${programName}`;

export default function klsDataUtil() {
  return true;
}

export function getCurrentGame(distinctGames, gameWebPath) {
  let index = _.findIndex(distinctGames, function (g) { return g.webPath === gameWebPath });
  return distinctGames[index];
}

export function getNextGame(distinctGames, gameWebPath) {
  let index = _.findIndex(distinctGames, function (g) { return g.webPath == gameWebPath });
  let count = distinctGames.length;
  let nextGameIndex = index + 1;
  if (nextGameIndex == count) return;
  return distinctGames[nextGameIndex];
}

export function getPreviousGame(distinctGames, gameWebPath) {
  let index = _.findIndex(distinctGames, function (g) { return g.webPath === gameWebPath });
  let previousGameIndex = index - 1;
  if (previousGameIndex < 0) return;
  return distinctGames[previousGameIndex];
}

export function getCurrent(distincts, webPath) {
  let index = _.findIndex(distincts, function (g) { return g.webPath === webPath });
  return distincts[index];
}

//deprecated
export function getNext(distincts, webPath) {
  let index = _.findIndex(distincts, function (g) { return g.webPath === webPath });
  let count = distincts.length;
  let nextIndex = index + 1;
  if (nextIndex == count) return;
  return distincts[nextIndex];
}

export function getNextWithOrder(distincts, order, webPath) {
  let sorted = _.orderBy(distincts, order, "asc");
  let index = _.findIndex(sorted, function (g) { return g.webPath === webPath });
  let count = distincts.length;
  let nextIndex = index + 1;
  if (nextIndex == count) return;
  return sorted[nextIndex];
}

export function getPreviousWithOrder(distincts, order, webPath) {
  let sorted = _.orderBy(distincts, order, "asc");
  let index = _.findIndex(sorted, function (g) { return g.webPath === webPath });
  let previousIndex = index - 1;
  if (previousIndex < 0) return;
  return sorted[previousIndex];
}
//deprecated
export function getPrevious(distincts, webPath) {
  let index = _.findIndex(distincts, function (g) { return g.webPath === webPath });
  let previousIndex = index - 1;
  if (previousIndex < 0) return;
  return distincts[previousIndex];
}

export function fillIndividualWinnerStats(data) {
  _.each(data, d => {
    d.individualWinner = getIndivualWinnerStatsPerPrograms(d, "1", "Individuel");
  })
}

export function getIndivualWinnerStatsPerPrograms(data, ranking, participationTypeName) {
  let details = data.participationDetails;
  return _.filter(details, { ranking: ranking, participationTypeName: participationTypeName });
}

export function getScore(gameStats) {
  return gameStats.ranking1AloneScore + gameStats.ranking2AloneScore + gameStats.longevity;
}

export function getPlayerSearchTitle(programName, playerName, player2Name) {
  if (programName) {
    if (playerName) {
      if (player2Name) {
        return getTitleProgramPlayerComparison(programName, playerName, player2Name);
      } else {
        return getTitleProgramPlayerPerf(programName, playerName)
      }
    } else {
      return getTitleProgramPerf(programName)
    }
  } else {
    return DEFAULT_TITLE_PARTICIPANT_PERFORMANCES;
  }
}

export function getTitleProgramPerf(programName) {
  return `Découvrer les performances des participants dans l'édition ${programName}`;
}

export function getTitleProgramPlayerPerf(programName, playerName) {
  return `Découvrer les performances de ${playerName} dans l'édition ${programName}`;
}

export function getTitleProgramPlayerComparison(programName, playerName, player2Name) {
  return `Découvrer les performances de ${playerName} comparées à celles de ${player2Name} dans l'édition ${programName}`;
}

export function getPageTitle(pageTitle, entity, entityTitle) {
  if (pageTitle) {
    return pageTitle;
  }
  if (entity) {
    if (entityTitle) {
      return entity + ' - ' + entityTitle;
    } else {
      return entity;
    }
  }
  return "";
}
