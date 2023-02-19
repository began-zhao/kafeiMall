package com.kafeimall.product.domain.entity;

import com.kafeimall.common.domain.ValueObject;
import com.kafeimall.product.domain.valobj.AttrValueWithSkuId;
import lombok.Data;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: spu销售属性组合
 */
@Data
public class SkuItemSaleAttr extends ValueObject {
    private Long attrId;
    private String attrName;
    private List<AttrValueWithSkuId> attrValues;
}
