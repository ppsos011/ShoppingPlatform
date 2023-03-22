<template>
  <div class="headerCart">
    <div id="cart">
      
      <a href="javascript:;" @click="handleCart()">
        <span><img src="../assets/images/购物车.png" alt="">购物车</span>
      </a>        
    </div>
    <!-- <div id="order">
      <span>我的订单</span>
    </div> -->
  </div>
</template>

<script>
  // import { mapGetters } from 'vuex'
  export default {
    name:'HeaderCart',
    // components: {},
    // computed: {
    //   //cart模块带有命名空间
    //   ...mapGetters('cart', {
    //     //Vuex的store中定义的一个getter，得到购物车中商品的数量
    //     // 将this.cartItemsCount 映射为 this.$store.getters['cart/itemsCount']
    //     cartItemsCount: 'itemsCount'
    //   })
    // },

    methods: {
      handleCart(){
        this.$router.push("/cart");
      }
    },
  }
</script>
<style scoped>
.headerCart {
    width: 210px;
    height: 40px;
}
#cart{
  width: 105px;
  height: 40px;
  float: left;
  background-color:#487a6f;
  text-align: center;
  line-height: 40px;
}
#order{
  width: 101px;
  height: 36px;
  float: left;
  display: block;
  border: solid 2px rgb(167, 164, 164);
  text-align: center;
  background-color: rgb(196, 195, 195);
  line-height: 36px;
}
img{
  width: 20px;
  vertical-align:middle;
}
.headerCart a {
    text-decoration: none;
    color: white;
    
}
</style>