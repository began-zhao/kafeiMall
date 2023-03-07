package com.kafeimall.product.application.impl;

import com.kafeimall.product.application.SkuApplicationService;
import com.kafeimall.product.domain.service.ProductDomainService;
import com.kafeimall.product.domain.model.BrandDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuApplicationServiceImpl implements SkuApplicationService {


    @Autowired
    private ProductDomainService productDomainService;

    @Override
    public List<BrandDO> getBrands()
    {
        return productDomainService.getBrand();
    }

}
