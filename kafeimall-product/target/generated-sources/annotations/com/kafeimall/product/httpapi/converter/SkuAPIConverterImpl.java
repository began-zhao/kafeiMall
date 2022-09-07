package com.kafeimall.product.httpapi.converter;

import com.kafeimall.product.application.dto.SkuImageDTO;
import com.kafeimall.product.application.dto.SkuItemDTO;
import com.kafeimall.product.application.dto.SkuItemSaleAttrDTO;
import com.kafeimall.product.application.dto.SpuItemAttrGroupDTO;
import com.kafeimall.product.httpapi.module.vo.SkuItemVO;
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
public class SkuAPIConverterImpl implements SkuAPIConverter {

    @Override
    public SkuItemVO toSkuItemVO(SkuItemDTO skuItemDTO) {
        if ( skuItemDTO == null ) {
            return null;
        }

        SkuItemVO skuItemVO = new SkuItemVO();

        skuItemVO.setSkuInfo( skuItemDTO.getSkuInfo() );
        skuItemVO.setHasStock( skuItemDTO.isHasStock() );
        List<SkuImageDTO> list = skuItemDTO.getImages();
        if ( list != null ) {
            skuItemVO.setImages( new ArrayList<SkuImageDTO>( list ) );
        }
        List<SkuItemSaleAttrDTO> list1 = skuItemDTO.getSaleAttr();
        if ( list1 != null ) {
            skuItemVO.setSaleAttr( new ArrayList<SkuItemSaleAttrDTO>( list1 ) );
        }
        skuItemVO.setDesp( skuItemDTO.getDesp() );
        List<SpuItemAttrGroupDTO> list2 = skuItemDTO.getGroupAttrs();
        if ( list2 != null ) {
            skuItemVO.setGroupAttrs( new ArrayList<SpuItemAttrGroupDTO>( list2 ) );
        }
        skuItemVO.setSeckillInfo( skuItemDTO.getSeckillInfo() );

        return skuItemVO;
    }
}
