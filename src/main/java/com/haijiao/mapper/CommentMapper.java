package com.haijiao.mapper;

import com.haijiao.pojo.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    
    /**
     * 新增评论
     * @param uid
     * @param pid
     * @param content
     * @return
     */
    @Insert("insert into comment values(null, #{pid}, #{uid}, sysdate(), 0, #{content})")
    Integer addComment(Integer uid, Integer pid, String content);
    
    /**
     * 根据pid获得所有评论
     * @param pid
     * @return
     */
    List<Comment> getCommentList(Integer pid);
    
    /**
     * 删除评论
     * @param cid
     * @return
     */
    @Delete("delete from comment where cid = #{cid}")
    Integer delComm(Integer cid);
    
    /**
     * 采纳评论
     * @param cid
     * @return
     */
    @Update("update comment set accept = 1 where cid = #{cid}")
    Integer acceptComm(Integer cid);
    
    /**
     * 用户最近的评论
     * @param uid
     * @return
     */
    List<Comment> getCommListByUid(Integer uid);
}
