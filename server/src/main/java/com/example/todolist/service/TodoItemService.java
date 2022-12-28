package com.example.todolist.service;

import com.example.todolist.entity.TodoItem;

import java.util.List;

public interface TodoItemService {
    List<TodoItem> itemInfo();

    String itemAdd(String name);

    String itemDelete(int id);

    String itemComplete(int id);
}
