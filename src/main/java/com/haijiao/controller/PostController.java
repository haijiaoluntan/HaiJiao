package com.haijiao.controller;

import com.haijiao.pojo.Post;
import com.haijiao.pojo.ShowPost;
import com.haijiao.pojo.User;
import com.haijiao.service.PostService;
import com.haijiao.service.UserService;
import com.haijiao.utils.JudgeLevelUtil;
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
import java.util.List;

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
    
    @Autowired
    private JudgeLevelUtil judgeLevelUtil;
    
    /**
     * 发表新帖
     * @param request
     * @param post
     * @return
     */
    @RequestMapping("/posts/addPost")
    public ResponseEntity<?> addPost(HttpServletRequest request, Post post) {
    
        //获得用户对象
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
        
        //设置值发帖
        post.setUid(user.getUid());
        post.setPubDate(new Date());
        post.setJing(0);
        post.setTop(0);
        post.setJie(0);
        post.setBrowse(0);
        post.setRstate(0);
    
        //扣除飞吻余额
        if (user.getBalance() >= post.getReward()) {
            Integer cnt = userService.useBalance(user.getUid(), post.getReward());
            if (cnt < 1) {
                return new ResponseEntity<>(cnt, HttpStatus.OK);
            }
        }
        
        //获得经验并判断是否升级
        userService.updExpByPosts(user.getUid());
        judgeLevelUtil.judgeLevel(user);
        
        int count = postService.addPost(post);
        
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 获得帖子列表
     * @return
     */
    @RequestMapping("/posts/getShowPostList")
    public ResponseEntity<?> getShowPostList(Integer pageSize, Integer currentPage){
    
        currentPage = (currentPage - 1) * pageSize;
        List<ShowPost> showPostList = postService.getShowPostList(pageSize, currentPage);
        return new ResponseEntity<>(showPostList, HttpStatus.OK);
    }
}
