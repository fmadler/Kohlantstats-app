//TODO unit test
import _ from "lodash";

export function getTimelineAbscissa(scoreTimeline) {
  return _.map(_.uniqBy(scoreTimeline, "day"), "day");
}

//TODO unit test
const borderColor = [
  'rgba(255, 99, 132, 1)',
  'rgba(54, 162, 235, 1)',
  'rgba(255, 206, 86, 1)',
  'rgba(75, 192, 192, 1)',
  'rgba(153, 102, 255, 1)',
  'rgba(255, 159, 64, 1)'
];
const borderColorLength = borderColor.length;
export function getChartJsDatasets(scoreTimeline) {
  let data = getDatasetsData(scoreTimeline);
  let datasets = [];
  let i = 0;
  for (let propName in data) {
    debugger
    if (typeof (data[propName]) != "undefined") {
      let values = data[propName];
      let label = propName;
      let dataset = {
        label: getLabel(scoreTimeline, propName),
        data: values,
        backgroundColor: "white",
        borderColor: getBackgroundColor(i),
        borderWidth: 1,
        //colours:[ { fillColor: '#ffff00' }, { fillColor: '#0066ff' } ]
      }
      datasets.push(dataset);
      i++;
    }
  }
  return datasets;
}

export function getLabel(scoreTimeline, fullWebPath) {
  return _.find(scoreTimeline, e => e.fullWebPath === fullWebPath).displayName;
}
export function getBackgroundColor(position) {
  let index = position % borderColorLength;
  return borderColor[index];
}

export function getDatasetsData(scoreTimeline) {
  return _.mapValues(_.groupBy(scoreTimeline, 'fullWebPath'),
    clist => clist.map(e => e.score));
}

function listProperties(obj) {
  var propList = "";
  debugger
  for (var propName in obj) {
    if (typeof (obj[propName]) != "undefined") {
      propList += (propName + ", ");
    }
  }
  console.log(propList);
}
