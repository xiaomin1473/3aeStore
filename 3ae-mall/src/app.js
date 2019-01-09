import Vue from 'vue'
import App from './App.vue'
import { createRouter } from './router'
import store from './docker/model/store'
import './config/registerServiceWorker'
import './assets/static/icons'

Vue.config.productionTip = false

export function createApp() {
  const router = createRouter()

  // const icon = createIcon()

  const app = new Vue({
    router,
    store,
    render: h => h(App)
  })

  return app
}
