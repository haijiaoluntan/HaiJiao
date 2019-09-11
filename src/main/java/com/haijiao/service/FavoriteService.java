package com.haijiao.service;

import com.haijiao.pojo.Favorite;

import java.util.List;

public interface FavoriteService {
    
    Integer addFavorite(Integer uid, Integer pid);
    
    Integer cancelFavorite(Integer uid, Integer pid);
    
    Favorite isFavorite(Integer uid, Integer pid);
    
    List<Favorite> getMyFavorites(Integer uid);
}
