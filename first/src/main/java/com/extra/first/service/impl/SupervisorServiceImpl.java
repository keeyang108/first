package com.extra.first.service.impl;

import com.extra.first.dao.SupervisorDao;
import com.extra.first.mapper.SupervisorMapper;
import com.extra.first.model.Supervisor;
import com.extra.first.model.SupervisorExample;
import com.extra.first.service.SupervisorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kee on 2016/10/30.
 */
@Service
public class SupervisorServiceImpl implements SupervisorService {

    Logger logger = LoggerFactory.getLogger(SupervisorServiceImpl.class);
    
    @Autowired
    private SupervisorDao supervisorDao;

    public int addSupervisor(Supervisor supervisor) {
        return supervisorDao.insert(supervisor);
    }

    public Supervisor checkUser(Supervisor supervisor) {
        SupervisorExample example = new SupervisorExample();
        example.createCriteria().andSupervisorNameEqualTo(supervisor.getSupervisorName()).andPasswordEqualTo(supervisor.getPassword());
        List<Supervisor>  result = supervisorDao.selectByExample(example);
        if (null != result && result.size() > 0){
            return result.get(0);
        }
        return null;
    }

    public Supervisor selectUserByUserName(String userName) {
        SupervisorExample example = new SupervisorExample();
        example.createCriteria().andSupervisorNameEqualTo(userName);
        List<Supervisor>  result = supervisorDao.selectByExample(example);
        if (null != result && result.size() > 0){
            return result.get(0);
        }
        return null;
    }
}
