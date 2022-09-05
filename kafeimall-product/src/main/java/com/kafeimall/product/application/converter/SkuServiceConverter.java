package com.kafeimall.product.application.converter;

import com.kafeimall.product.application.dto.*;
import com.kafeimall.product.domain.aggregate.SkuAggregate;
import com.kafeimall.product.domain.aggregate.SpuAggregate;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zzg
 * @date: 2022/9/4
 * @Description: zzg
 */
@Mapper(componentModel = "spring")
public interface SkuServiceConverter {

    //TODO:添加默认转换处理
    default SkuItemDTO toSkuItemDTO(SpuAggregate spuAggregate, SkuAggregate skuAggregate) {
        SkuItemDTO skuItemDTO = new SkuItemDTO();
        //
        SkuInfoDTO skuInfoDTO = new SkuInfoDTO();
        skuInfoDTO.setSkuId(skuAggregate.getSkuId());
        skuInfoDTO.setSpuId(skuAggregate.getSpuId());
        skuInfoDTO.setSkuName(skuAggregate.getSkuName());
        skuInfoDTO.setSkuDesc(skuAggregate.getSkuDesc());
        skuInfoDTO.setCatalogId(skuAggregate.getCatalogId());
        skuInfoDTO.setBrandId(skuInfoDTO.getBrandId());
        skuInfoDTO.setSkuDefaultImg(skuAggregate.getSkuDefaultImg());
        skuInfoDTO.setSkuTitle(skuAggregate.getSkuTitle());
        skuInfoDTO.setSkuSubtitle(skuAggregate.getSkuSubtitle());
        skuInfoDTO.setPrice(skuAggregate.getPrice());
        skuInfoDTO.setSaleCount(skuAggregate.getSaleCount());
        skuItemDTO.setSkuInfo(skuInfoDTO);
        //
        SpuInfoDescDTO spuInfoDescDTO = new SpuInfoDescDTO();
        spuInfoDescDTO.setSpuId(spuInfoDescDTO.getSpuId());
        spuInfoDescDTO.setDecript(spuInfoDescDTO.getDecript());
        skuItemDTO.setDesp(spuInfoDescDTO);
        //
        List<SkuImageDTO> skuImageDTOS = new ArrayList<>();
        skuAggregate.getSkuImages().stream().forEach(e -> {
            SkuImageDTO skuImageDTO = new SkuImageDTO();
            skuImageDTO.setId(e.getId());
            skuImageDTO.setSkuId(e.getSkuId());
            skuImageDTO.setImgUrl(e.getImgUrl());
            skuImageDTO.setImgSort(e.getImgSort());
            skuImageDTO.setDefaultImg(e.getDefaultImg());
            skuImageDTOS.add(skuImageDTO);
        });
        skuItemDTO.setImages(skuImageDTOS);
        //
        List<SkuItemSaleAttrDTO> skuItemSaleAttrDTOS = new ArrayList<>();
        spuAggregate.getSkuItemSaleAttrs().stream().forEach(e -> {
            SkuItemSaleAttrDTO skuItemSaleAttrDTO = new SkuItemSaleAttrDTO();
            skuItemSaleAttrDTO.setAttrId(e.getAttrId());
            skuItemSaleAttrDTO.setAttrName(e.getAttrName());
            List<AttrValueWithSkuIdDTO> attrValueWithSkuIdDTOS = e.getAttrValues().stream().map(f -> {
                AttrValueWithSkuIdDTO attrValueWithSkuIdDTO = new AttrValueWithSkuIdDTO();
                attrValueWithSkuIdDTO.setSkuIds(f.getSkuIds());
                attrValueWithSkuIdDTO.setAttrValue(f.getAttrValue());
                return attrValueWithSkuIdDTO;
            }).collect(Collectors.toList());
            skuItemSaleAttrDTO.setAttrValues(attrValueWithSkuIdDTOS);
            skuItemSaleAttrDTOS.add(skuItemSaleAttrDTO);
        });
        skuItemDTO.setSaleAttr(skuItemSaleAttrDTOS);

        List<SpuItemAttrGroupDTO> spuItemAttrGroupDTOS = new ArrayList<>();
        spuAggregate.getSpuItemAttrGroups().stream().forEach(e -> {
            SpuItemAttrGroupDTO spuItemAttrGroupDTO = new SpuItemAttrGroupDTO();
            spuItemAttrGroupDTO.setGroupName(e.getGroupName());
            List<AttrDTO> attrDTOS = e.getAttrs().stream().map(f -> {
                AttrDTO attrDTO = new AttrDTO();
                attrDTO.setAttrId(f.getAttrId());
                attrDTO.setAttrName(f.getAttrName());
                attrDTO.setSearchType(f.getSearchType());
                attrDTO.setIcon(f.getIcon());
                attrDTO.setValueSelect(f.getValueSelect());
                attrDTO.setAttrType(f.getAttrType());
                attrDTO.setEnable(f.getEnable());
                attrDTO.setCatelogId(f.getCatelogId());
                return attrDTO;
            }).collect(Collectors.toList());
            spuItemAttrGroupDTO.setAttrs(attrDTOS);
        });
        skuItemDTO.setGroupAttrs(spuItemAttrGroupDTOS);
        return skuItemDTO;
    };
}
