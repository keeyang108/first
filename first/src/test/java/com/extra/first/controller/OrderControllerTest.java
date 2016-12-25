package com.extra.first.controller;

import com.extra.first.dto.BaseResult;
import com.extra.first.pojo.OrderDetail;
import com.extra.first.pojo.PageBean;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Kee on 2016/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/application-*.xml"})
public class OrderControllerTest {

    Logger logger = LoggerFactory.getLogger(OrderControllerTest.class);
    @Autowired
    private OrderController orderController;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public  void setUp(){
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }

    @Test
    public void addOrderByJSONP() throws Exception {

    }

    @Test
    public void addOrder() throws Exception {

    }

    @Test
    public void listProvince() throws Exception {

    }

    @Test
    public void listCity() throws Exception {

    }

    @Test
    public void listAgency() throws Exception {

    }

    @Test
    public void listCar() throws Exception {

    }

    @Test
    public void download() throws Exception {

    }

    @Test
    public void countVisit() throws Exception {
        request.setParameter("ip","120.1.0.134");
        request.setParameter("callback","callback");
        orderController.countVisit(request,response);
        response.getWriter().println();
    }

    @Ignore
    @Test
    public void listOrder() throws Exception {
        OrderDetail detail = new OrderDetail();
//        detail.setSubject("大迈X5双11专题");
        detail.setIsActivity(1);
        BaseResult<PageBean<OrderDetail>> page = orderController.listOrder(detail,0,5);
        logger.info(page.getData().getData().size()+"");
        logger.info(page.getData().getConditions().get("subject").toString());
    }

}