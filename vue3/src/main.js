import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import axios from 'axios'
import VueAxios from 'vue-axios'
import VDistpicker from 'v-distpicker'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

router.beforeEach((to, from, next) => {
    /* 路由发生变化修改页面title */
    if (to.meta.title) {
      document.title = to.meta.title
    }
    next()
  })
  
axios.defaults.baseURL="/api"
createApp(App).use(router).use(VueAxios,axios).use(ElementPlus).use(VDistpicker).mount('#app')

const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

