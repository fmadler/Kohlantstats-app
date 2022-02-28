import Application from 'kohlantstats/app';
import config from 'kohlantstats/config/environment';
import { setApplication } from '@ember/test-helpers';
import { start } from 'ember-qunit';

setApplication(Application.create(config.APP));

start();
