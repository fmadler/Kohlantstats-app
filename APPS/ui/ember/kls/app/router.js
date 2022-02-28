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
     - name      : EmberRouterJs
     - file name : EmberRouterJs.vm
*/
import EmberRouter from '@ember/routing/router';
import config from './config/environment';

export default class Router extends EmberRouter {
  location = config.locationType;
  rootURL = config.rootURL;
  /*
    headData: Ember.inject.service(),

setTitle(title) {
  this.get('headData').set('title', title);
}
*/
}

Router.map(function () {
  this.route('programme', function () {
    this.route('index', { path: '/' });
    this.route('programme', { path: '/:programWebPath' }, function () {

      //1
      // this.route('game', function() {
      //   this.route('index', {path : '/:programWebPath/games'});
      //   this.route('game', {path : '/:programWebPath/game/:gameWebPath'});
      // });

    });
    //this.route('participant.index',   {path : '/:programWebPath/participant'});
    this.route('participant.participant', { path: '/:programWebPath/participant/:playerWebPath' });

    this.route('game.game', { path: '/:programWebPath/game/:gameWebPath' });
    this.route('game.index', { path: '/:programWebPath/games/' });
    // this.route('game', function() {
    //   this.route('index', {path : '/:programWebPath/games'});
    //   this.route('game', {path : '/:programWebPath/game/:gameWebPath'});
    // });
    this.route('team', function() {
      this.route('team', { path: '/:programWebPath/team/:teamWebPath' });
    });
  });

  this.route('participant', function () {
    this.route('index', { path: '/' });
    this.route('participant', { path: '/:playerWebPath' });
  });

  this.route('player', function () {
    this.route('index', { path: '/' });
    this.route('player', { path: '/:playerWebPath' });
  });

  this.route('timeline', function () {
    this.route('timeline', { path: '/' });
  });

  this.route('game', function () {
    this.route('index', { path: '/' });
    this.route('game', { path: '/:gameWebPath' });
  });

  this.route('team', function () {
    this.route('index', { path: '/' });
    this.route('team', { path: '/:teamWebPath' });
  });

  this.route('captcha');
  this.route('quizz', function() {
    this.route('question', function() {
      this.route('index', { path: '/' });
      this.route('question', { path: '/:questionWebPath' });
    });
  });

  this.route('contributeurs');
  this.route('mentions-legales');
  this.route('features');
  this.route('definitions');
});

