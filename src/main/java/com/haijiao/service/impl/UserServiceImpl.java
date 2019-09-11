package com.haijiao.service.impl;

import com.haijiao.mapper.UserMapper;
import com.haijiao.pojo.City;
import com.haijiao.pojo.Province;
import com.haijiao.pojo.User;
import com.haijiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer NumUser() {
        return userMapper.NumUser();
    }

    @Override
    public List<User> CurrUser(Integer page, Integer pageSize) {
        return userMapper.CurrUser(page,pageSize);
    }

    @Override
    public List<User> AllUser() {
        return userMapper.AllUser();
    }

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
    
    @Override
    public Integer useBalance(Integer uid, Integer balance) {
        return userMapper.useBalance(uid, balance);
    }
    
    @Override
    public Integer updLevel(Integer uid) {
        return userMapper.updLevel(uid);
    }
    
    @Override
    public Integer updExpByPosts(Integer uid) {
        return userMapper.updExpByPosts(uid);
    }
    
    @Override
    public int fsyanzm(String email, String yzm) {
        return userMapper.fsyanzm(email, yzm);
    }
    
    @Override
    public String elemaily(String email) {
        return userMapper.selemaily(email);
    }
    
    @Override
    public Integer updExpByLike(Integer uid) {
        return userMapper.updExpByLike(uid);
    }
    
    @Override
    public Integer updExpByComm(Integer uid) {
        return userMapper.updExpByComm(uid);
    }
    
    @Override
    public Integer earnBalance(Integer uid, Integer balance) {
        return userMapper.earnBalance(uid, balance);
    }
    
    @Override
    public List<User> getCommRank() {
        return userMapper.getCommRank();
    }
    
    @Override
    public User getUserByUid(Integer uid) {
        return userMapper.getUserByUid(uid);
    }
    
    @Override
    public Integer changePwdByUid(Integer uid, String password) {
        return userMapper.changePwdByUid(uid, password);
    }
    
    @Override
    public List<Province> queryAllProvince() {
        return userMapper.queryAllProvince();
    }
    
    @Override
    public List<City> queryCitysByPid(Integer pid) {
        return userMapper.queryCitysByPid(pid);
    }
    
    @Override
    public Integer updInfo(User user) {
        return userMapper.updInfo(user);
    }
    
    /**
     * 登录
     *
     * @param email
     * @param password
     * @return
     */
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
    
    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public Integer addUser(User user) {
        Integer i = userMapper.addUser(user);
        if (i > 0) {
            System.out.println("注册:注册成功");
            return i;
        } else {
            System.out.println("注册:注册失败");
            return i;
        }
    }
}
