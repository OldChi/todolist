<template>
    <div>
        <ul class="todo-main">
            <item  v-for="todoObj in todo"
            :key="todoObj.id"
            :todo="todoObj"
            :showCompleted="showCompleted"
            :checkTodo="checkTodo"
           />   
        </ul>
        
    </div>
</template>

<script>
    import Item from './item.vue'
    export default {
        components:{ Item },
        name:'todolist',
        props:['todo','showCompleted','checkTodo']
    }
</script>

<style scoped>


</style>