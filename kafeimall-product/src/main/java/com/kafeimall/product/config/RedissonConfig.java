package com.kafeimall.product.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author: zzg
 * @date: 8/29/22
 */
@Configuration
public class RedissonConfig {

    /**
     * 所有对redisson的使用都是通过RedissionClient对象
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod="shutdown")
    public RedissonClient redisson() throws IOException {
        //1、创建实例
        Config config = new Config();
        config.useSingleServer().setAddress("redis://120.25.165.167:6379");
        config.useSingleServer().setPassword("Zhaozhigang123..");
        //2、根据config创建出RedissonClient实例
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
