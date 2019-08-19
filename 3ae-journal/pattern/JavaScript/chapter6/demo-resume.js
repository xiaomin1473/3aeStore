log.info("log init");
/******************************************************************
**                                                               **
**                                                               **
**                      author: sid.tadpole                      **
**                      time:    2019.8.19                       **
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


// 建造者模式

// 初版
var Human = function(param) {
    // 技能
    this.skill = param && param.skill || '保密';
    // 兴趣爱好
    this.hobby = param && param.hobby || '保密';
}

Human.prototype = {
    getSkill: function() {
        return this.skill;
    },
    getHobby: function() {
        return this.hobby;
    }
}

var Named = function(name) {
    var that = this;
    // 构造器
    // 构造器函数解析姓名的姓和名
    (function(name, that){
        that.wholeName = name;
        if(name.indexOf(' ') > -1) {
            that.FirstName = name.slice(0, name.indexOf(' '));
            that.secondName = name.slice(name.indexOf(' '));
        }
    })(name, that);
}

var Work = function(work) {
    var that = this;
    (function(work, that){
        switch(work) {
            case 'code':
                that.work = '工程师';
                that.workDescript = '每天沉醉于编程';
                break;
            case 'UI':
            case 'UE':
                that.work = '设计师';
                that.workDescript = '设计更似一门艺术';
                break;
            case 'teach':
                that.work = '教师';
                that.workDescript = "分享也是一种快乐";
                break;
            default:
                that.work = work;
                that.workDescript = '对不起，我们还不清楚您所选择职位的相关描述...';
        }
    })(work, that);
}

Work.prototype.changeWork = function(work){
    this.work = work;
}

Work.prototype.changeDescript = function(setence) {
    this.workDescript = setence;
}

/**
 * 应聘者建造者
 * param name: 姓名
 * param work: 期望职位
 */
var Person = function(name, work) {
    // 创建应聘者缓存对象
    var _person = new Human();
    // 创建应聘者姓名解析对象
    _person.name = new Named(name);
    // 创建应聘者期望职位
    _person.work = new Work(work);
    // 将硬盘者对象返回
    return _person;
}

var person = new Person("赵宇明", 'code');

log.table(person);