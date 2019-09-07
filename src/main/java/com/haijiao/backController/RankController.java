package com.haijiao.backController;


import com.haijiao.pojo.Admin;
import com.haijiao.pojo.LayuiJSON;
import com.haijiao.service.impl.RankServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("haijiao")
public class RankController {
    @Autowired
    RankServiceImpl rankService;

    @RequestMapping("seladmin")
    public ResponseEntity<?> SelAdmin(@Param("page") String page,@Param("pageSize") String pageSize){
        System.out.println("进入查询所有管理员方法");
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
        Integer num=rankService.AdminNum();
        List<Admin> adminCurr=rankService.currAdmin(p,pageSize1);
        List<Admin> admin=rankService.FindAllAdmin();
        LayuiJSON jsonx=new LayuiJSON();
        if(num!=null){
            jsonx.setCount(num);
            jsonx.setData(adminCurr);
            jsonx.setTotal(admin);
            jsonx.setCode(0);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }else{
            jsonx.setCount(num);
            jsonx.setData(adminCurr);
            jsonx.setTotal(admin);
            jsonx.setCode(2);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }
    }
}
