package com.kafeimall.product.application;

import com.kafeimall.product.application.dto.SkuInfoDTO;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: SKU应用层
 */
public interface SkuApplicationService {
    /**
     * sku基本信息获取
     * */
    SkuInfoDTO getById(Long Id);
}
