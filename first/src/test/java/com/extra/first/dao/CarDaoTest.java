package com.extra.first.dao;

import com.extra.first.pojo.Car;
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
public class CarDaoTest {

    Logger logger = LoggerFactory.getLogger(CarDaoTest.class);
    @Autowired
    private CarDao carDao;

    @Test
    public void listCar() throws Exception {
        List<Car> cars = carDao.listCar(0, 10);
        for (Car car : cars) {
            logger.info(car.toString());
        }
    }

    @Test
    public void addCar() throws Exception {

    }

}