package com.haijiao.mapper;

import com.haijiao.pojo.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {
    
    /**
     * 添加消息（评论）
     * @param auid
     * @param suid
     * @param content
     * @param pid
     * @return
     */
    @Insert("insert into message values(null, #{auid}, #{suid}, #{content}, #{pid}, sysdate())")
    Integer addMessage(Integer auid, Integer suid, String content, Integer pid);
    
    /**
     * 我的消息
     * @param uid
     * @return
     */
    List<Message> getMessageByUid(Integer uid);
    
    /**
     * 删除消息
     * @param mid
     * @return
     */
    @Delete("delete from message where mid = #{mid}")
    Integer delMsg(Integer mid);
    
    /**
     * 清空个人消息
     * @param uid
     * @return
     */
    @Delete("delete from message where auid = #{uid}")
    Integer delAllMsg(Integer uid);
}
