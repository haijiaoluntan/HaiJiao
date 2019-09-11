package com.haijiao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论类
 */
public class Comment implements Serializable {
    
    private static final long serialVersionUID = 1968437707014025226L;
    private Integer cid;        //评论id
    private Integer pid;        //所属帖子id
    private User user;          //评论人
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cdate;         //评论时间
    private Integer likes;      //点赞数
    private Integer accept;     //是否采纳
    private String content;     //评论内容
    private String title;       //所属帖子标题
    
    public Integer getCid() {
        return cid;
    }
    
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    
    public Integer getPid() {
        return pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Date getCdate() {
        return cdate;
    }
    
    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
    
    public Integer getLikes() {
        return likes;
    }
    
    public void setLikes(Integer likes) {
        this.likes = likes;
    }
    
    public Integer getAccept() {
        return accept;
    }
    
    public void setAccept(Integer accept) {
        this.accept = accept;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment").append('[')
                .append("cid=")
                .append(cid)
                .append(", pid=")
                .append(pid)
                .append(", user=")
                .append(user)
                .append(", cdate=")
                .append(cdate)
                .append(", likes=")
                .append(likes)
                .append(", accept=")
                .append(accept)
                .append(", content=")
                .append(content)
                .append(", title=")
                .append(title)
                .append(']');
        return sb.toString();
    }
}
