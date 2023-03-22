<template>
    <div id="top-menu">
      <div>
        <SelectList/>
      </div>
    </div>
</template>
<script>
import SelectList from './SelectList.vue';
export default {
  data() {
    return {

    }
  },
  components: {
    SelectList
  }
}
</script>
<style>
#top-menu{
  width: 100%;
  height: 35px;
  background-color: #f9f9f9;
  border-bottom: #f2f2f2 1px solid;
}
</style>
