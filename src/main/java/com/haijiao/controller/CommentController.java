package com.haijiao.controller;

import com.haijiao.pojo.Comment;
import com.haijiao.pojo.Like;
import com.haijiao.pojo.Post;
import com.haijiao.pojo.User;
import com.haijiao.service.CommentService;
import com.haijiao.service.LikeService;
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
import java.util.List;

@RestController
@RequestMapping("/haijiao")
public class CommentController {
    
    @Value("${auth.header}")
    private String header;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private JudgeLevelUtil judgeLevelUtil;
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private LikeService likeService;
    
    @Autowired
    private PostService postService;
    
    /**
     * 新增评论
     * @param request
     * @param pid
     * @param content
     * @return
     */
    @RequestMapping("/comm/addComm")
    public ResponseEntity<?> addComment(HttpServletRequest request, Integer pid, String content) {
    
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
    
        Integer count = commentService.addComment(user.getUid(), pid, content);
    
        //获得经验并判断是否升级
        if (count > 0) {
    
            userService.updExpByComm(user.getUid());
            judgeLevelUtil.judgeLevel(user);
        }
        
        
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 根据pid获得评论列表
     * @param pid
     * @return
     */
    @RequestMapping("/comm/getCommentList")
    public ResponseEntity<?> getCommentList(Integer pid) {
    
        List<Comment> commentList = commentService.getCommentList(pid);
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }
    
    /**
     * 判断是否已点赞
     * @param request
     * @param cid
     * @return
     */
    @RequestMapping("/like/isLike")
    public ResponseEntity<?> isLike(HttpServletRequest request, Integer cid) {
    
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
        
        Like like = likeService.getLikeByUidAndCid(user.getUid(), cid);
        
        if (like != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }
    
    /**
     * 点赞
     * @param request
     * @param cid
     * @return
     */
    @RequestMapping("/like/addLike")
    public ResponseEntity<?> addLike(HttpServletRequest request, Integer cid) {
    
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
    
        Integer count = likeService.addLike(user.getUid(), cid);
        
        if (count > 0) {
            
            //判断是否点过赞，如果没有则加经验值并判断升级
            if (likeService.hasLikeByUidAndCid(user.getUid(), cid)) {
                return new ResponseEntity<>(2, HttpStatus.OK);
            } else {
                userService.updExpByLike(user.getUid());
                judgeLevelUtil.judgeLevel(user);
                return new ResponseEntity<>(1, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(0, HttpStatus.OK);
        }
    }
    
    
    /**
     * 取消点赞
     * @param request
     * @param cid
     * @return
     */
    @RequestMapping("/like/cancelLike")
    public ResponseEntity<?> cancelLike(HttpServletRequest request, Integer cid) {
    
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
        
        Integer count = likeService.cancelLike(user.getUid(), cid);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 删除评论
     * @param cid
     * @return
     */
    @RequestMapping("/comm/del")
    public ResponseEntity<?> delComm(Integer cid) {
    
        Integer count = commentService.delComm(cid);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 采纳评论
     * @param cid
     * @return
     */
    @RequestMapping("/comm/accept")
    public ResponseEntity<?> acceptComm(Integer uid, Integer pid, Integer cid) {
    
        Integer a = commentService.acceptComm(cid);
        Integer c = 0;
        
        //采纳后结算悬赏
        if (a > 0) {
    
            Post post = postService.getPostByPid(pid);
            Integer b = userService.earnBalance(uid, post.getReward());
            
            //悬赏后，完结帖子
            if (b > 0) {
    
                c = postService.doJie(pid);
            }
        }
        
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    
    /**
     * 用户最近的评论
     * @param uid
     * @return
     */
    @RequestMapping("comm/getCommListByUid")
    public ResponseEntity<?> getCommListByUid(Integer uid) {
    
        List<Comment> list = commentService.getCommListByUid(uid);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
