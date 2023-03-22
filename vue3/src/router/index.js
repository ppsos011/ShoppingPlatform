import { createRouter, createWebHashHistory } from 'vue-router'
// import HomePage from '@/views/HomePage.vue'
import PersonalInfo from '@/views/PersonalInfo.vue'
import PersonalData from '@/components/PersonalData.vue'
import ShopAddress from '@/components/ShopAddress.vue'
import Login from '@/components/Login.vue'
import SearchBook from '@/components/SearchBook.vue'
import HomePage from '@/views/HomePage.vue'
import Register from '@/components/Register.vue'
import ShoppingCart  from '@/components/ShoppingCart.vue'
import BookXQ from '@/components/BookXQ.vue'
import ConfirmOrder from '@/components/ConfirmOrder.vue'
import PaymyOrder from '@/components/PaymyOrder.vue'
const routes = [
  {
    path:'/',
    name:'登录',
    component:Login,
    meta:{
      title:'登录'
    }
  },
  {
    path:'/register',
    name:'注册',
    component:Register,
    meta:{
      title:'注册'
    }
  },
  {
    path:'/searchbook',
    name:'搜索',
    component:SearchBook,
    meta:{
      title:'搜索'
    }
  },
  {
    path:'/cart',
    name:'购物车',
    component:ShoppingCart,
    meta:{
      title:'购物车'
    }
  },
  {
    path:'/confirmorder',
    name:'结算订单',
    component:ConfirmOrder,
    meta:{
      title:'结算订单'
    }
  },
  {
    path:'/paymyorder',
    name:'我的订单',
    component:PaymyOrder,
    meta:{
      title:'我的订单'
    }
  },
  {
    path:'/bookxq',
    name:'图书详情',
    component:BookXQ,
    meta:{
      title:'图书详情'
    }
  },
  {
    path:'/homepage',
    name:'主页',
    component:HomePage,
    meta:{
      title:'主页'
    },
    
  },
  {
    path:'/personalinfo',
    component:PersonalInfo,
    meta:{
      title:'个人信息'
    },
    children:[
    {
      path:'',
      component:PersonalData, 
    },
    {
      path:'/address',
      name:'address',
      component:ShopAddress, 
    }
  ]
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
