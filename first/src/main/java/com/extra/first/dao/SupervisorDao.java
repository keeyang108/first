package com.extra.first.dao;

import com.extra.first.pojo.Supervisor;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by Kee on 2016/10/28.
 */
public interface SupervisorDao {

    int addSupervisor(@Param("supervisor") Supervisor supervisor);

//    Supervisor checkUser(@Param("supervisor") Supervisor supervisor);
    Map<String,Object> checkUser(@Param("supervisor") Supervisor supervisor);
}
