/*
package com.haijiao.config;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.haijiao.pojo.RequestMessage;
import com.haijiao.utils.LoggerRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect  //用来定义切面
@Order(5) //指定优级
public class WebLogAspect {

    private static final Logger log = LoggerFactory.getLogger(WebLogAspect.class);

    @Autowired
    private LoggerRepository rep;

    //定义切入点
    @Pointcut("execution(public * com.haijiao.controller.*.*(..))")
    public void weblog() {

    }

    //定义通知
    @Before("weblog()")
    public void before(JoinPoint jp) {
//        log.info("前置通知：{}",new Date());
//
//        RequestAttributes ras=RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes sra=(ServletRequestAttributes)ras;
//        //获得请求对象：
//        HttpServletRequest request=sra.getRequest();
//
//        log.info("URL:{}",request.getRequestURL());
//        log.info("HTTP_METHOD:{}",request.getMethod());
//        log.info("IP:{}",request.getRemoteHost());
//        log.info("ARGS:{}",Arrays.toString(jp.getArgs()));
//        log.info("METHOD_NAME:{},{}",jp.getSignature().getDeclaringType(),jp.getSignature().getName());
        //获取请求参数
        RequestAttributes ra=RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra= (ServletRequestAttributes) ra;
        HttpServletRequest request=sra.getRequest();
        //封装数据
        String id= UUID.randomUUID().toString();
        String url=request.getRequestURI();
        String method=request.getMethod();
        String signame=jp.getSignature().getName();
        String args=Arrays.toString(jp.getArgs());

        RequestMessage req=new RequestMessage(id, url, method, signame, args);

        //3、调用DAO将数据写入MongoDB
        log.info("开始将日志信息写入Mongodb,id:{}",id);
        rep.save(req);
        log.info("写入Mongodb完成");
    }

    //后置通知
    @AfterReturning(returning = "rtn",pointcut = "weblog()")
    public void after(Object rtn) {
        log.info("后置通知，返回值：{}",rtn);
    }

    //环绕通知
    @Around("weblog()")
    public Object  around(ProceedingJoinPoint jp) {
        log.info("环绕通知");
        log.info("Target:{}",jp.getTarget());
        log.info("This:{}",jp.getThis());

        //执行方法
        Object obj=null;
        try {
            obj = jp.proceed();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //方法执行完成之后，添加后置通知
        log.info("环绕结束:{}",obj);
        return obj;
    }
}
*/
