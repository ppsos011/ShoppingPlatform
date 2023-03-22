<template>
    <div id="bottomAll">
      <div id="img2"><img src="@/assets/images/今日特惠.png" ></div>
      <div id="inland">
        <div>
          <div id="left"><Menu/></div>
          <div id="middle"><BotMiddle/></div>
        </div>
        <div id="tui"> 
          <RecomendBook/>
        </div>
      </div>
      <div id="footer">
        <Footer/>
      </div>
    </div>
</template>
<script>
import Menu from './Menu.vue';
import BotMiddle from './BotMiddle.vue';
import RecomendBook from './RecomendBook.vue';
import Footer from './Footer.vue';
  export default {
    components: {
      Menu,
      BotMiddle,
      RecomendBook,
      Footer
    },
  }
  </script>
  <style scoped>
  #bottomAll{
    width: 100%;
    overflow: hidden;
    
  }
  #footer{
    width: 100%;
    height: 200px;
    border-top: 1px solid#ebebeb;;
  }
  #menu2{
  width: 100%;
  height: 30px;
  background-color: #f5f5f5;
  text-align: center;
}
#img2 img{
    width: 1200px;
    height: 75px;
  }
  #img2{
    width: 1200px;
    height: 65px;
    margin:10px auto 20px ;
  }
   #inland{
    width: 1200px;
    margin: auto;
    height: 1100px;
  }
  #left{
    float: left;
    width: 200px;
    height: 630px;
  }
  #middle{
    float: left;
    width: 990px;
    height: 630px;
    margin-left:10px;
  }
  #right{
    float: left;
    width: 228px;
    height: 600px;
  }
  #tui{
    width: 1200px;
    height: 400px;
    border-bottom:2px solid #487a6f ;
    float: left;
  }
  </style>