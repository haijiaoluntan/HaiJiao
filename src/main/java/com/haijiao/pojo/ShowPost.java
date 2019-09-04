package com.haijiao.pojo;

/**
 * 展示帖子实体类
 */
public class ShowPost extends Post{
    
    private static final long serialVersionUID = -1187065592821913432L;
    private User user;              //发帖人对象
    private Integer commCount;      //帖子评论数
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Integer getCommCount() {
        return commCount;
    }
    
    public void setCommCount(Integer commCount) {
        this.commCount = commCount;
    }
    
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("ShowPost").append('[')
//                .append("user=")
//                .append(user)
//                .append(", commCount=")
//                .append(commCount)
//                .append(']');
//        return sb.toString();
//    }
}
