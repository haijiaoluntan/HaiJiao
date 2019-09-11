package com.haijiao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子实体类
 */
public class Post implements Serializable {
    
    private static final long serialVersionUID = 1120892183929245142L;
    private Integer pid;        //帖子id
    private Integer uid;        //发帖人id
    private String title;       //标题
    private String type;        //类型
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date pubDate;       //发表时间
    private Integer jing;       //是否精品
    private Integer top;        //是否置顶
    private Integer jie;        //是否已结帖
    private Integer browse;     //浏览人数
    private Integer reward;     //悬赏飞吻数
    private Integer rstate;     //是否已悬赏
    private String content;     //帖子内容
    private Integer state;      //审核状态
    
    public Post() {
    }
    
    public Post(Integer pid, Integer uid, String title, String type, Date pubDate, Integer jing, Integer top, Integer jie, Integer browse, Integer reward, Integer rstate, String content) {
        this.pid = pid;
        this.uid = uid;
        this.title = title;
        this.type = type;
        this.pubDate = pubDate;
        this.jing = jing;
        this.top = top;
        this.jie = jie;
        this.browse = browse;
        this.reward = reward;
        this.rstate = rstate;
        this.content = content;
    }
    
    public Post(Integer pid, Integer uid, String title, String type, Date pubDate, Integer jing, Integer top, Integer jie, Integer browse, Integer reward, Integer rstate, String content, Integer state) {
        this.pid = pid;
        this.uid = uid;
        this.title = title;
        this.type = type;
        this.pubDate = pubDate;
        this.jing = jing;
        this.top = top;
        this.jie = jie;
        this.browse = browse;
        this.reward = reward;
        this.rstate = rstate;
        this.content = content;
        this.state = state;
    }
    
    public Integer getPid() {
        return pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    
    public Integer getUid() {
        return uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public Date getPubDate() {
        return pubDate;
    }
    
    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
    
    public Integer getJing() {
        return jing;
    }
    
    public void setJing(Integer jing) {
        this.jing = jing;
    }
    
    public Integer getTop() {
        return top;
    }
    
    public void setTop(Integer top) {
        this.top = top;
    }
    
    public Integer getJie() {
        return jie;
    }
    
    public void setJie(Integer jie) {
        this.jie = jie;
    }
    
    public Integer getBrowse() {
        return browse;
    }
    
    public void setBrowse(Integer browse) {
        this.browse = browse;
    }
    
    public Integer getReward() {
        return reward;
    }
    
    public void setReward(Integer reward) {
        this.reward = reward;
    }
    
    public Integer getRstate() {
        return rstate;
    }
    
    public void setRstate(Integer rstate) {
        this.rstate = rstate;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Integer getState() {
        return state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Post").append('[')
                .append("pid=")
                .append(pid)
                .append(", uid=")
                .append(uid)
                .append(", title=")
                .append(title)
                .append(", type=")
                .append(type)
                .append(", pubDate=")
                .append(pubDate)
                .append(", jing=")
                .append(jing)
                .append(", top=")
                .append(top)
                .append(", jie=")
                .append(jie)
                .append(", browse=")
                .append(browse)
                .append(", reward=")
                .append(reward)
                .append(", rstate=")
                .append(rstate)
                .append(", content=")
                .append(content)
                .append(", state=")
                .append(state)
                .append(']');
        return sb.toString();
    }
}
