package com.kafeimall.product.httpapi.converter;

import com.kafeimall.product.application.dto.CatalogDTO;
import com.kafeimall.product.httpapi.module.response.CatalogResponse;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 8/31/22
 * @Description: zzg
 */
@Mapper(componentModel = "spring")
public interface CatalogAPIConverter {
    CatalogResponse toCatalogVO(CatalogDTO catalogDTO);
}
