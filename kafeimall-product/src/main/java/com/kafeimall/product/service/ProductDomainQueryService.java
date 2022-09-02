package com.kafeimall.product.service;


import com.kafeimall.product.domain.aggregate.CategoryAggregate;
import com.kafeimall.product.domain.aggregate.SpuAggregate;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: zzg
 */
public interface ProductDomainQueryService {
    List<CategoryAggregate> getCategory();

    void updateCategoryById(CategoryAggregate categoryAggregate);

    SpuAggregate getSpuInfo(Long spuId) throws ExecutionException, InterruptedException;
}
