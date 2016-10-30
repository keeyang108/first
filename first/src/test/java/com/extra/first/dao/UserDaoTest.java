package com.extra.first.dao;

import com.extra.first.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Kee on 2016/10/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/application-dao.xml"})
public class UserDaoTest {
    Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
    @Resource
    private UserDao userDao;

    @Test
    public void insertUser() throws Exception {
        int id = userDao.insertUser("kee", "18603021850", 1);
        System.out.println(id);
        logger.info("******************************");
    }

    @Test
    public void listUser() throws Exception {
        List<User> users = userDao.listUser(null, null, 0, 10);
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

}