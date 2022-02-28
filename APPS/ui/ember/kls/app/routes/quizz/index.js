import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';
import { task } from 'ember-concurrency';

export default class QuizzIndexRoute extends Route {
  @service('Quizz') quizzService;

  // model(params) {
  //   if (!Ember.isEmpty(params.products)) {
  //     return params.products.map((product) => {
  //       return {
  //         name: product,
  //         taskInstance: this.get('findProductTask').perform(product),
  //       };
  //     });
  //   }

  //   // If no query params are provided, return empty array
  //   return [];
  // },

  // /** Task that fetches a product record */
  // findProductTask: task(function * (productName) {
  //   return yield this.store.findRecord('product', productName);
  // }),

  model(params) {
    return {
      params: params,
      taskInstance: this.distinctQuestionsTask.perform(params),
    };
  }

  modelOld(params) {
    return this.quizzService.distinctQuestions(params);
  }

  @task
  *distinctQuestionsTask(params) {
    return yield this.quizzService.distinctQuestions(params);
  }
}
