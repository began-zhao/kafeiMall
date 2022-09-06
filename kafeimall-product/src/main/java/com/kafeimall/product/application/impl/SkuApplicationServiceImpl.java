package com.kafeimall.product.application.impl;

import com.kafeimall.product.application.SkuApplicationService;
import com.kafeimall.product.application.converter.SkuServiceConverter;
import com.kafeimall.product.application.dto.SkuInfoDTO;
import com.kafeimall.product.application.dto.SkuItemDTO;
import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.domain.aggregate.SpuAggregate;
import com.kafeimall.product.infrastructure.repo.repository.SkuInfoRepository;
import com.kafeimall.product.service.impl.ProductDomainQueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutionException;

public class SkuApplicationServiceImpl implements SkuApplicationService {


    @Autowired
    private ProductDomainQueryServiceImpl productDomainQueryService;

    @Autowired
    private SkuInfoRepository skuInfoRepository;

    @Autowired
    private SkuServiceConverter skuServiceConverter;

    @Override
    public SkuInfoDTO getById(Long Id) {
        return null;
    }


    /**
     * sku详情获取两个聚合根做转换
     */
    @Override
    public SkuItemDTO getItem(Long skuId) throws ExecutionException, InterruptedException {
        SkuAggregate skuAggregate = productDomainQueryService.getSkuInfo(skuId);
        SpuAggregate spuAggregate = productDomainQueryService.getSpuInfo(skuAggregate.getSpuId());
        SkuItemDTO skuItemDTO = skuServiceConverter.toSkuItemDTO(spuAggregate, skuAggregate);
        return skuItemDTO;
    }
}