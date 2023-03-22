<template>

<div class="headerr">
  <HeaderAll></HeaderAll>
</div>
<div class="middle">
  <el-container >
      <el-aside width="300px">
        <div class="pic">
          <el-carousel :interval="5000" arrow="outside" height="400px">
            <el-carousel-item v-for="jojo in booksdata" :key="jojo">
              <h3 text="2xl" justify="center"><img :src="jojo.book_img" alt="" style="height:300px;margin-top:40px;"></h3>
            </el-carousel-item>
          </el-carousel>
        </div>
        <div class="pic1">
          <svg class="pic11" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-029747aa=""><path fill="currentColor" d="M352 480h320a32 32 0 1 1 0 64H352a32 32 0 0 1 0-64z"></path><path fill="currentColor" d="M480 672V352a32 32 0 1 1 64 0v320a32 32 0 0 1-64 0z"></path><path fill="currentColor" d="M512 896a384 384 0 1 0 0-768 384 384 0 0 0 0 768zm0 64a448 448 0 1 1 0-896 448 448 0 0 1 0 896z"></path></svg>
          <p class="pic12"><a href="#" class="pic13" >分享</a></p>
          <svg class="pic11"  viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-029747aa=""><path fill="currentColor" d="m161.92 580.736 29.888 58.88C171.328 659.776 160 681.728 160 704c0 82.304 155.328 160 352 160s352-77.696 352-160c0-22.272-11.392-44.16-31.808-64.32l30.464-58.432C903.936 615.808 928 657.664 928 704c0 129.728-188.544 224-416 224S96 833.728 96 704c0-46.592 24.32-88.576 65.92-123.264z"></path><path fill="currentColor" d="m161.92 388.736 29.888 58.88C171.328 467.84 160 489.792 160 512c0 82.304 155.328 160 352 160s352-77.696 352-160c0-22.272-11.392-44.16-31.808-64.32l30.464-58.432C903.936 423.808 928 465.664 928 512c0 129.728-188.544 224-416 224S96 641.728 96 512c0-46.592 24.32-88.576 65.92-123.264z"></path><path fill="currentColor" d="M512 544c-227.456 0-416-94.272-416-224S284.544 96 512 96s416 94.272 416 224-188.544 224-416 224zm0-64c196.672 0 352-77.696 352-160S708.672 160 512 160s-352 77.696-352 160 155.328 160 352 160z"></path></svg>
          <p class="pic12"><a href="#" class="pic13" >送秃鸡币2</a></p>
          <svg class="pic11" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-029747aa=""><path fill="currentColor" d="m512 747.84 228.16 119.936a6.4 6.4 0 0 0 9.28-6.72l-43.52-254.08 184.512-179.904a6.4 6.4 0 0 0-3.52-10.88l-255.104-37.12L517.76 147.904a6.4 6.4 0 0 0-11.52 0L392.192 379.072l-255.104 37.12a6.4 6.4 0 0 0-3.52 10.88L318.08 606.976l-43.584 254.08a6.4 6.4 0 0 0 9.28 6.72L512 747.84zM313.6 924.48a70.4 70.4 0 0 1-102.144-74.24l37.888-220.928L88.96 472.96A70.4 70.4 0 0 1 128 352.896l221.76-32.256 99.2-200.96a70.4 70.4 0 0 1 126.208 0l99.2 200.96 221.824 32.256a70.4 70.4 0 0 1 39.04 120.064L774.72 629.376l37.888 220.928a70.4 70.4 0 0 1-102.144 74.24L512 820.096l-198.4 104.32z"></path></svg>
          <p class="pic12"><a href="#" class="pic13" >收藏商品</a></p>
        </div>
      </el-aside>
      <div class="hf" v-for="jojo in booksdata" :key="jojo">
        <el-header style="height: 180px;">
          <img src="http://product.dangdang.com/images/icon_ddzy.png" alt="" class="ziying" style="margin-top:5px">
          <p class="bookname1">{{jojo.book_name}}</p>
          <div class="bookd">
            <p class="bookname2">{{jojo.book_detailed}}</p>
          </div>
          <div class="bookd2">
            <p class="bookname3">作者:{{jojo.book_writer}}  </p> 
            <p class="bookname3">出版社:{{jojo.book_press}} </p>
            <p class="bookname3">出版时间:{{jojo.book_time}} </p>
          </div>
        </el-header>
        <el-main style="padding-top: 0px;">
          <div class="bookp">
            <p class="bookp1">商品价格</p>
            <p class="bookp￥">￥</p>
            <p class="bookp2">{{jojo.book_price}}</p>
            <p class="bookp3">定价{{jojo.book_price+5}}</p> 
          </div>
        </el-main>
        <el-footer style="height: 100px;">
          <div class="addCart">
            <div class="addSubtractButton">
              <el-button @click="handleSubtract" 
                  :class="{disabled: quantity === 0, actived: quantity > 0}" 
                  href="javascript:;">-</el-button>
                  <input v-model="quantity" type="number">
              <el-button href="javascript:;" @click="handleAdd">+</el-button>
            </div>
        <p><el-button size="large" class="addCartButton"  @click="insertbook(jojo.id)">加入购物车</el-button></p>
      </div>
        </el-footer>
      </div>
    </el-container>
</div>
    
<div class="footerr"></div>
  <div class="footpl">
    <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
    <el-tab-pane label="商品详情" name="first">
      <div class="detailed" v-for="jojo in detaileds" :key="jojo">
        <p class="font-detailed">开本：{{jojo.kaiben}}</p>
        <p class="font-detailed">纸张：{{jojo.paper}}</p>
        <p class="font-detailed">包装：{{jojo.baozhuang}}</p>
        <p class="font-detailed">是否套装：{{jojo.taozhuang}}</p>
        <p class="font-detailed">国际标准书号ISBN:{{jojo.isbn}}</p>
      </div>
       <div class="deimg" v-for="jojo in booksdata" :key="jojo">
        <p><el-divider content-position="left" ></el-divider></p>
        <img :src="jojo.book_deimg" alt="" style="">
        </div>
      </el-tab-pane>
    <el-tab-pane label="商品评论" name="second">
      <div class="wenda"><p style="margin-top:0px;">短评</p>
      </div>
      <div class="pinlun" v-for="jojo in bookc" :key="jojo">
        <div><p class="pinlunl"> <el-rate disabled disabled-void-color="#ff9900" style="float:left;"/></p>
        <p  style="float:left;margin:0px;margin-top:5px;color:#ff9900">{{jojo.user_grade}}</p>
        </div>
        <div style="float:right"><img src="http://img7x8.ddimg.cn/imghead/87/5/2579695326438-1_o.png" alt="" style="width:50px;margin-right:20px;"></div>
        <div style="float:right;margin-right:35px;"><p>{{jojo.user_name}}</p></div>
        <div ><p class="pinlunl" style="margin:0px;margin-top:20px;color:#ff9900">分</p></div> 
        
         <div ><p class="pinlunl">{{jojo.user_comment}}</p></div>
         <div><p style="float:right;margin-right:10px;color:#ff9900;margin-top:0px;">黄金用户</p></div> 
         <div ><p class="pinlunl">{{jojo.user_ctime}}</p></div>
         
        
      </div>
      
    </el-tab-pane>
    <el-tab-pane label="商品问答(0)" name="third">
      <div class="wenda"><p style="margin-top:0px;">商品问答(0)</p>
      <p style="float:left;">目前没有回答</p></div>
    </el-tab-pane>

  </el-tabs></div>
  <Footer style="margin-top:20px"></Footer>
</template>
<script>
import HeaderAll from './HeaderAll.vue'
import Footer from './Footer.vue'
  // import AddSubtractButton from './AddSubtractButtonjojo'
export default{
  data(){
    return{
      booksdata:[],
      detaileds:[],
      bookc:[],
      book_id:'',
      quantity: 0,
      imgUrl:'',
      name:'',
      bprice:'',
      id:''
    }
  },
  components:{
    // AddSubtractButton,
    HeaderAll,
    Footer
  },
  mounted(){
    const that = this
    that.book_id =this.$route.query.bbid
    // 接受bbid的参数，并将他赋给book_id
    // 像后端发送book_id的参数，让后端向数据库执行只接受有关book_id的全部字段并将他返回给前端
    this.axios.get('/bid',{
      params:{
        key1:this.book_id
      }
    })
    .then(function(response){
      that.booksdata = response.data;
    }),
    
    that.book_id =this.$route.query.bbid
    this.axios.get('/did',{
      params:{
        key1:this.book_id
      }
    })
    .then(function(response){
      that.detaileds = response.data;
    }),
     that.book_id =this.$route.query.bbid
    this.axios.get('/cid',{
      params:{
        key1:this.book_id
      }
    })
    .then(function(response){
      that.bookc = response.data;
    })
  },
  methods:{
    handleAdd(){
        this.quantity++;
        this.$emit("update-quantity", this.quantity);
      },
      handleSubtract(){
        this.quantity--;
        this.$emit("update-quantity", this.quantity);
      },
    insertbook(id){
      this.bid = id-1
      console.log('id'+id)
      console.log('this.bid'+this.bid)
        
        for(var i=0;i<this.booksdata.length;i++){
          console.log(this.booksdata[i].book_name)
          this.name=this.booksdata[i].book_name
          this.imgUrl=this.booksdata[i].book_img
          this.bprice=this.booksdata[i].book_price
          this.id=this.booksdata[i].id
        }
        this.imgURL = this.imgUrl
        this.info = this.name
        // console.log(this.booksdata[this.bid].book_name)
        // this.price = '18'
        this.cid =this.id
        this.price = this.bprice
        this.count = this.quantity
        this.total =this.price
        // this.total = this.books[this.bid].price
        this.checkok = '0'
        console.log(this.cid,this.checkok,this.info,this.price,this.count,this.total)
        this.axios.get("/addtocartd",{
            params:{
                key0:this.cid,
                key1:this.checkok,
                key2:this.imgURL,
                key3:this.info,
                key4:this.price,
                key5:this.count,
                key6:this.total,
                }
  })
  .then(()=>{
    
      window.alert("添加成功");
    
  })
}
  }
}
</script>

<style scoped>
body{
  background-color: #fbfbfb;
}
  .el-header {
    
    color: #333;
    margin-right:150px; 
    
  }
  .el-footer {
    background-color: #fbfbfb;
    color: #333;
    margin-right:150px; 
    
    text-align: center;
    }

  .bookname1{
    padding: 0px;
    margin: 0px;
    font-weight: bolder;
    font-size: 20px;
    
  }
  .headerr{
    width: 100%;

    
  }
  .middle{
    margin-top: 20px;
  }
  .footerr
  {
    background-color: #66686b;
    color: #333;
    text-align: center;
    line-height: 500px;
    margin-right:150px;
     margin-left:150px;
     
  }
  .el-aside {
    background-color: #fbfbfb;
    color: #333;
    
    margin-left:150px;
  }
  
  .el-main {
    background-color: #fbfbfb;
    color: #333;
    margin-right:150px;
    
    height: 150px;
  }
  
 
  .ziying{
    float: left;
    margin: 0px;
    padding: 0px;
  }
  .bookd{
    height: 70px;
    margin: 0px;
  }
   .bookname2{
    font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    font-size: 18px;
    margin-top: 3px;
  }
  .bookd2{
    height: 30px;
    margin-top :3px;
    border-top: 1px solid #646464;
  }
  .bookname3{
    font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    font-size: 8px;
    float: left;
    margin-right: 80px;
    
  }
  .bookp{
    height: 80px;
    background-color: rgb(254, 253, 252);
  }
  .bookp1{
    font-size: 14px;
    
    margin-right: 20px;
    font-family:Arial, Helvetica, sans-serif;
    color: #8f8f8f;
    float: left;
    

  }.bookp2{
    margin: 0px;
    margin-left :8px;
    font-size: 28px;
    color: #e52222;
    
  }
  .bookp￥{
    margin: 1px;
    margin-top: 15px;
    margin-left :6px;
    font-size: 14px;
    float: left;
    color: red;
    
  }
  .bookp3{

    margin-top: 20px;
    font-size: 8px;
    color: #8f8f8f;
    text-decoration: line-through;
    
  }
  .pic{
    height: 380px;
    
  }
  .pic1{
    height: 20px;
    margin-top: 20px;
    
    display: flex;
    
  }
  .pic11{
    margin: 1px ;
    margin-right: 3px; 
    height: 16px;
    color: rgb(124, 117, 117);
  }
  
  .pic12{
    margin: 0px;
    font-size: 13px;
    margin-right: 30px;
    
  }
  .pic13{
    color: rgb(124, 117, 117);
    text-decoration:none;
  }


  
  .el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 400px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #fbfbfb;
}
.addCartButton{
  width: 180px;
  height: 50px;
	padding: 5px 10px 6px;
	color: #fff;
	border: none;
  background-color: #487a6f;
  display: block;
  margin-bottom: 50px;
}
.addCartButton:hover {
  text-shadow: 0 1px 1px #444;
}
.addCart {
  
  float: left;
  margin-left: 30px;
  margin-top: 10px;
}
  
.addSubtractButton input{
  height: 32px;
  width: 40px;
  text-align: center;
  border: 1px soild lightgray;
} 
.addSubtractButton button{
  display: inline-block;
  outline: none;
} 


input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
  -webkit-appearance: none !important;
  margin: 0;
  
}
.disabled { 
  pointer-events: none; 
  color: gray; 
  cursor: default;
}
.actived{
  color: black;
}
</style>