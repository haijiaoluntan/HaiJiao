package com.haijiao.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏类
 */
public class Favorite implements Serializable {
    
    private static final long serialVersionUID = 3978370854633126145L;
    private Integer fid;
    private Integer uid;
    private Post post;
    private Date fdate;
    
    public Integer getFid() {
        return fid;
    }
    
    public void setFid(Integer fid) {
        this.fid = fid;
    }
    
    public Integer getUid() {
        return uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    public Post getPost() {
        return post;
    }
    
    public void setPost(Post post) {
        this.post = post;
    }
    
    public Date getFdate() {
        return fdate;
    }
    
    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Favorite").append('[')
                .append("fid=")
                .append(fid)
                .append(", uid=")
                .append(uid)
                .append(", post=")
                .append(post)
                .append(", fdate=")
                .append(fdate)
                .append(']');
        return sb.toString();
    }
}
