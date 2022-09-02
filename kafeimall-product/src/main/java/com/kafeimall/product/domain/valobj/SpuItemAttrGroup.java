package com.kafeimall.product.domain.valobj;

import com.kafeimall.common.domain.ValueObject;
import lombok.Data;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/2/22
 * @Description: spu规格参数信息
 */
@Data
public class SpuItemAttrGroup extends ValueObject {
    private String groupName;
    private List<Attr> attrs;
}
