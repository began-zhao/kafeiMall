package com.kafeimall.product.config;

import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author: zzg
 * @date: 8/29/22
 */
@EnableConfigurationProperties(CacheProperties.class)
@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    RedisCacheConfiguration redisCacheConfiguration(CacheProperties cacheProperties) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        config = config.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
        config = config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));

        CacheProperties.Redis propertiesRedis = cacheProperties.getRedis();
        //将配置文件中的所有配置都生效
        if (propertiesRedis.getTimeToLive() != null) {
            config = config.entryTtl(propertiesRedis.getTimeToLive());
        }
        if (propertiesRedis.getKeyPrefix() != null) {
            config = config.prefixKeysWith(propertiesRedis.getKeyPrefix());
        }
        if (!propertiesRedis.isCacheNullValues()) {
            config = config.disableCachingNullValues();
        }
        if (!propertiesRedis.isUseKeyPrefix()) {
            config = config.disableKeyPrefix();
        }
        return config;
    }
}
