package com.extra.first.service;

import com.extra.first.pojo.Agency;

import java.util.List;

/**
 * Created by Kee on 2016/10/26.
 */
public interface AgencyService {

    int addAgency(Agency agency);

    List<Agency> queryAgenciesByCityId(int cityId, int offset, int limit);
}
