
package com.haijiao.backController;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.haijiao.service.impl.SmsServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/haijiao")
public class SmsController {
    @Autowired
    private SmsServiceImpl smsService;

/**
     * @Author: LX 17839193044@162.com
     * @Description: 短信发
     * @Date: 2019/4/18 16:08
     * @Version: V1.0
     */

    //测试验证码使用
    @GetMapping("/code")
    @ResponseBody
    public Integer getcode(){
        Integer code=smsService.getcode();
        return  code;
    }

    @GetMapping("/sms")
    @ResponseBody
    public String sms(@Param("phone") String phone) {
        Integer code=smsService.getcode();
        Map<String, Integer> map = new HashMap<>();
        map.put("code", code);
        SendSmsResponse sendSmsResponse = smsService.sendSms(phone,
                JSON.toJSONString(map),
                "SMS_173251325");
        return JSON.toJSONString(sendSmsResponse);
    }

/**
     * @Author: LX 17839193044@162.com
     * @Description: 短信查询
     * @Date: 2019/4/18 16:08
     * @Version: V1.0
     *
     */

    @GetMapping("/query")
    @ResponseBody
    public String query() {
        QuerySendDetailsResponse querySendDetailsResponse = smsService.querySendDetails("此处填写发送短信返回的bizId",
                "18229901603", 10L, 1L);
        return JSON.toJSONString(querySendDetailsResponse);
    }

}

