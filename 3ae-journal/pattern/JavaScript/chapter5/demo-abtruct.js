log.info("log init");
/******************************************************************
**                                                               **
**                                                               **
**                      author: sid.tadpole                      **
**                      time:    2019.8.16                       **
**                      path:    NanJing                         **
**                                                               **
**                                                               **
******************************************************************/


/************************ LEARNING_TARGET *************************
** 
** 
**  1. 对抽象工厂模式的理解
**  2. 说出抽象工厂模式与工厂方法模式以及简单工厂模式之间的异同点及其关系
** 
** 
*/

// 抽象工厂模式


var VehicleFactory = function(subType, superType) {
    if (typeof VehicleFactory[superType] === 'function') {
        // 缓存类
        function F() {};
        // 继承父类属性和方法
        F.prototype = new VehicleFactory[superType]();
        // 将子类constructor 指向子类
        subType.constructor = subType;
        // 子类原型继承“父类”
        subType.prototype = new F();
    } else {
        // 不存在该抽象类抛出错误
        log.error("未创建该抽象类");
    }
}

VehicleFactory.Car = function() {
    this.type = 'car';
}

VehicleFactory.Car.prototype = {
    getPrice: function() {
        log.error("抽象方法不能调用");
    },
    getSpeed: function() {
        log.error("抽象方法不能调用");
    }
}

VehicleFactory.Bus = function() {
    this.type = 'bus';
}

VehicleFactory.Bus.prototype = {
    getPrice: function() {
        log.error("抽象方法不能调用");
    },
    getSpeed: function() {
        log.error("抽象方法不能调用");
    }
}

VehicleFactory.Truck = function() {
    this.type = 'truck';
}

VehicleFactory.Truck.prototype = {
    getPrice: function() {
        log.error("抽象方法不能调用");
    },
    getSpeed: function() {
        log.error("抽象方法不能调用");
    }
}

var BMW = function(price, speed) {
    this.price = price;
    this.speed = speed;
}

VehicleFactory(BMW, 'Car');

BMW.prototype = {
    getPrice: function() {
        return this.price;
    },
    getSpeed: function() {
        return this.speed;
    }
}


var Lamborghini = function(price, speed) {
    this.price = price;
    this.speed = speed;
}

VehicleFactory(Lamborghini, 'Car');

Lamborghini.prototype = {
    getPrice: function() {
        return this.price;
    },
    getSpeed: function() {
        return this.speed;
    }
}


var BenzTruck = function(price, speed) {
    this.price = price;
    this.speed = speed;
}

VehicleFactory(BenzTruck, 'Truck');

BenzTruck.prototype = {
    getPrice: function() {
        return this.price;
    },
    getSpeed: function() {
        return this.speed;
    }
}



/************************ LEARNING_GETTER *************************
** 
** 
**  1. 简单工厂模式就是一个类的多样实例化，判断传入参数实例化对象。
**  2. 工厂方法模式在实例化时传入一个参数，实现时通过判断参数来初始化不同属性
**  3. 抽象工厂模式，建立了两级继承关系。父类实现子类必备属性方法(interface)
**     但不实现。子类在实现时必须重写父类方法。在对象实例化时传入对应子类参数
**     进而创建不同类型的子类。
** 
*/
