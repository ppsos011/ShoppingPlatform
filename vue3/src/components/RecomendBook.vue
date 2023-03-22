<template>
    <div>
        <div style="width:100%;height: 65px;border-bottom:2px solid #487a6f ;">
            <img src="../assets/images/猜你喜欢.png" alt="" style="margin:10px 0px 0px;height: 40px">
        </div>
    </div>
    <div id="home_ui" >
        <div class="content" ref="wrapper">
            <div class="booksNew">
                <div  class="book" v-for="(item, index) in datacontent" :key="index" style="margin: 20px;float: left;">
                    <div>
                        <router-link :to="'/' + item.id">
                            <img :src="item.imgUrl" :alt="item.title">
                            <p id="p1">{{ item.title }}</p>
                            <p id="p2">{{ item.author }}</p>
                            <p id="p3">{{ item.style }}</p>
                        </router-link>
                    </div>
                    <p id="p4">
                        {{ item.price }} 
                        <span id="book_price">{{ item.discount }}</span>
                    </p>
                </div>
            </div>
            <div class="button">
                <el-button @click="change" style="margin-top:-32px ;margin-left:35px ;">换一批</el-button>
            </div>
        </div>
    </div>
  </template>
<script>
import jsCookie from 'js-cookie';

export default{
    data () {
      return {
        BookData:[], // 放了10个对象
        PersonData:[],
        datacontent: [], // 用来存放每次点击换一批出来的三个对象
        personcontent:[],//用来存放当前登录用户的信息
        num2: '', // 用来放三个随机数
        arr: [], // 用来放三个随机数的数组，用来循环
        id:''
      }
    },
    created(){
      this.getUserName()
      console.log("this.id:"+this.id)
    },
    mounted(){
      if(this.id==""){
        this.searchBook()
        console.log("退出")
      }else{
        this.searchPerson()
        this.searchBook()
        console.log("登录")
      }
        
        
    },
    methods: {
      getUserName(){
        this.id = jsCookie.get('username')
      },
        searchBook(){//取出全部的推荐图书
            const that=this
            this.axios.get('/recomendbook')
                    .then(function(response){
                    that.BookData=response.data
                    }).then(()=>{// 页面一加载的时候先出来五个对象的内容
                      let j=0
                      for (var i = 0; i < this.BookData.length; i++) {
                        if(this.id==""){//当前未登录用户
                          this.datacontent.push(this.BookData[i])
                          console.log(this.id+'页面一加载：退出')
                          j=j+1
                          if(j>4){break}
                        }
                        if(this.id==this.personcontent[4]){
                          if(this.personcontent[3]=='学生'){
                            console.log('职业:'+this.personcontent[3]+'----是学生')
                            console.log(this.BookData[i].author +'  '+this.personcontent[2]+'  '+this.BookData[i].style+'  '+this.personcontent[1]+'  '+this.BookData[i].discount)
                            if(this.BookData[i].author == this.personcontent[2] || this.BookData[i].style == this.personcontent[1] || this.BookData[i].discount!=null){//取出喜欢相同作者、相同的类型和没折的
                              this.datacontent.push(this.BookData[i])
                              console.log('页面一加载：登录----是学生')
                              console.log('-------------------------------')
                              j=j+1
                            }
                            if(j>4){break}
                          }
                          if(this.personcontent[3]!='学生')
                          {
                            console.log('职业:'+this.personcontent[3]+'----不是学生'+this.personcontent[2]+this.personcontent[1]+this.BookData[i].author+this.BookData[i].style)
                            if(this.BookData[i].author == this.personcontent[2] || this.BookData[i].style == this.personcontent[1]){//判断是否和作者或喜好相同
                              this.datacontent.push(this.BookData[i])
                              console.log('页面一加载：登录----不是学生')
                              j=j+1
                            }
                            if(j>4){break}
                          }
                        }
                      }
                    })
        },
        searchPerson(){//取出所有用户的个人信息
            const that=this
            this.axios.get("/getAllPerson")
                .then(function(response){
                that.PersonData=response.data  
                }).then(()=>{// 页面一加载的时候先出来三个对象的内容
                    for (var i = 0; i < this.PersonData.length; i++) {
                        if(this.PersonData[i].id == this.id){//得到当前用户的个人信息
                          this.personcontent.push(this.PersonData[i].fullAddress)//取出目前登录用户的地址
                          this.personcontent.push(this.PersonData[i].favor)//取出目前登录喜欢的类型
                          this.personcontent.push(this.PersonData[i].favorAuthor)//取出目前登录用户喜欢的作者
                          this.personcontent.push(this.PersonData[i].role)//取出目前登录用户的职业
                          this.personcontent.push(this.PersonData[i].id)//取出目前登录用户的职业
                          // console.log(this.PersonData[i].role)
                          console.log(this.id+this.personcontent[4]+"   "+this.PersonData[i].fullAddress+"   "+this.PersonData[i].favor+"   "+this.PersonData[i].favorAuthor+"   "+this.PersonData[i].role)
                          
                          console.log("结束")
                          // console.log('fullAddress:'+this.personcontent.fullAddress+'favor:'+this.personcontent.favor+'favorAuthor:'+this.personcontent.favorAuthor)
                        }
                      }
                    })                  
        },
        change () { //每次点击换一批触发这个方法
            this.a=1
            this.num2 =''
            this.arr = []
            this.datacontent = [] // 每次点击换一批就让之前的数据全清空
            while(this.arr.length < 5){ // 用while来判断是否循环三次
                let num = parseInt(Math.random() * this.BookData.length) // 随机出四个0-BookData长度之间的随机数   parseInt取正，小数点后面的数字全部抹掉  Math.random() 0-1的随机数
                if (this.arr.indexOf(num) == -1) { // 获得不重复的四个数  this.arr.indexOf(num)若等于-1则证明arr这个数组里没有num这个随机数，因此可以放进这个数组里面
                  this.num2 = num
                  if(this.id==""){
                    this.datacontent.push(this.BookData[num]) // 将随机数当作下标来便利data里的内容
                    this.arr.push(num)
                    console.log(this.id+'刷新：退出')
                  }else{
                    if(this.id==this.personcontent[4]){
                      if(this.personcontent[3]=='学生'){
                        if(this.BookData[num].author == this.personcontent[2] || this.BookData[num].style == this.personcontent[1] || this.BookData[num].discount!=null){//判断是否和作者或喜好相同
                          this.datacontent.push(this.BookData[num]) // 将随机数当作下标来便利data里的内容
                          this.arr.push(num)
                          console.log(this.id+'刷新：登录')
                          // console.log('第'+this.a+'循环'+'  num:'+num+'   长度：'+this.datacontent.length)
                        }
                      }
                      if(this.personcontent[3]!='学生'){
                        if(this.BookData[num].author == this.personcontent[2] || this.BookData[num].style == this.personcontent[num]){//判断是否和作者或喜好相同
                          this.datacontent.push(this.BookData[num])
                          this.arr.push(num)
                          console.log(this.id+'刷新：登录')
                        }
                      }
                    }
                  }
                }
        }   
      }
    }

}
</script>  
<style scoped>    
.booksNew{
    width:1105px ;
    float: left;
    
  }
  .button{
    float: left;
    padding: 0px;
    margin-left:-25px;
    margin-top: 150px;
  }
  .booksNew .book{
    display: inline-block;
    width: 180px;
    text-align: center;
  }
  #new_book{
    width: 990px;
    height: 40px;
  }
  a{
    text-decoration: none;
    color: #aaaaaa;
    font-size: 10px;
  }
  p{
    overflow: hidden;
    height: 18px;
  }
  .booksNew a:hover{
    color: red;
  }
  .booksNew img {
    width: 150px;
    height: 150px;
    margin: 0px;
    padding: 0px;
  }
  #p4{
    color: red;
    font-weight: 700;
    font-family: poppins;
  }
  #book_price{
    color: black;
    text-decoration: line-through;
  }
</style>