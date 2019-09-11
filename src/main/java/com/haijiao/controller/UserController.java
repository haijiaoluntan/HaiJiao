
package com.haijiao.controller;


import com.haijiao.pojo.City;
import com.haijiao.pojo.Message;
import com.haijiao.pojo.Province;
import com.haijiao.pojo.User;
import com.haijiao.service.MessageService;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/haijiao")
public class UserController {
    
    @Value("${auth.header}")
    private String header;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private MessageService messageService;
    
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
    
    /**
     * 评论排行榜
     * @return
     */
    @RequestMapping("/user/getCommRank")
    public ResponseEntity<?> getCommRank() {
    
        List<User> commRank = userService.getCommRank();
        return new ResponseEntity<>(commRank, HttpStatus.OK);
    }
    
    /**
     * 根据uid获得user对象
     * @param uid
     * @return
     */
    @RequestMapping("/user/getUserByUid")
    public ResponseEntity<?> getUserByUid(Integer uid) {
    
        User user = userService.getUserByUid(uid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    /**
     * 检查原密码是否正确
     * @param request
     * @param pwd
     * @return
     */
    @RequestMapping("/user/checkOldPwd")
    public ResponseEntity<?> checkOldPwd(HttpServletRequest request, String pwd) {
    
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
    
        User user1 = userService.queryByEmailPsw(user.getEmail(), pwd);
    
        if (user1 != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }
    
    /**
     * 修改密码
     * @param request
     * @param newpass
     * @return
     */
    @RequestMapping("/user/changePwd")
    public ResponseEntity<?> changePwd(HttpServletRequest request, String newpass) {
        
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
    
        Integer count = userService.changePwdByUid(user.getUid(), newpass);
        
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 查询所有省份选项
     * @return
     */
    @RequestMapping("/user/getProvinceList")
    public ResponseEntity<?> getProvinceList() {
    
        List<Province> list = userService.queryAllProvince();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    /**
     * 查询此省份下所有城市选项
     * @param pid
     * @return
     */
    @RequestMapping("/user/getCityList")
    public ResponseEntity<?> getCityList(Integer pid) {
    
        List<City> list = userService.queryCitysByPid(pid);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    /**
     * 检查邮箱是否重复
     * @param email
     * @return
     */
    @RequestMapping("/user/checkEmail")
    public ResponseEntity<?> checkEmail(HttpServletRequest request, String email) {
    
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
    
        User user1 = userService.queryByEmail(email);
    
        if (user1 == null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else if (email.equals(user.getEmail())) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }
    
    /**
     * 检查昵称是否重复
     * @param username
     * @return
     */
    @RequestMapping("/user/checkUsername")
    public ResponseEntity<?> checkUsername(HttpServletRequest request, String username) {
    
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
        
        User user1 = userService.queryByUsername(username);
    
        if (user1 == null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else if (username.equals(user.getUsername())) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }
    
    /**
     * 修改个人信息
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/user/updInfo")
    public ResponseEntity<?> updInfo(HttpServletRequest request, User user) {
    
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user1 = userService.queryByUsername(claims.getIssuer());
        
        user.setUid(user1.getUid());
        
        Integer count = userService.updInfo(user);
        
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 我的消息
     * @param request
     * @return
     */
    @RequestMapping("/user/getMessageByUid")
    public ResponseEntity<?> getMessageByUid(HttpServletRequest request) {
    
        String token = request.getHeader(this.header);
        Claims claims = jwtTokenUtil.parseJWT(token);
        User user = userService.queryByUsername(claims.getIssuer());
    
        List<Message> list = messageService.getMessageByUid(user.getUid());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    /**
     * 删除消息
     * @param mid
     * @return
     */
    @RequestMapping("/user/delMsg")
    public ResponseEntity<?> delMsg(Integer mid) {
    
        Integer count = messageService.delMsg(mid);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
    /**
     * 清空个人消息
     * @param uid
     * @return
     */
    @RequestMapping("/user/delAllMsg")
    public ResponseEntity<?> delAllMsg(Integer uid) {
        
        Integer count = messageService.delAllMsg(uid);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
