package com.kafeimall.product.infrastructure.repo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kafeimall.product.domain.valobj.SkuItemSaleAttr;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuSaleAttrValuePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: zzg
 */
public interface SkuSaleAttrValueDao extends BaseMapper<SkuSaleAttrValuePO> {
    List<SkuItemSaleAttr> getSaleAttrsBySpuId(@Param("spuId") Long spuId);
}
