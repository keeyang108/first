package com.extra.first.dao;

import com.extra.first.pojo.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Kee on 2016/10/23.
 */
public interface CityDao {

    /**
     * 添加城市
     *
     * @param provinceId
     * @param cityName
     * @return
     */
    int addCity(@Param("provinceId") int provinceId, @Param("cityName") String cityName);

    /**
     * 根据Id获取记录
     *
     * @param cityId
     * @return
     */
    City queryCityById(int cityId);


    /**
     * 根据省份Id获取之下的城市
     *
     * @param provinceId
     * @param offset
     * @param limit
     * @return
     */
    List<City> queryCitiesByProvinceId(@Param("provinceId") int provinceId, @Param("offset") int offset, @Param("limit") int limit);

}
