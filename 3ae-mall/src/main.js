import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './docker/model/store/index'
import './config/registerServiceWorker'

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
