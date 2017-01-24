package com.extra.first.pojo;

import java.util.Date;
import java.util.List;

/**
 * 经销商城市实体
 * Created by Kee on 2016/10/23.
 */
public class City {

    private Integer id;
    private Integer provinceId;
    private String cityName;
    private Province province;
    private Date createTime;
    private List<Agency> agencyList;

    public List<Agency> getAgencyList() {
        return agencyList;
    }

    public void setAgencyList(List<Agency> agencyList) {
        this.agencyList = agencyList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", province=" + province +
                '}';
    }
}
