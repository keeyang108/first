package com.extra.first.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/application-dao.xml"})
public class VisitRecordDaoTest {
    private static final Logger logger = LoggerFactory.getLogger(VisitRecordDaoTest.class);
    @Autowired
    private VisitRecordDao visitRecordDao;

    @Test
    public void addVisitRecord() throws Exception {
        int row = visitRecordDao.addVisitRecord("127.0.0.1");
        Assert.assertEquals(row,1);
    }

    @Test
    public void getRecordCount() throws Exception {
        Map<String,Object> result = visitRecordDao.getRecordCount(null,null);
        Assert.assertEquals(result.get("totalCount"),1);
    }

}