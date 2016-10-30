package com.extra.first.service;

import com.extra.first.pojo.Car;

import java.util.List;

/**
 * Created by Kee on 2016/10/26.
 */
public interface CarService {

    List<Car> listCar(int offset, int limit);
}
