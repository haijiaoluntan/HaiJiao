/*
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
    
    @RequestMapping("/user/getUser")
    public ResponseEntity<?> getUser(HttpServletRequest request) {
        
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
        user.setPassword("******");
        System.out.println(user.getUsername());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
*/
