package com.haijiao.utils;

import com.haijiao.pojo.User;
import com.haijiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 等级判断器
 */
@Component
public class JudgeLevelUtil {
    
    @Autowired
    private UserService userService;
    
    /**
     * 判断是否需要升级
     * @param user
     */
    public void judgeLevel(User user){
    
        Integer uid = user.getUid();
        Integer level = user.getLevel();
        Integer exp = user.getExp();
        System.out.println("level = " + level);
        System.out.println("exp = " + exp);
        
        if ((level == 1 && exp >= 50) ||
                (level == 2 && exp >= 200) ||
                (level == 3 && exp >= 3000) ||
                (level == 4 && exp >= 10000) ||
                (level == 5 && exp >= 20000)) {
            userService.updLevel(uid);
        }
    }
}
