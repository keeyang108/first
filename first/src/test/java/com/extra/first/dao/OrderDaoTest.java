package com.extra.first.dao;

import com.extra.first.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by Kee on 2016/10/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/application-dao.xml"})
public class OrderDaoTest {

    Logger logger = LoggerFactory.getLogger(OrderDaoTest.class);
    @Autowired
    private OrderDao orderDao;

    @Test
    public void addOrder() throws Exception {
        Order order = new Order("kee1", "186020321234", 0, 1, 1, 1, 1, 1);
        int row = orderDao.addOrder(order);
        logger.info("" + row);
    }

    @Test
    public void queryOrders() throws Exception {
        List<Map<String,Object>> orders = orderDao.queryOrders(new Order(), 0, 10);
        for (Map<String,Object> map : orders) {
            logger.info(map.get("userName").toString());
        }
    }

    @Test
    public void delOrderById() throws Exception {

    }

    @Test
    public void updateOrder() throws Exception {

    }

}