package com.extra.first.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;

/**
 * Created by Kee on 2016/11/15.
 */
public interface VisitRecordDao {

    /**
     * 添加访问记录
     * @param ip
     * @return
     */
    int addVisitRecord(@Param("ip") String ip);

    /**
     * 统计访问次数
     * @param startTime
     * @param endTime
     * @return
     */
    Map<String,Object> getRecordCount(@Param("startTime") Date startTime,@Param("endTime") Date endTime);
}
