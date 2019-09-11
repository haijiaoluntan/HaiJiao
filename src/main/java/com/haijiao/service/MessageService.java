package com.haijiao.service;

import com.haijiao.pojo.Message;

import java.util.List;

public interface MessageService {
    
    Integer addMessage(Integer auid, Integer suid, String content, Integer pid);
    
    List<Message> getMessageByUid(Integer uid);
    
    Integer delMsg(Integer mid);
    
    Integer delAllMsg(Integer uid);
}
