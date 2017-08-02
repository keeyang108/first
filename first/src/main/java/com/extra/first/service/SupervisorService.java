package com.extra.first.service;

import com.extra.first.model.Supervisor;

import java.util.Map;

/**
 * Created by Kee on 2016/10/30.
 */
public interface SupervisorService {

    /**
     * add user
     */
    int addSupervisor(Supervisor supervisor);

    /**
     * check if is exists;
     * @param supervisor
     * @return
     */
    Supervisor checkUser(Supervisor supervisor);

    /**
     * select by userName
     * @param userName
     * @return
     */
    Supervisor selectUserByUserName(String userName);
}
