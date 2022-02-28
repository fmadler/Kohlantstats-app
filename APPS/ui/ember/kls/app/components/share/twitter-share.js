import ShareButton from './share-button'
import { action } from "@ember/object";

export default class ShareTwitterShareComponent extends ShareButton {
    shareURL = 'https://twitter.com/intent/tweet';
    hashtags = this.args.hashtags;

    @action
    click() {
        let url = this.shareURL;
        //strange this.title returns undefined but this.args.title works fine
        url += '?text=' + this.args.title;
        url += '&url=' + encodeURIComponent(this.getCurrentUrl());
        url += this.hashtags ? '&hashtags=' + this.hashtags.split(" ").join("") : '';
        url += this.via ? '&via=' + this.via : '';

        this.openSharePopup(url);
    }
}
