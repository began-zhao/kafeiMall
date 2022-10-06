package com.kafeimall.product.service;


import com.kafeimall.product.domain.aggregate.CategoryAggregate;
import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.domain.aggregate.SpuAggregate;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: 订单领域服务
 */
public interface ProductDomainService {
    List<CategoryAggregate> getCategory();

    void updateCategoryById(CategoryAggregate categoryAggregate);

    SpuAggregate getSpuInfo(Long spuId) throws ExecutionException, InterruptedException;

    SkuAggregate getSkuInfo(Long skuId) throws ExecutionException, InterruptedException;
}
