package com.extra.first.service;

import com.extra.first.dao.SupervisorDao;
import com.extra.first.pojo.Supervisor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Kee on 2016/10/30.
 */
@Service
public class SupervisorServiceImpl implements SupervisorService {

    Logger logger = LoggerFactory.getLogger(SupervisorServiceImpl.class);
    @Autowired
    private SupervisorDao supervisorDao;

    public int addSupervisor(Supervisor supervisor) {
        return supervisorDao.addSupervisor(supervisor);
    }

    public Map<String, Object> checkUser(Supervisor supervisor) {
        return supervisorDao.checkUser(supervisor);
    }
}
