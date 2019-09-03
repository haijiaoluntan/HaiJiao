/*
package com.haijiao.service.impl;

import com.haijiao.mapper.UserMapper;
import com.haijiao.pojo.User;
import com.haijiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    
    @Override
    public User queryByEmail(String email) {
        
        return userMapper.queryByEmail(email);
    }
    
    @Override
    public Integer updateLoginDate(Integer uid) {
        return userMapper.updateLoginDate(uid);
    }
    
    @Override
    public User queryByUsername(String username) {
        return userMapper.queryByUsername(username);
    }
    
    */
/**
     * 登录
     *
     * @param email
     * @param password
     * @return
     *//*

    @Override
    public User queryByEmailPsw(String email, String password) {
        User user = userMapper.queryByEmailPsw(email, password);
        System.out.println("登录：获得账号信息" + user);
        if (user != null) {
            Integer i = userMapper.updateLoginDate(user.getUid());
            if (i > 0) {
                System.out.println("登录:成功修改登录时间");
            }
        }
        return user;
    }
    
    @Override
    public Integer actication(String email) {
        return userMapper.actication(email);
    }
    
    */
/**
     * 注册
     *
     * @param user
     * @return
     *//*

    @Override
    public Integer insert(User user) {
        Integer i = userMapper.insert(user);
        if (i > 0) {
            System.out.println("注册:注册成功");
            return i;
        } else {
            System.out.println("注册:注册失败");
            return i;
        }
    }
}
*/
