package com.haijiao.service;

import com.haijiao.pojo.Comment;

import java.util.List;

public interface CommentService {
    
    Integer addComment(Integer uid, Integer pid, String content);
    
    List<Comment> getCommentList(Integer pid);
    
    Integer delComm(Integer cid);
    
    Integer acceptComm(Integer cid);
    
    List<Comment> getCommListByUid(Integer uid);
}
