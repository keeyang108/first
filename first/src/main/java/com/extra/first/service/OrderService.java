package com.extra.first.service;

import com.extra.first.pojo.Order;

import java.util.List;

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
     * @param userName
     * @param phone
     * @param agencyId
     * @param cityId
     * @param channelId
     * @param provinceId
     * @param catTypeId
     * @param offset
     * @param limit
     * @return
     */
    List<Order> queryOrders(String userName, String phone, int agencyId, int cityId, int channelId, int provinceId, int catTypeId, int offset, int limit);
}
