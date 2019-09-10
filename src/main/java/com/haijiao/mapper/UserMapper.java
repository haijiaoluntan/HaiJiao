
package com.haijiao.mapper;
import com.haijiao.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    
    User queryByEmailPsw(String email, String password);
    
    Integer actication(String email);
    
    Integer insert(User user);
    
    User queryByEmail(String email);

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
}
