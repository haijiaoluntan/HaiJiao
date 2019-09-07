package com.haijiao.mapper;

import com.haijiao.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankMapper {
    @Select("SELECT * FROM admin")
    public List<Admin> FindAllAdmin();

    @Select("select * from admin limit #{page},#{pageSize}")
    public List<Admin> currAdmin(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from admin")
    public Integer AdminNum();
}
