package com.example.todolist.service;

import com.example.todolist.entity.Item;

public interface UserService {
    Item userInfo(Integer id);

    int userAdd();
}
