package com.kafeimall.product.service.dto;

/**
 * @author: zzg
 * @date: 8/26/22
 * @Description: zzg
 */
public class UpdateCategorySortDTO {
    /**
     * 分类id
     */
    private Long catId;
    /**
     * 父分类id
     */
    private Long parentCid;
    /**
     * 层级
     */
    private Integer catLevel;
    /**
     * 排序
     */
    private Integer sort;
}
