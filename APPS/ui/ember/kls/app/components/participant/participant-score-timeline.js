import Component from '@glimmer/component';
import _ from 'lodash';
import {getTimelineAbscissa, getChartJsDatasets} from '../../utils/timeline-utils';

export default class ParticipantParticipantScoreTimelineComponent extends Component {

  scoreTimeline = this.args.scoreTimeline;

  options= {
    scales: {
      y: {
        beginAtZero: true
      }
    },
    responsive: true
  }

  get scoreChart() {
    debugger
    return {
      labels: getTimelineAbscissa(this.scoreTimeline),
      datasets: getChartJsDatasets(this.scoreTimeline)
    };
  }
}
