package com.kafeimall.product.application.converter;

import com.kafeimall.product.application.dto.CategoryDTO;
import com.kafeimall.product.domain.aggregate.CategoryAggregate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-07T23:14:38+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class CategoryServiceConverterImpl implements CategoryServiceConverter {

    @Override
    public CategoryDTO toCategoryDTO(CategoryAggregate productCategory) {
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
        categoryDTO.setChildren( categoryAggregateListToCategoryDTOList( productCategory.getChildren() ) );

        return categoryDTO;
    }

    @Override
    public CategoryAggregate toCategoryDO(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryAggregate categoryAggregate = new CategoryAggregate();

        categoryAggregate.setCatId( categoryDTO.getCatId() );
        categoryAggregate.setName( categoryDTO.getName() );
        categoryAggregate.setParentCid( categoryDTO.getParentCid() );
        categoryAggregate.setCatLevel( categoryDTO.getCatLevel() );
        categoryAggregate.setShowStatus( categoryDTO.getShowStatus() );
        categoryAggregate.setSort( categoryDTO.getSort() );
        categoryAggregate.setIcon( categoryDTO.getIcon() );
        categoryAggregate.setProductUnit( categoryDTO.getProductUnit() );
        categoryAggregate.setProductCount( categoryDTO.getProductCount() );
        categoryAggregate.setChildren( categoryDTOListToCategoryAggregateList( categoryDTO.getChildren() ) );

        return categoryAggregate;
    }

    protected List<CategoryDTO> categoryAggregateListToCategoryDTOList(List<CategoryAggregate> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryDTO> list1 = new ArrayList<CategoryDTO>( list.size() );
        for ( CategoryAggregate categoryAggregate : list ) {
            list1.add( toCategoryDTO( categoryAggregate ) );
        }

        return list1;
    }

    protected List<CategoryAggregate> categoryDTOListToCategoryAggregateList(List<CategoryDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryAggregate> list1 = new ArrayList<CategoryAggregate>( list.size() );
        for ( CategoryDTO categoryDTO : list ) {
            list1.add( toCategoryDO( categoryDTO ) );
        }

        return list1;
    }
}
