package com.kafeimall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.kafeimall.order.infrastructure.repo.dao")
@EnableFeignClients(basePackages = "com.kafeimall.order.infrastructure.facade")
public class KafeimallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafeimallOrderApplication.class, args);
    }

}