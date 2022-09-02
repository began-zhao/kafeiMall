package com.kafeimall.product.service.impl;

import com.kafeimall.product.application.converter.CategoryServiceConverter;
import com.kafeimall.product.domain.aggregate.CategoryAggregate;
import com.kafeimall.product.domain.aggregate.SpuAggregate;
import com.kafeimall.product.domain.valobj.SkuItemSaleAttr;
import com.kafeimall.product.domain.valobj.SpuInfoDesc;
import com.kafeimall.product.domain.valobj.SpuItemAttrGroup;
import com.kafeimall.product.infrastructure.repo.repository.CategoryRepository;
import com.kafeimall.product.infrastructure.repo.repository.SpuInfoRepository;
import com.kafeimall.product.service.ProductDomainQueryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

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
    private CategoryServiceConverter categoryConverter;
    @Autowired
    ThreadPoolExecutor executor;

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
        SpuAggregate spuAggregate = new SpuAggregate();
        //获取spu信息
        CompletableFuture<SpuAggregate> spuInfoFuture = CompletableFuture.supplyAsync(() -> {
            SpuAggregate bySpuId = spuInfoRepository.getBySpuId(spuId);
            BeanUtils.copyProperties(bySpuId, spuAggregate);
            return bySpuId;
        }, executor);

        //获取spu对应销售属性
        CompletableFuture<Void> saleAttrFuture = CompletableFuture.runAsync(() -> {
            List<SkuItemSaleAttr> saleAttrsBySpuId = spuInfoRepository.getSaleAttrsBySpuId(spuId);
            spuAggregate.setSkuItemSaleAttrs(saleAttrsBySpuId);
        }, executor);
        //获取spu介绍
        CompletableFuture<Void> spuInfoDesc = CompletableFuture.runAsync(() -> {
            SpuInfoDesc spuDescById = spuInfoRepository.getSpuDescById(spuId);
            spuAggregate.setSpuInfoDesc(spuDescById);
        }, executor);
        //获取spu规格参数信息
        CompletableFuture<Void> baseAttrFuture = spuInfoFuture.thenAcceptAsync((res) -> {
            List<SpuItemAttrGroup> attrGroupWithAttrsBySpuId = spuInfoRepository.getAttrGroupWithAttrsBySpuId(spuId, res.getCatalogId());
            spuAggregate.setSpuItemAttrGroups(attrGroupWithAttrsBySpuId);
        }, executor);
        //等待所有任务都完成
        CompletableFuture.allOf(saleAttrFuture, spuInfoDesc, baseAttrFuture, spuInfoFuture).get();
        return spuAggregate;
    }

}