package com.extra.first.service;

import java.util.Date;

/**
 * Created by Kee on 2016/11/16.
 */
public interface VisitRecordService {

    /**
     * 添加访问记录
     * @param ip
     * @return
     */
    int addVisitRecord(String ip);

    /**
     * 统计访问次数
     * @param startTime
     * @param endTime
     * @return
     */
    int getRecordCount(Date startTime,Date endTime);

}
