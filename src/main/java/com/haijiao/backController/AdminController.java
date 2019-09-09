
package com.haijiao.backController;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.haijiao.pojo.Admin;
import com.haijiao.pojo.User;
import com.haijiao.service.AdminService;
import com.haijiao.service.SmsService;
import com.haijiao.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("haijiao")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private SmsService smsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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

    //手机是否注册
    @GetMapping("/selphone")
    public ResponseEntity<?> selPhone(String phone){
        System.out.println("进入判断手机是否注册方法");
        Map<String,String> map=new HashMap<>();
        System.out.println("获取手机号是"+phone);
        Admin admin=adminService.selPhone(phone);
        if(admin==null){
            map.put("msg","手机号合法");
            map.put("info","1");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else{
            map.put("msg","手机号已被注册");
            map.put("info","2");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }
    //发送验证码创建预设表
    @PostMapping("/addready")
    public ResponseEntity<?> addReady(String phone){
        System.out.println("进入发送验证码建预设表方法");
        System.out.println("获取手机号是"+phone);
        Integer code=smsService.getcode();
        Map<String, Integer> map = new HashMap<>();
        map.put("code", code);
        SendSmsResponse sendSmsResponse = smsService.sendSms(phone,
                JSON.toJSONString(map),
                "SMS_173251325");
        System.out.println("返回代码是"+JSON.toJSONString(sendSmsResponse));
        if(sendSmsResponse.getCode().equals("OK")){
            Map<String, String> map1 = new HashMap<>();
            map1.put("info","1");
            map1.put("msg","发送成功");
            adminService.addReady(phone,code);
            return new ResponseEntity<>(map1,HttpStatus.OK);
        }else{
            Map<String, String> map1 = new HashMap<>();
            map1.put("info","2");
            map1.put("msg","发送失败");
            return new ResponseEntity<>(map1,HttpStatus.OK);
        }
    }
    //验证注册验证码
    @PostMapping("/selreadyy")
    public ResponseEntity<?> selReadyY(@Param("phone") String phone, @Param("yanzm")Integer yanzm){
        System.out.println("进入验证注册验证码方法");
        System.out.println("获取手机号是"+phone);
        System.out.println("获取验证码是"+yanzm);
        Map<String, String> map = new HashMap<>();
        Integer yanzm1=adminService.selReadyY(phone);
        if(yanzm1.equals(yanzm)){
            map.put("info","1");
            map.put("msg","验证码正确");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else {
            map.put("info","2");
            map.put("msg","验证码错误");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }

    //判断用户名是否存在
    @PostMapping("/seladmin")
    public ResponseEntity<?> selAdmin(String admin){
        System.out.println("进入账号重名判断方法");
        System.out.println("获取的账号"+admin);
        Map<String,String> map=new HashMap<>();
        Admin admin1=adminService.selAdmin(admin);
        if(admin1==null){
            map.put("msg","账号合法");
            map.put("info","1");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else {
            map.put("msg","账号重复");
            map.put("info","2");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }

    //手机注册
    @PostMapping("/phoneReg")
    public ResponseEntity<?> phoneReg(Admin admin){
        System.out.println("进入注册方法");
        Map<String, String> map = new HashMap<>();
        System.out.println("获取的注册信息"+admin.toString());
        Integer i=adminService.phoneReg(admin);
        if(i==1){
            map.put("info","1");
            map.put("msg","注册成功");
            map.put("admin",admin.getAdmin());
            map.put("pwd",admin.getPwd());
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else{
            map.put("info","2");
            map.put("msg","注册失败");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }

    //手机登录发送验证码
    @PutMapping("/updyzm")
    public ResponseEntity<?> updYzm(String phone){
        System.out.println("进入手机登录发送验证码方法");
        System.out.println("获取手机号是"+phone);
        Integer yanzm=smsService.getcode();
        Map<String, Integer> map = new HashMap<>();
        map.put("code", yanzm);
        SendSmsResponse sendSmsResponse = smsService.sendSms(phone,
                JSON.toJSONString(map),
                "SMS_173251325");
        System.out.println("返回代码是"+JSON.toJSONString(sendSmsResponse));
        if(sendSmsResponse.getCode().equals("OK")){
            Map<String, String> map1 = new HashMap<>();
            map1.put("info","1");
            map1.put("msg","发送成功");
            adminService.updYzm(phone,yanzm);
            return new ResponseEntity<>(map1,HttpStatus.OK);
        }else{
            Map<String, String> map1 = new HashMap<>();
            map1.put("info","2");
            map1.put("msg","发送失败");
            return new ResponseEntity<>(map1,HttpStatus.OK);
        }
    }
    //登录验证码验证
    @PostMapping("/dluyanzm")
    public ResponseEntity<?> Dluyanzm(String phone,Integer phoneyanzm){
        System.out.println("进入验证登录验证码方法");
        System.out.println("获取手机号是"+phone);
        System.out.println("获取验证码是"+phoneyanzm);
        Integer code=adminService.selYanzm(phone);
        Map<String,String> map=new HashMap<>();
        if(phoneyanzm.equals(code)){
            map.put("msg","验证成功");
            map.put("info","1");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else {
            map.put("msg","验证码错误");
            map.put("info","2");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }


    //手机登录
    @PostMapping("/phonedlu")
    public ResponseEntity<?> phoneDlu(String phone,Integer phoneyanzm){
        System.out.println("进入登录功能的方法");
        System.out.println("获取手机号是"+phone);
        System.out.println("获取验证码是"+phoneyanzm);
        Integer code=adminService.selYanzm(phone);
        Map<String,String> map=new HashMap<>();
        if(phoneyanzm.equals(code)){
            Admin admin=adminService.selPhone(phone);
            String ad=admin.getAdmin();
            adminService.updAdmins(new Date(),ad);
            String token = jwtTokenUtil.createJwt(ad);
            System.out.println("我创建的token是"+token);
            return new ResponseEntity<>(token,HttpStatus.OK);
        }else {
            map.put("msg","登录失败");
            map.put("info","2");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }

}

