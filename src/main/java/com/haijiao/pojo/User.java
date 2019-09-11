package com.haijiao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    
    private static final long serialVersionUID = 4344380176085309393L;
    private Integer uid;        //用户id
    private String username;    //昵称
    private String password;    //密码
    private String phone;       //手机号
    private String sex;         //性别
    private String picture;     //头像url
    private Integer level;      //等级
    private Integer exp;        //经验值
    private Integer province;   //省份
    private Integer city;       //城市
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date joindate;      //账号创建时间
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginDate;    //上次登录时间
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date end_date;      //上次下线时间
    private String signature;   //个性签名
    private Double balance;     //账户余额
    private String email;       //绑定邮箱
    private Integer act;        //邮箱是否激活
    private String actcode;     //邮箱激活码
    private Integer commCount;  //评论总数
    
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

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
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
    
    public Integer getCommCount() {
        return commCount;
    }
    
    public void setCommCount(Integer commCount) {
        this.commCount = commCount;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User").append('[')
                .append("uid=")
                .append(uid)
                .append(", username=")
                .append(username)
                .append(", password=")
                .append(password)
                .append(", phone=")
                .append(phone)
                .append(", sex=")
                .append(sex)
                .append(", picture=")
                .append(picture)
                .append(", level=")
                .append(level)
                .append(", exp=")
                .append(exp)
                .append(", province=")
                .append(province)
                .append(", city=")
                .append(city)
                .append(", joindate=")
                .append(joindate)
                .append(", loginDate=")
                .append(loginDate)
                .append(", end_date=")
                .append(end_date)
                .append(", signature=")
                .append(signature)
                .append(", balance=")
                .append(balance)
                .append(", email=")
                .append(email)
                .append(", act=")
                .append(act)
                .append(", actcode=")
                .append(actcode)
                .append(", commCount=")
                .append(commCount)
                .append(']');
        return sb.toString();
    }
}
