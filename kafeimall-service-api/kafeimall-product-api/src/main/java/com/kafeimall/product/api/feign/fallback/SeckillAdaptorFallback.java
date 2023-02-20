package com.kafeimall.product.api.feign.fallback;

import com.kafeimall.common.exception.BizCodeEnum;
import com.kafeimall.common.result.Result;
import com.kafeimall.product.api.feign.SeckillAdaptor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: 远程接口降级
 */
@Slf4j
public class SeckillAdaptorFallback implements SeckillAdaptor {
    @Override
    public Result getSkuSeckillInfo(Long skuId) {
        log.info("熔断方法调用...");
        return Result.error(BizCodeEnum.TOO_MANY_REQUEST.toString(), BizCodeEnum.TOO_MANY_REQUEST.getMessage());
    }
}
