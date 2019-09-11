package com.haijiao.backController;

import com.haijiao.pojo.Admin;
import com.haijiao.pojo.LayuiJSON;
import com.haijiao.pojo.User;
import com.haijiao.service.impl.RankServiceImpl;
import com.haijiao.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hai")
public class RoleController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("seluser")
    public ResponseEntity<?> SelUser(@Param("page") String page, @Param("pageSize") String pageSize){
        System.out.println("进入查询所有用户方法");
        System.out.println("获取的行数"+page+"获取的size"+pageSize);
        Integer page1=1;
        Integer pageSize1=6;
        if(page!=null){
            page1=Integer.parseInt(page);
        }
        if(pageSize!=null){
            pageSize1=Integer.parseInt(pageSize);
        }
        Integer p=(page1-1)*pageSize1;
        Integer num=userService.NumUser();
        List<User> UserCurr=userService.CurrUser(p,pageSize1);
        List<User> users=userService.AllUser();
        LayuiJSON jsonx=new LayuiJSON();
        if(num!=null){
            jsonx.setCount(num);
            jsonx.setData(UserCurr);
            jsonx.setTotal(users);
            jsonx.setCode(0);
            return new ResponseEntity<>(jsonx, HttpStatus.OK);
        }else{
            jsonx.setCount(num);
            jsonx.setData(UserCurr);
            jsonx.setTotal(users);
            jsonx.setCode(2);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }
    }
}
