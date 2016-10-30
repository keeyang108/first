package com.extra.first.pojo;

import com.extra.first.util.EncryptUtil;

import java.util.Date;

/**
 * Created by Kee on 2016/10/23.
 */
public class Supervisor {
    private Integer id;
    private String supervisorName;
    private String supervisorPhone;
    private String password;
    private Integer sex;
    private Date birthday;
    private Integer qq;
    private String email;
    private String headImagePath;
    private Date createTime;
    private Integer status;

    public Supervisor(String supervisorName, String supervisorPhone, String password, Integer sex, Date birthday, Integer qq, String email, String headImagePath) {
        this.supervisorName = supervisorName;
        this.supervisorPhone = supervisorPhone;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.qq = qq;
        this.email = email;
        this.headImagePath = headImagePath;
    }

    public Supervisor() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getSupervisorPhone() {
        return supervisorPhone;
    }

    public void setSupervisorPhone(String supervisorPhone) {
        this.supervisorPhone = supervisorPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = EncryptUtil.MD5Encrypt(password);
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }
}
