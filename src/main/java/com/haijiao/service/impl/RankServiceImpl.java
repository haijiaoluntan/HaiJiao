package com.haijiao.service.impl;

import com.haijiao.mapper.RankMapper;
import com.haijiao.pojo.Admin;
import com.haijiao.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    RankMapper rankMapper;

    @Override
    public Admin FindAllAdmin() {
        return rankMapper.FindAllAdmin();
    }
}
