package com.extra.first.dao;

import com.extra.first.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Kee on 2016/10/23.
 */
public interface OrderDao {

    /**
     * 添加预约订单
     *
     * @param order
     * @return
     */
    int addOrder(@Param("order") Order order);

    /**
     * 根据条件查询相应记录：包括获取所有
     *
     * @param order
     * @param offset
     * @param limit
     * @return
     */
    List<Map<String,Object>> queryOrders(@Param("order") Order order, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据Id删除记录
     *
     * @param id
     * @return
     */
    int delOrderById(long id);

    /**
     * 修改订单
     *
     * @param userName
     * @param phone
     * @param sex
     * @param agencyId
     * @param cityId
     * @param provinceId
     * @param carTypeId
     * @param status
     * @return
     */
    int updateOrder(@Param("userName") String userName, @Param("userPhone") String phone, @Param("sex") int sex
            , @Param("agencyId") int agencyId, @Param("cityId") int cityId, @Param("provinceId") int provinceId,
                    @Param("carTypeId") int carTypeId, @Param("status") int status, @Param("id") long id);

}
