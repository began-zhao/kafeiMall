package com.kaifeimall.search.api.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: zzg
 * @date: 2023/7/31
 * @Description: 获取检索服务资源
 */
@FeignClient("kafeimall-search")
public interface SearchFeignService {
}
