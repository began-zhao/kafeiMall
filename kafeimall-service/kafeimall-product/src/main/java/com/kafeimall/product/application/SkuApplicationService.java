package com.kafeimall.product.application;

import com.kafeimall.product.domain.model.BrandDO;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: SKU应用层
 */
public interface SkuApplicationService {
    /**
     * 品牌基本信息
     * */
    List<BrandDO> getBrands();

}
