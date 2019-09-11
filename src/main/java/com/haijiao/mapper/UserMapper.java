
package com.haijiao.mapper;
import com.haijiao.pojo.City;
import com.haijiao.pojo.Eready;
import com.haijiao.pojo.Province;
import com.haijiao.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {
    
    User queryByEmailPsw(String email, String password);
    
    Integer actication(String email);
    
    /**
     * 根据uid查询user对象
     * @param uid
     * @return
     */
    @Select("select * from user where uid = #{uid}")
    User getUserByUid(Integer uid);

    /**
     * 查询全部用户
     */
    @Select("select * from user")
    List<User> AllUser();

    /**
     * 查询当前页面用户
     */
    @Select("select * from user limit #{page},#{pageSize}")
    List<User> CurrUser(@Param("page") Integer page,@Param("pageSize") Integer pageSize);

    /**
     * 查询用户总数
     */
    @Select("select count(*) from user")
    Integer NumUser();

    /**
     * 注册
     * @param user
     * @return
     */
    @Insert("insert into user(username,password,email) values(#{username},#{password},#{email})")
    Integer addUser(User user);

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
    @Select("select uid, username, sex, email, picture, level, province, city, joindate, signature, balance from user where username = #{username}")
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
     * 获得飞吻
     * @param uid
     * @param balance
     * @return
     */
    @Update("update user set balance = (balance + #{balance}) where uid = #{uid}")
    Integer earnBalance(Integer uid, Integer balance);
    
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
    
    /**
     * 点赞获得经验值，+10
     * @param uid
     * @return
     */
    @Update("update user set exp = (exp + 10) where uid = #{uid}")
    Integer updExpByLike(Integer uid);
    
    /**
     * 评论获得经验值，+20
     * @param uid
     * @return
     */
    @Update("update user set exp = (exp + 20) where uid = #{uid}")
    Integer updExpByComm(Integer uid);
    
    /**
     * 评论排行榜
     * @return
     */
    List<User> getCommRank();
    
    /**
     * 修改密码
     * @param uid
     * @param password
     * @return
     */
    @Update("update user set password = #{password} where uid = #{uid}")
    Integer changePwdByUid(Integer uid, String password);
    
    /**
     * 查询所有省份
     * @return
     */
    @Select("select * from province")
    List<Province> queryAllProvince();
    
    /**
     * 查询此省份下所有城市
     * @param pid
     * @return
     */
    @Select("select * from city where pid = #{pid}")
    List<City> queryCitysByPid(Integer pid);
    
    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @Update("update user set email = #{email}, username = #{username}, sex = #{sex}, province = #{province}, city = #{city}, signature = #{signature} where uid = #{uid}")
    Integer updInfo(User user);
}
