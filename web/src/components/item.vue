<template>
    <div class="body-total">
       <li v-show="showCompleted || todo.status == 0">
           <label  for="">
               <input type="checkbox" :checked="todo.status == 1" @click="handleComplete(todo.id)">
               <span v-if="todo.status == 0">{{todo.name}}</span>
               <span class="finished" v-else>{{todo.name}}</span>
           </label>
           <button class="btn"
           @click="handleDelete(todo.id)">删除</button>
       </li>
    </div>
</template>

<script>
    import axios from "axios"
    export default {
        name:'item',
        //声明接受todo对象
        props:['todo','showCompleted','checkTodo'],
        methods: {
            handleComplete(id){
                axios.get("http://127.0.0.1:8081/completeItem?id=" + id ).then((data) => {
                    console.log(data);
                })
                .catch((err) => {
                    console.log(err);
                });
                location. reload();
            },
            handleDelete(id){
                if(confirm('确定删除吗')){
                    axios.get("http://127.0.0.1:8081/deleteItem?id=" + id ).then((data) => {
                        console.log(data);
                    })
                    .catch((err) => {
                        console.log(err);
                    });
                    location. reload();
                }
            }
        },
    }
</script>

<style scoped>
    *{
        margin: 10px;
    }
    button {
        float: right;
        width:40px;
        background: red;
        border-radius: 2px;
        border: none;
        color:white;
        height: 25px;
        margin-top: 5px;
        border-radius: 5px;
        display: none;     
    }
    li {
       list-style: none;
        width: 500px;
        border: 1px solid grey;
        border-radius: 8px;
    }
    li:hover {
        background-color: #f3f3f3;
    }
     li:hover button {
        display: block;
    }
    input {
        margin-right:20px;
    }
    .finished{
        text-decoration: line-through;
        font-style: italic;
        font-size: small;
        color: rgb(143, 138, 138);
    }
  

</style>