package com.kafeimall.product.application.impl;

import com.kafeimall.product.application.SkuApplicationService;
import com.kafeimall.product.application.converter.SkuServiceConverter;
import com.kafeimall.product.application.dto.SkuInfoDto;
import com.kafeimall.product.application.dto.SkuItemDto;
import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.domain.aggregate.SpuAggregate;
import com.kafeimall.product.service.impl.ProductDomainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class SkuApplicationServiceImpl implements SkuApplicationService {


    @Autowired
    private ProductDomainServiceImpl productDomainQueryService;

    @Autowired
    private SkuServiceConverter skuServiceConverter;

    @Override
    public SkuInfoDto getById(Long Id) {
        return null;
    }


    /**
     * sku详情获取两个聚合根做转换
     */
    @Override
    public SkuItemDto getItem(Long skuId) throws ExecutionException, InterruptedException {
        SkuAggregate skuAggregate = productDomainQueryService.getSkuInfo(skuId);
        SpuAggregate spuAggregate = productDomainQueryService.getSpuInfo(skuAggregate.getSpuId());
        SkuItemDto skuItemDTO = skuServiceConverter.toSkuItemDTO(spuAggregate, skuAggregate);
        return skuItemDTO;
    }
}
