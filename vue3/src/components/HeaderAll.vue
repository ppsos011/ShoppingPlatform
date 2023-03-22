<template>
    <div class="header">
      <div id="b">
        <div id="top">
          <div><img src="@/assets/images/logo.png"></div>
          <div id="log" style="">
            <!-- <span>请<router-link to="/">{{getUserName}}</router-link></span> -->
            <span v-if="username ==''">你好，请<router-link to="/"> 登录 </router-link> 免费 <router-link to="/register">注册</router-link></span>
            <span v-else><img src="../assets/images/224用户.png" style="width:20px;height:20px;margin: 11px 0px 0px 30px;"/>欢迎您，{{ username }}<a href="javascript:;" @click="logout">退出登录</a></span>
          </div>
        </div>
        <div id="bottom"><HeaderMenus/></div>
      </div>
    </div>
  </template>
  
  <script>
import HeaderMenus from "./HeaderMenus.vue";
import jsCookie from 'js-cookie';

  export default {
    name: "HeaderAll",
    data(){
      return{
        username:'',
        id:'',
        keyword:'',
      }
    },
    components: {
      HeaderMenus,
    },
    mounted(){
      this.username =jsCookie.get('username')
    },
    methods:{
      logout(){
        this.username =''
        jsCookie.set('username',this.username)
        this.$router.go(0);
        // this.id = jsCookie.set('id',this.username)
      }
    },
  
  };
  </script>
  <style scoped>
  body{
      margin: 0px;
      padding: 0px;
    }
.header{
  width: 100%;
  height: 149px;
  border-bottom:3px solid #487a6f ;
  
}
#b{
  width:1200px;
  height: 145px;
  margin: auto;
}
#top{
    width:1200px ;
    height: 105px;
    margin: auto;
    float: left;
    vertical-align: middle;
    
 }
 #log a{
  text-decoration: none;
  color: #ff2832;
  display: inline-block;
  margin: 0px 6px;
 }
 #log a:hover{
  color: cornflowerblue;
 }
 #bottom{
    width:1200px ;
    height: 40px;
    margin: auto;
    float: left;
    vertical-align: middle;
 }
img{
    width: 200px;
    height: 104px;
    vertical-align: middle;
    float: left;
} 
#search{
  width: 600px;
  float: left;
  margin:30px 95px 30px;
}
#log{
  width: 300px;
  height: 40px;
  float: right;
  margin-top:30px ;
  text-align:center;
  line-height:40px ;
  margin-right: 0px;
  color: #646464;
}
  
  
  </style>