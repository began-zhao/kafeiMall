package com.kafeimall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.kafeimall.member.infrastructure.repo.dao")
@EnableFeignClients(basePackages = "com.kafeimall.member.infrastructure.facade")
public class KafeimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafeimallMemberApplication.class, args);
    }

}