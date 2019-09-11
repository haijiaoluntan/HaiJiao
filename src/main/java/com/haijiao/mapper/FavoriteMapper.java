package com.haijiao.mapper;

import com.haijiao.pojo.Favorite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteMapper {
    
    /**
     * 添加收藏
     * @param uid
     * @param pid
     * @return
     */
    @Insert("insert into favorites values(null, #{uid}, #{pid}, sysdate())")
    Integer addFavorite(Integer uid, Integer pid);
    
    /**
     * 取消收藏
     * @param uid
     * @param pid
     * @return
     */
    @Delete("delete from favorites where uid = #{uid} and pid = #{pid}")
    Integer cancelFavorite(Integer uid, Integer pid);
    
    /**
     * 判断是否已收藏
     * @param uid
     * @param pid
     * @return
     */
    Favorite isFavorite(Integer uid, Integer pid);
    
    /**
     * 我收藏的帖
     * @param uid
     * @return
     */
    List<Favorite> getMyFavorites(Integer uid);
}
