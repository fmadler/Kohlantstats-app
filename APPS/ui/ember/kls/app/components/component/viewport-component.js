import Component from '@glimmer/component';
import { inject as service } from '@ember/service'; // with polyfill
import { action } from '@ember/object';
import { tracked } from "@glimmer/tracking";

export default class ComponentViewportComponentComponent extends Component {
    @service inViewport
    @tracked isInViewPort = false;
    loaderId = this.args.vpLoaderId


    @action
    setupInViewport() {
      const loader = document.getElementById(this.loaderId);
      const viewportTolerance = { bottom: 200 };
      const { onEnter, _onExit } = this.inViewport.watchElement(loader, { viewportTolerance });
      // pass the bound method to `onEnter` or `onExit`
      onEnter(this.didEnterViewport.bind(this));
    }

    didEnterViewport() {
        this.isInViewPort = true;
    }

    willDestroyElement() {
        // need to manage cache yourself if you don't use the mixin
        const loader = document.getElementById(this.loaderId);
        this.inViewport.stopWatching(loader);
    }
}
