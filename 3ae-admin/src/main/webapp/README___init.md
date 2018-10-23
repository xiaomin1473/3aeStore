# create-react-app **-demo

yarn add antd

yarn add react-app-rewired

yarn add babel-plugin-import

/* package.json */

```json
  "scripts": {
    "start": "react-app-rewired start",
    "build": "react-app-rewired build",
    "test": "react-app-rewired test --env=jsdom",
  }
```

add config-overrides.js

```js
const { injectBabelPlugin } = require('react-app-rewired');

module.exports = function override(config, env) {
    // do stuff with the webpack config...

    config = injectBabelPlugin(
      ['import', { libraryName: 'antd', libraryDirectory: 'es', style: 'css' }],
      config,
    );
    return config;
};
```

修改 src/App.js
import { Button } from 'antd';

yarn start