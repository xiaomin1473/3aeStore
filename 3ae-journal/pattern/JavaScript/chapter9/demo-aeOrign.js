log.info("log init");
/******************************************************************
**                                                               **
**                                                               **
**                      author: sid.tadpole                      **
**                      time:    2019.8.30                       **
**                      path:    NanJing                         **
**                                                               **
**                                                               **
******************************************************************/

/************************ LEARNING_TARGET *************************
** 
** 
**  
**    外观模式
** 
** 
*/

// 写在开篇的扩展知识
`
    历史的车轮翻转前进。应该不时停车看看轮胎，那里有许多不可告人的秘密。
                                                                —————题记
    以前只说IE6,7,8。直到真正开始做兼容的时候才发现，应该是5、6、7、8。
    曾看过的《莱昂氏Unix源码分析》里面好多种函数实现与写法。当时也是俯拾仰取，直
到后来才明白那些都是1970年左右写出来的代码。而C语言第一代标准诞生是在89年，后来人
们把C89标准称为经典版本。那之前的还未形成标准的时期我们应该怎么称呼？起个有趣的名
字：C0标准。而今天要讲的内容对大前端人来说很熟悉，但其实很陌生————DOM0级别。
    大学时期看过很多文章，博客大篇幅介绍浏览器历史，不是广而泛，就是虎头蛇尾。并不
是一个技术人“真正”想要看的内容。而浏览器发展史————更确切地是电脑客户端网络通讯软件
与技术实现发展史。既然是软件和技术发展史，那必然伴随着软件、技术版本的更迭，包括但
不限于：最核心的通信协议版本，编码语言版本，运行环境版本，宿主环境四大模块。而IE就
是宿主环境，它实现了DHTML。整个前端的兼容难点也是建立在IE实现的DHTML不同版本上。
IE分为三个阶段:
IE4及以前：
    DHTML0: 分别包含了DOM0, html+css(没经历过这个版本，就不瞎写了)。
IE5,6,7,8：
    DHTML1: 分别包含了DOM1, html4+css2。
IE9+:
    DHTML2: 分别包含了DOM2, html5+css3。

标注：DHTML特指HTML4这个阶段，而数字只是为了和DOM标准看齐的虚拟数字(相当于版本号)。

瞎几把扯，进入今天正题，如何编写高级统一接口来封装兼容代码，当当当。外观模式。
`


function addEvent(dom, type, fn) {
    // 对于支持DOM2级事件处理程序addEventListener方法的浏览器
    if(dom.addEventListener) {
        dom.addEventListener(type, fn, false);
    } else if(dom.attachEvent) {
        dom.attachEvent('on' + type, fn);
    } else {
        dom['on' + type] = fn;
    }
}

// 获取事件对象
var getEvent = function(event) {
    // 标准浏览器返回event, IE下window.event
    return event || window.event;
}

// 获取元素
var getTarget = function(event) {
    var event = getEvent(event);
    // 标准浏览器下event.target, IE下event.srcElement
    return event.target || event.srcElement;
}

// 阻止默认行为
var preventEdfault = function(evet) {
    var event = getEvent(event);
    // 标准浏览器
    if(event.preventEdfault) {
        event.preventEdfault();
    // IE浏览器
    } else {
        event.returnValue = false;
    }
}

// 简约版属性样式方法库
var A = {
    // 通过id获取元素
    g: function(id) {
        return document.getElementById(id);
    },
    // 设置元素的css属性
    css: function(id, key, value) {
        this.g(id).style[key] = value;
    },
    // 设置元素的属性
    attr: function(id, key, value) {
        this.g(id)[key] = value;
    },
    // 添加内容
    html: function(id, html) {
        this.g(id).innerHTML = html;
    },
    // 为元素绑定事件
    on: function(id, type, fn) {
        this.g(id)['on' + type] = fn;
    }
}

A.css("demo", "color", "red");








var $ = function(selector) {
    window.Ae = {
        el:'',
        // 设置元素的css属性
        css: function(key, value) {
            this.el.style[key] = value;
        },
        // 设置元素的属性
        attr: function(key, value) {
            this.el[key] = value;
        },
        // 添加内容
        html: function(html) {
            this.el.innerHTML = html;
        },
        // 为元素绑定事件
        on: function(type, fn) {
            this.el['on' + type] = fn;
        }
    }
    function _init(selector) {
        // context = document.getElementById(context) || document;
        if(~selector.indexOf('#')) {
            log.info("id");
            this.Ae.el = document.getElementById(selector.slice(1));
        } else if (~selector.indexOf('.')) {
            log.info("class");
            this.Ae.el = document.getElementsByClassName(selector.slice(1))[0];
        } else {
            log.info("tag");
            this.Ae.el = document.getElementsByTagName(selector);
        }
    }
    _init(selector);

    return window.Ae;
}



$(".demo").css("color", "blue");

$("#demo").css("color", "aqua");