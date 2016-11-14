package com.extra.first.service;

import com.extra.first.pojo.Order;

import java.util.List;
import java.util.Map;

/**
 * Created by Kee on 2016/10/23.
 */
public interface OrderService {

    /**
     * 增加预定订单
     *
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 根据条件查询订单
     *
     * @param order
     * @param offset
     * @param limit
     * @return
     */
    List<Map<String,Object>> queryOrders(Order order, int offset, int limit);
}
