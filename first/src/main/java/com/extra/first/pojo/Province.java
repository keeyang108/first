package com.extra.first.pojo;

import java.util.Date;
import java.util.List;

/**
 * 经销商所在省份实体
 * Created by Kee on 2016/10/23.
 */
public class Province {
    private Integer id;
    private String provinceName;
    private List<City> cityList;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", provinceName='" + provinceName + '\'' +
                ", cityList=" + cityList +
                ", createTime=" + createTime +
                '}';
    }
}
