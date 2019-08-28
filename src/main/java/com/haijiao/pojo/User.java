package com.haijiao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    
    private static final long serialVersionUID = 4344380176085309393L;
    private Integer uid;
    private String username;
    private String password;
    private String phone;
    private String sex;
    private String picture;
    private Integer level;
    private Integer exp;
    private Integer province;
    private Integer city;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date joindate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date start_date;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date end_date;
    private String signature;
    private Double balance;
    private  String  email;
    private  Integer act;
    private  String actcode;
    
    public User() {
    }
    
    public Integer getUid() {
        return uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
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

    public User(String username, String password, String phone, String sex, String picture, Integer level, Integer exp, Integer province, Integer city, Date joindate, Date start_date, Date end_date, String signature, Double balance, String email, Integer act, String actcode) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.picture = picture;
        this.level = level;
        this.exp = exp;
        this.province = province;
        this.city = city;
        this.joindate = joindate;
        this.start_date = start_date;
        this.end_date = end_date;
        this.signature = signature;
        this.balance = balance;
        this.email = email;
        this.act = act;
        this.actcode = actcode;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", picture='" + picture + '\'' +
                ", level=" + level +
                ", exp=" + exp +
                ", province=" + province +
                ", city=" + city +
                ", joindate=" + joindate +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", signature='" + signature + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", act=" + act +
                ", actcode='" + actcode + '\'' +
                '}';
    }
}
