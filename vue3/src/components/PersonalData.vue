<template>
    <!-- 填写个人信息 -->
    <div id="persondata">
        <el-card class="box-card">
            <div>
                <!-- 添加地址表单 -->
                <p>填写人员信息</p>
                <el-form :model="form" label-width="120px" inline=“true”>
                    <el-form-item label="账号">
                        <el-input v-model="form.id" placeholder="填写账号" disabled/>
                    </el-form-item>
                    <el-form-item label="姓名">
                        <el-input v-model="form.name" placeholder="姓名"/>
                    </el-form-item>
                    <el-form-item label="职业">
                        <el-select v-model="form.role" placeholder="请选择职业">
                            <el-option label="学生" value="学生"></el-option>
                            <el-option label="公务员" value="公务员"></el-option>
                            <el-option label="老师" value="老师"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="性别">
                        <el-radio-group v-model="form.genda">
                            <el-radio label="男" />
                            <el-radio label="女" />
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="手机号码" prop="number">
                        <el-input v-model="form.number" autocomplete="off" placeholder="填写手机号码"></el-input>
                    </el-form-item>
                    <el-form-item label="喜好" prop="favorAuthor" >
                        <el-input v-model="form.favor" autocomplete="off" placeholder="填写喜欢的类型"></el-input>
                        <el-input v-model="form.favorAuthor" autocomplete="off" placeholder="填写喜欢的作者"></el-input>
                    </el-form-item>
                    <el-form-item label="填写地址">
                        <div>
                            <!-- v-distpicker插件实现省市区三级联动 -->
                            <v-distpicker @selected="onSelected"></v-distpicker>
                            <el-input type="text" v-model="form.input" placeholder="填写详细地址" v-on:input="search"></el-input>
                        </div>
                    </el-form-item>
                    <el-form-item label="个性签名">
                        <el-input v-model="form.autograph" type="textarea" placeholder="填写个性签名" style="width:500px"/>
                    </el-form-item>
                    <el-form-item label="详细地址">
                        <el-input type="text" v-model="form.fullAddress" style="width:600px"></el-input>
                    </el-form-item>
                    <el-form-item style="float: right;">
                        <el-button type="primary" @click="onSubmit">提交</el-button>
                        <el-button>取消</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
    </div>
    <el-dialog
    v-model="dialogVisible"
    title="Tips"
    width="30%"
    :before-close="handleClose"
  >
    <span>{{message}}</span>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确定</el-button>
      </span>
    </template>
  </el-dialog>
</template>
<script>
import VDistpicker from 'v-distpicker'
import jsCookie from 'js-cookie';
  export default {
    data(){
        return{
            tableData:[],
            message:'',
            dialogVisible:false,
            form:{
                id:'',
                name: '',
                role:'',
                genda: '',
                number: '',
                favor:'',
                favorAuthor:'',
                input:'',
                autograph:'',
                fullAddress:''
            },
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
            return this.selected.province +"-"+ this.selected.city +"-"+ this.selected.area +"-"+this.form.input
        },
    },
    mounted(){
        this.form.id =jsCookie.get('username')
        this.searchall()
    },
    methods:{
        search(){
            this.form.fullAddress= this.fullAddress
        },
        searchall(){
            const that =this
            this.axios.get("/getAllPerson")
                .then(function(response){
                that.tableData=response.data
                console.log('------成功-------')   
                }).then(()=>{
                    if(this.form.id!=""){
                        for (var i = 0; i < that.tableData.length; i++) {
                            if(that.tableData[i].id ==this.form.id){//判断是否有该用户的信息
                                this.form=that.tableData[i]
                                jsCookie.get('form',this.form)
                            }
                        }
                    }
                })
        },
        onSelected(data){
            const {province,city,area} = data;
            if(!province.code && !city.code && !city.code) return;
            this.selected.province = province.value;
            this.selected.city = city.value;
            this.selected.area = area.value;
            this.form.fullAddress = this.selected.province +"-"+ this.selected.city +"-"+ this.selected.area
        },
        insert(){
            //传到数据库
            // const that = this
            this.axios.get('/insertaddress',{
                params:{
                    key1:this.form.id,
                    key2:this.form.name,
                    key3:this.form.role,
                    key4:this.form.number,
                    key5:this.form.favor,
                    key6:this.form.favorAuthor,
                    key7:this.form.genda,
                    key8:this.form.input,
                    key9:this.form.autograph,
                    key10:this.form.fullAddress,
                }
            })
                .then(function(response){
                    if(response.data>0){
                        window.alert("添加成功"); 
                    }else{
                        window.alert("添加失败"); 
                    }                   
                })
        },
        update(){//确定更新
          this.axios.get("/updateAddress",{
                params:{
                    key1:this.form.id,
                    key2:this.form.name,
                    key3:this.form.role,
                    key4:this.form.number,
                    key5:this.form.favor,
                    key6:this.form.favorAuthor,
                    key7:this.form.genda,
                    key8:this.form.input,
                    key9:this.form.autograph,
                    key10:this.form.fullAddress,
                }})
        },
        onSubmit(){
            const that =this
            this.axios.get("/getAllPerson")
                .then(function(response){
                that.tableData=response.data
                console.log('------成功-------')   
                }).then(()=>{
                    for( var i =0;i< that.tableData.length;i++){
                        if(this.form.id!=that.tableData[i].id){
                            a = a +1
                        }
                        console.log("----------")
                        console.log(this.form.id)
                        console.log(that.tableData[i].id)
                        console.log("----------")
                    } 
                    if(a == 0){
                        this.update()
                    }else{
                        this.insert()
                    }        
                })
            let a = 0;
            
            // console.log("----------")
            // console.log(a)
            // console.log("----------")
            
        }
    },
    components:{
        VDistpicker
    }
  }
  </script>
  <style scoped>
  p{
    text-align: center;
    font-weight:700 ;
  }
  #persondata{
    height: 800px;
    overflow: hidden;
    margin-left:50px ;
  }
 .el-card{
     margin-top: 30px; 
  }

  </style>