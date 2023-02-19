package com.kafeimall.product.domain.valobj;

import com.kafeimall.common.domain.ValueObject;
import lombok.Data;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: zzg
 */
@Data
public class AttrValueWithSkuId extends ValueObject {
    private String attrValue;
    private String skuIds;
}
