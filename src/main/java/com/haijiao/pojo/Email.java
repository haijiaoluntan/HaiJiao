package com.haijiao.pojo;

import java.io.Serializable;

public class Email implements Serializable {
    private Integer eid;
    private Integer uid;
    private  String  email;
    private  Integer act;
    private  String actcode;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAct() {
        return act;
    }

    public void setAct(Integer act) {
        this.act = act;
    }

    public String getActcode() {
        return actcode;
    }

    public void setActcode(String actcode) {
        this.actcode = actcode;
    }

    public Email() {
    }

    public Email(Integer eid, Integer uid, String email, Integer act, String actcode) {
        this.eid = eid;
        this.uid = uid;
        this.email = email;
        this.act = act;
        this.actcode = actcode;
    }

    @Override
    public String toString() {
        return "Email{" +
                "eid=" + eid +
                ", uid=" + uid +
                ", email='" + email + '\'' +
                ", act=" + act +
                ", actcode='" + actcode + '\'' +
                '}';
    }
}
