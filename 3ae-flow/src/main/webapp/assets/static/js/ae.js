/***************************************************************
 * 

 * 
 *              版本号： 1.0.1
 *              作  者： sid
 *              日  期： 2019-2-12
 * 
 * 
*/

;(function(window) {
    'use strict';

    var Ae = {}

    Ae.trans = {
        AJAX: function(data){},
        JSONP: function(data){},
        CORS: function(data){}
    }

    Ae.trans.AJAX = function(data, callback) {
        var xml;
        // data.url = `${data.url}?t=${Math.random()}`;
        // 首先判断当前浏览器是否支持XMLHttpRequest,若不支持则为IE5,IE6
        if(window.XMLHttpRequest) {
            xml = new XMLHttpRequest();
        }
        else {
            xml = new ActiveXObjects("Microsoft.XMLHttp");
        }

        


        // readyState 准备状态状态
        // 0 - (未初始化)还没有调用send()方法
        // 1 - (载入)已调用send()方法，正在发送请求
        // 2 - (载入完成)send()方法执行完成
        // 3 - (交互)正在解析响应内容
        // 4 - (完成)响应内容解析完成，可以在客户端调用了


        // 回调函数，依次执行4次
        xml.onreadystatechange = function() {
            if(xml.readyState === 4) {
                if(xml.status === 200) {
                    callback(xml);
                }
                else {
                    console.log(`执行错误，状态码为${xml.status}`);
                }
            }        }

        // 打开发送
        
        xml.open(data.type, data.url, data.async);
        if(data.type == "POST") {
            if(data.contentType) {
                xml.setRequestHeader("Content-type", data.contentType)
            }
        }

        data.type == "POST" ? xml.send(data.context) : xml.send();
    }

    Ae.trans.JSONP = function(data) {
        var script = document.createElement('script');
        var head = document.getElementsByTagName('head')[0];
        script.src = `${data.url}?callback=${data.callback}`;
        head.appendChild(script);
    }

    Ae.trans.CORS = function(data, callback) {
        var xml;
        if(window.XMLHttpRequest) {
            xml = new XMLHttpRequest();
        }
        else {
            xml = new ActiveXObjects("Microsoft.XMLHttp");
        }

        xml.onreadystatechange = function() {
            if(xml.readyState == 4) {
                if(xml.status == 200) {
                    callback(xml);
                }
            }
        }

        xml.open(data.type, data.url, data.async);

        xml.send();
    }

    Ae.util = {
        getId: function(id) {
            var ID = document.getElementById(id);
            return ID;
        },

        isArray: function(value) { 
            return Object.prototype.toString.apply(value) === '[object Array]';
        }
    }

    Ae.event = {
        click: function(id,fn) {
            Ae.func.getId(id).addEventListener('click',fn)
        }
    }

    Ae.carousel = {
        carousel: false,
        width: 0,
        height: 0,
        current: 1,
        scrlLeft: 0,
        total: 0,
        btn: {
            isBtn: false,
            pre: null,
            next: null
        },
        isCarousel: false,
        createBtn: function(e, btn) {
            btn.pre = document.createElement('div');
            btn.next = document.createElement('div');

            btn.pre.className = 'carousel-pre';
            btn.pre.innerHTML = '<';
            btn.next.className = 'carousel-next';
            btn.next.innerHTML = '>';

            e.appendChild(btn.pre);
            e.appendChild(btn.next);
        },
        swing: function(e, btn) {
            btn.pre.onclick = function() {
                if(this.current <= 1) {
                    return;
                }

                console.log("Carousel is offsetLeft…… " + e.offsetLeft);
                console.log("Carousel is clientLeft…… " + e.clientLeft);
                console.log("Carousel is scrollLeft…… " + e.scrollLeft);
                e.style.left = this.width + this.width;
                console.log("Carousel is scrollLeft…… " + e.style.left);
                this.scrlLeft = e.style.left;
            }

            btn.next.click = function() {
                if(this.current > this.data.total) {
                    return;
                }
            }
        },

        init: function(data) {
            /* --------------------  system is starting --------------------- */

            // Initing...
            this.carousel = document.getElementById(data.id);
            this.btn.isBtn = data.isBtn;
            this.isCarousel = data.isCarousel;
            this.total = data.total;
            
            if (this.carousel == null || !this.carousel) {
                console.log("轮播不存在！");
                return;
            }
            this.wrapper = document.getElementById('carousel_wrapper');
            this.width = this.carousel.offsetWidth;
            this.height = this.carousel.offsetHeight;
            for (var i =0; i < this.total; i++) {
                this.wrapper.children[i].style.width = this.width +'px';
            }

            
            this.wrapper.style.width = this.total * this.width +'px';
            console.log("wrapper's width is :" + this.wrapper.style.width);



            console.log("Carousel is initing……");
            console.log("Carousel's width: " + this.width);
            console.log("Carousel's height: " + this.height);
            
            if (this.btn.isBtn) {
                this.createBtn(this.carousel, this.btn);
                this.swing(this.wrapper, this.btn);
            }

        }
    }

    Ae.date = {
        format: function(time, format){
            var t = new Date(time);
            var tf = function(i){return (i < 10 ? '0' : '') + i};
            return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
            switch(a){
                case 'yyyy':
                    return tf(t.getFullYear());
                    break;
                case 'MM':
                    return tf(t.getMonth() + 1);
                    break;
                case 'mm':
                    return tf(t.getMinutes());
                    break;
                case 'dd':
                    return tf(t.getDate());
                    break;
                case 'HH':
                    return tf(t.getHours());
                    break;
                case 'ss':
                    return tf(t.getSeconds());
                    break;
                }
            }) 
        },
    }


    



    window.Ae = Ae;

})(window);