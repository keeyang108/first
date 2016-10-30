package com.extra.first.pojo;

import java.util.Date;

/**
 * 预定用户实体
 * Created by Kee on 2016/10/21.
 */
public class User {

    private Long id;
    private String userName;
    private String phone;
    private Integer sex;
    private Integer soft_del;
    private Date createTime;

    public User(Long id, String userName, String phone, Integer sex) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.sex = sex;
        this.createTime = new Date();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getSoft_del() {
        return soft_del;
    }

    public void setSoft_del(Integer soft_del) {
        this.soft_del = soft_del;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", createTime=" + createTime +
                '}';
    }
}
