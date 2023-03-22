<template>
  <div class="addSubtractButton">
    <el-button @click="handleSubtract" 
        :class="{disabled: quantity === 0, actived: quantity > 0}" 
        href="javascript:;">-</el-button>
        <input v-model="quantity" type="number">
    <el-button href="javascript:;" @click="handleAdd">+</el-button>
  </div>
</template>

<script>
  export default {
    name:'AddSubtractButton',
    data(){
      return {
        quantity: 0
      }
    },
    methods: {
      handleAdd(){
        this.quantity++;
        this.$emit("update-quantity", this.quantity);
      },
      handleSubtract(){
        this.quantity--;
        this.$emit("update-quantity", this.quantity);
      }
    }
  }
</script>
<style scoped>

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