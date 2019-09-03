/*
package com.haijiao.controller;

import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testController {
    //slf4j logging
    private static final Logger log = LoggerFactory.getLogger(testController.class);

    //common logging
    private static Log logx=LogFactory.getLog(testController.class);

    @GetMapping("/emp/{name}")
    public String hi(@PathVariable("name")String name) {
        log.info("slf4j,输入的name:{}",name);
        logx.info("commons log,输入的name:"+name);

        return "Hello "+name;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return String.format("Hello:%s","周泽坤");
    }

}
*/
