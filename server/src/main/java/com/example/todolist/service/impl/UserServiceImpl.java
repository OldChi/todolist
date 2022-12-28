package com.example.todolist.service.impl;

import com.example.todolist.dao.UserDao;
import com.example.todolist.entity.Item;
import com.example.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Item userInfo(Integer id) {
        Item cmfzAdmin = userDao.selectById(id);
        return cmfzAdmin;
    }

    @Override
    public int userAdd() {
        Item cmfzAdmin = new Item();
        cmfzAdmin.setName("hhhh");
        cmfzAdmin.setAge(12);

        userDao.insert(cmfzAdmin);
        return 1;
    }

}
