import Component from '@glimmer/component';

export default class PerformanceProgressBarComponent extends Component {
   get secondPercent() {
       let perf = this.args.performance;
       return perf.individualPerformanceFirstTwoPercent 
        - perf.individualPerformanceFirstPercent;
   } 
}
