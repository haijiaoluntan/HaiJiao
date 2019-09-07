package com.haijiao.service;

import com.haijiao.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RankService {

    public List<Admin> FindAllAdmin();
    public List<Admin> currAdmin(@Param("page") Integer page, @Param("pageSize") Integer pageSize);
    public Integer AdminNum();
}
