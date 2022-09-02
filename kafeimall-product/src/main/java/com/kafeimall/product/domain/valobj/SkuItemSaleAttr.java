package com.kafeimall.product.domain.valobj;

import com.kafeimall.common.domain.ValueObject;
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
