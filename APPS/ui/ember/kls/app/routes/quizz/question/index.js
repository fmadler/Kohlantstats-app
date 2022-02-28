import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';

export default class QuizzQuestionIndexRoute extends Route {
    @service('quizz') quizz;

    model(params) {
        let searchParams = {
            programWebPath: params.programWebPath,
            playerWebPath: params.playerWebPath,
            entityType: "player",
            entityWebPath: params.playerWebPath,
        };
        return this.quizz.questionDetail(
            params
        );
    }
}
