package com.kafeimall.product.application.converter;

import com.kafeimall.product.application.dto.SkuItemDTO;
import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.domain.aggregate.SpuAggregate;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 2022/9/4
 * @Description: zzg
 */
@Mapper(componentModel = "spring")
public interface SkuServiceConverter {

    //TODO:添加默认转换处理
    SkuItemDTO toSkuItemDTO(SpuAggregate spuAggregate, SkuAggregate skuAggregate);
}
