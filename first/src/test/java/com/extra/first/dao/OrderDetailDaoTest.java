package com.extra.first.dao;

import com.extra.first.pojo.OrderDetail;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Kee on 2016/11/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/application-dao.xml"})
public class OrderDetailDaoTest {

    Logger logger = LoggerFactory.getLogger(OrderDetailDaoTest.class);
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Ignore
    @Test
    public void insertOrder() throws Exception {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setName("test");
        orderDetail.setSex("男");
        orderDetail.setMobile("12345678890");
        orderDetail.setProvince("广东");
        orderDetail.setCity("深圳");
        orderDetail.setAgentName("华强别");
        orderDetail.setAgentCode(0);
        orderDetail.setCarType("大众");
        orderDetail.setCarTypeCode(1);
        orderDetail.setMediaName("360");
        orderDetail.setTerminal("pc");

        int row = orderDetailDao.insertOrder(orderDetail);
        logger.info("*****************************row={}****************************",row);
    }

    @Test
    public void listOrderDetails() throws Exception {
        List<OrderDetail> details = orderDetailDao.listOrderDetails(new OrderDetail(),0,10);
        for (OrderDetail detail : details){
            logger.info(detail.toString());
        }
    }

}