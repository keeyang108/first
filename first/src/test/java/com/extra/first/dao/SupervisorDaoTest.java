package com.extra.first.dao;

import com.extra.first.pojo.Supervisor;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Kee on 2016/10/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/application-*.xml"})
public class SupervisorDaoTest {

    Logger logger = LoggerFactory.getLogger(SupervisorDaoTest.class);
    @Autowired
    private SupervisorDao supervisorDao;

//    @Test
//    public void addSupervisor() throws Exception {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Supervisor supervisor = new Supervisor();
//        supervisor.setBirthday(format.parse("1989-10-08"));
//        supervisor.setCreateTime(new Date());
//        supervisor.setEmail("123456@q.com");
//        supervisor.setPassword("justletitgo");
//        supervisor.setSupervisorName("kee");
//        supervisor.setSupervisorPhone("12345678901");
//        logger.info(supervisor.toString());
//        supervisorDao.addSupervisor(supervisor);
//    }

    @Ignore
    @Test
    public void checkUser() throws Exception {
        Supervisor supervisor = new Supervisor();
        supervisor.setSupervisorName("kee");
        supervisor.setPassword("justletitgo");
        Map<String,Object> result  = supervisorDao.checkUser(supervisor);
        logger.info(result.get("password").toString());
//        Supervisor result = supervisorDao.checkUser(supervisor);
//        if (result == null ){
//            logger.info("******************login failed ****************");
//            return;
//        }
//        logger.info("*************%s******************",result.getSupervisorName());
    }

}