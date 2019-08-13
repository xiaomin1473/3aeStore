(function(window) {
    /**
     *  日志系统
     */


    Logger = function(data){
        this.state = data.state ? data.state : null;
        this.expand = data.expand;
    };
    Logger.prototype = {
        info: function(msg) {
            if(this.state == "test" || this.state == "debug") {
                console.log("【SYSTEM INFO】", msg);
            }
        },
        error: function(msg) {
            throw new Error("【SYSTEM ERROR】" + msg);
        },
        trace: function(msg) {
            if(this.state == "debug") {
                console.trace("【SYSTEM DEBUG】", msg);
            }
        },
        warn: function(msg) {
            console.warn("【SYSTEM WARNING】", msg);
        },
        dir: function(msg) {
            if(this.state == "test" || this.state == "debug") {
                this.info("Index: ");
                console.table(msg);
            }
        },
        table: function(msg) {
            if(this.state == "test" || this.state == "debug") {
                this.info("Index: ");
                console.table(msg);
            }
        },
        clear: function() {
            console.clear();
        },
        addMethod: function(fnName, fn) {
            if(this.expand == true) {
                this[fnName] = fn;
            } else {
                this.error("添加函数失败，扩展模式未开启...");
            }
        }
    }

    window.log = new Logger({
        state: "debug",
        expand: true
    });

})(window);