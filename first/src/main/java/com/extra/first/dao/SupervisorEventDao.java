package com.extra.first.dao;

import com.extra.first.pojo.SupervisorEvent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *管理员事件dao
 * Created by Kee on 2016/10/28.
 */
public interface SupervisorEventDao{

    /**
     * 添加管理员事件
     * @param supervisorEvent
     * @return
     */
    int addSupervisor(@Param("event") SupervisorEvent supervisorEvent);

    /**
     * 获取当前管理员的历史事件
     * @param supervisorId
     * @param offset
     * @param limit
     * @return
     */
    List<SupervisorEvent> listEventOfCurrentSupervisor(@Param("id") long supervisorId,@Param("offset") int offset,@Param("limit") int limit);

}
