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
	 - name      : EmberServiceJs
	 - file name : EmberServiceJs.vm
*/
import Adapter from '../adapters/entityvaluestore';
import Service from '@ember/service';
import { hash } from 'rsvp';

export default Service.extend({

	//description

    descriptionEntityValueRequest (params) {
        var adapter = Adapter.create(); 
        return adapter.descriptionEntityValueRequest(params);
    },
	//info
	//tenant

    tenantRegistry (params) {
        var adapter = Adapter.create(); 
        return adapter.tenantRegistry(params);
    },
	//binary

    binaryEntityValueRequest (params) {
        var adapter = Adapter.create(); 
        return adapter.binaryEntityValueRequest(params);
    },
	//translation

    translationLanguage (params) {
        var adapter = Adapter.create(); 
        return adapter.translationLanguage(params);
    },
	/** 
	 * Service to composite entity-value info 
	 * @param  {params} made of
	 *  - id
	 *  - tenantWebPath
	 *  - entityFullWebPath
	 *  - entityWebPath
	 *  - entityTypeWebPath
	 *  - languageCode
	 * @returns {*} Promise
	*/
    entityValue (params) {
    	var adapter = Adapter.create();
    	return adapter.EntityValue(params);
    },
    
	/** service to composite entity-value info in js
	 * @param  {params} made of
	 *  - id
	 *  - tenantWebPath
	 *  - entityFullWebPath
	 *  - entityWebPath
	 *  - entityTypeWebPath
	 *  - languageCode
	 * @returns {*} Promise
	*/
    entityValue2 (params) {
    	var adapter = Adapter.create();
		var descriptionEntityValueRequestPromise = adapter.descriptionEntityValueRequest(params)
		.then(d => {
			return d.DescriptionEntityValueRequestOut;
		});
		var binaryEntityValueRequestPromise = adapter.binaryEntityValueRequest(params)
		.then(d => {
			return d.BinaryEntityValueRequestOut;
		});
		var promises = {
			descriptionEntityValueRequest : descriptionEntityValueRequestPromise,
			binaryEntityValueRequest : binaryEntityValueRequestPromise,
			params : params,
		};
    	return hash(promises);

    },    


});
