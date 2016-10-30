package com.extra.first.dao;

import com.extra.first.pojo.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Kee on 2016/10/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/application-dao.xml"})
public class CityDaoTest {

    Logger logger = LoggerFactory.getLogger(CityDaoTest.class);

    @Autowired
    private CityDao cityDao;

    @Test
    public void addCity() throws Exception {
        int result = cityDao.addCity(1, "广州");
        logger.info(result + "");
    }

    @Test
    public void queryCityById() throws Exception {
        City city = cityDao.queryCityById(1);
        logger.info(city.toString());
    }

    @Test
    public void queryCitiesByProvinceId() throws Exception {
        List<City> cities = cityDao.queryCitiesByProvinceId(1, 0, 10);
        for (City city : cities) {
            logger.info(city.toString());
        }
    }

}