package com.kafeimall.product.httpapi.converter;

import com.kafeimall.product.application.dto.CatalogDTO;
import com.kafeimall.product.httpapi.module.vo.CatalogVO;
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
public class CatalogAPIConverterImpl implements CatalogAPIConverter {

    @Override
    public CatalogVO toCatalogVO(CatalogDTO catalogDTO) {
        if ( catalogDTO == null ) {
            return null;
        }

        CatalogVO catalogVO = new CatalogVO();

        catalogVO.setId( catalogDTO.getId() );
        catalogVO.setName( catalogDTO.getName() );
        catalogVO.setCatalog2List( catalog2DTOListToCatalog2VOList( catalogDTO.getCatalog2List() ) );

        return catalogVO;
    }

    protected CatalogVO.Catalog3VO catalog3DTOToCatalog3VO(CatalogDTO.Catalog3DTO catalog3DTO) {
        if ( catalog3DTO == null ) {
            return null;
        }

        CatalogVO.Catalog3VO catalog3VO = new CatalogVO.Catalog3VO();

        catalog3VO.setCatalog2Id( catalog3DTO.getCatalog2Id() );
        catalog3VO.setId( catalog3DTO.getId() );
        catalog3VO.setName( catalog3DTO.getName() );

        return catalog3VO;
    }

    protected List<CatalogVO.Catalog3VO> catalog3DTOListToCatalog3VOList(List<CatalogDTO.Catalog3DTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CatalogVO.Catalog3VO> list1 = new ArrayList<CatalogVO.Catalog3VO>( list.size() );
        for ( CatalogDTO.Catalog3DTO catalog3DTO : list ) {
            list1.add( catalog3DTOToCatalog3VO( catalog3DTO ) );
        }

        return list1;
    }

    protected CatalogVO.Catalog2VO catalog2DTOToCatalog2VO(CatalogDTO.Catalog2DTO catalog2DTO) {
        if ( catalog2DTO == null ) {
            return null;
        }

        CatalogVO.Catalog2VO catalog2VO = new CatalogVO.Catalog2VO();

        catalog2VO.setCatalog1Id( catalog2DTO.getCatalog1Id() );
        catalog2VO.setCatalog3List( catalog3DTOListToCatalog3VOList( catalog2DTO.getCatalog3List() ) );
        catalog2VO.setId( catalog2DTO.getId() );
        catalog2VO.setName( catalog2DTO.getName() );

        return catalog2VO;
    }

    protected List<CatalogVO.Catalog2VO> catalog2DTOListToCatalog2VOList(List<CatalogDTO.Catalog2DTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CatalogVO.Catalog2VO> list1 = new ArrayList<CatalogVO.Catalog2VO>( list.size() );
        for ( CatalogDTO.Catalog2DTO catalog2DTO : list ) {
            list1.add( catalog2DTOToCatalog2VO( catalog2DTO ) );
        }

        return list1;
    }
}
