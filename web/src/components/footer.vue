<template>
    <div>
        <input type="checkbox">
        <span>已完成{{TotalDone}} / 全部{{todo.length}} </span>
        <button @click="handleCompleted()" v-if="showCompleted">隐藏已完成的项目</button>
        <button @click="handleCompleted()" v-else>显示已完成的项目</button>
    </div>
</template>

<script>
export default {
    name:'mainfooter',
    props:['todo','handleCompleted','showCompleted'],
    computed: {
        TotalDone(){
            var num = 0;
            for(var i = 0; i < this.todo.length; i++){
                if(this.todo[i].status == 1){
                    num = num + 1;
                }
            } 
            return num;
        },
    }
   }

 
</script>

<style scoped>
*{
    margin: 10px;
}

</style>