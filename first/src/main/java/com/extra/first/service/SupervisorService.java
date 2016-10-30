package com.extra.first.service;

import com.extra.first.pojo.Supervisor;

import java.util.Map;

/**
 * Created by Kee on 2016/10/30.
 */
public interface SupervisorService {

    int addSupervisor(Supervisor supervisor);

    Map<String, Object> checkUser(Supervisor supervisor);
}
