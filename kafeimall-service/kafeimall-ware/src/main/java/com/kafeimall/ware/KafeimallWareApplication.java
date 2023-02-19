package com.kafeimall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.kafeimall.ware.infrastructure.repo.dao")
@EnableFeignClients(basePackages = "com.kafeimall.ware.infrastructure.facade")
public class KafeimallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafeimallWareApplication.class, args);
    }

}