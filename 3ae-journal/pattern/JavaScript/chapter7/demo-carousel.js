log.info("log init");
/******************************************************************
**                                                               **
**                                                               **
**                      author: sid.tadpole                      **
**                      time:    2019.8.26                       **
**                      path:    NanJing                         **
**                                                               **
**                                                               **
******************************************************************/

/************************ LEARNING_TARGET *************************
** 
** 
**  
**  原型模式
** 
** 
*/
var LoopImages = (function(){
    var carousel = function(container, imgArr) {
        var wrapper = document.createElement('div');
        imgArr.push(imgArr[0]);
        imgArr.unshift(imgArr[imgArr.length-2]);

        imgArr.forEach(function(imgUrl){
            var img = document.createElement('img');
            img.src = imgUrl;
            img.width = container.clientWidth;
            img.height = container.clientHeight;
            wrapper.appendChild(img);
        })
        container.appendChild(wrapper);
    }

    function _loopImages(imgArr, container, arrow) {
        this.containerId = container;
        this.container = document.getElementById(container);
        this.imagesArray = imgArr;      // 图片对象
        this.arrow = arrow;             // 箭头
        this.interval = null;           // 定时器
        this.curr = 1;                  // 当前图片
    }

    _loopImages.prototype = {
        createImage: function() {
            carousel(this.container, this.imagesArray);
        },
        changeImage: function() {
            log.info("loop changeImage function");
        }
    }
    return _loopImages;
})();

var SlideLoopImage = function(imgArr, container) {
    LoopImages.call(this, imgArr, container);
}

SlideLoopImage.prototype = new LoopImages();

SlideLoopImage.prototype.init = function() {
    // 继承父类的createImage()
    this.createImage.call(this);
    var wrapper = this.container.childNodes[0];
    wrapper.style.width = this.container.clientWidth * this.imagesArray.length + "px";
    wrapper.style.height = this.container.clientHeight;
    wrapper.childNodes.forEach(function(data) {
        data.style.float = "left";
    })
    wrapper.style.marginLeft = -this.container.clientWidth * this.curr + 'px';
    this.animate();
}

SlideLoopImage.prototype.changeImage = function() {
    var wrapper = this.container.childNodes[0];
    if("pre" == arguments[0]) {
        // 判断临界值
        this.curr == 0 ? this.curr = this.imagesArray.length - 2 : null;

        var currLeft = this.container.clientWidth * this.curr--;
        var targetLeft = this.container.clientWidth * this.curr;

        var interval = setInterval(function(){
            if(currLeft > targetLeft) {
                wrapper.style.marginLeft = -(currLeft-=20) + 'px';
            } else if(currLeft < targetLeft) {
                wrapper.style.marginLeft = -targetLeft + 'px';
                clearInterval(interval);
            }
        }, 20);
    } else if("next" == arguments[0]) {
        // 判断临界值
        this.curr == (this.imagesArray.length - 2) ? this.curr = 0 : null;

        var currLeft = this.container.clientWidth * this.curr++;
        var targetLeft = this.container.clientWidth * this.curr;

        var interval = setInterval(function(){
            if(currLeft < targetLeft) {
                wrapper.style.marginLeft = -(currLeft+=20) + 'px';
            } else if(currLeft > targetLeft) {
                wrapper.style.marginLeft = -targetLeft + 'px';
                clearInterval(interval);
            }
        }, 20);
    } else {
        log.info("no change function");
    }
}

SlideLoopImage.prototype.animate = function() {
    that = this;
    this.interval = setInterval(function(){
        that.changeImage('next');
    }, 4000);
}

var FadeLoopImage = function(imgArr, container, arrow) {
    LoopImages.call(this, imgArr, container);
    this.arrow = arrow;
}

FadeLoopImage.prototype = new LoopImages();

FadeLoopImage.prototype.changeImage = function() {
    if("pre" == arguments[0]) {
        log.info("Pre image function");
    } else if("next" == arguments[0]) {
        log.info("Next image function");
    } else {
        log.info("no change function");
    }
}