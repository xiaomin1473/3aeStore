log.info("log init");
/******************************************************************
**                                                               **
**                                                               **
**                      author: sid.tadpole                      **
**                      time:    2019.8.21                       **
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

var LoopImages = function(imgArr, container) {
    this.imagesArray = imgArr;
    this.container = container;
    this.createImage = function(){};
    this.changeImage = function(){};
}