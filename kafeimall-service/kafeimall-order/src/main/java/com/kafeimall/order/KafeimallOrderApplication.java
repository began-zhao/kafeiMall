package com.kafeimall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.kafeimall.order.infrastructure.facade")
@SpringBootApplication
public class KafeimallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafeimallOrderApplication.class, args);
    }

}