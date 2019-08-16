log.info("log init");
/******************************************************************
**                                                               **
**                                                               **
**                      author: sid.tadpole                      **
**                      time:    2019.8.15                       **
**                      path:    NanJing                         **
**                                                               **
**                                                               **
******************************************************************/


/************************ LEARNING_TARGET *************************
** 
** 
**  1. 通过工厂方法为页面创建不同功能的按钮
** 
** 
*/


// 工厂方法模式

/**
 * 
 * 
 * 
 * 
 */

var data = [
    {type: 'javascript', content: 'JavaScript 哪家强'},
    {type: 'java', content: 'java 哪家强'},
    {type: 'php', content: 'php 哪家强'},
    {type: 'UI', content: 'UI 哪家强'},
]






log.info("log init");


// 初版
// Java
var Java = function(content) {
    if(!(this instanceof Java)) {
        return new Java();
    }
    this.content = content;
    (function(content){
        var div = document.createElement('div');
        div.innerHTML = content;
        div.style.color = 'green';
        document.getElementsByTagName('body')[0].appendChild(div);
    })(content)
}

// PHP
var Php = function(content) {
    this.content = content;
    (function(content){
        var div = document.createElement('div');
        div.innerHTML = content;
        div.style.color = 'yellow';
        div.style.background = 'red';
        document.getElementsByTagName('body')[0].appendChild(div);
    })(content)
}

var Javascript =  function(content) {
    this.content = content;
    (function(content){
        var div = document.createElement('div');
        div.innerHTML = content;
        div.style.color = 'pink';
        document.getElementsByTagName('body')[0].appendChild(div);
    })(content)
}

function scriptFactoryOrign(type, content) {
    switch(type) {
        case 'java':
            return new Java(content);
        case 'php' :
            return new Php(content);
        case 'javascript':
            return new Javascript(content);
    }
}

scriptFactoryOrign("java", "java我最强");


// 改良版1
// Java
var Script = function(type, content) {
    if(!(this instanceof Script)) {
        return new Script(type, content);
    }
    this.content = content;
    (function(type, content){
        var div = document.createElement('div');
        div.innerHTML = content;
        if("java" == type) {
            div.style.color = 'green';
        } else if ("php" == type) {
            div.style.color = 'yellow';
            div.style.background = 'red';
        } else if ("javascript" == type) {
            div.style.color = 'pink';
        } else if ("UI" == type) {
            div.style.border = 'solid 1px red';
        }

        document.getElementsByTagName('body')[0].appendChild(div);
    })(type, content)
}
function scriptFactory(type, content) {
    return Script(type, content);
}

scriptFactory("java", "java我最强");

for(var i = 0; i < data.length; i++) {
    scriptFactory(data[i].type, data[i].content);
}




// 改良2, 未成功版
var Factory = function(type, content) {
    if (this instanceof Factory) {
        var s = new this[type](type, content);
    } else {
        return new Factory(type, content);
    }
}

Factory.prototype = {
    java: ()=>{
        this.script("java", content)},
    php: ()=>{this.script("php", content)},
    javascript: ()=>{this.script("javascript", content)},
    UI: ()=>{this.script("UI", content)},

    script: function(type, content) {
        var div = document.createElement('div');
        div.innerHTML = content;
        if("java" == type) {
            div.style.color = 'green';
        } else if ("php" == type) {
            div.style.color = 'yellow';
            div.style.background = 'red';
        } else if ("Javascript" == type) {
            div.style.color = 'pink';
        } else if ("UI" == type) {
            div.style.border = "solid 1px aqua";
        }
        
        document.getElementsByTagName('body')[0].appendChild(div);
    }
}

Factory("java", "我最骚");



