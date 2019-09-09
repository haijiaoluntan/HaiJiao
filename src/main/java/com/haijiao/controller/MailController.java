
package com.haijiao.controller;


import com.haijiao.service.impl.MailService;
import com.haijiao.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/haijiao")
public class MailController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private MailService mailService;

    @RequestMapping("getCheckCode")
    @ResponseBody
    public Integer getCheckCode(String email){
        Integer code=smsService.getcode();
        String message = "您的注册验证码为："+code;
        try {
            mailService.sendSimpleMail(email, "注册验证码", message);
        }catch (Exception e){
            return 2;
        }
        return code;
    }
}
