<template>
  <div id="app" class="bg-grid">  
      <div class="title">任务列表</div>
      <serach :receive="receive"></serach>
      <todolist :todo="todo"
        :showCompleted="showCompleted"
        :checkTodo="checkTodo"
        ></todolist>
      <mainfooter :todo='todo' :handleCompleted='handleCompleted' :showCompleted="showCompleted"></mainfooter>
  </div>
</template>

<script>
  import Mainfooter from './components/footer.vue'
  import Serach from './components/serach.vue'
  import Todolist from './components/todolist.vue'
  import axios from "axios"
  export default {

    name: 'App',
    components: {
      Todolist,
      Serach,
      Mainfooter, 
    },
    props:{
    },
    data(){
      return {
          todo:[],
          showCompleted: false,
      }
  },
  mounted(){
      this.getdata();
    },
  methods: {
    getdata() {
        axios.get("http://127.0.0.1:8081/getItem").then((data) => {
            console.log(data);
            this.todo = data.data;
        })
        .catch((err) => {
            console.log(err);
        });
    },
    receive(obj){
      this.todo.unshift(obj)
    },
    checkTodo(id){
      this.todo.forEach(todo => {
        if(todo.id === id) todo.done =! todo.done
      })
    },
    handleCompleted(){
      this.showCompleted = !this.showCompleted;
    },
  }
}
  



</script>

<style >
  * {
    margin: 0;
    padding:0;
  }
 
  #app {
    width: 700px;
    margin: 150px auto;
    padding: 50px;
    box-sizing: border-box;
    border-radius: 20px;
    transition: all .6s;
  }

  input:focus {
    box-shadow: 0 0 15px skyblue;
  }
  #app:hover {
    box-shadow: 0 0 15px skyblue;
  }
  .title {
    height: 40px;
    color: #000;
    text-align: center;
    line-height: 40px;
    font-size: 30px;
  }
  .bg-grid {
    padding: 10px;
    padding-top: 64px;
    background-color: #efefef;
    background-size: 21px 21px, 21px 21px;
    background-position: center;
  }


  .bg-grid:before {
    top: 0;
    width: 10px;
  }

  .bg-grid:after {
    top: 26px;
    width: 28px;
    border-radius: 50%;
  }
</style>
