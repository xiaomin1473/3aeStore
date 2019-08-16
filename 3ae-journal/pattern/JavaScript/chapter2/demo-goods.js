log.info("test log");
/******************************************************************
**                                                               **
**                                                               **
**                      author: sid.tadpole                      **
**                      time:    2019.8.13                       **
**                      path:    NanJing                         **
**                                                               **
**                                                               **
******************************************************************/

/************************ LEARNING_TARGET *************************
** 
** 
**  1. 如何实现深复制？
** 
** 
*/


// 该demo主要是展示了对象的封装和继承的多种形式，并实现了一个真实的商品对象的实现
/**
 * 
 *  Tips: 
 *  1. 本例实现了简单的Book类封装，Goods类封装。
 *  2. 本例实现了一个Book子类继承Goods父类的几种方式。
 * 
 *  apply和call 把方法在指定对象上执行一次
 */
function add(c,d){
    return this.a + this.b + c + d;
}

var s = {a:1, b:2};
// console.log(add.call(s,3,4)); // 1+2+3+4 = 10
// console.log(add.apply(s,[5,6])); // 1+2+5+6 = 14



/*************************** BEGIN ****************************
**
**
**                           初版
**
**
*/
var BookOrign = function(id, name, price){
    this.name = name;
    this.id = id;
    this.price = price;
}
BookOrign.prototype = {
    // 特权方法
    checkId: function(id) {
        if(id == 1) {
            log.info(id + " 是唯一的");
        }
    },
    setId: function(id) {
        if(checkId) {
            this.id = id;
        } else {
            log.error("ID标识错误..");
        }
    },
    getId: function() {
        return this.id;
    },
    getName: function() {
        return this.name;
    },
    setName: function(name) {
        this.name = name;
    },
    getPrice: function(){
        return this.price;
    },
    setPrice: function(price){
        this.price = price;
    }
}

var foodBook = new BookOrign(1, "美食杂志", "￥15.00");

var tourBook = new BookOrign(1, "旅游杂志", "￥15.00");

log.info(foodBook.getName());
log.info(tourBook.getName());


/*************************** BEGIN ****************************
**
**
**                           初版
**
**
*/
var GoodsOrgin = (function() {
    var goodsNum = 0;

    function _goods(newId, newName, newPrice) {
        var name, price;
        this.id = newId;
        goodsNum++;
        if(goodsNum > 3){
            log.error("我们商城只有3个商品");
        };
        this.setName = function() {
            this.name = newName;
        };
        this.setPrice = function() {
            this.price = newPrice;
        }
        this.setName(name);
        this.setPrice(price);
    }

    _goods.prototype = {
        display: function() {
            log.table([{
                id: this.id,
                name: this.name,
                price: this.price
            }]);
        }
    }
    return _goods;
})();

var sexBook = new GoodsOrgin(1000, "健身杂志", "$25.00");
sexBook.display();

// var sexBook2 = new Book(1000, "花花公子杂志", "$55.00");
// sexBook2.display();

log.trace("这是调试");
log.warn("这是警告");
log.notes("这是提示");




/*************************** AFTER ****************************
**
**
**                           改进继承版
**
**
*/
var GoodsClass = function(name) {
    this.name = name;
}
GoodsClass.prototype = {
    getName: function() {
        return this.name;
    }
}
var BookClass = (function() {
    var num = 0;
    function _bookClass(name) {
        if(num > 2) {
            log.error("我们只出版了"+ num +"本书，非常抱歉...");
        }
        GoodsClass.call(this, name);
        num++;
    }
    _bookClass.prototype = new GoodsClass();

    return _bookClass;
})();

var book = new BookClass("时尚杂志");
var book1 = new BookClass("美食杂志");
var book2 = new BookClass("旅游杂志");
log.info(book.getName());
log.info(book1.getName());
log.info(book2.getName());




/*************************** FINAL ****************************
**
**
**                           最终版
**
**
*/
function inheritPrototype(SubClass, SuperClass) {
    function _f(){};
    _f.prototype = SuperClass.prototype;
    var p = new _f();
    p.constructor = SubClass;
    SubClass.prototype = p;
}

Goods = function(name) {
    this.name = name;
}
Goods.prototype = {
    getName: function() {
        return this.name;
    }
}
Book = (function() {
    var num = 0;
    function _book(name) {
        if(num > 1) { log.error("我们只出版了"+ num +"本书，非常抱歉..."); }
        Goods.call(this, name);
        num++;
    }
    inheritPrototype(_book, Goods);
    return _book;
})();

var book4 = new Book("时尚杂志");
var book5 = new Book("美食杂志");
log.info(book4.getName());
log.table(book5);