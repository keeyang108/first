package com.extra.first.service;

import com.extra.first.pojo.City;

import java.util.List;

/**
 * Created by Kee on 2016/10/26.
 */
public interface CityService {

    List<City> queryCitiesByProvinceId(int provinceId, int offset, int limit);
}
