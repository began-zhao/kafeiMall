package com.kafeimall.product.httpapi.converter;

import com.kafeimall.product.application.dto.SkuItemDTO;
import com.kafeimall.product.httpapi.module.vo.SkuItemVO;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 9/5/22
 * @Description: zzg
 */
@Mapper(componentModel = "spring")
public interface SkuAPIConverter {
    SkuItemVO toSkuItemVO(SkuItemDTO skuItemDTO);
}
