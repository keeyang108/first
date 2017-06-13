package com.extra.first.service.impl;

import com.extra.first.dao.OrderDetailDao;
import com.extra.first.model.OrderDetailQueryBean;
import com.extra.first.pojo.OrderDetail;
import com.extra.first.service.OrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Kee on 2016/11/9.
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private static final Logger logger = LoggerFactory.getLogger(OrderDetailServiceImpl.class);
    @Autowired
    private OrderDetailDao orderDetailDao;

    public int insertOrder(OrderDetail detail) {
        return orderDetailDao.insertOrder(detail);
    }

    public List<OrderDetail> listOrderDetails(OrderDetailQueryBean detail, int offset, int limit) {
        return orderDetailDao.listOrderDetails(detail,offset,limit);
    }

    public int countOrderDetails(OrderDetailQueryBean detail) {
        Map<String,Object> result = orderDetailDao.countOrderDetails(detail);
        return Integer.parseInt(result.get("totalCount").toString());
    }
}
