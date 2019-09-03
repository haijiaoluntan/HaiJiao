/*
package com.haijiao.mapper;
import com.haijiao.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("userMapper")
public interface UserMapper {
    
    User queryByEmailPsw(String email, String password);
    
    Integer actication(String email);
    
    Integer insert(User user);
    
    User queryByEmail(String email);
    
    */
/**
     * 修改登录时间
     * @param uid
     * @return
     *//*

    @Update("update user set logindate = sysdate() where uid = #{uid}")
    Integer updateLoginDate(Integer uid);
    
    */
/**
     * 通过昵称查询用户
     * @param username
     * @return
     *//*

    @Select("select * from user where username = #{username}")
    User queryByUsername(String username);
}
*/
