package com.kafeimall.product.service.converter;

import com.kafeimall.product.domain.aggregate.ProductCategory;
import com.kafeimall.product.service.dto.CategoryDTO;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: 分类DO-DTO转换器
 */
@Mapper(componentModel = "spring")
public interface CategoryServiceConverter {
    CategoryDTO toCategoryDTO(ProductCategory productCategory);
}
