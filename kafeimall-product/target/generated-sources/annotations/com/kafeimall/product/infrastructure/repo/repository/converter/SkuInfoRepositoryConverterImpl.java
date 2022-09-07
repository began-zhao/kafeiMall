package com.kafeimall.product.infrastructure.repo.repository.converter;

import com.kafeimall.product.domain.valobj.skuAggregate;
import com.kafeimall.product.infrastructure.repo.dao.po.SkuInfoPO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-07T23:14:38+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class SkuInfoRepositoryConverterImpl implements SkuInfoRepositoryConverter {

    @Override
    public skuAggregate toSkuInfoDO(SkuInfoPO categoryPO) {
        if ( categoryPO == null ) {
            return null;
        }

        skuAggregate skuAggregate = new skuAggregate();

        skuAggregate.setSkuId( categoryPO.getSkuId() );
        skuAggregate.setSpuId( categoryPO.getSpuId() );
        skuAggregate.setSkuName( categoryPO.getSkuName() );
        skuAggregate.setSkuDesc( categoryPO.getSkuDesc() );
        skuAggregate.setCatalogId( categoryPO.getCatalogId() );
        skuAggregate.setBrandId( categoryPO.getBrandId() );
        skuAggregate.setSkuDefaultImg( categoryPO.getSkuDefaultImg() );
        skuAggregate.setSkuTitle( categoryPO.getSkuTitle() );
        skuAggregate.setSkuSubtitle( categoryPO.getSkuSubtitle() );
        skuAggregate.setPrice( categoryPO.getPrice() );
        skuAggregate.setSaleCount( categoryPO.getSaleCount() );

        return skuAggregate;
    }
}
