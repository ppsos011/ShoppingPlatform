<template>
<!-- 实现省市区三级联动 -->
  <div class="wrap">
    <!-- v-distpicker插件 -->
    <v-distpicker @selected="onSelected"></v-distpicker>
    <el-input type="text" v-model="input" placeholder="填写详细地址"></el-input>
    <div>
          你当前选的的地址:{{fullAddress}}
    </div> 
  </div>
</template>
<script>
import VDistpicker from 'v-distpicker'
export default {
    data(){
        return{
            selected:{
                province: "",
                city: "",
                area: ""
            },
            input:''
        }
    },
    computed:{
        fullAddress:function(){
            return this.selected.province +"-"+ this.selected.city +"-"+ this.selected.area +"-"+this.input
        }
    },
    methods:{
        onSelected(data){
            const {province,city,area} = data;
            if(!province.code && !city.code && !city.code) return;
            this.selected.province = province.value;//赋值给省
            this.selected.city = city.value;//赋值给市
            this.selected.area = area.value;//赋值给区
        }
    },
    components:{
        VDistpicker
    }
}
</script>


<!-- 
第二种：
  <template>
  element-china-area-data插件
    <div id="app">
      <el-cascader
        size="large"
        :options="options"
        v-model="selectedOptions"
        @change="addressChange">
      </el-cascader>
    </div>
  </template>
   
  <script>
    import { regionData,CodeToText } from 'element-china-area-data'
    export default {
      data () {
        return {
          options: regionData,
          selectedOptions: []
        }
      },
   
      methods: {
        addressChange(arr) {
            console.log(arr);
            console.log(CodeToText[arr[0]], CodeToText[arr[1]], CodeToText[arr[2]]);
        },
      }
    }
  </script> -->

  
  <!-- 
  第三种：
    <template>
    <div>
    <button @click="choose">点我选择区域</button>
    <p>您选择的城市为:<span>{{txt1}}</span><span>{{txt2}}</span><span>{{txt3}}</span></p>
    <p class="pwrap" v-if="show">
      <v-distpicker type="mobile" @province="onChangeProvince" @city="onChangeCity" @area="onChangeArea"></v-distpicker>
    </p>
  </div>
</template>
<script>
	import VDistpicker from 'v-distpicker'
  export default {
    name: 'getAddress',
    components: { VDistpicker },
    data() {
      return {
        show:false,
        txt1:'',
        txt2:'',
        txt3:'',   
      }
    },
    methods: {
      choose(){
        this.show=!this.show
      },
      onChangeProvince(a){
        console.log(a) 
        this.txt1 = a.value + '-'
      },    
      onChangeCity(a){
        console.log(a)    
        this.txt2 = a.value + '-'    
      },
      onChangeArea(a){
        console.log(a)  
        this.txt3 = a.value
        this.show=false
      }      
    },
}
</script> -->