package com.example.todolist.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.todolist.dao.TodoItemDao;
import com.example.todolist.entity.TodoItem;
import com.example.todolist.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    @Resource
    private TodoItemDao todoItemDao;

    @Override
    public List<TodoItem> itemInfo() {
        QueryWrapper<TodoItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("status", 2);
        List<TodoItem> userInfoList = todoItemDao.selectList(queryWrapper);
        return userInfoList;
    }

    @Override
    public String itemAdd(String name) {
        TodoItem item = new TodoItem();
        item.setName(name);

        todoItemDao.insert(item);
        return "success";
    }

    @Override
    public String itemDelete(int id) {
        TodoItem item = todoItemDao.selectById(id);
        item.setStatus(2);
        todoItemDao.updateById(item);
        return "success";
    }

    @Override
    public String itemComplete(int id) {
        TodoItem item = todoItemDao.selectById(id);
        if(item.getStatus() == 0){
            item.setStatus(1);
        }
        else if (item.getStatus() == 1) {
            item.setStatus(0);
        }
        todoItemDao.updateById(item);
        return "success";
    }
}
