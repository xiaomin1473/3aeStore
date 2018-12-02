# VUE源码学习心得体会和前端架构规划

| 修订版本 | 修订内容  | 修订日期 |
| :-----: |  :-----:  | :-----: |
|  v1.0.1 | 新建VUE源码学习心得体会和前端架构规划 | 2018-12-02 |

```utf-8
  今天周四，天气晴。
  经过一个多星期对vue框架的整合和源码、编码学习。大致理解到了下面这样一个工作流程：
    1.vue本质上是一个挂载到windows（全局对象）下的一个vue全局对象。
    2.vue所有的外置组件vuex,vue-router等挂载到vue对象上，等于是vue对象的属性。
    3.vue所有的组件操作其实就相当于是在改变vue所挂载对象的属性。
    4.vue组件对象的属性大致可以分为以下四个层级：
        (computentName):{
          data:{},    // 静态数据（常量）
          state:{},   // 状态数据（变量）
          atomOp:{},  // 原子操作（单一性，原子性，可见性，有序性。常见的vue内置封装函数）
          action:{},  // 高级操作（对原子操作的高级封装）
        }
    5.vue的生命周期从创建（前、后）、初始化（前、后）、运行监听（数据改变）、销毁（前、后）这几个阶段来完成整个dom树的构建与操作。
    6.理解什么是真正的面向对象。万物皆对象，皆不可逆，皆完备。
    7.按照对象的完备程度我们划分不同层级，给予不同的权限与能力。
    8.根据不同的规则，学习规则，完善规则，改造规则，创造规则。一张张表。
    9.面向对象三大要素：计算性、完备性、因果性。
    10.数据的存，数据的取。即仓库，操作，展示。MVC。
```

```utf-8
  经过对vue-admin框架的学习。独自整理出了下面这样一个网站工作流程：
    1.CVV架构。 cords vitae views （数据绑定、模块流程、展示操作）（MVVM）
    2.cords三个模块：answer(前端数据POST请求)、api(后台数据GET请求)、store(vuex本地数据) 其他mock(数据模拟)
    3.vitae三个模块：router(路由表)、permit(权限表)、session(会话表)
    4.views两个模块：apply(组件应用)、book(订装页面)
    5.网站流程：
      > main.js程序入口，挂载filter,vue-router,vuex,element,logs组件到vue上。
      > 获取store入口文件
        1.加载store
      > 获取vuex自带日志功能、记录操作者
      > 获取router入口文件
        1.挂载到vue
        2.加载config文件 // 暂无
        3.加载routes
          > 初始化静态路由表，若没有操作则返回
          > 获取store里用户列表，并获取用户roles
          > 获取permission路由表，根据roles动态生成permission表
          > 把之前生成的所有路由表合并成routes
        4.加载router全局守卫
          > 有token,根据store中当前用户token来判断所有路由表->进入routes文件进行动态配置（即改变store）
          > 没有token
            1.查看白名单，如果有，next()
            2.不在,to(登录)
          > 其他全部404
        5.局部守卫
        6.permit权限，页面权限，操作权限，数据权限，会话权限
          > 遵循规则：
            "[WHO]是否可以对[WHAT]进行[HOW]的访问操作，该操作[WHEN]授权结束" === true
            "[WHO]" —》 "[WHEN]" —》 "[HOW]" —》 "[WHAT]"  ===  "[state]"
            "[WHEN]"
            "[admin]" —》 "[handle]" —》 "[bound]"  ===  "[state]"
            "[admin]" —》 "[handle]" —》 "[reveal]"  ===  "[state]"
            "[admin]" —》 "[visit]" —》 "[bound]"  ===  "[state]"
            "[admin]" —》 "[visit]" —》 "[reveal]"  ===  "[state]"
            "[user]" —》 "[handle]" —》 "[bound]"  ===  "[state]"
            "[user]" —》 "[handle]" —》 "[reveal]"  ===  "[state]"
            "[user]" —》 "[visit]" —》 "[bound]"  ===  "[state]"
            "[user]" —》 "[visit]" —》 "[reveal]"  ===  "[state]"
      > views动态渲染sider和navbar
      > 操作发送给answer,验证操作token
      > 三级密码
```