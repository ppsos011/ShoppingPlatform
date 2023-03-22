<template>
  <div class="headerSearch">
      <el-input type="search" v-model="keyword" v-on:input="search"/>
      <!-- target="_blank" -->
      <router-link to="/searchbook" target="_blank">
        <button ><img src="../assets/images/搜索.png" alt=""></button>
      </router-link>
  </div>
</template>

<script>
import jsCookie from 'js-cookie';
  export default {
    name:'HeaderSearch',
    data () {
      return {
        keyword: '',
      };
    },
    mounted(){
      this.keyword=jsCookie.get('keyword')
    },
    methods: {
      search(){
        jsCookie.set('keyword',this.keyword)
        console.log('this.keyword:'+this.keyword)
      },
    },
  }
</script>
<style scoped>
.headerSearch {
    display: inline-block; 
    position: relative;
}
.headerSearch .el-input {
    width: 400px;
    height: 30px;
    background-color: #fff;
    outline: none;
    border-radius: 5px;
}

.headerSearch button{
    position: absolute;
    right: 0px;
    top: 0;
    width: 60px;
    height: 30px;
    margin: 0;
    border: none;
    color: white;
    background-color: #487a6f;
    cursor: pointer;
    border-top-right-radius: 5px;
    border-bottom-right-radius: 5px;
    }
img{
    width: 25px;
}
</style>