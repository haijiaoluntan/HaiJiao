package com.haijiao.service;

import com.haijiao.pojo.Like;

public interface LikeService {
    
    Like getLikeByUidAndCid(Integer uid, Integer cid);
    
    Integer addLike(Integer uid, Integer cid);
    
    Integer cancelLike(Integer uid, Integer cid);
    
    boolean hasLikeByUidAndCid(Integer uid, Integer cid);
}
