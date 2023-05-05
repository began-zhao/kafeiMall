package com.kafeimall.product.domain.service;


import com.kafeimall.product.domain.model.BrandDO;

import java.util.List;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: 商品领域服务
 */
public interface ProductDomainService {
    List<BrandDO> getBrand();

}
