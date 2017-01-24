package com.extra.first.dao;

import com.extra.first.pojo.City;
import com.extra.first.pojo.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Kee on 2016/10/23.
 */
public interface ProvinceDao {

    /**
     * 添加省份
     * @param province
     * @return
     */
    int addProvince(@Param("province") Province province);

    /**
     * 获取省份列表
     * @param offset
     * @param limit
     * @return
     */
    List<Province> listProvince(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据Id查询对应记录
     * @param provinceId
     * @return
     */
    Province queryProvinceById(int provinceId);

    /**
     * 根据省份Id获取之下的城市
     * @param provinceId
     * @param offset
     * @param limit
     * @return
     */
    List<City> queryCitiesByProvinceId(@Param("provinceId") int provinceId, @Param("offset") int offset, @Param("limit") int limit);
}
