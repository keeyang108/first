package com.extra.first.dao;

import com.extra.first.pojo.Supervisor;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by Kee on 2016/10/28.
 */
public interface SupervisorDao {

    /**
     * 添加管理员
     * @param supervisor
     * @return
     */
    int addSupervisor(@Param("supervisor") Supervisor supervisor);

    /**
     * 登陆校验及个人资料获取
     * @param supervisor
     * @return id,name,
     */
    Map<String,Object> checkUser(@Param("supervisor") Supervisor supervisor);

    /**
     * 更新管理员资料
     * @param supervisor
     * @return
     */
    int updateSupervisor(@Param("supervisor") Supervisor supervisor);
}
