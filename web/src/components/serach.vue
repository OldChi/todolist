<template>
  <div>
    <form @submit.prevent="addtodo($event)">
      <input
        class="input"
        type="text"
        placeholder="请在输入框输入要完成的任务"
        name="name"
      />
      <input type="submit" value="添加" class="button" />
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "search",
  props: ["receive"],
  methods: {
    addtodo(event) {
      var formData = new FormData(event.target);
    //   console.log(formData);
      if(!this.title) return alert('输入不可以为空')
      axios
        .post("http://127.0.0.1:8081/addItem", formData)
        .then(function (res) {
          console.log(res);
        })
        .catch(function (err) {
          console.log(err);
        });
      location.reload();
    },
  },
  data() {
    return {
      title: "",
    };
  },
};
</script>

<style scoped>
* {
  padding: 10px;
}
.input {
  width: 400px;
  height: 30px;
  outline: none;
  border-radius: 20px;
  border: 2px solid skyblue;
  transition: all .6s;
}
.button {
  width: 100px;
  height: 50px;
  margin-left: 30px;
  cursor: pointer;
}
</style>