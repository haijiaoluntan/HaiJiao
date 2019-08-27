package com.haijiao.service;

import com.haijiao.pojo.User;

import java.util.Date;

public interface UserService {
    User queryByEmailPsw(String email, String password);
    Integer actication(String email);
    Integer insert(User user);
    User queryByEmail(String email);
    Integer updatejoindate(String email);
}
