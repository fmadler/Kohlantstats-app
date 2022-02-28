import Component from '@glimmer/component';

export default class ShareShareButtonComponent extends Component {
    tagName = 'button';
    //@tracked 
    title = this.args.title;
    text = '';
    image = '';
    shareAltIntro = this.args.shareAltIntro;
    url = '';
    via = this.args.via;
    //classNameBindings: ['adaptive:adaptive-button'],
    adaptive = true;
    get titleName() {
        return `${this.shareAltIntro} ${this.title}`
    }

    getCurrentUrl() {
        return this.url ? this.url : document.location.href;
    }

    getPopupPosition() {
        const dualScreenLeft = screen.availLeft;
        const dualScreenTop = screen.availTop;

        const windowWidth = screen.availWidth;
        const windowheight = screen.availHeight;

        const left = ((windowWidth / 2) - (600 / 2)) + dualScreenLeft;
        const top = ((windowheight / 2) - (600 / 2)) + dualScreenTop;

        return { left: left, top: top };
    }

    openSharePopup(url) {
        let popupPosition = this.getPopupPosition();
        var newWindow = window.open(url, 'Facebook',
            'location=no,toolbar=no,menubar=no,scrollbars=no,status=no, width=600, height=600, top=' + popupPosition.top + ', left=' + popupPosition.left);

        if (typeof (newWindow) !== 'undefined' && newWindow !== null && newWindow.focus) {
            newWindow.focus();
        }
    }
}
