
// 该demo主要是展示了对象的封装和继承的多种形式，并实现了一个真实的商品对象的实现
log.info("test log");

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
console.log(add.call(s,3,4)); // 1+2+3+4 = 10
console.log(add.apply(s,[5,6])); // 1+2+5+6 = 14



// 初版
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

var footBook = new BookOrign(1, "足浴杂志", "￥15.00");

log.info(foodBook.getName());
log.info(footBook.getName());


// 初版
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

var sexBook = new GoodsOrgin(1000, "性爱杂志", "$25.00");
sexBook.display();

// var sexBook2 = new Book(1000, "花花公子杂志", "$55.00");
// sexBook2.display();



// 改进继承版
var GoodsClass = function() {
    this.name = "花花公子杂志";
}

GoodsClass.prototype = {
    getName: function() {
        return this.name;
    }
}

var BookClass = function() {

}

var Book = function(){}

Book.prototype = new GoodsClass();

var book = new Book();

log.info(book.getName())
log.info(BookClass.prototype.constructor.prototype.constructor.prototype.constructor.prototype.constructor);