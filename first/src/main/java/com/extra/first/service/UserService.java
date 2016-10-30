package com.extra.first.service;

import com.extra.first.pojo.User;

import java.util.List;

/**
 * Created by Kee on 2016/10/22.
 */
public interface UserService {
    /**
     * insert
     *
     * @param userName
     * @param phone
     * @param sex
     * @return
     */
    int insertUser(String userName, String phone, int sex);

    List<User> listUser(String userName, String phone, int offset, int limit);
}
