package com.kafeimall.product.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: zzg
 * @date: 9/1/22
 * @Description: spu规格参数信息
 */
@Data
@NoArgsConstructor
public class SpuItemAttrGroupDto {
    private String groupName;
    private List<AttrDto> attrs;
}
