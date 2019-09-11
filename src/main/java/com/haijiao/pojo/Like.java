package com.haijiao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 点赞类
 */
public class Like implements Serializable {
    
    private static final long serialVersionUID = 4659199345693398231L;
    private Integer lid;
    private Integer uid;
    private Integer cid;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ldate;
    
    public Integer getLid() {
        return lid;
    }
    
    public void setLid(Integer lid) {
        this.lid = lid;
    }
    
    public Integer getUid() {
        return uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    public Integer getCid() {
        return cid;
    }
    
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    
    public Date getLdate() {
        return ldate;
    }
    
    public void setLdate(Date ldate) {
        this.ldate = ldate;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Like").append('[')
                .append("lid=")
                .append(lid)
                .append(", uid=")
                .append(uid)
                .append(", cid=")
                .append(cid)
                .append(", ldate=")
                .append(ldate)
                .append(']');
        return sb.toString();
    }
}
