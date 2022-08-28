package com.kafeimall.product.infrastructure.repo.repository.converter;

import com.kafeimall.product.domain.aggregate.ProductCategory;
import com.kafeimall.product.infrastructure.repo.dao.po.CategoryPO;
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
public class CategoryRepositoryConverterImpl implements CategoryRepositoryConverter {

    @Override
    public ProductCategory toProductCategoryDO(CategoryPO categoryPO) {
        if ( categoryPO == null ) {
            return null;
        }

        ProductCategory productCategory = new ProductCategory();

        productCategory.setCatId( categoryPO.getCatId() );
        productCategory.setName( categoryPO.getName() );
        productCategory.setParentCid( categoryPO.getParentCid() );
        productCategory.setCatLevel( categoryPO.getCatLevel() );
        productCategory.setShowStatus( categoryPO.getShowStatus() );
        productCategory.setSort( categoryPO.getSort() );
        productCategory.setIcon( categoryPO.getIcon() );
        productCategory.setProductUnit( categoryPO.getProductUnit() );
        productCategory.setProductCount( categoryPO.getProductCount() );
        productCategory.setChildren( categoryPOListToProductCategoryList( categoryPO.getChildren() ) );

        return productCategory;
    }

    protected List<ProductCategory> categoryPOListToProductCategoryList(List<CategoryPO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductCategory> list1 = new ArrayList<ProductCategory>( list.size() );
        for ( CategoryPO categoryPO : list ) {
            list1.add( toProductCategoryDO( categoryPO ) );
        }

        return list1;
    }
}
