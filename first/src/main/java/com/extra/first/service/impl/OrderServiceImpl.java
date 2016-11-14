package com.extra.first.service.impl;

import com.extra.first.dao.OrderDao;
import com.extra.first.pojo.Order;
import com.extra.first.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Kee on 2016/10/23.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderDao orderDao;

    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    /**
     * 查询订单
     *
     * @param order
     * @param offset
     * @param limit
     * @return
     */
    public List<Map<String,Object>> queryOrders(Order order, int offset, int limit) {
        List<Map<String,Object>> orders = null;
        orders = orderDao.queryOrders(order, offset, limit);
        return orders;
    }

}
