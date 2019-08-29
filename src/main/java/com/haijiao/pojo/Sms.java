package com.haijiao.pojo;

public class Sms {
    /**
     * 手机号
     */
    private String phoneNumbers;

    /**
     * 模板参数 格式："{\"code\":\"123456\"}"
     */
    private String templateParam;

    private String outId;

    /**
     * 阿里云模板管理code
     */
    private String templateCode;

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(String templateParam) {
        this.templateParam = templateParam;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }
}
