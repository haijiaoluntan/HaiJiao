
package com.haijiao.controller;

import com.haijiao.utils.MyVerifyCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/haijiao")
public class VerifyCodeController {
    
    
    @RequestMapping("/getVerifyCode")
    public ResponseEntity<?> getVerifyCode(){
    
        String[] code = MyVerifyCode.getCode();
        return new ResponseEntity<>(code, HttpStatus.OK);
    }
}
