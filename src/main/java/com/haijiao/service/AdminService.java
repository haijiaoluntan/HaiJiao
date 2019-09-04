
package com.haijiao.service;

import com.haijiao.pojo.Admin;
import com.haijiao.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AdminService {
    public String adminlogin(@Param("user") String user, @Param("pwd") String pwd);
    public  int updAdmins(@Param("login_time") Date login_time,
                          @Param("user") String user);
    public  int addadmin(@Param("user") String user,
                         @Param("pwd") String pwd
    );
    public Admin seleadmin(@Param("user") String user);
    public List<User> findall ();
    public int delete(@Param("uid")Integer uid);

    public int addReady(@Param("phone") String phone,@Param("yanzm") Integer yanzm);
    public Integer selReadyY(String phone);
    public Integer phoneReg(Admin admin);
    public Integer updYzm(@Param("phone")String phone,@Param("phoneyanzm")Integer phoneyanzm);
    public Integer selYanzm(String phone);
    public Admin selPhone(String phone);
}

