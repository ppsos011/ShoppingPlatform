<template>
  <body id="login-page">
    <el-form  class="login-container"  label-position="left"  label-width="0px">
      <h3 class="login_title">用户登录</h3>
      <el-form-item> 
        <el-input prefix-icon="Avatar" type="text" v-model="form.username" auto-complete="off" placeholder="账号/手机号/邮箱" @blur="handleBlurUser" ></el-input>
      </el-form-item>
      <el-form-item> 
        <el-input prefix-icon="Lock" type="password" v-model="form.password" auto-complete="off" placeholder="密码" show-password @blur="handleBlurPwd" ></el-input>
      </el-form-item>
      <el-form-item>
        <span id="xy1" style="font-size:13px">登录即同意</span>
        <span id="xy2" style="font-size:13px"> 用户协议、隐私政策</span>
      </el-form-item>
      <el-form-item>
        <router-link to="/homepage"><el-button id="quick" @click="qucik">快速体验</el-button></router-link></el-form-item>
      <el-form-item style="width: 100%">
        <el-button class="b" type="primary" @click="login" style="width: 45%;  border: none;background:#fe5447">登录</el-button >
        <el-button class="b" type="primary" style="width: 45%;  border: none;background:#fe5447"  ><router-link to="/register">注册</router-link></el-button>
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
import jsCookie from 'js-cookie';
export default {
  name: "Login",
  data() {
    return {
      form: {
        username: '',
        password: '',
      }, 
      nowusername:''
    }
  },
  
  methods: {
    quick(){
      jsCookie.set('username',this.form.username)
    },
    login(){
        this.axios.post('/login',{
          username: this.form.username,
          password: this.form.password
      }).then(res => {
          console.log(res);
          if(res.data.code === 200){   //接收后端来的响应码，如果是200就是成功，400是失败
              jsCookie.set('username',this.form.username)
              window.alert("Welcome!");
              this.$router.replace({path: '/homepage'});  //登录成功跳转
          }else{
              window.alert("账号或密码有误!"); //失败就弹窗提示
          }
      }).catch(failResponse => {
          console.log(failResponse);
      })
    },
  },
};
</script>
<style scoped>
#login-page {

  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body {
  margin: 0px;
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.login_title1 {
  font-size: 10px;
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

.b{
  margin: auto;
}
a{
    color:white;
    text-decoration: none;
}
#xy1{
    color: #908e8f;
    text-align: center;
    line-height: 13px;
    margin-top: -3px;
}
#xy2{
  font-weight:bold;
}
#quick{
  width: 280px;
}
</style>