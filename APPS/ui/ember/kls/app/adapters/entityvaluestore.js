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
	 - name      : EmberAdapterJs
	 - file name : EmberAdapterJs.vm
*/
import JSONAPIAdapter from '@ember-data/adapter/json-api';
import {fetchData} from '../utils/common-utils';
import appendQuery from 'append-query';

/*
import config from '../../config/environment';
const { host, namespace } = config.scoreDS;
const baseUrl = host+"/"+namespace;

*/

import config from 'kohlantstats/config/environment';
const { host, namespace } = config.entityValueStoreDS;
const baseUrl = host+"/"+namespace;

export default class entityvaluestore extends JSONAPIAdapter {

    //package description
    /* connector to DescriptionEntityValueRequest info */
    descriptionEntityValueRequest (params) {
        return fetchData(baseUrl+'/data/sdd/DescriptionEntityValueRequestIn'+filterDescriptionEntityValueRequest(params));
    }
    //package info
    //package tenant
    /* connector to TenantRegistry info */
    tenantRegistry (params) {
        return fetchData(baseUrl+'/data/sdd/TenantRegistryIn'+filterTenantRegistry(params));
    }
    //package binary
    /* connector to BinaryEntityValueRequest info */
    binaryEntityValueRequest (params) {
        return fetchData(baseUrl+'/data/sdd/BinaryEntityValueRequestIn'+filterBinaryEntityValueRequest(params));
    }
    //package translation
    /* connector to TranslationLanguage info */
    translationLanguage (params) {
        return fetchData(baseUrl+'/data/sdd/TranslationLanguageIn'+filterTranslationLanguage(params));
    }

	/* connector to composite entity-value info */
    entityValue (params) {
        return fetchData(baseUrl+'/data/sdd/EntityValueIn'+filterentityValue(params));
    }


}


/* filter for composite entity-value entity */
function filterentityValue (filter) {
	if (filter) {
		return appendQuery("",{
				"id":filter.id ,
				"tenantWebPath":filter.tenantWebPath ,
				"entityFullWebPath":filter.entityFullWebPath ,
				"entityWebPath":filter.entityWebPath ,
				"entityTypeWebPath":filter.entityTypeWebPath ,
				"languageCode":filter.languageCode ,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			


//description

/* filter for DescriptionEntityValueRequest entity */
function filterDescriptionEntityValueRequest (filter) {
	if (filter) {
		return appendQuery("",{
				"id":filter.id,
				"tenantWebPath":filter.tenantWebPath,
				"entityFullWebPath":filter.entityFullWebPath,
				"entityWebPath":filter.entityWebPath,
				"entityTypeWebPath":filter.entityTypeWebPath,
				"languageCode":filter.languageCode,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//info
//tenant

/* filter for TenantRegistry entity */
function filterTenantRegistry (filter) {
	if (filter) {
		return appendQuery("",{
				"tenantWebPath":filter.tenantWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//binary

/* filter for BinaryEntityValueRequest entity */
function filterBinaryEntityValueRequest (filter) {
	if (filter) {
		return appendQuery("",{
				"id":filter.id,
				"tenantWebPath":filter.tenantWebPath,
				"entityFullWebPath":filter.entityFullWebPath,
				"entityTypeWebPath":filter.entityTypeWebPath,
				"entityWebPath":filter.entityWebPath,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			
//translation

/* filter for TranslationLanguage entity */
function filterTranslationLanguage (filter) {
	if (filter) {
		return appendQuery("",{
				"isTranslated":filter.isTranslated,
				"isToTranslate":filter.isToTranslate,
				}, 
				{ removeNull: true }
			);
	}
	return "";
}			

