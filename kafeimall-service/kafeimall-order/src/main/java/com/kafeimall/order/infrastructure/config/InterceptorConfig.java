package com.kafeimall.order.infrastructure.config;

import com.kafeimall.order.infrastructure.interceptor.LoginUserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author: zzg
 * @date: 2023/5/5
 * @Description: 自定义拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    LoginUserInterceptor loginUserInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置所有的路径都要进行拦截，除了login
        registry.addInterceptor(loginUserInterceptor).addPathPatterns("/**");
    }
}
