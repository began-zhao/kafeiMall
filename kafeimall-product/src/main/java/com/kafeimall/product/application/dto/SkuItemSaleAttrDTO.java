package com.kafeimall.product.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: spu销售属性组合
 */
@Data
@NoArgsConstructor
public class SkuItemSaleAttrDTO {
    private Long attrId;
    private String attrName;
    private List<AttrValueWithSkuIdDTO> attrValues;
}
