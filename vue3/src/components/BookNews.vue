<template>
    <div class="booksNew">
      <img id="new_book" src="../assets/images/new_book.png" alt="">
      <NewBooks/>
    </div>
  </template>
  
  <script>
import NewBooks from './NewBooks.vue';
export default {
  // props:[''],
  data () {
    return {
      books: [],
    };
  },
  components: {
    NewBooks
  },
  mounted() {
    const that=this
    this.axios.get('/book')
              .then(function(response){
              that.books=response.data
              })
}
    }
  </script>
  
  <style scoped>
 
  </style>