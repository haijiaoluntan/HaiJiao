package com.haijiao.service.impl;

import com.haijiao.mapper.LikeMapper;
import com.haijiao.pojo.Like;
import com.haijiao.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    
    @Autowired
    private LikeMapper likeMapper;
    
    @Override
    public Like getLikeByUidAndCid(Integer uid, Integer cid) {
        return likeMapper.getLikeByUidAndCid(uid, cid);
    }
    
    @Override
    public Integer addLike(Integer uid, Integer cid) {
        return likeMapper.addLike(uid, cid);
    }
    
    @Override
    public Integer cancelLike(Integer uid, Integer cid) {
        return likeMapper.cancelLike(uid, cid);
    }
    
    @Override
    public boolean hasLikeByUidAndCid(Integer uid, Integer cid) {
        
        List<Like> likes = likeMapper.hasLikeByUidAndCid(uid, cid);
        if (likes.size() == 0) {
            return false;
        } else {
            return true;
        }
        
    }
}
