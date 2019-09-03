
package com.haijiao.mapper;

import com.haijiao.pojo.Admin;
import com.haijiao.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AdminMapper {
    @Select("select user from admin where user=#{user} and pwd=#{pwd}")
    public String adminlogin(@Param("user") String user,
                             @Param("pwd") String pwd);


    @Update("update admin set login_time=#{login_time} where user=#{user}")
    public  int updAdmins(@Param("login_time") Date login_time,
                          @Param("user") String user);

    @Insert("insert into admin(user,pwd,level)values(#{user},#{pwd},1)")
    public  int addadmin(@Param("user") String user,
                         @Param("pwd") String pwd
    );

    @Select("select id,USER,LEVEL,login_time from admin where user=#{user} ")
    public Admin seleadmin(@Param("user") String user);

    @Select("SELECT uid,username,pwd FROM users  ")
    public List<User> findall ();

    @Delete("delete from users where uid=#{uid}")
    public int delete(@Param("uid")Integer uid);

}




