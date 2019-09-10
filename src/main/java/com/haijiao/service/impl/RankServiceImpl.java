package com.haijiao.service.impl;

import com.haijiao.mapper.RankMapper;
import com.haijiao.pojo.Admin;
import com.haijiao.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    RankMapper rankMapper;

    @Override
    public List<Admin> currAdmin(Integer page, Integer pageSize) {
        return rankMapper.currAdmin(page,pageSize);
    }

    @Override
    public Integer AdminNum() {
        return rankMapper.AdminNum();
    }

    @Override
    public List<Admin> FindAllAdmin() {
        return rankMapper.FindAllAdmin();
    }
}
