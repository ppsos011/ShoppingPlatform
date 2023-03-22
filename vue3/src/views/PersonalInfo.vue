<template>
    <div class="common-layout">
      <el-container width="100%" >
        <el-header height="145px">
          <HeaderAll/>
        </el-header>
        <el-main id="bottom">
            <div id="bottomAll">
                <div id="inland">
                    <div id="menu">
                        <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
                            <el-sub-menu index="1">
                                <template #title>
                                    <el-icon><location /></el-icon>
                                    <span>个人中心</span>
                                </template>
                                <!-- <el-menu-item index="1-1"><router-link>个人信息</router-link></el-menu-item>
                                <el-menu-item index="1-2"><router-link>收货地址</router-link></el-menu-item> -->
                                <el-menu-item index="1-1"><router-link to="">个人信息</router-link></el-menu-item>
                                <el-menu-item index="1-2"><router-link :to="{name:'address'}">收货地址</router-link></el-menu-item>
                            </el-sub-menu>
                        </el-menu>
                    </div>
                    <div id="form">
                        <router-view></router-view>
                    </div>
                </div>
            </div>
        </el-main>
      </el-container>
      <div>
        <Footer/>
      </div>
    </div>
</template>
  <script>
import HeaderAll from '../components/HeaderAll.vue';
import jsCookie from 'js-cookie';
import Footer from '../components/Footer.vue';
// import PersonalData from '@/components/PersonalData.vue';
  export default {
    components: {
      HeaderAll,
      Footer
    //   PersonalData
    },mounted(){
      this.username =jsCookie.get('id')
    },
  }
  </script>
  <style scoped>
  #bottom{
    padding: 0px;
    width: 100%;
    margin: 1px auto;
    border-top: 3px solid red;
    overflow: hidden;
  }
   #inland{
    width: 1200px;
    margin: auto;
  }
  #menu{
    width: 200px;
    float: left;
  }
  .el-sub-menu {
    background-color:#487a6f ;
    
  }
  .el-sub-menu span{
    color: white ;
  }
  .el-menu-item{
    border: none;
    display: block;
  }
  .el-sub-menu:hover{
    display: block;
    color: black !important; ;
  }
  .el-sub-menu span:hover{
    display: block;
    color: black !important; ;
  }
  .el-menu-item a{
    display: block;
    text-decoration: none;
  } 
  #form{
    width: 900px;
    float: left;
  }
</style>