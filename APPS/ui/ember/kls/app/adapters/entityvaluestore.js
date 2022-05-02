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

    //package entity
    /* connector to CreateEntity info */
    createEntity (params) {
        return fetchData(baseUrl+'/data/sdd/CreateEntityIn'+filterCreateEntity(params));
    }

    //package generic
    /* connector to MasterData info */
    masterData (params) {
        return fetchData(baseUrl+'/data/sdd/MasterDataIn'+filterMasterData(params));
    }

    //package description
    /* connector to DescriptionEntityValueRequest info */
    descriptionEntityValueRequest (params) {
        return fetchData(baseUrl+'/data/sdd/DescriptionEntityValueRequestIn'+filterDescriptionEntityValueRequest(params));
    }

    //package property
    /* connector to CreateProperty info */
    createProperty (params) {
        return fetchData(baseUrl+'/data/sdd/CreatePropertyIn'+filterCreateProperty(params));
    }

    /* connector to GetProperty info */
    getProperty (params) {
        return fetchData(baseUrl+'/data/sdd/GetPropertyIn'+filterGetProperty(params));
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
				"limit":filter.limit ,
				"offset":filter.offset ,
				},
				{ removeNull: true }
			);
	}
	return "";
}


//entity

/* filter for CreateEntity entity */
function filterCreateEntity (filter) {
	if (filter) {
		return appendQuery("",{
				"tenantWebPath":filter.tenantWebPath,
				"entityTypeWebPath":filter.entityTypeWebPath,
				"name":filter.name,
				"webPath":filter.webPath,
				"entityFullWebPath":filter.entityFullWebPath,
				"rootEntityWebPath":filter.rootEntityWebPath,
				"id":filter.id,
				},
				{ removeNull: true }
			);
	}
	return "";
}
//generic

/* filter for MasterData entity */
function filterMasterData (filter) {
	if (filter) {
		return appendQuery("",{
				"tenantWebPath":filter.tenantWebPath,
				"table":filter.table,	//Allowed values PROPERTY_TYPE,ENTITY_TYPE,ENTITY
				"orderby":filter.orderby,	//Allowed values id,name,web_path
				"sort":filter.sort,	//Allowed values ascending,descending
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
				"limit":filter.limit,
				"offset":filter.offset,
				},
				{ removeNull: true }
			);
	}
	return "";
}
//property

/* filter for CreateProperty entity */
function filterCreateProperty (filter) {
	if (filter) {
		return appendQuery("",{
				"tenantWebPath":filter.tenantWebPath,
				"entityFullWebPath":filter.entityFullWebPath,
				"propertyTypeWebPath":filter.propertyTypeWebPath,
				"value":filter.value,
				"id":filter.id,
				},
				{ removeNull: true }
			);
	}
	return "";
}

/* filter for GetProperty entity */
function filterGetProperty (filter) {
	if (filter) {
		return appendQuery("",{
				"tenantWebPath":filter.tenantWebPath,
				"entityFullWebPath":filter.entityFullWebPath,
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
				"limit":filter.limit,
				"offset":filter.offset,
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

