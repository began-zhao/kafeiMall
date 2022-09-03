package com.kafeimall.product.infrastructure.repo.repository.converter;

import com.kafeimall.product.domain.aggregate.SpuAggregate;
import com.kafeimall.product.domain.valobj.SpuInfoDesc;
import com.kafeimall.product.infrastructure.repo.dao.po.SpuInfoDescPO;
import com.kafeimall.product.infrastructure.repo.dao.po.SpuInfoPO;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: zzg
 */
@Mapper(componentModel = "spring")
public interface SpuInfoRepositoryConverter {
    SpuInfoDesc toSpuDescInfoDO(SpuInfoDescPO spuInfoDescPO);

    SpuAggregate toSpuAggregateDO(SpuInfoPO spuInfoPO);

}
