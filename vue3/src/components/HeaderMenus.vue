<template>
    <div class="menus">
      <div id="menul">
        <ul>
          <li id="all">
            <router-link to="/homepage" style="color: white">首页</router-link>
          </li>
          <li class="other">
            <router-link target="_blank" to="/">图书</router-link>
          </li>
          <li class="other">
            <a href="javascript:;">电子书</a>
          </li>
          <li class="other">
            <a href="javascript:;">童书</a>
          </li>
          <li class="other">
            <Cart/>
          </li>
          <li class="other">
            <router-link target="_blank" to="/personalinfo">我的</router-link>
          </li>
          <li class="other">
            <router-link target="_blank" to="/paymyorder">订单</router-link>
          </li>
        </ul>
      </div>
      <div id="menur">
        <Search/>
      </div>
    </div>
</template>

<script>
import Search from './Search.vue';
import Cart from './Cart.vue';
export default {
  components: {
    Search,
    Cart
    }
};
</script>
<style scoped>
.menus {
  margin: auto;
  width: 1200px;
  height: 40px;
  margin-bottom:10px ;
}
#menul{
  width: 800px;
  height: 40px;
  float: left;
}
#menur{
  padding: 5px 0px;
  /* margin-left:100px ; */
  float: left;
}
#all{
  width: 200px;
  background: #487a6f;
}
a {
  text-decoration: none;
  display: block;
  color: black;
  height: 40px;
  line-height: 40px;
  border-width: 1px 1px 0 0;
  font: "Microsoft Yahei";
  font-weight: bold;
}
ul{
  margin: 0px;
  padding: 0px;
}
li {
  width: 100px;
  list-style-type: none;
  float: left;
  text-align: center;
  position: relative;
}
.other a:hover {
  color: #487a6f;
  
}
</style>