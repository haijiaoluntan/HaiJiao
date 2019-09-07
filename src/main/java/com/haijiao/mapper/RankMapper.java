package com.haijiao.mapper;

import com.haijiao.pojo.Admin;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface RankMapper {
    @Select("SELECT * FROM admin")
    public Admin FindAllAdmin();

}
