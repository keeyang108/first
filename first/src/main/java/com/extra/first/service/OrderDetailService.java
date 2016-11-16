package com.extra.first.service;

import com.extra.first.pojo.OrderDetail;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by Kee on 2016/11/9.
 */
public interface OrderDetailService {
    /**
     * 添加订单
     * @param detail
     * @return
     */
    int insertOrder (OrderDetail detail);

    /**
     * 根据条件查询订单详情
     * @param detail
     * @param offset
     * @param limit
     * @return
     */
    List<OrderDetail> listOrderDetails(OrderDetail detail,  int offset,int limit) throws DataAccessException;

    /**
     * 获取条件查询订单的总数
     * @param detail
     * @return
     */
    int countOrderDetails(OrderDetail detail);
}
