
package com.haijiao.controller;


import com.haijiao.pojo.User;
import com.haijiao.service.UserService;
import com.haijiao.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/haijiao")
public class UserController {
    
    @Value("${auth.header}")
    private String header;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    /**
     * 获得用户信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/user/getUser")
    public ResponseEntity<?> getUser(HttpServletRequest request) {
        
        String token = request.getHeader(this.header);
        User user = null;
        if (token != null && !"".equals(token)) {
            Claims claims = jwtTokenUtil.parseJWT(token);
            user = userService.queryByUsername(claims.getIssuer());
            user.setPassword("******");
            System.out.println(user.getUsername());
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    /**
     * 登录
     *
     * @param email
     * @param password
     * @return
     */
    @RequestMapping("/user/login")
    public ResponseEntity<?> login(String email, String password) {
        
        User user = userService.queryByEmailPsw(email, password);
        
        if (user != null) {
            
            String jwt = jwtTokenUtil.createJwt(user.getUsername());
            return new ResponseEntity<>(jwt, HttpStatus.OK);
            
        } else {
            
            return new ResponseEntity<>("fail", HttpStatus.OK);
        }
    }
    
    /**
     * 判断余额是否够
     * @param request
     * @param reward
     * @return
     */
    @RequestMapping("/user/checkBalance")
    public ResponseEntity<?> checkBalance(HttpServletRequest request, Integer reward) {
        
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
    
        if (user.getBalance() < reward) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/reg")
    public ResponseEntity<?> reg(User user){
        System.out.println("进入邮箱注册方法");
        Map<String, String> map = new HashMap<>();
        Integer i = userService.addUser(user);
        if(i==1){
            map.put("info","1");
            map.put("msg","注册成功");
            map.put("user",user.getUsername());
            map.put("pwd",user.getPassword());
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else{
            map.put("info","1");
            map.put("msg","注册失败");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }

    /**
     * 判断邮箱是否已被注册
     * @param email
     * @return
     */
    @GetMapping("/selemail")
    public ResponseEntity<?> selemail(String email){
        System.out.println("进入查询邮箱的方法");
        Map<String,String> map=new HashMap<>();
        User user = userService.queryByEmail(email);
        if(user==null){
            map.put("msg","邮箱合法");
            map.put("info","1");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else{
            map.put("msg","邮箱已被注册");
            map.put("info","2");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }

    @PostMapping("/yz")
    public ResponseEntity<?> yanzheng(String email,String yzm){
        Map<String, String> map = new HashMap<>();
        String yanzm = userService.elemaily(email);
        if(yanzm.equals(yzm)){
            map.put("info","1");
            map.put("msg","验证码正确");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else {
            map.put("info","1");
            map.put("msg","验证码错误");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }
}
