package com.example.todolist.controller;

import com.example.todolist.entity.TodoItem;
import com.example.todolist.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ItemController {
    @Autowired
    private TodoItemService todoItemService;

    @RequestMapping("getItem")
    @ResponseBody
    public List<TodoItem> getItem(){
        return todoItemService.itemInfo();
    }

    @PostMapping ("addItem")
    public String addItem(@RequestParam("name") String name){
        return todoItemService.itemAdd(name);
    }

    @RequestMapping("deleteItem")
    public String deleteItem(@RequestParam("id") int id){
        return todoItemService.itemDelete(id);
    }

    @RequestMapping("completeItem")
    public String completeItem(@RequestParam("id") int id){
        return todoItemService.itemComplete(id);
    }
}
