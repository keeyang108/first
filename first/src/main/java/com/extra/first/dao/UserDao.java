package com.extra.first.dao;

import com.extra.first.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Kee on 2016/10/21.
 */
public interface UserDao {

    /**
     * insert
     *
     * @param userName
     * @param phone
     * @param sex
     * @return
     */
    int insertUser(@Param("userName") String userName, @Param("phone") String phone, @Param("sex") int sex);

    List<User> listUser(@Param("userName") String name, @Param("phone") String phone, @Param("offset") int offset, @Param("limit") int limit);
}
