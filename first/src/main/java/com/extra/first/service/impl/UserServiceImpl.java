package com.extra.first.service.impl;

import com.extra.first.dao.UserDao;
import com.extra.first.pojo.User;
import com.extra.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kee on 2016/10/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public int insertUser(String userName, String phone, int sex) {
        return userDao.insertUser(userName, phone, sex);
    }

    public List<User> listUser(String userName, String phone, int offset, int limit) {
        return userDao.listUser(userName, phone, offset, limit);
    }
}
