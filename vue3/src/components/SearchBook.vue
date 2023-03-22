<template>
  <!-- <div class="headerSearch">
      <input type="search" v-model.trim="keyword">
      <button @click="MainSearch(keyword)"><img id="logo" src="../assets/images/搜索.png" alt=""></button>
  </div> -->
  <div>
    <HeaderAll></HeaderAll>
  </div>
    <div id="classifytab1">
      <div id="font">
        <span>全部 </span>   
        <span>  > </span>
        <span style="color:red"> 世说新语 </span>
        <span>共</span>
        <span style="color:red">34800</span>
        <span>件商品</span>
      </div>
    </div>
<!-- 搜索条 -->
    <div id="classifytab3">
      <div id="classifytab3-1">
          <el-pagination 
          background layout="prev, pager, next" 
          :total="20" 
          :current-page="currentPage"
          :page-sizes="[3,5,10,15]"
          :page-size="query.limit"
          :pager-count="query.pages"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          />
      </div>
    </div>
<!-- 搜索的书籍 -->
 <div id="classifytab4-1">
   <div id="classifytab4-1-0">
      <div class="classifytab4-1-1" v-for="book in books" :key="book.id">
           <div id="tab4-1">
             <img :src="book.pic">
        </div>
         <div id="tab4-2">
           <div id="title">
             <span><a href="#">{{book.title}}</a></span>
           </div>
           <div id="price">
              <span id="price1">{{book.price}}</span>
              <span id="discount">{{book.discount}}</span>
           </div>
           <div id="author">
             <span>{{book.author}}</span>
           </div>
           <div id="comment">
             <div id="pic">
               <span style="width: 75px"></span>
              <!-- <img src="../assets/images/star.png" style="  width: 60px;height: 20px;margin-top: 5px;"> -->
             </div>
             <div id="com">
                <span>{{book.comment}}</span>
             </div>
           </div>
           <div id="detail">
              <span id="de">{{book.detail}}</span>
           </div>
           <div id="bu">
             <div id="bu1">
                <button id="bu1-1" @click="insertbook(book.id)">加入购物车</button>
             </div>
             <div id="bu2">
                <button id="bu2-2">收藏</button>
             </div>
           </div>
        </div>
      </div>
   </div>
<!-- 推广商品 -->
<div id="classifytab4-1-2" >
        <div id="tg">
            <span id="tg1">推广商品</span>
        </div>
        <div class="tg-all" v-for="ad in adver" :key="ad.id">
           <div id="tab-pic">
              <img :src="ad.pic2">

            </div>
            <div id="tab-de">
                <span id="tab-de-1">{{ad.de2}}</span>
            </div>
              <div id="tab-price">
                  <span id="pricede">{{ad.price2}}</span>
            </div>
              <div id="tab-price1">
                  <span id="pricedis">{{ad.discount2}}</span>
            </div>
        </div>
      </div>
   </div>
   <div>
      <Footer/>
   </div>
</template>
<script>
import jsCookie from 'js-cookie';
import Footer from './Footer.vue';
import HeaderAll from './HeaderAll.vue';
export default {
    data(){
      return{
        books:[],
        adver:[],
        keyword:'',
        allMsg:[],
        total:0,
        query:{
          limit:5,  //每页显示五条数据
          page:1,
          pages:0,
        },
        a:''
      };
    },
    components:{
      HeaderAll,
      Footer
    },
    mounted(){
        this.searchall()   //打开页面就先显示所有的图书，下面相同
        this.search()
        this.keyword =jsCookie.get('keyword')
        // this.mainSearch()
    },

    methods:{
      insertbook(id){
          this.bid = id
              this.cid = '5'
              this.imgURL = this.books[this.bid].pic
              this.info = this.books[this.bid].title
              this.price = '18'
              // this.price = pathis.books[this.bid].price
              this.count = '1'
              this.total =this.price
              // this.total = this.books[this.bid].price
              this.checkok = '0'
              console.log(this.cid,this.checkok,this.imgURL,this.info,this.price,this.count,this.total)
              this.axios.get("/addtocart",{
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
          },
      //设置每页展示几个数据
      handleSizeChange(val){
        this.query.page = 1;
        this.query.limit = val;
        this.searchall(this.keyword);
        console.log(`每页${val}条`);
      },
      //当前在第几页
      handleCurrentChange(val){
        this.query.page = val;
        this.searchall(this.keyword);
        console.log(`当前页:${val}`);
      },
      //全部的书籍
      searchall(){
          const that=this
          this.axios.get('/seacherbooks',{
            params:{page:that.query.page,limit:that.query.limit},
          })
                .then(function(response){
                that.allMsg=response.data.data.list;
                that.total= response.data.data.total;
                that.query.limit = response.data.data.limit;
                that.query.page = response.data.data.page;
                that.query.pages = response.data.data.pages;
                that.books=that.allMsg
                // console.log("全部数据1",that.allMsg,that.total)
                }).then(()=>{
                  this.mainSearch()
                })
      },
      //推广广告中所有的数据
      search(){
        const that=this
        this.axios.get('/seacherTg')
                .then(function(response){
                that.adver=response.data
                
                })
      },
      // 获得输入的关键字，然后使用正则去查询是否有这个关键字的书籍
      mainSearch(){
        const that = this;
        this.books=[]
          if (this.keyword != "") {
            let queryStringArr = this.keyword.split("");
            let str = "(.*?)";
            let regStr = str + queryStringArr.join(str) + str;
            let reg = RegExp(regStr, "i"); // 以mh为例生成的正则表达式为/(.*?)m(.*?)h(.*?)/i
            that.allMsg.map((book) => {
              if (reg.test(book.title)) {
                that.books.push(book);
              }
            });
      
          }
      },
      MainSearch(wd){ 
          const that = this;
          console.log('----------');
          console.log('wd:'+wd);
          console.log('----------');
          that.keyword = wd;
          if (wd != "") {
            console.log("有关键字", that.keyword);
            let queryStringArr = wd.split("");
            let str = "(.*?)";
            that.books = [];
            let regStr = str + queryStringArr.join(str) + str;
            let reg = RegExp(regStr, "i"); // 以mh为例生成的正则表达式为/(.*?)m(.*?)h(.*?)/i
            that.allMsg.map((book) => {
              if (reg.test(book.title)) {
                that.books.push(book);
              }
            })
            this.keyword = '';
          }else{
            this.searchall()
          }
      }

    }
}
</script>
<style scoped>
#pic span{
  background: url(../assets/images/star.png) repeat-x;
    height: 16px;
    line-height: 16px;
    display: inline-block;
    font-size: 0;
    margin:7px 5px 0px 0px;
}
  #font2{
    float: left;
    margin-top: 5px;
  }
   #classify2{
    width: 1200px;
    height: 40px;
    margin: auto;
  }
  
  #classifytab1{
    width: 1200px;
    height: 40px;
    margin: auto;
    background-color: #F5F5F5;
  }
  #classifytab3{
    width: 1200px;
    height: 40px;
    margin: auto;
    margin-top: 10px;
    margin-bottom: 10px;
  }
  #classifytab3-1{
    width: 400px;
    height: 35px;
    float: left;
    margin-top:5px;
  }
  #classifytab4-1{
    width: 1200px;
    height: 1200px;
    margin: auto;
  }
  #classifytab4-1-0{
    height: 1200px;
    width:950px;
    float: left;
  }
  .classifytab4-1-1{
    margin: 10px 0px;
    padding: 20px 0px;
    border-bottom: 1px solid #ebebeb;
    background-color: #fafafa;
    height: 250px;
    width:950px;
    float: left;
  }
  #classifytab4-1-2{
    height: 1200px;
    width:220px;
    float: left;
    margin-left:30px ;
    
  }
  #tab4-1{
    width: 200px;
    height: 200px;
    margin: auto;
    float: left;
    /* margin-left: 10px; */
  }
  .tg-all{
    width: 220px;
    height: 260px;
    margin: auto;
    float: left;
    /* margin-left: 10px;*/ 
  } 
  #tg{
    width: 220px;
    height: 30px;
    float: left;
    text-align:left;
    background: #f5f5f5 no-repeat 185px 10px;
  }
  #tg1{
    font-weight:bold;
  }
  #tab-pic{
    width: 220px;
    height: 200px;
    float: left;
  }
  /* #tab-pic img{
    width: 250px;
    height: 120px;
  } */
  #tab-de{
    width: 220px;
    height: 30px;
    float: left;
  }
  #tab-de-1{
    font-size:12px ;
  }
  #tab-price{
    width: 70px;
    height: 25px;
    float: left;
  }
  #pricede{
    font: bold 14px arial,'Hiragino Sans GB',"Simsun";
    color: #fa5000;
    overflow: hidden;
    margin-right: 10px;
  }
  #pricedis{
    color: #969696;
    text-decoration: line-through;
    font: normal normal 12px arial,'Hiragino Sans GB',"Simsun";
}
  #tab-price1{
    width: 85px;
    height: 25px;
    float: left;
  }

  #font{
    text-align: center;
    /* border: 1px solid red; */
    float: left;
    line-height: 40px;
    font-size: 13px;
    display: block;
    margin-left: 20px;
  }
#cla1{
    height: 40px;
    width: 140px;
    background-color: red;
    float: left;
    text-align: center;
    line-height: 40px;
}
#ft{
  color:#fff;
  font-weight:bold;   
}
#cla2{
    height: 40px;
    width: 140px;
    background-color: red;
    float: right;
}




#title{
  float: left;
  height: 30px;
  width: 700px;
  text-align:left
}
#title a{
  text-decoration: none;
  font-size: 13.5px;
}
#price{
  float: left;
  height: 30px;
  width: 700px;
    text-align:left
}
#price1{
  color: #ff2832;
  font-size: 18px;
  font-weight:bold;
  height: 20px;
  width: 70px;
  float: left;
  margin-top: 5px;
  /* margin-left: 15px; */
  line-height: 20px;
  text-align:left
}
#discount{
  font-size: 12px;
  color: #969696;
  margin-top: 5px;
  height: 20px;
  width: 140px;
  float: left;
  line-height: 20px;
  text-align:left;
  text-decoration: line-through;
  font: normal normal 12px arial,'Hiragino Sans GB',"Simsun";
}
#author{
  float: left;
  font-size: 12px;
  color: #969696;
  height: 25px;
  width: 700px;
  text-align:left
}

#comment{
  float: left;
  height: 30px;
  width: 700px;
  text-align:left
}
#pic{
  float: left;
  height: 30px;
  width: 65px;
}
#com{
  height: 30px;
  width: 100px;
  font-size: 13px;
  margin-top: 5px;
  margin-left: 20px;
  float: left;
  line-height: 20px;
  text-align:left
}
#detail{
  float: left;
  height: 40px;
  width: 700px;
  text-align:left
}
#de{
  font-size: 13px;
}
#bu{
   float: left;
  height: 34px;
  width: 700px;
  text-align:left
}
#bu1{
  float: left;
  height: 30px;
  width: 100px;

}
#bu1-1{
   height: 35px;
  width: 100px;
  color: #ffffff;
  background-color: #ff2832;
  border-radius: 4px;
}
#bu2{
  float: left;
  height: 30px;
  width:82px;
}

#bu2-2{
   height: 35px;
  width: 82px;
  color: #ff2832;
  background-color: #FFEDEE;
  margin-left: 10px;
  border-radius: 4px;
}


/*  */


.headerSearch {
    display: inline-block; 
    position: relative;
}
.headerSearch input {
    width: 600px;
    height: 40px;
    background-color: #fff;
    outline: none;
    border-top: none;
    border-left: none;
    border-bottom-color:red;
    border-radius: 5px;
}

.headerSearch button{
    position: absolute;
    right: 0px;
    top: 0;
    width: 60px;
    height: 40px;
    margin: 0;
    border: none;
    color: white;
    background-color: red;
    cursor: pointer;
    border-top-right-radius: 5px;
    border-bottom-right-radius: 5px;
    }
#logo{
    width: 25px;
}

</style>