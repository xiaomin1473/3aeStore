log.info("log init");
/******************************************************************
**                                                               **
**                                                               **
**                      author: sid.tadpole                      **
**                      time:    2019.9.3                        **
**                      path:    NanJing                         **
**                                                               **
**                                                               **
******************************************************************/

var Count = (function(){
    //缓存图片（参考第二十二章， 备忘录模式）
    var _img = new Image();
    // 返回统计函数
    return function(param) {
        var str = "http://www.count.com/a.gif?";
        //拼接字符串
        for(var i in param) {
            str += i + '=' + param[i];
            // 发送统计请求
        }
        _img.src = str;
    }
})();
Count({num : 10});