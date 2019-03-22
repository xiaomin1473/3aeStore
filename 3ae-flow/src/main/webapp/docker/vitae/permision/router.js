Router = [
   {
      title: "登录",
      name: 'login',
      url: '/login',
      component: Config.alias.pagePath + "login.html"
   },
   {
      title: "首页",
      name: '',
      url: '/',
      component: Config.alias.htmlPath + "portal.html"
   },
   {
      title: "首页",
      name: 'portal',
      url: '/portal',
      component: Config.alias.htmlPath + "portal.html"
   },
   {
      title: "详情",
      name: 'detail',
      url: '/detail',
      component: Config.alias.htmlPath + "detail.html"
   },
   {
      title: "列表",
      name: 'list',
      url: '/list',
      component: Config.alias.htmlPath + "list.html"
   },
   {
      title: "数据备份",
      name: 'database',
      url: '/database',
      component: Config.alias.htmlPath + "database.html"
   },
   {
      title: "管理中心",
      name: 'controller',
      url: '/controller',
      component: Config.alias.htmlPath + "controller.html"
   },
   {
      title: "记录",
      name: 'log',
      url: '/log',
      component: Config.alias.htmlPath + "log.html"
   },
   {
      title: "错误",
      name: 'error',
      url: '/error',
      component: Config.alias.pagePath + "error/404.html"
   }
]