package com.extra.first.pojo;

import java.util.Date;

/**
 * 订单实体
 * Created by Kee on 2016/10/23.
 */
public class Order {
    private Long id;
    private String userName;
    private String userPhone;
    private Integer userSex;
    private Integer agencyId;
    private Integer cityId;
    private Integer provinceId;
    private Integer channelId;
    private Integer carTypeId;
    private Date createTime;
    private Date updateTime;
    private Integer status;

    private Agency agency;
    private Car car;
    private Channel channel;

    public Order(String userName, String userPhone, Integer userSex, Integer agencyId, Integer cityId, Integer provinceId, Integer channelId, Integer carTypeId) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userSex = userSex;
        this.agencyId = agencyId;
        this.cityId = cityId;
        this.provinceId = provinceId;
        this.channelId = channelId;
        this.carTypeId = carTypeId;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(Integer carTypeId) {
        this.carTypeId = carTypeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userSex=" + userSex +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", agency=" + agency +
                ", car=" + car +
                ", channel=" + channel +
                '}';
    }
}
