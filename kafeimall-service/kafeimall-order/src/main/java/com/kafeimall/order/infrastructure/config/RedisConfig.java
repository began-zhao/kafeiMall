package com.kafeimall.order.infrastructure.config;

import com.kafeimall.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zzg
 * @date: 11/4/22
 * @Description: Redis相关配置
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}

