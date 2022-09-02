package com.kafeimall.product.infrastructure.repo.repository;

import com.kafeimall.common.repository.IRepository;
import com.kafeimall.product.domain.aggregate.SpuAggregate;
import com.kafeimall.product.domain.valobj.SkuItemSaleAttr;
import com.kafeimall.product.domain.valobj.SpuInfoDesc;
import com.kafeimall.product.domain.valobj.SpuItemAttrGroup;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: Spu资源库
 */
public interface SpuInfoRepository extends IRepository<SpuAggregate> {

    /**
     * 查出当前spu对应的spu销售属性组合
     */
    SpuAggregate getBySpuId(Long spuId);

    /**
     * 查出当前spu对应的spu销售属性组合
     */
    List<SkuItemSaleAttr> getSaleAttrsBySpuId(Long spuId);

    /**
     * 获取Spu介绍
     */
    SpuInfoDesc getSpuDescById(Long spuId);

    /**
     * 查出当前spu对应的所有属性的分组信息以及当前分组下所有属性对应的值
     */
    List<SpuItemAttrGroup>  getAttrGroupWithAttrsBySpuId(Long spuId, Long cataLogId);

}
