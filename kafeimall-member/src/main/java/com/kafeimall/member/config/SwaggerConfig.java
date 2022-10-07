package com.kafeimall.member.config;

import com.kafeimall.common.config.BaseSwaggerConfig;
import com.kafeimall.common.config.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

/**
 * @author: zzg
 * @date: 2022/10/7
 * @Description: Swagger API文档相关配置
 */
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.kafeimall.member.httpapi.controller")
                .title("mall会员服务")
                .description("mall会员服务相关接口文档")
                .contactName("咖飞")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }
}
