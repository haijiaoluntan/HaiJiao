package com.haijiao.service.impl;

import com.haijiao.mapper.FavoriteMapper;
import com.haijiao.pojo.Favorite;
import com.haijiao.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    
    @Autowired
    private FavoriteMapper favoriteMapper;
    
    @Override
    public Integer addFavorite(Integer uid, Integer pid) {
        return favoriteMapper.addFavorite(uid, pid);
    }
    
    @Override
    public Integer cancelFavorite(Integer uid, Integer pid) {
        return favoriteMapper.cancelFavorite(uid, pid);
    }
    
    @Override
    public Favorite isFavorite(Integer uid, Integer pid) {
        return favoriteMapper.isFavorite(uid, pid);
    }
    
    @Override
    public List<Favorite> getMyFavorites(Integer uid) {
        return favoriteMapper.getMyFavorites(uid);
    }
}
