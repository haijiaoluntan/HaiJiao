
package com.haijiao.service.impl;

import com.haijiao.mapper.AdminMapper;
import com.haijiao.pojo.Admin;
import com.haijiao.pojo.User;
import com.haijiao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String adminlogin(String user, String pwd) {
        return adminMapper.adminlogin(user,pwd);
    }

    @Override
    public int updAdmins(Date login_time, String user) {
        return adminMapper.updAdmins(login_time,user);
    }


    @Override
    public int addadmin(String user, String pwd) {
        return adminMapper.addadmin(user,pwd);
    }

    @Override
    public Admin seleadmin(String user) {
        return adminMapper.seleadmin(user);
    }

    @Override
    public List<User> findall() {
        return adminMapper.findall();
    }

    @Override
    public int delete(Integer uid) {
        return adminMapper.delete(uid);
    }


}

