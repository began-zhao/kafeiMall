package com.kafeimall.product.infrastructure.facade;

import com.kafeimall.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: zzg
 */
@FeignClient(value = "kafeimall-seckill")
public interface SeckillAdaptor {
    @GetMapping("/sku/seckill/{skuId}")
    Result getSkuSeckillInfo(@PathVariable("skuId") Long skuId);
}
