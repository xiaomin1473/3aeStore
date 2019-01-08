import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/service/demo/Home.vue'

Vue.use(Router)

export default function createRouter() {
  const router = new Router({
    // 要记得增加mode属性，因为#后面的内容不会发送至服务器，服务器不知道请求的是哪一个路由
    mode: 'history',
    routes: [
      {
        path: '/',
        name: 'home',
        component: Home
      },
      {
        path: '/about',
        name: 'about',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/service/demo/About.vue')
      },
      {
        path: '/list',
        name: 'list',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/service/demo/List.vue')
      }
    ]
  })

  return router
}
