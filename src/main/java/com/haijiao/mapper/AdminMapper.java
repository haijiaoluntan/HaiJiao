
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


    @Update("update admin set login_time=#{login_time} where admin=#{admin}")
    public  int updAdmins(@Param("login_time") Date login_time,
                          @Param("admin") String admin);

    @Insert("insert into admin(user,pwd,level)values(#{user},#{pwd},1)")
    public  int addadmin(@Param("user") String user,
                         @Param("pwd") String pwd
    );

    @Select("select aid,USER,LEVEL,login_time from admin where user=#{user} ")
    public Admin seleadmin(@Param("user") String user);

    @Select("SELECT uid,username,pwd FROM users  ")
    public List<User> findall ();

    @Delete("delete from users where uid=#{uid}")
    public int delete(@Param("uid")Integer uid);

    //创建预备表
    @Insert("insert into ready value(#{phone},#{yanzm})")
    public int addReady(@Param("phone") String phone,@Param("yanzm") Integer yanzm);
    //注册验证码检测(即获取手机验证码)
    @Select("select yanzm from ready where phone=#{phone}")
    public Integer selReadyY(String phone);

    //手机注册功能
    @Insert("insert into admin(admin,pwd,phone,phoneyanzm,create_time,rank) values(#{admin},#{pwd},#{phone},#{phoneyanzm},now(),#{rank})")
    public Integer phoneReg(Admin admin);

    //判断是否存在相同用户名
    @Select("select * from admin where admin=#{admin}")
    public Admin selAdmin(String admin);
    //手机登录发送验证码(即修改手机验证码)
    @Update("update admin set phoneyanzm=#{phoneyanzm} where phone=#{phone}")
    public Integer updYzm(@Param("phone")String phone,@Param("phoneyanzm")Integer phoneyanzm);
    //手机登录验证码验证(即获取手机验证码)
    @Select("select phoneyanzm from admin where phone=#{phone}")
    public Integer selYanzm(String phone);
    //查询手机号是否已经注册(也可做用手机号获取管理员信息)
    @Select("select * from admin where phone=#{phone}")
    public Admin selPhone(String phone);


}




