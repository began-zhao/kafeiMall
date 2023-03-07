package com.kafeimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.kafeimall.product.infrastructure.repo.dao")
@EnableFeignClients(basePackages = "com.kafeimall.product.api.feign")
@EnableDiscoveryClient
public class KafeimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafeimallProductApplication.class, args);
    }

}
