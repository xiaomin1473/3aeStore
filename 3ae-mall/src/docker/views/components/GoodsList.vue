<template>
  <div>
    <h1>category</h1>
    <ul id="example-1">
      <li v-for="(value, key) in category" :key="key">
        <div v-for="(value2, key2) in value" :key="key2">
          <span v-for="(value3, key3) in value" :key="key3">
            {{ value3 }}
            <span v-for="(value4, key4) in value" :key="key4">
              {{ value4 }}
            </span>
          </span>
        </div>
      </li>
    </ul>
  </div>
</template>
<script>
import request from '@/assets/utils/request'

export default {
  name: 'GoodsList',
  data() {
    return {
      category: []
    }
  },

  mounted() {
    var that = this
    request.get('/mall/goods/category').then(function(response) {
      that.category = response.data.data
      console.log(that.category)
    }).catch(function(error) {
      console.log(error)
    })
  }
}
</script>
