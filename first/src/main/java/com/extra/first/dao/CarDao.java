package com.extra.first.dao;

import com.extra.first.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Kee on 2016/10/26.
 */
public interface CarDao {

    /**
     * 查询所有车型
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Car> listCar(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 添加车型
     *
     * @param car
     * @return
     */
    int addCar(Car car);
}
