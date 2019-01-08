const server = require('express')()
const createApp = require('./dist/service-worker.js')

server.get('*', (req, res) => {
   const app = createApp()
   renderer.renderToString(app, (err, html) => {
      // 处理错误……
      res.end(html)
    })
})

server.listen(8080)