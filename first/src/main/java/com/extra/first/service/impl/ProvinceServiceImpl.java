package com.extra.first.service.impl;

import com.extra.first.dao.ProvinceDao;
import com.extra.first.pojo.Province;
import com.extra.first.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kee on 2016/10/26.
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceDao provinceDao;

    public List<Province> listProvince(int offset, int limit) {
        return provinceDao.listProvince(offset, limit);
    }

    public int addProvince(Province province) {
        return provinceDao.addProvince(province);
    }
}
