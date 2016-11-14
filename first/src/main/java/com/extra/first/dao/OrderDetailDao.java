package com.extra.first.dao;

import com.extra.first.pojo.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Kee on 2016/11/8.
 */
public interface OrderDetailDao {

    /**
     * 添加订单
     * @param detail
     * @return
     */
    int insertOrder(@Param("order") OrderDetail detail);

    /**
     * 根据条件查询订单详情
     * @param detail
     * @param offset
     * @param limit
     * @return
     */
    List<OrderDetail> listOrderDetails(@Param("detail") OrderDetail detail,@Param("offset") int offset,@Param("limit") int limit);

}