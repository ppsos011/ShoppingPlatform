<template id="select-list">
    <div id="allselect">
        <div class="select-list-wrap" :class="{ 'show-select' : showSelect }" @click="showSelectList">
            <div class="select-list-select-item">
                <span>送至：{{ selectItem }}</span>
                <svg class="icon" viewBox="0 0 1024 1024" width="20" height="20">
                    <path
                        d="M579.043 792.408l418.544-418.641c25.83-25.827 33.48-64.34 19.53-98.087-13.95-33.655-46.79-55.52-83.14-55.52L96.8 220.16c-36.352 0-69.205 21.955-83.147 55.52-4.59 11.157-6.842 22.86-6.842 34.47 0 23.395 9.177 46.43 26.365 63.62l418.641 418.639c16.912 16.91 39.772 26.365 63.622 26.365 23.84 0 46.795-9.535 63.62-26.365L579.043 792.409 579.043 792.408z"
                        fill="#ffffff">
                    </path>
                </svg>
            </div>
            <!-- <el-dialog v-model="dialogVisible" title="Tips" width="30%" :before-close="handleClose">
                <span>{{ selectItem }}为疫情地区（发货和物流受疫情影响，时间较长）</span>
                <template #footer>
                    <span class="dialog-footer">
                        <el-button @click="dialogVisible = false">取消</el-button>
                        <el-button type="primary" @click="dialogVisible = false">确定</el-button>
                    </span>
                </template>
            </el-dialog> -->
            <div class="select-list-content" ref="selectListContent" @click.stop="hideSelectList">
                <ul>
                    <li v-for="add in adds" :key="add.id" @click="select(add)">
                        {{ add }}
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    el: '#app',
    data() {
        return {
            selectItem: '北京',
            showSelect: false,
            selectListHeight: 0,
            dialogVisible: false,
            adds:['北京','天津','河北','山西','内蒙古','辽宁','吉林','黑龙江','上海','江苏','浙江','安徽','福建','江西','山东','河南','湖北','湖南','广东','广西','海南','重庆','四川','贵州','云南','西藏','陕西','甘肃','青海','宁夏','新疆','台湾','香港','澳门','钓鱼岛'],
        }
    },
    mounted() {
        this.a();
        // this.getAddress()
    },
    methods: {
        a() {
            let selectListContent=0
            selectListContent = this.$refs.selectListContent;
            this.selectListHeight = selectListContent.offsetHeight;
            selectListContent.style.height = '0';
        },
        showSelectList() {
            this.showSelect = !this.showSelect;
            this.$refs.selectListContent.style.height = this.showSelect ? this.selectListHeight + 'px' : '0';
        },
        hideSelectList() {
            this.showSelect = false;
            this.$refs.selectListContent.style.height = '0';
            
        },
        select(add) {
            this.selectItem = add;
            this.$emit('select', add);
            if (add == '内蒙古') {
                this.dialogVisible=true
            }
            
        },
        // getAddress(){
        //     const that=this
        //     this.axios.get('/getAddress')
        //             .then(function(response){
        //             that.adds=response.data
        //             })
        // }
    },
}
</script>
<style>
 * {
    margin: 0;
    padding: 0;
}

#allselect{
    width: 200px;
    height: 30px;
 }
.select-list-wrap {
    position: relative;
    background: white;
    width: 200px;
    font-weight: bold;
    padding: 4px 16px 4px 8px;
    /* border: 3px solid white; */
    border: cornflowerblue 3px solid;
    color: cornflowerblue;
    cursor: pointer;
    transition: all .2s ease-in-out;
}

.select-list-select-item {
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.select-list-content {
    width: 500px;
    position: absolute;
    top: 30px;
    left: -3px;
    background: white;
    transition: all .2s ease-in-out;
    border: cornflowerblue 3px solid;
    height: auto;
    z-index: 10;
    opacity: 0;
}

.select-list-content ul {
    color: cornflowerblue;
    list-style: none;
}

.select-list-content li {
    text-align: left;
    transition: all .2s ease-in-out;
    width: 50px;
    float: left;
    padding: 5px 0px;
    margin: 0px 2px;
}
.select-list-content li:hover {
    background: #f5f3ec;
}
.show-select {
    background: white;
    color: cornflowerblue;
}
.show-select .select-list-content {
    opacity: 1;
}
.select-list-select-item svg {
    transition: all .2s ease-in-out;
}

.show-select .select-list-select-item svg {
    transform: rotateZ(-180deg);
}

.show-select .select-list-select-item path {
    fill: cornflowerblue;
}/* */
</style>