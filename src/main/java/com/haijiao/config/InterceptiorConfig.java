package com.haijiao.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器的配置类
 */
@Configuration  //声明为配置类
public class InterceptiorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(createInterceptor()).
                 addPathPatterns("/config") //所有路径
                 .excludePathPatterns("/dladmin"); //拦截器不会拦截的请求
    }

    @Bean
    public MyInterceptor createInterceptor() {

        return new MyInterceptor();
    }
}
