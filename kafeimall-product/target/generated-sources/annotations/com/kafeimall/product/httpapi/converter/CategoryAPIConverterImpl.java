package com.kafeimall.product.httpapi.converter;

import com.kafeimall.product.application.dto.CategoryDTO;
import com.kafeimall.product.httpapi.module.req.CategoryUpdateSortReq;
import com.kafeimall.product.httpapi.module.vo.CategoryVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-07T23:14:38+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class CategoryAPIConverterImpl implements CategoryAPIConverter {

    @Override
    public CategoryVO toCategoryVO(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryVO categoryVO = new CategoryVO();

        return categoryVO;
    }

    @Override
    public CategoryDTO toCategoryDTO(CategoryUpdateSortReq categoryUpdateSortReq) {
        if ( categoryUpdateSortReq == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        return categoryDTO;
    }
}
