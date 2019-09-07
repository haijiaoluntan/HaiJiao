package com.haijiao.backController;


import com.haijiao.pojo.Admin;
import com.haijiao.service.impl.RankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("haijiao")
public class RankController {
    @Autowired
    RankServiceImpl rankService;

    @RequestMapping("seladmin")
    public ResponseEntity<?> SelAdmin(){
        System.out.println("进入查询所有管理员方法");
        Admin admin=rankService.FindAllAdmin();
        if(admin!=null){
            return new ResponseEntity<>(admin, HttpStatus.OK);
        }else{
            Map<String,String> map=new HashMap<>();
            map.put("msg","查询失败");
            map.put("info","2");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
