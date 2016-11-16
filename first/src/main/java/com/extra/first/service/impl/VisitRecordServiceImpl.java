package com.extra.first.service.impl;

import com.extra.first.dao.VisitRecordDao;
import com.extra.first.service.VisitRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Created by Kee on 2016/11/16.
 */
@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private static final Logger logger = LoggerFactory.getLogger(VisitRecordServiceImpl.class);
    @Autowired
    private VisitRecordDao visitRecordDao;

    /**
     * 添加访问记录
     * @param ip
     * @return
     */
    public int addVisitRecord(String ip) {
        return visitRecordDao.addVisitRecord(ip);
    }

    /**
     * 统计访问次数
     * @param startTime
     * @param endTime
     * @return
     */
    public int getRecordCount(Date startTime, Date endTime) {
        Map<String,Object> result = visitRecordDao.getRecordCount(startTime,endTime);
        if (result == null ){
            return 0;
        }
        return Integer.parseInt(result.get("totalCount").toString());
    }
}
