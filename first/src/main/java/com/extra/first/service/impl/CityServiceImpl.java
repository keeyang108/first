package com.extra.first.service.impl;

import com.extra.first.dao.CityDao;
import com.extra.first.pojo.City;
import com.extra.first.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kee on 2016/10/26.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public List<City> queryCitiesByProvinceId(int provinceId, int offset, int limit) {
        return cityDao.queryCitiesByProvinceId(provinceId, offset, limit);
    }
}
