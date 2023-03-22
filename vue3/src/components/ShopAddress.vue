<template>
    <!-- 收货地址 -->
    <div id="address">
        <el-card>
            <el-table :data="tableData" style="width: 100%">
                <el-table-column label="姓名" prop="name" />
                <el-table-column label="性别" prop="genda" />
                <el-table-column label="电话" prop="number" />
                <el-table-column label="收货地址" prop="fullAddress" />
                <el-table-column align="right">
                <template #header>
                    <el-input v-model="search" size="small" placeholder="Type to search" />
                </template>
                <template #default="scope">
                    <el-button size="small" @click="update(scope.row)">编辑</el-button>
                    <el-button size="small" type="danger" @click="deletebyID(scope.row)">删除</el-button>
                </template>
                </el-table-column>
            </el-table>
        </el-card>
    </div>
    <!-- 删除按钮的对话框 -->
    <el-dialog v-model="dialogVisible" title="Tips" width="30%" :before-close="handleClose" >
        <span>确定删除吗？</span>
        <template #footer>
        <span class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="deleteOK">确定</el-button>
        </span>
        </template>
    </el-dialog>
    <!-- 编辑按钮的对话框 -->
    <el-dialog v-model="dialogFormVisible" title="地址更新">
        <p>地址更新</p>
        <el-form :model="form" label-width="120px">
            <el-form-item label="账号">
                <el-input v-model="form.id" placeholder="填写账号" disabled/>
            </el-form-item>
            <el-form-item label="姓名">
                <el-input v-model="form.name" placeholder="姓名" />
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
                <el-input v-model="form.favor" autocomplete="off" placeholder="填写喜欢的类型" disabled></el-input>
                <el-input v-model="form.favorAuthor" autocomplete="off" placeholder="填写喜欢的作者" disabled></el-input>
            </el-form-item>
            <el-form-item label="个性签名">
                <el-input v-model="form.autograph" type="textarea" placeholder="填写个性签名" disabled/>
            </el-form-item>
            <el-form-item label="详细地址">
                <el-input type="text" v-model="form.fullAddress"></el-input>
            </el-form-item>
        </el-form>
        <template #footer>
        <span class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取消</el-button>
            <el-button type="primary" @click="updateOK">更新</el-button>
        </span>
        </template>
    </el-dialog>
  </template>
  <script>
  import jsCookie from 'js-cookie';
    export default{
      data(){
        return{
            address:[],
            tableData:[],
            dialogFormVisible:false,
            dialogVisible:false,
            id:''
        }
    },
    mounted(){
        this.searchall()
        this.id =jsCookie.get('username')
    },
    methods:{
        searchall(){//展示收货地址
            const that=this
            this.axios.get("/getAllPerson")
                .then(function(response){
                that.address=response.data
                console.log('------成功-------')   
                }).then(()=>{
                    for (var i = 0; i < that.address.length; i++) {
                        if(that.address[i].id ==this.id){
                            this.tableData.push(this.address[i])
                        }
                      }
                    this.tableData
                })
        },
        deleteOK(){//确定删除
            const that=this
            this.axios.get("/deleteAddress",{
                params:{
                    key1:this.name,
                    key2:this.number,
                    key3:this.genda,
                    key4:this.fullAddress
                }
            }).then(function(response){
                console.log(response)
                that.searchall()
                that.dialogVisible=false
            })
        },
        deletebyID(row){//点击删除按钮
          this.dialogVisible=true,
          this.name=row.name
          this.number=row.number
          this.genda=row.genda
          this.fullAddress=row.fullAddress
          console.log(this.name+this.number+this.genda+this.fullAddress)
        },
        update(row){//点击更新按钮
          this.dialogFormVisible=true
          this.form=row
        },
        updateOK(){//确定更新
          const that = this
          this.axios.get("/updateAddress",{
                params:{
                    key1:this.form.id,
                    key2:this.form.name,
                    key3:this.form.number,
                    key4:this.form.favor,
                    key5:this.form.favorAuthor,
                    key6:this.form.genda,
                    key7:this.form.input,
                    key8:this.form.autograph,
                    key9:this.form.fullAddress
                }})
                .then(function(response){
                  console.log(response)
                  that.searchall()
                  that.dialogFormVisible=false
                })
        }
    }
}
  </script>
  <style scoped>
     .Default{
         color:orange
     }
     #address{
        width: 900px;
        margin-left: 50px;
        margin-bottom:200px ;
     }
     .addresslist{
         border-top:1px solid darkgray;
     }
     h5{
         text-align: left;
         font-weight: bold;
     }
    
      
  </style>
  
  