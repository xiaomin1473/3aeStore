<template>
  <div class="home">
    <img alt="Vue logo" src="@/assets/static/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <GoodsList />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/docker/views/components/HelloWorld.vue'
import GoodsList from '@/docker/views/components/GoodsList.vue'

export default {
  name: 'home',
  components: {
    HelloWorld,
    GoodsList
  }
}
</script>
