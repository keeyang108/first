package com.extra.first.pojo;

import java.util.Date;

/**
 * Created by Kee on 2016/11/15.
 */
public class VisitRecord {

    private Long id;
    private String ip;
    private Date visitTime;

    public VisitRecord(String ip) {
        this.ip = ip;
    }

    public VisitRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }
}
