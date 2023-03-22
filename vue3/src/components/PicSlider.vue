<template>
  <!-- 图片轮播功能 -->
  <el-carousel indicator-position="outside">
    <el-carousel-item v-for="item in items" :key="item">
      <img :src="item.img" alt="">
    </el-carousel-item>
  </el-carousel>
</template>
<script>
export default {
  components: {
  },
  data(){
    return{
        items:[
        {img:require('@/assets/images/73cea82c9b55c694.png')},
        { img: require('@/assets/images/4fd30f960303f495.png') },
        { img: require('@/assets/images/024a1770794985d6.png') },
        // https://img63.ddimg.cn/2022/11/30/202211301633165620.jpg
        { img: require('@/assets/images/605d3960908f86f2.png') },
        { img: require('@/assets/images/a9bcfd6ebc066eab.png') }
        // http://img63.ddimg.cn/ddreader/dangebook/207dk750x315.jpg
        ]
    }
  }
}
</script>
<style scoped>
  .el-carousel__item  {
    font-size: 18px;
    line-height: 300px;
    margin: 0;
  }
  .el-carousel__item img{
    margin-left:75px ;
    width: 850px;
    height: 300px;
  }
  .el-carousel{
    width: 990px;
    height: 340px;
    
  }

</style>