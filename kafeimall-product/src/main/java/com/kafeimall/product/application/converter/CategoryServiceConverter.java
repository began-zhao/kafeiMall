package com.kafeimall.product.application.converter;

import com.kafeimall.product.application.dto.CategoryDTO;
import com.kafeimall.product.domain.aggregate.CategoryAggregate;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: 分类DO-DTO转换器
 */
@Mapper(componentModel = "spring")
public interface CategoryServiceConverter {
    CategoryDTO toCategoryDTO(CategoryAggregate productCategory);

    CategoryAggregate toCategoryDO(CategoryDTO categoryDTO);

}
