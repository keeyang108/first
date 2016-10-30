package com.extra.first.service;

import com.extra.first.pojo.Province;

import java.util.List;

/**
 * Created by Kee on 2016/10/26.
 */
public interface ProvinceService {

    List<Province> listProvince(int offset, int limit);

    int addProvince(String provinceName);

}
