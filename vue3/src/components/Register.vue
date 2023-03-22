<template>
  <body id="login-page">
    <el-form class="login-container" label-position="left" label-width="0px">
      <!-- <router-link><el-icon><ArrowLeftBold /></el-icon></router-link> -->
      <h3 class="login_title">立即注册</h3>
      <!-- <span id="head">立即注册</span> -->
      <el-form-item>
        <el-input
        prefix-icon="Avatar"
          type="text"
          v-model="form.name"
          auto-complete="off"
          placeholder="账号"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-input
        prefix-icon="Lock"
          type="password"
          v-model="form.password"
          auto-complete="off"
          placeholder="密码"
          show-password
        ></el-input>
      </el-form-item>
       <el-form-item>
        <el-input
          prefix-icon="Iphone"
          type="text"
          v-model="form.phonenum"
          auto-complete="off"
          placeholder="手机号"
        ></el-input>
      </el-form-item>
      <el-form-item>
            <el-select v-model="form.profession" placeholder="请选择职业">
              <el-option label="学生" value="学生"></el-option>
              <el-option label="公务员" value="公务员"></el-option>
              <el-option label="老师" value="老师"></el-option>
            </el-select>
      </el-form-item>
       <el-form-item>

         <span id="xy1" style="font-size:13px">登录即同意</span>
        <span id="xy2" style="font-size:13px">  用户协议、隐私政策</span>

       </el-form-item>
            
        
      <el-form-item style="width: 100%">
           <el-button type="primary"  style="width: 100%;  border: none; background:#fe5447"  @click="register">同意并注册</el-button>
      </el-form-item>
      <el-form-item>
          <el-button type="primary"  style="width: 100%;  border: none; background:#fe5447">
            <router-link to="/">返回登录页面</router-link></el-button>
      </el-form-item>
    </el-form>
     
  </body>
</template>

<script>
export default {
  data() {
    // let password =  (rule, value, callback) => {
    //             if (value === ''){
    //                 callback(new Error('密码不能为空'));
    //             } else {
    //                 callback()
    //             }
    //         }
    return {
      form: {
        name: '',
        password: '',
        phonenum:'',
        profession:''
      },

      // signup_rules: {
      //     username: [
      //         {required: true, message: '请输入用户名', trigger: 'change'},
      //     ],
      //     password: [
      //         {required: true, message: '请输入密码', trigger: 'change'}
      //     ],
      // }


    }
  },
  methods: {
     
     register(){
         const that = this
            this.axios.get('/register',
                {params:{
                    Uname:this.form.name,
                    Upsd:this.form.password,
                    UphoneN:this.form.phonenum,
                    Upro:this.form.profession
                }})
              .then(function(response){
                    console.log(response)
                    window.alert("注册成功");
                    that.$router.push({path: '/'});
    
              })
               .catch(function(error){
                    console.log(error)
                });
        },
    }
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
.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

#xy1{
    color: #908e8f;
    text-align: center;
    line-height: 13px;
}
#xy2{
  font-weight:bold;
}
a{
    color:white;
    text-decoration: none;
}

</style>