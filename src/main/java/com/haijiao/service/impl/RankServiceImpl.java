package com.haijiao.service.impl;

import com.haijiao.mapper.RankMapper;
import com.haijiao.pojo.Admin;
import com.haijiao.pojo.DataAuth;
import com.haijiao.pojo.OperAuth;
import com.haijiao.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankServiceImpl implements RankService {
    @Autowired
    RankMapper rankMapper;

    @Override
    public Integer DataUpdate(Integer state, Integer aid, Integer did) {
        return rankMapper.DataUpdate(state,aid,did);
    }

    @Override
    public Integer OperUpdate(Integer state, Integer aid, Integer oid) {
        return rankMapper.OperUpdate(state,aid,oid);
    }

    @Override
    public Integer AddData(String dpath, String describe) {
        return rankMapper.AddData(dpath,describe);
    }

    @Override
    public List<DataAuth> FindData(Integer aid) {
        return rankMapper.FindData(aid);
    }

    @Override
    public List<OperAuth> FindOper(Integer aid) {
        return rankMapper.FindOper(aid);
    }

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
