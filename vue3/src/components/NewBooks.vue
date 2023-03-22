<template>
  <!-- 新书上市  可切换 -->
  <div id="ap">
    <div class="SwiperBox" >
      <div class="imgBox" :style="{ left: `-${leftVal}px`, transition: `${ition}s` }">
        <!-- 遍历图书 -->
        <div class="imgBoxOut" v-for="(item, index) in imgList" :key="index">
          <!-- <VueV/> -->
          <div v-for="(items, indexs) in item" :key="indexs">
            <!-- <img :src="items.imgUrl" alt=""  /> -->
            <div class="box">
              <div class="slide-img">
                <!-- <img src="../assets/images/29477635-1_l_17.jpg"> -->
                <img :src="items.imgUrl" alt="1">
                <div class="overlay" @click="buy">
                    <router-link :to="{path :'/bookxq', query:{bbid:items.id}}"><a href=" " class="buy-btn" >买它</a></router-link>
                </div>
              </div>
              <!-- 封装图书封面 -->
              <div class="detail-box">
                  <div class="type">
                      <a href="">
                        <p style="overflow:hidden">{{items.title}}</p>
                      </a>
                      <span style="overflow:hidden">{{items.author}}</span>
                  </div>
                  <a href="" class="price">
                    <p>{{items.discount}}</p>
                    <span >{{ items.price }}</span>
                  </a>
              </div>
            </div>
          </div>
        </div>
        <!-- 复制第一张放到最后,以实现无缝无线循环滚动效果 -->
        <div class="imgBoxOut" v-for="(items,indexs) in imgList[0]" :key="indexs">
          <div class="box">
              <div class="slide-img">
                <img :src="items.imgUrl" alt="1">
                <div class="overlay" @click="turnPerson">
                    <a href=" " class="buy-btn" >买它</a>
                </div>
              </div>
              <div class="detail-box">
                  <div class="type">
                      <a href="">
                        <p style="overflow:hidden">{{items.title}}</p>
                      </a>
                      <span style="overflow:hidden">{{items.author}}</span>
                  </div>
                  <a href="" class="price">
                    <p>{{items.discount}}</p>
                    <span id="book_price">{{ items.price }}</span>
                  </a>
              </div>
            </div>
        </div>
      </div>
      
      <!-- 左箭头按钮 -->
      <div class="leftBtn" @click="throttle(PrevFun)">&larr;</div>
      <!-- 右箭头按钮 -->
      <div class="rightBtn" @click="throttle(NextFun)">&rarr;</div>
      <!-- 下方指示点容器 -->
      <div class="instBox">
        <div @click="instFun(index)" v-for="(item, index) in imgList.length" :key="index" :class="['inst', index == imgShow ? 'instActv' : '']" ></div>
      </div>
    </div>
  </div>
  <!-- 弹出完善个人信息对话框 -->
  <el-dialog v-model="dialogVisible" title="Tips" width="30%" :before-close="handleClose" >
        <span>请先填写个人信息</span>
        <template #footer>
        <span class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <router-link to="/personalinfo"><el-button type="primary" @click="turnPerson">确定</el-button></router-link>
        </span>
        </template>
  </el-dialog>
</template>
<script>
export default {
  data() {
    return {
      imgData: [],
      leftVal: 0, // 轮播图盒子的偏移值
      flag: true, // 用来节流防止重复点击j
      start: null, // 自动执行下一张定的时器
      imgWidth: 990, // 在这里填写你需要的图片宽度
      ition: 0.8, // 设置轮播图过度时间
      imgShow: 0, // 表示当前显示的图片索引
      dialogVisible: false,
      form:{
                id:'',
                name:'',
                genda:'',
                level:'',
                depart:'',
                ability:''
            },
    };
  },
  components: {
  },
  mounted() {
    const that=this
    this.axios.get('/book')
              .then(function(response){
              that.imgData=response.data
              })
  },
  computed: {
    imgList() {
      // 数组分割
      let arr = [];
      let num = 4; // 填写需要分割成几个一组的数量
      if (this.imgData.length) {
        for (let i = 0; i < this.imgData.length; i += num) {
          arr.push(this.imgData.slice(i, i + num));
        }
      }
      return arr;
    },
  },
  // mounted() {
  //   this.奥力给(); // 偷偷告诉大家一个小秘密,JavaScript是原生支持中文命名函数或变量的哦
  // },
  methods: {
    buy(){
      // this.dialogVisible=true

    },
    turnPerson() {
      this.dialogVisible=false
    },
    // 这里定义一个鼠标移入移出事件，鼠标悬停时停止自动轮播，鼠标移出则重新执行自动轮播
    // MouseFun(type) {
    //   // 停止定时器            // 重新执行定时器
    //   type == "移入" ? clearTimeout(this.start) : this.奥力给();
    // },
    // // 此为自动轮播定时器
    // 奥力给() {
    //   this.start = setInterval(() => {
    //     this.NextFun();
    //   }, 1500);
    // },
    // 这里通过额外封装的节流函数触发 PrevFun() 和 NextFun(),以达到防止重复点击的效果
    throttle(fun) {
      if (this.flag) {
        this.flag = false;
        fun(); // 此为模板中传递进来的PrevFun()或NextFun()函数
        setTimeout(() => {
          this.flag = true;
        }, 1200); // 节流间隔时间
      }
    },
    // 上一张
    PrevFun() {
      if (this.leftVal == 0) {
        // 判断显示的图片 是 第一张时执行
        // this.imgList.length是指循环图片数组的图片个数
        this.ition = 0; // 将过渡时间变成0，瞬间位移到最后一张图
        this.imgShow = this.imgList.length - 1; // 将高亮小点改为最后一张图
        this.leftVal = this.imgList.length * this.imgWidth; // 瞬间移动
        setTimeout(() => {
          // 通过延时障眼法,归原过渡时间,执行真正的“上一张”函数
          this.ition = 0.8;
          this.leftVal -= this.imgWidth;
        }, this.ition * 1000);
      } else {
        // 判断显示的图片 不是 第一张时执行
        this.ition = 0.8;
        this.leftVal -= this.imgWidth;
        this.imgShow--;
      }
    },
    // 下一张
    NextFun() {
      if (this.leftVal == (this.imgList.length - 1) * this.imgWidth) {
        // 判断显示的图片 是 最后一张时执行
        this.ition = 0.8;
        this.leftVal += this.imgWidth;
        this.imgShow = 0;
        setTimeout(() => {
          this.ition = 0;
          this.leftVal = 0;
        }, this.ition * 1000);
      } else {
        // 判断显示的图片 不是 最后一张时执行
        this.ition = 0.8;
        this.leftVal += this.imgWidth;
        this.imgShow++;
      }
    },
    // 点击小圆点
    instFun(index) {
      this.ition = 0.8;
      this.leftVal = index * this.imgWidth;
      this.imgShow = index;
    },
  },
};
</script>
<style scoped>
/* 图片容器样式 */
p{
  height: 18px;
}
#book_price{
    color: red;
    text-decoration: line-through;
    font-size: 14px;
    margin-left:10px ;
  }
.SwiperBox {
    position: relative;
    width: 990px;
    height: 260px;
    box-sizing: border-box;
    cursor: pointer;
    overflow: hidden;
  }
  .imgBox{
    position: absolute;
    top: 0px;
    left: 0px;
    min-width: 990px;
    height: 240px;
    display: flex;
    justify-content: flex-start;
  }
  /* 图片默认样式 */
  .imgBox .imgBoxOut {
    flex-shrink: 0;
    width: 990px;
    height: 270px;
    display: flex;
    justify-content: space-around;
    align-items: center;
    margin-top:-10px ;
  }
  .imgBox div img{
    width: 150px;
    height: 150px;
  }
   /* 两个按钮共有的样式,也可直接使用箭头图片替代 */
  .leftBtn,
  .rightBtn {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    width: 30px;
    height: 30px;
    display: flex;
    justify-content: center;
    align-items: center;
    background: rgba(109, 109, 109, 0.445);
    color: #fff;
    border-radius: 50%;
    cursor: pointer;
    font-size: 12px;
    font-weight: 500;
  }
  .leftBtn {
    left: 10px;
  }
  .rightBtn {
    right: 10px;
  }
  /* 下方指示器盒子 */
  .instBox{
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    bottom: 10px;
    display: flex;
  }
   /* 小圆点 */
  .inst{
    width: 10px;
    height: 10px;
    border: 1px solid #ccc;
    margin-right: 8px;
    background: #fff;
    border-radius: 50%;
    cursor: pointer;
  }
  .inst:last-child{
    margin-right: 0px;
  }
  .instActv{
    border: 1px solid #ff0000;
    background: #ff0000;
  }

body{
        margin: 0px;
        padding: 0px;
        background-color: #eef8ff;
    }
    a{
        text-decoration: none;
    }
    .box{
        width:150px;
        box-shadow:2px 2px 30px rgba(0,0,0,0.2);
        border-radius: 10px;
        overflow:hidden;
        /* position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%,-50%); */
    }
    .slide-img{
        width: 150px;
        height: 150px;
        position: relative;
    }
    .slide-img img{
        width: 150px;
        height: 150px;
        object-fit: cover;
        box-sizing: border-box;
    }
    .detail-box{
       height: 70px;
        width: 150px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px 20px;
        box-sizing: border-box;
        font-family: calibri;
    }
    .type{
        display: flex;
        flex-direction: column;
    }
    .type a{
        color: #222222;
        /* margin: 5px 0px; */
        font-weight: 400;
        letter-spacing: 0.5px;
        font-size:12px;
        font-family: poppins;
    }
    .type span{
        color:rgba(26,26,26,0.5);
        font-size:12px;
        height: 18px;
    } 
    .price p{
        color: red;
        font-weight: 700;
        font-size:1.1rem;
        font-family: poppins;
        letter-spacing: 0.5px;
    }
    .price span{
        font-size:14px;
        font-family: poppins;
        color: #333333;
        margin:0px 0px 0px 10px ;
        text-decoration: line-through;
    }
    .overlay{
        position: absolute;
        left: 50%;
        top:50% ;
        transform: translate(-50%,-50%);
        width: 50%;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .buy-btn{
        width: 160px;
        height: 40px;
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: #ffffff;
        color: #252525;
        font-weight:700 ;
        letter-spacing: 1px;
        font-family: calibri;
        border-radius: 20px;
        box-shadow: 2px 2px 30px rgba(0,0,0,0.2);
    }
    .buy-btn:hover{
        color: #FFFFFF;
        background-color: #f15fa3;
        transition: all ease 0.3s;
    }
    .overlay{
        visibility: hidden;
    }
    .slide-img:hover .overlay{
        visibility: visible;
        animation: fade 0.5s;
    }
    @keyframes fade{
        0%{
            opacity: 0;
        }
        100%{
            opacity: 1;
        }
    }
</style>
