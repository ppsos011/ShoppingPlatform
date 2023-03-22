<template slot-scope="scope">
<el-container>
  <div>
    <HeaderAll></HeaderAll>
  </div>
  <div class="cart-image w">
    <div>
      <img src="../assets/images/今日特惠.png" class="cartpic">
      
    </div>
  </div>
  <div class="cart-header w">
      <div class="cart-header-content">
        <p class="cart-header-p" >
          <i class="cart-myshop">
              <svg viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-029747aa=""><path fill="currentColor" d="M432 928a48 48 0 1 1 0-96 48 48 0 0 1 0 96zm320 0a48 48 0 1 1 0-96 48 48 0 0 1 0 96zM96 128a32 32 0 0 1 0-64h160a32 32 0 0 1 31.36 25.728L320.64 256H928a32 32 0 0 1 31.296 38.72l-96 448A32 32 0 0 1 832 768H384a32 32 0 0 1-31.36-25.728L229.76 128H96zm314.24 576h395.904l82.304-384H333.44l76.8 384z"></path><path fill="currentColor" d="M699.648 256 608 145.984 516.352 256h183.296zm-140.8-151.04a64 64 0 0 1 98.304 0L836.352 320H379.648l179.2-215.04z"></path></svg>
          </i>
          我的购物车
        </p>
        <span class="cart-header-span">温馨提示：商品是否购买成功，以最终下单为准喔，请尽快结算!</span>
      </div>
    </div>

  <!-- 中间信息导航 -->
<div class="crumb">
    <div class="w">
        <div class="crumb-list">
            <a href="" class="crumb-item">Shop</a>
            <span>&gt;</span>
            <span class="crumb-item">我的购物车</span>
        </div>
    </div>
</div>

<!-- 购物车主要内容区 -->
  <div class="cartcell-content " v-if="flag">
    <!-- 表头 -->
      <div class="cartcell-header w" >
        <table class="cart-table">
          <tbody>
            <tr>
                <th class="cartcell cell-check"><label> <input type="checkbox" class="cart-select-all" v-model="isCheckAll" @click="checkAll"> <span>全选</span> </label></th>
                <th class="cartcell cell-info">商品信息</th>
                <th class="cartcell cell-price">单价（元）</th>
                <th class="cartcell cell-count">数量</th>
                <th class="cartcell cell-total">金额（元）</th>
                <th class="cartcell cell-opera">操作</th>
            </tr>
            </tbody>
        </table>
      </div>
      <div class="cart-list w">  
        <table product-id="27" class="cart-table"  v-for="item in cartbooks" :key="item.cid" >
            <tbody>
            <tr>    
                <td class="cartcell cell-check"><input type="checkbox" class="cart-select" v-model="saveInfo" @change="singleCheck(item.cid)" :value="item" ></td>
                <td class="cartcell cell-img">
                      <a href="" target="_blank"> 
                        <img class="c-img" :src="item.imgURL">                  
                      </a>
                </td>                
                <td class="cartcell cell-info1" >
                  <a class="link i-name" href="" target="_blank" >{{item.info}}</a>
                </td>
                <td class="cartcell cell-price">{{item.price}}</td>
                <td class="cartcell cell-count">
                    <button class="count-btn mins" data-opera-type="mins" :min="1" @click="minplusm(item.cid)">-</button> 
                    <input data-max="-20101" class="count-input" :value="item.count" >
                    <button class="count-btn plus" data-opera-type="plus" :max="5" @click="minplusp(item.cid)">+</button>
                    </td>
                    
                <td class="cartcell cell-total">{{(item.price*item.count).toFixed(2)}}</td>
                <td class="cartcell cell-opera">
                  <!-- <a class="cartcell-delete"> -->
                  <el-button type="text" size="small" @click="deletebybook(item.cid)">删除</el-button>
                  </td>
            </tr>
            </tbody>
        </table> 
      </div>
      <div class="cartcell-footer w">
            <div class="cart-bar-left">
              <span>
                <router-link to="/">继续购物</router-link>
              </span>
              <span class="sep">|</span>
              <span class="cart-total">
                共
              <span class="cart-total-num">{{getnum}}</span> 件商品
              <!-- <span class="cart-total-num">{{getchecknum}}</span> 件 -->
          </span>
        </div>
        <div class="submit-all"><span>合计：</span> <span class="submit-total">{{totalsum}}元</span> 
              <router-link to="/confirmorder">
                  <span class="btn submit-btn">去结算</span></router-link>
        </div>
    </div>
  </div>

  <!-- 购物车为空的时候显示的内容 -->
    <div class="cart-empty"  v-else>
      <div class="empty">
        <h2>您的购物车还是空的！</h2>
        <p>快去购物吧！</p>
      </div>
    </div>
    <!-- 购物车为空的时候显示的内容END -->
  
  <el-footer class="footer ">
    
    <div  class="footer1">
      <Footer></Footer>
  </div>
  </el-footer>
</el-container>


<el-dialog
                              class="dialogde"
                              v-model="dialogVisible"
                              title="book"
                              width="30%"

                            >
                              <span>确定删除吗？</span>
                              <template #footer>
                                <span class="dialog-footer">
                                  <el-button @click="dialogVisible = false">取消</el-button>
                                  <el-button type="primary" @click="deleteOK">确定</el-button>
                                        <el-dialog
                                          class="dialogde"
                                          v-model="dialogDeleteok"
                                          title="book"
                                          width="30%"
                                          :before-close="handleClose"
                                        >
                                          <span>{{messageA}}</span>
                                          <template #footer>
                                            <span class="dialog-footer">
                                              <el-button @click="dialogVisible = false">取消</el-button>
                                              <el-button type="primary" @click="deleteOKK">确定</el-button>
                                          </span>
                                        </template>
                                      </el-dialog>
                                </span>
                              </template>
                            </el-dialog>
</template>
<script>
import HeaderAll from './HeaderAll.vue';
import Footer from './Footer.vue';

export default{
    data(){
        return{
            cartbooks:[], //购物车数据
            saveInfo:[],  //选中的图书
            getnum:'',    //共计图书数
            getchecknum:'',  //已选择多少
            totalsum:'0',    //总计
            flag:false,       //判断是否有图书
            isCheckAll:false, //是否全选
            dialogVisible:false,
            dialogDeleteok:false,
            messageA:'',
            visible:false,
            checkitema:0,

        }
        
    },

    methods:{
      //查询购物车数据
      searchall(){
      const that=this
      this.axios.get('/cartlists')
        .then(function(res){
          that.cartbooks = res.data;
        })
      },  
      //判断购物车是否有商品
      selectitem(){
        const that=this
        this.axios.get("/searchshow")
                  .then(function(response){
                    if(response.data>0){
                      that.flag=true;
                    }else{
                      that.flag=false;
                    }
                  })
      },


      //全选单选
      singleCheck(id) {
                const that = this 
                this.cid = id
                if (this.saveInfo.length === this.cartbooks.length) {
                    this.isCheckAll = true;
                    this.axios.get("/selectsumm")
                        .then(function(response){
                          that.totalsum = response.data;})
                } else {
                    this.isCheckAll = false;
                   this.a = this.cartbooks[this.cid-1].cid
                    that.axios.get("/checkitem",{
                      params:{key1:this.a,
                            }
                        })
                        .then(function(res){
                          that.checkitema = res.data
                        })
                    console.log(this.a,that.checkitema)
                    
                    if(this.checkitema === 0){
                       this.axios.get("/updatecheckitem1",{
                                  params:{key1:this.cid,
                                        }
                                    })
                                    .then(function(){              
                        })
                        }else{
                          this.axios.get("/updatecheckitem0",{
                                  params:{key1:this.cid,
                                        }
                                    })
                                    .then(function(){         
                        }) 
                        }
                    if (this.checkitema === 0){
                            this.axios.get("/itemcheck",{
                            params:{key1:this.cid,}
                                  })
                                  .then(function(response){
                                    that.totalsum = ( parseFloat(response.data)+parseFloat(that.totalsum)).toFixed(2);
                                  })
                    }else{
                              this.axios.get("/itemcheck",{
                                  params:{key1:this.cid,
                                        }
                                    })
                                    .then(function(response){
                                      that.totalsum =  (parseFloat(that.totalsum)-parseFloat(response.data)).toFixed(2);
                        })

                    }
                }
               
            },
      checkAll() {
                let that = this;
                this.cartbooks.forEach(item => {
                    if (!that.isCheckAll) {
                        that.saveInfo.push(item)
                        this.axios.get("/selectsumm")
                        .then(function(response){
                          that.totalsum = response.data;  })
                        this.axios.get("/updatecheck1")
                    } else 
                        that.saveInfo = [];
                        that.totalsum ='0',
                        that.searchall()
                        this.axios.get("/updatecheck0")
                    })

                },


      //删除单行图书 
      deletebybook(id){
              this.deleteid=id
              this.dialogVisible=true
            },
            deleteOK(){
              const that = this
              this.axios.get("/deletebook",{
                params:{key1:this.deleteid,
                        }
              })
              .then(function(response){
                    if(response.data>0){
                        that.messageA = "删除成功";
                      }else{
                        that.messageA = "删除失败"
                      }                   
                        that.dialogDeleteok=true
                      })
              },

              deleteOKK(){ 
                this.searchall()
                  this.dialogDeleteok=false
                  this.dialogVisible=false
      },


      //共计多少件
      getNum(){
        const that = this
        this.axios.get("/getnum")
                  .then(function(res){
                    that.getnum = res.data;
                  })
      },

      //已选择多少件
      // getCheckNum(){
      //   const that = this
      //   this.axios.get("/getchecknum")
      //             .then(function(res){
      //               that.getchecknum = res.data;
      //             })
      // },
      //总价
      // selectsum(){
      //   const that=this
      //   this.axios.get("/selectsumm")
      //             .then(function(response){
      //               that.totalsum = response.data;
      //             })
      // },

      //加减图书数量
      minplusm(id){
        const that=this
        this.cid = id
        this.axios.get("/cminplusm",{
                params:{key1:this.cid,}
                  })
                  .then(function(){
                      that.searchall()
                  }),
        this.axios.get("/cminplusmm",{
                params:{key1:this.cid,}
                  })
              },
      minplusp(id){
        const that=this
        this.cid = id
        this.axios.get("/cminplusp",{
                params:{key1:this.cid,}
                  })
                  .then(function(){
                      that.searchall()
                  }),
        this.axios.get("/cminpluspp",{
                params:{key1:this.cid,}
                  }) 
              }
      },
      
    mounted(){
      this.searchall()
      this.selectitem()
      this.getNum()
      // this.getCheckNum()
      // this.selectsum()
    },

    components:{
      HeaderAll,
        Footer,
    },

}



</script>

<style scoped>
  
  *{
    margin: 0;
    padding: 0
  }
  
  body > .el-container {
    /* margin-bottom: 40px; */
    margin: 0px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }


  .w{
    width: 1080px;
    margin: 0 auto;
    position: relative;
    overflow: hidden
  }


  /* 顶部信息 */
  .cartpic{
    width: 100%;
    padding-top: 16px;
  }

  .cart-tools{
    line-height: 110px;
    height: 110px;
  }
  /* 头部信息栏 */
  .cart-header{
    height: 50px;
    border-bottom: 2px solid #ff6700;
    background-color: #fff;
    
  }
   .cart-header-content{
    width: 1225px;
    margin: 0 auto;
   }
  .cart-header svg{
      width: 30px;
      font-weight: bold;
      float: left;
      margin-top: 9px;
      margin-right: 5px;
  }
  .cart-myshop{
    color:#ff6700; 
    font-weight: 600; 
    font-size: 20px;
  }
  .cart-header-p{
      float: left;
    font-weight: normal; 
    line-height: 44px;
    font-size: 30px;
    margin-left: 5px;
    margin-bottom: 0;
    margin-top: 0;
  }
  .cart-header-span{
      color: #757575;
    font-size: 12px;
    float: left;
    line-height: 20px;
    margin-top: 16px;
    margin-left: 15px;
  }

  
  .crumb {
    margin-bottom: 15px;
    height: 50px;
    line-height: 50px;
    font-size: 14px;
    background: #fff;
    color: #888;
}

.crumb .crumb-item {
    color: #888;
    text-decoration: none;
    cursor: pointer
}

.crumb .crumb-item:hover {
    color: #0294da
}


  /* 购物车商品信息栏 */
.cartcell-header{
      background: #eee;
  }
.cartcell-content {
  width: 1225px;
  margin: 0 auto;
  background-color: #fff;
 }
 table {
    display: table;
    border-collapse: separate;
    box-sizing: border-box;
    text-indent: initial;
    border-spacing: 2px;
    border-color: grey;
}
.cart-table{
    width: 100%;
    border-collapse: collapse;
    border: 1px solid #ebebeb;
    margin-top: 10px;
    margin-bottom: 10px; 
    color: #424242;
   border-spacing: 2px;
 }

/* 购物车表头 */
  .cart-table tbody{
    height: 41px;
  }
  tr{
    display: table-row;
    vertical-align: inherit;
    border-color: inherit;
  }
  th{
    display: table-cell;
    vertical-align: inherit;
    font-weight: bold;
   text-align: internal-center;
  }
  .cartcell-header .cartcell{
    height: 40px;
    line-height: 40px;
  }

.link{
    text-decoration:none;
}
a {
    text-decoration: none;
    color: #000;
}
a:link {
    text-decoration: none;
    color: #000;
}
a:visited {
    text-decoration: none;
    color: rgb(148, 172, 163);
}
a:hover {
    text-decoration: none;
    color: rgb(156, 152, 152);
}
a:active {
    text-decoration: none;
    color: rgb(245, 139, 139);
}

  

  /* 购物车列表 */
  .cart-table .cell-check{
    /* 
    text-align: center;
    padding-left: 20px; */
    /* width: 6%; */
    width: 11%;
    text-align: left;
    padding-left: 20px;
  }
  
  .cart-table .cell-img {
    width: 10%;
    text-align: left;
}

.cart-table .cell-img .c-img {
    margin: 10px 0;
    width: 80px;
    height: 80px;
    border: 1px solid #ddd;
    object-fit: cover;
}
  .cart-table .cell-info{
    width: 45%;
    padding-left: 106px;
    text-align: left;
  }

  .cart-table .cell-info1{
    width: 35%;
    text-align: left;
  }
  .i-name{
    word-break: break-all;
    word-wrap: break-word;
  }
  /* .cartcell-header .cell-info{
    width: 45%;
    padding-left: 106px;
  } */

  .cart-table .cell-price{
    width: 10%;
    text-align: center;
  }
  .cart-table .cell-count{
    width: 15%;
    text-align: center;
  }

  .cart-table .cell-count .count-input{
    width: 60px;
    height: 28px;
    line-height: 28px;
    border: 1px solid #ddd;
    text-align: center;
    vertical-align: middle;
    outline: none;
    color: #333;
}
.cart-table .cell-count .count-btn{
    display: inline-block;
    width: 20px;
    height: 28px;
    line-height: 28px;
    border: 1px solid #ddd;
    vertical-align: middle;
    cursor: pointer;
    background: #fff;
}

  .count-input{
    width: 40%;
    text-align: center;
  }
  .count-min,.count-plus{
    display: inline-block;
    border: 1px solid gray;
    background-color: white;
    
  }

  .cell-total{
     width: 14%;
    text-align: center;
    font-weight: bold;  
  }

  .cell-opera{
    width: 11%;
    text-align: center;
  }

  .cartcell-footer{
    background-color:rgb(229, 226, 226);
    /* width: 100%; */
    border-collapse: collapse;
    border: 1px solid #ebebeb;
    margin-top: 10px;
    margin-bottom: 10px; 
    

  }
  

/* 购物车内容底部 */
  /* .cartcell-footer .select-all{
      width: 5%;
      float: left;
  }  */
  .cartcell-footer{
    position: relative;
    line-height: 50px;
    background: #eee;
    overflow: hidden;
  } 

  .cartcell-footer .cart-bar-left {
    float: left;
  }
  .cartcell-footer .cart-bar-left a {
    line-height: 50px;
    margin-left: 32px;
    color: #757575;
  }
  .cartcell-footer .cart-bar-left a:hover {
    color: #ff6700;
  }
  .cartcell-footer .cart-bar-left .sep {
    color: rgb(108, 108, 108);
    margin: 0 20px;
  }
  .cartcell-footer .cart-bar-left .cart-total {
    color: #757575;
  }
  .cartcell-footer .cart-total-num{
    color: #c60023;
  }

  .cartcell-footer .submit-all{
      float:right;
  }
  .cartcell-footer .submit-all .submit-total{
    font-size: 18px;
    color: #c60023;
    font-weight: bold;
    margin-right: 30px;
    vertical-align: middle;
  }

.submit-all .submit-btn{
    width: 80px;
    text-align: center;
    height: 50px;
    line-height: 50px;
}

.submit-btn{
  float: right;
  width: 200px;
  text-align: center;
  font-size: 18px;
  margin-left: 50px;
  background: #ff6700;
  color: #fff;
}




/* 底部 */
/* 购物车为空的时候显示的内容CSS */


.cart-empty {
  width: 1225px;
  margin: 0 auto;
}
.cart-empty .empty {
  height: 300px;
  padding: 0 0 130px 558px;
  margin: 65px 0 0;
  background: url('../assets/images/cart-empty.png') no-repeat 124px 0;
  color: #b0b0b0;
  overflow: hidden;
}
.cart-empty .empty h2 {
  margin: 70px 0 15px;
  font-size: 36px;
}
.cart-empty .empty p {
  margin: 0 0 20px;
  font-size: 20px;
}
/* 购物车为空的时候显示的内容CSS END */

/* 购物车底部信息 */

.footer1 {
  width: 100%;
  text-align: center;
  /* background: #0a0a0a; */
  padding-bottom: 20px;
  padding-top: 50px;
}
.footer1 .mod_help {
  text-align: center;
  color: #888888;
}
.footer1 .mod_help p {
  margin: 20px 0 16px 0;
}
.footer1 .mod_help p a {
  color: #888888;
  text-decoration: none;
}
.footer1 .mod_help p a:hover {
  color: rgb(152, 109, 109);
}
.footer1 .mod_help p span {
  padding: 0 22px;
}
</style>