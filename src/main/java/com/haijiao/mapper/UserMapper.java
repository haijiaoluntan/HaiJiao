package com.haijiao.mapper;
import com.haijiao.pojo.User;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper {
    User queryByEmailPsw(String email,String password);
    Integer actication(String email);
    Integer insert(User user);
    User queryByid(Integer eid);
}
