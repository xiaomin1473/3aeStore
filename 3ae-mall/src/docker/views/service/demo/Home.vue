<template>
  <div class="home">
    <img alt="Vue logo" src="@/assets/static/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/docker/views/components/HelloWorld.vue'


export default {
  name: 'list',
  components: {
    HelloWorld
  }
}
</script>
