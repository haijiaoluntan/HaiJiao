
package com.haijiao.service;

import com.haijiao.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserService {
    
    User queryByEmailPsw(String email, String password);
    
    Integer actication(String email);
    
    Integer addUser(User user);
    
    User queryByEmail(String email);
    
    Integer updateLoginDate(Integer uid);
    
    User queryByUsername(String username);
    
    Integer useBalance(Integer uid, Integer balance);
    
    Integer updLevel(Integer uid);
    
    Integer updExpByPosts(Integer uid);

    public int fsyanzm(@Param("email")String email, @Param("yzm")String yzm);

    public String elemaily(String email);
    
    Integer updExpByLike(Integer uid);
    
    Integer updExpByComm(Integer uid);
    
    Integer earnBalance(Integer uid, Integer balance);
}

