package com.haijiao.pojo;

import java.util.Date;

/**
 * @Description: 短信查询实体
 * @Date: 15:51 2019/4/18
 * @Version: V1.0
 */
public class SmsQuery {
    private String bizId;
    private String phoneNumber;
    private Date sendDate;
    private Long pageSize;
    private Long currentPage;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }
}
