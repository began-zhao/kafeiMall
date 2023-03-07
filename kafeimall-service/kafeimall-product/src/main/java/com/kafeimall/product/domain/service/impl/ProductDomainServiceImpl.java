package com.kafeimall.product.domain.service.impl;

import com.kafeimall.product.domain.repository.BrandRepository;
import com.kafeimall.product.domain.service.ProductDomainService;
import com.kafeimall.product.domain.model.BrandDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: 订单领域服务实现
 */
@Service
public class ProductDomainServiceImpl implements ProductDomainService {

    @Resource
    private BrandRepository brandRepository;

    @Override
    public List<BrandDO> getBrand() {
        return brandRepository.findAll();
    }
}