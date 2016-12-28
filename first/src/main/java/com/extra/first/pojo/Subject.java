package com.extra.first.pojo;

import java.util.Date;

/**
 * 专题Pojo
 * Created by Administrator on 2016/12/28.
 */
public class Subject {

    private Integer id;
    private String name;
    private String url;
    private String description;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private Long viewCount;

    public Subject(String name, String url, String description, Date createTime, Integer status) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.createTime = createTime;
        this.status = status;
    }

    public Subject(Integer id, String name, String url, String description, Date updateTime, Integer status) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.updateTime = updateTime;
        this.status = status;
    }

    public Subject() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", viewCount=" + viewCount +
                '}';
    }
}
