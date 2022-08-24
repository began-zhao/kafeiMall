package com.kafeimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.kafeimall.product.repo.dao")
public class KafeimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafeimallProductApplication.class, args);
    }

}
