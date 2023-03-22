<template>
    <div class="common-layout">
      <!-- <TopMenu/> -->
      <el-container width="100%" >
        <el-header height="145px">
          <HeaderAll/>
        </el-header>
        <el-main id="bottom">
          <BottomAll/>
          <!-- <CartL/> -->
        </el-main>
      </el-container>
    </div>
</template>
  <script>
import HeaderAll from '../components/HeaderAll.vue';
import BottomAll from '../components/BottomAll.vue';
// import CartL from './CartL.vue';
// import TopMenu from './TopMenu.vue';
  export default {
    components: {
      HeaderAll,
      BottomAll,
      // CartL
      // TopMenu
  },
  }
  </script>
  <style scoped>
.common-layout{
  overflow: hidden;
}
.el-header{
    padding: 0px;

  }
  #bottom{
    padding: 0px;
    width: 100%;
    margin: 1px auto;
    border-top: 3px solid #487a6f;
  }
 
  </style>