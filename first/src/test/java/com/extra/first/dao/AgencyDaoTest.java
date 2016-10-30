package com.extra.first.dao;

import com.extra.first.pojo.Agency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Kee on 2016/10/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/application-dao.xml"})
public class AgencyDaoTest {
    Logger logger = LoggerFactory.getLogger(AgencyDaoTest.class);
    @Autowired
    private AgencyDao agencyDao;

    @Test
    public void addAgency() throws Exception {

    }

    @Test
    public void updateAgency() throws Exception {

    }

    @Test
    public void queryAgenciesByCityId() throws Exception {
        List<Agency> agencies = agencyDao.queryAgenciesByCityId(1, 0, 10);
        for (Agency agency : agencies) {
            logger.info(agency.toString());
        }
    }

}