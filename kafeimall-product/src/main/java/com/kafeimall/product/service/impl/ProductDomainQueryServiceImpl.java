package com.kafeimall.product.service.impl;

import com.kafeimall.product.domain.aggregate.CategoryAggregate;
import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.domain.aggregate.SpuAggregate;
import com.kafeimall.product.infrastructure.repo.repository.CategoryRepository;
import com.kafeimall.product.infrastructure.repo.repository.SkuInfoRepository;
import com.kafeimall.product.infrastructure.repo.repository.SpuInfoRepository;
import com.kafeimall.product.service.ProductDomainQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: zzg
 */
@Service
public class ProductDomainQueryServiceImpl implements ProductDomainQueryService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CategoryRepository categoryRepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SpuInfoRepository spuInfoRepository;
    @Autowired
    private SkuInfoRepository skuInfoRepository;

    @Override
    public List<CategoryAggregate> getCategory() {
        List<CategoryAggregate> productCategory = categoryRepository.getProductCategory();
        return productCategory;
    }

    @Override
    public void updateCategoryById(CategoryAggregate categoryAggregate) {
        categoryRepository.updateCategoryById(categoryAggregate);
    }

    @Override
    public SpuAggregate getSpuInfo(Long spuId) throws ExecutionException, InterruptedException {
        SpuAggregate spuAggregate = spuInfoRepository.getBySpuId(spuId);
        return spuAggregate;
    }

    @Override
    public SkuAggregate getSkuInfo(Long skuId) throws ExecutionException, InterruptedException {
        SkuAggregate skuAggregate = skuInfoRepository.getById(skuId);
        return skuAggregate;
    }

}