package com.kafeimall.product.domain.aggregate;

import com.kafeimall.common.domain.AggregateRoot;
import com.kafeimall.product.domain.entity.AttrGroup;
import com.kafeimall.product.domain.entity.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: zzg
 * @date: 8/30/22
 */
@Data
@NoArgsConstructor
public class AttrAggregate extends AggregateRoot {
    /**
     * 属性id
     */
    private Long attrId;
    /**
     * 属性名
     */
    private String attrName;
    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    private Integer searchType;
    /**
     * 属性图标
     */
    private String icon;
    /**
     * 可选值列表[用逗号分隔]
     */
    private String valueSelect;
    /**
     * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
     */
    private Integer attrType;
    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
    private Long enable;
    /**
     * 所属分类
     */
    private Long catelogId;
    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    private Integer showDesc;

    /**
     * 所属分类
     * */
    private Category category;
    /**
     *所属 属性分组
    */
    private List<AttrGroup> attrGroupList;

}
