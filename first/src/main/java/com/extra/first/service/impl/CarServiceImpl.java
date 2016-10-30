package com.extra.first.service.impl;

import com.extra.first.dao.CarDao;
import com.extra.first.pojo.Car;
import com.extra.first.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kee on 2016/10/28.
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    public List<Car> listCar(int offset, int limit) {
        return carDao.listCar(offset, limit);
    }
}
