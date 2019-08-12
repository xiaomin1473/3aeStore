
// 该demo主要是展示了js几种函数对象使用形式，并完成了日志对象的创建和优化

/**
 * 
 *  Tips: 因为JS中所有的成员都属于对象，而且都继承自Obeject对象。
 * 
 *  测试使用
 *
**/
// 用对象收编变量
var CheckObject = {
    checkName: function() {
    },
    checkEmail: function() {
    },
    checkPwd: function() {
    }
}

// 另一种形式
var CheckObjectFnc = function(){};
CheckObjectFnc.checkName = function(){};
CheckObjectFnc.checkEmail = function(){};
CheckObjectFnc.checkPwd = function(){};



// 初始版。该对象作为一个类，每次使用都需要实例化。消耗资源
LoggerOrign = function(msg) {
    this.info = function(msg) {
        console.log("【SYSTEM INFO】", msg);
    },
    this.error = function(msg) {
        console.error("【SYSTEM ERROR】", msg);
    }
}

var loggerOrign = new LoggerOrign();



// 检测以上两种方法是否都继承自Object对象
loggerOrign.info(CheckObject instanceof Object)
loggerOrign.info(CheckObjectFnc instanceof Object)





// 改进版，把常用的类属性封装在原型链上，再多次实例化时，可以减少内存消耗
LoggerNew = function(){};
LoggerNew.prototype =  {
    info: function(msg) {
        console.log("【SYSTEM INFO】", msg);
    },
    error: function(msg) {
        console.error("【SYSTEM ERROR】", msg);
    }
}

// 为每个函数添加一个操作方法
Function.prototype.logger = new LoggerNew();






// 终极改良版，封装了一些常用的输出环境和格式
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
        console.error("【SYSTEM ERROR】", msg);
    },
    trace: function(msg) {
        if(this.state == "debug") {
            console.trace("【SYSTEM DEBUG】", msg);
        }
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

// 给类添加参数,test debug 空 分别对应测试，调试，正常运行三种模式
var log = new Logger({
    state: "sss",
    expand: true
});

log.addMethod("runTick", function() {
    if(this.state == "test") {
        console.time();
    }
})

log.addMethod("endTick", function() {
    if(this.state == "test") {
        this.info("模块运行时间");
        console.timeEnd();
    }
})

log.runTick();
log.endTick();

var arr = [1, 2, 3, 4, 5, 6, 7];

var map = {
    state: "test",
    expand: true
}

log.dir(arr);
log.dir(map);
log.table(arr);
log.table(map);
localStorage.li = "哈哈";

`text
这个demo1代码，主要目的是为了熟悉各种函数的创建方式
顺便封装了一下console，平时也没多大用，要是可以存储在本地文件中就更好了
网上有几种方法可以存储本地文件
1.localstorage 2.cookie

// 本地存储实践
https://blog.csdn.net/weixin_34080571/article/details/89380193
`

// https://www.fed123.com/javascriptnodejs/4531.html
// 介绍以下代码区别
var log2 = Object.create(LoggerOrign,{});
var log3 = new LoggerOrign();

