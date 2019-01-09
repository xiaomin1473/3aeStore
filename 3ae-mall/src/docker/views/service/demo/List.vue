<template>
  <div class="list">
    <GoodsList />
    <SvgIcon />
  </div>
</template>

<script>
// @ is an alias to /src
import GoodsList from '@/docker/views/components/GoodsList.vue'

export default {
  components: {
    GoodsList
  }
}
</script>
