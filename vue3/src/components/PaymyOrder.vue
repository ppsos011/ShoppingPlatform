<template>
<div>
      <HeaderAll></HeaderAll>
    </div>
  <div class="ordera">
    <!-- 我的订单头部 -->
    <div class="order-headera">
      <div class="order-header-contenta">
        <p>

          我的订单
        </p>
      </div>
    </div>
    <!-- 我的订单头部END -->
    <div class="crumb">
        <div class="w">
            <div class="crumb-list">
                <a href="" class="crumb-item">Shop</a>
                <span>&gt;</span>
                <span class="crumb-item">我的购物车</span>
                <span>&gt;</span>
                <span class="crumb-item">确认订单</span>
                <span>&gt;</span>
                <span class="crumb-item">我的订单</span>
            </div>
        </div>
    </div>
    <!-- 我的订单主要内容 -->
    <div class="order-contenta" v-if="orders.length>0">
      <div class="contenta" >
        <ul class="ull">
          <!-- 我的订单表头 -->
          <li class="order-info" v-for="(item,index) in orders.slice(0,1)"  :key="index">
            <div class="order-id">订单编号: {{item.order_id}}</div>
            <div class="order-time">订单时间: {{item.order_time}}</div>
          </li>
          <li class="headera">
            <div class="apro-img"></div>
            <div class="apro-name">商品名称</div>
            <div class="apro-price">单价</div>
            <div class="apro-num">数量</div>
            <div class="apro-total">小计</div>
          </li>
          <!-- 我的订单表头END -->

          <!-- 订单列表 -->
          <li class="aproduct-list"  v-for="book in orders" :key="book">
            <div class="apro-img">
              <router-link :to="{ path: '/' }">
                <img :src="book.imgURL" />
              </router-link>
            </div>
            <div class="apro-name pro-name1">
              <!-- <router-link class="i-name"
                :to="{ path: '/'}"
              >{{book.info}}</router-link> -->
              <a class="alink ai-name" href="" target="_blank" >{{book.info}}</a>
            </div>
            <div class="apro-price">{{book.price}}元</div>
            <div class="apro-num">{{book.count}}</div>
            <div class="apro-total apro-total-in">{{book.price*book.count}}元</div>
          </li>
        </ul>
        <div class="order-bar">
          <div class="order-bar-left">
            <span class="order-total">
              共
              <span class="order-total-num">{{ordernum}}</span> 件商品
            </span>
          </div>
          <div class="order-bar-right">
            <span>
              <span class="atotal-price-title">合计：</span>
              <span class="atotal-price">{{ordertotal}}元</span>
            </span>
          </div>
          <!-- 订单列表END -->
        </div>
      </div>
      <div style="margin-top:-40px;"></div>
    </div>
    <!-- 我的订单主要内容END -->

    <!-- 订单为空的时候显示的内容 -->
    <div v-else class="order-empty">
      <div class="emptya">
        <h2>您的订单还是空的！</h2>
        <p>快去购物吧！</p>
           <button @click="a">nihao</button>
      </div>
    </div>
    <!-- 订单为空的时候显示的内容END -->
  </div>
       <div class="footer1">
        <Footer></Footer>
    </div>
</template>
<script>
import HeaderAll from './HeaderAll.vue';
import Footer from './Footer.vue';

export default {
  data() {
    return {
      orders: [], // 订单列表
      ordernum:'',
      ordertotal:'',
    };
  },
  methods:{
    getOrders(){
        const that=this
        this.axios.get('/getmyorders')
        .then(function(res){
          that.orders = res.data;
        })
    },
    getOrderNum(){
        const that=this
        this.axios.get('/getmyordersnum')
        .then(function(res){
          that.ordernum = res.data;
        })
    },
    getOrderTotal(){
        const that=this
        this.axios.get('/getmyorderstotal')
        .then(function(res){
          that.ordertotal = res.data;
        })
    },
  },

  mounted(){
    this.getOrders()
    this.getOrderNum()
    this.getOrderTotal()
  },

     components:{
      HeaderAll,
        Footer,
    },
 
};
</script>
<style scoped>

*{
  margin: 0;
  padding: 0;
}
.ordera {
  background-color: #f5f5f5;
  padding-bottom: 20px;
  
}
li{
    list-style: none;
}
/* 我的订单头部CSS */
.ordera .order-headera {
  height: 64px;
  border-bottom: 2px solid #ff6700;
  background-color: #fff;
  margin-bottom: 20px ; 
  
}
.ordera .order-headera .order-header-contenta {
  width: 1225px;
  margin: 0 auto;
}
.ordera .order-headera p {
  font-size: 28px;
  line-height: 58px;
  float: left;
  font-weight: normal;
  color: #424242;
}
/* 我的订单头部CSS END */
.ordera .contenta {
  width: 1225px;
  margin: 0 auto;
  background-color: #fff;
  margin-bottom: 50px;
}
.ordera .contenta .ull {
  background-color: #fff;
  color: #424242;
  line-height: 85px;
}
/* 我的订单表头CSS */
.ordera .contenta .ull .order-info {
  height: 60px;
  line-height: 60px;
  padding: 0 26px;
  color: #424242;
  border-bottom: 1px solid #ff6700;
}
.ordera .contenta .ull .order-info .order-id {
  float: left;
  color: #ff6700;
}
.ordera .contenta .ull .order-info .order-time {
  float: right;
}
.ordera .contenta .ull .headera {
  height: 85px;
  padding-right: 26px;
  color: #424242;
}
/* 我的订单表头CSS END */
/* 订单列表CSS */
.ordera .contenta .ull .aproduct-list {
  height: 110px;
  padding: 15px 26px 15px 0;
  border-top: 1px solid #e0e0e0;
}
.ordera .contenta .ull .apro-img {
  float: left;
  height: 85px;
  width: 120px;
  /* padding-left: 80px; */
}
.ordera .contenta .ull .apro-img img {
  height: 80px;
  width: 80px;
}
.ordera .contenta .ull .apro-name {
    float: left;
    width: 380px;
   
    line-height: 80px;
    height: 80px;

}
.pro-name1{
    width: 35%;
    text-align: left;
     font-size:10px ;
}
.ai-name{
     word-break: break-all;
    word-wrap: break-word;
    line-height: 50px;
    border-spacing: 2px;
    
}
.ordera .contenta .ull .apro-name a {
  color: #424242;
}
.ordera .contenta .ull .apro-name a:hover {
  color: #ff6700;
}
.ordera .contenta .ull .apro-price {
  float: left;
  width: 160px;
  padding-right: 18px;
  text-align: center;
}
.ordera .contenta .ull .apro-num {
  float: left;
  width: 190px;
  text-align: center;
}
.ordera .contenta .ull .apro-total {
  float: left;
  width: 160px;
  /* padding-right: 21px; */
  margin-left: 18px;
  text-align: right;
}
.ordera .contenta .ull .apro-total-in {
  color: #ff6700;
}
.ordera .order-bar {
  width: 1185px;
  padding: 0 20px;
  border-top: 1px solid #ff6700;
  height: 50px;
  line-height: 50px;
  background-color: #fff;
}
.ordera .order-bar .order-bar-left {
  float: left;
}
.ordera .order-bar .order-bar-left .order-total {
  color: #757575;
}
.ordera .order-bar .order-bar-left .order-total-num {
  color: #ff6700;
}
.ordera .order-bar .order-bar-right {
  float: right;
}
.ordera .order-bar .order-bar-right .atotal-price-title {
  color: #ff6700;
  font-size: 14px;
}
.ordera .order-bar .order-bar-right .atotal-price {
  color: #ff6700;
  font-size: 30px;
}
/* 订单列表CSS END */
/* 订单为空的时候显示的内容CSS */
.ordera .order-empty {
  width: 1225px;
  margin: 0 auto;
}
.ordera .order-empty .emptya {
  height: 300px;
  padding: 0 0 130px 558px;
  margin: 65px 0 0;
  background: url('../assets/images/cart-empty.png') no-repeat 124px 0;
  color: #b0b0b0;
  overflow: hidden;
}
.ordera .order-empty .emptya h2 {
  margin: 70px 0 15px;
  font-size: 36px;
}
.ordera .order-empty .emptya p {
  margin: 0 0 20px;
  font-size: 20px;
}

/* 订单为空的时候显示的内容CSS END */
 .crumb {
      width: 1225px;
    margin: 0 auto;
    position: relative;
    overflow: hidden;
    
    height: 30px;
    line-height: 40px;
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

.footer1 {
  width: 100%;
  text-align: center;
  /* background: #0a0a0a; */
  padding-bottom: 20px;
  padding-top: 50px;
}
</style>