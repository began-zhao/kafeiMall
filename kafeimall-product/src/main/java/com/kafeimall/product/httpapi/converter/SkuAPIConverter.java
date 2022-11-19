package com.kafeimall.product.httpapi.converter;

import com.kafeimall.product.application.dto.SkuItemDTO;
import com.kafeimall.product.httpapi.module.response.SkuItemResponse;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 9/5/22
 * @Description: zzg
 */
@Mapper(componentModel = "spring")
public interface SkuAPIConverter {
    SkuItemResponse toSkuItemVO(SkuItemDTO skuItemDTO);
}
