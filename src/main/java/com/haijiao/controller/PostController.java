
package com.haijiao.controller;

import com.haijiao.pojo.Post;
import com.haijiao.pojo.ShowPost;
import com.haijiao.pojo.User;
import com.haijiao.service.PostService;
import com.haijiao.service.UserService;
import com.haijiao.utils.JudgeLevelUtil;
import com.haijiao.utils.JwtTokenUtil;
import com.haijiao.utils.Pager;
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
    
    @Autowired
    private Pager pager;
    
    /**
     * 发表新帖
     *
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
        
        Integer count = postService.addPost(post);
        
        //获得经验并判断是否升级
        if (count > 0) {
            userService.updExpByPosts(user.getUid());
            judgeLevelUtil.judgeLevel(user);
        }
        
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 获得帖子列表
     *
     * @return
     */
    @RequestMapping("/posts/getShowPostList")
    public ResponseEntity<?> getShowPostList(Integer pageSize, Integer currentPage, Integer type, Integer state, Integer dateOrComm) {
        
        currentPage = (currentPage - 1) * pageSize;
        List<ShowPost> showPostList = postService.getShowPostList(pageSize, currentPage, type, state, dateOrComm);
        Integer total = postService.getShowPostListTotal(type, state);
        pager.setResult(showPostList);
        pager.setTotalPage(total);
        
        return new ResponseEntity<>(pager, HttpStatus.OK);
    }
    
    /**
     * 置顶列表
     * @return
     */
    @RequestMapping("/posts/getTopList")
    public ResponseEntity<?> getTopList() {
    
        List<ShowPost> topList = postService.getTopList();
        return new ResponseEntity<>(topList, HttpStatus.OK);
    }
    
    /**
     * 查询用户发表的所有帖子
     * @param uid
     * @return
     */
    @RequestMapping("/posts/getPostsListByUid")
    public ResponseEntity<?> getPostsListByUid(Integer uid) {
    
        List<ShowPost> list = postService.getPostsListByUid(uid);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    /**
     * 首页展示列表
     * @param state
     * @return
     */
    @RequestMapping("/posts/getIndexList")
    public ResponseEntity<?> getTopList(Integer state) {
    
        List<ShowPost> list = postService.getIndexPostList(state);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    /**
     * 本周热议
     *
     * @return
     */
    @RequestMapping("/posts/getWeekList")
    public ResponseEntity<?> getWeekList() {
        
        List<ShowPost> weekList = postService.getWeekList();
        return new ResponseEntity<>(weekList, HttpStatus.OK);
    }
    
    /**
     * 帖子详情
     * @param pid
     * @return
     */
    @RequestMapping("/posts/getShowPost")
    public ResponseEntity<?> getShowPostByPid(Integer pid) {
        
        //修改浏览量
        postService.updBrowse(pid);
        
        ShowPost showPost = postService.getShowPostByPid(pid);
        return new ResponseEntity<>(showPost, HttpStatus.OK);
    }
    
    /**
     * 根据id获取帖子用于修改
     * @param pid
     * @return
     */
    @RequestMapping("/posts/getPost")
    public ResponseEntity<?> getPostByPid(Integer pid) {
    
        Post post = postService.getPostByPid(pid);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
    
    /**
     * 修改帖子
     * @param post
     * @return
     */
    @RequestMapping("/posts/updPost")
    public ResponseEntity<?> updPost(Post post) {
    
        Integer count = postService.updPost(post);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 加精
     * @param pid
     * @return
     */
    @RequestMapping("/posts/addJing")
    public ResponseEntity<?> addJing(Integer pid) {
        
        Integer count = postService.addJing(pid);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 取消加精
     * @param pid
     * @return
     */
    @RequestMapping("/posts/cancelJing")
    public ResponseEntity<?> cancelJing(Integer pid) {
        
        Integer count = postService.cancelJing(pid);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 置顶
     * @param pid
     * @return
     */
    @RequestMapping("/posts/addTop")
    public ResponseEntity<?> addTop(Integer pid) {
        
        Integer count = postService.addTop(pid);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 取消置顶
     * @param pid
     * @return
     */
    @RequestMapping("/posts/cancelTop")
    public ResponseEntity<?> cancelTop(Integer pid) {
        
        Integer count = postService.cancelTop(pid);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 我发的帖
     * @param request
     * @return
     */
    @RequestMapping("/posts/getPostsList")
    public ResponseEntity<?> getPostsList(HttpServletRequest request) {
    
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
    
        List<ShowPost> list = postService.getPostsList(user.getUid());
        
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
//    @RequestMapping("/posts/isFavorite")
//    public ResponseEntity<?> isFavorite(Integer uid, Integer pid) {
//
//    }
//
//    @RequestMapping("/posts/addFavorite")
//    public ResponseEntity<?> addFavorite(HttpServletRequest request, Integer pid) {
//
//    }
//
//    @RequestMapping("/posts/cancelFavorite")
//    public ResponseEntity<?> cancelFavorite(HttpServletRequest request, Integer pid) {
//
//    }
}
