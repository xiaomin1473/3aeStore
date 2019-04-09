function DOMTokenList(el) {
    Object.defineProperty(this, "value", {
        enumerable: false,
        set: function(nv) {
            el.className = nv;
        }
    })
}

DOMTokenList.prototype = {
    constructor: DOMTokenList,
    add: function (clazz) {
        [].push.call(this, clazz);
        this.value = [].join.call(this, " ");
    },
    contains: function(clazz) {
        return [].includes.call(this, clazz);
    },
    remove: function(clazz) {
        for(var i=0; i<this.length; i++) {
            if(clazz === this[i]) {
                [].splice.call(this, i, 1);
                this.value = [].join.call(this, " ");

                return clazz;
            }
        }
    },
    toggle: function() {

    }
}
Object.defineProperty(HTMLElement.prototype, "classList", {
    get: function() {
        if(!this.__dtl__) {
            this.__dtl__ = this.className.split(" ");
            this.__dtl__.__proto__ = new DOMTokenList(this);
        }
        
        return this.__dtl__;
    }
})