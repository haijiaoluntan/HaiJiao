package com.haijiao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息通知类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    
    private static final long serialVersionUID = 7816382067509167921L;
    private Integer mid;
    private Integer auid;
    private Integer suid;
    private String content;
    private Integer pid;
    private String ausername;
    private String title;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date mdate;
}
