package com.extra.first.service.impl;

import com.extra.first.dao.AgencyDao;
import com.extra.first.pojo.Agency;
import com.extra.first.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kee on 2016/10/26.
 */
@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyDao agencyDao;

    public int addAgency(Agency agency) {
        return 0;
    }

    public List<Agency> queryAgenciesByCityId(int cityId, int offset, int limit) {
        return agencyDao.queryAgenciesByCityId(cityId, offset, limit);
    }
}
