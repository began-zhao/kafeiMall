package com.kafeimall.product.infrastructure.repo.repository;

import com.kafeimall.common.repository.IRepository;
import com.kafeimall.product.domain.aggregate.SkuAggregate;

/**
 * @author: zzg
 * @date: 8/31/22
 * @Description: zzg
 */
public interface SkuInfoRepository extends IRepository<SkuAggregate> {
    SkuAggregate getById(Long Id);
}
