package com.haijiao.mapper;

import com.haijiao.pojo.Admin;
import com.haijiao.pojo.DataAuth;
import com.haijiao.pojo.OperAuth;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RankMapper {
    @Select("SELECT * FROM admin")
    public List<Admin> FindAllAdmin();

    @Select("select * from admin limit #{page},#{pageSize}")
    public List<Admin> currAdmin(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from admin")
    public Integer AdminNum();

    @Select("select a.aid,b.did,b.`describe`,b.dpath,c.state from admin a,data_auth b,rale_data c where a.aid=c.aid and c.did=b.did and a.aid=#{aid}")
    public List<DataAuth> FindData(Integer aid);

    @Select("select a.aid,b.oid,b.`describe`,b.authname,c.state from admin a,oper_auth b,rale_oper c where a.aid=c.aid and c.oid=b.oid and a.aid=#{aid}")
    public List<OperAuth> FindOper(Integer aid);

    @Insert("insert into data_auth(dpath,`describe`) values(#{dpath},#{describe})")
    public Integer AddData(@Param("dpath") String dpath,@Param("describe") String describe);

    @Update("update rale_data set state=#{state} where aid=#{aid} and did=#{did}")
    public Integer DataUpdate(@Param("state") Integer state,@Param("aid") Integer aid,@Param("did") Integer did);

    @Update("update rale_oper set state=#{state} where aid=#{aid} and oid=#{oid}")
    public Integer OperUpdate(@Param("state") Integer state,@Param("aid") Integer aid,@Param("oid") Integer oid);

}
