import Route from '@ember/routing/route';

//TODO add in ConfigAwareRoute
import config from 'kohlantstats/config/environment';
const { host, namespace } = config.entityValueStoreDS;
//const entityValueStoreBaseUrl = host+"/"+namespace;

export default class ConfigAwareRoute extends Route {
    entityValueStoreBaseUrl = host+"/"+namespace;
}