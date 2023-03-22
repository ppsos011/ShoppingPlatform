<template>
    <!-- 三级菜单 -->
    <div>
      <ul id="main">
        <div id="span" style="border-bottom:1px #487a6f dashed ;">
            <span>图书分类</span>
        </div>
        <div id="major">
            <template v-for="menu in menus" :key="menu.id">
                <div class="dropdown" v-if="menu.level == '1'" >
                    <div class="dropbtn">
                        {{ menu.menu }}
                    </div>
                    <!-- <div class="dropdown-menu">
                        <template v-for="menu1 in menus" :key="menu1.id" >
                            <div class="dropdown-menu1" v-if="menu1.parentId == menu.id " >
                                <a href="#">{{ menu1.menu }}</a>
                            </div>
                        </template>
                    </div> -->
                    <div class="dropdown-content">
                        <template v-for="menu1 in menus" :key="menu1.id" >
                            <div class="line" v-if="menu1.parentId == menu.id " >
                                {{ menu1.menu }}
                                <div class="right">
                                    <template v-for="menu2 in menus" :key="menu2.id">
                                        <div v-if="menu2.parentId == menu1.id" >
                                            <div class="r-r">
                                                <a>{{ menu2.menu }}</a>
                                            </div>
                                        </div>
                                    </template>
                                </div>
                            </div>
                        </template>
                    </div>
                </div>
            </template>
        </div>
      </ul>
    </div>
</template>
<script>
export default {
    data() {
        return {
            menus:[]
        }
    },
    mounted() {
    const that=this
    this.axios.get('/getMenu')
              .then(function(response){
              that.menus=response.data
              })
}
}
</script>
<style>
 * {
        box-sizing: border-box;
    }
    #span{
        text-align: center;
        color: white;
        background-color: #487a6f;
        display: block;
        height: 35px;
        font-size: 20px;
        line-height: 35px;
        border-top-right-radius: 10px;
        border-top-left-radius: 10px;
    }
    #major{
        width: 200px;
        height: 595px;
        border: 2px solid #487a6f;
        border-top:2px #487a6f dashed !important;
    }
    #main {
        list-style-type: none;
        margin: 0;
        padding: 0;
        /* overflow: hidden; */
        float: left;
        
    }
    a :hover{
        color:#ec7814;
    }
    .line{
        width: 500px;
        height: auto;
        font-size: 12px;
        float: left;
        color: #487a6f;
        border-bottom:1px dashed #487a6f;
        margin: 5px ;
        padding: 10px;
    }
    .left{
        width: 80px;
        height: auto;
        float: left;
        text-align: center;
        line-height: 50px;
    }
    .right{
        width: 410px;
        height: auto;
        float: right;
    }
    .r-r{
        height: auto;
        float: left;
        border-right:1px solid black;
        padding: 0px 10px 5px 10px;
    }
    .RM-ul{
        margin: 0px;
        padding: 0px;
        
    }
    .RM-ul li {
        list-style-type: none;
        float: left;
        text-align: center;
        border-right:1px solid black;
        padding: 0px 10px;
        margin: 3px 0px;
    }
    .dropbtn {
        display: inline-block;
        display: block;
        width: 180px;
        padding: 8px 10px;
        text-align: center;
        height: auto;
        color: #487a6f;
        font-weight: bold;
        font-size:14px;
        margin: 3px 6px 0px 6px;
    }
    .dropdown{
        width: 200px;
        height: auto;
        float: left;
        margin-left: -2px;
        border:2px solid transparent;
        /* padding: 0px 0px; */
        position: relative;
    }
    .dropdown:hover{
        border: #487a6f 2px solid;
        border-right: white 2px solid !important;
        
    }
    .dropdown-menu{
        width: 200px;
        height: auto;
    }
    .dropdown-menu1 a{
        float: left;
        padding: 0px 5px 0px 0px; 
        color:#666666;
        font: 12px Arial;
        border-right: #878585 1px solid;
    }
    .dropdown-menu a {
        display: block;
        color: black;
        /* padding: 12px 16px; */
        text-decoration: none;  
    }

    .dropdown-menu a:hover {
        background-color: #f1f1f1
        
    } 
    /* 下拉菜单设置样式 */
    .dropdown-content {
        /* 隐藏菜单 */
        height: auto;
        display: none;
        position: absolute;
        left: 198px;
        top:-2px;
        background-color: white;
        /* 设置链接元素的最小宽度 */
        min-width: 160px;
        box-shadow: 20px 0px 16px 10px rgba(12, 12, 12, 0.2);
        overflow: auto;
        border-top:2px solid #487a6f;
        border-right:2px solid #487a6f;
        border-bottom:2px solid #487a6f;
        z-index:5;
    }
    
    .dropdown-content a {
        display: block;
        color: black;
        /* padding: 12px 16px; */
        text-decoration: none;  
    }

    .dropdown-content a:hover {
        background-color: #f1f1f1
        
    }
    .dropdown:hover .dropdown-content {
        display: block;
    }       
</style>