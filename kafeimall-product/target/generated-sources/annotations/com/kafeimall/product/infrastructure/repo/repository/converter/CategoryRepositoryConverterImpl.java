package com.kafeimall.product.infrastructure.repo.repository.converter;

import com.kafeimall.product.domain.aggregate.CategoryAggregate;
import com.kafeimall.product.infrastructure.repo.dao.po.CategoryPO;
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
public class CategoryRepositoryConverterImpl implements CategoryRepositoryConverter {

    @Override
    public CategoryAggregate toProductCategoryDO(CategoryPO categoryPO) {
        if ( categoryPO == null ) {
            return null;
        }

        CategoryAggregate categoryAggregate = new CategoryAggregate();

        categoryAggregate.setCatId( categoryPO.getCatId() );
        categoryAggregate.setName( categoryPO.getName() );
        categoryAggregate.setParentCid( categoryPO.getParentCid() );
        categoryAggregate.setCatLevel( categoryPO.getCatLevel() );
        categoryAggregate.setShowStatus( categoryPO.getShowStatus() );
        categoryAggregate.setSort( categoryPO.getSort() );
        categoryAggregate.setIcon( categoryPO.getIcon() );
        categoryAggregate.setProductUnit( categoryPO.getProductUnit() );
        categoryAggregate.setProductCount( categoryPO.getProductCount() );
        categoryAggregate.setChildren( categoryPOListToCategoryAggregateList( categoryPO.getChildren() ) );

        return categoryAggregate;
    }

    @Override
    public CategoryPO toProductCategoryPO(CategoryAggregate categoryDO) {
        if ( categoryDO == null ) {
            return null;
        }

        CategoryPO categoryPO = new CategoryPO();

        categoryPO.setCatId( categoryDO.getCatId() );
        categoryPO.setName( categoryDO.getName() );
        categoryPO.setParentCid( categoryDO.getParentCid() );
        categoryPO.setCatLevel( categoryDO.getCatLevel() );
        categoryPO.setShowStatus( categoryDO.getShowStatus() );
        categoryPO.setSort( categoryDO.getSort() );
        categoryPO.setIcon( categoryDO.getIcon() );
        categoryPO.setProductUnit( categoryDO.getProductUnit() );
        categoryPO.setProductCount( categoryDO.getProductCount() );
        categoryPO.setChildren( categoryAggregateListToCategoryPOList( categoryDO.getChildren() ) );

        return categoryPO;
    }

    protected List<CategoryAggregate> categoryPOListToCategoryAggregateList(List<CategoryPO> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryAggregate> list1 = new ArrayList<CategoryAggregate>( list.size() );
        for ( CategoryPO categoryPO : list ) {
            list1.add( toProductCategoryDO( categoryPO ) );
        }

        return list1;
    }

    protected List<CategoryPO> categoryAggregateListToCategoryPOList(List<CategoryAggregate> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryPO> list1 = new ArrayList<CategoryPO>( list.size() );
        for ( CategoryAggregate categoryAggregate : list ) {
            list1.add( toProductCategoryPO( categoryAggregate ) );
        }

        return list1;
    }
}
