package com.kafeimall.product.domain.entity;

import com.kafeimall.common.domain.ValueObject;
import com.kafeimall.product.domain.entity.Attr;
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
