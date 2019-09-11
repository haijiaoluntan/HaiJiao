package com.haijiao.mapper;

import com.haijiao.pojo.Like;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeMapper {
    
    /**
     * 查询是否已点赞
     * @param uid
     * @param cid
     * @return
     */
    @Select("select * from likes where uid = #{uid} and cid = #{cid} and state = 1")
    Like getLikeByUidAndCid(Integer uid, Integer cid);
    
    /**
     * 点赞
     * @param uid
     * @param cid
     * @return
     */
    @Insert("insert into likes values(null, #{uid}, #{cid}, sysdate(), 1)")
    Integer addLike(Integer uid, Integer cid);
    
    /**
     * 取消点赞
     * @param uid
     * @param cid
     * @return
     */
    @Update("update likes set state = 0 where uid = #{uid} and cid = #{cid} and state = 1")
    Integer cancelLike(Integer uid, Integer cid);
    
    /**
     * 查询点赞记录
     * @param uid
     * @param cid
     * @return
     */
    @Select("select * from likes where uid = #{uid} and cid = #{cid} and state = 0")
    List<Like> hasLikeByUidAndCid(Integer uid, Integer cid);
}
