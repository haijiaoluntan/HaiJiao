package com.haijiao.mapper;
import com.haijiao.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("userMapper")
public interface UserMapper {
    User queryByEmailPsw(String email, String password);
    Integer actication(String email);
    Integer insert(User user);
    User queryByEmail(String email);
    Integer updatejoindate(String email);
}
