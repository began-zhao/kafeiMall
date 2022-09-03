package com.kafeimall.product.application.impl;

import com.kafeimall.product.application.SkuApplicationService;
import com.kafeimall.product.application.dto.SkuInfoDTO;
import com.kafeimall.product.application.dto.SkuItemDTO;
import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.domain.valobj.SkuInfo;
import com.kafeimall.product.infrastructure.repo.repository.SkuInfoRepository;
import com.kafeimall.product.service.impl.ProductDomainQueryServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutionException;

public class SkuApplicationServiceImpl implements SkuApplicationService {



    @Autowired
    private ProductDomainQueryServiceImpl productDomainQueryService;

    @Autowired
    private SkuInfoRepository skuInfoRepository;

    @Override
    public SkuInfoDTO getById(Long Id) {
        return null;
    }

    @Override
    public SkuItemDTO getItem(Long skuId) throws ExecutionException, InterruptedException {
        SkuInfo skuInfo = skuInfoRepository.getById(skuId);
        SkuAggregate skuAggregate = productDomainQueryService.getSkuInfo(skuInfo.getSkuId());

        BeanUtils.copyProperties(skuInfo,skuAggregate);
        return null;
    }
}
