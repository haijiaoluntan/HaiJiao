
package com.haijiao.controller;


import com.haijiao.pojo.User;
import com.haijiao.service.UserService;
import com.haijiao.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
}
