# VUE脚手架实现心得以及优化规划

| 修订版本 | 修订内容  | 修订人员 | 文档类型 | 修订日期 |
| :-----: |  :-----:  | :-----: | :-----: | :-----: |
|  v1.0.1.* | 新建VUE脚手架实现心得以及优化规划 | sid | -- | 2018-12-04 |
| ————— | ——————————————————————————— | ————— | ————— | —————— |

版本号说明

* 版本号第四位: 修剪文档语句结构、内容布局，不计入修订版本。
* 版本号第三位: 二级模块内容、结构进行更新，计入修订版本。
* 版本号第二位: 一级模块内容、结构进行更新，计入修订版本。
* 版本号第一位: 不限于整个文档进行升级、包含的内容同时进行版本迭代，计入修订版本并生成新的文档。

修改文档名为：
1.快照版（同布更新）
2.稳定版（只维护，不更新）
3.最终版（不更新、不维护）

---

## 主架构

```utf-8
架构图 vue-app

    project-name
    ├── build                                           // 打包资源
    ├── config                                          // webpack配置
    ├── dist                                            // 编译文件
    ├── script                                          // 脚本资源
    ├── src
    │    ├── common                                     // 通用资源
    │    │     ├── utils                                // 通用工具
    │    │     └── assets                               // 通用静态资源
    │    ├── config                                     // 公共配置
    │    ├── doctor                                     // 装配文件 (Vt. 装配，假造，修改)
    │    │     ├── cords                                // 数据处理 (n. 绳，堆积,捆绑)
    │    │     │     ├── api                            // 后台api
    │    │     │     ├── mock                           // 数据mock
    │    │     │     └── store                          // vuex
    │    │     ├── views                                // 视图
    │    │     │     ├── apply                          // 应用
    │    │     │     │     ├── components               // 组件
    │    │     │     │     └── paging                   // 分页
    │    │     │     └── pages                          // 页面
    │    │     │           └── filler                   // 页面配置 (n. 填装物，填注，补白，填料)
    │    │     └── vitae                                // 项目履历 (n. 个人简历，生活，生命<vita复数>，展望)
    │    │     │     ├── router                         // 路由
    │    │     │     └── permission.js                  // 许可证
    │    ├── main.js                                    // 应用入口
    │    └── app.vue                                    // 路由入口
    ├── static                                          // 全局静态资源
    ├── test                                            // 测试
    ├── .editorconfig                                   // 代码风格配置
    ├── .eslintignore                                   // eslint 忽略目录配置
    ├── .eslintrc                                       // eslint 配置
    ├── generator.json                                  // generator.json
    ├── package.json                                    // package.json
    ├── README.md                                       // 项目说明
    └── yarn.lock                                       // 模板版本管理
```

## 架构介绍及实现思考

- MVC结构
- 三级
- 细粒度
- 布局
- 设计模式
- 流程
- 测试

>&emsp;因为我对整个项目的开发流程、项目结构，包括vue的开发环境都处在学习、摸索阶段。所以特意把别人项目按照我自己的想法重新规划了结构和目录。
***
>&emsp;由于我有着一颗躁动和不安现状的心（想造出自己的轮子、脚手架、甚至是框架）。因此我在现有的项目基础上结合这段时间对ant-design-admin的学习与改造，做出了这个项目架构。
***
>&emsp;本着我自己的开发原则：顶层设计，层层拆分，逐步细化，依次打包，整体规划。从而实现由抽象到具体再到抽象的原子细粒度级的项目开发。

## 依赖包

```JSON
// data-set bizcharts                  图表
// antd                                UI
// babel-plugin-import                 按需加载
// promise-polyfill                    promise兼容
// whatwg-fetch                        跨域请求
// puppeteer                           爬虫（自动测试，抓取网页）
// redux-saga                          完成中间件的异步请求
{
  "dependencies": {
    "@antv/data-set": "^0.9.6",
    "antd": "^3.9.2",
    "babel-plugin-import": "^1.9.1",
    "bizcharts": "^3.2.2",
    "promise-polyfill": "^8.1.0",
    "puppeteer-core": "^1.8.0",
    "react": "^16.5.1",
    "react-app-rewire-less": "^2.1.3",
    "react-app-rewired": "^1.6.2",
    "react-dom": "^16.5.1",
    "react-router": "^4.3.1",
    "react-router-dom": "^4.3.1",
    "react-scripts": "1.1.5",
    "redux": "^4.0.0",
    "redux-saga": "^0.16.0",
    "whatwg-fetch": "^3.0.0"
  }
}
```

学习文献
1.Architectural Styles and the Design of Network-based Software Architectures
