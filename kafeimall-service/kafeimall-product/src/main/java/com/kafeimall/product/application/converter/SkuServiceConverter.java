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
    default SkuItemDto toSkuItemDTO(SpuAggregate spuAggregate, SkuAggregate skuAggregate) {
        SkuItemDto skuItemDTO = new SkuItemDto();
        //
        SkuInfoDto skuInfoDTO = new SkuInfoDto();
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
        SpuInfoDescDto spuInfoDescDTO = new SpuInfoDescDto();
        spuInfoDescDTO.setSpuId(spuInfoDescDTO.getSpuId());
        spuInfoDescDTO.setDecript(spuInfoDescDTO.getDecript());
        skuItemDTO.setDesp(spuInfoDescDTO);
        //
        List<SkuImageDto> skuImageDtos = new ArrayList<>();
        skuAggregate.getSkuImages().stream().forEach(e -> {
            SkuImageDto skuImageDTO = new SkuImageDto();
            skuImageDTO.setId(e.getId());
            skuImageDTO.setSkuId(e.getSkuId());
            skuImageDTO.setImgUrl(e.getImgUrl());
            skuImageDTO.setImgSort(e.getImgSort());
            skuImageDTO.setDefaultImg(e.getDefaultImg());
            skuImageDtos.add(skuImageDTO);
        });
        skuItemDTO.setImages(skuImageDtos);
        //
        List<SkuItemSaleAttrDto> skuItemSaleAttrDtos = new ArrayList<>();
        spuAggregate.getSkuItemSaleAttrs().stream().forEach(e -> {
            SkuItemSaleAttrDto skuItemSaleAttrDTO = new SkuItemSaleAttrDto();
            skuItemSaleAttrDTO.setAttrId(e.getAttrId());
            skuItemSaleAttrDTO.setAttrName(e.getAttrName());
            List<AttrValueWithSkuIdDto> attrValueWithSkuIdDtos = e.getAttrValues().stream().map(f -> {
                AttrValueWithSkuIdDto attrValueWithSkuIdDTO = new AttrValueWithSkuIdDto();
                attrValueWithSkuIdDTO.setSkuIds(f.getSkuIds());
                attrValueWithSkuIdDTO.setAttrValue(f.getAttrValue());
                return attrValueWithSkuIdDTO;
            }).collect(Collectors.toList());
            skuItemSaleAttrDTO.setAttrValues(attrValueWithSkuIdDtos);
            skuItemSaleAttrDtos.add(skuItemSaleAttrDTO);
        });
        skuItemDTO.setSaleAttr(skuItemSaleAttrDtos);

        List<SpuItemAttrGroupDto> spuItemAttrGroupDtos = new ArrayList<>();
        spuAggregate.getSpuItemAttrGroups().stream().forEach(e -> {
            SpuItemAttrGroupDto spuItemAttrGroupDTO = new SpuItemAttrGroupDto();
            spuItemAttrGroupDTO.setGroupName(e.getGroupName());
            List<AttrDto> attrDtos = e.getAttrs().stream().map(f -> {
                AttrDto attrDTO = new AttrDto();
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
            spuItemAttrGroupDTO.setAttrs(attrDtos);
        });
        skuItemDTO.setGroupAttrs(spuItemAttrGroupDtos);
        return skuItemDTO;
    };
}
