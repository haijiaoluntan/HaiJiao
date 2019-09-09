
package com.haijiao.mapper;
import com.haijiao.pojo.Eready;
import com.haijiao.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    
    User queryByEmailPsw(String email, String password);
    
    Integer actication(String email);

    /**
     * 注册
     * @param user
     * @return
     */
    @Insert("insert into user(username,password,email) values(#{username},#{password},#{email})")
    Integer insert(User user);

    /**
     * 查询邮箱是否注册
     * @param email
     * @return
     */
    @Select("select * from user where email=#{email}")
    User queryByEmail(String email);

    /**
     * 查询邮箱验证码
     * @param email
     * @return
     */
    @Select("select yzm from eready where email=#{email}")
    public String selemaily(String email);

    /**
     * 创建验证表
     * @param email
     * @param yzm
     * @return
     */
    @Insert("insert into eready value(#{email},#{yzm})")
    public int fsyanzm(@Param("email")String email,@Param("yzm")String yzm);

/**
     * 修改登录时间
     * @param uid
     * @return
     */

    @Update("update user set logindate = sysdate() where uid = #{uid}")
    Integer updateLoginDate(Integer uid);

/**
     * 通过昵称查询用户
     * @param username
     * @return
     */

    @Select("select * from user where username = #{username}")
    User queryByUsername(String username);
    
    /**
     * 使用飞吻
     * @param uid
     * @param balance
     * @return
     */
    @Update("update user set balance = (balance - #{balance}) where uid = #{uid}")
    Integer useBalance(Integer uid, Integer balance);
    
    /**
     * 更新等级
     * @param uid
     * @return
     */
    @Update("update user set level = (level + 1) where uid = #{uid}")
    Integer updLevel(Integer uid);
    
    /**
     * 发帖获得经验值，+25
     * @param uid
     * @return
     */
    @Update("update user set exp = (exp + 25) where uid = #{uid}")
    Integer updExpByPosts(Integer uid);


}
