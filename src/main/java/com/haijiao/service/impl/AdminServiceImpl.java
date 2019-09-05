
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

    //以下为手机注册登录
    @Override
    public int addReady(String phone, Integer yanzm) {
        return adminMapper.addReady(phone,yanzm);
    }

    @Override
    public Integer selReadyY(String phone) {
        return adminMapper.selReadyY(phone);
    }

    @Override
    public Admin selAdmin(String admin) {
        return adminMapper.selAdmin(admin);
    }

    @Override
    public Integer phoneReg(Admin admin) {
        return adminMapper.phoneReg(admin);
    }

    @Override
    public Integer updYzm(String phone, Integer phoneyanzm) {
        return adminMapper.updYzm(phone,phoneyanzm);
    }

    @Override
    public Integer selYanzm(String phone) {
        return adminMapper.selYanzm(phone);
    }

    @Override
    public Admin selPhone(String phone) {
        return adminMapper.selPhone(phone);
    }


}

