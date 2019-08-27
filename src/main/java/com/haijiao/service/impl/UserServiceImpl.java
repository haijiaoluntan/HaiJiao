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
    public User queryByEmailPsw(String email, String password, String username, Date joindate) {
        return userMapper.queryByEmailPsw(email,password,username,joindate);
    }

    @Override
    public Integer actication(String email) {
        return userMapper.actication(email);
    }

    @Override
    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User queryByEmail(Integer email) {
        return userMapper.queryByEmail(email);
    }
}
