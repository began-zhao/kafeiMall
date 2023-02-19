package com.kafeimall.product.infrastructure.repo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kafeimall.product.domain.entity.SpuItemAttrGroup;
import com.kafeimall.product.infrastructure.repo.dao.po.AttrGroupPO;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: zzg
 */
public interface AttrGroupDao extends BaseMapper<AttrGroupPO> {
    List<SpuItemAttrGroup> getAttrGroupWithAttrsBySpuId(Long spuId, Long cataLogId);
}
