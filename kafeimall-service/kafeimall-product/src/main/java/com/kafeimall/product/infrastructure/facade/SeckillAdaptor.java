package com.kafeimall.product.infrastructure.facade;

import com.kafeimall.common.result.Result;
import com.kafeimall.product.api.contract.response.SeckillInfo;
import com.kafeimall.product.api.feign.SeckillFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: 调用远程接口的秒杀防腐层
 */
@Component
public class SeckillAdaptor {

    //仅作为样例，后期秒杀服务的feign接口内容应该放在秒杀服务对应api下
    @Autowired
    private SeckillFeignService seckillService;

    public SeckillInfo getMtCityInfo(Long skuId) {
        Result<SeckillInfo> skuSeckillInfo = seckillService.getSkuSeckillInfo(skuId);
        return skuSeckillInfo.getData();
    }
}
