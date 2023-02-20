package com.kafeimall.product.api.feign;

import com.kafeimall.common.result.Result;
import com.kafeimall.product.api.contract.response.SeckillInfo;
import com.kafeimall.product.api.feign.fallback.SeckillAdaptorFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: 远程调用秒杀服务获取秒杀信息
 */
@FeignClient(value = "kafeimall-seckill", fallback = SeckillAdaptorFallback.class)
public interface SeckillAdaptor {
    @GetMapping("/sku/seckill/{skuId}")
    Result<SeckillInfo> getSkuSeckillInfo(@PathVariable("skuId") Long skuId);
}
