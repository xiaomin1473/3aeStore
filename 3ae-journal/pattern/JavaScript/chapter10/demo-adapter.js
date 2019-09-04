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

/************************ LEARNING_TARGET *************************
** 
** 
**    适配器模式
**    1. 我们想要一个对象数据，而后端给的是字符串或XML，怎么转换?
** 
** 
*/

function doSomeThing(obj) {}


function doSomeThing(obj) {
    var _adapter = {
        name: "洒清荷",
        title: "设计模式",
        age: 24,
        color: "pink",
        size: 100,
        prize: 50
    };
    for(var i in _adapter) {
        _adapter[i] = obj[i] || _adapter[i];
    }

    // do something
}


var arr = ['java', 'book', '19-9-3'];

function arrToObjAdapter(arr) {
    return {
        name: arr[0],
        type: arr[1],
        data: arr[2]
    }
}

// 适配器是对外观模式的扩展，需清楚数据内部的结构，再原来的基础上把不同形式的数据封装成另一种形式
// 而外观仅仅是对接口的封装