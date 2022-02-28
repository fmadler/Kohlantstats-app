/*
	 Copyright (c) minuteproject, minuteproject@gmail.com
	 All rights reserved.

	 Licensed under the Apache License, Version 2.0 (the "License")
	 you may not use this file except in compliance with the License.
	 You may obtain a copy of the License at

	 http://www.apache.org/licenses/LICENSE-2.0

	 Unless required by applicable law or agreed to in writing, software
	 distributed under the License is distributed on an "AS IS" BASIS,
	 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 See the License for the specific language governing permissions and
	 limitations under the License.

	 More information on minuteproject:
	 twitter @minuteproject
	 wiki http://minuteproject.wikispaces.com
	 blog http://minuteproject.blogspot.net

*/
/*
	 template reference :
	 - Minuteproject version : 0.9.11
	 - name      : EmberRouteEntityJs
	 - file name : EmberRouteEntityJs.vm
*/
import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';

export default class ParticipantParticipantRoute extends Route {
	titleToken = ['field.participant'];
	@service('Score') scoreService;
	searchParams = null;

	model(params) {
		let searchParams = {
			playerWebPath: params.playerWebPath,
			entityType: "player",
			entityWebPath: params.playerWebPath,
		};
		this.searchParams = searchParams;

		let ret = this.get('scoreService').participantDetail2(
			searchParams
		);

		return ret;
	}
}
