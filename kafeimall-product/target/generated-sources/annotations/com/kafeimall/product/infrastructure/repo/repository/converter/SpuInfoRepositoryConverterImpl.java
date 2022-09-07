package com.kafeimall.product.infrastructure.repo.repository.converter;

import com.kafeimall.product.domain.valobj.SpuInfoDesc;
import com.kafeimall.product.infrastructure.repo.dao.po.SpuInfoDescPO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-07T23:14:38+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class SpuInfoRepositoryConverterImpl implements SpuInfoRepositoryConverter {

    @Override
    public SpuInfoDesc toSpuDescInfoDO(SpuInfoDescPO spuInfoDescPO) {
        if ( spuInfoDescPO == null ) {
            return null;
        }

        SpuInfoDesc spuInfoDesc = new SpuInfoDesc();

        spuInfoDesc.setSpuId( spuInfoDescPO.getSpuId() );
        spuInfoDesc.setDecript( spuInfoDescPO.getDecript() );

        return spuInfoDesc;
    }
}
