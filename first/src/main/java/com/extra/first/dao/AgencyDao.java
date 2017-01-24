package com.extra.first.dao;

import com.extra.first.pojo.Agency;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Kee on 2016/10/23.
 */
public interface AgencyDao {

    /**
     * 添加经销商
     *
     * @param agency
     * @return
     */
    int addAgency(@Param("agency") Agency agency);

    /**
     * 修改经销商资料
     *
     * @param agency
     * @return
     */
    int updateAgency(Agency agency);


    /**
     * 获取之下的经销商名单
     *
     * @param cityId
     * @param offset
     * @param limit
     * @return
     */
    List<Agency> queryAgenciesByCityId(@Param("cityId") int cityId, @Param("offset") int offset, @Param("limit") int limit);
}
