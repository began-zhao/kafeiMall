package com.kafeimall.product.httpapi.converter;

import com.kafeimall.product.application.dto.CategoryDTO;
import com.kafeimall.product.httpapi.module.req.CategoryUpdateSortReq;
import com.kafeimall.product.httpapi.module.vo.CategoryVO;
import org.mapstruct.Mapper;

/**
 * @author: zzg
 * @date: 8/24/22
 * @Description: CategoryVO-DTO转换器
 */
@Mapper(componentModel = "spring")
public interface CategoryAPIConverter {
    CategoryVO toCategoryVO(CategoryDTO categoryDTO);

    CategoryDTO toCategoryDTO(CategoryUpdateSortReq categoryUpdateSortReq);
}
