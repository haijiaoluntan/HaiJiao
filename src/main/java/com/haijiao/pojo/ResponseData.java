package com.haijiao.pojo;

import java.io.Serializable;

public class ResponseData implements Serializable {

    private String code;
    private String msg;

    public ResponseData() {
    }

    public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
