package com.kafeimall.product.application.converter;

import com.kafeimall.product.application.dto.CategoryDTO;
import com.kafeimall.product.domain.aggregate.ProductCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-28T16:00:18+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class CategoryServiceConverterImpl implements CategoryServiceConverter {

    @Override
    public CategoryDTO toCategoryDTO(ProductCategory productCategory) {
        if ( productCategory == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCatId( productCategory.getCatId() );
        categoryDTO.setName( productCategory.getName() );
        categoryDTO.setParentCid( productCategory.getParentCid() );
        categoryDTO.setCatLevel( productCategory.getCatLevel() );
        categoryDTO.setShowStatus( productCategory.getShowStatus() );
        categoryDTO.setSort( productCategory.getSort() );
        categoryDTO.setIcon( productCategory.getIcon() );
        categoryDTO.setProductUnit( productCategory.getProductUnit() );
        categoryDTO.setProductCount( productCategory.getProductCount() );
        categoryDTO.setChildren( productCategoryListToCategoryDTOList( productCategory.getChildren() ) );

        return categoryDTO;
    }

    protected List<CategoryDTO> productCategoryListToCategoryDTOList(List<ProductCategory> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryDTO> list1 = new ArrayList<CategoryDTO>( list.size() );
        for ( ProductCategory productCategory : list ) {
            list1.add( toCategoryDTO( productCategory ) );
        }

        return list1;
    }
}
