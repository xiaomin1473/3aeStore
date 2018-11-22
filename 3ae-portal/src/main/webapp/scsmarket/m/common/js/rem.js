(function (doc, win) {
    var docEl = doc.documentElement;
    var resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize';
    var recalc = function () {
        var clientWidth = docEl.clientWidth;
        var clientHeight = docEl.clientHeight;
        if (!clientWidth) return;

        clientWidth = docEl.clientWidth>750 ? 750: docEl.clientWidth<=320?320:docEl.clientWidth;

        docEl.style.fontSize = (clientWidth / 750 * 100).toFixed(2) +"px";
    };
    recalc();
    if (!doc.addEventListener) return;
    win.addEventListener (resizeEvt, recalc, false);
})(document, window);
