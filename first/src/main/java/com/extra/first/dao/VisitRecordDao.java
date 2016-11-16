package com.extra.first.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by Kee on 2016/11/15.
 */
public interface VisitRecordDao {

    int addVisitRecord(@Param("ip") String ip);

    Map<String,Object> getRecordCount();
}
