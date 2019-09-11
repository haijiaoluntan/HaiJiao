package com.haijiao.service;

import com.haijiao.pojo.Admin;
import com.haijiao.pojo.DataAuth;
import com.haijiao.pojo.OperAuth;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RankService {

    public List<Admin> FindAllAdmin();
    public List<Admin> currAdmin(@Param("page") Integer page, @Param("pageSize") Integer pageSize);
    public Integer AdminNum();

    public List<DataAuth> FindData(Integer aid);
    public List<OperAuth> FindOper(Integer aid);

    public Integer AddData(@Param("dpath") String dpath,@Param("describe") String describe);

    public Integer DataUpdate(@Param("state") Integer state,@Param("aid") Integer aid,@Param("did") Integer did);
    public Integer OperUpdate(@Param("state") Integer state,@Param("aid") Integer aid,@Param("oid") Integer oid);


    public Integer selDS(@Param("aid") Integer aid,@Param("did") Integer did);
    public Integer selOS(@Param("aid") Integer aid,@Param("oid") Integer oid);
    public Integer aidByAdmin(String admin);
}
