
package com.haijiao.controller;

import com.haijiao.pojo.Admin;
import com.haijiao.pojo.User;
import com.haijiao.service.AdminService;
import com.haijiao.utils.JwtTokenUtils;
import io.jsonwebtoken.Claims;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtTokenUtils jwtTokenUtil;

    @Value("${auth.header}") //application.yml 获取auth.header的值
    private String header;

    @PostMapping("/dladmin")
    public ResponseEntity<?> dl(@RequestParam("user") String user,
                    @RequestParam("pwd")  String pwd
    ){
      String ad= adminService.adminlogin(user,pwd);
        if (ad!=null){
            updAdmins(new Date(),ad);

            String token = jwtTokenUtil.createJwt(ad);

            return new ResponseEntity<>(token,HttpStatus.OK);
        }
        return null;
    }

    @PostMapping("/addadmin")
    public int addadmin(@RequestParam("user") String user,
                        @RequestParam("pwd")  String pwd){

        return adminService.addadmin(user,pwd);
    }


    @RequestMapping("/check")
    public ResponseEntity<?> check(HttpServletRequest request){
        String token = request.getHeader(header);
        if(token!=null){

            Claims claims =  jwtTokenUtil.parseJWT(token);
            System.out.println(claims.get("realname")
                    +","+claims.get("sex")+","+claims.get("weight"));
            System.out.println("claims.getIssuer()="+claims.getIssuer());
            System.out.println("token"+"==="+token);
            return new ResponseEntity<>(claims.getIssuer(),HttpStatus.OK);
        }
        return null;
    }


    public void updAdmins(Date login_time, String user){
        adminService.updAdmins(login_time,user);
    }



    @PostMapping("/seleadmin")
    public Admin seleadmin(@RequestParam("user") String user){

        return adminService.seleadmin(user);
    }

    @PostMapping("/findall")
    public List<User> findall(){

        return adminService.findall();
    }
    @DeleteMapping("/del/{uid}")
    public int delete(@PathVariable("uid") Integer uid){
        int k=adminService.delete(uid);



        return k;
    }

}

