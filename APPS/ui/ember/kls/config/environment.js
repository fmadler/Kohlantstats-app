'use strict';

module.exports = function(environment) {
  let ENV = {
    modulePrefix: 'kohlantstats',
    environment,
    rootURL: '/',
    locationType: 'history',//auto
    EmberENV: {
      FEATURES: {
        // Here you can enable experimental features on an ember canary build
        // e.g. EMBER_NATIVE_DECORATOR_SUPPORT: true
      },
      EXTEND_PROTOTYPES: {
        // Prevent Ember Data from overriding Date.parse.
        Date: false
      }
    },
    viewportConfig: {
      viewportEnabled                 : false,
      viewportUseRAF                  : true,
      viewportSpy                     : false,
      viewportScrollSensitivity       : 1,
      viewportRefreshRate             : 100,
      viewportListeners               : [],
      intersectionThreshold           : 0,
      scrollableArea                  : null,
      viewportTolerance: {
        top    : 0,
        left   : 0,
        bottom : 0,
        right  : 0
      }
    },
    //Main data
    scoreDS: {
      namespace: 'scoreKendoUiApp',
      host: 'https://winerylabs.com',
    },
    //Microservices
    entityValueStoreDS: {
      namespace: 'entityvaluestoreKendoUiApp',
      host: 'https://winerylabs.com',
    },
    imageDS: {
      namespace: 'imageManagementWeb',
      host: 'https://winerylabs.com',
    },
    quizzDS: {
      namespace: 'quizzKendoUiApp',
      host: 'https://winerylabs.com',
      //host: 'http://localhost/',
    },
    APP: {
      // Here you can pass flags/options to your application instance
      // when it is created
    }
  };

  if (environment === 'prototype') {
    // ENV.APP.LOG_RESOLVER = true;
    // ENV.APP.LOG_ACTIVE_GENERATION = true;
    // ENV.APP.LOG_TRANSITIONS = true;
    // ENV.APP.LOG_TRANSITIONS_INTERNAL = true;
    // ENV.APP.LOG_VIEW_LOOKUPS = true;
    ENV.scoreDS = {
      namespace: 'scoreGraphQLApp',
      host: 'https://winerylabs.com',
      //host: 'http://localhost',
    }
    ENV.entityValueStoreDS = {
      //namespace: 'imageManagementWeb',
      namespace: 'entityvaluestoreKendoUiApp',
      host: 'https://winerylabs.com',
      //host: 'http://localhost/',
    }
    ENV.imageDS = {
      namespace: 'imageManagementWeb',
        host: 'https://winerylabs.com',
    }
    ENV.quizzDS= {
      namespace: 'quizzKendoUiApp',
      host: 'https://winerylabs.com',
      //host: 'http://localhost/',
    }
  }

  if (environment === 'development') {
    // ENV.APP.LOG_RESOLVER = true;
    // ENV.APP.LOG_ACTIVE_GENERATION = true;
    // ENV.APP.LOG_TRANSITIONS = true;
    // ENV.APP.LOG_TRANSITIONS_INTERNAL = true;
    // ENV.APP.LOG_VIEW_LOOKUPS = true;
    ENV.scoreDS = {
      namespace: 'scoreKendoUiApp',
      //host: 'https://winerylabs.com',
      host: 'http://localhost',
    }
    ENV.entityValueStoreDS = {
      //namespace: 'imageManagementWeb',
      namespace: 'entityvaluestoreKendoUiApp',
      host: 'https://winerylabs.com',
    }
    ENV.imageDS = {
      namespace: 'imageManagementWeb',
      host: 'https://winerylabs.com',
    }
    ENV.quizzDS= {
      namespace: 'quizzKendoUiApp',
      host: 'https://winerylabs.com',
      //host: 'http://localhost/',
    }
  }

  if (environment === 'test') {
    // Testem prefers this...
    ENV.locationType = 'none';

    // keep test console output quieter
    ENV.APP.LOG_ACTIVE_GENERATION = false;
    ENV.APP.LOG_VIEW_LOOKUPS = false;

    ENV.APP.rootElement = '#ember-testing';
    ENV.APP.autoboot = false;
  }

  if (environment === 'production') {
    // here you can enable a production-specific feature
  }

  return ENV;
};
