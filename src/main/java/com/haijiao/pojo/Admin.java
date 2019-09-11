package com.haijiao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//使用了lombak插件
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {
    private static final long serialVersionUID = 4960310662539928636L;
    private int aid;
    private String admin;
    private String pwd;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss", timezone = "GMT+8")
    private Date login_time;
    private String phone;
    private Integer phoneyanzm;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss", timezone = "GMT+8")
    private Date create_time;
    private Integer rank;
    private DataAuth dataAuth;
    private OperAuth operAuth;
}
