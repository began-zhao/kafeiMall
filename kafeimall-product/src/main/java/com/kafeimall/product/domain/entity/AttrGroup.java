package com.kafeimall.product.domain.entity;

import com.kafeimall.common.domain.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: 属性分组实体
 */
@Data
@NoArgsConstructor
public class AttrGroup extends Entity {
    /**
     * 分组id
     */
    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    private Long catelogId;

    private Long[] catelogPath;
}
