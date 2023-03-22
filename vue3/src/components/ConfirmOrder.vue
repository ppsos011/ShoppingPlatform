<template>
  <div class="confirmOrder">
    <div>
      <HeaderAll></HeaderAll>
    </div>
    <!-- 头部 -->
    <div class="confirmOrder-header">
      <div class="header-content">
        <p>

        </p>
        <p>确认订单</p>
        <router-link to></router-link>
      </div>
    </div>
    <!-- 头部END -->
    <div class="crumb">
        <div class="w">
            <div class="crumb-list">
                <a href="" class="crumb-item">Shop</a>
                <span>&gt;</span>
                <span class="crumb-item">我的购物车</span>
                <span>&gt;</span>
                <span class="crumb-item">确认订单</span>
            </div>
        </div>
    </div>
    <!-- 主要内容容器 -->
    <div class="content">
      <!-- 选择地址 -->
      <div class="section-address">
        <p class="title">收货地址</p>
        <div class="address-body">
          <ul>
            <li
              :class="item.id == confirmAddress ? 'in-section' : ''"
              v-for="item in address"
              :key="item.id"
            >
              <h2>{{item.name}}</h2>
              <p class="phone">{{item.phone}}</p>
              <p class="address">{{item.address}}</p>
            </li>
            <li class="add-address">
              <i class="el-icon-circle-plus-outline"></i>
              <p>添加新地址</p>
            </li>
          </ul>
        </div>
      </div>
      <!-- 选择地址END -->

      <!-- 商品及优惠券 -->
      <div class="section-goods">
        <p class="title">商品及优惠券</p>
        <div class="goods-list">
          <ul>
            <li v-for="item in getcheckbooks" :key="item.id">
              <img  :src="item.imgURL" />
              <!-- src="../assets/images/qq.jpg" -->
              <span class="pro-name">{{item.info}}</span>
              <span class="pro-price">{{item.price}}元 x {{item.count}}</span>
              <span class="pro-status"></span>
              <span class="pro-total">{{item.total}}元</span>
            </li>
          </ul>
        </div>
      </div>
      <!-- 商品及优惠券END -->

      <!-- 配送方式 -->
      <div class="section-shipment">
        <p class="title">配送方式</p>
        <p class="shipment">包邮</p>
      </div>
      <!-- 配送方式END -->

      <!-- 发票 -->
      <div class="section-invoice">
        <p class="title">发票</p>
        <p class="invoice">电子发票</p>
        <p class="invoice">个人</p>
        <p class="invoice">商品明细</p>
      </div>
      <!-- 发票END -->

      <!-- 结算列表 -->
      <div class="section-count">
        <div class="money-box">
          <ul>
            <li>
              <span class="title">商品件数：</span>
              <span class="value">{{getcheckbooknuma}}件</span>
            </li>
            <li>
              <span class="title">商品总价：</span>
              <span class="value">{{gettotalpricez}}元</span>
            </li>
            <li>
              <span class="title">活动优惠：</span>
              <span class="value">-0元</span>
            </li>
            <li>
              <span class="title">优惠券抵扣：</span>
              <span class="value">-0元</span>
            </li>
            <li>
              <span class="title">运费：</span>
              <span class="value">0元</span>
            </li>
            <li class="total">
              <span class="title">应付总额：</span>
              <span class="value">
                <span class="total-price">{{gettotalpricez}}</span>元
              </span>
            </li>
          </ul>
        </div>
      </div>
      <!-- 结算列表END -->
      
      <!-- 结算导航 -->
      <div class="section-bar">
        <div class="btn" >
          <router-link to="/shoppingCart" class="btn-base btn-return">返回购物车</router-link>
          <router-link to="/paymyorder"><a href="javascript:void(0);" @click="addOrder(item)" class="btn-base btn-primary">结算</a></router-link>
        </div>
      </div>
      <!-- 结算导航END -->
    </div>
    <!-- 主要内容容器END -->
    <div class="footer1">
      <Footer></Footer>
    </div>
  </div>
</template>
<script>
import HeaderAll from './HeaderAll.vue';
import Footer from './Footer.vue';

export default {
  data() {
    return {
      getcheckbooks:[],
      getcheckbooknuma:'',
      gettotalpricez:'',
      // 虚拟数据
      confirmAddress: 1, // 选择的地址id
      name: "",
      datee:new Date(),
      orderi:'1101177889975036',
      imgurl:'http://img3m8.ddimg.cn/68/30/29483258-2_u_5.jpg',
        
      // 地址列表
      address: [
        {
          id: 1,
          name: "张同学",
          phone: "1000222221086",
          address: "浙江省 杭州市 滨江区 ***"
        },
        {
          id: 2,
          name: "张同学",
          phone: "1000222221086",
          address: "浙江省 杭州市 西湖区 ***"
        }
      ]
    };
  },
//   created() {
//     // 如果没有勾选购物车商品直接进入确认订单页面,提示信息并返回购物车
//     if (this.getCheckNum < 1) {
//       this.notifyError("请勾选商品后再结算");
//       this.$router.push({ path: "/shoppingCart" });
//     }
//   },
  computed: {
   
  },
  methods: {
    //订单商品
    getCheckNum(){
        const that=this
      this.axios.get('/getcheckbook')
        .then(function(res){
          that.getcheckbooks = res.data;
        })
    },
    //图书件数
    getCheckCount(){
        const that=this
        this.axios.get('/getcheckbooknum')
                  .then(function(res){
                    that.getcheckbooknuma = res.data;
        })
    },
    //总价
    getTotalPrice(){
         const that=this
         this.axios.get('/gettotalpricea')
                  .then(function(res){
                    that.gettotalpricez = res.data;
        })
    },
    dateFormat:function(time) {
    var date=new Date(time);
    var year=date.getFullYear();
    /* 在日期格式中，月份是从0开始的，因此要加0
     * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
     * */
    var month= date.getMonth()+1<10 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
    var day=date.getDate()<10 ? "0"+date.getDate() : date.getDate();
    var hours=date.getHours()<10 ? "0"+date.getHours() : date.getHours();
    var minutes=date.getMinutes()<10 ? "0"+date.getMinutes() : date.getMinutes();
    var seconds=date.getSeconds()<10 ? "0"+date.getSeconds() : date.getSeconds();
    // 拼接
    return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
    },
  //   a(){
  //     this.a=this.getcheckbooks
  //  this.imgURL = this.getcheckbooks[0].imgURL
  //   console.log(this.a,this.imgURL)
  //   },
    addOrder(){
      const that =this
        this.orderid = this.orderi
        this.imgurll=this.imgurl
        this.imgURL = this.getcheckbooks[0].imgURL
        for(let i=0;i<=this.getcheckbooks.length-1;i++){
            // this.imgURL = this.getcheckbooks[i].img
            this.info = that.getcheckbooks[i].info
            this.price = this.getcheckbooks[i].price
            this.count = this.getcheckbooks[i].count
            this.total = this.getcheckbooks[i].total
            this.order_time = this.dateFormat(new Date())
            console.log(this.orderid,this.imgURL,this.info,this.price, this.count,this.total,this.order_time)
            this.axios.get("/addtoorder",{
                params:{
                    key0:this.orderid,
                    key1:this.imgurl,
                    key2:this.info,
                    key3:this.price,
                    key4:this.count,
                    key6:this.order_time,
                    key5:this.total, }
          })
        }
    },
 
  },
  mounted(){
     this.getCheckNum();
     this.getCheckCount()
     this.getTotalPrice()
  },
  components:{
      HeaderAll,
        Footer,
    },
};
</script>
<style scoped>
.confirmOrder {
  background-color: #f5f5f5;
  padding-bottom: 20px;
}
/* 头部CSS */
.cart-myshop{
        color:#ff6700; 
    font-weight: 600; 
    font-size: 20px;
}
.confirmOrder .confirmOrder-header {
  background-color: #fff;
  border-bottom: 2px solid #ff6700;
  margin-bottom: 20px;
}
.confirmOrder .confirmOrder-header .header-content {
  width: 1225px;
  margin: 0 auto;
  height: 80px;
}
.confirmOrder .confirmOrder-header .header-content p {
  float: left;
  font-size: 28px;
  line-height: 80px;
  color: #424242;
  margin-top: 0%;
  margin-bottom: 20px;
  margin-left:20px;
}
.confirmOrder .confirmOrder-header .header-content p i {
  font-size: 45px;
  color: #ff6700;
  line-height: 80px;
}
/* 头部CSS END */
/* 主要内容容器CSS */
ul{
    list-style: none;
}
.confirmOrder .content {
  width: 1225px;
  margin: 0 auto;
  padding: 48px 0 0;
  background-color: #fff;
}
/* 选择地址CSS */
.confirmOrder .content .section-address {
  margin: 0 48px;
  overflow: hidden;
}
.confirmOrder .content .section-address .title {
  color: #333;
  font-size: 18px;
  line-height: 20px;
  margin-bottom: 20px;
}
.confirmOrder .content .address-body li {
  float: left;
  color: #333;
  width: 220px;
  height: 178px;
  border: 1px solid #e0e0e0;
  padding: 15px 24px 0;
  margin-right: 17px;
  margin-bottom: 24px;
}
.confirmOrder .content .address-body .in-section {
  border: 1px solid #ff6700;
}
.confirmOrder .content .address-body li h2 {
  font-size: 18px;
  font-weight: normal;
  line-height: 30px;
  margin-bottom: 10px;
}
.confirmOrder .content .address-body li p {
  font-size: 14px;
  color: #757575;
}
.confirmOrder .content .address-body li .address {
  padding: 10px 0;
  max-width: 180px;
  max-height: 88px;
  line-height: 22px;
  overflow: hidden;
}
.confirmOrder .content .address-body .add-address {
  text-align: center;
  line-height: 30px;
}
.confirmOrder .content .address-body .add-address i {
  font-size: 30px;
  padding-top: 50px;
  text-align: center;
}
/* 选择地址CSS END */
/* 商品及优惠券CSS */
.confirmOrder .content .section-goods {
  margin: 0 48px;
}
.confirmOrder .content .section-goods p.title {
  color: #333;
  font-size: 18px;
  line-height: 40px;
}
.confirmOrder .content .section-goods .goods-list {
  padding: 5px 0;
  border-top: 1px solid #e0e0e0;
  border-bottom: 1px solid #e0e0e0;
}
.confirmOrder .content .section-goods .goods-list li {
  padding: 10px 0;
  color: #424242;
  overflow: hidden;
}
.confirmOrder .content .section-goods .goods-list li img {
  float: left;
  width: 30px;
  height: 30px;
  margin-right: 10px;
}
.confirmOrder .content .section-goods .goods-list li .pro-name {
  float: left;
  width: 650px;
  line-height: 30px;
  font-size: 10px;
}
.confirmOrder .content .section-goods .goods-list li .pro-price {
  float: left;
  width: 150px;
  text-align: center;
  line-height: 30px;
}
.confirmOrder .content .section-goods .goods-list li .pro-status {
  float: left;
  width: 99px;
  height: 30px;
  text-align: center;
  line-height: 30px;
}
.confirmOrder .content .section-goods .goods-list li .pro-total {
  float: left;
  width: 190px;
  text-align: center;
  color: #ff6700;
  line-height: 30px;
}
/* 商品及优惠券CSS END */
/* 配送方式CSS */
.confirmOrder .content .section-shipment {
  margin: 0 48px;
  padding: 25px 0;
  border-bottom: 1px solid #e0e0e0;
  overflow: hidden;
}
.confirmOrder .content .section-shipment .title {
  float: left;
  width: 150px;
  color: #333;
  font-size: 18px;
  line-height: 38px;
}
.confirmOrder .content .section-shipment .shipment {
  float: left;
  line-height: 38px;
  font-size: 14px;
  color: #ff6700;
}
/* 配送方式CSS END */
/* 发票CSS */
.confirmOrder .content .section-invoice {
  margin: 0 48px;
  padding: 25px 0;
  border-bottom: 1px solid #e0e0e0;
  overflow: hidden;
}
.confirmOrder .content .section-invoice .title {
  float: left;
  width: 150px;
  color: #333;
  font-size: 18px;
  line-height: 38px;
}
.confirmOrder .content .section-invoice .invoice {
  float: left;
  line-height: 38px;
  font-size: 14px;
  margin-right: 20px;
  color: #ff6700;
}
/* 发票CSS END */
/* 结算列表CSS */
.confirmOrder .content .section-count {
  margin: 0 48px;
  padding: 20px 0;
  overflow: hidden;
}
.confirmOrder .content .section-count .money-box {
  float: right;
  text-align: right;
}
.confirmOrder .content .section-count .money-box .title {
  float: left;
  width: 126px;
  height: 30px;
  display: block;
  line-height: 30px;
  color: #757575;
}
.confirmOrder .content .section-count .money-box .value {
  float: left;
  min-width: 105px;
  height: 30px;
  display: block;
  line-height: 30px;
  color: #ff6700;
}
.confirmOrder .content .section-count .money-box .total .title {
  padding-top: 15px;
}
.confirmOrder .content .section-count .money-box .total .value {
  padding-top: 10px;
}
.confirmOrder .content .section-count .money-box .total-price {
  font-size: 30px;
}
/* 结算列表CSS END */
/* 结算导航CSS */
.confirmOrder .content .section-bar {
  padding: 20px 48px;
  border-top: 2px solid #f5f5f5;
  overflow: hidden;
}
.confirmOrder .content .section-bar .btn {
  float: right;
}
.confirmOrder .content .section-bar .btn .btn-base {
  float: left;
  margin-left: 30px;
  width: 158px;
  height: 38px;
  border: 1px solid #b0b0b0;
  font-size: 14px;
  line-height: 38px;
  text-align: center;
}
.confirmOrder .content .section-bar .btn .btn-return {
  color: rgba(0, 0, 0, 0.27);
  border-color: rgba(0, 0, 0, 0.27);
}
.confirmOrder .content .section-bar .btn .btn-primary {
  background: #ff6700;
  border-color: #ff6700;
  color: #fff;
}
/* 结算导航CSS */
/* 主要内容容器CSS END */
  .crumb {
        width: 1225px;
    margin: 0 auto;
    position: relative;
    overflow: hidden;
    height: 20px;
    line-height: 20px;
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