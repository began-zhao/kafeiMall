package com.kafeimall.product.httpapi.module.response;

import com.kafeimall.product.application.dto.CategoryDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: zzg
 * @date: 8/23/22
 * @Description: 商品VO
 */
@Data
@NoArgsConstructor
public class CategoryResponse {
    /**
     * 分类id
     */
    private Long catId;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父分类id
     */
    private Long parentCid;
    /**
     * 层级
     */
    private Integer catLevel;
    /**
     * 是否显示[0-不显示，1显示]
     */
    private Integer showStatus;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 图标地址
     */
    private String icon;
    /**
     * 计量单位
     */
    private String productUnit;
    /**
     * 商品数量
     */
    private Integer productCount;

    /**
     * 分类
     */
    private List<CategoryDTO> children;
}
