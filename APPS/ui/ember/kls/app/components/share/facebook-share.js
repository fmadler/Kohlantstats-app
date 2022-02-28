import ShareButton from './share-button'
import { action } from "@ember/object";

export default class ShareFacebookShareComponent extends ShareButton {

    shareURL = 'https://facebook.com/sharer.php';
    hashtags = this.args.hashtags;
    quote = this.args.quote;

    buildUrl() {
        let quote = this.quote ? `&quote=${this.quote}` : '';
        let hashtag = this.hashtags ? `&hashtag=${this.hashtags}` : '';
        let currentUrl = encodeURIComponent(this.getCurrentUrl());
        let url = `${this.shareURL}?display=popup&u=${currentUrl}${hashtag}${quote}`;
        return url;
    }

    @action
    click() {
        let url = this.buildUrl();
        this.openSharePopup(url);
    }
}
