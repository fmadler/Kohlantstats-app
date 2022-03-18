import klsDataUtil from 'kohlantstats/utils/kls-data-util';
import { getCurrentGame,
  getNextGame,
  getPreviousGame,
  getPlayerSearchTitle,
  getNext,
  getPrevious,
  getNextWithOrder,
  getPreviousWithOrder
} from 'kohlantstats/utils/kls-data-util';
import { DEFAULT_TITLE_PARTICIPANT_PERFORMANCES,
          getTitleProgramPerf,
          getTitleProgramPlayerPerf,
          getTitleProgramPlayerComparison,
          getPageTitle
         } from 'kohlantstats/utils/kls-data-util';

import { module, test } from 'qunit';

const inputDistinctEditions = {"DistinctProgramsOut":[{"editionNumber":23,"year":2022,"name":"Le Totem maudit","webPath":"le-totem-maudit","totalTimeLength":39,"country":"Philippines","countryFlag":"Philippines.png","countryWebPath":"philippines","place":"Philippines","placeWebPath":"philippines","nbOfParticipants":24,"winnerName":null,"winnerWebPath":null},{"editionNumber":22,"year":2021,"name":"La légende","webPath":"la-legende-2021","totalTimeLength":36,"country":"France","countryFlag":"France.png","countryWebPath":"france","place":"Polynésie française","placeWebPath":"polynesie-française","nbOfParticipants":21,"winnerName":null,"winnerWebPath":null},{"editionNumber":21,"year":2021,"name":"Les armes secrètes","webPath":"les-armes-secretes","totalTimeLength":35,"country":"France","countryFlag":"France.png","countryWebPath":"france","place":"Polynésie française","placeWebPath":"polynesie-française","nbOfParticipants":21,"winnerName":"Maxine","winnerWebPath":"maxine-2021"},{"editionNumber":20,"year":2020,"name":"Les quatre terres","webPath":"les-quatre-terres","totalTimeLength":40,"country":"Fidji","countryFlag":"Fidji.png","countryWebPath":"fidji","place":null,"placeWebPath":null,"nbOfParticipants":24,"winnerName":"Alexandra","winnerWebPath":"alexandra-2020"}]};
const inputDistinctGames = { "DistinctGamesOut": [{ "name": "Poursuite par équipe", "webPath": "poursuite-par-equipe-2020", "timePosition": "1", "timeUnitIndex": 1, "programIndex": 1, "gameTypeName": "Poursuite chargée", "gameTypeWebPath": "poursuite-chargee", "gameStakeTypeName": "Confort", "gameStakeTypeWebPath": "confort", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Parcours relai avec obstacles", "webPath": "parcours-relais-avec-obstacles-2020", "timePosition": "2", "timeUnitIndex": 1, "programIndex": 2, "gameTypeName": "Parcours en relai", "gameTypeWebPath": "parcours-en-relai", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Pierres apnée", "webPath": "pierre-apnee-2020", "timePosition": "4", "timeUnitIndex": 4, "programIndex": 3, "gameTypeName": "Relai aquatique avec charge", "gameTypeWebPath": "relai-aquatique-avec-charge", "gameStakeTypeName": "Confort", "gameStakeTypeWebPath": "confort", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Rangement boules", "webPath": "rangement-boules-2020", "timePosition": "5", "timeUnitIndex": 5, "programIndex": 4, "gameTypeName": "Classement des boules", "gameTypeWebPath": "classement-des-boules", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Manipulation boules", "webPath": "manipulation-boules-2020", "timePosition": "7", "timeUnitIndex": 7, "programIndex": 5, "gameTypeName": "Parcours de billes", "gameTypeWebPath": "parcours-de-billes", "gameStakeTypeName": "Confort", "gameStakeTypeWebPath": "confort", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Radeaux puzzle", "webPath": "radeaux-2020", "timePosition": "8", "timeUnitIndex": 8, "programIndex": 6, "gameTypeName": "Radeaux", "gameTypeWebPath": "radeaux", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Bamboo", "webPath": "bamboo-2020", "timePosition": "10", "timeUnitIndex": 10, "programIndex": 7, "gameTypeName": "Bamboo", "gameTypeWebPath": "bamboo", "gameStakeTypeName": "Confort", "gameStakeTypeWebPath": "confort", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Prisonnier", "webPath": "prisonnier-2020", "timePosition": "12", "timeUnitIndex": 12, "programIndex": 8, "gameTypeName": "Prisonier", "gameTypeWebPath": "prisonier", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Koala en dorsale", "webPath": "koala-2020", "timePosition": "14", "timeUnitIndex": 14, "programIndex": 9, "gameTypeName": "Koala", "gameTypeWebPath": "koala", "gameStakeTypeName": "Capitaine", "gameStakeTypeWebPath": "capitaine", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Flambeaux", "webPath": "flambeaux-2020", "timePosition": "15", "timeUnitIndex": 15, "programIndex": 10, "gameTypeName": "Flambeaux", "gameTypeWebPath": "flambeaux", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Douche", "webPath": "douche-2020", "timePosition": "17", "timeUnitIndex": 17, "programIndex": 11, "gameTypeName": "Douche", "gameTypeWebPath": "douche", "gameStakeTypeName": "Confort", "gameStakeTypeWebPath": "confort", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Boue", "webPath": "boue-2020", "timePosition": "18", "timeUnitIndex": 18, "programIndex": 12, "gameTypeName": "Boue", "gameTypeWebPath": "boue", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Guide-aveugle", "webPath": "guide-aveugle-2020", "timePosition": "18", "timeUnitIndex": 18, "programIndex": 13, "gameTypeName": "Guide-aveugle", "gameTypeWebPath": "guide-aveugle", "gameStakeTypeName": "Confort", "gameStakeTypeWebPath": "confort", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Massacre poteries suspendues", "webPath": "saut-poterie-2020", "timePosition": "19", "timeUnitIndex": 19, "programIndex": 14, "gameTypeName": "Poteries suspendues", "gameTypeWebPath": "poteries-suspendues", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Malle nouée", "webPath": "malle-nouee-2020", "timePosition": "20", "timeUnitIndex": 20, "programIndex": 15, "gameTypeName": "Malle-nouée", "gameTypeWebPath": "malle-nouee", "gameStakeTypeName": "Confort", "gameStakeTypeWebPath": "confort", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Equilibre poteries", "webPath": "equilibre-poteries-2020", "timePosition": "21", "timeUnitIndex": 21, "programIndex": 16, "gameTypeName": "Equilibre poteries", "gameTypeWebPath": "equilibre-poteries", "gameStakeTypeName": "Confort", "gameStakeTypeWebPath": "confort", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Parcours du combattant", "webPath": "parcours-du-combattant-2020", "timePosition": "23", "timeUnitIndex": 23, "programIndex": 17, "gameTypeName": "Parcours du combattant", "gameTypeWebPath": "parcours-du-combattant", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Grapin", "webPath": "grapin-2020", "timePosition": "21", "timeUnitIndex": 21, "programIndex": 18, "gameTypeName": "Grapin", "gameTypeWebPath": "grapin", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Parcours en cinq étapes", "webPath": "parcours-en-cinq-etapes-2020", "timePosition": "28", "timeUnitIndex": 28, "programIndex": 19, "gameTypeName": "Parcours en cinq étapes", "gameTypeWebPath": "parcours-en-cinq-etapes", "gameStakeTypeName": "Confort", "gameStakeTypeWebPath": "confort", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Figure de proue", "webPath": "figure-de-proue-2020", "timePosition": "29", "timeUnitIndex": 29, "programIndex": 20, "gameTypeName": "Figure de proue", "gameTypeWebPath": "figure-de-proue", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Elévation d'une tour", "webPath": "elevation-tour-2020", "timePosition": "30", "timeUnitIndex": 30, "programIndex": 21, "gameTypeName": "Elévation d'une tour", "gameTypeWebPath": "elevation-tour", "gameStakeTypeName": "Confort", "gameStakeTypeWebPath": "confort", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Pallets", "webPath": "pallets-2020", "timePosition": "31", "timeUnitIndex": 31, "programIndex": 22, "gameTypeName": "Pallets", "gameTypeWebPath": "pallets", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Croisillons", "webPath": "croisillons-2020", "timePosition": "33", "timeUnitIndex": 33, "programIndex": 23, "gameTypeName": "Croisillons", "gameTypeWebPath": "croisillons", "gameStakeTypeName": "Confort", "gameStakeTypeWebPath": "confort", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }, { "name": "Empillement de boules", "webPath": "empillement-de-boules-2020", "timePosition": "35", "timeUnitIndex": 35, "programIndex": 24, "gameTypeName": "Empillement de boules", "gameTypeWebPath": "empillement-de-boules", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }] };
const bambooGame = { "name": "Bamboo", "webPath": "bamboo-2020", "timePosition": "10", "timeUnitIndex": 10, "programIndex": 7, "gameTypeName": "Bamboo", "gameTypeWebPath": "bamboo", "gameStakeTypeName": "Confort", "gameStakeTypeWebPath": "confort", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }
const prisonnierGame = { "name": "Prisonnier", "webPath": "prisonnier-2020", "timePosition": "12", "timeUnitIndex": 12, "programIndex": 8, "gameTypeName": "Prisonier", "gameTypeWebPath": "prisonier", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }
const radeauGame = { "name": "Radeaux puzzle", "webPath": "radeaux-2020", "timePosition": "8", "timeUnitIndex": 8, "programIndex": 6, "gameTypeName": "Radeaux", "gameTypeWebPath": "radeaux", "gameStakeTypeName": "Immunité", "gameStakeTypeWebPath": "immunité", "programName": "Les quatre terres", "programWebPath": "les-quatre-terres" }

const bambooWebPath = "bamboo-2020";
const prisonnierWebPath = "prisonnier-2020";
const radeauWebPath = "radeaux-2020";
const les4terres = "les-quatre-terres";
const lesArmesSecretes = "les-armes-secretes";
const laLegende = "la-legende-2021";

module('Unit | Utility | kls-data-util', function () {

  test('next edition', function (assert) {
    let resultNext = getNextWithOrder(inputDistinctEditions.DistinctProgramsOut, "editionNumber", lesArmesSecretes);
    assert.ok(resultNext);
    assert.equal(resultNext.webPath, laLegende)
  });

  test('previous edition', function (assert) {
    let result = getPreviousWithOrder(inputDistinctEditions.DistinctProgramsOut, "editionNumber", lesArmesSecretes);
    assert.ok(result);
    assert.equal(result.webPath, les4terres)
  });

  test('current game', function (assert) {
    let result = getCurrentGame(inputDistinctGames.DistinctGamesOut, bambooWebPath);
    assert.ok(result);
    assert.equal(result.webPath, bambooWebPath)
    assert.deepEqual(result, bambooGame, "Two BambooGame objects can be the same in value");
  });

  test('next game', function (assert) {
    let result = getNextGame(inputDistinctGames.DistinctGamesOut, bambooWebPath);
    assert.ok(result);
    assert.equal(result.webPath, prisonnierWebPath)
    assert.deepEqual(result, prisonnierGame, "Two Prisionnier objects can be the same in value");
  });

  test('next game when last game', function (assert) {
    let result = getNextGame(inputDistinctGames.DistinctGamesOut, 'empillement-de-boules-2020');
    assert.strictEqual(typeof (result), "undefined")
  });

  test('previous game', function (assert) {
    let result = getPreviousGame(inputDistinctGames.DistinctGamesOut, bambooWebPath);
    assert.ok(result);
    assert.equal(result.webPath, radeauWebPath)
    assert.deepEqual(result, radeauGame, "Two RadeauGame objects can be the same in value");
  });

  test('next game when first game', function (assert) {
    let result = getPreviousGame(inputDistinctGames.DistinctGamesOut, 'poursuite-par-equipe-2020');
    assert.strictEqual(typeof (result), "undefined")
  });

  test('player search title with no params', function (assert) {
    let result = getPlayerSearchTitle(null, null, null);
    assert.strictEqual(result, DEFAULT_TITLE_PARTICIPANT_PERFORMANCES)
  });

  test('player search title with edition param only', function (assert) {
    let programName = "Les quatre terres";
    let result = getPlayerSearchTitle(programName, null, null);
    assert.strictEqual(result, getTitleProgramPerf(programName))
  });

  test('player search title with edition and player param', function (assert) {
    let programName = "Les quatre terres";
    let playerName = "Loïc";
    let result = getPlayerSearchTitle(programName, playerName, null);
    assert.strictEqual(result, getTitleProgramPlayerPerf(programName, playerName))
  });

  test('player search title with edition and two players param', function (assert) {
    let programName = "Les quatre terres";
    let playerName = "Loïc";
    let player2Name = "Alexandra";
    let result = getPlayerSearchTitle(programName, playerName, player2Name);
    assert.strictEqual(result, getTitleProgramPlayerComparison(programName, playerName, player2Name))
  });

  test('Page title simple', function (assert) {
    let pageTitle = "Les quatre terres";
    let result = getPageTitle(pageTitle);
    assert.strictEqual(result, pageTitle)
  });

  test('Page title with entity only', function (assert) {
    let entity = "Editions";
    let result = getPageTitle(null, entity);
    assert.strictEqual(result, entity)
  });

  test('Page title with entity and entity title', function (assert) {
    let entity = "Edition";
    let entityTitle = "Les quatre terres";
    let result = getPageTitle(null, entity, entityTitle);
    assert.strictEqual(result, "Edition - Les quatre terres")
  });
});
