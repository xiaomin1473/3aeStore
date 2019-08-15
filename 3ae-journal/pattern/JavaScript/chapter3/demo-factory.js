// 该demo主要展示了简单工厂模式, 球类商品
/**
 * 
 *  Tips: 
 * 
 * 
 * 
 */

log.info("log init");


// 篮球基类
var Basketball = function() {
    this.name = '篮球';
}

Basketball.prototype = {
    getMember: function() {
        log.info("需要5名队员");
    },
    getBallSize: function() {
        log.info("篮球很大");
    }
}

// 足球基类
var FootBall =function() {
    this.name = "足球";
}

FootBall.prototype = {
    getMember: function() {
        log.info("需要11名队员");
    },
    getBallSize: function() {
        log.info("足球很大");
    }
}

// 网球基类
var Tennis = function() {
    this.name = "网球";
}

Tennis.prototype = {
    getMember: function() {
        log.info("每个队伍需要1名队员");
    },
    getBallSize: function() {
        log.info("网球很小");
    }
}

var SportsFactory = function(name) {
    switch(name) {
        case 'NBA':
            return new Basketball();
        case 'WordCup':
            return new FootBall();
        case 'FranchOpen':
            return new Tennis();
    }
}

var football = new SportsFactory("WordCup");

football.getBallSize();


var Goods = function() {
    this.name = "商品";
}

Goods.prototype = {
    getName: function() {
        return "书名：" + this.name;
    },
    getNum: function() {
        return "这是第" + this.num + "本书...";
    }
}

function inheritPrototype(SubClass, SuperClass) {
    function _f(){};
    _f.prototype = SuperClass.prototype;
    var p = new _f();
    p.constructor = SubClass;
    SubClass.prototype = p;
}

var Book = (function() {
    var num = 0;
    function Book(newName, newPrice) {
        Goods.call(this);
        this.name = newName;
        this.price = newPrice;
        this.num = ++num;
        if(num>2){
            log.error("书本不够");
        }
    }
    inheritPrototype(Book, Goods);
    return Book;
})();

var book1 = new Book("花花公子", "￥63");
var book2 = new Book("花花公子", "￥63");
log.info(book1.getName() + "  " + book1.getNum());
log.table(book2);