Logger = (function() {
    /**
     *  日志系统
     */
    var themes = {
        layout: "6px 0",
        tips: {
            color: '#fff',
            background: '#030307',
        },
        info: {
            color: '#777',
            background: '#f6f6f6',
        },
        debug: {
            color: '#777',
            background: '#00ffff',
        },
        warn: {
            color: '#777',
            background: '#f8f828',
        },
        except: {
            color: '#fff',
            background: '#ff2832',
        },
        set: function(data) {
            var str=";color:"+this[data].color+
                    ";background:"+this[data].background + 
                    ";padding:" + this.layout;
            //console.log(str);
            return str;
        }
    }

    var config = {
        notes: {
            time: 3000,
        },
    }

    function tips(tips, msg) {
        var str = '\n %c '+ tips.toLocaleUpperCase() +' %c '+ msg + ' \n';
        console.log(str, themes.set("tips"), themes.set(tips));
    }


    function _logger(data){
        this.state = data.state ? data.state : null;
        this.expand = data.expand;
        var themes = themes;
    };
    
    _logger.prototype = {
        info: function(msg) {
            if(this.state =="test" || this.state == "debug") {
                tips("info", msg);
            }
        },
        trace: function(msg) {
            if(this.state == "debug") {
                tips("debug", msg);
            }
        },
        warn: function(msg) {
            tips("warn", msg);
            console.warn(msg);
        },
        error: function(msg) {
            tips("except", msg);
            throw new Error(msg);
        },
        dir: function(msg) {
            if(this.state =="test" || this.state == "debug") {
                this.info("Index");
                console.table(msg);
            }
        },
        table: function(msg) {
            if(this.state =="test" || this.state == "debug") {
                this.info("Index");
                console.table(msg);
            }
        },
        count: function(msg){
            if(this.state == "debug") {
                tips("debug", msg);
                console.count("执行次数");
            }
        },
        clear: function() {
            console.clear();
        },
        notes: function(msg) {
            var div = document.createElement("div");
            div.style = "position: fixed; "+
                        //"top:-80px;"+
                        "top:0;"+
                        "left:0;"+
                        "width: 100%;"+
                        "height: 80px;"+
                        "color: #fff;"+
                        "line-height: 80px;"+
                        "text-align: center;"+
                        "background-color: rgba(0, 0, 0, .75);"+
                        "opcity: 0"+
                        "transition: all .3s;";
            div.innerHTML = msg;
            document.body.appendChild(div);
            var i = 0;
            setInterval(function() {
                //i<65 ? div.style.top = i+=5 + "px" : div.style.top = "0";
                i<1 ? div.style.opacity = i+=0.3 : div.style.opacity = 1;
            }, 100);
            setTimeout(function(){document.body.removeChild(div)}, config.notes.time);
        },
        addMethod: function(fnName, fn) {
            if(this.expand == true) {
                this[fnName] = fn;
            } else {
                this.error("添加函数失败，扩展模式未开启...");
            }
        }
    }

    return _logger;
})();

window.log = new Logger({
    state: "debug",
    expand: true
});