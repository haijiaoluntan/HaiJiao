package com.haijiao.service.impl;

import com.haijiao.mapper.MessageMapper;
import com.haijiao.pojo.Message;
import com.haijiao.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    
    @Autowired
    private MessageMapper messageMapper;
    
    @Override
    public Integer addMessage(Integer auid, Integer suid, String content, Integer pid) {
        return messageMapper.addMessage(auid, suid, content, pid);
    }
    
    @Override
    public List<Message> getMessageByUid(Integer uid) {
        return messageMapper.getMessageByUid(uid);
    }
    
    @Override
    public Integer delMsg(Integer mid) {
        return messageMapper.delMsg(mid);
    }
    
    @Override
    public Integer delAllMsg(Integer uid) {
        return messageMapper.delAllMsg(uid);
    }
}
