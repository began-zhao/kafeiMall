package com.kafeimall.product.application;

import com.kafeimall.product.application.dto.SkuInfoDto;
import com.kafeimall.product.application.dto.SkuItemDto;

import java.util.concurrent.ExecutionException;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: SKU应用层
 */
public interface SkuApplicationService {
    /**
     * sku基本信息获取
     * */
    SkuInfoDto getById(Long Id);

    /**
     * sku详情获取
     * */
    SkuItemDto getItem(Long skuId) throws ExecutionException, InterruptedException;
}
