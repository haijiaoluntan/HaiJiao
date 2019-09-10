package com.haijiao.service.impl;

import com.haijiao.mapper.CommentMapper;
import com.haijiao.pojo.Comment;
import com.haijiao.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentMapper commentMapper;
    
    @Override
    public Integer addComment(Integer uid, Integer pid, String content) {
        return commentMapper.addComment(uid, pid, content);
    }
    
    @Override
    public List<Comment> getCommentList(Integer pid) {
        return commentMapper.getCommentList(pid);
    }
    
    @Override
    public Integer delComm(Integer cid) {
        return commentMapper.delComm(cid);
    }
    
    @Override
    public Integer acceptComm(Integer cid) {
        return commentMapper.acceptComm(cid);
    }
}
