package com.kafeimall.product.infrastructure.repo.repository;

import com.kafeimall.common.repository.IRepository;
import com.kafeimall.product.domain.aggregate.SpuAggregate;
import com.kafeimall.product.domain.valobj.SkuItemSaleAttr;
import com.kafeimall.product.domain.valobj.SpuInfoDesc;
import com.kafeimall.product.domain.valobj.SpuItemAttrGroup;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: Spu资源库
 */
public interface SpuInfoRepository extends IRepository<SpuAggregate> {

    /**
     *
     */
    SpuAggregate getBySpuId(Long spuId) throws ExecutionException, InterruptedException;

}
