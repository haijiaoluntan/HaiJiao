package com.haijiao.controller;

import com.haijiao.pojo.Post;
import com.haijiao.pojo.User;
import com.haijiao.service.PostService;
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
import java.util.Date;

@RestController
@RequestMapping("/haijiao")
public class PostController {
    
    @Value("${auth.header}")
    private String header;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private PostService postService;
    
    @RequestMapping("/post/addPost")
    public ResponseEntity<?> addPost(HttpServletRequest request, Post post) {
    
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
        
        post.setUid(user.getUid());
        post.setPubDate(new Date());
        post.setJing(0);
        post.setTop(0);
        post.setJie(0);
        post.setBrowse(0);
        post.setRstate(0);
    
        int count = postService.addPost(post);
        
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
