import ShareButton from './share-button'
import { action } from "@ember/object";

export default class SharePinterestShareComponent extends ShareButton {

    shareURL = 'https://www.pinterest.com/pin/create/button/';

    @action
    click() {
        let url = this.shareURL;
        url += '?url=' + encodeURIComponent(this.getCurrentUrl());
        this.openSharePopup(url);
    }

}
